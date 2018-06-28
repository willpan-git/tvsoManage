/**
 * 
 */
package com.skyworth.config;

import org.activiti.spring.SpringProcessEngineConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;

/**   
* Copyright: Copyright (c) 2018 skyworth
* 
* @ClassName: ActivitiConfig.java
* @Description: 工作流定义类
*
* @version: v1.0.0
* @author: Administrator
* @date: 2018年6月26日 下午3:24:01 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年6月26日     Administrator           v1.0.0               修改原因
*/
@Configuration
public class ActivitiConfig {
    @Autowired
    PlatformTransactionManager transactionManager;

    @Autowired
    DruidDataSource druidDataSource;

    @Bean
    public SpringProcessEngineConfiguration getProcessEngineConfiguration(){
        SpringProcessEngineConfiguration config =  
                               new SpringProcessEngineConfiguration();
        config.setDataSource(druidDataSource);
        config.setTransactionManager(transactionManager);
        config.setDatabaseType("mysql");
        config.setDatabaseSchemaUpdate("true");
        return config;
    }
}

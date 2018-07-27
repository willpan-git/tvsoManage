/**
 * 
 */
package com.skyworth.config;

import javax.servlet.MultipartConfigElement;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**   
* Copyright: Copyright (c) 2018 skyworth
* 
* @ClassName: UploadConfig.java
* @Description: 设置默认上传路劲
*
* @version: v1.0.0
* @author: Administrator
* @date: 2018年7月25日 下午3:24:29 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年7月25日     Administrator           v1.0.0               修改原因
*/
@Configuration
public class UploadConfig {
    @Value("${project.path}")
    private String projectpath;
    
    @Bean
    MultipartConfigElement multipartConfigElement() {
       MultipartConfigFactory factory = new MultipartConfigFactory();
       factory.setLocation(projectpath);
       return factory.createMultipartConfig();
   }

}

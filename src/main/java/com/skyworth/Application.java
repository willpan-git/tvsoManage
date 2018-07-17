package com.skyworth;

import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Copyright: Copyright (c) 2018 skyworth
 * 
 * @ClassName: StartController.java
 * @Description: 软件启动接口
 *
 * @version: v1.0.0
 * @author: Administrator
 * @date: 2018��5��7�� ����11:31:05
 *
 *        Modification History: Date Author Version Description
 *        ---------------------------------------------------------*
 *        2018��5��7�� Administrator v1.0.0 �޸�ԭ��
 */
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
// @EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
@EnableTransactionManagement // 如果mybatis中service实现类中加入事务注解，需要此处添加开启事务注解
@ComponentScan
@MapperScan(basePackages = "com.skyworth.mapper")
public class Application {
    public static void main(String[] args) {
	SpringApplication.run(Application.class, args);
    }
}

/**
 * 
 */
package com.skyworth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Copyright: Copyright (c) 2018 skyworth
 * 
 * @ClassName: SwaggerConfig.java
 * @Description: Swagger2配置文件
 *
 * @version: v1.0.0
 * @author: Administrator
 * @date: 2018年5月18日 下午5:45:26
 *
 *        Modification History: Date Author Version Description
 *        ---------------------------------------------------------* 2018年5月18日
 *        Administrator v1.0.0 修改原因
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket buildDocket() {
	return new Docket(DocumentationType.SWAGGER_2)
		.apiInfo(buildApiInf()) // .apiInfo(apiInfo())
		.select()
		.apis(RequestHandlerSelectors.basePackage("com.skyworth.controller"))// 要注释的接口名
		.paths(PathSelectors.any())
		.build();
    }

    private ApiInfo buildApiInf() {
	return new ApiInfoBuilder().title("TV平台后台管理系统接口详情")
		.description("Spring Boot中使用Swagger2构建RESTful APIs")
		.termsOfServiceUrl("http://www.skyworth.com")
		.contact(new Contact("skyworth", "http://www.skyworth.com", ""))
		.version("1.0")
		.build();

    }
}
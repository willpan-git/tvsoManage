/**
 * 
 */
package com.skyworth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**   
* Copyright: Copyright (c) 2018 skyworth
* 
* @ClassName: CorsConfig.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Administrator
* @date: 2018年7月19日 上午9:12:25 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年7月19日     Administrator           v1.0.0               修改原因
*/
@Configuration
public class CorsConfig  implements WebMvcConfigurer  {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
        .allowedOrigins("*")
        .allowedMethods("GET", "POST", "PUT", "OPTIONS", "DELETE", "PATCH")
        .allowCredentials(true).maxAge(3600);
    }
}

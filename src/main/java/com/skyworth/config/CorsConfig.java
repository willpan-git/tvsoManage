/**
 * 
 */
package com.skyworth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**   
* Copyright: Copyright (c) 2018 skyworth
* 
* @ClassName: CorsConfig.java
* @Description: 允许跨域配置文件
*
* @version: v1.0.0
* @author: Administrator
* @date: 2018年5月31日 上午11:45:21 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年5月31日     Administrator           v1.0.0               修改原因
*/
@Configuration
public class CorsConfig {
    private CorsConfiguration buildConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*"); // 1
        corsConfiguration.addAllowedHeader("*"); // 2
        corsConfiguration.addAllowedMethod("*"); // 3
        return corsConfiguration;
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", buildConfig()); // 4
        return new CorsFilter(source);
    }
}

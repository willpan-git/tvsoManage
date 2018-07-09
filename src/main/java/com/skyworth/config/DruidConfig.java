/**
 * 
 */
package com.skyworth.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

/**
 * Copyright: Copyright (c) 2018 skyworth
 * 
 * @ClassName: DruidConfig.java
 * @Description: druid监控工能配置
 *
 * @version: v1.0.0
 * @author: Administrator
 * @date: 2018年5月29日 下午7:04:05
 *
 *        Modification History: Date Author Version Description
 *        ---------------------------------------------------------* 2018年5月29日
 *        Administrator v1.0.0 修改原因
 */

@Configuration
public class DruidConfig {
    @Bean
    public ServletRegistrationBean<StatViewServlet> druidServlet() {
	ServletRegistrationBean<StatViewServlet> servletRegistrationBean = new ServletRegistrationBean<StatViewServlet>(new StatViewServlet(),
		"/druid/*");
	// 登入白名单
	servletRegistrationBean.addInitParameter("allow", "127.0.0.1");
	// 登入黑名单
	servletRegistrationBean.addInitParameter("deny", "");
	// 监控页面登入账户和密码
	servletRegistrationBean.addInitParameter("loginUsername", "admin");
	servletRegistrationBean.addInitParameter("loginPassword", "9527");
	// 禁用页面的reset all功能
	servletRegistrationBean.addInitParameter("resetEnable", "false");
	return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean<WebStatFilter> filterRegistrationBean() {
	FilterRegistrationBean<WebStatFilter> filterRegistrationBean = new FilterRegistrationBean<WebStatFilter>(new WebStatFilter());
	filterRegistrationBean.addUrlPatterns("/*");
	// 忽略资源
	filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
	return filterRegistrationBean;
    }

}

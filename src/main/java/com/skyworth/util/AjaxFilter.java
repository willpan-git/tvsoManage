/**
 * 
 */
package com.skyworth.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

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
//拦截器添加跨域支持（如果是web.xml配置拦截器，请将@component删除）
@Component
public class AjaxFilter implements Filter {

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {

  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

      HttpServletRequest request = (HttpServletRequest) servletRequest;
      HttpServletResponse response = (HttpServletResponse) servletResponse;
      response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
      response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
      response.setHeader("Access-Control-Max-Age", "3600");
      response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
      response.setHeader("Access-Control-Allow-Credentials","true"); 
      filterChain.doFilter(servletRequest, servletResponse);
  }

  @Override
  public void destroy() {

  }
}

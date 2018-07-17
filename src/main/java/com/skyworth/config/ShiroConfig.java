/**
 * 
 */
package com.skyworth.config;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.DelegatingFilterProxy;

import com.skyworth.realm.MyRealm;

/**
 * Copyright: Copyright (c) 2018 skyworth
 * 
 * @ClassName: ShiroConfiguration.java
 * @Description: shiro定义
 *
 * @version: v1.0.0
 * @author: Administrator
 * @date: 2018年5月14日 下午2:11:58
 *
 *        Modification History: Date Author Version Description
 *        ---------------------------------------------------------* 2018年5月14日
 *        Administrator v1.0.0 修改原因
 */
@Configuration
public class ShiroConfig {
    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;
    
//    @Value("${spring.redis.timeout}")  
//    private int timeout; 


    /**
     * 修复Spring Boot整合shiro出现UnavailableSecurityManagerException 问题
     * 此处设置相当于在web.xml中增加filter
     */
    @Bean
    public FilterRegistrationBean<DelegatingFilterProxy> delegatingFilterProxy() {
	FilterRegistrationBean<DelegatingFilterProxy> filterRegistrationBean = new FilterRegistrationBean<DelegatingFilterProxy>();
	DelegatingFilterProxy proxy = new DelegatingFilterProxy();
	proxy.setTargetFilterLifecycle(true);
	proxy.setTargetBeanName("shiroFilter");
	filterRegistrationBean.setFilter(proxy);
	return filterRegistrationBean;
    }

    /**
     * SHIRO核心拦截器配置
     */
    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(@Qualifier("securityManager") SecurityManager securityManager) {
	ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
	// 必须设置 SecurityManager
	shiroFilterFactoryBean.setSecurityManager(securityManager);

	// 拦截器.顺序判断
	Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
	// authc:所有url都必须认证通过才可以访问
	// anon:所有url都都可以匿名访问
	filterChainDefinitionMap.put("/user/login", "anon");
	// 放行静态资源
	filterChainDefinitionMap.put("/static/**", "anon");
	// swagger2 放行
	filterChainDefinitionMap.put("/swagger-ui.html", "anon");
	filterChainDefinitionMap.put("/swagger/**", "anon");
	filterChainDefinitionMap.put("/webjars/**", "anon");
	filterChainDefinitionMap.put("/swagger-resources/**", "anon");
	filterChainDefinitionMap.put("/v2/**", "anon");
	// druid 监控放行
	filterChainDefinitionMap.put("/druid/**", "anon");
	// 退出 过滤器
	filterChainDefinitionMap.put("/user/logout", "logout");
	// 过滤链定义，从上向下顺序执行，一般将 /**放在最为下边
	// filterChainDefinitionMap.put("/**", "authc");
	shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

	// 配置退出过滤器,如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
	shiroFilterFactoryBean.setLoginUrl("/login.html");
	// 登录成功后要跳转的链接
	shiroFilterFactoryBean.setSuccessUrl("/index.html");
	// 未授权要跳转的链接;
	shiroFilterFactoryBean.setUnauthorizedUrl("/login.html");

	return shiroFilterFactoryBean;
    }

    /**
     * securityManager 安全管理器 （通过 authorize 调用 自定义 realm 数据进行认证和授权）
     */
    @Bean(name = "securityManager")
    public SecurityManager securityManager(@Qualifier("myRealm") MyRealm myRealm) {
	DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
	// 设置realm.
	securityManager.setRealm(myRealm);

	// 自定义缓存实现 使用redis
	securityManager.setCacheManager(cacheManager());
	
	// 自定义session管理 使用redis
	securityManager.setSessionManager(sessionManager());
	

	return securityManager;
    }

    /**
     * 自定义realm; (账号密码校验；权限等)
     * 
     * @return
     */
    @Bean(name = "myRealm")
    public MyRealm myRealm() {
	MyRealm myRealm = new MyRealm();
	// 添加 matcher加密算法到 MyRealm
	myRealm.setCredentialsMatcher(hashedCredentialsMatcher());
	return myRealm;
    }

    /**
     * 密码匹配凭证管理器
     *
     * @return
     */
    @Bean(name = "hashedCredentialsMatcher")
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
	HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
	// 采用MD5方式加密
	hashedCredentialsMatcher.setHashAlgorithmName("MD5");
	// 设置加密次数
	hashedCredentialsMatcher.setHashIterations(1024);
	return hashedCredentialsMatcher;
    }

    /**
     * Shiro生命周期处理器
     * 
     * @return
     */
    @Bean(name = "lifecycleBeanPostProcessor")
    public static LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
	return new LifecycleBeanPostProcessor();
    }

    /**
     * 开启Shiro的注解(如@RequiresRoles,@RequiresPermissions 授权注解)
     * 需借助SpringAOP扫描使用Shiro注解的类,并在必要时进行安全逻辑验证
     * 
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(
	    @Qualifier("securityManager") SecurityManager securityManager) {
	AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
	advisor.setSecurityManager(securityManager);
	return advisor;
    }

    /**
     * 配置shiro redisManager 使用的是shiro-redis开源插件
     * 
     * @return
     */
    public RedisManager redisManager() {
	RedisManager redisManager = new RedisManager();
	redisManager.setHost(host);
	redisManager.setPort(port);
	redisManager.setExpire(1800);// 配置缓存过期时间
	//redisManager.setTimeout(timeout);
	// redisManager.setPassword(password);
	return redisManager;
    }

    /**
     * cacheManager 缓存 redis实现 使用的是shiro-redis开源插件
     * 
     * @return
     */
    public RedisCacheManager cacheManager() {
	RedisCacheManager redisCacheManager = new RedisCacheManager();
	redisCacheManager.setRedisManager(redisManager());
	return redisCacheManager;
    }

    /**
     * RedisSessionDAO shiro sessionDao层的实现 通过redis 使用的是shiro-redis开源插件
     */
    @Bean
    public RedisSessionDAO redisSessionDAO() {
	RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
	redisSessionDAO.setRedisManager(redisManager());
	return redisSessionDAO;
    }

    /**
     * shiro session的管理
     */
    @Bean
    public DefaultWebSessionManager sessionManager() {
	DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
	sessionManager.setSessionDAO(redisSessionDAO());
	return sessionManager;
    }


     /*@Bean(name = "redisTemplate")
     public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
 	RedisTemplate<String, String> template = new RedisTemplate<>();
 	RedisSerializer<String> redisSerializer = new StringRedisSerializer();
 	template.setConnectionFactory(factory);
 	// key序列化方式
 	template.setKeySerializer(redisSerializer);
 	// value序列化
 	template.setValueSerializer(redisSerializer);
 	// value hashmap序列化
 	template.setHashValueSerializer(redisSerializer);
 	// key haspmap序列化
 	template.setHashKeySerializer(redisSerializer);
 	//
 	return template;
     }*/
}

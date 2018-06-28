/**
 * 
 */
package com.skyworth.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**   
* Copyright: Copyright (c) 2018 skyworth
* 
* @ClassName: RedisConfig.java
* @Description: 配置redis链接池
*
* @version: v1.0.0
* @author: Administrator
* @date: 2018年6月5日 下午1:46:51 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年6月5日     Administrator           v1.0.0               修改原因
*/
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {
	@Value("${spring.redis.host}")
	private String host;

	@Value("${spring.redis.port}")
	private int port;

	@Value("${spring.redis.timeout}")
	private int timeout;

	@Value("${spring.redis.max-idle}")
	private int maxIdle;

	@Value("${spring.redis.max-wait}")
	private long maxWaitMillis;

	@Bean
	public JedisPool redisPoolFactory() {
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		jedisPoolConfig.setMaxIdle(maxIdle);
		jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);

		JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port, timeout);

		return jedisPool;
	}
}

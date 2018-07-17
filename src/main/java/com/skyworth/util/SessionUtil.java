/**
 * 
 */
package com.skyworth.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.skyworth.entity.ResultEnum;
import com.skyworth.exception.MyRuntimeException;

/**   
* Copyright: Copyright (c) 2018 skyworth
* 
* @ClassName: SessionUtil.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Administrator
* @date: 2018年6月28日 下午3:03:39 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年6月28日     Administrator           v1.0.0               修改原因
*/
public class SessionUtil {
    /**
     * SpringMvc下获取request
     * 
     * @return
     */
    public static HttpServletRequest getRequest() {
	HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        return request;

    }
    /**
     * SpringMvc下获取session
     * 
     * @return
     */
    public static HttpSession getSession() {
        HttpSession session = getRequest().getSession(false);
        // session 失效，提示重新登入
        if (session == null) {
            throw new MyRuntimeException(ResultEnum.InvalidatedSessionException);
	}
        return session;

    }
}

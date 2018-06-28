/**
 * 
 */
package com.skyworth.util;

import org.apache.shiro.crypto.hash.Md5Hash;

/**   
* Copyright: Copyright (c) 2018 skyworth
* 
* @ClassName: Md5Util.java
* @Description: Md5加密工具:md5+salt
*
* @version: v1.0.0
* @author: Administrator
* @date: 2018年5月16日 下午6:48:43 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年5月16日     Administrator           v1.0.0               修改原因
*/
public class Md5Util {
	public static String md5(String crdentials,String salt) {
		Md5Hash md5Hash = new Md5Hash(crdentials,salt,1024);
		return md5Hash.toString();
	}
}

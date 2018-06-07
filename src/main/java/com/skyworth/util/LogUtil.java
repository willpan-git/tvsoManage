package com.skyworth.util;

/**   
* Copyright: Copyright (c) 2018 skyworth
* 
* @ClassName: LogUtil.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Administrator
* @date: 2018年5月10日 下午4:41:27 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年5月10日     Administrator           v1.0.0               修改原因
*/
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description: 日志工具类
 * @Author: LinkinStar
 */
public class LogUtil {

	/**
	 * 将信息打印到自定义日志（my_info.log）中
	 * 
	 * @param message
	 *            需要被打印的信息
	 */
	public static void printLog(String message) {
		Logger logger = LoggerFactory.getLogger("log_info");

		StringBuffer logOut = new StringBuffer();
		logOut.append("\n");
		logOut.append(message);
		logOut.append("\n");

		logger.info(logOut.toString());
	}

	/**
	 * 将信息打印到自定义日志（system_error.log）中
	 * 
	 * @param e
	 *            异常信息
	 */
	public static void printLog(Exception e, Class<?> clazz) {
		Logger logger = LoggerFactory.getLogger(clazz);

		StringBuffer logOut = new StringBuffer();
		logOut.append("\n");
		logOut.append(e.toString());
		logOut.append("\n");

		StackTraceElement[] errorList = e.getStackTrace();
		for (StackTraceElement stackTraceElement : errorList) {
			logOut.append(stackTraceElement.toString());
			logOut.append("\n");
		}

		logOut.append("\n");
		logOut.append("\n");

		logger.error(logOut.toString());
	}

}

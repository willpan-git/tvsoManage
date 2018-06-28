package com.skyworth.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.skyworth.entity.Result;
import com.skyworth.util.LogUtil;
import com.skyworth.util.ResultUtil;

/**
 * Copyright: Copyright (c) 2018 skyworth
 * 
 * @ClassName: GolbalExceptionHandler.java
 * @Description: 全局异常捕获
 *
 * @version: v1.0.0
 * @author: Administrator
 * @date: 2018��5��7�� ����1:47:33
 *
 *        Modification History: Date Author Version Description
 *        ---------------------------------------------------------*
 *        2018��5��7�� Administrator v1.0.0 �޸�ԭ��
 */
@ControllerAdvice
public class GolbalExceptionHandler {
	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public Result<?> exceptionHandler(Exception ex) {

		if (ex instanceof MyException) {
			MyException myException = (MyException) ex;
			return ResultUtil.getError(myException.getCode(), myException.getMessage());
		} else {
			// 调用日志打印方法
			LogUtil.printLog(ex, RuntimeException.class);
			return ResultUtil.getError("-1", "系统错误，请稍后重试！");
		}

	}
}

/**
 * 
 */
package com.skyworth.util;

import javax.validation.constraints.Null;

import com.skyworth.entity.Result;

/**
 * Copyright: Copyright (c) 2018 skyworth
 * 
 * @ClassName: ResultUtil.java
 * @Description: 根据返回数据对象可封装相应的结果模板工具类 (封装成json)
 *
 * @version: v1.0.0
 * @author: Administrator
 * @date: 2018年5月15日 下午5:53:05
 *
 *        Modification History: Date Author Version Description
 *        ---------------------------------------------------------* 2018年5月15日
 *        Administrator v1.0.0 修改原因
 */
public class ResultUtil {
    public static Result<Object> getSuccess(String code, String msg, Object object) {
	Result<Object> result = new Result<Object>();
	result.setCode(code);
	result.setMsg(msg);
	result.setData(object);
	return result;
    }

    public static Result<?> getSuccess() {
	return getSuccess("", "", null);
    }

    public static Result<Null> getError(String code, String msg) {
	Result<Null> result = new Result<Null>();
	result.setCode(code);
	result.setMsg(msg);
	return result;
    }
}

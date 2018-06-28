/**
 * 
 */
package com.skyworth.entity;

/**   
* Copyright: Copyright (c) 2018 skyworth
* 
* @ClassName: Result.java
* @Description: 返回错误信息的类(一个Http最外层的封装对象，统一返回的对象数据json)
*
* @version: v1.0.0
* @author: Administrator
* @date: 2018年5月15日 下午6:57:34 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年5月15日     Administrator           v1.0.0               修改原因
*/
public class Result<T> {

    /** 错误码. */
    private String code;

    /** 提示信息. */
    private String msg;

    /** 具体的内容. */
    private T data;

    public String getCode() {
        return code;
    }

    public void setCode(String code2) {
        this.code = code2;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
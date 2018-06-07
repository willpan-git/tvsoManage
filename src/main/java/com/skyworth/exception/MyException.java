/**
 * 
 */
package com.skyworth.exception;

import com.skyworth.entity.ResultEnum;

/**   
* Copyright: Copyright (c) 2018 skyworth
* 
* @ClassName: myException.java
* @Description: 自定义抛出信息,注意这里不能继承Exception，因为 springBoot只支持继承RuntimeException的
*
* @version: v1.0.0
* @author: Administrator
* @date: 2018年5月15日 下午7:01:14 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年5月15日     Administrator           v1.0.0               修改原因
*/
public class MyException extends RuntimeException {

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;
    private String code;
    private String msg;

    public String getCode() {
        return code;
    }
    public String getMeg() {
        return msg;
    }

    public MyException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public MyException(String code,String message) {
        this.code = code;
        this.msg = message;
    }
}

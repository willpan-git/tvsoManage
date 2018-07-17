/**
 * 
 */
package com.skyworth.exception;

import com.skyworth.entity.ResultEnum;

/**   
* Copyright: Copyright (c) 2018 skyworth
* 
* @ClassName: MyRuntimeException.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Administrator
* @date: 2018年7月12日 上午9:40:15 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年7月12日     Administrator           v1.0.0               修改原因
*/
public class MyRuntimeException extends RuntimeException {

    /**
	 * 
	 */
    private static final long serialVersionUID = 2L;
    private String code;
    private String msg;

    public String getCode() {
        return code;
    }
    public String getMeg() {
        return msg;
    }

    public MyRuntimeException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public MyRuntimeException(String code,String message) {
        this.code = code;
        this.msg = message;
    }
}

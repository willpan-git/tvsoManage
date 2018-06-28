/**
 * 
 */
package com.skyworth.entity;

/**
 * Copyright: Copyright (c) 2018 skyworth
 * 
 * @ClassName: ResultEnum.java
 * @Description: 提示信息枚举类
 *
 * @version: v1.0.0
 * @author: Administrator
 * @date: 2018年5月15日 下午7:20:12
 *
 *        Modification History: Date Author Version Description
 *        ---------------------------------------------------------* 2018年5月15日
 *        Administrator v1.0.0 修改原因
 */
public enum ResultEnum {
	 /**
     * 成功. ErrorCode : 00
     */
    SUCCESS("00","成功！"),
    AddSuccess("0001","新增成功！"),
    UpdateSuccess("0002","更新信息成功！"),
    DeleteSuccess("0003","删除成功！"),
    UnableSuccess("0004","失效成功！"),
    EffectSuccess("0005","生效成功！"),
    UploadSuccess("0006","上传成功！"),
    NoDataSuccess("0007","没有查询到数据！"),
    AdminSuccess("0008","登入成功！"),
    UpSuccess("0009","上架成功！"),
    DownSuccess("0010","下架成功！"),
    /**
     * 未知异常. ErrorCode : 01
     */
    UnknownException("01","未知异常"),
    /**
     * 系统异常. ErrorCode : 02
     */
    SystemException("02","系统异常"),
    UploadFailException("0201","上传失败！"),
    /**
     * 业务错误. ErrorCode : 03
     */
    MyException("03","业务错误"),
    AdminFailException("0301","登入失败！"),
    /**
     * 提示级错误. ErrorCode : 04
     */
    InfoException("04", "提示级错误"),
    UnknownAccountException("0401","该用户名不存在！"),
    IncorrectCredentialsException("0402","用户名或密码错误！"),
    LockedAccountException("0403","用户名已被锁定或失效，请联系管理员！"),
    ExistsAccountException("0404","该用户账号已经存在，请重新填写！"),
    
    UnknowEquipException("0405","该设备信息不存在！"),
    UnknowSchemeException("0406","该方案信息不存在！"),
    UnknowMaterialException("0407","该素材信息不存在！"),
    
    ExistsEquipException("0408","该设备已存在！"),
    
    /**
     * 数据库操作异常. ErrorCode : 05
     */
    DBException("05","数据库执行异常"),
    /**
     * 参数验证错误. ErrorCode : 06
     */
    ParamException("06","参数验证错误"),
    UnknownFileException("0601","请选择一个文件进行上传！"),
    ErrorFileException("0602","文件名称或者内容不能为空！");

    private String code;
    private String msg;
	
    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    ResultEnum(String code, String msg) {
	this.code = code;
	this.msg = msg;
    }
}

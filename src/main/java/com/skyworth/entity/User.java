package com.skyworth.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Copyright: Copyright (c) 2018 skyworth
 * 
 * @ClassName: User2.java
 * @Description: 用户类
 *
 * @version: v1.0.0
 * @author: Administrator
 * @date: 2018年5月11日 上午10:48:46
 *
 *        Modification History: Date Author Version Description
 *        ---------------------------------------------------------* 2018年5月11日
 *        Administrator v1.0.0 修改原因
 */
@ApiModel(description = "用户信息类")
public class User {
    @ApiModelProperty(value = "用户id",hidden=true)
    private Integer tourId;
    @ApiModelProperty(value = "用户类型")
    private Integer tourType;
    @ApiModelProperty(value = "用户类型名称")
    private String tourTypeName;
    @ApiModelProperty(value = "用户账号")
    private String tourAccount;
    @ApiModelProperty(value = "用户密码")
    private String tourPassword;
    @ApiModelProperty(value = "用户名称")
    private String tourName;
    @ApiModelProperty(value = "用户英文名称")
    private String tourEnglishName;
    @ApiModelProperty(value = "用户性别")
    private Integer tourSex;
    @ApiModelProperty(value = "用户地址")
    private String tourAddress;
    @ApiModelProperty(value = "用户联系电话")
    private String tourTelphone;
    @ApiModelProperty(value = "用户邮箱")
    private String tourMail;
    @ApiModelProperty(value = "用户传真")
    private String tourFox;
    @ApiModelProperty(value = "有效性")
    private Integer isenable;

    
    /**
     * @return the tourId
     */
    public Integer getTourId() {
        return tourId;
    }

    /**
     * @param tourId the tourId to set
     */
    public void setTourId(Integer tourId) {
        this.tourId = tourId;
    }

    /**
     * @return the tourType
     */
    public Integer getTourType() {
	return tourType;
    }

    /**
     * @param tourType
     *            the tourType to set
     */
    public void setTourType(Integer tourType) {
	this.tourType = tourType;
    }

    /**
     * @return the tourTypeName
     */
    public String getTourTypeName() {
	return tourTypeName;
    }

    /**
     * @param tourTypeName
     *            the tourTypeName to set
     */
    public void setTourTypeName(String tourTypeName) {
	this.tourTypeName = tourTypeName;
    }

    /**
     * @return the tourAccount
     */
    public String getTourAccount() {
	return tourAccount;
    }

    /**
     * @param tourAccount
     *            the tourAccount to set
     */
    public void setTourAccount(String tourAccount) {
	this.tourAccount = tourAccount;
    }

    /**
     * @return the tourPasswor
     */
    public String getTourPassword() {
	return tourPassword;
    }

    /**
     * @param tourPasswor
     *            the tourPasswor to set
     */
    public void setTourPassword(String tourPassword) {
	this.tourPassword = tourPassword;
    }

    /**
     * @return the tourName
     */
    public String getTourName() {
	return tourName;
    }

    /**
     * @param tourName
     *            the tourName to set
     */
    public void setTourName(String tourName) {
	this.tourName = tourName;
    }

    /**
     * @return the tourEnglishName
     */
    public String getTourEnglishName() {
	return tourEnglishName;
    }

    /**
     * @param tourEnglishName
     *            the tourEnglishName to set
     */
    public void setTourEnglishName(String tourEnglishName) {
	this.tourEnglishName = tourEnglishName;
    }

    /**
     * @return the tourSex
     */
    public Integer getTourSex() {
	return tourSex;
    }

    /**
     * @param tourSex
     *            the tourSex to set
     */
    public void setTourSex(Integer tourSex) {
	this.tourSex = tourSex;
    }

    /**
     * @return the tourAddress
     */
    public String getTourAddress() {
	return tourAddress;
    }

    /**
     * @param tourAddress
     *            the tourAddress to set
     */
    public void setTourAddress(String tourAddress) {
	this.tourAddress = tourAddress;
    }

    /**
     * @return the tourTelphone
     */
    public String getTourTelphone() {
	return tourTelphone;
    }

    /**
     * @param tourTelphone
     *            the tourTelphone to set
     */
    public void setTourTelphone(String tourTelphone) {
	this.tourTelphone = tourTelphone;
    }

    /**
     * @return the tourMail
     */
    public String getTourMail() {
	return tourMail;
    }

    /**
     * @param tourMail
     *            the tourMail to set
     */
    public void setTourMail(String tourMail) {
	this.tourMail = tourMail;
    }

    /**
     * @return the tourFox
     */
    public String getTourFox() {
	return tourFox;
    }

    /**
     * @param tourFox
     *            the tourFox to set
     */
    public void setTourFox(String tourFox) {
	this.tourFox = tourFox;
    }

    /**
     * @return the tourIsenable
     */
    public Integer getIsenable() {
	return isenable;
    }

    /**
     * @param tourIsenable
     *            the tourIsenable to set
     */
    public void setIsenable(Integer isenable) {
	this.isenable = isenable;
    }

}

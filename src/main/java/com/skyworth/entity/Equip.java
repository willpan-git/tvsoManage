/**
 * 
 */
package com.skyworth.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Copyright: Copyright (c) 2018 skyworth
 * 
 * @ClassName: Equip.java
 * @Description: 设备信息类
 *
 * @version: v1.0.0
 * @author: Administrator
 * @date: 2018年5月18日 上午11:48:19
 *
 *        Modification History: Date Author Version Description
 *        ---------------------------------------------------------* 2018年5月18日
 *        Administrator v1.0.0 修改原因
 */
@ApiModel(description = "设备信息类")
public class Equip {
    @ApiModelProperty(value = "设备id",hidden=true)
    private Integer toeiId;
    @ApiModelProperty(value = "设备名称")
    private String toeiEquipmentName;
    @ApiModelProperty(value = "设备编码")
    private String toeiEquipmentCode;
    @ApiModelProperty(value = "设备机芯")
    private String toeiEquipmentCore;
    @ApiModelProperty(value = "设备机型")
    private String toeiEquipmentType;
    @ApiModelProperty(value = "设备使用国家")
    private String toeiEquipmentCountry;
    @ApiModelProperty(value = "设备使用国家名称")
    private String toeiEquipmentCountryName;
    @ApiModelProperty(value = "设备开机广告id")
    private Integer toeiAdvertisement;
    @ApiModelProperty(value = "设备开机广告名称")
    private String toeiAdvertisementName;
    @ApiModelProperty(value = "设备默认方案id")
    private Integer toeiDefaultScheme;
    @ApiModelProperty(value = "设备默认方案名称")
    private String toeiDefaultSchemeName;
    @ApiModelProperty(value = "设备使用主题id")
    private Integer toeiUseingScheme;
    @ApiModelProperty(value = "设备使用主题名称")
    private String toeiUseingSchemeName;
    @ApiModelProperty(value = "有效性")
    private Integer isenable;
    @ApiModelProperty(value = "备注")
    private String toeiRemark;

    
    /**
     * @return the toeiId
     */
    public Integer getToeiId() {
        return toeiId;
    }

    /**
     * @param toeiId the toeiId to set
     */
    public void setToeiId(Integer toeiId) {
        this.toeiId = toeiId;
    }

    /**
     * @return the toeiEquipmentName
     */
    public String getToeiEquipmentName() {
	return toeiEquipmentName;
    }

    /**
     * @param toeiEquipmentName
     *            the toeiEquipmentName to set
     */
    public void setToeiEquipmentName(String toeiEquipmentName) {
	this.toeiEquipmentName = toeiEquipmentName;
    }

    /**
     * @return the toeiEquipmentCode
     */
    public String getToeiEquipmentCode() {
	return toeiEquipmentCode;
    }

    /**
     * @param toeiEquipmentCode
     *            the toeiEquipmentCode to set
     */
    public void setToeiEquipmentCode(String toeiEquipmentCode) {
	this.toeiEquipmentCode = toeiEquipmentCode;
    }

    /**
     * @return the toeiEquipmentCore
     */
    public String getToeiEquipmentCore() {
	return toeiEquipmentCore;
    }

    /**
     * @param toeiEquipmentCore
     *            the toeiEquipmentCore to set
     */
    public void setToeiEquipmentCore(String toeiEquipmentCore) {
	this.toeiEquipmentCore = toeiEquipmentCore;
    }

    /**
     * @return the toeiEquipmentType
     */
    public String getToeiEquipmentType() {
	return toeiEquipmentType;
    }

    /**
     * @param toeiEquipmentType
     *            the toeiEquipmentType to set
     */
    public void setToeiEquipmentType(String toeiEquipmentType) {
	this.toeiEquipmentType = toeiEquipmentType;
    }

    /**
     * @return the toeiEquipmentCountry
     */
    public String getToeiEquipmentCountry() {
	return toeiEquipmentCountry;
    }

    /**
     * @param toeiEquipmentCountry
     *            the toeiEquipmentCountry to set
     */
    public void setToeiEquipmentCountry(String toeiEquipmentCountry) {
	this.toeiEquipmentCountry = toeiEquipmentCountry;
    }
    

    /**
     * @return the toeiEquipmentCountryName
     */
    public String getToeiEquipmentCountryName() {
        return toeiEquipmentCountryName;
    }

    /**
     * @param toeiEquipmentCountryName the toeiEquipmentCountryName to set
     */
    public void setToeiEquipmentCountryName(String toeiEquipmentCountryName) {
        this.toeiEquipmentCountryName = toeiEquipmentCountryName;
    }
    
    

    /**
     * @return the toeiAdvertisement
     */
    public Integer getToeiAdvertisement() {
        return toeiAdvertisement;
    }

    /**
     * @param toeiAdvertisement the toeiAdvertisement to set
     */
    public void setToeiAdvertisement(Integer toeiAdvertisement) {
        this.toeiAdvertisement = toeiAdvertisement;
    }

    /**
     * @return the toeiAdvertisementName
     */
    public String getToeiAdvertisementName() {
        return toeiAdvertisementName;
    }

    /**
     * @param toeiAdvertisementName the toeiAdvertisementName to set
     */
    public void setToeiAdvertisementName(String toeiAdvertisementName) {
        this.toeiAdvertisementName = toeiAdvertisementName;
    }

    /**
     * @return the toeiDefaultScheme
     */
    public Integer getToeiDefaultScheme() {
	return toeiDefaultScheme;
    }

    /**
     * @param toeiDefaultScheme
     *            the toeiDefaultScheme to set
     */
    public void setToeiDefaultScheme(Integer toeiDefaultScheme) {
	this.toeiDefaultScheme = toeiDefaultScheme;
    }

    /**
     * @return the toeiDefaultSchemeName
     */
    public String getToeiDefaultSchemeName() {
	return toeiDefaultSchemeName;
    }

    /**
     * @param toeiDefaultSchemeName
     *            the toeiDefaultSchemeName to set
     */
    public void setToeiDefaultSchemeName(String toeiDefaultSchemeName) {
	this.toeiDefaultSchemeName = toeiDefaultSchemeName;
    }

    /**
     * @return the toeiUseingScheme
     */
    public Integer getToeiUseingScheme() {
	return toeiUseingScheme;
    }

    /**
     * @param toeiUseingScheme
     *            the toeiUseingScheme to set
     */
    public void setToeiUseingScheme(Integer toeiUseingScheme) {
	this.toeiUseingScheme = toeiUseingScheme;
    }

    /**
     * @return the toeiUseingSchemeName
     */
    public String getToeiUseingSchemeName() {
	return toeiUseingSchemeName;
    }

    /**
     * @param toeiUseingSchemeName
     *            the toeiUseingSchemeName to set
     */
    public void setToeiUseingSchemeName(String toeiUseingSchemeName) {
	this.toeiUseingSchemeName = toeiUseingSchemeName;
    }

    /**
     * @return the isenable
     */
    public Integer getIsenable() {
	return isenable;
    }

    /**
     * @param isenable
     *            the isenable to set
     */
    public void setIsenable(Integer isenable) {
	this.isenable = isenable;
    }

    /**
     * @return the toeiRemark
     */
    public String getToeiRemark() {
	return toeiRemark;
    }

    /**
     * @param toeiRemark
     *            the toeiRemark to set
     */
    public void setToeiRemark(String toeiRemark) {
	this.toeiRemark = toeiRemark;
    }

}

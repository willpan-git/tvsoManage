/**
 * 
 */
package com.skyworth.entity;

import java.util.ArrayList;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.skyworth.entity.SchemeDetail;

/**
 * Copyright: Copyright (c) 2018 skyworth
 * 
 * @ClassName: Scheme.java
 * @Description: 方案实体类
 *
 * @version: v1.0.0
 * @author: Administrator
 * @date: 2018年5月22日 下午2:00:31
 *
 *        Modification History: Date Author Version Description
 *        ---------------------------------------------------------* 2018年5月22日
 *        Administrator v1.0.0 修改原因
 */
@ApiModel(description = "方案类")
public class Scheme {
    @ApiModelProperty(value = "方案id",hidden=true)
    private Integer toseId;
    @ApiModelProperty(value = "方案编码")
    private String toseCode;
    @ApiModelProperty(value = "方案名称")
    private String toseName;
    @ApiModelProperty(value = "方案机芯")
    private String toseEquipmentCore;
    @ApiModelProperty(value = "方案机型")
    private String toseEquipmentType;
    @ApiModelProperty(value = "方案使用国家")
    private String toseEquipmentCountry;
    @ApiModelProperty(value = "方案语言")
    private String toseLanguage;
    @ApiModelProperty(value = "方案优先级")
    private String toseLevel;
    @ApiModelProperty(value = "方案版本")
    private String toseVersion;
    @ApiModelProperty(value = "方案关联客户")
    private String toseUnionCust;
    @ApiModelProperty(value = "备注")
    private String toseRemark;
    @ApiModelProperty(value = "状态")
    private Integer toseStatus;
    @ApiModelProperty(value = "有效性")
    private Integer isenable;
    
    private ArrayList<SchemeDetail> schemeDetail;
    

    /**
     * @return the toseId
     */
    public Integer getToseId() {
        return toseId;
    }

    /**
     * @param toseId the toseId to set
     */
    public void setToseId(Integer toseId) {
        this.toseId = toseId;
    }

    /**
     * @return the toseCode
     */
    public String getToseCode() {
	return toseCode;
    }

    /**
     * @param toseCode
     *            the toseCode to set
     */
    public void setToseCode(String toseCode) {
	this.toseCode = toseCode;
    }

    /**
     * @return the toseName
     */
    public String getToseName() {
	return toseName;
    }

    /**
     * @param toseName
     *            the toseName to set
     */
    public void setToseName(String toseName) {
	this.toseName = toseName;
    }

    /**
     * @return the toseEquipmentCore
     */
    public String getToseEquipmentCore() {
	return toseEquipmentCore;
    }

    /**
     * @param toseEquipmentCore
     *            the toseEquipmentCore to set
     */
    public void setToseEquipmentCore(String toseEquipmentCore) {
	this.toseEquipmentCore = toseEquipmentCore;
    }

    /**
     * @return the toseEquipmentType
     */
    public String getToseEquipmentType() {
	return toseEquipmentType;
    }

    /**
     * @param toseEquipmentType
     *            the toseEquipmentType to set
     */
    public void setToseEquipmentType(String toseEquipmentType) {
	this.toseEquipmentType = toseEquipmentType;
    }

    /**
     * @return the toseEquipmentCountry
     */
    public String getToseEquipmentCountry() {
	return toseEquipmentCountry;
    }

    /**
     * @param toseEquipmentCountry
     *            the toseEquipmentCountry to set
     */
    public void setToseEquipmentCountry(String toseEquipmentCountry) {
	this.toseEquipmentCountry = toseEquipmentCountry;
    }

    /**
     * @return the toseLanguage
     */
    public String getToseLanguage() {
	return toseLanguage;
    }

    /**
     * @param toseLanguage
     *            the toseLanguage to set
     */
    public void setToseLanguage(String toseLanguage) {
	this.toseLanguage = toseLanguage;
    }

    /**
     * @return the toseLevel
     */
    public String getToseLevel() {
	return toseLevel;
    }

    /**
     * @param toseLevel
     *            the toseLevel to set
     */
    public void setToseLevel(String toseLevel) {
	this.toseLevel = toseLevel;
    }

    /**
     * @return the toseVersion
     */
    public String getToseVersion() {
	return toseVersion;
    }

    /**
     * @param toseVersion
     *            the toseVersion to set
     */
    public void setToseVersion(String toseVersion) {
	this.toseVersion = toseVersion;
    }

    /**
     * @return the toseUnionCust
     */
    public String getToseUnionCust() {
	return toseUnionCust;
    }

    /**
     * @param toseUnionCust
     *            the toseUnionCust to set
     */
    public void setToseUnionCust(String toseUnionCust) {
	this.toseUnionCust = toseUnionCust;
    }

    /**
     * @return the toseRemark
     */
    public String getToseRemark() {
	return toseRemark;
    }

    /**
     * @param toseRemark
     *            the toseRemark to set
     */
    public void setToseRemark(String toseRemark) {
	this.toseRemark = toseRemark;
    }

    /**
     * @return the toseStatus
     */
    public Integer getToseStatus() {
	return toseStatus;
    }

    /**
     * @param toseStatus
     *            the toseStatus to set
     */
    public void setToseStatus(Integer toseStatus) {
	this.toseStatus = toseStatus;
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
     * @return the schemeDetail
     */
    public ArrayList<SchemeDetail> getSchemeDetail() {
	return schemeDetail;
    }

    /**
     * @param schemeDetail the schemeDetail to set
     */
    public void setSchemeDetail(ArrayList<SchemeDetail> schemeDetail) {
	this.schemeDetail = schemeDetail;
    }
}


/**
 * 
 */
package com.skyworth.entity;

import java.sql.Time;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Copyright: Copyright (c) 2018 skyworth
 * 
 * @ClassName: Advertisement.java
 * @Description: 该类的功能描述
 *
 * @version: v1.0.0
 * @author: Administrator
 * @date: 2018年7月23日 上午11:11:49
 *
 *        Modification History: Date Author Version Description
 *        ---------------------------------------------------------* 2018年7月23日
 *        Administrator v1.0.0 修改原因
 */
@ApiModel(description = "广告应用类")
public class Advertisement {
    @ApiModelProperty(value = "广告id", hidden = true)
    private Integer toatId;
    @ApiModelProperty(value = "广告名称")
    private String toatName;
    @ApiModelProperty(value = "广告存放地址")
    private String toatUrl;
    @ApiModelProperty(value = "广告时长")
    private Time toatDuration;
    @ApiModelProperty(value = "广告格式")
    private String toatFormat;
    @ApiModelProperty(value = "广告描述")
    private String toatRemark;
    @ApiModelProperty(value = "有效性")
    private Integer isenable;
    /**
     * @return the toatId
     */
    public Integer getToatId() {
        return toatId;
    }
    /**
     * @param toatId the toatId to set
     */
    public void setToatId(Integer toatId) {
        this.toatId = toatId;
    }
    /**
     * @return the toatName
     */
    public String getToatName() {
        return toatName;
    }
    /**
     * @param toatName the toatName to set
     */
    public void setToatName(String toatName) {
        this.toatName = toatName;
    }
    /**
     * @return the toatUrl
     */
    public String getToatUrl() {
        return toatUrl;
    }
    /**
     * @param toatUrl the toatUrl to set
     */
    public void setToatUrl(String toatUrl) {
        this.toatUrl = toatUrl;
    }
    /**
     * @return the toatDuration
     */
    public Time getToatDuration() {
        return toatDuration;
    }
    /**
     * @param toatDuration the toatDuration to set
     */
    public void setToatDuration(Time toatDuration) {
        this.toatDuration = toatDuration;
    }
    /**
     * @return the toatFormat
     */
    public String getToatFormat() {
        return toatFormat;
    }
    /**
     * @param toatFormat the toatFormat to set
     */
    public void setToatFormat(String toatFormat) {
        this.toatFormat = toatFormat;
    }
    /**
     * @return the toatRemark
     */
    public String getToatRemark() {
        return toatRemark;
    }
    /**
     * @param toatRemark the toatRemark to set
     */
    public void setToatRemark(String toatRemark) {
        this.toatRemark = toatRemark;
    }
    /**
     * @return the isenable
     */
    public Integer getIsenable() {
        return isenable;
    }
    /**
     * @param isenable the isenable to set
     */
    public void setIsenable(Integer isenable) {
        this.isenable = isenable;
    }

}

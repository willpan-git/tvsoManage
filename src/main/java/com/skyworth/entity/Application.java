/**
 * 
 */
package com.skyworth.entity;

import java.util.ArrayList;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**   
* Copyright: Copyright (c) 2018 skyworth
* 
* @ClassName: Application.java
* @Description: APP应用类
*
* @version: v1.0.0
* @author: Administrator
* @date: 2018年6月12日 上午9:46:08 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年6月12日     Administrator           v1.0.0               修改原因
*/
@ApiModel(description = "app应用类")
public class Application {
    @ApiModelProperty(value = "应用id",hidden=true)
    private Integer toanId;
    @ApiModelProperty(value = "应用分类")
    private Integer toanType;
    @ApiModelProperty(value = "应用分类名称")
    private String toanTypeName;
    @ApiModelProperty(value = "应用图标")
    private String toanIcon;
    @ApiModelProperty(value = "应用名称")
    private String toanName;
    @ApiModelProperty(value = "海报1")
    private String toanPosterFirst;
    @ApiModelProperty(value = "海报2")
    private String toanPosterSecond;
    @ApiModelProperty(value = "海报3")
    private String toanPosterThird;
    @ApiModelProperty(value = "APK/APP存放地址")
    private String toanUrl;
    @ApiModelProperty(value = "适用机芯")
    private String toanEquipmentCore;
    @ApiModelProperty(value = "适用机型")
    private String toanEquipmentType;
    @ApiModelProperty(value = "适用国家")
    private String toanEquipmentCountry;
    @ApiModelProperty(value = "语言")
    private String toanLanguage;
    @ApiModelProperty(value = "开发商")
    private String toanDeveloper;
    @ApiModelProperty(value = "应用大小")
    private Double toanSize;
    @ApiModelProperty(value = "年龄分级")
    private Integer toanAgeGrading;
    @ApiModelProperty(value = "版本")
    private String toanVersion;
    @ApiModelProperty(value = "评分")
    private Double toanScore;
    @ApiModelProperty(value = "下载总量")
    private Integer toanLoadTotals;
    @ApiModelProperty(value = "描述")
    private String toanRemark;
    @ApiModelProperty(value = "审核状态")
    private Integer toanStatus;
    @ApiModelProperty(value = "上/下架标识")
    private Integer isenable;
    
    private ArrayList<ApplicationLoad> applicationLoad;

    /**
     * @return the toanId
     */
    public Integer getToanId() {
        return toanId;
    }

    /**
     * @param toanId the toanId to set
     */
    public void setToanId(Integer toanId) {
        this.toanId = toanId;
    }

    /**
     * @return the toanType
     */
    public Integer getToanType() {
        return toanType;
    }

    /**
     * @param toanType the toanType to set
     */
    public void setToanType(Integer toanType) {
        this.toanType = toanType;
    }

    /**
     * @return the toanTypeName
     */
    public String getToanTypeName() {
        return toanTypeName;
    }

    /**
     * @param toanTypeName the toanTypeName to set
     */
    public void setToanTypeName(String toanTypeName) {
        this.toanTypeName = toanTypeName;
    }

    /**
     * @return the toanIcon
     */
    public String getToanIcon() {
        return toanIcon;
    }

    /**
     * @param toanIcon the toanIcon to set
     */
    public void setToanIcon(String toanIcon) {
        this.toanIcon = toanIcon;
    }

    /**
     * @return the toanName
     */
    public String getToanName() {
        return toanName;
    }

    /**
     * @param toanName the toanName to set
     */
    public void setToanName(String toanName) {
        this.toanName = toanName;
    }

    /**
     * @return the toanPosterFirst
     */
    public String getToanPosterFirst() {
        return toanPosterFirst;
    }

    /**
     * @param toanPosterFirst the toanPosterFirst to set
     */
    public void setToanPosterFirst(String toanPosterFirst) {
        this.toanPosterFirst = toanPosterFirst;
    }

    /**
     * @return the toanPosterSecond
     */
    public String getToanPosterSecond() {
        return toanPosterSecond;
    }

    /**
     * @param toanPosterSecond the toanPosterSecond to set
     */
    public void setToanPosterSecond(String toanPosterSecond) {
        this.toanPosterSecond = toanPosterSecond;
    }

    /**
     * @return the toanPosterThird
     */
    public String getToanPosterThird() {
        return toanPosterThird;
    }

    /**
     * @param toanPosterThird the toanPosterThird to set
     */
    public void setToanPosterThird(String toanPosterThird) {
        this.toanPosterThird = toanPosterThird;
    }

    /**
     * @return the toanUrl
     */
    public String getToanUrl() {
        return toanUrl;
    }

    /**
     * @param toanUrl the toanUrl to set
     */
    public void setToanUrl(String toanUrl) {
        this.toanUrl = toanUrl;
    }

    /**
     * @return the toanEquipmentCore
     */
    public String getToanEquipmentCore() {
        return toanEquipmentCore;
    }

    /**
     * @param toanEquipmentCore the toanEquipmentCore to set
     */
    public void setToanEquipmentCore(String toanEquipmentCore) {
        this.toanEquipmentCore = toanEquipmentCore;
    }

    /**
     * @return the toanEquipmentType
     */
    public String getToanEquipmentType() {
        return toanEquipmentType;
    }

    /**
     * @param toanEquipmentType the toanEquipmentType to set
     */
    public void setToanEquipmentType(String toanEquipmentType) {
        this.toanEquipmentType = toanEquipmentType;
    }

    /**
     * @return the toanEquipmentCountry
     */
    public String getToanEquipmentCountry() {
        return toanEquipmentCountry;
    }

    /**
     * @param toanEquipmentCountry the toanEquipmentCountry to set
     */
    public void setToanEquipmentCountry(String toanEquipmentCountry) {
        this.toanEquipmentCountry = toanEquipmentCountry;
    }

    /**
     * @return the toanLanguage
     */
    public String getToanLanguage() {
        return toanLanguage;
    }

    /**
     * @param toanLanguage the toanLanguage to set
     */
    public void setToanLanguage(String toanLanguage) {
        this.toanLanguage = toanLanguage;
    }

    /**
     * @return the toanDeveloper
     */
    public String getToanDeveloper() {
        return toanDeveloper;
    }

    /**
     * @param toanDeveloper the toanDeveloper to set
     */
    public void setToanDeveloper(String toanDeveloper) {
        this.toanDeveloper = toanDeveloper;
    }

    /**
     * @return the toanSize
     */
    public Double getToanSize() {
        return toanSize;
    }

    /**
     * @param toanSize the toanSize to set
     */
    public void setToanSize(Double toanSize) {
        this.toanSize = toanSize;
    }

    /**
     * @return the toanAgeGrading
     */
    public Integer getToanAgeGrading() {
        return toanAgeGrading;
    }

    /**
     * @param toanAgeGrading the toanAgeGrading to set
     */
    public void setToanAgeGrading(Integer toanAgeGrading) {
        this.toanAgeGrading = toanAgeGrading;
    }

    /**
     * @return the toanVersion
     */
    public String getToanVersion() {
        return toanVersion;
    }

    /**
     * @param toanVersion the toanVersion to set
     */
    public void setToanVersion(String toanVersion) {
        this.toanVersion = toanVersion;
    }

    /**
     * @return the toanScore
     */
    public Double getToanScore() {
        return toanScore;
    }

    /**
     * @param toanScore the toanScore to set
     */
    public void setToanScore(Double toanScore) {
        this.toanScore = toanScore;
    }

    /**
     * @return the toanLoadTotals
     */
    public Integer getToanLoadTotals() {
        return toanLoadTotals;
    }

    /**
     * @param toanLoadTotals the toanLoadTotals to set
     */
    public void setToanLoadTotals(Integer toanLoadTotals) {
        this.toanLoadTotals = toanLoadTotals;
    }

    /**
     * @return the toanRemark
     */
    public String getToanRemark() {
        return toanRemark;
    }

    /**
     * @param toanRemark the toanRemark to set
     */
    public void setToanRemark(String toanRemark) {
        this.toanRemark = toanRemark;
    }

    /**
     * @return the toanStatus
     */
    public Integer getToanStatus() {
        return toanStatus;
    }

    /**
     * @param toanStatus the toanStatus to set
     */
    public void setToanStatus(Integer toanStatus) {
        this.toanStatus = toanStatus;
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

    /**
     * @return the applicationLoad
     */
    public ArrayList<ApplicationLoad> getApplicationLoad() {
        return applicationLoad;
    }

    /**
     * @param applicationLoad the applicationLoad to set
     */
    public void setApplicationLoad(ArrayList<ApplicationLoad> applicationLoad) {
        this.applicationLoad = applicationLoad;
    }
   
}

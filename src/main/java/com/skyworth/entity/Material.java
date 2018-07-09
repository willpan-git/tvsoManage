/**
 * 
 */
package com.skyworth.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**   
* Copyright: Copyright (c) 2018 skyworth
* 
* @ClassName: Material.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Administrator
* @date: 2018年5月28日 下午6:08:41 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年5月28日     Administrator           v1.0.0               修改原因
*/
@ApiModel(description = "素材类")
public class Material {
    @ApiModelProperty(value = "素材id",hidden=true)
    private Integer tomdId;
    @ApiModelProperty(value = "素材类型")
    private Integer tomdType;
    @ApiModelProperty(value = "标题名称")
    private String tomdName;
    @ApiModelProperty(value = "布局大小")
    private Integer tomdSize;
    @ApiModelProperty(value = "海报存在url")
    private String tomdPosterUrl;
    @ApiModelProperty(value = "点击事件")
    private Integer tomdClickType;
    @ApiModelProperty(value = "点击内容")
    private String tomdClick;
    @ApiModelProperty(value = "素材版本")
    private String tomdVersion;
    @ApiModelProperty(value = "素材秒速")
    private String tomdRemark;
    @ApiModelProperty(value = "有效性")
    private Integer isenable;
    /**
     * @return the tomdId
     */
    public Integer getTomdId() {
        return tomdId;
    }
    /**
     * @param tomdId the tomdId to set
     */
    public void setTomdId(Integer tomdId) {
        this.tomdId = tomdId;
    }
    /**
     * @return the tomdType
     */
    public Integer getTomdType() {
        return tomdType;
    }
    /**
     * @param tomdType the tomdType to set
     */
    public void setTomdType(Integer tomdType) {
        this.tomdType = tomdType;
    }
    /**
     * @return the tomdName
     */
    public String getTomdName() {
        return tomdName;
    }
    /**
     * @param tomdName the tomdName to set
     */
    public void setTomdName(String tomdName) {
        this.tomdName = tomdName;
    }
    /**
     * @return the tomdSize
     */
    public Integer getTomdSize() {
        return tomdSize;
    }
    /**
     * @param tomdSize the tomdSize to set
     */
    public void setTomdSize(Integer tomdSize) {
        this.tomdSize = tomdSize;
    }
    /**
     * @return the tomdPosterUrl
     */
    public String getTomdPosterUrl() {
        return tomdPosterUrl;
    }
    /**
     * @param tomdPosterUrl the tomdPosterUrl to set
     */
    public void setTomdPosterUrl(String tomdPosterUrl) {
        this.tomdPosterUrl = tomdPosterUrl;
    }
    /**
     * @return the tomdClickType
     */
    public Integer getTomdClickType() {
        return tomdClickType;
    }
    /**
     * @param tomdClickType the tomdClickType to set
     */
    public void setTomdClickType(Integer tomdClickType) {
        this.tomdClickType = tomdClickType;
    }
    /**
     * @return the tomdClick
     */
    public String getTomdClick() {
        return tomdClick;
    }
    /**
     * @param tomdClick the tomdClick to set
     */
    public void setTomdClick(String tomdClick) {
        this.tomdClick = tomdClick;
    }
    /**
     * @return the tomdVersion
     */
    public String getTomdVersion() {
        return tomdVersion;
    }
    /**
     * @param tomdVersion the tomdVersion to set
     */
    public void setTomdVersion(String tomdVersion) {
        this.tomdVersion = tomdVersion;
    }
    /**
     * @return the tomdRemark
     */
    public String getTomdRemark() {
        return tomdRemark;
    }
    /**
     * @param tomdRemark the tomdRemark to set
     */
    public void setTomdRemark(String tomdRemark) {
        this.tomdRemark = tomdRemark;
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

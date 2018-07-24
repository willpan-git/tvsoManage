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
* @ClassName: TV.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Administrator
* @date: 2018年7月20日 下午4:26:13 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年7月20日     Administrator           v1.0.0               修改原因
*/
@ApiModel(description = "TV设备开机返回类，包括开机广告、显示方案")
public class TV {
    @ApiModelProperty(value = "设备id")
    private Integer equipId;
    @ApiModelProperty(value = "广告信息")
    private AdInfo adInfo;
    @ApiModelProperty(value = "主页信息")
    private ArrayList<SchemeInfo> schemeInfo;
    
    
    
    /**
     * @return the equipId
     */
    public Integer getEquipId() {
        return equipId;
    }

    /**
     * @param equipId the equipId to set
     */
    public void setEquipId(Integer equipId) {
        this.equipId = equipId;
    }

    /**
     * @return the adInfo
     */
    public AdInfo getAdInfo() {
        return adInfo;
    }

    /**
     * @param adInfo the adInfo to set
     */
    public void setAdInfo(AdInfo adInfo) {
        this.adInfo = adInfo;
    }

    /**
     * @return the schemeInfo
     */
    public ArrayList<SchemeInfo> getSchemeInfo() {
        return schemeInfo;
    }

    /**
     * @param schemeInfo the schemeInfo to set
     */
    public void setSchemeInfo(ArrayList<SchemeInfo> schemeInfo) {
        this.schemeInfo = schemeInfo;
    }

    /* 非静态的内部类默认的构造函数有一个参数，这个参数指向其外部类的实例,
     * 对于内部类，如果没必要访问外部类，我们可以将其定义为static的*/
    @ApiModel(description = "开机广告信息")
    public static class AdInfo{
	@ApiModelProperty(value = "广告id")
	private Integer adId;
	@ApiModelProperty(value = "广告播放地址")
	private String adUrl;
	/**
	 * @return the adId
	 */
	public Integer getAdId() {
	    return adId;
	}
	/**
	 * @param adId the adId to set
	 */
	public void setAdId(Integer adId) {
	    this.adId = adId;
	}
	/**
	 * @return the adUrl
	 */
	public String getAdUrl() {
	    return adUrl;
	}
	/**
	 * @param adUrl the adUrl to set
	 */
	public void setAdUrl(String adUrl) {
	    this.adUrl = adUrl;
	}	
    }

    /* 非静态的内部类默认的构造函数有一个参数，这个参数指向其外部类的实例,
     * 对于内部类，如果没必要访问外部类，我们可以将其定义为static的*/
    @ApiModel(description = "开机广告信息")
    public static class SchemeInfo{
	@ApiModelProperty(value = "模板id")
	private Integer modelId;
	@ApiModelProperty(value = "模板序号")
	private Integer modelOrder;
	@ApiModelProperty(value = "模板里填充的素材详情")
	private ArrayList<ModelDetail> modelDetail;
	
	
	
	 /**
	 * @return the modelId
	 */
	public Integer getModelId() {
	    return modelId;
	}



	/**
	 * @param modelId the modelId to set
	 */
	public void setModelId(Integer modelId) {
	    this.modelId = modelId;
	}



	/**
	 * @return the modelOrder
	 */
	public Integer getModelOrder() {
	    return modelOrder;
	}



	/**
	 * @param modelOrder the modelOrder to set
	 */
	public void setModelOrder(Integer modelOrder) {
	    this.modelOrder = modelOrder;
	}



	/**
	 * @return the modelDetail
	 */
	public ArrayList<ModelDetail> getModelDetail() {
	    return modelDetail;
	}



	/**
	 * @param modelDetail the modelDetail to set
	 */
	public void setModelDetail(ArrayList<ModelDetail> modelDetail) {
	    this.modelDetail = modelDetail;
	}



	@ApiModel(description = "模板里填充的素材详情")
	 static class ModelDetail{
	     @ApiModelProperty(value = "素材id")
	     private Integer materialId;
	     @ApiModelProperty(value = "素材获取地址")
	     private String materialUrl;
	     @ApiModelProperty(value = "素材序号")
	     private Integer materialOrder;
	    /**
	     * @return the materialId
	     */
	    public Integer getMaterialId() {
	        return materialId;
	    }
	    /**
	     * @param materialId the materialId to set
	     */
	    public void setMaterialId(Integer materialId) {
	        this.materialId = materialId;
	    }
	    /**
	     * @return the materialUrl
	     */
	    public String getMaterialUrl() {
	        return materialUrl;
	    }
	    /**
	     * @param materialUrl the materialUrl to set
	     */
	    public void setMaterialUrl(String materialUrl) {
	        this.materialUrl = materialUrl;
	    }
	    /**
	     * @return the materialOrder
	     */
	    public Integer getMaterialOrder() {
	        return materialOrder;
	    }
	    /**
	     * @param materialOrder the materialOrder to set
	     */
	    public void setMaterialOrder(Integer materialOrder) {
	        this.materialOrder = materialOrder;
	    }
	     
	     
	 }
    }
}

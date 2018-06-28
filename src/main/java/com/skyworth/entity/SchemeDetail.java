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
* @ClassName: SchemeDetail.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Administrator
* @date: 2018年5月25日 下午6:18:54 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年5月25日     Administrator           v1.0.0               修改原因
*/
@ApiModel(description = "方案明细类")
public class SchemeDetail {
    @ApiModelProperty(value = "方案明细id",hidden=true)
    private Integer tosdId;
    @ApiModelProperty(value = "方案主表id")
    private Integer tosdToseId;
    @ApiModelProperty(value = "方案模板id")
    private Integer tosdModelId;
    @ApiModelProperty(value = "方案模板顺序")
    private Integer tosdModelOrder;
    @ApiModelProperty(value = "方案素材类型")
    private String tosdRefType;
    @ApiModelProperty(value = "方案素材id")
    private String tosdRefId;
    @ApiModelProperty(value = "方案素材海报存放地址")
    private ArrayList<String> tosdRefUrlList;
    /**
     * @return the tosdId
     */
    public Integer getTosdId() {
        return tosdId;
    }
    /**
     * @param tosdId the tosdId to set
     */
    public void setTosdId(Integer tosdId) {
        this.tosdId = tosdId;
    }
    /**
     * @return the tosdToseId
     */
    public Integer getTosdToseId() {
        return tosdToseId;
    }
    /**
     * @param tosdToseId the tosdToseId to set
     */
    public void setTosdToseId(Integer tosdToseId) {
        this.tosdToseId = tosdToseId;
    }
    /**
     * @return the tosdModelId
     */
    public Integer getTosdModelId() {
        return tosdModelId;
    }
    /**
     * @param tosdModelId the tosdModelId to set
     */
    public void setTosdModelId(Integer tosdModelId) {
        this.tosdModelId = tosdModelId;
    }
    /**
     * @return the tosdModelOrder
     */
    public Integer getTosdModelOrder() {
        return tosdModelOrder;
    }
    /**
     * @param tosdModelOrder the tosdModelOrder to set
     */
    public void setTosdModelOrder(Integer tosdModelOrder) {
        this.tosdModelOrder = tosdModelOrder;
    }
    /**
     * @return the tosdRefType
     */
    public String getTosdRefType() {
        return tosdRefType;
    }
    /**
     * @param tosdRefType the tosdRefType to set
     */
    public void setTosdRefType(String tosdRefType) {
        this.tosdRefType = tosdRefType;
    }
    /**
     * @return the tosdRefId
     */
    public String getTosdRefId() {
        return tosdRefId;
    }
    /**
     * @param tosdRefId the tosdRefId to set
     */
    public void setTosdRefId(String tosdRefId) {
        this.tosdRefId = tosdRefId;
    }
    /**
     * @return the tosdRefUrlList
     */
    public ArrayList<String> getTosdRefUrlList() {
        return tosdRefUrlList;
    }
    /**
     * @param tosdRefUrlList the tosdRefUrlList to set
     */
    public void setTosdRefUrlList(ArrayList<String> tosdRefUrlList) {
        this.tosdRefUrlList = tosdRefUrlList;
    }
    
    
}

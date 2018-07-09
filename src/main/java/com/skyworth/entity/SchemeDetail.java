/**
 * 
 */
package com.skyworth.entity;

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
    @ApiModelProperty(value = "方案素材id")
    private Integer tosdRefId;
    @ApiModelProperty(value = "方案素材海报存放地址")
    private String tosdRefUrl;
    
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
     * @return the tosdRefId
     */
    public Integer getTosdRefId() {
        return tosdRefId;
    }
    /**
     * @param tosdRefId the tosdRefId to set
     */
    public void setTosdRefId(Integer tosdRefId) {
        this.tosdRefId = tosdRefId;
    }
    /**
     * @return the tosdRefUrl
     */
    public String getTosdRefUrl() {
        return tosdRefUrl;
    }
    /**
     * @param tosdRefUrl the tosdRefUrl to set
     */
    public void setTosdRefUrl(String tosdRefUrl) {
        this.tosdRefUrl = tosdRefUrl;
    }
   
}

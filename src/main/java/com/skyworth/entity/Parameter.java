/**
 * 
 */
package com.skyworth.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**   
* Copyright: Copyright (c) 2018 skyworth
* 
* @ClassName: Parameter.java
* @Description: 参数类
*
* @version: v1.0.0
* @author: Administrator
* @date: 2018年5月23日 下午3:17:55 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年5月23日     Administrator           v1.0.0               修改原因
*/
@ApiModel(description= "参数类") 
public class Parameter {
    @ApiModelProperty(value = "参数id",hidden=true)
    private Integer codeId;
    @ApiModelProperty(value = "参数类型")
    private String codeType;
    @ApiModelProperty(value = "参数代码")
    private String codeCode;
    @ApiModelProperty(value = "参数名称")
    private String codeName;
    @ApiModelProperty(value = "参数描述")
    private String codeDesc;
    @ApiModelProperty(value = "参数排序")
    private Integer codeSeq;
    @ApiModelProperty(value = "有效性")
    private Integer isenable;
    
    
    /**
     * @return the codeId
     */
    public Integer getCodeId() {
        return codeId;
    }
    /**
     * @param codeId the codeId to set
     */
    public void setCodeId(Integer codeId) {
        this.codeId = codeId;
    }
    /**
     * @return the codeType
     */
    public String getCodeType() {
        return codeType;
    }
    /**
     * @param codeType the codeType to set
     */
    public void setCodeType(String codeType) {
        this.codeType = codeType;
    }
    /**
     * @return the codeCode
     */
    public String getCodeCode() {
        return codeCode;
    }
    /**
     * @param codeCode the codeCode to set
     */
    public void setCodeCode(String codeCode) {
        this.codeCode = codeCode;
    }
    /**
     * @return the codeName
     */
    public String getCodeName() {
        return codeName;
    }
    /**
     * @param codeName the codeName to set
     */
    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }
    /**
     * @return the codeDesc
     */
    public String getCodeDesc() {
        return codeDesc;
    }
    /**
     * @param codeDesc the codeDesc to set
     */
    public void setCodeDesc(String codeDesc) {
        this.codeDesc = codeDesc;
    }
    /**
     * @return the codeSeq
     */
    public Integer getCodeSeq() {
        return codeSeq;
    }
    /**
     * @param codeSeq the codeSeq to set
     */
    public void setCodeSeq(Integer codeSeq) {
        this.codeSeq = codeSeq;
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

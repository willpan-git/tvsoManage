/**
 * 
 */
package com.skyworth.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**   
* Copyright: Copyright (c) 2018 skyworth
* 
* @ClassName: ApplicationLoad.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Administrator
* @date: 2018年6月12日 上午10:45:20 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年6月12日     Administrator           v1.0.0               修改原因
*/
@ApiModel(description = "app应用下载量类")
public class ApplicationLoad {
    @ApiModelProperty(value = "记录id",hidden=true)
    private Integer toalId;
    @ApiModelProperty(value = "关联应用管理表id",hidden=true)
    private Integer toalToanId;
    @ApiModelProperty(value = "年")
    private Integer toalYear;
    @ApiModelProperty(value = "月")
    private Integer toalMonth;
    @ApiModelProperty(value = "周")
    private Integer toalWeek;
    @ApiModelProperty(value = "本周下载量")
    private Integer toalLoadNum;
    /**
     * @return the toalId
     */
    public Integer getToalId() {
        return toalId;
    }
    /**
     * @param toalId the toalId to set
     */
    public void setToalId(Integer toalId) {
        this.toalId = toalId;
    }
    /**
     * @return the toalToanId
     */
    public Integer getToalToanId() {
        return toalToanId;
    }
    /**
     * @param toalToanId the toalToanId to set
     */
    public void setToalToanId(Integer toalToanId) {
        this.toalToanId = toalToanId;
    }
    /**
     * @return the toalYear
     */
    public Integer getToalYear() {
        return toalYear;
    }
    /**
     * @param toalYear the toalYear to set
     */
    public void setToalYear(Integer toalYear) {
        this.toalYear = toalYear;
    }
    /**
     * @return the toalMonth
     */
    public Integer getToalMonth() {
        return toalMonth;
    }
    /**
     * @param toalMonth the toalMonth to set
     */
    public void setToalMonth(Integer toalMonth) {
        this.toalMonth = toalMonth;
    }
    
    /**
     * @return the toalWeek
     */
    public Integer getToalWeek() {
        return toalWeek;
    }
    /**
     * @param toalWeek the toalWeek to set
     */
    public void setToalWeek(Integer toalWeek) {
        this.toalWeek = toalWeek;
    }
    /**
     * @return the toalLoadNum
     */
    public Integer getToalLoadNum() {
        return toalLoadNum;
    }
    /**
     * @param toalLoadNum the toalLoadNum to set
     */
    public void setToalLoadNum(Integer toalLoadNum) {
        this.toalLoadNum = toalLoadNum;
    }
    
}

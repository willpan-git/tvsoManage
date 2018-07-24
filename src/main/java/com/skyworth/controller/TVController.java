/**
 * 
 */
package com.skyworth.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skyworth.entity.Equip;
import com.skyworth.entity.Parameter;
import com.skyworth.entity.Result;
import com.skyworth.entity.ResultEnum;
import com.skyworth.entity.TV;
import com.skyworth.exception.MyRuntimeException;
import com.skyworth.service.ApplicationService;
import com.skyworth.service.BaseInfoService;
import com.skyworth.service.EquipService;
import com.skyworth.service.PublicService;
import com.skyworth.service.TVService;
import com.skyworth.util.LogUtil;
import com.skyworth.util.ResultUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**   
* Copyright: Copyright (c) 2018 skyworth
* 
* @ClassName: TVController.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Administrator
* @date: 2018年7月20日 下午1:49:39 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年7月20日     Administrator           v1.0.0               修改原因
*/
@Api(value = "API - TV",description = "TV设备API", protocols = "json", tags = { "TV" })
@RestController
@RequestMapping("/tvmanage/tv")
@Transactional(rollbackFor = { Exception.class })
public class TVController {
    @Autowired
    private EquipService equipService;
    
    @Autowired
    private TVService tvService;
    
    @Autowired
    private BaseInfoService baseInfoService;
    
    @Autowired
    private PublicService publicService;
    
    @Autowired
    private ApplicationService applicationService;

    @ApiOperation(value = "TV开机数据服务", notes = "根据机芯、机型、使用国家获取开机广告，界面显示方案")
    @ApiImplicitParams({
	    @ApiImplicitParam(name = "core", value = "机芯", required = true, dataType = "String", paramType = "query"),
	    @ApiImplicitParam(name = "type", value = "机型", required = true, dataType = "String", paramType = "query"),
	    @ApiImplicitParam(name = "country", value = "使用国家", required = true, dataType = "String", paramType = "query")})
    @ApiResponses({ @ApiResponse(code = 0101, message = "获取设备信息失败！"),
		@ApiResponse(code = 0102, message = "服务器未响应！"),
	    @ApiResponse(code = 0103, message = "执行异常，请联系管理员！") })
    @RequestMapping(value = { "/action" }, method = RequestMethod.GET)
    public Result<?> action(@RequestParam(value = "core") String core,@RequestParam(value = "type") String type
	    ,@RequestParam(value = "country") String country){
	TV tv = new TV();
	// 判断设备是否存在
	Integer equipTemp = equipService.checkEquipExists(core,type,country);
	if (equipTemp == null || equipTemp == 0) {
	    // 完善设备信息
	    Equip equip = new Equip();
	    
	    equip.setToeiEquipmentName("系统录入");
	    equip.setToeiEquipmentCode(country+"-"+core+"-"+type);
	    equip.setToeiEquipmentCore(core);
	    equip.setToeiEquipmentType(type);
	    equip.setToeiEquipmentCountry(country);
	    equip.setIsenable(1);
	    
	    // 获取默认设计方案
	    Map<String, Object> map = new HashMap<String, Object>();
	    map = equipService.getDefaultScheme(core,type,country).get("data");
	    Integer DefaultScheme = (Integer)map.get("toseId");
	    equip.setToeiDefaultScheme(DefaultScheme); 
	    
	    // 新增设备
	    equipService.addEquip(equip);
	    
	    // 机芯新增参数 
	    Integer parameterTemp = baseInfoService.checkParameterExists("equip_core",core);
	    if (parameterTemp == null || parameterTemp == 0) {
		// 完善参数信息
		Parameter parameter = new Parameter();
		parameter.setCodeType("equip_core");
		parameter.setCodeCode(core);
		parameter.setCodeName(core);
		parameter.setCodeDesc("系统插入");
		// 新增参数
		baseInfoService.addParameterCode(parameter);
	    }
	    
	    // 机型新增参数 
	    Integer parameterTemp2 = baseInfoService.checkParameterExists("equip_type",type);
	    if (parameterTemp2 == null || parameterTemp2 == 0) {
		// 完善参数信息
		Parameter parameter = new Parameter();
		parameter.setCodeType("equip_type");
		parameter.setCodeCode(type);
		parameter.setCodeName(type);
		parameter.setCodeDesc("系统插入");
		// 新增参数
		baseInfoService.addParameterCode(parameter);
	    }
	    
	    // 国家新增参数 
	    Integer parameterTemp3 = baseInfoService.checkParameterExists("country",country);
	    if (parameterTemp3 == null || parameterTemp3 == 0) {
		// 完善参数信息
		Parameter parameter = new Parameter();
		parameter.setCodeType("country");
		parameter.setCodeCode(country);
		parameter.setCodeName(country);
		parameter.setCodeDesc("系统插入");
		// 新增参数
		baseInfoService.addParameterCode(parameter);
	    }
	    
	    // 获取tv设备信息
	    Integer equipTemp2 = equipService.checkEquipExists(core,type,country);
	    tv = tvService.queryTVInfo(equipTemp2);
	    
	}
	else
	{
	    // 获取tv设备信息
	    tv = tvService.queryTVInfo(equipTemp);	    	    
	}
	// 返回信息
	ResultEnum resultEnum = ResultEnum.SUCCESS;
	return ResultUtil.getSuccess(resultEnum.getCode(), resultEnum.getMsg(), tv);	
    }
    
    @ApiOperation(value = "应用每下载一次更新下载数量", notes = "应用每下载一次更新下载数量")
    @ApiImplicitParams({
	    @ApiImplicitParam(name = "dateStr", value = "当前日期，例：2018-06-14", required = true, dataType = "String", paramType = "query"),
	    @ApiImplicitParam(name = "toanId", value = "应用id", required = true, dataType = "Integer", paramType = "query") })
    @RequestMapping(value = { "/updateApplicationLoad" }, method = RequestMethod.POST)
    public void updateApplicationLoad(String dateStr, Integer toanId) {
	// 将当前日期进行转化
	try {
	    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	    Date date = format.parse(dateStr);
	    Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);

	    Integer year = calendar.get(Calendar.YEAR);
	    Integer month = calendar.get(Calendar.MONTH) + 1;
	    Integer weekOfYear = publicService.getWeekOfYear(dateStr);

	    // 先查询系统是否存在当前日期的数据，没有的话先插入
	    applicationService.updateApplicationLoad(year, month, weekOfYear, toanId);
	} catch (Exception e) {
	    // 打印错误日志
	    LogUtil.printLog(e, Exception.class);
	    // 抛出错误
	    throw new MyRuntimeException(ResultEnum.DBException);
	}
    }
}

/**
 * 
 */
package com.skyworth.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.skyworth.entity.Application;
import com.skyworth.entity.Result;
import com.skyworth.entity.ResultEnum;
import com.skyworth.exception.MyRuntimeException;
import com.skyworth.service.ApplicationService;
import com.skyworth.util.LogUtil;
import com.skyworth.util.ResultUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * Copyright: Copyright (c) 2018 skyworth
 * 
 * @ClassName: ApplicationController.java
 * @Description: APP应用管理控制层
 *
 * @version: v1.0.0
 * @author: Administrator
 * @date: 2018年6月14日 下午3:49:12
 *
 *        Modification History: Date Author Version Description
 *        ---------------------------------------------------------* 2018年6月14日
 *        Administrator v1.0.0 修改原因
 */
@Api(value = "API - APPController", description = "应用管理API", protocols = "json", tags = { "APP" })
@RestController
@RequestMapping("/tvmanage/app")
public class ApplicationController {
    @Autowired
    private ApplicationService applicationService;

    @ApiOperation(value = "查询应用列表", notes = "返回信息中包含分页的相关信息，json格式")
    @ApiImplicitParam(name = "map", value = "查询条件：应用类型，应用名称", required = false, dataType = "Map", paramType = "query")
    @RequestMapping(value = { "/queryApplicationList" }, method = RequestMethod.GET)
    public Result<?> queryApplicationList(@RequestParam(required = false) Map<String, Object> map) {
	int pageNum = 1;
	int pageSize = 10;
	if (map != null && map.get("pageNum") != null) {
	    pageNum = Integer.parseInt(map.get("pageNum").toString());
	}
	if (map != null && map.get("pageSize") != null) {
	    pageSize = Integer.parseInt(map.get("pageSize").toString());
	}

	PageHelper.startPage(pageNum, pageSize);
	List<HashMap<String, Object>> list = applicationService.queryApplicationList(map);
	PageInfo<HashMap<String, Object>> pageList = new PageInfo<HashMap<String, Object>>(list);

	// 返回信息
	ResultEnum resultEnum = ResultEnum.SUCCESS;
	return ResultUtil.getSuccess(resultEnum.getCode(), resultEnum.getMsg(), pageList);
    }

    @ApiOperation(value = "根据id查询应用信息", notes = "根据id查询应用信息")
    @ApiImplicitParam(name = "toanId", value = "应用id", required = true, dataType = "int", paramType = "query")
    @RequestMapping(value = { "/queryApplicationById" }, method = RequestMethod.GET)
    public Result<?> queryApplicationById(Integer toanId) {
	Application application = applicationService.queryApplicationById(toanId);
	if (application == null) {
	    // 没有查询到数据
	    throw new MyRuntimeException(ResultEnum.NoDataSuccess);
	}
	// 返回信息
	ResultEnum resultEnum = ResultEnum.SUCCESS;
	return ResultUtil.getSuccess(resultEnum.getCode(), resultEnum.getMsg(), application);
    }

    @ApiOperation(value = "新增应用", notes = "新增应用信息")
    @ApiImplicitParam(name = "application", value = "应用实体类", required = true, dataType = "Application")
    @RequestMapping(value = { "/addApplication" }, method = RequestMethod.POST)
    public Result<?> addApplication(@RequestBody(required = true) Application application) {
	applicationService.addApplication(application);
	// 新增成功后打印日志信息
	LogUtil.printLog("新增应用成功!应用名称:" + application.getToanName());
	// 新增成功提示信息(从枚举类里获取)
	ResultEnum resultEnum = ResultEnum.AddSuccess;
	return ResultUtil.getSuccess(resultEnum.getCode(), resultEnum.getMsg(), "");
    }

    @ApiOperation(value = "修改应用", notes = "修改应用信息")
    @ApiImplicitParam(name = "application", value = "应用实体类", required = true, dataType = "Application")
    @RequestMapping(value = { "/updateApplication" }, method = RequestMethod.POST)
    public Result<?> updateApplication(@RequestBody(required = true) Application application) {
	Application applicationTemp = applicationService.queryApplicationById(application.getToanId());
	if (applicationTemp == null) {
	    // 没有查询到数据
	    throw new MyRuntimeException(ResultEnum.UnknowSchemeException);
	} else {
	    // 调用更新方法
	    applicationService.updateApplication(application);

	    // 更新成功后打印日志信息
	    LogUtil.printLog("新增应用成功!应用名称:" + application.getToanName());
	    // 更新成功提示信息(从枚举类里获取)
	    ResultEnum resultEnum = ResultEnum.UpdateSuccess;
	    return ResultUtil.getSuccess(resultEnum.getCode(), resultEnum.getMsg(), "");
	}
    }

    @ApiOperation(value = "删除应用", notes = "删除应用")
    @ApiImplicitParam(name = "toanId", value = "应用id", required = true, dataType = "Integer", paramType = "query")
    @RequestMapping(value = { "/deleteApplication" }, method = RequestMethod.DELETE)
    public Result<?> deleteApplication(Integer toanId) {
	Application applicationTemp = applicationService.queryApplicationById(toanId);
	if (applicationTemp == null) {
	    // 没有查询到数据
	    throw new MyRuntimeException(ResultEnum.UnknowSchemeException);
	} else {
	    // 调用更新方法
	    applicationService.deleteApplication(toanId);
	    // 更新成功后打印日志信息
	    LogUtil.printLog("新增应用成功!应用名称:" + applicationTemp.getToanName());
	    // 更新成功提示信息(从枚举类里获取)
	    ResultEnum resultEnum = ResultEnum.UpdateSuccess;
	    return ResultUtil.getSuccess(resultEnum.getCode(), resultEnum.getMsg(), "");
	}
    }

    @ApiOperation(value = "下架应用", notes = "下架应用")
    @ApiImplicitParam(name = "toanId", value = "应用id", required = true, dataType = "Integer", paramType = "query")
    @RequestMapping(value = { "/unableApplication" }, method = RequestMethod.POST)
    public Result<?> unableApplication(Integer toanId) {
	Application applicationTemp = applicationService.queryApplicationById(toanId);
	if (applicationTemp == null) {
	    // 没有查询到数据
	    throw new MyRuntimeException(ResultEnum.UnknowSchemeException);
	} else {
	    // 调用更新方法
	    applicationService.unableApplication(toanId);
	    // 更新成功后打印日志信息
	    LogUtil.printLog("下架应用成功!应用名称:" + applicationTemp.getToanName());
	    // 更新成功提示信息(从枚举类里获取)
	    ResultEnum resultEnum = ResultEnum.DownSuccess;
	    return ResultUtil.getSuccess(resultEnum.getCode(), resultEnum.getMsg(), "");
	}
    }

    @ApiOperation(value = "上架应用", notes = "上架应用")
    @ApiImplicitParam(name = "toanId", value = "应用id", required = true, dataType = "Integer", paramType = "query")
    @RequestMapping(value = { "/effectApplication" }, method = RequestMethod.POST)
    public Result<?> effectApplication(Integer toanId) {
	Application applicationTemp = applicationService.queryApplicationById(toanId);
	if (applicationTemp == null) {
	    // 没有查询到数据
	    throw new MyRuntimeException(ResultEnum.UnknowSchemeException);
	} else {
	    // 调用更新方法
	    applicationService.effectApplication(toanId);
	    // 更新成功后打印日志信息
	    LogUtil.printLog("上架应用成功!应用名称:" + applicationTemp.getToanName());
	    // 更新成功提示信息(从枚举类里获取)
	    ResultEnum resultEnum = ResultEnum.UpSuccess;
	    return ResultUtil.getSuccess(resultEnum.getCode(), resultEnum.getMsg(), "");
	}
    }

    @ApiOperation(value = "查询app类型百分比", notes = "保留2位小数")
    @RequestMapping(value = { "/queryAppTypePercentList" }, method = RequestMethod.GET)
    public Result<?> queryAppTypePercentList() {
	try {
	    // 返回信息
	    ResultEnum resultEnum = ResultEnum.SUCCESS;
	    return ResultUtil.getSuccess(resultEnum.getCode(), resultEnum.getMsg(),
		    applicationService.queryAppTypePercentList());

	} catch (Exception e) {
	    // 打印错误日志
	    LogUtil.printLog(e, Exception.class);
	    // 抛出错误
	    throw new MyRuntimeException(ResultEnum.DBException);
	}
    }

    @ApiOperation(value = "查询app每月点击量", notes = "查询往前的6个月")
    @ApiImplicitParam(name = "idx", value = "应用id集合,例 10,11,12", required = true, dataType = "String", paramType = "query")
    @RequestMapping(value = { "/queryAppLoadDetailsByMonth" }, method = RequestMethod.GET)
    public Result<?> queryAppLoadDetailsByMonth(String idx) {
	try {
	    // 返回信息
	    ResultEnum resultEnum = ResultEnum.SUCCESS;
	    return ResultUtil.getSuccess(resultEnum.getCode(), resultEnum.getMsg(),
		    applicationService.queryAppLoadDetailsByMonth(idx));
	} catch (Exception e) {
	    // 打印错误日志
	    LogUtil.printLog(e, Exception.class);
	    // 抛出错误
	    throw new MyRuntimeException(ResultEnum.DBException);
	}
    }

    @ApiOperation(value = "查询app每周点击量", notes = "查询往前的6个星期")
    @ApiImplicitParam(name = "idx", value = "应用id集合,例 10,11,12", required = true, dataType = "String", paramType = "query")
    @RequestMapping(value = { "/queryAppLoadDetailsByWeek" }, method = RequestMethod.GET)
    public Result<?> queryAppLoadDetailsByWeek(String idx) {
	try {
	    // 返回信息
	    ResultEnum resultEnum = ResultEnum.SUCCESS;
	    return ResultUtil.getSuccess(resultEnum.getCode(), resultEnum.getMsg(),
		    applicationService.queryAppLoadDetailsByWeek(idx));
	} catch (Exception e) {
	    // 打印错误日志
	    LogUtil.printLog(e, Exception.class);
	    // 抛出错误
	    throw new MyRuntimeException(ResultEnum.DBException);
	}
    }
}

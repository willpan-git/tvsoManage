/**
 * 
 */
package com.skyworth.controller;

import java.util.List;
import java.util.Map;

import javax.validation.constraints.Null;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.skyworth.entity.Parameter;
import com.skyworth.entity.Result;
import com.skyworth.entity.ResultEnum;
import com.skyworth.service.BaseInfoService;
import com.skyworth.util.LogUtil;
import com.skyworth.util.ResultUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * Copyright: Copyright (c) 2018 skyworth
 * 
 * @ClassName: PublicController.java
 * @Description: 基础数据处理的控制层
 *
 * @version: v1.0.0
 * @author: Administrator
 * @date: 2018年5月23日 下午3:12:07
 *
 *        Modification History: Date Author Version Description
 *        ---------------------------------------------------------* 2018年5月23日
 *        Administrator v1.0.0 修改原因
 */
@Api(value = "API - BaseInfoController",description = "基础数据管理API", protocols = "json", tags = "BaseInfo")
@RestController
@RequestMapping("/tvmanage/baseinfo")
public class BaseInfoController {
    @Autowired
    private BaseInfoService baseInfoService;

    @ApiOperation(value = "新增基础数据", notes = "新增基础数据")
    @ApiImplicitParam(name = "parameter", value = "参数类", required = true, dataType = "Parameter")
    @RequestMapping(value = { "/addParameterCode" }, method = RequestMethod.POST)
    public Result<Null> addParameterCode(@RequestBody(required = true) Parameter parameter) {
	// 新增
	baseInfoService.addParameterCode(parameter);
	// 新增成功后打印日志信息
	LogUtil.printLog("新增参数成功!编码:" + parameter.getCodeCode() + " 名称:" + parameter.getCodeName());
	// 新增成功提示信息(从枚举类里获取)
	ResultEnum resultEnum = ResultEnum.AddSuccess;
	return ResultUtil.getMsg(resultEnum.getCode(), resultEnum.getMsg());
    }

    @ApiOperation(value = "修改基础数据", notes = "修改基础数据")
    @ApiImplicitParam(name = "parameter", value = "参数类", required = true, dataType = "Parameter")
    @RequestMapping(value = { "/updateParameterCode" }, method = RequestMethod.POST)
    public Result<Null> updateParameterCode(@RequestBody(required = true) Parameter parameter) {
	// 修改
	baseInfoService.updateParameterCode(parameter);
	// 修改成功后打印日志信息
	LogUtil.printLog("修改修改成功!编码:" + parameter.getCodeCode() + " 名称:" + parameter.getCodeName());
	// 修改成功提示信息(从枚举类里获取)
	ResultEnum resultEnum = ResultEnum.UpdateSuccess;
	return ResultUtil.getMsg(resultEnum.getCode(), resultEnum.getMsg());
    }

    @ApiOperation(value = "失效单笔基础数据", notes = "失效单笔基础数据")
    @ApiImplicitParam(name = "codeId", value = "参数id", required = true, dataType = "Integer", paramType = "query")
    @RequestMapping(value = { "/unableParameterCode" }, method = RequestMethod.POST)
    public Result<Null> unableParameterCode(Integer codeId) {
	// 失效
	baseInfoService.unableParameterCode(codeId);
	// 失效成功打印日志信息
	LogUtil.printLog("失效参数 成功!参数id：" + codeId);
	// 失效成功提示信息(从枚举类里获取)
	ResultEnum resultEnum = ResultEnum.UnableSuccess;
	return ResultUtil.getMsg(resultEnum.getCode(), resultEnum.getMsg());
    }
    
    @ApiOperation(value = "生效单笔基础数据", notes = "生效单笔基础数据")
    @ApiImplicitParam(name = "codeId", value = "参数id", required = true, dataType = "Integer", paramType = "query")
    @RequestMapping(value = { "/effectParameterCode" }, method = RequestMethod.POST)
    public Result<Null> effectParameterCode(Integer codeId) {
	// 生效
	baseInfoService.effectParameterCode(codeId);
	// 失效成功打印日志信息
	LogUtil.printLog("生效参数 成功!参数id：" + codeId);
	// 失效成功提示信息(从枚举类里获取)
	ResultEnum resultEnum = ResultEnum.EffectSuccess;
	return ResultUtil.getMsg(resultEnum.getCode(), resultEnum.getMsg());
    }

    @ApiOperation(value = "删除单笔基础数据", notes = "删除单笔基础数据")
    @ApiImplicitParam(name = "codeId", value = "参数id", required = true, dataType = "Integer", paramType = "query")
    @RequestMapping(value = { "/deleteParameterCode" }, method = RequestMethod.DELETE)
    public Result<Null> deleteParameterCode(Integer codeId) {
	baseInfoService.deleteParameterCode(codeId);
	// 刪除成功打印日志信息
	LogUtil.printLog("删除参数苏 成功!参数id：" + codeId);
	// 刪除成功提示信息(从枚举类里获取)
	ResultEnum resultEnum = ResultEnum.DeleteSuccess;
	return ResultUtil.getMsg(resultEnum.getCode(), resultEnum.getMsg());
    }
    
    @ApiOperation(value = "根据参数id查询参数信息", notes = "根据参数id查询参数信息")
    @ApiImplicitParam(name = "codeId", value = "参数id", required = true, dataType = "Integer", paramType = "query")
    @RequestMapping(value = { "/fingParameterById" }, method = RequestMethod.GET)
    public Parameter fingParameterById(Integer codeId) {
	return baseInfoService.findParameterById(codeId);
    }
    
    @ApiOperation(value = "查询参数列表", notes = "返回信息中包含分页的相关信息，json格式")
    @ApiImplicitParam(name = "map", value = "多种查询条件", required = false, dataType = "Map", paramType = "query")
    @RequestMapping(value = { "/queryParameterList" }, method = RequestMethod.GET)
    public PageInfo<Parameter> queryParameterList(@RequestParam(required = false) Map<String, Object> map){
	int pageNum = 1;
	int pageSize = 10;
	if (map != null && map.get("pageNum") != null) {
	    pageNum = Integer.parseInt(map.get("pageNum").toString());
	}
	if (map != null && map.get("pageSize") != null) {
	    pageSize = Integer.parseInt(map.get("pageSize").toString());
	}

	PageHelper.startPage(pageNum, pageSize);
	List<Parameter> list = baseInfoService.queryParameterList(map);
	PageInfo<Parameter> pageList = new PageInfo<Parameter>(list);
	return pageList;
    }
}

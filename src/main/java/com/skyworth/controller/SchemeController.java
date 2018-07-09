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
import com.skyworth.entity.ResultEnum;
import com.skyworth.entity.Scheme;
import com.skyworth.exception.MyException;
import com.skyworth.service.SchemeService;
import com.skyworth.util.LogUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * Copyright: Copyright (c) 2018 skyworth
 * 
 * @ClassName: SchemeController.java
 * @Description: 方案相关逻辑控制层
 *
 * @version: v1.0.0
 * @author: Administrator
 * @date: 2018年5月22日 上午11:36:56
 *
 *        Modification History: Date Author Version Description
 *        ---------------------------------------------------------* 2018年5月22日
 *        Administrator v1.0.0 修改原因
 */
@Api(value = "API - UserController", protocols = "json", tags = { "Scheme" })
@RestController
public class SchemeController {

    @Autowired
    private SchemeService schemeService;

    @ApiOperation(value = "查询方案列表", notes = "返回信息中包含分页的相关信息，json格式")
    @ApiImplicitParam(name = "map", value = "多种查询条件", required = false, dataType = "Map", paramType = "query")
    @RequestMapping(value = { "/querySchemeList" }, method = RequestMethod.GET)
    public PageInfo<HashMap<String, Object>> querySchemeList(@RequestParam(required = false) Map<String, Object> map) {
	int pageNum = 1;
	int pageSize = 10;
	if (map != null && map.get("pageNum") != null) {
	    pageNum = (int) map.get("pageNum");
	}
	if (map != null && map.get("pageSize") != null) {
	    pageSize = (int) map.get("pageSize");
	}

	PageHelper.startPage(pageNum, pageSize);
	List<HashMap<String, Object>> list = schemeService.querySchemeList(map);
	PageInfo<HashMap<String, Object>> pageList = new PageInfo<HashMap<String, Object>>(list);
	return pageList;
    }

    @ApiOperation(value = "根据id查询方案信息", notes = "根据id查询方案信息")
    @ApiImplicitParam(name = "toseId", value = "方案id", required = true, dataType = "Integer", paramType = "query")
    @RequestMapping(value = { "/findSchemeById" }, method = RequestMethod.GET)
    public Scheme findSchemeById(Integer toseId) {
	Scheme scheme = schemeService.findSchemeById(toseId);
	if (scheme == null) {
	    // 没有查询到数据
	    throw new MyException(ResultEnum.NoDataSuccess);
	}
	return scheme;
    }

    @ApiOperation(value = "新增方案", notes = "新增方案信息")
    @ApiImplicitParam(name = "scheme", value = "方案实体类", required = true, dataType = "Scheme")
    @RequestMapping(value = { "/addScheme" }, method = RequestMethod.POST)
    public void addScheme(@RequestBody(required = true) Scheme scheme) {
	
	schemeService.addScheme(scheme);
	// 新增成功后打印日志信息
	LogUtil.printLog("新增方案成功!方案名称:" + scheme.getToseCode() + " 方案编码:" + scheme.getToseName());
	// 新增成功提示信息(从枚举类里获取)
	throw new MyException(ResultEnum.AddSuccess);
    }
    
    @ApiOperation(value = "修改方案", notes = "修改方案信息")
    @ApiImplicitParam(name = "scheme", value = "方案实体类", required = true, dataType = "Scheme")
    @RequestMapping(value = { "/updateScheme" }, method = RequestMethod.POST)
    public void updateScheme(@RequestBody(required = true) Scheme scheme) {
	Scheme schemeTemp = schemeService.findSchemeById(scheme.getToseId());
	if (schemeTemp == null) {
	    // 没有查询到数据
	    throw new MyException(ResultEnum.UnknowSchemeException);
	}else {
	    // 调用更新方法
	    schemeService.updateScheme(scheme);
	    // 更新成功后打印日志信息
	    LogUtil.printLog("修改方案成功!方案名称:" + scheme.getToseName() + " 方案编码:" + scheme.getToseCode());
	    // 更新成功提示信息(从枚举类里获取)
	    throw new MyException(ResultEnum.UpdateSuccess);
	}
    }
    
    @ApiOperation(value = "删除方案", notes = "删除方案")
    @ApiImplicitParam(name = "toseId", value = "方案id", required = true, dataType = "Integer")
    @RequestMapping(value = { "/deleteScheme" }, method = RequestMethod.DELETE)
    public void deleteScheme(Integer toseId) {
	Scheme schemeTemp = schemeService.findSchemeById(toseId);
	if (schemeTemp == null) {
	    // 没有查询到数据
	    throw new MyException(ResultEnum.UnknowSchemeException);
	}else {
	    // 调用方法
	    schemeService.deleteScheme(toseId);
	    // 更新成功后打印日志信息
	    LogUtil.printLog("删除方案成功!方案名称:" + schemeTemp.getToseName() + " 方案编码:" + schemeTemp.getToseCode());
	    // 更新成功提示信息(从枚举类里获取)
	    throw new MyException(ResultEnum.DeleteSuccess);
	}
    }
    
    @ApiOperation(value = "失效方案", notes = "失效方案")
    @ApiImplicitParam(name = "toseId", value = "方案id", required = true, dataType = "Integer")
    @RequestMapping(value = { "/unableScheme" }, method = RequestMethod.POST)
    public void unableScheme(Integer toseId) {
	Scheme schemeTemp = schemeService.findSchemeById(toseId);
	if (schemeTemp == null) {
	    // 没有查询到数据
	    throw new MyException(ResultEnum.UnknowSchemeException);
	}else {
	    // 调用方法
	    schemeService.unableScheme(toseId);
	    // 更新成功后打印日志信息
	    LogUtil.printLog("失效方案成功!方案名称:" + schemeTemp.getToseName() + " 方案编码:" + schemeTemp.getToseCode());
	    // 更新成功提示信息(从枚举类里获取)
	    throw new MyException(ResultEnum.UnableSuccess);
	}
    }
    
    @ApiOperation(value = "生效方案", notes = "生效方案")
    @ApiImplicitParam(name = "toseId", value = "方案id", required = true, dataType = "Integer")
    @RequestMapping(value = { "/effectScheme" }, method = RequestMethod.POST)
    public void effectScheme(Integer toseId) {
	Scheme schemeTemp = schemeService.findSchemeById(toseId);
	if (schemeTemp == null) {
	    // 没有查询到数据
	    throw new MyException(ResultEnum.UnknowSchemeException);
	}else {
	    // 调用方法
	    schemeService.effectScheme(toseId);
	    // 更新成功后打印日志信息
	    LogUtil.printLog("生效方案成功!方案名称:" + schemeTemp.getToseName() + " 方案编码:" + schemeTemp.getToseCode());
	    // 更新成功提示信息(从枚举类里获取)
	    throw new MyException(ResultEnum.EffectSuccess);
	}
    }
}

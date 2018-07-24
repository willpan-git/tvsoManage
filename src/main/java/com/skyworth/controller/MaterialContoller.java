/**
 * 
 */
package com.skyworth.controller;

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
import com.skyworth.entity.Material;
import com.skyworth.entity.Result;
import com.skyworth.entity.ResultEnum;
import com.skyworth.exception.MyRuntimeException;
import com.skyworth.service.MaterialService;
import com.skyworth.util.LogUtil;
import com.skyworth.util.ResultUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * Copyright: Copyright (c) 2018 skyworth
 * 
 * @ClassName: MaterialContoller.java
 * @Description: 该类的功能描述
 *
 * @version: v1.0.0
 * @author: Administrator
 * @date: 2018年5月28日 下午6:08:21
 *
 *        Modification History: Date Author Version Description
 *        ---------------------------------------------------------* 2018年5月28日
 *        Administrator v1.0.0 修改原因
 */
@Api(value = "API - MaterialContoller",description = "素材管理API", protocols = "json", tags = "Material")
@RestController
@RequestMapping("/tvmanage/material")
public class MaterialContoller {
    @Autowired
    private MaterialService materialService;

    // 查询接口
    @ApiOperation(value = "查询素材列表", notes = "返回信息中包含分页的相关信息，json格式")
    @ApiImplicitParam(name = "map", value = "多种查询条件", required = false, dataType = "Map", paramType = "query")
    @RequestMapping(value = { "/queryMaterialList" }, method = RequestMethod.GET)
    public Result<?> queryMaterialList(@RequestParam(required = false) Map<String, Object> map) {
	int pageNum = 1;
	int pageSize = 10;
	if (map != null && map.get("pageNum") != null) {
	    pageNum = Integer.parseInt(map.get("pageNum").toString());
	}
	if (map != null && map.get("pageSize") != null) {
	    pageSize = Integer.parseInt(map.get("pageSize").toString());
	}

	PageHelper.startPage(pageNum, pageSize);
	List<Material> list = materialService.queryMaterialList(map);
	PageInfo<Material> pageList = new PageInfo<Material>(list);
	
	// 返回信息
	ResultEnum resultEnum = ResultEnum.SUCCESS;
	return ResultUtil.getSuccess(resultEnum.getCode(), resultEnum.getMsg(), pageList);
    }
    
    // 根据素材id查询素材相关信息
    @ApiOperation(value = "根据素材id查询素材相关信息", notes = "根据素材id查询素材相关信息")
    @ApiImplicitParam(name = "tomdId", value = "素材id", required = true, dataType = "Integer", paramType = "query")
    @RequestMapping(value = { "/findMaterialById" }, method = RequestMethod.GET)
    public Result<?> findMaterialById(Integer tomdId) {
	Material material = materialService.findMaterialById(tomdId);
	if (material == null) {
	    // 没有查询到数据
	    throw new MyRuntimeException(ResultEnum.NoDataSuccess);
	}
	// 返回信息
	ResultEnum resultEnum = ResultEnum.SUCCESS;
	return ResultUtil.getSuccess(resultEnum.getCode(), resultEnum.getMsg(),material);
	
    }

    // 新增接口
    @ApiOperation(value = "新增素材", notes = "新增素材")
    @ApiImplicitParam(name = "material", value = "素材详细实体类material", required = true, dataType = "Material")
    @RequestMapping(value = { "/addMaterial" }, method = RequestMethod.POST)
    public Result<?> addMaterial(@RequestBody(required = true) Material material) {
	// 调用方法
	materialService.addMaterial(material);
	// 新增成功后打印日志信息
	LogUtil.printLog("新增素材成功!名称:" + material.getTomdName());
	// 新增成功提示信息(从枚举类里获取)
	ResultEnum resultEnum = ResultEnum.AddSuccess;
	return ResultUtil.getSuccess(resultEnum.getCode(), resultEnum.getMsg(),"");
    }

    // 修改接口
    @ApiOperation(value = "修改素材相关信息", notes = "修改素材相关信息")
    @ApiImplicitParam(name = "material", value = "素材详细实体类material", required = true, dataType = "Material")
    @RequestMapping(value = { "/updateMaterial" }, method = RequestMethod.POST)
    public Result<?> updateMaterial(@RequestBody(required = true) Material material) {
	// 调用更新方法
	materialService.updateMaterial(material);
	// 更新成功后打印日志信息
	LogUtil.printLog("修改素材成功!名称:" + material.getTomdName());
	// 更新成功提示信息(从枚举类里获取)
	ResultEnum resultEnum = ResultEnum.UpdateSuccess;
	return ResultUtil.getSuccess(resultEnum.getCode(), resultEnum.getMsg(),"");
    }

    // 失效接口
    @ApiOperation(value = "失效素材", notes = "失效素材")
    @ApiImplicitParam(name = "tomdId", value = "素材id", required = true, dataType = "Integer", paramType = "query")
    @RequestMapping(value = { "/unableMaterial" }, method = RequestMethod.POST)
    public Result<?> unableMaterial(Integer tomdId) {
	// 判断设备是否存在
	Material material = materialService.findMaterialById(tomdId);
	if (material == null) {
	    // 素材不存在
	    throw new MyRuntimeException(ResultEnum.UnknowMaterialException);
	} else {
	    // 失效素材
	    materialService.unableMaterial(tomdId);
	    // 打印到控制台
	    LogUtil.printLog("失效素材成功!" + " 名称:" + material.getTomdName());
	    // 返回信息
	    ResultEnum resultEnum = ResultEnum.UnableSuccess;
	    return ResultUtil.getSuccess(resultEnum.getCode(), resultEnum.getMsg(),"");
	}
    }
    
    // 生效接口
    @ApiOperation(value = "生效素材", notes = "生效素材")
    @ApiImplicitParam(name = "tomdId", value = "素材id", required = true, dataType = "Integer", paramType = "query")
    @RequestMapping(value = { "/effectMaterial" }, method = RequestMethod.POST)
    public Result<?> effectMaterial(Integer tomdId) {
	// 判断素材是否存在
	Material material = materialService.findMaterialById(tomdId);
	if (material == null) {
	    throw new MyRuntimeException(ResultEnum.UnknowMaterialException);
	} else {
	    // 生效素材
	    materialService.effectMaterial(tomdId);
	    // 打印到控制台
	    LogUtil.printLog("生效素材成功!" + " 名称:" + material.getTomdName());
	    // 返回信息
	    ResultEnum resultEnum = ResultEnum.EffectSuccess;
	    return ResultUtil.getSuccess(resultEnum.getCode(), resultEnum.getMsg(),"");
	}
    }
    
    // 删除接口
    @ApiOperation(value = "删除素材", notes = "删除素材")
    @ApiImplicitParam(name = "tomdId", value = "素材id", required = true, dataType = "Integer", paramType = "query")
    @RequestMapping(value = { "/deleteMaterial" }, method = RequestMethod.DELETE)
    public Result<?> deleteMaterial(Integer tomdId) {
	// 判断设备是否存在
	Material material = materialService.findMaterialById(tomdId);
	if (material == null) {
	    throw new MyRuntimeException(ResultEnum.UnknowMaterialException);
	} else {
	    // 删除素材
	    materialService.deleteMaterial(tomdId);
	    // 打印到控制台
	    LogUtil.printLog("删除素材成功!" + " 名称:" + material.getTomdName());
	    // 返回信息
	    ResultEnum resultEnum = ResultEnum.DeleteSuccess;
	    return ResultUtil.getSuccess(resultEnum.getCode(), resultEnum.getMsg(),"");
	}
    }
}

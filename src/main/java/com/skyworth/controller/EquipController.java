/**
 * 
 */
package com.skyworth.controller;

import java.util.HashMap;
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
import com.skyworth.entity.Equip;
import com.skyworth.entity.Result;
import com.skyworth.entity.ResultEnum;
import com.skyworth.exception.MyRuntimeException;
import com.skyworth.service.EquipService;
import com.skyworth.util.LogUtil;
import com.skyworth.util.ResultUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * Copyright: Copyright (c) 2018 skyworth
 * 
 * @ClassName: EquipController.java
 * @Description: 设备功能类接口
 *
 * @version: v1.0.0
 * @author: Administrator
 * @date: 2018年5月18日 上午11:33:59
 *
 *        Modification History: Date Author Version Description
 *        ---------------------------------------------------------* 2018年5月18日
 *        Administrator v1.0.0 修改原因
 */
@Api(value = "API - EquipController",description = "设备管理API", protocols = "json", tags = { "Equipment" })
@RestController
@RequestMapping("/tvmanage/equip")
public class EquipController {
    @Autowired
    private EquipService equipService;

    // 查询设备
    @ApiOperation(value = "查询设备列表", notes = "返回信息中包含分页的相关信息，json格式")
    @ApiImplicitParam(name = "map", value = "多种查询条件", required = false, dataType = "Map", paramType = "query")
    @RequestMapping(value = { "/queryEquipList" }, method = RequestMethod.GET)
    public PageInfo<Equip> queryEquipList(@RequestParam(required = false) Map<String, Object> map) {
	int pageNum = 1;
	int pageSize = 10;
	if (map != null && map.get("pageNum") != null) {
	    pageNum = Integer.parseInt(map.get("pageNum").toString());
	}
	if (map != null && map.get("pageSize") != null) {
	    pageSize = Integer.parseInt(map.get("pageSize").toString());
	}

	PageHelper.startPage(pageNum, pageSize);
	List<Equip> list = equipService.queryEquipList(map);
	PageInfo<Equip> pageList = new PageInfo<Equip>(list);
	return pageList;
    }

    // 新增设备
    @ApiOperation(value = "新增设备", notes = "根据Equip类新增设备")
    @ApiImplicitParam(name = "equip", value = "设备详细实体equip", required = true, dataType = "Equip")
    @RequestMapping(value = { "/addEquip" }, method = RequestMethod.POST)
    public Result<Null> addEquip(@RequestBody(required = true) Equip equip) {
	// 新增时判断设备是否存在
	String toeiEquipmentCore = equip.getToeiEquipmentCore();
	String toeiEquipmentType = equip.getToeiEquipmentType();
	String toeiEquipmentCountry = equip.getToeiEquipmentCountry();
	String equipTemp = equipService.checkEquipExists(toeiEquipmentCore, toeiEquipmentType, toeiEquipmentCountry);
	if (equipTemp != null && equipTemp != "") {
	    throw new MyRuntimeException(ResultEnum.ExistsEquipException);
	} else {
	    // 调用新增方法
	    equipService.addEquip(equip);
	    // 新增成功后打印日志信息
	    LogUtil.printLog("新增设备成功!设备名称:" + equip.getToeiEquipmentName() + " 设备编码:" + equip.getToeiEquipmentCode());
	    // 新增成功提示信息(从枚举类里获取)
	    ResultEnum resultEnum = ResultEnum.AddSuccess;
	    return ResultUtil.getMsg(resultEnum.getCode(), resultEnum.getMsg());
	}
    }

    // 修改设备
    @ApiOperation(value = "修改设备相关信息", notes = "根据设备编码修改设备相关信息")
    @ApiImplicitParam(name = "equip", value = "设备详细实体equip", required = true, dataType = "Equip")
    @RequestMapping(value = { "/updateEquip" }, method = RequestMethod.POST)
    public Result<Null> updateEquip(@RequestBody(required = true) Equip equip) {
	// 判断设备是否存在
	Equip equipTemp = equipService.findEquipById(equip.getToeiId());
	if (equipTemp == null) {
	    throw new MyRuntimeException(ResultEnum.UnknowEquipException);
	} else {
	    // 调用更新方法
	    equipService.updateEquip(equip);
	    // 更新成功后打印日志信息
	    LogUtil.printLog("修改设备成功!设备名称:" + equip.getToeiEquipmentName() + " 设备编码:" + equip.getToeiEquipmentCode());
	    // 更新成功提示信息(从枚举类里获取)
	    ResultEnum resultEnum = ResultEnum.UpdateSuccess;
	    return ResultUtil.getMsg(resultEnum.getCode(), resultEnum.getMsg());
	}
    }

    // 失效设备
    @ApiOperation(value = "使设备失效", notes = "根据设备编码失效设备")
    @ApiImplicitParam(name = "toeiId", value = "设备id", required = true, dataType = "Integer", paramType = "query")
    @RequestMapping(value = { "/unableEquip" }, method = RequestMethod.POST)
    public Result<Null> unableEquip(Integer toeiId) {
	// 判断设备是否存在
	Equip equip = equipService.findEquipById(toeiId);
	if (equip == null) {
	    // 设备不存在
	    throw new MyRuntimeException(ResultEnum.UnknowEquipException);
	} else {
	    // 失效设备
	    equipService.unableEquip(toeiId);
	    // 打印到控制台
	    LogUtil.printLog("失效设备成功!" + " 设备编码:" + equip.getToeiEquipmentCode());
	    // 返回信息
	    ResultEnum resultEnum = ResultEnum.UnableSuccess;
	    return ResultUtil.getMsg(resultEnum.getCode(), resultEnum.getMsg());
	}
    }

    // 生效设备
    @ApiOperation(value = "使设备生效", notes = "根据设备编码生效设备")
    @ApiImplicitParam(name = "toeiId", value = "设备id", required = true, dataType = "Integer", paramType = "query")
    @RequestMapping(value = { "/effectEquip" }, method = RequestMethod.POST)
    public Result<Null> effectEquip(Integer toeiId) {
	// 判断设备是否存在
	Equip equip = equipService.findEquipById(toeiId);
	if (equip == null) {
	    // 设备不存在
	    throw new MyRuntimeException(ResultEnum.UnknowEquipException);
	} else {
	    // 生效设备
	    equipService.effectEquip(toeiId);
	    // 打印到控制台
	    LogUtil.printLog("生效设备成功!" + " 设备编码:" + equip.getToeiEquipmentCode());
	    // 返回信息
	    ResultEnum resultEnum = ResultEnum.EffectSuccess;
	    return ResultUtil.getMsg(resultEnum.getCode(), resultEnum.getMsg());
	}
    }

    // 刪除设备
    @ApiOperation(value = "删除设备", notes = "根据设备编码删除设备")
    @ApiImplicitParam(name = "toeiId", value = "设备id", required = true, dataType = "Integer", paramType = "query")
    @RequestMapping(value = { "/deleteEquip" }, method = RequestMethod.DELETE)
    public Result<Null> deleteEquip(Integer toeiId) {
	// 判断设备是否存在
	Equip equip = equipService.findEquipById(toeiId);
	if (equip == null) {
	    // 设备不存在
	    throw new MyRuntimeException(ResultEnum.UnknowEquipException);
	} else {
	    // 删除设备
	    equipService.deleteEquip(toeiId);
	    // 打印到控制台
	    LogUtil.printLog("删除设备成功!" + " 设备编码:" + equip.getToeiEquipmentCode());
	    // 返回信息
	    ResultEnum resultEnum = ResultEnum.EffectSuccess;
	    return ResultUtil.getMsg(resultEnum.getCode(), resultEnum.getMsg());
	}
    }

    // 根据设备id查询设备相关信息
    @ApiOperation(value = "根据设备id查询设备相关信息", notes = "根据设备id查询设备相关信息")
    @ApiImplicitParam(name = "toeiId", value = "设备id", required = true, dataType = "Integer", paramType = "query")
    @RequestMapping(value = { "/findEquipById" }, method = RequestMethod.GET)
    public Equip findEquipById(Integer toeiId) {
	Equip equip = equipService.findEquipById(toeiId);
	if (equip == null) {
	    // 没有查询到数据
	    throw new MyRuntimeException(ResultEnum.NoDataSuccess);
	}
	return equip;
    }

    // 根据 机芯+机型+使用国家 自动获取优先级最高的默认设置方案
    @ApiOperation(value = "获取默认设置方案", notes = "根据 机芯+机型+使用国家 自动获取优先级最高的默认设置方案")
    @ApiImplicitParams({
	    @ApiImplicitParam(name = "toeiEquipmentCore", value = "设备机芯", required = true, dataType = "String", paramType = "query"),
	    @ApiImplicitParam(name = "toeiEquipmentType", value = "设备机型", required = true, dataType = "String", paramType = "query"),
	    @ApiImplicitParam(name = "toeiEquipmentCountry", value = "设备使用国家", required = true, dataType = "String", paramType = "query") })
    @RequestMapping(value = { "/getDefaultScheme" }, method = RequestMethod.GET)
    public Map<String, Object> getDefaultScheme(String toeiEquipmentCore, String toeiEquipmentType,
	    String toeiEquipmentCountry) {
	Map<String, Object> map = new HashMap<String, Object>();
	map = equipService.getDefaultScheme(toeiEquipmentCore, toeiEquipmentType, toeiEquipmentCountry);
	return map;
    }

    // 根据 机芯+机型+使用国家 自动获取设置方案列表
    @ApiOperation(value = "获取设置方案列表", notes = "根据 机芯+机型+使用国家 自动获取有效的设置方案列表")
    @ApiImplicitParams({
	    @ApiImplicitParam(name = "toeiEquipmentCore", value = "设备机芯", required = true, dataType = "String", paramType = "query"),
	    @ApiImplicitParam(name = "toeiEquipmentType", value = "设备机型", required = true, dataType = "String", paramType = "query"),
	    @ApiImplicitParam(name = "toeiEquipmentCountry", value = "设备使用国家", required = true, dataType = "String", paramType = "query") })
    @RequestMapping(value = { "/getSchemeList" }, method = RequestMethod.GET)
    public HashMap<String, Object> getSchemeList(String toeiEquipmentCore, String toeiEquipmentType,
	    String toeiEquipmentCountry) {
	HashMap<String, Object> map = new HashMap<String, Object>();
	map = equipService.getSchemeList(toeiEquipmentCore, toeiEquipmentType, toeiEquipmentCountry);
	return map;
    }

    // 根据关键字查询设备信息
    @ApiOperation(value = "设备名称/编码模糊查询", notes = "根据关键字模糊查询名称/编码")
    @ApiImplicitParam(name = "keyWord", value = "模糊查询关键字", required = false, dataType = "String", paramType = "query")
    @RequestMapping(value = { "/queryEquipByKey" }, method = RequestMethod.GET)
    public List<Map<String, String>> queryEquipByKey(String keyWord) {
	return equipService.queryEquipByKey(keyWord);
    }
}

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
import com.skyworth.entity.Advertisement;
import com.skyworth.entity.Result;
import com.skyworth.entity.ResultEnum;
import com.skyworth.exception.MyRuntimeException;
import com.skyworth.service.AdService;
import com.skyworth.util.LogUtil;
import com.skyworth.util.ResultUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

/**
 * Copyright: Copyright (c) 2018 skyworth
 * 
 * @ClassName: AdController.java
 * @Description: 该类的功能描述
 *
 * @version: v1.0.0
 * @author: Administrator
 * @date: 2018年7月23日 上午11:06:47
 *
 *        Modification History: Date Author Version Description
 *        ---------------------------------------------------------* 2018年7月23日
 *        Administrator v1.0.0 修改原因
 */
@Api(value = "API - Advertisement Controller", description = "广告管理API", protocols = "json", tags = { "Advertisement" })
@RestController
@RequestMapping("/tvmanage/advertisement")
public class AdController {

    @Autowired
    private AdService adService;

    @ApiOperation(value = "查询广告列表", notes = "返回信息中包含分页的相关信息，json格式")
    @ApiImplicitParam(name = "map", value = "多种查询条件", required = false, dataType = "Map", paramType = "query")
    @RequestMapping(value = { "/queryAdvertisementList" }, method = RequestMethod.GET)
    public Result<?> queryParameterList(@RequestParam(required = false) Map<String, Object> map) {
	int pageNum = 1;
	int pageSize = 10;
	if (map != null && map.get("pageNum") != null) {
	    pageNum = Integer.parseInt(map.get("pageNum").toString());
	}
	if (map != null && map.get("pageSize") != null) {
	    pageSize = Integer.parseInt(map.get("pageSize").toString());
	}

	PageHelper.startPage(pageNum, pageSize);
	List<Advertisement> list = adService.queryAdvertisementList(map);
	PageInfo<Advertisement> pageList = new PageInfo<Advertisement>(list);

	// 返回信息
	ResultEnum resultEnum = ResultEnum.SUCCESS;
	return ResultUtil.getSuccess(resultEnum.getCode(), resultEnum.getMsg(), pageList);
    }

    @ApiOperation(value = "根据广告id查询广告相关信息", notes = "根据广告id查询广告相关信息")
    @ApiImplicitParam(name = "toatId", value = "广告id", required = true, dataType = "Integer", paramType = "query")
    @RequestMapping(value = { "/queryAdvertisementById" }, method = RequestMethod.GET)
    public Result<?> queryAdvertisementById(Integer toatId) {
	Advertisement advertisement = adService.queryAdvertisementById(toatId);
	if (advertisement == null) {
	    // 没有查询到数据
	    throw new MyRuntimeException(ResultEnum.NoDataSuccess);
	}
	// 返回信息
	ResultEnum resultEnum = ResultEnum.SUCCESS;
	return ResultUtil.getSuccess(resultEnum.getCode(), resultEnum.getMsg(), advertisement);
    }

    @ApiOperation(value = "新增广告", notes = "根据广告类新增广告")
    @ApiImplicitParam(name = "advertisement", value = "广告类", required = true, dataType = "Advertisement")
    @RequestMapping(value = { "/addAdvertisement" }, method = RequestMethod.POST)
    public Result<?> addAdvertisement(@RequestBody(required = true) Advertisement advertisement) {
	// 调用新增方法
	adService.addAdvertisement(advertisement);
	// 新增成功后打印日志信息
	LogUtil.printLog("新增广告成功!广告名称:" + advertisement.getToatName());
	// 新增成功提示信息(从枚举类里获取)
	ResultEnum resultEnum = ResultEnum.AddSuccess;
	return ResultUtil.getSuccess(resultEnum.getCode(), resultEnum.getMsg(), "");
    }

    @ApiOperation(value = "修改广告相关信息", notes = "修改广告相关信息")
    @ApiImplicitParam(name = "advertisement", value = "广告类", required = true, dataType = "Advertisement")
    @RequestMapping(value = { "/updateAdvertisement" }, method = RequestMethod.POST)
    public Result<?> updateAdvertisement(@RequestBody(required = true) Advertisement advertisement) {
	// 判断广告是否存在
	Advertisement AdvertisementTemp = adService.queryAdvertisementById(advertisement.getToatId());
	if (AdvertisementTemp == null) {
	    throw new MyRuntimeException(ResultEnum.UnknowAdException);
	} else {
	    // 调用更新方法
	    adService.updateAdvertisement(advertisement);
	    // 更新成功后打印日志信息
	    LogUtil.printLog("修改广告成功!广告名称:" + advertisement.getToatName());
	    // 更新成功提示信息(从枚举类里获取)
	    ResultEnum resultEnum = ResultEnum.UpdateSuccess;
	    return ResultUtil.getSuccess(resultEnum.getCode(), resultEnum.getMsg(), "");
	}
    }

    @ApiOperation(value = "删除广告", notes = "根据广告id删除广告")
    @ApiImplicitParam(name = "toatId", value = "广告id", required = true, dataType = "Integer", paramType = "query")
    @RequestMapping(value = { "/deleteAdvertisement" }, method = RequestMethod.DELETE)
    public Result<?> deleteAdvertisement(Integer toatId) {
	// 判断设备是否存在
	Advertisement AdvertisementTemp = adService.queryAdvertisementById(toatId);
	if (AdvertisementTemp == null) {
	    // 广告不存在
	    throw new MyRuntimeException(ResultEnum.UnknowAdException);
	} else {
	    // 删除设备
	    adService.deleteAdvertisement(toatId);
	    // 打印到控制台
	    LogUtil.printLog("修改广告成功!广告名称:" + AdvertisementTemp.getToatName());
	    // 返回信息
	    ResultEnum resultEnum = ResultEnum.DeleteSuccess;
	    return ResultUtil.getSuccess(resultEnum.getCode(), resultEnum.getMsg(), "");
	}
    }
}

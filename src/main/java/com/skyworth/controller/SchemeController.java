/**
 * 
 */
package com.skyworth.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.skyworth.entity.Result;
import com.skyworth.entity.ResultEnum;
import com.skyworth.entity.Scheme;
import com.skyworth.exception.MyRuntimeException;
import com.skyworth.service.PublicService;
import com.skyworth.service.SchemeService;
import com.skyworth.util.LogUtil;
import com.skyworth.util.ResultUtil;
import com.skyworth.util.SessionUtil;

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
@Api(value = "API - UserController",description = "方案管理API", protocols = "json", tags = { "Scheme" })
@RestController
@RequestMapping("/tvmanage/scheme")
public class SchemeController {

    @Autowired
    private SchemeService schemeService;
    @Autowired
    private PublicService publicService;

    @ApiOperation(value = "查询方案列表", notes = "返回信息中包含分页的相关信息，json格式")
    @ApiImplicitParam(name = "map", value = "多种查询条件", required = false, dataType = "Map", paramType = "query")
    @RequestMapping(value = { "/querySchemeList" }, method = RequestMethod.GET)
    public Result<?> querySchemeList(@RequestParam(required = false) Map<String, Object> map) {
	int pageNum = 1;
	int pageSize = 10;
	if (map != null && map.get("pageNum") != null) {
	    pageNum = Integer.parseInt(map.get("pageNum").toString());
	}
	if (map != null && map.get("pageSize") != null) {
	    pageSize = Integer.parseInt(map.get("pageSize").toString());
	}
	// 将当前登入用户传入，作审核权限判断
	HttpSession session = SessionUtil.getSession();
	String currentUser = session.getAttribute("activeUser").toString();
	map.put("currentUser", currentUser);

	PageHelper.startPage(pageNum, pageSize);
	List<HashMap<String, Object>> list = schemeService.querySchemeList(map);
	PageInfo<HashMap<String, Object>> pageList = new PageInfo<HashMap<String, Object>>(list);
	
	// 返回信息
	ResultEnum resultEnum = ResultEnum.SUCCESS;
	return ResultUtil.getSuccess(resultEnum.getCode(), resultEnum.getMsg(), pageList);
    }

    @ApiOperation(value = "根据id查询方案信息", notes = "根据id查询方案信息")
    @ApiImplicitParam(name = "toseId", value = "方案id", required = true, dataType = "Integer", paramType = "query")
    @RequestMapping(value = { "/findSchemeById" }, method = RequestMethod.GET)
    public Result<?> findSchemeById(Integer toseId) {
	Scheme scheme = schemeService.findSchemeById(toseId);
	if (scheme == null) {
	    // 没有查询到数据
	    throw new MyRuntimeException(ResultEnum.NoDataSuccess);
	}
	// 返回信息
	ResultEnum resultEnum = ResultEnum.SUCCESS;
	return ResultUtil.getSuccess(resultEnum.getCode(), resultEnum.getMsg(), scheme);
    }

    @ApiOperation(value = "方案名称检索框", notes = "方案名称检索框接口")
    @ApiImplicitParam(name = "toseName", value = "方案名称", required = false, dataType = "String", paramType = "query")
    @RequestMapping(value = { "/GetSchemeNameSug" }, method = RequestMethod.GET)
    public Result<?> GetSchemeNameSug(String toseName) {
	try {
	    // 返回信息
	    ResultEnum resultEnum = ResultEnum.SUCCESS;
	    return ResultUtil.getSuccess(resultEnum.getCode(), resultEnum.getMsg(),
		    schemeService.GetSchemeNameSug(toseName));
	} catch (Exception e) {
	    // 打印错误日志
	    LogUtil.printLog(e, Exception.class);
	    // 抛出错误
	    throw new MyRuntimeException(ResultEnum.DBException);
	}
    }

    @ApiOperation(value = "方案客户检索框", notes = "方案客户检索框接口")
    @ApiImplicitParam(name = "custName", value = "客户名称", required = false, dataType = "String", paramType = "query")
    @RequestMapping(value = { "/GetSchemeCustSug" }, method = RequestMethod.GET)
    public Result<?> GetSchemeCustSug(String custName) {
	try {
	    // 返回信息
	    ResultEnum resultEnum = ResultEnum.SUCCESS;
	    return ResultUtil.getSuccess(resultEnum.getCode(), resultEnum.getMsg(),
		    schemeService.GetSchemeCustSug(custName));
	} catch (Exception e) {
	    // 打印错误日志
	    LogUtil.printLog(e, Exception.class);
	    // 抛出错误
	    throw new MyRuntimeException(ResultEnum.DBException);
	}
    }

    @ApiOperation(value = "新增方案", notes = "新增方案信息")
    @ApiImplicitParam(name = "scheme", value = "方案实体类", required = true, dataType = "Scheme")
    @RequestMapping(value = { "/addScheme" }, method = RequestMethod.POST)
    public Result<?> addScheme(@RequestBody(required = true) Scheme scheme) {
	// 自动生成编码
	String toseCodeTemp = "";
	toseCodeTemp = publicService.autoCoding("SC", "tvso_scheme", "tose_code");
	scheme.setToseCode(toseCodeTemp);
	// 根据session获取登入用户
	HttpSession session = SessionUtil.getSession();
	String addUser = session.getAttribute("activeUser").toString();
	scheme.setAddUser(addUser);
	// 赋值单据状态 2:审核中
	scheme.setToseStatus(2);
	schemeService.addScheme(scheme);
	// 新增成功后打印日志信息
	LogUtil.printLog("新增方案成功!方案名称:" + scheme.getToseName() + " 方案编码:" + scheme.getToseCode());
	// 新增成功提示信息(从枚举类里获取)
	ResultEnum resultEnum = ResultEnum.AddSuccess;
	return ResultUtil.getSuccess(resultEnum.getCode(), resultEnum.getMsg(),"");
    }

    @ApiOperation(value = "保存方案", notes = "保存方案信息")
    @ApiImplicitParam(name = "scheme", value = "方案实体类", required = true, dataType = "Scheme")
    @RequestMapping(value = { "/saveScheme" }, method = RequestMethod.POST)
    public Result<?> saveScheme(@RequestBody(required = true) Scheme scheme) {
	Scheme schemeTemp = schemeService.findSchemeById(scheme.getToseId());
	if (schemeTemp == null) {
	    // 自动生成编码
	    String toseCodeTemp = "";
	    toseCodeTemp = publicService.autoCoding("SC", "tvso_scheme", "tose_code");
	    scheme.setToseCode(toseCodeTemp);
	    // 根据session获取登入用户
	    HttpSession session = SessionUtil.getSession();
	    scheme.setAddUser(session.getAttribute("activeUser").toString());
	    // 赋值单据状态 1:待提交
	    scheme.setToseStatus(1);
	    schemeService.addScheme(scheme);
	    // 新增成功后打印日志信息
	    LogUtil.printLog("保存方案成功!方案名称:" + scheme.getToseName() + " 方案编码:" + scheme.getToseCode());
	    // 新增成功提示信息(从枚举类里获取)
	    ResultEnum resultEnum = ResultEnum.AddSuccess;
	    return ResultUtil.getSuccess(resultEnum.getCode(), resultEnum.getMsg(),"");
	} else {
	    // 调用更新方法
	    schemeService.updateScheme(scheme);
	    // 更新成功后打印日志信息
	    LogUtil.printLog("修改方案成功!方案名称:" + scheme.getToseName() + " 方案编码:" + scheme.getToseCode());
	    // 更新成功提示信息(从枚举类里获取)
	    ResultEnum resultEnum = ResultEnum.UpdateSuccess;
	    return ResultUtil.getSuccess(resultEnum.getCode(), resultEnum.getMsg(),"");
	}

    }

    @ApiOperation(value = "修改方案", notes = "修改方案信息")
    @ApiImplicitParam(name = "scheme", value = "方案实体类", required = true, dataType = "Scheme")
    @RequestMapping(value = { "/updateScheme" }, method = RequestMethod.POST)
    public Result<?> updateScheme(@RequestBody(required = true) Scheme scheme) {
	Scheme schemeTemp = schemeService.findSchemeById(scheme.getToseId());
	if (schemeTemp == null) {
	    // 没有查询到数据
	    throw new MyRuntimeException(ResultEnum.UnknowSchemeException);
	} else {  
	    // 根据session获取登入用户
	    HttpSession session = SessionUtil.getSession();
	    scheme.setModUser(session.getAttribute("activeUser").toString());
	    // 调用更新方法
	    schemeService.updateScheme(scheme);
	    // 更新成功后打印日志信息
	    LogUtil.printLog("修改方案成功!方案名称:" + scheme.getToseName() + " 方案编码:" + scheme.getToseCode());
	    // 更新成功提示信息(从枚举类里获取)
	    ResultEnum resultEnum = ResultEnum.UpdateSuccess;
	    return ResultUtil.getSuccess(resultEnum.getCode(), resultEnum.getMsg(),"");
	}
    }

    @ApiOperation(value = "删除方案", notes = "删除方案")
    @ApiImplicitParam(name = "toseId", value = "方案id", required = true, dataType = "Integer", paramType = "query")
    @RequestMapping(value = { "/deleteScheme" }, method = RequestMethod.DELETE)
    public Result<?> deleteScheme(Integer toseId) {
	Scheme schemeTemp = schemeService.findSchemeById(toseId);
	if (schemeTemp == null) {
	    // 没有查询到数据
	    throw new MyRuntimeException(ResultEnum.UnknowSchemeException);
	} else {
	    // 调用方法
	    schemeService.deleteScheme(toseId);
	    // 更新成功后打印日志信息
	    LogUtil.printLog("删除方案成功!方案名称:" + schemeTemp.getToseName() + " 方案编码:" + schemeTemp.getToseCode());
	    // 更新成功提示信息(从枚举类里获取)
	    ResultEnum resultEnum = ResultEnum.DeleteSuccess;
	    return ResultUtil.getSuccess(resultEnum.getCode(), resultEnum.getMsg(),"");
	}
    }

    @ApiOperation(value = "失效方案", notes = "失效方案")
    @ApiImplicitParam(name = "toseId", value = "方案id", required = true, dataType = "Integer", paramType = "query")
    @RequestMapping(value = { "/unableScheme" }, method = RequestMethod.POST)
    public Result<?> unableScheme(Integer toseId) {
	Scheme schemeTemp = schemeService.findSchemeById(toseId);
	if (schemeTemp == null) {
	    // 没有查询到数据
	    throw new MyRuntimeException(ResultEnum.UnknowSchemeException);
	} else {
	    // 调用方法
	    schemeService.unableScheme(toseId);
	    // 更新成功后打印日志信息
	    LogUtil.printLog("失效方案成功!方案名称:" + schemeTemp.getToseName() + " 方案编码:" + schemeTemp.getToseCode());
	    // 更新成功提示信息(从枚举类里获取)
	    ResultEnum resultEnum = ResultEnum.UnableSuccess;
	    return ResultUtil.getSuccess(resultEnum.getCode(), resultEnum.getMsg(),"");
	}
    }

    @ApiOperation(value = "生效方案", notes = "生效方案")
    @ApiImplicitParam(name = "toseId", value = "方案id", required = true, dataType = "Integer", paramType = "query")
    @RequestMapping(value = { "/effectScheme" }, method = RequestMethod.POST)
    public Result<?> effectScheme(Integer toseId) {
	Scheme schemeTemp = schemeService.findSchemeById(toseId);
	if (schemeTemp == null) {
	    // 没有查询到数据
	    throw new MyRuntimeException(ResultEnum.UnknowSchemeException);
	} else {
	    // 调用方法
	    schemeService.effectScheme(toseId);
	    // 更新成功后打印日志信息
	    LogUtil.printLog("生效方案成功!方案名称:" + schemeTemp.getToseName() + " 方案编码:" + schemeTemp.getToseCode());
	    // 更新成功提示信息(从枚举类里获取)
	    ResultEnum resultEnum = ResultEnum.EffectSuccess;
	    return ResultUtil.getSuccess(resultEnum.getCode(), resultEnum.getMsg(),"");
	}
    }

    @ApiOperation(value = "查询填充素材列表", notes = "返回信息中包含分页的相关信息，json格式")
    @ApiImplicitParam(name = "map", value = "查询条件：materialType 类型；materialName 名称；pageNum 第几页；pageSize 每页大小", required = false, dataType = "Map", paramType = "query")
    @RequestMapping(value = { "/GetSchemeFillMaterial" }, method = RequestMethod.GET)
    public Result<?> GetSchemeFillMaterial(
	    @RequestParam(required = false) Map<String, Object> map) {
	int pageNum = 1;
	int pageSize = 10;
	if (map != null && map.get("pageNum") != null) {
	    pageNum = Integer.parseInt(map.get("pageNum").toString());
	}
	if (map != null && map.get("pageSize") != null) {
	    pageSize = Integer.parseInt(map.get("pageSize").toString());
	}

	PageHelper.startPage(pageNum, pageSize);
	List<HashMap<String, Object>> list = schemeService.GetSchemeFillMaterial(map);
	PageInfo<HashMap<String, Object>> pageList = new PageInfo<HashMap<String, Object>>(list);
	
	// 返回信息
	ResultEnum resultEnum = ResultEnum.SUCCESS;
	return ResultUtil.getSuccess(resultEnum.getCode(), resultEnum.getMsg(), pageList);
    }
}

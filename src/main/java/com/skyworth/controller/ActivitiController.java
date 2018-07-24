/**
 * 
 */
package com.skyworth.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skyworth.entity.Result;
import com.skyworth.entity.ResultEnum;
import com.skyworth.service.ActivitiService;
import com.skyworth.util.LogUtil;
import com.skyworth.util.ResultUtil;
import com.skyworth.util.SessionUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**   
* Copyright: Copyright (c) 2018 skyworth
* 
* @ClassName: ActivitiController.java
* @Description: 该类的功能描述
*
* @version: v1.0.0
* @author: Administrator
* @date: 2018年7月3日 下午6:03:31 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年7月3日     Administrator           v1.0.0               修改原因
*/
@Api(value = "API - ActivitiController",description = "流程管理API", protocols = "json", tags = { "Activiti" })
@RestController
@RequestMapping("/tvmanage/activiti")
public class ActivitiController {
    @Autowired
    private ActivitiService activitiService;
    
    @ApiOperation(value = "审核操作 通过/退回 接口", notes = "审核操作 通过/退回 接口")
    @ApiImplicitParams({
	    @ApiImplicitParam(name = "wfId", value = "流程key,例：SchemeProcess", required = true, dataType = "String", paramType = "query"),
	    @ApiImplicitParam(name = "mid", value = "单据主id", required = true, dataType = "String", paramType = "query"),
	    @ApiImplicitParam(name = "result", value = "操作结构,通过为true,退回为false", required = true, dataType = "Boolean", paramType = "query") })
    @RequestMapping(value = { "/workflowReview" }, method = RequestMethod.POST)
    public Result<?> workflowReview(String wfId,String mid,Boolean result) {
	// 根据session获取登入人账号
	HttpSession session = SessionUtil.getSession();
	String user = session.getAttribute("activeUser").toString();
	// 调用服务 
	activitiService.completeTask(wfId, mid, user, result);
	// 更新成功后打印日志信息
	LogUtil.printLog("审核信息: 流程key-" + wfId + " 单据id-" + mid + " 通过-" + result + " 通过人-" + user);
	// 更新成功提示信息(从枚举类里获取)
	ResultEnum resultEnum = ResultEnum.SUCCESS;
	return ResultUtil.getSuccess(resultEnum.getCode(), resultEnum.getMsg(),"");
    }
}

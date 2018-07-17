/**
 * 
 */
package com.skyworth.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.skyworth.service.ActivitiService;
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
    public void workflowReview(String wfId,String mid,Boolean result) {
	// 根据session获取登入人账号

	HttpSession session = SessionUtil.getSession();
	System.out.println(session.getAttribute("activeUser"));
	String user = session.getAttribute("activeUser").toString();
	// 调用服务 
	activitiService.completeTask(wfId, mid, user, result);
    }
}

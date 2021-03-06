/**
 * 
 */
package com.skyworth.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skyworth.entity.Result;
import com.skyworth.entity.ResultEnum;
import com.skyworth.exception.MyRuntimeException;
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
 * @ClassName: UserLoginController.java
 * @Description: 用户登入接口
 *
 * @version: v1.0.0
 * @author: Administrator
 * @date: 2018年5月14日 上午11:23:50
 *
 *        Modification History: Date Author Version Description
 *        ---------------------------------------------------------* 2018年5月14日
 *        Administrator v1.0.0 修改原因
 */
@Api(value = "API - UserController",description = "用户登入API", protocols = "json", tags = { "Admin" })
@RestController
@RequestMapping("/tvmanage/user")
public class UserLoginController {
    // @ApiOperation(value = "用户登入接口", notes = "用于登入验证失败，返回登入页面的方法，无参数")
    // @RequestMapping(value = "/login", method = RequestMethod.GET)
    // public String login() {
    // return "login.html";
    // }

    @ApiOperation(value = "用户登入接口", notes = "输入用户账号、密码登入")
    @ApiImplicitParams({
	    @ApiImplicitParam(name = "account", value = "用户账号", required = true, dataType = "String", paramType = "query"),
	    @ApiImplicitParam(name = "password", value = "用户密码", required = true, dataType = "String", paramType = "query") })
    @ApiResponses({ @ApiResponse(code = 0401, message = "该用户名不存在！"), @ApiResponse(code = 0402, message = "用户名或密码错误！"),
	    @ApiResponse(code = 0403, message = "用户名已被锁定或失效，请联系管理员！") })
    @RequestMapping(value = { "/login" }, method = RequestMethod.POST)
    public Result<?> login(@RequestParam(value = "account") String account,
	    @RequestParam("password") String password) {
	// 结果信息
	Result<?> result = new Result<>();
	// 创建Subject实例
	Subject subject = SecurityUtils.getSubject();

	// 将用户名及密码封装到UsernamePasswordToken
	UsernamePasswordToken token = new UsernamePasswordToken(account, password);

	try {
	    // 完成登录验证
	    subject.login(token);
	    // 判断当前用户是否验证成功
	    if (subject.isAuthenticated() == true) {
		// 登入成功
		ResultEnum resultEnum = ResultEnum.AdminSuccess;
		result = ResultUtil.getSuccess(resultEnum.getCode(), resultEnum.getMsg(),"");
		// 打印到控制台
		LogUtil.printLog(result.getMsg()+",登入用户: " + account);
	    }

	} catch (LockedAccountException e) {
	    // 用户无效
	    throw new MyRuntimeException(ResultEnum.LockedAccountException);
	} catch (IncorrectCredentialsException e) {
	    // 密码不正确
	    throw new MyRuntimeException(ResultEnum.IncorrectCredentialsException);
	} catch (AuthenticationException e) {
	    // 用户不存在
	    throw new MyRuntimeException(ResultEnum.UnknownAccountException);
	} catch (Exception e) {
	    throw e;
	}
	return result;
    }

    // @ApiOperation(value = "用户登出接口", notes = "用于页面跳转，跳转到登入的页面，无参数")
    // @RequestMapping(value = "/logout",method = RequestMethod.GET)
    // public void logout() {
    // Subject subject = SecurityUtils.getSubject();
    // subject.logout();
    // }
}

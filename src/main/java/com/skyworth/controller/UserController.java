package com.skyworth.controller;

import java.util.List;
import java.util.Map;

import javax.validation.constraints.Null;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.skyworth.entity.AdminUser;
import com.skyworth.entity.Result;
import com.skyworth.entity.ResultEnum;
import com.skyworth.entity.User;
import com.skyworth.exception.MyRuntimeException;
import com.skyworth.service.UserService;
import com.skyworth.util.LogUtil;
import com.skyworth.util.Md5Util;
import com.skyworth.util.ResultUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * Copyright: Copyright (c) 2018 skyworth
 * 
 * @ClassName: UserController.java
 * @Description: 用户模塊控制层
 *
 * @version: v1.0.0
 * @author: Administrator
 * @date: 2018��5��7�� ����11:31:22
 *
 *        Modification History: Date Author Version Description
 *        ---------------------------------------------------------*
 *        2018��5��7�� Administrator v1.0.0 �޸�ԭ��
 */
// @RestController is a stereotype annotation that combines @ResponseBody and
// @Controller
@Api(value = "API - UserController",description = "用户管理API", protocols = "json", tags = "User")
@RestController
@RequestMapping("/tvmanage//user")
public class UserController {
    @Autowired
    private UserService userService;

    // 查询用户接口
    @ApiOperation(value = "查询用户列表", notes = "返回信息中包含分页的相关信息，json格式")
    @ApiImplicitParam(name = "map", value = "多种查询条件", required = false, dataType = "Map", paramType = "query")
    @RequestMapping(value = { "/queryUserList" }, method = RequestMethod.GET)
    public PageInfo<User> queryUserList(@RequestParam(required = false) Map<String, Object> map) {
	int pageNum = 1;
	int pageSize = 10;
	if (map != null && map.get("pageNum") != null) {
	    pageNum = Integer.parseInt(map.get("pageNum").toString());
	}
	if (map != null && map.get("pageSize") != null) {
	    pageSize = Integer.parseInt(map.get("pageSize").toString());
	}

	PageHelper.startPage(pageNum, pageSize);
	List<User> list = userService.queryUserList(map);
	PageInfo<User> pageList = new PageInfo<User>(list);
	return pageList;
    }

    // 新增用户接口
    @ApiOperation(value = "创建用户", notes = "根据User对象创建用户")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @RequestMapping(value = { "/addUser" }, method = RequestMethod.POST)
    public Result<Null> addUser(@RequestBody(required = true) User user) {
	if (userService.checkAccount(user.getTourAccount())) {
	    // 账号已存在提示信息(从枚举类里获取)
	    throw new MyRuntimeException(ResultEnum.ExistsAccountException);
	} else {
	    // 密碼加密：MD5+SALT
	    user.setTourPassword(Md5Util.md5(user.getTourPassword(), user.getTourName()));
	    // 调用新增方法
	    userService.addUser(user);
	    // 新增成功后打印日志信息
	    LogUtil.printLog("新增用户成功!账号:" + user.getTourAccount() + " 名称:" + user.getTourName());
	    // 新增成功提示信息(从枚举类里获取)
	    ResultEnum resultEnum = ResultEnum.AddSuccess;
	    return ResultUtil.getMsg(resultEnum.getCode(), resultEnum.getMsg());
	}
    }

    // 修改用户接口
    @ApiOperation(value = "修改用户相关信息", notes = "根据用户账号修改用户相关信息")
    @ApiImplicitParam(name = "user", value = "用户详细实体user", required = true, dataType = "User")
    @RequestMapping(value = { "/updateUser" }, method = RequestMethod.POST)
    public Result<Null> updateUser(@RequestBody(required = true) User user) {
	// 判断用户是否存在
	AdminUser adminUser = this.userService.findUserByAccount(user.getTourAccount());
	if (adminUser == null) {
	    // 用户不存在
	    throw new MyRuntimeException(ResultEnum.UnknownAccountException);
	} else {
	    // 调用修改方法
	    userService.updateUser(user);
	    // 修改成功后打印日志信息
	    LogUtil.printLog("修改用户成功!账号:" + user.getTourAccount() + " 名称:" + user.getTourName());
	    // 修改成功提示信息(从枚举类里获取)
	    ResultEnum resultEnum = ResultEnum.UpdateSuccess;
	    return ResultUtil.getMsg(resultEnum.getCode(), resultEnum.getMsg());
	}
    }

    // 修改密码接口
    @ApiOperation(value = "修改用户密码", notes = "根据用户账号修改用户密码")
    @ApiImplicitParams({
	    @ApiImplicitParam(name = "tourAccount", value = "用户账号", required = true, dataType = "String", paramType = "query"),
	    @ApiImplicitParam(name = "tourName", value = "用户名称", required = true, dataType = "String", paramType = "query"),
	    @ApiImplicitParam(name = "oldpassword", value = "旧密码", required = true, dataType = "String", paramType = "query"),
	    @ApiImplicitParam(name = "tourPassword", value = "新密码", required = true, dataType = "String", paramType = "query") })
    @RequestMapping(value = { "/updatePassword" }, method = RequestMethod.POST)
    public Result<Null> updatePassword(@RequestParam("tourAccount") String tourAccount,
	    @RequestParam("tourName") String tourName, @RequestParam("oldpassword") String oldpassword,
	    @RequestParam("tourPassword") String tourPassword) {
	// 结果信息
	Result<Null> result = new Result<Null>();
	// 创建Subject实例
	Subject subject = SecurityUtils.getSubject();

	// 将用户名及密码封装到UsernamePasswordToken
	UsernamePasswordToken token = new UsernamePasswordToken(tourAccount, oldpassword);

	try {
	    // 完成登录验证
	    subject.login(token);
	    // 判断当前用户是否验证成功
	    if (subject.isAuthenticated() == true) {
		// 修改密码
		userService.updatePassword(tourAccount, Md5Util.md5(tourPassword, tourName));
		// 登入成功
		ResultEnum resultEnum = ResultEnum.SUCCESS;
		result = ResultUtil.getMsg(resultEnum.getCode(), resultEnum.getMsg());
		// 打印到控制台
		LogUtil.printLog(result.getMsg() + ",修改用户: " + tourAccount);
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

    // 失效用户接口
    @ApiOperation(value = "使用户失效", notes = "根据用户账号失效用户")
    @ApiImplicitParam(name = "tourId", value = "用户id", required = true, dataType = "Integer", paramType = "query")
    @RequestMapping(value = { "/unableUser" }, method = RequestMethod.POST)
    public Result<Null> unableUser(Integer tourId) {
	// 判断用户是否存在
	User user = this.userService.findUserById(tourId);
	if (user == null) {
	    // 用户不存在
	    throw new MyRuntimeException(ResultEnum.UnknownAccountException);
	} else {
	    // 调用失效方法
	    userService.unableUser(tourId);
	    // 失效成功打印日志信息
	    LogUtil.printLog("用户失效 成功!账号：" + user.getTourAccount());
	    // 失效成功提示信息(从枚举类里获取)
	    ResultEnum resultEnum = ResultEnum.UnableSuccess;
	    return ResultUtil.getMsg(resultEnum.getCode(), resultEnum.getMsg());
	}
    }

    // 生效用户接口
    @ApiOperation(value = "使用户生效", notes = "根据用户账号生效用户")
    @ApiImplicitParam(name = "tourId", value = "用户id", required = true, dataType = "Integer", paramType = "query")
    @RequestMapping(value = { "/effectUser" }, method = RequestMethod.POST)
    public Result<Null> effectUser(Integer tourId) {
	// 判断用户是否存在
	User user = this.userService.findUserById(tourId);
	if (user == null) {
	    // 用户不存在
	    throw new MyRuntimeException(ResultEnum.UnknownAccountException);
	} else {
	    // 调用方法
	    userService.effectUser(tourId);
	    // 失效成功打印日志信息
	    LogUtil.printLog("用户生效 成功!账号：" + user.getTourAccount());
	    // 失效成功提示信息(从枚举类里获取)
	    ResultEnum resultEnum = ResultEnum.EffectSuccess;
	    return ResultUtil.getMsg(resultEnum.getCode(), resultEnum.getMsg());
	}
    }

    // 刪除用戶接口
    @ApiOperation(value = "删除用户", notes = "根据用户账号删除用户")
    @ApiImplicitParam(name = "tourId", value = "用户id", required = true, dataType = "Integer", paramType = "query")
    @RequestMapping(value = { "/deleteUser" }, method = RequestMethod.DELETE)
    public Result<Null> deleteUser(Integer tourId) {
	// 判断用户是否存在
	User user = this.userService.findUserById(tourId);
	if (user == null) {
	    throw new MyRuntimeException(ResultEnum.UnknownAccountException);
	} else {
	    // 调用刪除方法
	    userService.deleteUser(tourId);
	    // 刪除成功打印日志信息
	    LogUtil.printLog("用户失效 成功!账号：" + user.getTourAccount());
	    // 刪除成功提示信息(从枚举类里获取)
	    ResultEnum resultEnum = ResultEnum.DeleteSuccess;
	    return ResultUtil.getMsg(resultEnum.getCode(), resultEnum.getMsg());
	}
    }

    // 用户模糊查询接口
    @ApiOperation(value = "用户模糊查询接口", notes = "根据关键字查询用户名称账号")
    @ApiImplicitParam(name = "keyWord", value = "检索关键字", required = false, dataType = "String", paramType = "query")
    @RequestMapping(value = { "/queryUserByKey" }, method = RequestMethod.GET)
    public List<Map<String, String>> queryUserByKey(String keyWord) {
	return userService.queryUserByKey(keyWord);
    }

    // 根据用户id查询用户相关信息
    @ApiOperation(value = "根据用户id查询用户相关信息", notes = "根据用户id查询用户相关信息")
    @ApiImplicitParam(name = "tourId", value = "用户id", required = true, dataType = "Integer", paramType = "query")
    @RequestMapping(value = { "/findUserById" }, method = RequestMethod.GET)
    public User findUserById(Integer tourId) {
	User user = userService.findUserById(tourId);
	if (user == null) {
	    // 没有查询到数据
	    throw new MyRuntimeException(ResultEnum.NoDataSuccess);
	}
	return user;
    }

    // 判断用户账号是否存在
    @ApiOperation(value = "判断用户账号是否存在", notes = "根据关键字判断用户账号是否存在")
    @ApiImplicitParam(name = "account", value = "检索关键字", required = true, dataType = "String", paramType = "query")
    @RequestMapping(value = { "/checkAccount" }, method = RequestMethod.GET)
    public Boolean checkAccount(String account) {
	return userService.checkAccount(account);
    }
}

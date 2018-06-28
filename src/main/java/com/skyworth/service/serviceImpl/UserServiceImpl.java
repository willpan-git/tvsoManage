/**
 * 
 */
package com.skyworth.service.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.skyworth.entity.AdminUser;
import com.skyworth.entity.ResultEnum;
import com.skyworth.entity.User;
import com.skyworth.exception.MyException;
import com.skyworth.mapper.UserMapper;
import com.skyworth.service.UserService;
import com.skyworth.util.LogUtil;

/**
 * Copyright: Copyright (c) 2018 skyworth
 * 
 * @ClassName: UserServiceImpl.java
 * @Description: 服务层
 *
 * @version: v1.0.0
 * @author: Administrator
 * @date: 2018��5��7�� ����2:39:54
 *
 *        Modification History: Date Author Version Description
 *        ---------------------------------------------------------*
 *        2018��5��7�� Administrator v1.0.0 �޸�ԭ��
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public AdminUser findUserByAccount(String account) {
	return userMapper.findUserByAccount(account);
    }

    @Override
    public User findUserById(Integer tourId) {
	return userMapper.findUserById(tourId);
    }

    @Override
    public List<User> queryUserList(Map<String, Object> map) {
	return userMapper.queryUserList(map);
    }

    // 开启事务
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000, rollbackFor = Exception.class)
    public void addUser(User user) {
	try {
	    userMapper.addUser(user);
	} catch (Exception e) {
	    // 打印错误日志
	    LogUtil.printLog(e, Exception.class);
	    // 抛出错误
	    throw new MyException(ResultEnum.DBException);
	}
    }

    @Override
    public void updateUser(User user) {
	userMapper.updateUser(user);
    }

    @Override
    public void updatePassword(String tourAccount, String tourPassword) {

	HashMap<String, Object> map = new HashMap<String, Object>();

	map.put("tourAccount", tourAccount);

	map.put("tourPassword", tourPassword);

	userMapper.updatePassword(map);
    }

    @Override
    public void unableUser(Integer tourId) {
	userMapper.unableUser(tourId);
    }

    @Override
    public void effectUser(Integer tourId) {
	userMapper.effectUser(tourId);
    }

    @Override
    public void deleteUser(Integer tourId) {
	userMapper.deleteUser(tourId);
    }

    @Override
    public List<Map<String, String>> queryUserByKey(String keyWord) {
	return userMapper.queryUserByKey(keyWord);
    }

    @Override
    public boolean checkAccount(String account) {
	return userMapper.checkAccount(account);
    }
}

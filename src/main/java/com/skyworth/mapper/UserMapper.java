package com.skyworth.mapper;

import java.util.List;
import java.util.Map;

import com.skyworth.entity.AdminUser;
import com.skyworth.entity.User;

/**
 * Copyright: Copyright (c) 2018 skyworth
 * 
 * @ClassName: UserMapper.java
 * @Description: Dao层
 *
 * @version: v1.0.0
 * @author: Administrator
 * @date: 2018��5��7�� ����4:31:15
 *
 *        Modification History: Date Author Version Description
 *        ---------------------------------------------------------*
 *        2018��5��7�� Administrator v1.0.0 �޸�ԭ��
 */
public interface UserMapper {
    AdminUser findUserByAccount(String account);
    
    public User findUserById(Integer tourId);

    List<User> queryUserList(Map<String, Object> map);

    void addUser(User user);

    void updateUser(User user);

    void updatePassword(Map<String, Object> map);

    void unableUser(Integer tourId);
    
    void effectUser(Integer tourId);

    void deleteUser(Integer tourId);

    List<Map<String, String>> queryUserByKey(String keyWord);
    
    boolean checkAccount(String account);
}

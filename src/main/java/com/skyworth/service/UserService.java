/**
 * 
 */
package com.skyworth.service;

import java.util.List;
import java.util.Map;

import com.skyworth.entity.AdminUser;
import com.skyworth.entity.User;

/**
 * Copyright: Copyright (c) 2018 skyworth
 * 
 * @ClassName: UserService.java
 * @Description: ����Ĺ�������
 *
 * @version: v1.0.0
 * @author: Administrator
 * @date: 2018��5��7�� ����2:35:51
 *
 *        Modification History: Date Author Version Description
 *        ---------------------------------------------------------*
 *        2018��5��7�� Administrator v1.0.0 �޸�ԭ��
 */
public interface UserService {
    AdminUser findUserByAccount(String account);

    User findUserById(Integer tourId);

    List<User> queryUserList(Map<String, Object> map);

    void addUser(User user);

    void updateUser(User user);

    void updatePassword(String account, String password);

    void unableUser(Integer tourID);

    void effectUser(Integer tourID);

    void deleteUser(Integer tourId);

    List<Map<String, String>> queryUserByKey(String keyWord);

    boolean checkAccount(String account);
}

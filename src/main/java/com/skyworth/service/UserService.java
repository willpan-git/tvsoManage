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
    public AdminUser findUserByAccount(String account);

    public User findUserById(Integer tourId);

    public List<User> queryUserList(Map<String, Object> map);

    public void addUser(User user);

    public void updateUser(User user);

    public void updatePassword(String account, String password);

    public void unableUser(Integer tourID);

    public void effectUser(Integer tourID);

    public void deleteUser(Integer tourId);

    public List<Map<String, String>> queryUserByKey(String keyWord);

    boolean checkAccount(String account);
}

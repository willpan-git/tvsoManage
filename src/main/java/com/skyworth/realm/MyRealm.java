/**
 * 
 */
package com.skyworth.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.skyworth.entity.AdminUser;
import com.skyworth.service.UserService;

/**
 * Copyright: Copyright (c) 2018 skyworth
 * 
 * @ClassName: MyRealm.java
 * @Description:自定义realm
 *
 * @version: v1.0.0
 * @author: Administrator
 * @date: 2018年5月14日 下午3:33:38
 *
 *        Modification History: Date Author Version Description
 *        ---------------------------------------------------------* 2018年5月14日
 *        Administrator v1.0.0 修改原因
 */
public class MyRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;

    /**
     * 在认证、授权内部实现机制中都有提到，最终处理都将交给Real进行处理。因为在Shiro中，最终是通过Realm来获取应用程序中的用户、角色及权限信息的。通常情况下，在Realm中会直接从我们的数据源中获取Shiro需要的验证信息。可以说，Realm是专用于安全框架的DAO.
     * Shiro的认证过程最终会交由Realm执行，这时会调用Realm的getAuthenticationInfo(token)方法。
     * 该方法主要执行以下操作:
     *
     * 检查提交的进行认证的令牌信息 根据令牌信息从数据源(通常为数据库)中获取用户信息 对用户信息进行匹配验证。
     * 验证通过将返回一个封装了用户信息的AuthenticationInfo实例。
     * 验证失败则抛出AuthenticationException异常信息。而在我们的应用程序中要做的就是自定义一个Realm类，继承AuthorizingRealm抽象类，重载doGetAuthenticationInfo()，重写获取用户信息的方法。
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
	// 1.从主体传过来的认证信息中，获取用户名,密码
	String account = (String) token.getPrincipal();
	// String password = new String((char[]) token.getCredentials());

	// 2.通过用户名去到数据库中获取凭证
	AdminUser adminUser = this.userService.findUserByAccount(account);

	// 判断用户是否存在
	if (adminUser == null) {
	    throw new UnknownAccountException();
	}
	// 判断用户是否有效
	if (adminUser.getAdminIsenable() == 0) {
	    throw new LockedAccountException();
	}

	// 3.加密：MD5+salt，在这里添加盐值,以用户名作为盐值
	ByteSource salt = ByteSource.Util.bytes(adminUser.getAdminName());

	String realName = this.getName();

	// 4.验证凭证信息(密码信息)
	SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(account,
		adminUser.getAdminPassword(), salt, realName);

	// 5.当shiro验证成功，把用户信息放在session里
//	Session session = SecurityUtils.getSubject().getSession();  
//	       session.setAttribute("userSession", account);  
//	       session.setAttribute("userSessionId", adminUser.);  

	return authenticationInfo;
    }

    /**
     * 授权用户权限 授权的方法是在碰到<shiro:hasPermission name=''></shiro:hasPermission>标签的时候调用的
     * ,它会去检测shiro框架中的权限(这里的permissions)是否包含有该标签的name值,如果有,里面的内容显示
     * ,如果没有,里面的内容不予显示(这就完成了对于权限的认证.)
     * 
     * shiro的权限授权是通过继承AuthorizingRealm抽象类，重载doGetAuthorizationInfo();
     * 当访问到页面的时候，链接配置了相应的权限或者shiro标签才会执行此方法否则不会执行，所以如果只是简单的身份认证没有权限的控制的话，那么这个方法可以不进行实现，直接返回null即可。
     * 在这个方法中主要是使用类：SimpleAuthorizationInfo 进行角色的添加和权限的添加。
     * authorizationInfo.addRole(role.getRole());
     * authorizationInfo.addStringPermission(p.getPermission());
     * 当然也可以添加set集合：roles是从数据库查询的当前用户的角色，stringPermissions是从数据库查询的当前用户对应的权限
     * authorizationInfo.setRoles(roles);
     * authorizationInfo.setStringPermissions(stringPermissions);
     * 就是说如果在shiro配置文件中添加了filterChainDefinitionMap.put(“/add”, “perms[权限添加]”);
     * 就说明访问/add这个链接必须要有“权限添加”这个权限才可以访问，
     * 如果在shiro配置文件中添加了filterChainDefinitionMap.put(“/add”,
     * “roles[100002]，perms[权限添加]”);
     * 就说明访问/add这个链接必须要有“权限添加”这个权限和具有“100002”这个角色才可以访问。
     * 
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
	// 1.从主体传过来的认证信息中，获取用户名
	// String acoount = (String) principals.getPrimaryPrincipal();
	// 查询用户名称
	// User user = userService.findUserByAccount(acoount);
	// 添加角色和权限
	SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
	// for (Role role:user.getRoles()) {
	// //添加角色
	// simpleAuthorizationInfo.addRole(role.getRoleName());
	// for (Permission permission:role.getPermissions()) {
	// //添加权限
	// simpleAuthorizationInfo.addStringPermission(permission.getPermission());
	// }
	// }
	return simpleAuthorizationInfo;

    }
}
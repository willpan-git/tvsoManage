/**
 * 
 */
package com.skyworth.entity;

/**   
* Copyright: Copyright (c) 2018 skyworth
* 
* @ClassName: AdminUser.java
* @Description: 用户登入类
*
* @version: v1.0.0
* @author: Administrator
* @date: 2018年5月17日 下午4:36:48 
*
* Modification History:
* Date         Author          Version            Description
*---------------------------------------------------------*
* 2018年5月17日     Administrator           v1.0.0               修改原因
*/
public class AdminUser {
	private String adminAccount;
	private String adminPassword;
	private String adminName;
	private int adminIsenable;
	/**
	 * @return the adminIsenable
	 */
	public int getAdminIsenable() {
		return adminIsenable;
	}
	/**
	 * @param adminIsenable the adminIsenable to set
	 */
	public void setAdminIsenable(int adminIsenable) {
		this.adminIsenable = adminIsenable;
	}
	/**
	 * @return the adminAccount
	 */
	public String getAdminAccount() {
		return adminAccount;
	}
	/**
	 * @param adminAccount the adminAccount to set
	 */
	public void setAdminAccount(String adminAccount) {
		this.adminAccount = adminAccount;
	}
	/**
	 * @return the adminPassword
	 */
	public String getAdminPassword() {
		return adminPassword;
	}
	/**
	 * @param adminPassword the adminPassword to set
	 */
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	/**
	 * @return the adminName
	 */
	public String getAdminName() {
		return adminName;
	}
	/**
	 * @param adminName the adminName to set
	 */
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	
}

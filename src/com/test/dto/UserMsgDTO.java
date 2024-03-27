package com.test.dto;

import java.util.Date;

/**
 * 用于封装USER_MSG表中一行用户信息
 * 
 * @author admin
 *
 */
public class UserMsgDTO implements java.io.Serializable {

	private static final long serialVersionUID = -909148873956710879L;
	/**
	 * 用户编号
	 */
	private Integer userId;
	/**
	 * 用户名
	 */
	private String userName;
	/**
	 * 用户密码
	 */
	private String userPassword;
	/**
	 * 用户住址
	 */
	private String userAddress;
	/**
	 * 用户邮箱
	 */
	private String userEmail;
	/**
	 * 用户出生日期
	 */
	private Date userBirthday;
	/**
	 * 用户联系电话
	 */
	private String userTelephone;
	/**
	 * 用户邮编
	 */
	private String userPostcode;
	/**
	 * 用户权限：0为管理员，1为普通用户
	 */
	private Integer powerId;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Date getUserBirthday() {
		return userBirthday;
	}

	public void setUserBirthday(Date userBirthday) {
		this.userBirthday = userBirthday;
	}

	public String getUserTelephone() {
		return userTelephone;
	}

	public void setUserTelephone(String userTelephone) {
		this.userTelephone = userTelephone;
	}

	public String getUserPostcode() {
		return userPostcode;
	}

	public void setUserPostcode(String userPostcode) {
		this.userPostcode = userPostcode;
	}

	public Integer getPowerId() {
		return powerId;
	}

	public void setPowerId(Integer powerId) {
		this.powerId = powerId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
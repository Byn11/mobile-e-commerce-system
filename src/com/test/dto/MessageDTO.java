package com.test.dto;

import java.io.Serializable;

public class MessageDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5589298484810498527L;
	/**
	 * 消息编号
	 */
	private Integer messageId;
	/**
	 * 投稿人姓名
	 */
	private String userName;
	/**
	 * 投稿内容
	 */
	private String messageContext;
	/**
	 * 投稿主题
	 */
	private String messageSubject;
	/**
	 * 投稿人邮箱
	 */
	private String userEmail;
	public Integer getMessageId() {
		return messageId;
	}
	public void setMessageId(Integer messageId) {
		this.messageId = messageId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getMessageContext() {
		return messageContext;
	}
	public void setMessageContext(String messageContext) {
		this.messageContext = messageContext;
	}
	public String getMessageSubject() {
		return messageSubject;
	}
	public void setMessageSubject(String messageSubject) {
		this.messageSubject = messageSubject;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}

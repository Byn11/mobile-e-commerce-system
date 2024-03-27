package com.test.dto;

import java.util.Date;

/**
 * 用于封装ORDERS表中一行订单信息
 * 
 * @author Administrator
 *
 */
public class OrdersDTO implements java.io.Serializable {

	private static final long serialVersionUID = -3800725790300352439L;
	/**
	 * 订单编号
	 */
	private Integer orderId;
	/**
	 * 用户编号
	 */
	private Integer userId;
	/**
	 * 下订单时间
	 */
	private Date orderDate;
	/**
	 * 订单状态：1、未发货，2、发货，3、收货，4、已付款
	 */
	private Integer orderStatus;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Integer getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

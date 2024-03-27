package com.test.dto;

/**
 * 用于封装ORDER_DETAILS表中的一行订单明细信息
 * 
 * @author Administrator
 *
 */
public class OrderDetailsDTO implements java.io.Serializable {

	private static final long serialVersionUID = -8105960241582776823L;
	/**
	 * 订单明细编号
	 */
	private Integer orderDetailId;
	/**
	 * 订单编号
	 */
	private Integer orderId;
	/**
	 * 商品编号
	 */
	private Integer productId;
	/**
	 * 商品颜色编号
	 */
	private Integer productColorId;
	/**
	 * 商品尺码编号
	 */
	private Integer productSizeId;
	/**
	 * 商品数量
	 */
	private Integer productQty;

	public Integer getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(Integer orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Integer getProductColorId() {
		return productColorId;
	}

	public void setProductColorId(Integer productColorId) {
		this.productColorId = productColorId;
	}

	public Integer getProductSizeId() {
		return productSizeId;
	}

	public void setProductSizeId(Integer productSizeId) {
		this.productSizeId = productSizeId;
	}

	public Integer getProductQty() {
		return productQty;
	}

	public void setProductQty(Integer productQty) {
		this.productQty = productQty;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productColorId == null) ? 0 : productColorId.hashCode());
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + ((productSizeId == null) ? 0 : productSizeId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderDetailsDTO other = (OrderDetailsDTO) obj;
		if (productColorId == null) {
			if (other.productColorId != null)
				return false;
		} else if (!productColorId.equals(other.productColorId))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (productSizeId == null) {
			if (other.productSizeId != null)
				return false;
		} else if (!productSizeId.equals(other.productSizeId))
			return false;
		return true;
	}

}

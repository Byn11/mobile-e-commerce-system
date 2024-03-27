package com.test.dto;

/**
 * 用于封装PRODUCT_SIZES表中的一行商品尺码信息
 * 
 * @author Administrator
 *
 */
public class ProductSizesDTO implements java.io.Serializable {

	private static final long serialVersionUID = 2947461636449441305L;
	/**
	 * 商品尺码编号
	 */
	private Integer productSizeId;
	/**
	 * 商品编号
	 */
	private Integer productId;
	/**
	 * 商品尺码完整信息
	 */
	private SizesDTO size;
	/**
	 * 商品价格
	 */
	private Double productPrice;
	
	public Integer getProductSizeId() {
		return productSizeId;
	}

	public void setProductSizeId(Integer productSizeId) {
		this.productSizeId = productSizeId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public SizesDTO getSize() {
		return size;
	}

	public void setSize(SizesDTO size) {
		this.size = size;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

}

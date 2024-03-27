package com.test.dto;

/**
 * 用于封装PRODUCTS表中的一行商品信息
 * 
 * @author admin
 *
 */
public class ProductsDTO implements java.io.Serializable {
	private static final long serialVersionUID = -5553750559045871208L;
	/**
	 * 商品编号
	 */
	private Integer productId;
	/**
	 * 商品名称
	 */
	private String productName;
	/**
	 * 商品价格
	 */
	private Double productPrice;
	/**
	 * 是否有货：1表示有货，0表示无货
	 */
	private Integer productAvailability;
	/**
	 * 商品大图片
	 */
	private String productBigImage;
	/**
	 * 商品小图片
	 */
	private String productSmallImage;
	/**
	 * 商品品牌信息
	 */
	private BrandsDTO brands;
	/**
	 * 商品简介
	 */
	private String productDescription;

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public Integer getProductAvailability() {
		return productAvailability;
	}

	public void setProductAvailability(Integer productAvailability) {
		this.productAvailability = productAvailability;
	}

	public String getProductBigImage() {
		return productBigImage;
	}

	public void setProductBigImage(String productBigImage) {
		this.productBigImage = productBigImage;
	}

	public String getProductSmallImage() {
		return productSmallImage;
	}

	public void setProductSmallImage(String productSmallImage) {
		this.productSmallImage = productSmallImage;
	}

	public BrandsDTO getBrands() {
		return brands;
	}

	public void setBrands(BrandsDTO brands) {
		this.brands = brands;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

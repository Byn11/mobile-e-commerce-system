package com.test.dto;

/**
 * 用于封装PORDUCT_COLORS表中的一行商品颜色信息
 * 
 * @author Administrator
 *
 */
public class ProductColorsDTO implements java.io.Serializable {

	private static final long serialVersionUID = -6293643660592040242L;
	/**
	 * 商品颜色编号
	 */
	private Integer productColorId;
	/**
	 * 商品编号
	 */
	private Integer productId;
	/**
	 * 商品颜色完整信息
	 */
	private ColorsDTO color;

	public Integer getProductColorId() {
		return productColorId;
	}

	public void setProductColorId(Integer productColorId) {
		this.productColorId = productColorId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public ColorsDTO getColor() {
		return color;
	}

	public void setColor(ColorsDTO color) {
		this.color = color;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

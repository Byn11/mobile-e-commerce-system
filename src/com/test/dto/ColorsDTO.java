package com.test.dto;

/**
 * 用于封装COLORS表中的一行颜色信息
 * 
 * @author Administrator
 *
 */
public class ColorsDTO implements java.io.Serializable {

	private static final long serialVersionUID = -8986576426290110630L;
	/**
	 * 颜色编号
	 */
	private Integer colorId;
	/**
	 * 颜色名称
	 */
	private String colorName;

	public Integer getColorId() {
		return colorId;
	}

	public void setColorId(Integer colorId) {
		this.colorId = colorId;
	}

	public String getColorName() {
		return colorName;
	}

	public void setColorName(String colorName) {
		this.colorName = colorName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

package com.test.dto;

/**
 * 用于封装SIZES表中的一行尺码信息
 * 
 * @author Administrator
 *
 */
public class SizesDTO implements java.io.Serializable {

	private static final long serialVersionUID = 1573571178935071398L;
	/**
	 * 尺码编号
	 */
	private Integer sizeId;
	/**
	 * 尺码名称
	 */
	private String sizeName;

	public Integer getSizeId() {
		return sizeId;
	}

	public void setSizeId(Integer sizeId) {
		this.sizeId = sizeId;
	}

	public String getSizeName() {
		return sizeName;
	}

	public void setSizeName(String sizeName) {
		this.sizeName = sizeName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

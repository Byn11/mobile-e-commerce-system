package com.test.dto;

/**
 * 用于封装BRANDS表中的一行品牌信息
 * 
 * @author admin
 *
 */
public class BrandsDTO implements java.io.Serializable {

	private static final long serialVersionUID = 2838216171011352716L;

	/**
	 * 品牌编号
	 */
	private Integer brandId;
	/**
	 * 当前品牌的菜单信息
	 */
	private MenusDTO menus;
	/**
	 * 品牌名称
	 */
	private String brandName;

	public Integer getBrandId() {
		return brandId;
	}

	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}

	public MenusDTO getMenus() {
		return menus;
	}

	public void setMenus(MenusDTO menus) {
		this.menus = menus;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

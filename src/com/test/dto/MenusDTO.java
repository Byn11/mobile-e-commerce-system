package com.test.dto;

/**
 * 用于封装MENUS表中的一行菜单信息
 * 
 * @author admin
 *
 */
public class MenusDTO implements java.io.Serializable {

	private static final long serialVersionUID = -6704719552412889265L;
	/**
	 * 菜单编号
	 */
	private Integer menuId;
	/**
	 * 菜单名称
	 */
	private String menuName;

	public Integer getMenuId() {
		return menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

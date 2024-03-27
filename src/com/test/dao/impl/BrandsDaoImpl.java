package com.test.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.test.dao.BrandsDAO;
import com.test.dto.BrandsDTO;
import com.test.dto.MenusDTO;

public class BrandsDaoImpl implements BrandsDAO {

	@Override
	public List<BrandsDTO> selectAll(Connection conn) throws SQLException {
		String sql = "SELECT BRAND_ID,MENU_ID,BRAND_NAME FROM BRANDS";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<BrandsDTO> list = new ArrayList<BrandsDTO>();
		BrandsDTO dto = null;
		while (rs.next()) {
			dto = new BrandsDTO();
			dto.setBrandId(rs.getInt("BRAND_ID"));
			dto.setBrandName(rs.getString("BRAND_NAME"));
			MenusDTO menus = new MenusDTO();
			menus.setMenuId(rs.getInt("MENU_ID"));
			dto.setMenus(menus);
			list.add(dto);
		}
		return list;
	}

}

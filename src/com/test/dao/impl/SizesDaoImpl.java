package com.test.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.test.dao.SizesDAO;
import com.test.dto.SizesDTO;

public class SizesDaoImpl implements SizesDAO {

	@Override
	public List<SizesDTO> selectAll(Connection conn) throws SQLException {
		String sql = "SELECT SIZE_ID,SIZE_NAME FROM SIZES";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<SizesDTO> list = new ArrayList<SizesDTO>();
		SizesDTO dto = null;
		while (rs.next()) {
			dto = new SizesDTO();
			dto.setSizeId(rs.getInt("SIZE_ID"));
			dto.setSizeName(rs.getString("SIZE_NAME"));
			list.add(dto);
		}
		return list;
	}

}

package com.test.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.test.dao.ColorsDAO;
import com.test.dto.ColorsDTO;

public class ColorsDaoImpl implements ColorsDAO {

	@Override
	public List<ColorsDTO> selectAll(Connection conn) throws SQLException {
		String sql = "SELECT COLOR_ID,COLOR_NAME FROM COLORS";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<ColorsDTO> list = new ArrayList<ColorsDTO>();
		ColorsDTO dto = null;
		while (rs.next()) {
			dto = new ColorsDTO();
			dto.setColorId(rs.getInt("COLOR_ID"));
			dto.setColorName(rs.getString("COLOR_NAME"));
			list.add(dto);
		}
		return list;
	}

}

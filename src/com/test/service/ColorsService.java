package com.test.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.test.common.DbUtils;
import com.test.dao.ColorsDAO;
import com.test.dao.impl.ColorsDaoImpl;
import com.test.dto.ColorsDTO;

public class ColorsService {

	private ColorsDAO colorsDAO;

	public ColorsService() {
		this.colorsDAO = new ColorsDaoImpl();
	}

	/**
	 * 获得所有颜色信息
	 * 
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public List<ColorsDTO> selectAll() throws ClassNotFoundException, SQLException {
		Connection conn = DbUtils.getConnection();
		try {
			return this.colorsDAO.selectAll(conn);
		} finally {
			conn.close();
		}
	}
}

package com.test.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.test.common.DbUtils;
import com.test.dao.SizesDAO;
import com.test.dao.impl.SizesDaoImpl;
import com.test.dto.SizesDTO;

public class SizesService {

	private SizesDAO sizesDAO;

	public SizesService() {
		this.sizesDAO = new SizesDaoImpl();
	}

	/**
	 * 获得所有尺码信息
	 * 
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public List<SizesDTO> selectAll() throws ClassNotFoundException, SQLException {
		Connection conn = DbUtils.getConnection();
		try {
			return this.sizesDAO.selectAll(conn);
		} finally {
			conn.close();
		}
	}
}

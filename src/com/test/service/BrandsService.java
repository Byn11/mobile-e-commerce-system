package com.test.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.test.common.DbUtils;
import com.test.dao.BrandsDAO;
import com.test.dao.impl.BrandsDaoImpl;
import com.test.dto.BrandsDTO;

public class BrandsService {

	private BrandsDAO brandsDAO;

	public BrandsService() {
		this.brandsDAO = new BrandsDaoImpl();
	}

	/**
	 * 查询所有品牌信息
	 * 
	 * @return 返回java.util.List类型
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public List<BrandsDTO> selectAll() throws ClassNotFoundException, SQLException {
		Connection conn = DbUtils.getConnection();
		try {
			return this.brandsDAO.selectAll(conn);
		} finally {
			conn.close();
		}
	}
}

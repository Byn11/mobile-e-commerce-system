package com.test.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.test.dao.ProductColorsDAO;

public class ProductColorsDaoImpl implements ProductColorsDAO {

	@Override
	public boolean insert(Connection conn, Integer productId, Integer colorId) throws SQLException {
		String sql = "INSERT INTO PRODUCT_COLORS VALUES(PRODUCT_COLOR_SEQ.NEXTVAL,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, productId);
		ps.setInt(2, colorId);
		int rows = ps.executeUpdate();
		if (rows > 0) {
			return true;
		}
		return false;
	}

}

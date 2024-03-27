package com.test.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.test.dao.ProductSizesDAO;

public class ProductSizesDaoImpl implements ProductSizesDAO {

	@Override
	public boolean insert(Connection conn, Integer productId, Integer sizeId,Double productPrice) throws SQLException {
		String sql = "INSERT INTO PRODUCT_SIZES VALUES(PRODUCT_SIZE_SEQ.NEXTVAL,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, productId);
		ps.setInt(2, sizeId);
		ps.setDouble(3, productPrice);
		int rows = ps.executeUpdate();
		if (rows > 0) {
			return true;
		}
		return false;
	}

}

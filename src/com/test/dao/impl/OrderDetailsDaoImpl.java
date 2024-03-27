package com.test.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.test.dao.OrderDetailsDAO;
import com.test.dto.OrderDetailsDTO;

public class OrderDetailsDaoImpl implements OrderDetailsDAO {

	@Override
	public boolean insert(Connection conn, OrderDetailsDTO dto, Integer orderId)
			throws SQLException {
		String sql="insert into order_details values(order_detail_seq.nextval,?,?,?,?,?)";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, orderId);
		ps.setInt(2, dto.getProductId());
		ps.setInt(3, dto.getProductColorId());
		ps.setInt(4, dto.getProductSizeId());
		ps.setInt(5, dto.getProductQty());
		int rows=ps.executeUpdate();
		if(rows>0){
			return true;
		}
		return false;
	}


}

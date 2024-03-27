package com.test.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.test.dao.OrdersDAO;
import com.test.dto.OrdersDTO;

public class OrdersDaoImpl implements OrdersDAO {

	@Override
	public Integer selectOrderId(Connection conn) throws SQLException {
		String sql="select order_seq.nextval from dual";
		PreparedStatement ps=conn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		rs.next();
		return rs.getInt(1);
	}

	@Override
	public boolean insert(Connection conn, OrdersDTO dto) throws SQLException {
		String sql="insert into orders values(?,?,sysdate,1)";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setInt(1, dto.getOrderId());
		ps.setInt(2, dto.getUserId());
		int rows=ps.executeUpdate();
		if(rows>0){
			return true;
		}
		return false;
	}

}

package com.test.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.test.dto.OrdersDTO;

/**
 * 用于定义对ORDERS表进行操作的方法
 * @author user
 *
 */
public interface OrdersDAO {
	/**
	 * 通过订单序列(order_seq)获得最新的订单编号
	 * @param conn 数据库连接对象
	 * @return 返回订单编号
	 * @throws SQLException
	 */
	public abstract Integer selectOrderId(Connection conn) throws SQLException;
	/**
	 * 向ORDERS表中添加一行新的订单信息
	 * @param conn 数据库连接对象
	 * @param dto 新订单信息
	 * @return  添加成功返回TRUE，失败返回false
	 * @throws SQLException
	 */
	public abstract boolean insert(Connection conn,OrdersDTO dto) throws SQLException;
}

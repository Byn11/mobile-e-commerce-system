package com.test.dao;

import java.sql.Connection;
import java.sql.SQLException;

import com.test.dto.OrderDetailsDTO;

/**
 * 用于定义对order_details表进行操作的方法
 * @author user
 *
 */
public interface OrderDetailsDAO {
/**
 * 向ORDER_DETAILS表中添加一行新的订单明细信息
 * @param conn 数据库连接信息
 * @param dto 订单明细信息
 * @param orderId 订单编号
 * @return 添加成功返回true，否则返回false
 * @throws SQLException
 */
	public abstract boolean insert(Connection conn,OrderDetailsDTO dto,Integer orderId) throws SQLException;

}

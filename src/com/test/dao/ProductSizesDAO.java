package com.test.dao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 用于定义对PRODUCT_SIZES表进行操作的方法
 * 
 * @author MSI
 *
 */
public interface ProductSizesDAO {

	/**
	 * 向PRODUCT_SIZES表中添加一行新的商品尺码信息
	 * 
	 * @param conn
	 *            数据库连接对象
	 * @param productId
	 *            商品编号
	 * @param sizeId
	 *            尺码编号
	 * @return 添加成功返回true，否则返回false
	 * @throws SQLException
	 */
	public abstract boolean insert(Connection conn, Integer productId, Integer sizeId,Double productPrice) throws SQLException;
}
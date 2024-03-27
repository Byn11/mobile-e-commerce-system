package com.test.dao;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 用于定义对PRODUCT_COLORS表进行操作的方法
 * 
 * @author MSI
 *
 */
public interface ProductColorsDAO {
	/**
	 * 向PRODUCT_COLORS表中添加一行新的商品颜色信息
	 * @param conn 数据库连接对象
	 * @param productId 商品编号
	 * @param colorId 颜色编号
	 * @return 添加成功返回true，否则返回false
	 * @throws SQLException
	 */
	public abstract boolean insert(Connection conn, Integer productId, Integer colorId) throws SQLException;
}
package com.test.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.test.dto.ColorsDTO;

/**
 * 用于定义对COLORS表进行操作的方法
 * 
 * @author MSI
 *
 */
public interface ColorsDAO {
	/**
	 * 获得COLORS表中所有的颜色信息
	 * 
	 * @param conn
	 *            数据库连接对象
	 * @return 返回java.util.List类型
	 */
	public abstract List<ColorsDTO> selectAll(Connection conn) throws SQLException;
}

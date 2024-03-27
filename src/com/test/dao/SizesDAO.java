package com.test.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import com.test.dto.SizesDTO;

/**
 * 用于定义对SIZES表进行操作的方法
 * 
 * @author MSI
 *
 */
public interface SizesDAO {
	/**
	 * 获得SIZES表中所有的尺码信息
	 * 
	 * @param conn
	 *            数据库连接对象
	 * @return 返回java.util.List类型
	 */
	public abstract List<SizesDTO> selectAll(Connection conn)  throws SQLException;;
}

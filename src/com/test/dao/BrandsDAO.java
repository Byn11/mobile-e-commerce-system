package com.test.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.test.dto.BrandsDTO;

/**
 * 用于定义对BRANDS表进行操作的方法
 * 
 * @author MSI
 *
 */
public interface BrandsDAO {

	/**
	 * 查询BRANDS表中所有的品牌信息
	 * 
	 * @param conn
	 *            数据库连接对象
	 * @return 返回java.util.List类型
	 */
	public abstract List<BrandsDTO> selectAll(Connection conn) throws SQLException ;
}

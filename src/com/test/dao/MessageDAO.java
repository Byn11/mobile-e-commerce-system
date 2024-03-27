package com.test.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.test.dto.MessageDTO;

/**
 * 用于定义对表message操作的方法
 * @author user
 *
 */
public interface MessageDAO {
	/**
	 * 向message表中添加数据
	 * @param conn 数据库连接对象
	 * @param dto 新投稿信息
	 * @return true为添加成功，false为添加失败
	 * @throws SQLException
	 */
	public boolean insert(Connection conn,MessageDTO dto) throws SQLException ;
	/**
	 * 查询表中所有信息
	 * @param conn 数据库连接对象
	 * @return 返回所有投稿信息
	 * @throws SQLException
	 */
	public List<MessageDTO> selectAll(Connection conn) throws SQLException;
}

package com.test.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.test.dto.UserMsgDTO;

/**
 * 定义对表USER_MSG进行操作的方法
 * 
 * @author admin
 *
 */
public interface UserMsgDAO {

	/**
	 * 判断用户名是否存在
	 * 
	 * @param conn
	 *            数据库连接对象
	 * @param dto
	 *            用户信息
	 * @return 如果用户名存在返回true,否则返回false
	 * @throws SQLException
	 */
	public abstract boolean isExists(Connection conn, UserMsgDTO dto) throws SQLException;

	/**
	 * 向USER_MSG表中添加数据
	 * 
	 * @param conn
	 *            数据库连接对象
	 * @param dto
	 *            新用户信息
	 * @return 添加成功返回true,否则返回false
	 * @throws SQLException
	 */
	public abstract boolean insert(Connection conn, UserMsgDTO dto) throws SQLException;

	/**
	 * 查询USER_MSG表中指定名字的用户信息
	 * 
	 * @param conn
	 *            数据库连接对象
	 * @param dto
	 *            查询用户信息
	 * @return 返回com.test.dto.UserMsgDTO类型
	 * @throws SQLException
	 */
	public abstract UserMsgDTO selectByName(Connection conn, UserMsgDTO dto) throws SQLException;

	/**
	 * 判断USER_MSG表登录是否成功
	 * 
	 * @param conn
	 *            数据库连接对象
	 * @param dto
	 *            登录信息
	 * @return 登录成功返回true，并通过dto返回登录成功用户的所有信息。登录失败返回false
	 * @throws SQLException
	 */
	public abstract boolean login(Connection conn, UserMsgDTO dto) throws SQLException;
	/**
	 * 查询USER_MSG表中指定行的数据(分页功能)
	 * @param conn 数据库连接对象
	 * @param dto 查询信息
	 * @param startRow 起始行
	 * @param endRow 终止行
	 * @return
	 * @throws SQLException
	 */
	public abstract List<UserMsgDTO> selectPage(Connection conn,UserMsgDTO dto,int startRow,int endRow) throws SQLException;
	/**
	 * 查询USER_MSG表中满足条件数据的行数
	 * @param conn 数据库连接对象
	 * @param dto 查询条件
	 * @return 行数
	 * @throws SQLException
	 */
	public abstract Integer selectCount(Connection conn,UserMsgDTO dto) throws SQLException;
	
}

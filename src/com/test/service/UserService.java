package com.test.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.test.common.DbUtils;
import com.test.dao.UserMsgDAO;
import com.test.dao.impl.UserMsgDaoImpl;
import com.test.dto.UserMsgDTO;

/**
 * 用户模块的模型层
 * 
 * @author admin
 *
 */
public class UserService {

	/**
	 * 声明用户表对应的持久化层的对象
	 */
	private UserMsgDAO userMsgDAO;

	public UserService() {
		this.userMsgDAO = new UserMsgDaoImpl();
	}

	/**
	 * 判断用户名是否重复
	 * 
	 * @param dto
	 *            用户信息
	 * @return 如果重复返回true,否则返回false
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public boolean isExists(UserMsgDTO dto) throws ClassNotFoundException, SQLException {
		// 获得数据库连接对象
		Connection conn = DbUtils.getConnection();
		try {
			return this.userMsgDAO.isExists(conn, dto);
		} finally {
			conn.close();
		}
	}

	/**
	 * 注册新用户
	 * 
	 * @param dto
	 *            新用户信息
	 * @return 注册成功返回true,否则返回false
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public boolean insert(UserMsgDTO dto) throws ClassNotFoundException, SQLException {
		Connection conn = DbUtils.getConnection();
		try {
			boolean b = this.userMsgDAO.insert(conn, dto);
			if (b) {
				conn.commit();
				return true;
			}
			conn.rollback();
		} finally {
			conn.close();
		}
		return false;
	}

	/**
	 * 根据用户名获得用户的完整信息
	 * 
	 * @param dto
	 *            查询用户的条件
	 * @return 成功返回com.test.dto.UserMsgDTO类型，否则返回null
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public UserMsgDTO selectByName(UserMsgDTO dto) throws ClassNotFoundException, SQLException {
		Connection conn = DbUtils.getConnection();
		try {
			return this.userMsgDAO.selectByName(conn, dto);
		} finally {
			conn.close();
		}
	}

	/**
	 * 判断用户登录是否成功
	 * 
	 * @param dto
	 *            登录信息
	 * @return 登录成功返回true,并获得登录用户的完整信息。登录失败返回false。
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public boolean login(UserMsgDTO dto) throws ClassNotFoundException, SQLException {
		Connection conn = DbUtils.getConnection();
		try {
			return this.userMsgDAO.login(conn, dto);
		} finally {
			conn.close();
		}
	}
	public List<UserMsgDTO> selectPage(UserMsgDTO dto,int pageNumber,int pageRows) throws ClassNotFoundException,SQLException{
		//计算起始行与终止行数
		int endRow=pageNumber*pageRows;
		int startRow=endRow-pageRows+1;

		//调用持久化层的方法，获得数据
		Connection conn=DbUtils.getConnection();
		try{
			return this.userMsgDAO.selectPage(conn, dto, startRow, endRow);
		}finally{
			conn.close();
		}
	}
	/**
	 * 查询满足条件的用户/管理员的行数
	 * @param dto 查询条件
	 * @return
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public int selectCount(UserMsgDTO dto) throws ClassNotFoundException, SQLException{
		Connection conn = DbUtils.getConnection();
		try{
			return this.userMsgDAO.selectCount(conn, dto);
		}finally{
			conn.close();
		}
	}
}

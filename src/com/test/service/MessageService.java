package com.test.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.test.common.DbUtils;
import com.test.dao.MessageDAO;
import com.test.dao.impl.MessageDaoImpl;
import com.test.dto.MessageDTO;

public class MessageService {
	MessageDAO messageDAO=new MessageDaoImpl();
	/**
	 * 查询所有投稿信息
	 * @return 返回java.util.List类型
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public List<MessageDTO> selectAll() throws ClassNotFoundException, SQLException {
		Connection conn = DbUtils.getConnection();
		try {
			return this.messageDAO.selectAll(conn);
		} finally {
			conn.close();
		}
	
	}
	/**
	 * 
	 * @param dto
	 * @return
	 */
	public boolean insert(MessageDTO dto) throws ClassNotFoundException, SQLException{
		Connection conn = DbUtils.getConnection();
		try {
			boolean b = this.messageDAO.insert(conn, dto);
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

	public MessageService() {
		super();
		this.messageDAO = new MessageDaoImpl();
	}}

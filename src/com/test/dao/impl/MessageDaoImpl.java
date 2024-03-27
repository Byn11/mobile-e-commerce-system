package com.test.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.test.dao.MessageDAO;
import com.test.dto.MessageDTO;

public class MessageDaoImpl implements MessageDAO {

	@Override
	public boolean insert(Connection conn, MessageDTO dto) throws SQLException {
		String sql = "INSERT INTO message VALUES(message_seq.NEXTVAL,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, dto.getUserName());
		ps.setString(2, dto.getMessageContext());
		ps.setString(3, dto.getMessageSubject());
		ps.setString(4, dto.getUserEmail());
		int rows = ps.executeUpdate();
		if (rows > 0) {
			return true;
		}
		return false;
	}

	@Override
	public List<MessageDTO> selectAll(Connection conn) throws SQLException {
		String sql = "	SELECT message_id ,user_name ,"
				+"	message_context ,message_subject  ,"
				+"	user_email "
				+"	FROM message";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<MessageDTO> list = new ArrayList<MessageDTO>();
		MessageDTO dto = null;
		while(rs.next()){
			dto = new MessageDTO();
			//封装投稿信息
			dto.setMessageId(rs.getInt("message_id"));
			dto.setUserName(rs.getString("user_name"));
			dto.setMessageContext(rs.getString("message_context"));
			dto.setMessageSubject(rs.getString("message_subject"));
			dto.setUserEmail(rs.getString("user_email"));
			list.add(dto);
		}
		return list;
	}

}

package com.test.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.test.dao.UserMsgDAO;
import com.test.dto.UserMsgDTO;

/**
 * 实现对USER_MSG表进行操作的方法
 * 
 * @author admin
 *
 */
public class UserMsgDaoImpl implements UserMsgDAO {

	@Override
	public boolean isExists(Connection conn, UserMsgDTO dto) throws SQLException {
		String sql = "SELECT COUNT(*) AS C FROM USER_MSG WHERE USER_NAME=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, dto.getUserName());
		ResultSet rs = ps.executeQuery();
		// 因为COUNT(*)一定会产生数据，所以不需要判断next()方法是否成功。
		rs.next();
		int count = rs.getInt("C");
		if (count > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean insert(Connection conn, UserMsgDTO dto) throws SQLException {
		String sql = "INSERT INTO USER_MSG VALUES(USER_MSG_SEQ.NEXTVAL,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, dto.getUserName());
		ps.setString(2, dto.getUserPassword());
		ps.setString(3, dto.getUserAddress());
		ps.setString(4, dto.getUserEmail());
		ps.setDate(5, new java.sql.Date(dto.getUserBirthday().getTime()));
		ps.setString(6, dto.getUserTelephone());
		ps.setString(7, dto.getUserPostcode());
		ps.setInt(8, dto.getPowerId());
		int rows = ps.executeUpdate();
		if (rows > 0) {
			return true;
		}
		return false;
	}

	@Override
	public UserMsgDTO selectByName(Connection conn, UserMsgDTO dto) throws SQLException {
		String sql = "SELECT USER_ID,USER_NAME,USER_PASSWORD,"
				+ "USER_ADDRESS,USER_EMAIL,USER_BIRTHDAY,"
				+ "USER_TELEPHONE,USER_POSTCODE,POWER_ID "
				+ "FROM USER_MSG WHERE USER_NAME=? AND POWER_ID=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, dto.getUserName());
		ps.setInt(2, dto.getPowerId());
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			dto.setUserId(rs.getInt("USER_ID"));
			dto.setUserName(rs.getString("USER_NAME"));
			dto.setUserPassword(rs.getString("USER_PASSWORD"));
			dto.setUserAddress(rs.getString("USER_ADDRESS"));
			dto.setUserEmail(rs.getString("USER_EMAIL"));
			dto.setUserBirthday(rs.getDate("USER_BIRTHDAY"));
			dto.setUserTelephone(rs.getString("USER_TELEPHONE"));
			dto.setUserPostcode(rs.getString("USER_POSTCODE"));
			dto.setPowerId(rs.getInt("POWER_ID"));
			return dto;
		}
		return null;
	}

	@Override
	public boolean login(Connection conn, UserMsgDTO dto) throws SQLException {
		String sql = "SELECT USER_ID,USER_NAME,USER_PASSWORD,"
				+ "USER_ADDRESS,USER_EMAIL,USER_BIRTHDAY,"
				+ "USER_TELEPHONE,USER_POSTCODE,POWER_ID "
				+ "FROM USER_MSG WHERE USER_NAME=? AND "
				+ "USER_PASSWORD=? AND POWER_ID=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, dto.getUserName());
		ps.setString(2, dto.getUserPassword());
		ps.setInt(3, dto.getPowerId());
		ResultSet rs = ps.executeQuery();
		if(rs.next()){
			dto.setUserId(rs.getInt("USER_ID"));
			dto.setUserName(rs.getString("USER_NAME"));
			dto.setUserPassword(rs.getString("USER_PASSWORD"));
			dto.setUserAddress(rs.getString("USER_ADDRESS"));
			dto.setUserEmail(rs.getString("USER_EMAIL"));
			dto.setUserBirthday(rs.getDate("USER_BIRTHDAY"));
			dto.setUserTelephone(rs.getString("USER_TELEPHONE"));
			dto.setUserPostcode(rs.getString("USER_POSTCODE"));
			dto.setPowerId(rs.getInt("POWER_ID"));
			return true;
		}
		return false;
	}

	public List<UserMsgDTO> selectPage(Connection conn, UserMsgDTO dto,
			int startRow, int endRow) throws SQLException {
		StringBuilder sql = new StringBuilder("	SELECT *"
				+ "	FROM (SELECT ROW_NUMBER() OVER(ORDER BY USER_ID ASC) AS R,"
				+ "	       USER_ID," + "	       USER_NAME,"
				+ "	       USER_PASSWORD," + "	       USER_ADDRESS,"
				+ "	       USER_EMAIL," + "	       USER_BIRTHDAY,"
				+ "	       USER_TELEPHONE," + "	       USER_POSTCODE,"
				+ "	       POWER_ID" + "	      FROM USER_MSG"
				+ "	      WHERE POWER_ID=? ");
		if (dto.getUserName() != null && !dto.getUserName().equals("")) {
			sql.append(" AND USER_NAME like ? ");
		}
		sql.append(") WHERE R BETWEEN ? AND ?");
		PreparedStatement ps = conn.prepareStatement(sql.toString());
		int count = 1;
		ps.setInt(count++, dto.getPowerId());
		if (dto.getUserName() != null && !dto.getUserName().equals("")) {
			ps.setString(count++, "%" + dto.getUserName() + "%");
		}
		ps.setInt(count++, startRow);
		ps.setInt(count++, endRow);
		ResultSet rs = ps.executeQuery();
		List<UserMsgDTO> list = new ArrayList<>();
		UserMsgDTO msgDTO = null;
		while (rs.next()) {
			msgDTO = new UserMsgDTO();
			msgDTO.setUserId(rs.getInt("USER_ID"));
			msgDTO.setUserName(rs.getString("USER_NAME"));
			msgDTO.setUserPassword(rs.getString("USER_PASSWORD"));
			msgDTO.setUserAddress(rs.getString("USER_ADDRESS"));
			msgDTO.setUserEmail(rs.getString("USER_EMAIL"));
			msgDTO.setUserBirthday(rs.getDate("USER_BIRTHDAY"));
			msgDTO.setUserTelephone(rs.getString("USER_TELEPHONE"));
			msgDTO.setUserPostcode(rs.getString("USER_POSTCODE"));
			msgDTO.setPowerId(rs.getInt("POWER_ID"));
			list.add(msgDTO);
		}
		return list;
	}

	@Override
	public Integer selectCount(Connection conn, UserMsgDTO dto)
			throws SQLException {
		StringBuilder sql = new StringBuilder(
				"	SELECT COUNT(*) FROM USER_MSG WHERE POWER_ID=?");
		if (dto.getUserName() != null && !dto.getUserName().equals("")) {
			sql.append(" AND USER_NAME Like ? ");
		}
		PreparedStatement ps = conn.prepareStatement(sql.toString());
		int count = 1;
		ps.setInt(count++, dto.getPowerId());
		if (dto.getUserName() != null && !dto.getUserName().equals("")) {
			ps.setString(count++, "%" + dto.getUserName() + "%");
		}
		ResultSet rs = ps.executeQuery();
		rs.next();
		return rs.getInt(1);
	}
}

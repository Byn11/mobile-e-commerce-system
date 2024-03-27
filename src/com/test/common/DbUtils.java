package com.test.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 数据库的工具类
 * 
 * @author admin
 *
 */
public class DbUtils {

	/**
	 * 获得数据库连接对象
	 * 
	 * @return 返回java.sql.Connection类型
	 * @throws ClassNotFoundException
	 *             数据库驱动加载失败
	 * @throws SQLException
	 *             数据库连接失败
	 */
	public static Connection getConnection() throws ClassNotFoundException,
			SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:orcl", "system", "bfzy19970827");
		conn.setAutoCommit(false);
		return conn;
	}
}

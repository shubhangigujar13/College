package com.conn;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {

	private static Connection conn = null;

	public static Connection getConnection() {

		if (conn == null) {

			try {
				String url = "jdbc:mysql://localhost:3306/JDBCDemo";
				String uname = "root";
				String pw = "yash@1988";
				conn = DriverManager.getConnection(url, uname, pw);
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return conn;
	}

}
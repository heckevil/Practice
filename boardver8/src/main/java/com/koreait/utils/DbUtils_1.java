package com.koreait.utils;

import java.sql.*;

public class DbUtils {
	public static Connection getCon() throws Exception {
		final String DB_NAME = "prrboard";
		final String DRIVER = "com.mysql.cj.jdbc.Driver";
		final String URL = "jdbc:mysql://localhost:3308/" + DB_NAME;
		final String USER_NAME = "root";
		final String PASSWORD = "koreait";

		Class.forName(DRIVER);
		Connection con = DriverManager.getConnection(URL, USER_NAME, PASSWORD);

		return con;
	}

	public static void close(Connection con, PreparedStatement ps) {
		close(con, ps, null);
	}

	public static void close(Connection con, PreparedStatement ps, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}

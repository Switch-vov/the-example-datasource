package com.pc.jdbc.mydatasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

public class TestMyDataSource {
	@Test
	public void test() {
		MyDataSource dataSource = new MyDataSource();
		Connection ct = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			ct = dataSource.getConnection();
			String sql = "select * from users";
			pstmt = ct.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt("id") + " " + rs.getString("username") + " " + rs.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (ct != null) {
					ct.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}

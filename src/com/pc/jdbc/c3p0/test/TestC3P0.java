package com.pc.jdbc.c3p0.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.pc.jdbc.c3p0.utils.C3P0Utils;

public class TestC3P0 {

	@Test
	public void test_c3p0_getConnection() {
		Connection ct = C3P0Utils.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "select * from users";
			pstmt = ct.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				System.out.println(rs.getInt("id") + " " + rs.getString("username") + " " + rs.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

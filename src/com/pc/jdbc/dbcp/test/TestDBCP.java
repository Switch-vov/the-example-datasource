package com.pc.jdbc.dbcp.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

import com.pc.jdbc.dbcp.utils.DBCPUtils;

/**
 * 测试DBCP
 * 
 * @author Switch
 * @data 2016年9月30日
 * @version V1.0
 */
public class TestDBCP {
	@Test
	public void test_get_connection() {
		Connection ct = DBCPUtils.getConnection();
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

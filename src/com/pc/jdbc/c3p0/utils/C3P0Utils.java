package com.pc.jdbc.c3p0.utils;
/**
 * 基于C3P0的工具类，提供数据库源和连接
 * @author Switch
 * @data 2016年9月30日
 * @version V1.0
 */

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Utils {
	// 使用c3p0-config.xml中的默认配置
	private static DataSource dataSource = new ComboPooledDataSource();

	/**
	 * 获取数据源
	 * @return
	 */
	public static DataSource getDataSource() {
		return dataSource;
	}
	
	/**
	 * 获取连接
	 * @return
	 */
	public static Connection getConnection() {
		Connection ct = null;
		try {
			ct = dataSource.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ct;
	}
}

package com.pc.jdbc.mydatasource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * JDBC工具类
 * @author Switch
 * @data 2016年9月30日
 * @version V1.0
 */
public class JDBCUtils {
	private static String driver = null;
	private static String url = null;
	private static String username = null;
	private static String password = null;

	static {
		InputStream is = null;
		try {
			Properties props = new Properties();
			is = JDBCUtils.class.getClassLoader().getResourceAsStream("db.properties");
			props.load(is);
			driver = props.getProperty("mysql.driver");
			url = props.getProperty("mysql.url");
			username = props.getProperty("mysql.username");
			password = props.getProperty("mysql.password");
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException();
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
					throw new RuntimeException();
				}
			}
		}
	}

	/**
	 * 获得连接
	 * 
	 * @return 连接
	 */
	public static Connection getConnection() {
		Connection ct = null;
		try {
			Class.forName(driver);
			ct = DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return ct;
	}

}

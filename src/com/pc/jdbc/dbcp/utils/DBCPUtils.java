package com.pc.jdbc.dbcp.utils;
/**
 * 基于DBCP的工具类，提供数据库源和连接
 * @author Switch
 * @data 2016年9月30日
 * @version V1.0
 */

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class DBCPUtils {
	// 数据源
	private static DataSource dataSource = null;

	// 静态块初始化数据源
	static {
		try {
			// 获取文件流
			InputStream is = DBCPUtils.class.getClassLoader().getResourceAsStream("dbcpconfig.properties");
			// 创建Properties对象
			Properties props = new Properties();
			// 加载文件流
			props.load(is);
			dataSource = BasicDataSourceFactory.createDataSource(props);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 返回连接
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

	/**
	 * 返回数据源
	 * @return
	 */
	public static DataSource getDataSource() {
		return dataSource;
	}

}

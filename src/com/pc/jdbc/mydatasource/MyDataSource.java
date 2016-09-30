package com.pc.jdbc.mydatasource;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.logging.Logger;

import javax.sql.DataSource;

/**
 * 自定义连接池
 * 
 * @author Switch
 * @data 2016年9月30日
 * @version V1.0
 */
public class MyDataSource implements DataSource {
	/**
	 * 队列模拟线程池
	 */
	private static LinkedList<Connection> dataSource = null;

	/**
	 * 初始化连接池
	 */
	static {
		dataSource = new LinkedList<>();
		for (int i = 0; i < 20; i++) {
			// 通过工具类获取原始连接对象
			Connection ct = JDBCUtils.getConnection();
			// 将连接对象进行装饰，实现close的方法的覆盖，归还到连接池
			MyConnection myCt = new MyConnection(ct, dataSource);
			dataSource.add(myCt);
		}
	}

	/**
	 * 从线程池中获取连接
	 */
	@Override
	public Connection getConnection() throws SQLException {
		// 该版本并未考虑多线程及空闲连接和激活连接
		// 所以说当连接不够时，只会再添加一些连接
		if (dataSource.isEmpty()) {
			for (int i = 0; i < 5; i++) {
				dataSource.add(new MyConnection(JDBCUtils.getConnection(), dataSource));
			}
		}
		return dataSource.removeFirst();
	}

	@Override
	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter arg0) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setLoginTimeout(int arg0) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isWrapperFor(Class<?> arg0) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <T> T unwrap(Class<T> arg0) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Connection getConnection(String arg0, String arg1) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}

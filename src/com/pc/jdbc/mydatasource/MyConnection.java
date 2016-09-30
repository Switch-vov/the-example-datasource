package com.pc.jdbc.mydatasource;

import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.LinkedList;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

/**
 * 使用装饰者模式，简单的实现了连接关闭的复写，实现将关闭连接加入连接池
 * 
 * @author Switch
 * @data 2016年9月30日
 * @version V1.0
 */
public class MyConnection implements Connection {
	// 1.持有Connection接口和连接池
	Connection ct = null;
	LinkedList<Connection> dataSource = null;

	/**
	 * 通过传入的参数，初始化持有对象
	 * 
	 * @param ct
	 *            连接
	 * @param dataSource
	 *            连接池
	 */
	public MyConnection(Connection ct, LinkedList<Connection> dataSource) {
		this.ct = ct;
		this.dataSource = dataSource;
	}

	/**
	 * 将装饰后的连接重新加入到连接池中
	 */
	@Override
	public void close() throws SQLException {
		this.dataSource.add(this);
	}

	// 之后的方法，要使用哪个，就实现哪个，如果功能没改变，则可以直接使用持有对象ct的相同调用
	@Override
	public PreparedStatement prepareStatement(String arg0) throws SQLException {
		return this.ct.prepareStatement(arg0);
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
	public void abort(Executor arg0) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void clearWarnings() throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void commit() throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public Array createArrayOf(String arg0, Object[] arg1) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Blob createBlob() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Clob createClob() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NClob createNClob() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SQLXML createSQLXML() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Statement createStatement() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Statement createStatement(int arg0, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Statement createStatement(int arg0, int arg1, int arg2) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Struct createStruct(String arg0, Object[] arg1) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getAutoCommit() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getCatalog() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Properties getClientInfo() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getClientInfo(String arg0) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getHoldability() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public DatabaseMetaData getMetaData() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getNetworkTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getSchema() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTransactionIsolation() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Map<String, Class<?>> getTypeMap() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SQLWarning getWarnings() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isClosed() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isReadOnly() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isValid(int arg0) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String nativeSQL(String arg0) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CallableStatement prepareCall(String arg0) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CallableStatement prepareCall(String arg0, int arg1, int arg2) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CallableStatement prepareCall(String arg0, int arg1, int arg2, int arg3) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PreparedStatement prepareStatement(String arg0, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PreparedStatement prepareStatement(String arg0, int[] arg1) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PreparedStatement prepareStatement(String arg0, String[] arg1) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PreparedStatement prepareStatement(String arg0, int arg1, int arg2) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PreparedStatement prepareStatement(String arg0, int arg1, int arg2, int arg3) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void releaseSavepoint(Savepoint arg0) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void rollback() throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void rollback(Savepoint arg0) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setAutoCommit(boolean arg0) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setCatalog(String arg0) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setClientInfo(Properties arg0) throws SQLClientInfoException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setClientInfo(String arg0, String arg1) throws SQLClientInfoException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setHoldability(int arg0) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setNetworkTimeout(Executor arg0, int arg1) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setReadOnly(boolean arg0) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public Savepoint setSavepoint() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Savepoint setSavepoint(String arg0) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setSchema(String arg0) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setTransactionIsolation(int arg0) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setTypeMap(Map<String, Class<?>> arg0) throws SQLException {
		// TODO Auto-generated method stub

	}

}

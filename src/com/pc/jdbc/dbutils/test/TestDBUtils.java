package com.pc.jdbc.dbutils.test;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.KeyedHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Before;
import org.junit.Test;

import com.pc.jdbc.c3p0.utils.C3P0Utils;
import com.pc.jdbc.dbutils.domain.User;

/**
 * 测试DBUtils
 * 
 * @author Switch
 * @data 2016年9月30日
 * @version V1.0
 */
public class TestDBUtils {
	// 声明查询类
	QueryRunner queryRunner = null;

	@Before
	public void init() {
		// 使用数据源(连接池)
		DataSource dataSource = C3P0Utils.getDataSource();

		// 获取查询对象
		queryRunner = new QueryRunner(dataSource);
	}

	// 测试查询所有用户(使用BeanListHandler)
	@Test
	public void getAllUsersByBeanListHandler() {
		try {
			// 创建SQL语句
			String sql = "select * from users";
			// 创建Bean列表处理器
			BeanListHandler<User> beanListHandler = new BeanListHandler<>(User.class);
			// 执行查询
			List<User> users = queryRunner.query(sql, beanListHandler);
			for (User user : users) {
				System.out.println(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 测试查询指定ID的用户(使用BeanHandler)
	@Test
	public void getUserByIdByBeanHandler() {
		try {
			String sql = "select * from users where id = ?";
			BeanHandler<User> beanHandler = new BeanHandler<>(User.class);
			Object[] params = { 1 };
			User user = queryRunner.query(sql, beanHandler, params);
			System.out.println(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 测试查询所有用户(使用MapListHandler)
	@Test
	public void getAllUsersByMapListHandler() {
		try {
			String sql = "select * from users";
			MapListHandler mapListHandler = new MapListHandler();
			List<Map<String, Object>> users = queryRunner.query(sql, mapListHandler);
			for (Map<String, Object> user : users) {
				System.out.println(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 测试查询指定ID的用户(使用MapHandler)
	@Test
	public void getUserByIdByMapHandler() {
		try {
			String sql = "select * from users where id = ? ";
			MapHandler mapHandler = new MapHandler();
			Object[] params = { 1 };
			Map<String, Object> user = queryRunner.query(sql, mapHandler, params);
			System.out.println(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 测试查询所有用户的姓名(使用ArrayListHandler)
	@Test
	public void getAllUserByArrayListHandler() {
		try {
			String sql = "select * from users";
			ArrayListHandler arrayListHandler = new ArrayListHandler();
			List<Object[]> users = queryRunner.query(sql, arrayListHandler);
			for (Object[] user : users) {
				System.out.println(user[0] + " " + user[1] + " " + user[2]);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 测试查询指定ID的用户(使用ArrayHandler)
	@Test
	public void getUserByIdByArrayHandler() {
		try {
			String sql = "select * from users where id = ?";
			ArrayHandler arrayHandler = new ArrayHandler();
			Object[] params = { 1 };
			Object[] user = queryRunner.query(sql, arrayHandler, params);
			System.out.println(user[0] + " " + user[1] + " " + user[2]);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 测试查询所有用户的姓名(使用ColumnHandler)
	@Test
	public void getAllUserNameByColumnHandler() {
		try {
			String sql = "select * from users";
			// 列列表处理器，指定相应列，返回列表
			ColumnListHandler columnListHandler = new ColumnListHandler("username");
			List<Object> names = queryRunner.query(sql, columnListHandler);
			System.out.println(names);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 测试查询所有用户的姓名(使用KeyedHandler)
	@Test
	public void getAllUserByKeyedHandler() {
		try {
			String sql = "select * from users";
			// 键处理器，以指定列的内容作为键，返回相应键值对，值也是键值对，(键为：列名，值为：内容)
			KeyedHandler keyedHandler = new KeyedHandler("id");
			Map<Object, Map<String, Object>> users = queryRunner.query(sql, keyedHandler);
			System.out.println(users);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		//  测试查询一共有多少用户(使用ScalarHandler)
	@Test
	public void getAllUserNumberBy() {
		try {
			String sql = "select count(*) from users";
			// 返回单行单列
			ScalarHandler scalarHandler = new ScalarHandler();
			Object number = queryRunner.query(sql, scalarHandler);
			System.out.println(number);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	//  测试插入一个用户
	@Test
	public void insertUser() {
		try {
			String sql = "insert into users values(null,?,?)";
			Object[] params = {"赵六", "654321"};
			
			int updateNum = queryRunner.update(sql, params);
			System.out.println(updateNum);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//  测试更新一个用户
	@Test
	public void updateUserById() {
		try {
			String sql = "update users set username=?,password=? where id=?";
			Object[] params = {"钱七", "123456", "4"};
			
			int updateNum = queryRunner.update(sql, params);
			System.out.println(updateNum);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//  测试删除一个用户
	@Test
	public void deleteUserById() {
		try {
			String sql = "delete from users where id=?";
			Object[] params = {"4"};
			
			int updateNum = queryRunner.update(sql, params);
			System.out.println(updateNum);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}


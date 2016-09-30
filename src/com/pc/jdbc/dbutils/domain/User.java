package com.pc.jdbc.dbutils.domain;

import java.io.Serializable;

/**
 * User对象，JavaBean
 * @author Switch
 * @data 2016年9月30日
 * @version V1.0
 */
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 646488674285514806L;
	// id
	private Integer id;
	// 用户名
	private String userName;
	// 密码
	private String password;
	
	// 无参构造方法
	public User() {
		
	}
	
	// 设置器和获取器
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	// 覆盖toString方法
	@Override
	public String toString() {
		return this.id + " " + this.userName + " " + this.password;
	}
}

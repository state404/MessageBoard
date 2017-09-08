package com.masgb.model;

public class User {

	private String username;
	private String pwd;
	private int id;
	public User(){}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "User [username=" + username + ", pwd=" + pwd + ", id=" + id + "]";
	}
	
}

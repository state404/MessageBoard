package com.masgb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import com.masgb.model.User;
import com.masgb.util.DBUtil;

public class UserDAO2 {

	private  QueryRunner qr;
	private  ResultSetHandler<User> rsh;
	public UserDAO2()
	{
		qr=new QueryRunner(DBUtil.getDataSource());
		rsh= new ResultSetHandler<User>() {

			@Override
			public User handle(ResultSet res) throws SQLException {
				
				if(res.next())
				{
					User user=new User();
					user.setId(res.getInt("id"));
					user.setPwd(res.getString("pwd"));
					user.setUsername(res.getString("username"));
					return user;
				}
				return null;
			}
		};
	}
	public User userLogin(String pwd,String username)
	{
		User user=null;
		String sql="select * from user where pwd=? and username=?";
		try {
			user=qr.query(sql, rsh,pwd,username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	public User findUserById(int id)
	{
		User user=null;
		String sql="select * from user where id=?";
		try {
			user=qr.query(sql, rsh,id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	public User findUserByUName(String username)
	{
		User user=null;
		String sql="select * from user where username=?";
		try {
			user=qr.query(sql, rsh,username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	public boolean userRegiste(User user)
	{
		String sql="insert into user (pwd,username) values(?,?)";
		try {
			int num=qr.update(sql,user.getPwd(),user.getUsername());
			if(num>0)
			{
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
}

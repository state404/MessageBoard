package com.masgb.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.masgb.model.User;
import com.masgb.util.BFUtil;
import com.masgb.util.HBUtil;

public class UserDAO1 {
	public User userLogin(String pwd,String username)
	{
		Session session = BFUtil.getSession();
		Query qu = session.createQuery("select u from User u where u.pwd=:pwd and u.username=:username");
		qu.setParameter("pwd", pwd);
		qu.setParameter("username", username);
		List list = qu.list();
		if(list.isEmpty())
		{
			return null;
		}
		return (User)list.get(0);
	}
	public User findUserById(int id)
	{
		Session session = BFUtil.getSession();
		Query qu = session.createQuery("select u from User u where u.id=:id");
		qu.setParameter("id", id);
		List list = qu.list();
		if(list.isEmpty())
		{
			return null;
		}
		return (User)list.get(0);
	}
	public User findUserByUName(String username)
	{
		Session session = BFUtil.getSession();
		Query qu = session.createQuery("select u from User u where u.username=:username");
		qu.setParameter("username", username);
		List list = qu.list();
		if(list.isEmpty())
		{
			return null;
		}
		return (User)list.get(0);
	}
	public void  userRegiste(User user)
	{
		HBUtil.add(user);
	}
}

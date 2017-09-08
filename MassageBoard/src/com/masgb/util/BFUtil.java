package com.masgb.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BFUtil {

	private static SessionFactory sf=null;
	private static ThreadLocal<Session> threadLocal=new ThreadLocal<Session>();
	static{
		sf=new Configuration().configure("config/hibernate.cfg.xml").buildSessionFactory();
	}
	public static Session getSession()
	{
		Session session=threadLocal.get();
		if(session!=null&&session.isOpen())
		{
			return session;
		}
		session=sf.openSession();
		threadLocal.set(session);
		return session;
	}
	public static void close()
	{
		Session session=threadLocal.get();
		if(session!=null)
		{
			session.close();
		}
	}
}

package com.masgb.util;

import java.lang.reflect.Method;
import java.util.List;

import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.query.Query;


public class HBUtil {

	public static void add(Object obj)
	{
		Session session = BFUtil.getSession();
		session.beginTransaction();
		session.save(obj);
		session.getTransaction().commit();
		BFUtil.close();
	}
	public static void delete(Object obj)
	{
		Session session = BFUtil.getSession();
		session.beginTransaction();
		session.delete(obj);
		session.getTransaction().commit();
		BFUtil.close();
	}
	public static void update(Object obj)
	{
		Session session = BFUtil.getSession();
		session.beginTransaction();
		session.update(obj);
		session.getTransaction().commit();
		BFUtil.close();
	}
	public static <T> T query(int key,Class clazz) 
	{ 
		
		Session session=BFUtil.getSession();
		T t1=(T) session.get(clazz,key);
		BFUtil.close();
		return t1;	
	}
	public static List queryAll(Class cl)
	{
		Session session=BFUtil.getSession();
		String className=cl.getName();
		Query qu = session.createQuery("select d from "+className+" d");
		List<Object> list= qu.list();
		BFUtil.close();
		return list;
	}
	public static List queryLimit(Class cl,int start ,int num)
	{
		Session session = BFUtil.getSession();
		String className=cl.getName();
		Query qu = session.createQuery("select d from "+className+" d");
		qu.setFirstResult(start);
		qu.setMaxResults(num);
		List list = qu.list();
		BFUtil.close();
		return list;
	}
	public static long getCount(Class cl)
	{
		Session session = BFUtil.getSession();
		String className=cl.getName();
		Query qu = session.createQuery("select d from "+className+" d");
		ScrollableResults results = qu.scroll();
		results.last();
		long count = results.getRowNumber() + 1;
		BFUtil.close();
		return count;
	}
}

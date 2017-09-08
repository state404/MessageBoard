/**
 * 
 */
package com.masgb.util;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

/**
 * 数据库连接池
 * @author 杨文龙
 *
 */
public class DBUtil {

	private static DataSource ds;
	private static final String DB_USER="root";
	private static final String DB_PWD="1234";
	private static final String DB_DRIVER="com.mysql.jdbc.Driver";
	private static final String DB_URL="jdbc:mysql://127.0.0.1:3306/masgb?Unicode=true&characterEncoding=utf8&useSSL=false";
	static 
	{
		BasicDataSource bds=new BasicDataSource();
		bds.setMinIdle(10);
		bds.setMaxTotal(100);
		bds.setMaxWaitMillis(10000);
		bds.setDriverClassName(DB_DRIVER);
		bds.setUrl(DB_URL);
		bds.setUsername(DB_USER);
		bds.setPassword(DB_PWD);
		ds=bds;
	}
	public static DataSource getDataSource()
	{
		return ds;
	}
	private DBUtil()
	{
		throw new AssertionError();
	}
}

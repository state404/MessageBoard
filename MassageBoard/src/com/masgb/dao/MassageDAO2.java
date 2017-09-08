package com.masgb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import com.masgb.model.Massage;
import com.masgb.util.DBUtil;
import com.masgb.util.MyTools;


public class MassageDAO2 {

	private  QueryRunner qr;
	private  ResultSetHandler<ArrayList<Massage>> rsh;
	public MassageDAO2()
	{
		qr=new QueryRunner(DBUtil.getDataSource());
		rsh= new ResultSetHandler<ArrayList<Massage>>() {

			@Override
			public ArrayList<Massage> handle(ResultSet res) throws SQLException {
				UserDAO2 udao=new UserDAO2();
				ArrayList<Massage> list=new ArrayList<Massage>();
				while(res.next())
				{
					Massage massage=new Massage();
					massage.setContentText(res.getString("context"));
					massage.setId(res.getInt("id"));
					massage.setPic(res.getString("pic"));
					massage.setShowTime(MyTools.getTimeByNum(res.getLong("time")));
					massage.setTime(res.getLong("time"));
					massage.setUser(udao.findUserById(res.getInt("uid")));
					massage.setTitle(res.getString("title"));
					list.add(massage);
				}
				return list.isEmpty()? null : list;
			}
		};
	}
	public boolean insertMasg(Massage mas)
	{
		String sql="insert into massage (pic,uid,title,context,time) values(?,?,?,?,?)";
		try {
			int num=qr.update(sql,mas.getPic(),mas.getUser().getId(),mas.getTitle(),mas.getContentText(),mas.getTime());
			if(num>0)
			{
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  false;
	}
	public ArrayList<Massage> getAllMasg()
	{
		String sql="select * from massage order by 'time' desc";
		ArrayList<Massage> list=null;
		try {
			list=qr.query(sql, rsh);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	public boolean delMasgById(int id)
	{
		String sql="delete from massage where id=?";
		try {
			int num=qr.update(sql,id);
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
	public int getMassageNum()
	{
		String sql="select count(*)as num from massage";
		ResultSetHandler<Integer> rsh1=new ResultSetHandler<Integer>(){

			@Override
			public Integer handle(ResultSet res) throws SQLException {

				if(res.next())
				{
					return res.getInt("num");
				}
				return 0;
			}};
		try {
			return qr.query(sql, rsh1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	public Massage getMassageById(int id)
	{
		Massage massage=null;
		String sql="select * from massage where id=?";
		try {
			ArrayList<Massage> mlist=qr.query(sql, rsh,id);
			if(mlist!=null)
			{
				massage=mlist.get(0);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return massage;
		
	}
	public ArrayList<Massage> splitMassage(int pageNum ,int start)
	{
		String sql="select * from massage limit ?,?";
		ArrayList<Massage> agoods=null;
		try {
			agoods=qr.query(sql, rsh,start,pageNum);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return agoods;
	}
}

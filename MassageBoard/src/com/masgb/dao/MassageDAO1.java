package com.masgb.dao;

import java.util.ArrayList;


import com.masgb.model.Massage;
import com.masgb.util.HBUtil;

public class MassageDAO1 {

	public  void insertMasg(Massage mas)
	{
		HBUtil.add(mas);
	}
	public ArrayList<Massage> getAllMasg()
	{
		return (ArrayList<Massage>) HBUtil.queryAll(Massage.class);
	}
	public void  delMasgById(int id)
	{
		Massage mas = HBUtil.query(id, Massage.class);
		HBUtil.delete(mas);
		
	}
	public int getMassageNum()
	{
		return (int) HBUtil.getCount(Massage.class);
	}
	public Massage getMassageById(int id)
	{
		return HBUtil.query(id, Massage.class);
	}
	public ArrayList<Massage> splitMassage(int pageNum ,int start)
	{
		return (ArrayList<Massage>) HBUtil.queryLimit(Massage.class, start, pageNum);
	}
}

package com.masgb.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.masgb.model.Page;


public class MyTools {

	public static Page getPage(String url,int nowPage,int pageSize,int massageNum)
	{
		int pageTotal=(int) Math.ceil((double)massageNum/pageSize);
		int[] arr=new int[4];
		arr[0]=nowPage-2;
		arr[1]=nowPage-1;
		arr[2]=nowPage+1;
		arr[3]=nowPage+2;
		Page page=new Page();
		String nextPage="";
		String prePage="";
		String pageNum1="";
		String pageNum2="";
		String pageNum3="";
		String pageNum4="";
		if(arr[0]>0)
		{
			pageNum1="<a href='"+url+"?nPage="+arr[0]+"'>"+arr[0]+"</a>";
		}
		if(arr[1]>0)
		{
			pageNum2="<a href='"+url+"?nPage="+arr[1]+"'>"+arr[1]+"</a>";
			prePage="<a href='"+url+"?nPage="+arr[1]+"'><</a>";
		}
		if(arr[2]<=pageTotal)
		{
			pageNum3="<a href='"+url+"?nPage="+arr[2]+"'>"+arr[2]+"</a>";
			nextPage="<a href='"+url+"?nPage="+arr[2]+"'>></a>";
		}
		if(arr[3]<=pageTotal)
		{
			pageNum4="<a href='"+url+"?nPage="+arr[3]+"'>"+arr[3]+"</a>";
		}
		page.setFirstPage("<a href='"+url+"?nPage="+1+"'>首页</a>");
		page.setLastPage("<a href='"+url+"?nPage="+pageTotal+"'>尾页</a>");
		page.setNextPage(nextPage);
		page.setPrePage(prePage);
		page.setpNum1(pageNum1);
		page.setpNum2(pageNum2);
		page.setpNum3(pageNum3);
		page.setpNum4(pageNum4);
		page.setNowPage(nowPage);
		return page;
	}
	//时间两位数显示
	public static String showTimeLable(int hour,int minutes,int second)
	{
		String hourStr=String.format("%2d", hour);
		String minStr=String.format("%2d", minutes);
		String seStr=String.format("%2d", second);
		hourStr=hourStr.replace(" ", "0");
		minStr=minStr.replace(" ", "0");
		seStr=seStr.replace(" ", "0");
		return hourStr+":"+minStr+":"+seStr;
	}
	//时间变为字符串格式
	public static String getTimeByNum(long num)
	{
		Date date=new Date(num);
		SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); 
		String str=dateFormater.format(date);
		return str;
	}
}

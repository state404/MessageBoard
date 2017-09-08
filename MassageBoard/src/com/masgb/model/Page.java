package com.masgb.model;

public class Page {

	private String pNum1;
	private String pNum2;
	private String pNum3;
	private String pNum4;
	private String nextPage;
	private String prePage;
	private String firstPage;
	private String lastPage;
	private int nowPage;
	public Page(){}
	
	public int getNowPage() {
		return nowPage;
	}

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}

	public String getpNum1() {
		return pNum1;
	}
	public void setpNum1(String pNum1) {
		this.pNum1 = pNum1;
	}
	public String getpNum2() {
		return pNum2;
	}
	public void setpNum2(String pNum2) {
		this.pNum2 = pNum2;
	}
	public String getpNum3() {
		return pNum3;
	}
	public void setpNum3(String pNum3) {
		this.pNum3 = pNum3;
	}
	public String getpNum4() {
		return pNum4;
	}
	public void setpNum4(String pNum4) {
		this.pNum4 = pNum4;
	}
	public String getNextPage() {
		return nextPage;
	}
	public void setNextPage(String nextPage) {
		this.nextPage = nextPage;
	}
	public String getPrePage() {
		return prePage;
	}
	public void setPrePage(String prePage) {
		this.prePage = prePage;
	}
	public String getFirstPage() {
		return firstPage;
	}
	public void setFirstPage(String firstPage) {
		this.firstPage = firstPage;
	}
	public String getLastPage() {
		return lastPage;
	}
	public void setLastPage(String lastPage) {
		this.lastPage = lastPage;
	}
	
	
}

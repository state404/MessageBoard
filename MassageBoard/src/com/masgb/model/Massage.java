package com.masgb.model;

public class Massage {

	private String contentText;
	private String title;
	private String pic;
	private String showTime;
	private long time;
	private int id;
	private User user;
	public Massage(){}
	
	
	@Override
	public String toString() {
		return "Massage [contentText=" + contentText + ", title=" + title + ", pic=" + pic + ", showTime=" + showTime
				+ ", time=" + time + ", id=" + id + ", user=" + user + "]";
	}


	public String getShowTime() {
		return showTime;
	}
	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public String getContentText() {
		return contentText;
	}
	public void setContentText(String contentText) {
		this.contentText = contentText;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	
}

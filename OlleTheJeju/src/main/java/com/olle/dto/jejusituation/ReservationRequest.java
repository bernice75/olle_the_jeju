package com.olle.dto.jejusituation;

//for json data format
public class ReservationRequest {

	private String name;
	private String phone;
	private String require;
	private String date;
	private String time;
	private int cnt;
	private int situ_num;
	
	/*
	 * public static class ReservUser{ private String name; private String phone;
	 * private String content; public ReservUser() { super(); // TODO Auto-generated
	 * constructor stub } public ReservUser(String name, String phone, String
	 * content) { super(); this.name = name; this.phone = phone; this.content =
	 * content; } public String getName() { return name; } public void
	 * setName(String name) { this.name = name; } public String getPhone() { return
	 * phone; } public void setPhone(String phone) { this.phone = phone; } public
	 * String getContent() { return content; } public void setContent(String
	 * content) { this.content = content; }
	 * 
	 * @Override public String toString() { return "ReservUser [name=" + name +
	 * ", phone=" + phone + ", content=" + content + "]"; }
	 * 
	 * 
	 * }
	 */

	public ReservationRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReservationRequest(String name, String phone, String require, String date, String time, int cnt,
			int situ_num) {
		super();
		this.name = name;
		this.phone = phone;
		this.require = require;
		this.date = date;
		this.time = time;
		this.cnt = cnt;
		this.situ_num = situ_num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRequire() {
		return require;
	}

	public void setRequire(String require) {
		this.require = require;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public int getSitu_num() {
		return situ_num;
	}

	public void setSitu_num(int situ_num) {
		this.situ_num = situ_num;
	}

	@Override
	public String toString() {
		return "ReservationRequest [name=" + name + ", phone=" + phone + ", require=" + require + ", date=" + date
				+ ", time=" + time + ", cnt=" + cnt + ", situ_num=" + situ_num + "]";
	}

	
	
}

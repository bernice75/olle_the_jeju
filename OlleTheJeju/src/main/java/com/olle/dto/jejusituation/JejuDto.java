package com.olle.dto.jejusituation;

import java.util.Date;

public class JejuDto {
	private int situ_num;
	private String situ_name;
	private String situ_writer;
	private Date situ_regdate;
	private String situ_phone;
	private String situ_addr;
	private String situ_open_time;
	private String situ_close_time;
	private String situ_home;
	
	public JejuDto() {
		super();
	}
	public JejuDto(int situ_num, String situ_name, String situ_writer, Date situ_regdate, String situ_phone,
			String situ_addr, String situ_open_time, String situ_close_time, String situ_home) {
		super();
		this.situ_num = situ_num;
		this.situ_name = situ_name;
		this.situ_writer = situ_writer;
		this.situ_regdate = situ_regdate;
		this.situ_phone = situ_phone;
		this.situ_addr = situ_addr;
		this.situ_open_time = situ_open_time;
		this.situ_close_time = situ_close_time;
		this.situ_home = situ_home;
	}
	
	public int getSitu_num() {
		return situ_num;
	}
	public void setSitu_num(int situ_num) {
		this.situ_num = situ_num;
	}
	public String getSitu_name() {
		return situ_name;
	}
	public void setSitu_name(String situ_name) {
		this.situ_name = situ_name;
	}
	public String getSitu_writer() {
		return situ_writer;
	}
	public void setSitu_writer(String situ_writer) {
		this.situ_writer = situ_writer;
	}
	public Date getSitu_regdate() {
		return situ_regdate;
	}
	public void setSitu_regdate(Date situ_regdate) {
		this.situ_regdate = situ_regdate;
	}
	public String getSitu_phone() {
		return situ_phone;
	}
	public void setSitu_phone(String situ_phone) {
		this.situ_phone = situ_phone;
	}
	public String getSitu_addr() {
		return situ_addr;
	}
	public void setSitu_addr(String situ_addr) {
		this.situ_addr = situ_addr;
	}
	public String getSitu_open_time() {
		return situ_open_time;
	}
	public void setSitu_open_time(String situ_open_time) {
		this.situ_open_time = situ_open_time;
	}
	public String getSitu_close_time() {
		return situ_close_time;
	}
	public void setSitu_close_time(String situ_close_time) {
		this.situ_close_time = situ_close_time;
	}
	public String getSitu_home() {
		return situ_home;
	}
	public void setSitu_home(String situ_home) {
		this.situ_home = situ_home;
	}
}

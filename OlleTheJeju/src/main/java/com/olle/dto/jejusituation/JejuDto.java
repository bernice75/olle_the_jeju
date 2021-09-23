package com.olle.dto.jejusituation;

import java.util.Date;

public class JejuDto {
	private int situ_num;
	private String situ_name;
	private String situ_writer;
	private String situ_regDate;
	private String situ_open_time;
	private String situ_close_time;
	private String situ_phone;
	private String situ_addr;
	private String situ_gubun;
	
	public JejuDto() {
		super();
	}

	public JejuDto(int situ_num, String situ_name, String situ_writer, String situ_regDate, String situ_open_time,
			String situ_close_time, String situ_phone, String situ_addr, String situ_gubun) {
		super();
		this.situ_num = situ_num;
		this.situ_name = situ_name;
		this.situ_writer = situ_writer;
		this.situ_regDate = situ_regDate;
		this.situ_open_time = situ_open_time;
		this.situ_close_time = situ_close_time;
		this.situ_phone = situ_phone;
		this.situ_addr = situ_addr;
		this.situ_gubun = situ_gubun;
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

	public String getSitu_regDate() {
		return situ_regDate;
	}

	public void setSitu_regDate(String situ_regDate) {
		this.situ_regDate = situ_regDate;
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

	public String getSitu_gubun() {
		return situ_gubun;
	}

	public void setSitu_gubun(String situ_gubun) {
		this.situ_gubun = situ_gubun;
	}
	
}
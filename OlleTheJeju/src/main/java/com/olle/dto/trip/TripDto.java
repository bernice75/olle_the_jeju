package com.olle.dto.trip;

import java.util.Date;

public class TripDto {
	private int trip_num;
	private String trip_kategorie;
	private String trip_title;
	private String trip_content;
	private String trip_writer;
	private Date trip_regdate;
	private String trip_nail;
	private String trip_addr;
	private String trip_phone;
	private String trip_detail;
	private int trip_views;
	private int trip_push;
	private int dib;
	public TripDto() {
		super();
	}
	public TripDto(int trip_num, String trip_kategorie, String trip_title, String trip_content, String trip_writer,
			Date trip_regdate, String trip_nail, String trip_addr, String trip_phone, String trip_detail, int trip_views,
			int trip_push) {
		super();
		this.trip_num = trip_num;
		this.trip_kategorie = trip_kategorie;
		this.trip_title = trip_title;
		this.trip_content = trip_content;
		this.trip_writer = trip_writer;
		this.trip_regdate = trip_regdate;
		this.trip_nail = trip_nail;
		this.trip_addr = trip_addr;
		this.trip_phone = trip_phone;
		this.trip_detail = trip_detail;
		this.trip_views = trip_views;
		this.trip_push = trip_push;
	}
	
	public TripDto(int trip_num, String trip_kategorie, String trip_title, String trip_content, String trip_writer,
			Date trip_regdate, String trip_nail, String trip_addr, String trip_phone, String trip_detail,
			int trip_views, int trip_push, int dib) {
		super();
		this.trip_num = trip_num;
		this.trip_kategorie = trip_kategorie;
		this.trip_title = trip_title;
		this.trip_content = trip_content;
		this.trip_writer = trip_writer;
		this.trip_regdate = trip_regdate;
		this.trip_nail = trip_nail;
		this.trip_addr = trip_addr;
		this.trip_phone = trip_phone;
		this.trip_detail = trip_detail;
		this.trip_views = trip_views;
		this.trip_push = trip_push;
		this.dib = dib;
	}
	
	public int getDib() {
		return dib;
	}
	public void setDib(int dib) {
		this.dib = dib;
	}
	public int getTrip_num() {
		return trip_num;
	}
	public void setTrip_num(int trip_num) {
		this.trip_num = trip_num;
	}
	public String getTrip_kategorie() {
		return trip_kategorie;
	}
	public void setTrip_kategorie(String trip_kategorie) {
		this.trip_kategorie = trip_kategorie;
	}
	public String getTrip_title() {
		return trip_title;
	}
	public void setTrip_title(String trip_title) {
		this.trip_title = trip_title;
	}
	public String getTrip_content() {
		return trip_content;
	}
	public void setTrip_content(String trip_content) {
		this.trip_content = trip_content;
	}
	public String getTrip_writer() {
		return trip_writer;
	}
	public void setTrip_writer(String trip_writer) {
		this.trip_writer = trip_writer;
	}
	public Date getTrip_regdate() {
		return trip_regdate;
	}
	public void setTrip_regdate(Date trip_regdate) {
		this.trip_regdate = trip_regdate;
	}
	public String getTrip_nail() {
		return trip_nail;
	}
	public void setTrip_nail(String trip_nail) {
		this.trip_nail = trip_nail;
	}
	public String getTrip_addr() {
		return trip_addr;
	}
	public void setTrip_addr(String trip_addr) {
		this.trip_addr = trip_addr;
	}
	public String getTrip_phone() {
		return trip_phone;
	}
	public void setTrip_phone(String trip_phone) {
		this.trip_phone = trip_phone;
	}
	public String getTrip_detail() {
		return trip_detail;
	}
	public void setTrip_detail(String trip_detail) {
		this.trip_detail = trip_detail;
	}
	public int getTrip_push() {
		return trip_push;
	}
	public void setTrip_push(int trip_push) {
		this.trip_push = trip_push;
	}
	public int getTrip_views() {
		return trip_views;
	}
	public void setTrip_views(int trip_views) {
		this.trip_views = trip_views;
	}
	@Override
	public String toString() {
		return "TripDto [trip_num=" + trip_num + ", trip_kategorie=" + trip_kategorie + ", trip_title=" + trip_title
				+ ", trip_content=" + trip_content + ", trip_writer=" + trip_writer + ", trip_regdate=" + trip_regdate
				+ ", trip_nail=" + trip_nail + ", trip_addr=" + trip_addr + ", trip_phone=" + trip_phone
				+ ", trip_detail=" + trip_detail + ", trip_views=" + trip_views + ", trip_push=" + trip_push + "]";
	}
}
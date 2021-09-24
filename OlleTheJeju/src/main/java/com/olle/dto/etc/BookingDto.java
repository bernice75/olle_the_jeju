package com.olle.dto.etc;

import java.util.Date;

public class BookingDto {
	private int book_num;
	private int situ_num;
	private String book_name;
	private int book_people;
	private String book_regdate;
	private String book_time;
	private String book_phone;
	private String book_content;
	
	public BookingDto() {
		super();
	}
	public BookingDto(int book_num, int situ_num, String book_name, int book_people, String book_regdate,
			String book_time, String book_phone, String book_content) {
		super();
		this.book_num = book_num;
		this.situ_num = situ_num;
		this.book_name = book_name;
		this.book_people = book_people;
		this.book_regdate = book_regdate;
		this.book_time = book_time;
		this.book_phone = book_phone;
		this.book_content = book_content;
	}
	
	public int getBook_num() {
		return book_num;
	}
	public void setBook_num(int book_num) {
		this.book_num = book_num;
	}
	public int getSitu_num() {
		return situ_num;
	}
	public void setSitu_num(int situ_num) {
		this.situ_num = situ_num;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public int getBook_people() {
		return book_people;
	}
	public void setBook_people(int book_people) {
		this.book_people = book_people;
	}
	public String getBook_regdate() {
		return book_regdate;
	}
	public void setBook_regdate(String book_regdate) {
		this.book_regdate = book_regdate;
	}
	public String getBook_time() {
		return book_time;
	}
	public void setBook_time(String book_time) {
		this.book_time = book_time;
	}
	public String getBook_phone() {
		return book_phone;
	}
	public void setBook_phone(String book_phone) {
		this.book_phone = book_phone;
	}
	public String getBook_content() {
		return book_content;
	}
	public void setBook_content(String book_content) {
		this.book_content = book_content;
	}
	@Override
	public String toString() {
		return "BookingDto [book_num=" + book_num + ", situ_num=" + situ_num + ", book_name=" + book_name
				+ ", book_people=" + book_people + ", book_regdate=" + book_regdate + ", book_time=" + book_time
				+ ", book_phone=" + book_phone + ", book_content=" + book_content + "]";
	}
	
}

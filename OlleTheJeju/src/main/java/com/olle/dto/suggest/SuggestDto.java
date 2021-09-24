package com.olle.dto.suggest;

import java.util.Date;

import org.springframework.stereotype.Component;


@Component
public class SuggestDto {
	private int sug_num;
	private String sug_kategorie;
	private String sug_title;
	private String sug_content;
	private String sug_writer;
	private Date sug_regdate;
	private String sug_nail;
	private String sug_tendency;
	private String sug_addr;
	private String sug_term;
	private int sug_views;
	private int sug_push;
	private int dib;
	public SuggestDto() {
		super();
	}
	public SuggestDto(int sug_num, String sug_kategorie, String sug_title, String sug_content, String sug_writer,
			Date sug_regdate, String sug_nail, String sug_tendency, String sug_addr, String sug_term, int sug_views,
			int sug_push) {
		super();
		this.sug_num = sug_num;
		this.sug_kategorie = sug_kategorie;
		this.sug_title = sug_title;
		this.sug_content = sug_content;
		this.sug_writer = sug_writer;
		this.sug_regdate = sug_regdate;
		this.sug_nail = sug_nail;
		this.sug_tendency = sug_tendency;
		this.sug_addr = sug_addr;
		this.sug_term = sug_term;
		this.sug_views = sug_views;
		this.sug_push = sug_push;
	}
	
	
	public SuggestDto(int sug_num, String sug_kategorie, String sug_title, String sug_content, String sug_writer,
			Date sug_regdate, String sug_nail, String sug_tendency, String sug_addr, String sug_term, int sug_views,
			int sug_push, int dib) {
		super();
		this.sug_num = sug_num;
		this.sug_kategorie = sug_kategorie;
		this.sug_title = sug_title;
		this.sug_content = sug_content;
		this.sug_writer = sug_writer;
		this.sug_regdate = sug_regdate;
		this.sug_nail = sug_nail;
		this.sug_tendency = sug_tendency;
		this.sug_addr = sug_addr;
		this.sug_term = sug_term;
		this.sug_views = sug_views;
		this.sug_push = sug_push;
		this.dib = dib;
	}
	
	public int getDib() {
		return dib;
	}
	public void setDib(int dib) {
		this.dib = dib;
	}
	public int getSug_num() {
		return sug_num;
	}
	public void setSug_num(int sug_num) {
		this.sug_num = sug_num;
	}
	public String getSug_kategorie() {
		return sug_kategorie;
	}
	public void setSug_kategorie(String sug_kategorie) {
		this.sug_kategorie = sug_kategorie;
	}
	public String getSug_title() {
		return sug_title;
	}
	public void setSug_title(String sug_title) {
		this.sug_title = sug_title;
	}
	public String getSug_content() {
		return sug_content;
	}
	public void setSug_content(String sug_content) {
		this.sug_content = sug_content;
	}
	public String getSug_writer() {
		return sug_writer;
	}
	public void setSug_writer(String sug_writer) {
		this.sug_writer = sug_writer;
	}
	public Date getSug_regdate() {
		return sug_regdate;
	}
	public void setSug_regdate(Date sug_regdate) {
		this.sug_regdate = sug_regdate;
	}
	public String getSug_nail() {
		return sug_nail;
	}
	public void setSug_nail(String sug_nail) {
		this.sug_nail = sug_nail;
	}
	public String getSug_tendency() {
		return sug_tendency;
	}
	public void setSug_tendency(String sug_tendency) {
		this.sug_tendency = sug_tendency;
	}
	public String getSug_addr() {
		return sug_addr;
	}
	public void setSug_addr(String sug_addr) {
		this.sug_addr = sug_addr;
	}
	public String getSug_term() {
		return sug_term;
	}
	public void setSug_term(String sug_term) {
		this.sug_term = sug_term;
	}
	public int getSug_views() {
		return sug_views;
	}
	public void setSug_views(int sug_views) {
		this.sug_views = sug_views;
	}
	public int getSug_push() {
		return sug_push;
	}
	public void setSug_push(int sug_push) {
		this.sug_push = sug_push;
	}
	@Override
	public String toString() {
		return "SuggestDto [sug_num=" + sug_num + ", sug_kategorie=" + sug_kategorie + ", sug_title=" + sug_title
				+ ", sug_content=" + sug_content + ", sug_writer=" + sug_writer + ", sug_regdate=" + sug_regdate
				+ ", sug_nail=" + sug_nail + ", sug_tendency=" + sug_tendency + ", sug_addr=" + sug_addr + ", sug_term="
				+ sug_term + ", sug_views=" + sug_views + ", sug_push=" + sug_push + ", dib=" + dib + "]";
	}
}
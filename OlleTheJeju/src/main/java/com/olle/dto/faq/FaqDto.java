package com.olle.dto.faq;

import java.util.Date;

public class FaqDto {
	private int faq_num;
	private int faq_kat;
	private String faq_title;
	private String faq_content;
	private Date faq_regdate;
	
	public FaqDto() {
		super();
	}
	public FaqDto(int faq_num, int faq_kat, String faq_title, String faq_content, Date faq_regdate) {
		super();
		this.faq_num = faq_num;
		this.faq_kat = faq_kat;
		this.faq_title = faq_title;
		this.faq_content = faq_content;
		this.faq_regdate = faq_regdate;
	}
	
	public int getFaq_num() {
		return faq_num;
	}
	public void setFaq_num(int faq_num) {
		this.faq_num = faq_num;
	}
	public int getFaq_kat() {
		return faq_kat;
	}
	public void setFaq_kat(int faq_kat) {
		this.faq_kat = faq_kat;
	}
	public String getFaq_title() {
		return faq_title;
	}
	public void setFaq_title(String faq_title) {
		this.faq_title = faq_title;
	}
	public String getFaq_content() {
		return faq_content;
	}
	public void setFaq_content(String faq_content) {
		this.faq_content = faq_content;
	}
	public Date getFaq_regdate() {
		return faq_regdate;
	}
	public void setFaq_regdate(Date faq_regdate) {
		this.faq_regdate = faq_regdate;
	}
}

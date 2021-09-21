package com.olle.dto.customplan;

import java.util.Date;

import com.olle.dto.member.Criteria;

public class CustomDto {
	private int plan_num;
	private String plan_title;
	private String plan_content;
	private String plan_writer;
	private Date plan_regdate;
	private String plan_nail;
	private String plan_tendency;
	private String plan_addr;
	private String plan_term;
	private int plan_views;
	private int plan_push;
	private int plan_hide;

	
	

	public CustomDto() {
		super();
	}

	
	public CustomDto(int plan_num, String plan_title, String plan_content, String plan_writer, Date plan_regdate,
			String plan_nail, String plan_tendency, String plan_addr, String plan_term, int plan_views, int plan_push,
			int plan_hide) {
		super();
		this.plan_num = plan_num;
		this.plan_title = plan_title;
		this.plan_content = plan_content;
		this.plan_writer = plan_writer;
		this.plan_regdate = plan_regdate;
		this.plan_nail = plan_nail;
		this.plan_tendency = plan_tendency;
		this.plan_addr = plan_addr;
		this.plan_term = plan_term;
		this.plan_views = plan_views;
		this.plan_push = plan_push;
		this.plan_hide = plan_hide;
		
	}


	public int getPlan_num() {
		return plan_num;
	}


	public void setPlan_num(int plan_num) {
		this.plan_num = plan_num;
	}

	public String getPlan_title() {
		return plan_title;
	}

	public void setPlan_title(String plan_title) {
		this.plan_title = plan_title;
	}

	public String getPlan_content() {
		return plan_content;
	}

	public void setPlan_content(String plan_content) {
		this.plan_content = plan_content;
	}

	public String getPlan_writer() {
		return plan_writer;
	}

	public void setPlan_writer(String plan_writer) {
		this.plan_writer = plan_writer;
	}

	public Date getPlan_regdate() {
		return plan_regdate;
	}

	public void setPlan_regdate(Date plan_regdate) {
		this.plan_regdate = plan_regdate;
	}

	public String getPlan_nail() {
		return plan_nail;
	}

	public void setPlan_nail(String plan_nail) {
		this.plan_nail = plan_nail;
	}

	public String getPlan_tendency() {
		return plan_tendency;
	}

	public void setPlan_tendency(String plan_tendency) {
		this.plan_tendency = plan_tendency;
	}

	public String getPlan_addr() {
		return plan_addr;
	}

	public void setPlan_addr(String plan_addr) {
		this.plan_addr = plan_addr;
	}

	public String getPlan_term() {
		return plan_term;
	}

	public void setPlan_term(String plan_term) {
		this.plan_term = plan_term;
	}

	public int getPlan_views() {
		return plan_views;
	}

	public void setPlan_views(int plan_views) {
		this.plan_views = plan_views;
	}

	public int getPlan_push() {
		return plan_push;
	}

	public void setPlan_push(int plan_push) {
		this.plan_push = plan_push;
	}

	public int getPlan_hide() {
		return plan_hide;
	}

	public void setPlan_hide(int plan_hide) {
		this.plan_hide = plan_hide;
	}

	
	
}

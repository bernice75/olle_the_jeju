package com.olle.dto.admin;

import java.util.Date;

public class ReportDto {
	private int rep_num;
	private String user_id;
	private String rep_reson;
	private String rep_user;
	private int plan_num;
	private Date rep_regdate;
	
	public ReportDto() {
		super();
	}
	public ReportDto(int rep_num, String user_id, String rep_reson, String rep_user, int plan_num, Date rep_regdate) {
		super();
		this.rep_num = rep_num;
		this.user_id = user_id;
		this.rep_reson = rep_reson;
		this.rep_user = rep_user;
		this.plan_num = plan_num;
		this.rep_regdate = rep_regdate;
	}
	
	public int getRep_num() {
		return rep_num;
	}
	public void setRep_num(int rep_num) {
		this.rep_num = rep_num;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getRep_reson() {
		return rep_reson;
	}
	public void setRep_reson(String rep_reson) {
		this.rep_reson = rep_reson;
	}
	public String getRep_user() {
		return rep_user;
	}
	public void setRep_user(String rep_user) {
		this.rep_user = rep_user;
	}
	public int getPlan_num() {
		return plan_num;
	}
	public void setPlan_num(int plan_num) {
		this.plan_num = plan_num;
	}
	public Date getRep_regdate() {
		return rep_regdate;
	}
	public void setRep_regdate(Date rep_regdate) {
		this.rep_regdate = rep_regdate;
	}
}

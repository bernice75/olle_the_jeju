package com.olle.dto.etc;

import java.util.Date;

public class SupportDto {
	private int sup_num;
	private String chat_group;
	private String from_user;
	private String to_user;
	private String sup_content;
	private Date sup_regdate;
	
	public SupportDto() {
		super();
	}
	public SupportDto(int sup_num, String chat_group, String from_user, String to_user, String sup_content,
			Date sup_regdate) {
		super();
		this.sup_num = sup_num;
		this.chat_group = chat_group;
		this.from_user = from_user;
		this.to_user = to_user;
		this.sup_content = sup_content;
		this.sup_regdate = sup_regdate;
	}
	
	public int getSup_num() {
		return sup_num;
	}
	public void setSup_num(int sup_num) {
		this.sup_num = sup_num;
	}
	public String getChat_group() {
		return chat_group;
	}
	public void setChat_group(String chat_group) {
		this.chat_group = chat_group;
	}
	public String getFrom_user() {
		return from_user;
	}
	public void setFrom_user(String from_user) {
		this.from_user = from_user;
	}
	public String getTo_user() {
		return to_user;
	}
	public void setTo_user(String to_user) {
		this.to_user = to_user;
	}
	public String getSup_content() {
		return sup_content;
	}
	public void setSup_content(String sup_content) {
		this.sup_content = sup_content;
	}
	public Date getSup_regdate() {
		return sup_regdate;
	}
	public void setSup_regdate(Date sup_regdate) {
		this.sup_regdate = sup_regdate;
	}
}

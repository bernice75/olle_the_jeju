package com.olle.dto.etc;

public class DateDto {
	private int date_num;
	private int board_num;
	private int table_num;
	private int date_n;
	private int group_num;
	private String date_name;
	private String date_addr;
	
	public DateDto() {
		super();
	}
	public DateDto(int date_num, int board_num, int table_num, int date_n, int group_num, String date_name,
			String date_addr) {
		super();
		this.date_num = date_num;
		this.board_num = board_num;
		this.table_num = table_num;
		this.date_n = date_n;
		this.group_num = group_num;
		this.date_name = date_name;
		this.date_addr = date_addr;
	}
	
	public int getDate_num() {
		return date_num;
	}
	public void setDate_num(int date_num) {
		this.date_num = date_num;
	}
	public int getBoard_num() {
		return board_num;
	}
	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}
	public int getTable_num() {
		return table_num;
	}
	public void setTable_num(int table_num) {
		this.table_num = table_num;
	}
	public int getDate_n() {
		return date_n;
	}
	public void setDate_n(int date_n) {
		this.date_n = date_n;
	}
	public int getGroup_num() {
		return group_num;
	}
	public void setGroup_num(int group_num) {
		this.group_num = group_num;
	}
	public String getDate_name() {
		return date_name;
	}
	public void setDate_name(String date_name) {
		this.date_name = date_name;
	}
	public String getDate_addr() {
		return date_addr;
	}
	public void setDate_addr(String date_addr) {
		this.date_addr = date_addr;
	}
}

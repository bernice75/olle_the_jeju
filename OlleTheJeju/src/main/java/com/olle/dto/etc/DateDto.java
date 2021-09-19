package com.olle.dto.etc;

public class DateDto {
	private int date_num;
	private int board_num;
	private int table_num;
	private int group_num;
	private double date_lat;
	private double date_lon;
	private String date_name;
	private String date_addr;
	private String date_phone;
	
	public DateDto() {
		super();
	}

	public DateDto(int date_num, int board_num, int table_num, int group_num, double date_lat, double date_lon,
			String date_name, String date_addr, String date_phone) {
		super();
		this.date_num = date_num;
		this.board_num = board_num;
		this.table_num = table_num;
		this.group_num = group_num;
		this.date_lat = date_lat;
		this.date_lon = date_lon;
		this.date_name = date_name;
		this.date_addr = date_addr;
		this.date_phone = date_phone;
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

	public int getGroup_num() {
		return group_num;
	}

	public void setGroup_num(int group_num) {
		this.group_num = group_num;
	}

	public double getDate_lat() {
		return date_lat;
	}

	public void setDate_lat(double date_lat) {
		this.date_lat = date_lat;
	}

	public double getDate_lon() {
		return date_lon;
	}

	public void setDate_lon(double date_lon) {
		this.date_lon = date_lon;
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

	public String getDate_phone() {
		return date_phone;
	}

	public void setDate_phone(String date_phone) {
		this.date_phone = date_phone;
	}
	
}

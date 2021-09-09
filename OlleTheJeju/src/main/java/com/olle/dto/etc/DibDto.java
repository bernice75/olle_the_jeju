package com.olle.dto.etc;

public class DibDto {
	private int dib_num;
	private int board_num;
	private int table_num;
	private String user_id;
	
	public DibDto() {
		super();
	}
	public DibDto(int dib_num, int board_num, int table_num, String user_id) {
		super();
		this.dib_num = dib_num;
		this.board_num = board_num;
		this.table_num = table_num;
		this.user_id = user_id;
	}
	
	public int getDib_num() {
		return dib_num;
	}
	public void setDib_num(int dib_num) {
		this.dib_num = dib_num;
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
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
}

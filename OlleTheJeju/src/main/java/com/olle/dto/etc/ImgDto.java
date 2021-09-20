package com.olle.dto.etc;

public class ImgDto {
	private int img_num;
	private int board_num;
	private int table_num;
	private String img_title;
	private int group_num;

	
	public ImgDto() {
		super();
	}


	public ImgDto(int img_num, int board_num, int table_num, String img_title, int group_num) {
		super();
		this.img_num = img_num;
		this.board_num = board_num;
		this.table_num = table_num;
		this.img_title = img_title;
		this.group_num = group_num;
	}


	public int getImg_num() {
		return img_num;
	}


	public void setImg_num(int img_num) {
		this.img_num = img_num;
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


	public String getImg_title() {
		return img_title;
	}


	public void setImg_title(String img_title) {
		this.img_title = img_title;
	}


	public int getGroup_num() {
		return group_num;
	}


	public void setGroup_num(int group_num) {
		this.group_num = group_num;
	}


	@Override
	public String toString() {
		return "ImgDto [img_num=" + img_num + ", board_num=" + board_num + ", table_num=" + table_num + ", img_title="
				+ img_title + ", group_num=" + group_num + "]";
	}


	
}

package com.olle.dto.etc;

public class HashtagDto {
	private int hash_num;
	private int board_num;
	private int table_num;
	private int group_num;
	private String hash_content;
	
	public HashtagDto() {
		super();
	}
	public HashtagDto(int hash_num, int board_num, int table_num, int group_num, String hash_content) {
		super();
		this.hash_num = hash_num;
		this.board_num = board_num;
		this.table_num = table_num;
		this.group_num = group_num;
		this.hash_content = hash_content;
	}
	
	public int getHash_num() {
		return hash_num;
	}
	public void setHash_num(int hash_num) {
		this.hash_num = hash_num;
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
	public String getHash_content() {
		return hash_content;
	}
	public void setHash_content(String hash_content) {
		this.hash_content = hash_content;
	}
}

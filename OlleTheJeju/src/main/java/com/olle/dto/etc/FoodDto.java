package com.olle.dto.etc;

public class FoodDto {
	private int food_num;
	private int situ_num;
	private int group_num;
	private String food_name;
	
	public FoodDto() {
		super();
	}
	public FoodDto(int food_num, int situ_num, int group_num, String food_name) {
		super();
		this.food_num = food_num;
		this.situ_num = situ_num;
		this.group_num = group_num;
		this.food_name = food_name;
	}
	
	public int getFood_num() {
		return food_num;
	}
	public void setFood_num(int food_num) {
		this.food_num = food_num;
	}
	public int getSitu_num() {
		return situ_num;
	}
	public void setSitu_num(int situ_num) {
		this.situ_num = situ_num;
	}
	public int getGroup_num() {
		return group_num;
	}
	public void setGroup_num(int group_num) {
		this.group_num = group_num;
	}
	public String getFood_name() {
		return food_name;
	}
	public void setFood_name(String food_name) {
		this.food_name = food_name;
	}
}

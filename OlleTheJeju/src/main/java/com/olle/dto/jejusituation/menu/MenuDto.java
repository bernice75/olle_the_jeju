package com.olle.dto.jejusituation.menu;

public class MenuDto {
	
	private Long menu_id;
	private Long store_id;
	private String menu;
	public MenuDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MenuDto(Long menu_id, Long store_id, String menu) {
		super();
		this.menu_id = menu_id;
		this.store_id = store_id;
		this.menu = menu;
	}
	public Long getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(Long menu_id) {
		this.menu_id = menu_id;
	}
	public Long getStore_id() {
		return store_id;
	}
	public void setStore_id(Long store_id) {
		this.store_id = store_id;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	@Override
	public String toString() {
		return "MenuDto [menu_id=" + menu_id + ", store_id=" + store_id + ", menu=" + menu + "]";
	}
	

	
	
}

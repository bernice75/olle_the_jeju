package com.olle.dto.jejusituation;

public class MenuDto {
	
	private Integer menu_id;
	private Integer store_id;
	private String menu;
	private Integer price;
	public MenuDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MenuDto(Integer menu_id, Integer store_id, String menu, Integer price) {
		super();
		this.menu_id = menu_id;
		this.store_id = store_id;
		this.menu = menu;
		this.price = price;
	}
	public Integer getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(Integer menu_id) {
		this.menu_id = menu_id;
	}
	public Integer getStore_id() {
		return store_id;
	}
	public void setStore_id(Integer store_id) {
		this.store_id = store_id;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "MenuDto [menu_id=" + menu_id + ", store_id=" + store_id + ", menu=" + menu + ", price=" + price + "]";
	}

	
}

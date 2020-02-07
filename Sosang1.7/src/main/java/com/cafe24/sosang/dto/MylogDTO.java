package com.cafe24.sosang.dto;

public class MylogDTO {
	private int idx;
	private String id;
	private String area;
	private String food;
	private String search_date;
	
	public MylogDTO() { /* default constructor */ }
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getFood() {
		return food;
	}
	public void setFood(String food) {
		this.food = food;
	}
	public String getSearch_date() {
		return search_date;
	}
	public void setSearch_date(String search_date) {
		this.search_date = search_date;
	}
	@Override
	public String toString() {
		return "MylogDTO [idx=" + idx + ", id=" + id + ", area=" + area + ", food=" + food + ", search_date="
				+ search_date + "]";
	}

	

}

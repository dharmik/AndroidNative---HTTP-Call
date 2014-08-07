package com.mobmaxime.httprequest;

public class createRow {
	
	 private String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public createRow(String title) {
		// TODO Auto-generated constructor stub
		this.title = title;
	}
	
	@Override
	public String toString() {
		return title ;
	}

	
}

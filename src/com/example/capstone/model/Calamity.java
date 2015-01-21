package com.example.capstone.model;

public class Calamity {
	private int id;
	private String data1;
	private String data2;
	private String url;
	
	public Calamity() {
		
	}
	public Calamity(String data1, String data2) {
		this.data1 = data1;
		this.data2 = data2;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getData1() {
		return data1;
	}
	public void setData1(String data1) {
		this.data1 = data1;
	}
	public String getData2() {
		return data2;
	}
	public void setData2(String data2) {
		this.data2 = data2;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}

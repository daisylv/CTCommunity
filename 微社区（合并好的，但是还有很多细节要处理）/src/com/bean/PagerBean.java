package com.bean;

public class PagerBean {
	
	private int pg = 0;//request传过来的页操作
	private int cuP = 0;//当前页
	
	private int beginItem = 0;//每页第一条
	private int endItem = 0;//每页最后一条记录
	private int maxItem = 0;//总条数
	
	public void setBeginItem(int beginItem) {
		this.beginItem = beginItem;
	}
	public int getBeginItem() {
		return beginItem;
	}
	
	public void setCuP(int cuP) {
		this.cuP = cuP;
	}
	public int getCuP() {
		return cuP;
	}
	
	public void setEndItem(int endItem) {
		this.endItem = endItem;
	}
	public int getEndItem() {
		return endItem;
	}
	
	public void setMaxItem(int maxItem) {
		this.maxItem = maxItem;
	}
	public int getMaxItem() {
		return maxItem;
	}
	
	public void setPg(int pg) {
		this.pg = pg;
	}
	public int getPg() {
		return pg;
	}
}

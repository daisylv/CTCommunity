package com.bean;

public class PagerBean {
	
	private int pg = 0;//request��������ҳ����
	private int cuP = 0;//��ǰҳ
	
	private int beginItem = 0;//ÿҳ��һ��
	private int endItem = 0;//ÿҳ���һ����¼
	private int maxItem = 0;//������
	
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

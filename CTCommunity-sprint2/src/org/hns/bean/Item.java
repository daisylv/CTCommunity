package org.hns.bean;

public class Item {
	private int Itemid;
	private String ItemCountent;
	private int ownerId;
	private String communityItemcol;

	public void setItemid(int itemid) {
		Itemid = itemid;
	}
	
	public int getItemid() {
		return Itemid;
	}
	
	public void setItemCountent(String itemCountent) {
		ItemCountent = itemCountent;
	}
	
	public String getItemCountent() {
		return ItemCountent;
	}
	
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
	
	public int getOwnerId() {
		return ownerId;
	}
	
	public void setCommunityItemcol(String communityItemcol) {
		this.communityItemcol = communityItemcol;
	}
	
	public String getCommunityItemcol() {
		return communityItemcol;
	}
}


package org.hns.bean;

public class Item {
	private int Itemid;
	private String ItemCountent;
	private int ownerId;
	private String ItemName;
	private int communityId;
	
	public void setCommunityId(int communityId) {
		this.communityId = communityId;
	}
	public int getCommunityId() {
		return communityId;
	}

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
	
	public void setItemName(String itemName) {
		ItemName = itemName;
	}
	public String getItemName() {
		return ItemName;
	}
}


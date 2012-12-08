package org.hns.bean;

public class Community {
	private int communityId;
	private String communityName;
	private String communityIntro;
	private String communityType;
	private int ownerId;
	
	public void setCommunityId(int communityId) {
		this.communityId = communityId;
	}
	public int getCommunityId() {
		return communityId;
	}
	
	public void setCommunityName(String communityName) {
		this.communityName = communityName;
	}
	public String getCommunityName() {
		return communityName;
	}
	
	public void setCommunityIntro(String communityIntro) {
		this.communityIntro = communityIntro;
	}
	public String getCommunityIntro() {
		return communityIntro;
	}
	
	public void setCommunityType(String communityType) {
		this.communityType = communityType;
	}
	public String getCommunityType() {
		return communityType;
	}
	
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}
	public int getOwnerId() {
		return ownerId;
	}
}

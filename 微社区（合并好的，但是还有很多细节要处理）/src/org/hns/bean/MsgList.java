package org.hns.bean;

public class MsgList {
	
	private int senderId;
	private int msgId;
	private int receiverId;
	private int communityId;
	private String content;
	
	public void setContent(String content) {
		this.content = content;
	}
	public String getContent() {
		return content;
	}
	
	public void setMsgId(int msgId) {
		this.msgId = msgId;
	}
	public int getMsgId() {
		return msgId;
	}
	
	public void setReceiverId(int receiverId) {
		this.receiverId = receiverId;
	}
	public int getReceiverId() {
		return receiverId;
	}
	
	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}
	public int getSenderId() {
		return senderId;
	}
	
	public void setCommunityId(int communityId) {
		this.communityId = communityId;
	}
	public int getCommunityId() {
		return communityId;
	}
}
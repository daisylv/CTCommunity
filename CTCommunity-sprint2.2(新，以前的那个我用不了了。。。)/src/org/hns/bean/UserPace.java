package org.hns.bean;

import java.sql.Timestamp;


public class UserPace {
	private int userId;
	private String userpace;
	private Timestamp timestamp;
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getUserId() {
		return userId;
	}
	
	public void setUserpace(String userpace) {
		this.userpace = userpace;
	}
	public String getUserpace() {
		return userpace;
	}
	
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
}

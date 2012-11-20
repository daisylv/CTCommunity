package org.hns.bean;

public class User {
	
	private int userId;
	private int sinaId;
	private String username;
	private String usergender;
	private String password;
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public void setSinaId(int sinaId) {
		this.sinaId = sinaId;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setUsergender(String usergender) {
		this.usergender = usergender;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public int getSinaId() {
		return sinaId;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getUsergender() {
		return usergender;
	}
	
	/*public void setUserId(int userId){
		this.userId = userId;
	}
	public int getUserId(){
		return userId;
	}
	
	public void setSinaId(int sinaId){
		this.sinaId = sinaId;
	}
	public int getSinaId(){
		return sinaId;
	}
	
	public void setUsername(String username){
		this.username = username;
	}
	public String getUsername(){
		return username;
	}
	
	public void setUsergender(String usergender){
		this.usergender = usergender;
	}
	public String getUsergender(){
		return usergender;
	}*/
}

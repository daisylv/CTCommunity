package com.action;

import org.hns.bean.User;
import org.hns.user.dao.UserHibDao;

import com.opensymphony.xwork2.ActionSupport;

public class Login extends ActionSupport{
	
	private User user = new User();
	public void setUser(User user) {
		this.user = user;
	}
	public User getUser() {
		return user;
	}
	
	public String login(){
		System.out.println("Login!");
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		int id = UserHibDao.finduser(user.getUsername(), user.getPassword());
		if(id == -1){
			return "noneuser";
		}
		else if(id == -2){
			return "failpassword";
		}
		else if(id == 0){
			return "error";
		}
		else{
			user.setUserId(id);
			return "success";
		}
	}
}

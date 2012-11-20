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
		int id = UserHibDao.finduser(user.getUsername(), user.getPassword());
		user.setUserId(id);
		return "success";
	}
}

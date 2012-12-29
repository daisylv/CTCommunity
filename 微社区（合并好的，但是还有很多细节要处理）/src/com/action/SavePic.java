package com.action;

import org.apache.struts2.ServletActionContext;
import org.hns.bean.User;
import org.hns.user.dao.UserHibDao;

import com.opensymphony.xwork2.ActionSupport;

public class SavePic extends ActionSupport{
	
	String picpath;
	public void setPicpath(String picpath) {
		this.picpath = picpath;
	}
	public String getPicpath() {
		return picpath;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		int userid = Integer.parseInt(ServletActionContext.getRequest().getSession().getAttribute("userid").toString());
		User user = UserHibDao.getuser(userid);
		user.setPicpath(picpath);
		System.out.println(user.getUsername());
		System.out.println(user.getPicpath());
		System.out.println(user.getUsername());
		UserHibDao.update(user);
		System.out.println("save picture");
		
		return "success";
	}
	
	
}

package com.action;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.apache.struts2.ServletActionContext;
import org.hns.bean.Community;
import org.hns.bean.User;
import org.hns.user.dao.UserHibDao;

import com.opensymphony.xwork2.ActionSupport;
import communityDB.Userinfo;

public class Login extends ActionSupport{
	
	private User user = new User();
	public void setUser(User user) {
		this.user = user;
	}
	public User getUser() {
		return user;
	}
	
	private List<Community>communitylist2=Hello.communitylist;
	public List<Community> getCommunitylist2() {
		return communitylist2;
	}
	
	private Userinfo weiboinfo = new Userinfo();
	public void setWeiboinfo(Userinfo weiboinfo) {
		this.weiboinfo = weiboinfo;
	}
	public Userinfo getWeiboinfo() {
		return weiboinfo;
	}
	private String id;
	public void setId(String id) {
		this.id = id;
	}
	public String getId() {
		return id;
	}
	public String login(){
		System.out.println("Login!");
		System.out.println(user.getUsername());
		System.out.println(weiboinfo.getWeiboId());
		System.out.println(weiboinfo.getUserId());
		
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
	
	public String loginByweibo(){
		System.out.println("Login!");
		String sinaWeiboid = (String) ServletActionContext.getRequest().getSession().getAttribute("weiboId");
		String weiboid = UserHibDao.findUserbyWeibo(sinaWeiboid); 
		System.out.println(weiboid);
		if(weiboid=="registe")
			return "registe";
		
		weiboinfo.setWeiboId(sinaWeiboid);
		setId(sinaWeiboid);				//前段获取不到Userinfo.weiboId
		System.out.println(getId());
		
		return "success";
	}
}

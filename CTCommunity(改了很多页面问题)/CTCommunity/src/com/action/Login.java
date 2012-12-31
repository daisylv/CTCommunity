package com.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.hns.bean.Community;
import org.hns.bean.User;
import org.hns.bean.UserPace;
import org.hns.user.dao.UserHibDao;
import org.hns.user.dao.UserPaceHibDao;

import com.opensymphony.xwork2.ActionSupport;
import communityDB.Weiboinfo;

public class Login extends ActionSupport{
	//private HttpServletRequest request;
	private User user = new User();
	public void setUser(User user) {
		this.user = user;
	}
	public User getUser() {
		return user;
	}
	
	private List<Community>communitylist2=Hello.communitylist;
	
	public static List<Community>userCommunity = new ArrayList<Community>();
	
	public List<Community> getCommunitylist2() {
		return communitylist2;
	}
	
	private Weiboinfo weiboinfo = new Weiboinfo();
	public void setWeiboinfo(Weiboinfo weiboinfo) {
		this.weiboinfo = weiboinfo;
	}
	public Weiboinfo getWeiboinfo() {
		return weiboinfo;
	}
	private String id;
	public void setId(String id) {
		this.id = id;
	}
	public String getId() {
		return id;
	}
	
	public static List<UserPace> userpace = new ArrayList<UserPace>();
	public static void setUserpace(List<UserPace> userpace) {
		Login.userpace = userpace;
	}
	public static List<UserPace> getUserpace() {
		return userpace;
	}
	
	public String login(){
		//request=ServletActionContext.getRequest();
		System.out.println("Login!");
		System.out.println(user.getUsername());
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
			user = UserHibDao.getuser(id);
			userpace = UserPaceHibDao.selectPaces(id);
			userCommunity.clear();
			for(int i = 0; i<communitylist2.size();++i){
				Community cur = communitylist2.get(i);
				if(cur.getOwnerId()==id)
					userCommunity.add(cur);
			}
			//ServletActionContext.getRequest().getSession().setAttribute("type", "abc");
			ServletActionContext.getRequest().getSession().setAttribute("userid", user.getUserId());
			ServletActionContext.getRequest().getSession().setAttribute("username", user.getUsername());
			ServletActionContext.getRequest().getSession().setAttribute("picpath", user.getPicpath());
			//UserHibDao.getuser(user.getUserId());
			System.out.println(user.getPicpath());
			System.out.println("success");
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
		setId(sinaWeiboid);				//前段获取不到Weiboinfo.weiboId
		System.out.println(getId());
		
		return "success";
	}
}

package com.action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.mapper.ActionMapping;
import org.hns.bean.Community;
import org.hns.user.dao.CommunityHibDao;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class Addcommunity extends ActionSupport{
	/**
	 * 
	 */
	private HttpServletRequest request;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private Community community = new Community();
	
	public void setCommunity(Community community) {
		this.community = community;
	}
	
	public Community getCommunity() {
		return community;
	}
	
	
	public String add(){
		request = ServletActionContext.getRequest();
		System.out.println("Your communityName is: "+community.getCommunityName());
		System.out.println("Your communityType is: "+community.getCommunityType());
		
		//int communityid = community.getCommunityId();
		//System.out.println(communityid);
		//userOwned.setCommunityId(communityid);
		//request.getSession().setAttribute("communityid", communityid);
		int userid = (int)ServletActionContext.getRequest().getSession().getAttribute("userid");  
		System.out.println(userid);
		community.setOwnerId(userid);
		//userOwned.setUserId(userid);
		//CommunityHibDao.insert(userOwned);
		CommunityHibDao.insert(community);
		//向我的足迹加代码
		System.out.println("Insert successfully!");
		return "success";
	}

}

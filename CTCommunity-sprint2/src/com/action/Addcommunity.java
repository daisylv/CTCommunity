package com.action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.dispatcher.mapper.ActionMapping;
import org.hns.bean.Community;
import org.hns.user.dao.CommunityHibDao;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class Addcommunity extends ActionSupport{
	/**
	 * 
	 */
	
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
		System.out.println("Your communityName is: "+community.getCommunityName());
		System.out.println("Your communityType is: "+community.getCommunityType());
		CommunityHibDao.insert(community);
		return "success";
	}

}

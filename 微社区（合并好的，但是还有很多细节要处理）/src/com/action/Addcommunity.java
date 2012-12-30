package com.action;

import org.apache.struts2.ServletActionContext;
import org.hns.bean.Community;
import org.hns.bean.CommunityMember;
import org.hns.bean.UserPace;
import org.hns.user.dao.CommunityHibDao;
import org.hns.user.dao.MemHibDao;
import org.hns.user.dao.UserPaceHibDao;

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
		Hello.communitylist.add(community);
		Login.userCommunity.add(community);
		//向我的足迹加代码
		UserPace userPace = GetPace.setPaceInfo("在CTCommunity新建了社区："+community.getCommunityName());
		System.out.println(userPace.getTimestamp());
		UserPaceHibDao.insert(userPace);
		
		CommunityMember communitymember = new CommunityMember();
		communitymember.setUserId(userid);
		System.out.println(communitymember.getUserId());
		communitymember.setCommunityId(community.getCommunityId());
		System.out.println(communitymember.getCommunityId());
		MemHibDao.insert(communitymember);
		
		System.out.println("Insert successfully!");
		return "success";
	}

}

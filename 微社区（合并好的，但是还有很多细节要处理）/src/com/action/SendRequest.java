package com.action;

import org.apache.struts2.ServletActionContext;
import org.hns.bean.MsgList;
import org.hns.bean.UserPace;
import org.hns.user.dao.MsgHibDao;
import org.hns.user.dao.UserPaceHibDao;

import com.opensymphony.xwork2.ActionSupport;

public class SendRequest extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5367358783769654989L;
	private MsgList msg = new MsgList();
	int communityId;
	public void setCommunityId(int communityId) {
		this.communityId = communityId;
	}
	public int getCommunityId() {
		return communityId;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		communityId = Integer.parseInt(ServletActionContext.getRequest().getParameter("communityId"));
		System.out.println(communityId);
		int ownerId = Integer.parseInt(ServletActionContext.getRequest().getParameter("ownerId"));
		System.out.println(ownerId);
		int userid = (int)ServletActionContext.getRequest().getSession().getAttribute("userid");
		System.out.println(userid);
		String communityName = ServletActionContext.getRequest().getParameter("communityName");
		System.out.println(communityName);
		msg.setReceiverId(ownerId);
		msg.setCommunityId(communityId);
		msg.setSenderId(userid);
		msg.setContent(ServletActionContext.getRequest().getSession().getAttribute("username")+"申请加入社区："+communityName);
		MsgHibDao.insert(msg);
		//还有userpace也要添加！
		UserPace userPace = GetPace.setPaceInfo("申请了加入社区："+communityName);
		System.out.println(userPace.getUserId());
		System.out.println(userPace.getUserpace());
		System.out.println(userPace.getTimestamp());
		UserPaceHibDao.insert(userPace);
		System.out.println("success insert userpace!");
		//ServletActionContext.getRequest().setAttribute("communityId", communityId);
		return "success";
	}
}

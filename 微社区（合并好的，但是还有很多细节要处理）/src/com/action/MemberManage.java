package com.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hns.bean.CommunityMember;
import org.hns.bean.MsgList;
import org.hns.bean.User;
import org.hns.user.dao.MemHibDao;
import org.hns.user.dao.MsgHibDao;
import org.hns.user.dao.UserHibDao;

import com.opensymphony.xwork2.ActionSupport;

public class MemberManage extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6384440244616681605L;
	
	public static CommunityMember communityMember = new CommunityMember();
	public static List<MsgList>msglist = new ArrayList<MsgList>();
	public int communityId;
	public static MsgList msg = new MsgList();
	public static List<User>userlist = new ArrayList<User>();//貌似还没用到
	
	public static void setMsglist(List<MsgList> msglist) {
		MemberManage.msglist = msglist;
	}
	public static List<MsgList> getMsglist() {
		return msglist;
	}
	
	public static void setUserlist(List<User> userlist) {
		UserAct.userlist = userlist;
	}
	public static List<User> getUserlist() {
		return userlist;
	}
	
	public static List<User> getUsers(){
		userlist = UserHibDao.select();
		return userlist;//获取所有用户。。。。还是把这个写上了，我知道太不爽了
	}
	
	public static String add(){
		int userId = (int)ServletActionContext.getRequest().getSession().getAttribute("userid");
		int communityId = Integer.parseInt(ServletActionContext.getRequest().getParameter("communityId"));
		int senderId = Integer.parseInt(ServletActionContext.getRequest().getParameter("senderId"));
		communityMember.setCommunityId(communityId);
		communityMember.setUserId(senderId);
		MemHibDao.insert(communityMember);
		System.out.println("AddMember successfully!");
		msg = MsgHibDao.select(userId, senderId);
		System.out.println(msg.getContent());
		MsgHibDao.delete(msg.getMsgId());
		System.out.println("Deleting successfully!");
		try{
			msglist = MsgHibDao.selectbyreceiverId(userId);
			if(msglist.size()==0)
				return "success";
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return "success";
	}
	
	public static void deleteMem(){
		
	}
	
	public String getMsgli(){
		System.out.println("Come Into the MemberManage");
		communityId = Integer.parseInt((ServletActionContext.getRequest().getParameter("communityId")));
		int userId = (int)ServletActionContext.getRequest().getSession().getAttribute("userid");
		msglist = MsgHibDao.selectbyreceiverId(userId);
		if(msglist.size()!=0)
			System.out.println(msglist.get(0).getSenderId());
		getUsers();
		// TODO Auto-generated method stub
		return "success";
	}
	
}

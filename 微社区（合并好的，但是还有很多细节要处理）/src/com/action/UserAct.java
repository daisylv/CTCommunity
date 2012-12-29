package com.action;

import java.util.ArrayList;
import java.util.List;

import org.hns.bean.MsgList;
import org.hns.bean.User;
import org.hns.user.dao.UserHibDao;

import com.opensymphony.xwork2.ActionSupport;

public class UserAct extends ActionSupport{
	
	//private List<MsgList> sdMsglist = new ArrayList();
	//private List<MsgList> rcMsglist = new ArrayList();
	public static List<User>userlist = new ArrayList<User>();
	public static void setUserlist(List<User> userlist) {
		UserAct.userlist = userlist;
	}
	public static List<User> getUserlist() {
		return userlist;
	}
	public static List<User> getUsers(){
		userlist = UserHibDao.select();
		return userlist;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		
		return super.execute();
	}
}

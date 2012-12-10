package com.action;

import java.sql.Date;

import javax.xml.crypto.Data;

import org.apache.struts2.ServletActionContext;
import org.hns.bean.UserPace;

import com.sun.jmx.snmp.Timestamp;


public class GetPace {
	
	//private static UserPace userPace;
	private static String username;
	private static int userid;
	private static String actString;
	
	public static UserPace setPaceInfo(String actionString){
		userid = (int) ServletActionContext.getRequest().getSession().getAttribute("userid");
		//System.out.println(userid);
		username = (String)ServletActionContext.getRequest().getSession().getAttribute("username");
		//System.out.println(username);
		UserPace userPace = new UserPace();
		userPace.setUserId(userid);
		//System.out.println(userPace.getUserId());
		actString = username+"∏’∏’"+actionString+"£¨øÏ¿¥Œßπ€≈∂£°";
		userPace.setUserpace(actString);
		System.out.println(userPace.getUserpace());
		//Date time = new Date
		//time.getTime();
		//Timestamp time = new Timestamp(System.currentTimeMillis()); 
		//System.out.println(time.getDate());
		//userPace.setTime(System.currentTimeMillis());
		//System.out.println(userPace.getTime());
		return userPace;
	}
}

package com.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hns.bean.CommunityMember;
import org.hns.bean.MsgList;
import org.hns.user.dao.MsgHibDao;

import com.opensymphony.xwork2.ActionSupport;

public class MsgConfirm extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -971601582675119301L;

	public static String confirm(int ownerid, int communityid){
		int userid=0;
		if(ServletActionContext.getRequest().getSession().getAttribute("userid")!=null){
			userid=(int)ServletActionContext.getRequest().getSession().getAttribute("userid");
			if(userid==ownerid){
				return "manage";
			}
			else {
				//判断msglist，不存在返回申请，存在返回等待批准。
				List<MsgList> msglist = (List<MsgList>) MsgHibDao.selectbySender(userid);
				List<CommunityMember> memberlist = InCommunity.memberlist;
				for(int i = 0; i < msglist.size(); ++i){
					if(msglist.get(i).getReceiverId()==ownerid&&msglist.get(i).getCommunityId()== communityid)
						return "sended";
				}
				for(int i = 0; i < memberlist.size(); ++i){
					if(memberlist.get(i).getUserId() == userid)
						return "member";
				}
				return "requestsend";
			}
		}
		else{
			return "nonuser";
		}
		//System.out.println(userid);
		//if(userid==0){
			//return "nonuser";
		//}
		/*if(userid==ownerid){
			return "manage";
		}
		else{
			//判断msglist，不存在返回申请，存在返回等待批准。
			List<MsgList> msglist = (List<MsgList>) MsgHibDao.selectbySender(userid);
			for(int i = 0; i < msglist.size(); ++i){
				if(msglist.get(i).getReceiverId()==ownerid)
					return "sended";
			}
			return "requestsend";
		}*/
	}
}

package com.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hns.bean.Community;
import org.hns.user.dao.CommunityHibDao;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class Hello extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1218418035464402709L;
	public static String[] ctype = {
		"�˶�","����Ƭ","����","ѧϰ","����","��ʳ","��ѧ","IT","����","��Ӱ","����","����","����","���",
		"����","����","������","����","��ְ","����"
	};
	public static List<Community> communitylist = new ArrayList<Community>(); 
	public static List<String> typelist = new ArrayList<String> ();
	
	public void setCommunitylist(List<Community> communitylist) {
		Hello.communitylist = communitylist;
	}
	
	public List<Community> getCommunitylist() {
		return communitylist;
	}
	

	@Override
	public String execute() throws Exception {
		System.out.println(ctype[0]);
		//System.out.println(ctype[1]);
		// TODO Auto-generated method stub
		typelist.clear();
		for(int i = 0; i<ctype.length; ++i){
			typelist.add(ctype[i]);
		}
		//ServletActionContext.getRequest().setAttribute("typelist", typelist);
		Hello.communitylist = CommunityHibDao.select();
		ActionContext.getContext().getSession().put("communitylist", communitylist);
		System.out.println(communitylist.get(0).getCommunityName());
		System.out.println("Hello!");
		return super.execute();
	}
	
}

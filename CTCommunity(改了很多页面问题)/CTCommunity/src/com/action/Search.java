package com.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hns.bean.Community;
import org.hns.user.dao.CommunityHibDao;

import com.opensymphony.xwork2.ActionSupport;

public class Search extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String searchcontent;
	public void setSearchcontent(String searchcontent) {
		this.searchcontent = searchcontent;
	}
	public String getSearchcontent() {
		return searchcontent;
	}
	
	private List<Community> communitySearchlist = new ArrayList<Community>();
	public void setCommunitySearchlist(List<Community> communitySearchlist) {
		this.communitySearchlist = communitySearchlist;
	}
	public List<Community> getCommunitySearchlist() {
		return communitySearchlist;
	}
	
	public String searchOwn(){
		int userid = Integer.parseInt(ServletActionContext.getRequest().getSession().getAttribute("userid").toString());
		List<Community> communitySearchlist2 = CommunityHibDao.search(searchcontent);
		if(communitySearchlist2==null){
			System.out.println("search none");
			return "failed";
		}
		for(int i = 0; i<communitySearchlist2.size(); ++i){
			if(communitySearchlist2.get(i).getOwnerId()==userid){
				communitySearchlist.add(communitySearchlist2.get(i));
				//System.out.println("!!!");
			}
		}
		if(communitySearchlist==null){
			System.out.println("search none");
			return "failed";
		}
		return "success";
	}
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("come in!");
		System.out.println(searchcontent);
		communitySearchlist = CommunityHibDao.search(searchcontent);
		if(communitySearchlist==null&&ServletActionContext.getRequest().getSession().getAttribute("userid")==null){
			System.out.println("search none");
			return "failed";
		}
		if(communitySearchlist==null){
			return "userfailed";
		}
		return "success";
	}
}

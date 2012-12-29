package com.action;

import java.util.List;

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
	
	private List<Community> communitySearchlist;
	public void setCommunitySearchlist(List<Community> communitySearchlist) {
		this.communitySearchlist = communitySearchlist;
	}
	public List<Community> getCommunitySearchlist() {
		return communitySearchlist;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("come in!");
		System.out.println(searchcontent);
		communitySearchlist = CommunityHibDao.search(searchcontent);
		if(communitySearchlist==null){
			return "nonefit";
		}
		return "success";
	}
}

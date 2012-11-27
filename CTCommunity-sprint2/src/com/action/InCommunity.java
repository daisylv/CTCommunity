package com.action;

import java.util.List;

import org.hns.bean.Community;

import com.opensymphony.xwork2.ActionSupport;

public class InCommunity extends ActionSupport{
	
	private List<Community> list = Hello.communitylist;
	private Community currentCommunity = new Community();
	private int communityId;
	public void setCommunityId(int communityId) {
		this.communityId = communityId;
	}
	/*public int getCommunityId() {
		return communityId;
	}*/
	/*private List<Community> list;
	private Community thisCommunity;
	
	public void setList(List<Community> list) {
		this.list = list;
	}
	
	public List<Community> getList() {
		return list;
	}
	
	public void setThisCommunity(Community thisCommunity) {
		this.thisCommunity = thisCommunity;
	}
	public Community getThisCommunity() {
		return thisCommunity;
	}*/
	public void findCommunity(int communityId){
		for(int i = 0; i<list.size();++i ){
			if(communityId == list.get(i).getCommunityId()){
				currentCommunity = list.get(i);
				break;
			}
		}
	}
	
	public Community getCurrentCommunity() {
		return currentCommunity;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		//String s = list.get(0).getCommunityName();
		//System.out.println(s);
		//System.out.println(thisCommunity.getCommunityName());
		findCommunity(communityId);
		System.out.println(communityId);
		System.out.println(currentCommunity.getCommunityName());
		return "success";
	}
}

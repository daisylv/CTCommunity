package com.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.mapper.ActionMapping;
import org.hns.bean.Item;
import org.hns.user.dao.ItemHibDao;
import org.hns.user.dao.ItemHibDao;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class Additem extends ActionSupport{
	
	private HttpServletRequest request;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    private Item item = new Item();
    private int communityId;
    public void setCommunityId(int communityId) {
		this.communityId = communityId;
	}
    public int getCommunityId() {
		return communityId;
	}
    public void setItem(Item item) {
		this.item = item;
	}
    
    public Item getItem() {
		return item;
	}
    
    public String add(){
    	request = ServletActionContext.getRequest();
    	System.out.println("Your ItemName is: "+item.getItemName());
		System.out.println("Your ItemContent is: "+item.getItemCountent());
		int ownerId = (int)ServletActionContext.getRequest().getSession().getAttribute("userid");
		item.setOwnerId(ownerId);
		//int comminityId = Integer.parseInt(request.getParameter("communityId").toString());
		System.out.println(communityId);
		item.setCommunityId(communityId);
		ItemHibDao.insert(item);
		System.out.println("Insert successfully!");
		return "success";
    }	
}
    

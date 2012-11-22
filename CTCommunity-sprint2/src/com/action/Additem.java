package com.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.dispatcher.mapper.ActionMapping;
import org.hns.bean.Item;
import org.hns.user.dao.ItemHibDao;
import org.hns.user.dao.ItemHibDao;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class Additem extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    private Item item = new Item();
    
    public void setItem(Item item) {
		this.item = item;
	}
    
    public Item getItem() {
		return item;
	}
    
    public String add(){
    	System.out.println("Your ItemName is: "+item.getItemName());
		System.out.println("Your ItemContent is: "+item.getItemCountent());
		ItemHibDao.insert(item);
		System.out.println("Insert successfully!");
		return "success";
    }	
}
    

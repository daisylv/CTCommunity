package com.action;

import java.util.Collection;

import org.apache.struts2.ServletActionContext;

import com.bean.PagerBean;
import com.opensymphony.xwork2.ActionSupport;

public class Pager extends ActionSupport{
	
	private PagerBean pagerbean = new PagerBean();
	public PagerBean getPagerbean() {
		return pagerbean;
	}
	public void setPagerbean(PagerBean pagerbean) {
		this.pagerbean = pagerbean;
	}
	
	private PagerBean pagerbean2 = new PagerBean();
	public void setPagerbean2(PagerBean pagerbean2) {
		this.pagerbean2 = pagerbean2;
	}
	public PagerBean getPagerbean2() {
		return pagerbean2;
	}
	
	public String communityPager(){
		int type = Integer.parseInt(ServletActionContext.getRequest().getParameter("ty"));
		
		System.out.println("come int page");
		int pg =  Integer.parseInt(ServletActionContext.getRequest().getParameter("page"));
		pagerbean.setPg(pg);
		
		System.out.println(pg);
		int cuP =  Integer.parseInt(ServletActionContext.getRequest().getParameter("cuPage"));
		pagerbean.setCuP(cuP);
		System.out.println(cuP);
		
		int pg2 =  Integer.parseInt(ServletActionContext.getRequest().getParameter("page2"));
		int cuP2 =  Integer.parseInt(ServletActionContext.getRequest().getParameter("cuPage2"));
		pagerbean2.setPg(pg2);
		pagerbean2.setCuP(cuP2);
		
		if(type==1){
		
			if(pg==-1){
				pagerbean.setCuP(--cuP);
			}
			if(pg==1){
				pagerbean.setCuP(++cuP);
			}
			if(pagerbean.getCuP()<=0){
				pagerbean.setCuP(1);
			}
		}
		int beginItem = 5*(cuP-1);//0
		pagerbean.setBeginItem(beginItem);
		int endItem = beginItem+4;//4
		pagerbean.setEndItem(endItem);
		int maxItem = com.action.Login.userCommunity.size()-1;
		pagerbean.setMaxItem(maxItem);
		if(pagerbean.getEndItem()>=pagerbean.getMaxItem()+1){
			pagerbean.setEndItem(maxItem);
		}
		
		if(type==2){
			
			if(pg2==-1){
				pagerbean2.setCuP(--cuP2);
			}
			if(pg2==1){
				pagerbean2.setCuP(++cuP2);
			}
			if(cuP2<=0){
				pagerbean2.setCuP(1);
			}
		}

		int beginItem2 = 5*(cuP2-1);//0
		pagerbean2.setBeginItem(beginItem2);
		int endItem2 = beginItem2+4;//4
		pagerbean2.setEndItem(endItem2);
		int maxItem2 = com.action.Login.userpace.size()-1;
		pagerbean2.setMaxItem(maxItem2);
		if(pagerbean2.getEndItem()>=pagerbean2.getMaxItem()+1){
			pagerbean2.setEndItem(maxItem2);
		}
		return "pager";
	}
	
	/*public String pacePager(){
		System.out.println("come int page");
		int pg2 =  Integer.parseInt(ServletActionContext.getRequest().getParameter("page2"));
		int cuP2 =  Integer.parseInt(ServletActionContext.getRequest().getParameter("cuPage2"));
		pagerbean2.setPg(pg2);
		pagerbean2.setCuP(cuP2);
		if(pg2==-1){
			pagerbean2.setCuP(--cuP2);
		}
		if(pg2==1){
			pagerbean2.setCuP(++cuP2);
		}
		if(cuP2<=0){
			pagerbean2.setCuP(1);
		}
		
		int beginItem2 = 5*(cuP2-1);//0
		pagerbean2.setBeginItem(beginItem2);
		int endItem2 = beginItem2+4;//4
		pagerbean2.setEndItem(endItem2);
		int maxItem2 = com.action.Login.userpace.size()-1;
		pagerbean2.setMaxItem(maxItem2);
		if(pagerbean2.getEndItem()>=pagerbean2.getMaxItem()+1){
			pagerbean2.setEndItem(maxItem2);
		}
		
		return "pager";
	}*/
}

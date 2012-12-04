package com.action;

import com.opensymphony.xwork2.ActionSupport;


public class Hello extends ActionSupport{
	private String msg;
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Hello!");
		return super.execute();
	}
	
}

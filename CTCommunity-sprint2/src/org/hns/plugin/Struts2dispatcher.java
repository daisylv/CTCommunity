package org.hns.plugin;

import javax.servlet.FilterConfig;
import javax.servlet.ServletException;

import org.apache.struts2.dispatcher.FilterDispatcher;

import com.sun.xml.internal.ws.handler.HandlerException;

@SuppressWarnings("deprecation")
public class Struts2dispatcher extends FilterDispatcher{
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		super.init(filterConfig);
		try{
			HibernateUtil.createSeesionFactory();
			System.out.println("Application initializing successfully!");
		}catch(HandlerException e){
			throw new ServletException(e);
		}
	}
}

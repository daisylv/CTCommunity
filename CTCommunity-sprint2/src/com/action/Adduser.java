package com.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.dispatcher.mapper.ActionMapping;
import org.hns.bean.User;
import org.hns.user.dao.UserHibDao;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;



public class Adduser extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5556396704823935544L;
	/*public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)*/
	/*private int UserId;
	private int SinaId;
	
	public void setUserId(int userId) {
		UserId = userId;
	}
	
	public void setSinaId(int sinaId) {
		SinaId = sinaId;
	}
	*/
	
	/*ActionContext context = ActionContext.getContext();
	Map param = context.getParameters();
	int userid = (int)param.get("userid");
	int sinaid = (int)param.get("sinaid");*/
	private User user = new User();
	
	
	public void setUser(User user) {
		this.user = user;
	}
	
	
	public User getUser() {
		return user;
	}
	/*public void setUser(){
		user.setUserId(Integer.parseInt(UserId));
		user.setSinaId(Integer.parseInt(SinaId));
	}
	public User getUser(){
		return user;
	}*/
	
	/*public void setUserid(int userid){
		this.userid = userid;
	}
	public int getUserid(){
		return userid;
	}
	
	public void setSinaid(int sinaid){
		this.sinaid = sinaid;
	}
	public int getSinaid(){
		return sinaid;
	}*/
	@Override
	public void validate() {
		// TODO Auto-generated method stub
		if(getUser().getUsername()==null||"".equals(getUser().getUsername().trim()))
			this.addFieldError("User.username", "请输入用户名");
		if(getUser().getPassword()==null||"".equals(getUser().getPassword().trim()))
			this.addFieldError("User.password", "请输入密码");
		super.validate();
	}
	
	public String add() {
		//int u = user.getUserId();
		//String s = SinaId;
		System.out.println("Your sinaID is: "+user.getSinaId());
		System.out.println("Your userID is: "+user.getUserId());
		System.out.println("Your username is: "+user.getUsername());
		System.out.println("Come in!");
		UserHibDao.insert(user);
		return "success";
		
	}
	/*public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Come in!");
		UserHibDao.insert(user);
		return SUCCESS;
	}*/
	
}

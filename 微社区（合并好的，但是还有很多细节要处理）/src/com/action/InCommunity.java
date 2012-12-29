package com.action;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
//import org.hibernate.cache.ReadWriteCache.Item;
import org.hns.bean.Community;
import org.hns.bean.CommunityMember;
import org.hns.bean.User;
import org.hns.user.dao.MemHibDao;
import org.hns.user.dao.UserHibDao;

import com.opensymphony.xwork2.ActionSupport;

import communityDB.AccountHelper;
import communityDB.CommunityItem;
import communityDB.Topicinfo;

public class InCommunity extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2677038390978622498L;
	
	private List<Community> list = new ArrayList<Community>();
	private Community currentCommunity = new Community();
	private CommunityItem currentitem = new CommunityItem();
	private static String communityId;
	private int communityid;
	public static void setCommunityId(String communityId) {
		InCommunity.communityId = communityId;
	}
	public static String getCommunityId() {
		return communityId;
	}
	//public static List<CommunityItem> itemlist; 
	public static List<CommunityMember>memberlist;
	public static List<User> userList = new ArrayList<User>();
	public static void setUserList(List<User> userList) {
		InCommunity.userList = userList;
	}
	public static List<User> getUserList() {
		return userList;
	}
	
	public static String msgconfirm;
	public void setMsgconfirm(String msgconfirm) {
		InCommunity.msgconfirm = msgconfirm;
	}
	public String getMsgconfirm() {
		return msgconfirm;
	}
	
	
	int beginItem;
	int cuP;
	int endItem;
	int maxItem;
	int pg;
	public void setBeginItem(int beginItem) {
		this.beginItem = beginItem;
	}
	public int getBeginItem() {
		return beginItem;
	}
	public void setCuP(int cuP) {
		this.cuP = cuP;
	}
	public int getCuP() {
		return cuP;
	}
	public void setEndItem(int endItem) {
		this.endItem = endItem;
	}
	public int getEndItem() {
		return endItem;
	}
	public void setMaxItem(int maxItem) {
		this.maxItem = maxItem;
	}
	public int getMaxItem() {
		return maxItem;
	}
	public void setPg(int pg) {
		this.pg = pg;
	}
	public int getPg() {
		return pg;
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
	
	public void setPager(){
		
		pg =  Integer.parseInt(ServletActionContext.getRequest().getParameter("page"));
		cuP =  Integer.parseInt(ServletActionContext.getRequest().getParameter("cuPage"));
		
		if(pg==-1){
			--cuP;
		}
		if(pg==1){
			++cuP;
		}
		if(cuP<=0){
			cuP=1;
		}
		beginItem = 5*(cuP-1);//0
		endItem = beginItem+4;//4
		maxItem = topics.size()-1;
		if(endItem>=maxItem+1){
			endItem = maxItem;
		}
	}
	
	public void findCommunity(int communityId){
		for(int i = 0; i<Hello.communitylist.size();++i ){
			if(communityId == Hello.communitylist.get(i).getCommunityId()){
				currentCommunity = Hello.communitylist.get(i);
				break;
			}
		}
	}
	
	public Community getCurrentCommunity() {
		return currentCommunity;
	}
	public CommunityItem getCurrentitem() {
		return currentitem;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		//String s = list.get(0).getCommunityName();
		//System.out.println(s);
		//System.out.println(thisCommunity.getCommunityName());
		list = Hello.communitylist;
		if(communityId!=null){
			communityid = Integer.parseInt(communityId);
		}
		if(ServletActionContext.getRequest().getParameter("communityId")!=null){
			communityid = Integer.parseInt(ServletActionContext.getRequest().getParameter("communityId").toString());
		}
		System.out.println(communityid);
		System.out.println("…………………………………………");
		findCommunity(communityid);
		System.out.println(communityid);
		System.out.println(currentCommunity.getCommunityName());
		
		topic();
//		try{
		/*AccountHelper helper = AccountHelper.INSTANCE;
			itemlist = helper.selectTopicsByCommunityId(communityId);//ItemHibDao.select(communityId);
			if(itemlist.size()!=0){
				System.out.println(itemlist.get(0).getTpTitle());
				}*/
//		}catch(Exception e){
//			e.printStackTrace();
//		}
		try{
			memberlist = MemHibDao.selectbyC(communityid);
			System.out.println(memberlist.get(0).getUserId());
			System.out.println("Success in getting members!");
		}catch(Exception e){
			e.printStackTrace();
		}
		userList.clear();
		for(int i = 0; i < memberlist.size(); ++i){
			User user = UserHibDao.getuser(memberlist.get(i).getUserId());
			System.out.println(user.getUsername());
			try{
				userList.add(user);
				//System.out.println(userList.get(0).getUsername());
			}catch(Exception e){
				e.printStackTrace();
			}
			//System.out.println(userList.get(0).getUsername());
		}
		System.out.println("Success in getting users!");
		//System.out.println(userList.size());
		//System.out.println(itemlist.get(0).getItemName());
		//System.out.println(itemlist.get(1).getItemName());
		//System.out.println(itemlist.get(2).getItemName());
		//findItem(itemId);
		
		//用户消息（非登陆用户：显示登录；登录用户，判断是否是owner，是的话返回查看社区消息，
		//否的话若以发出申请，返回等待批准，否则返回申请）
		try{
			//报错，nullpointer。。。。MsgConfirm报错
			msgconfirm = MsgConfirm.confirm(currentCommunity.getOwnerId(), currentCommunity.getCommunityId());
			System.out.println(msgconfirm);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		if(ServletActionContext.getRequest().getParameter("page")!=null){
			setPager();
		}else{
			cuP=1;
			beginItem = 0;
			endItem = beginItem+4;//4
			maxItem = topics.size()-1;
			if(endItem>=maxItem+1){
				endItem = maxItem;
			}
		}
		
		return "success";
	}
	
	/**@author bjrara*/
	private HttpServletRequest request;
	public static final String FAILURE = "failure";
	private CommunityItem communityItem = new CommunityItem();
	private List<CommunityItem> topics;
	private Topicinfo topicinfo;

	private void topic() {
		request = ServletActionContext.getRequest();
		String s_communityId = request.getParameter("communityId");
		AccountHelper helper = AccountHelper.INSTANCE;
		communityid = Integer.parseInt(s_communityId);
		topics = helper.selectTopicsByCommunityId(communityid);
		Collections.reverse(topics);
		for (int i = 0; i < topics.size(); i++) {
			CommunityItem topic = topics.get(i);
			topicinfo = helper.selectTopicinfoByTopicId(topic.getTopicId()).get(0);
			topic.setTopicinfo(topicinfo);
		}
	}
	
	

	public CommunityItem getCommunityItem() {
		return communityItem;
	}

	public void setCommunityItem(CommunityItem communityItem) {
		this.communityItem = communityItem;
	}

	public List<CommunityItem> getTopics() {
		return topics;
	}

	public void setTopics(List<CommunityItem> topics) {
		this.topics = topics;
	}
	
	public Topicinfo getTopicinfo() {
		return topicinfo;
	}

	public void setTopicinfo(Topicinfo topicinfo) {
		this.topicinfo = topicinfo;
	}
}

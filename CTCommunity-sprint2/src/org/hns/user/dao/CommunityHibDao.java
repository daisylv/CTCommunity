package org.hns.user.dao;

import java.util.Iterator;
import java.util.List;

import javax.management.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hns.bean.Community;
import org.hns.plugin.HibernateUtil;

public class CommunityHibDao {
	
	private List<Community>communitylist;
	
	//private Community community;
	
	public static void insert(Community community){
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.save(community);
			tx.commit();
		}catch(RuntimeException e){
			if(tx != null)tx.rollback();
			throw e;
		}finally{
			session.close();
		}
	}



}

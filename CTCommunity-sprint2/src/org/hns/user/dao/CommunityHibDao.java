package org.hns.user.dao;

import java.util.Iterator;
import java.util.List;

import javax.management.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hns.bean.Community;
import org.hns.plugin.HibernateUtil;

public class CommunityHibDao {
	
	//private List<Community>communitylist;
	//private Community community;
	
	
	
	public static void select(String type){
		Session session = HibernateUtil.getSession();
		try{
			org.hibernate.Query query = session.createQuery("from Community c where c.communityType=?");
			((org.hibernate.Query)query).setString(0, type);
			List<Community> community = ((org.hibernate.Query) query).list();
			
		}catch(RuntimeException e){
			e.printStackTrace();
		}finally{
			session.close();
		}
	}
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

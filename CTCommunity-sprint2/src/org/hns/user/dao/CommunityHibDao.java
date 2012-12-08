package org.hns.user.dao;

import java.util.Iterator;
import java.util.List;

import javax.management.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hns.bean.Community;
import org.hns.plugin.HibernateUtil;

public class CommunityHibDao {
	
	public static List<Community>communitylist;
	//private Community community;
	
	
	public static List<Community> select(){
		//HibernateUtil.createSeesionFactory();
		Session session = HibernateUtil.getSession();
		try{
			org.hibernate.Query query = session.createQuery("from Community c");
			//((org.hibernate.Query)query).setString(0, type);
			communitylist = ((org.hibernate.Query) query).list();
			//return communitylist;
		}catch(RuntimeException e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return communitylist;
		
	}
	public static void insert(Community community){
		//HibernateUtil.createSeesionFactory();
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

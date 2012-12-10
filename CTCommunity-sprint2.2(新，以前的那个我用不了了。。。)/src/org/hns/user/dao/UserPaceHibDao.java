package org.hns.user.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hns.bean.UserPace;
import org.hns.plugin.HibernateUtil;

public class UserPaceHibDao {
	
	private static List<UserPace>userpacelist;
	
	public static void insert(UserPace userpace){
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.save(userpace);
			tx.commit();
		}catch(RuntimeException e){
			if(tx!=null)tx.rollback();
			throw e;
		}finally{
			session.close();
		}
	}
	
	public static void update(UserPace userpace){
		HibernateUtil.createSeesionFactory();
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.update(userpace);
		}catch(RuntimeException e){
			if(tx != null)tx.rollback();
			throw e;
		}finally{
			session.close();
		}
	}
	
	public static List<UserPace> selectPaces(int userid){
		Session session = HibernateUtil.getSession();
		try{
			org.hibernate.Query query = session.createQuery("from UserPace up where up.userId=?");
			((org.hibernate.Query) query).setInteger(0, userid);
			userpacelist = ((org.hibernate.Query) query).list();
		}catch(RuntimeException e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return userpacelist;
	}
}

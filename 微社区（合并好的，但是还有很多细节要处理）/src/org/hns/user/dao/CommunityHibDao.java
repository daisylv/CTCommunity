package org.hns.user.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hns.bean.Community;
import org.hns.bean.User;
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
	
	public static void delete(Integer id){
		//HibernateUtil.createSeesionFactory();
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		
		try{
			tx = session.beginTransaction();
			Community community = (Community)session.get(Community.class, id);
			session.delete(community);
			tx.commit();
		}catch(RuntimeException e){
			if(tx != null)tx.rollback();
			throw e;
		}finally{
			session.close();
		}
	}
	
	public static List<Community> search(String searchcontent){
		Session session = HibernateUtil.getSession();
		//Transaction tx = null;
		try{
			org.hibernate.Query query = session.createQuery("from Community c where c.communityName like '%"+searchcontent+"%'");
			List<Community> userlist = ((org.hibernate.Query) query).list();
			if(userlist == null || 0 == userlist.size()){
				return null;//无合适的结果
			}
			//Iterator<Community> it = userlist.iterator();
			//Community community = it.next();
			return userlist;
		}catch(RuntimeException e){
			e.printStackTrace();
			return null;
		}finally{
			session.close();
		}
		
	}
	
	/*public static void insert(UserOwned userOwned){
		//HibernateUtil.createSeesionFactory();
		
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.save(userOwned);
			tx.commit();
		}catch(RuntimeException e){
			if(tx != null)tx.rollback();
			throw e;
		}finally{
			session.close();
		}

	}*/

}

package org.hns.user.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hns.bean.MsgList;
import org.hns.plugin.HibernateUtil;

import java.util.Iterator;
import java.util.List;


public class MsgHibDao {
	
	private static MsgList msg; 
	private static List<MsgList> msglist;
	
	public static void insert(MsgList msg){
		//HibernateUtil.createSeesionFactory();
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.save(msg);
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
			msg = (MsgList)session.get(MsgList.class, id);
			session.delete(msg);
			tx.commit();
		}catch(RuntimeException e){
			if(tx != null)tx.rollback();
			throw e;
		}finally{
			session.close();
		}
	}
	
	public static List<MsgList> selectbySender (int senderId){
		Session session = HibernateUtil.getSession();
		try{
			org.hibernate.Query query = session.createQuery("from MsgList m where m.senderId=?");
			((org.hibernate.Query) query).setInteger(0, senderId);
			msglist = ((org.hibernate.Query) query).list();
		}catch(RuntimeException e){
			e.printStackTrace();
		}finally{
		session.close();
		}
		return msglist;
	}
	
	public static List<MsgList> selectbyreceiverId (int receiverId){
		Session session = HibernateUtil.getSession();
		try{
			org.hibernate.Query query = session.createQuery("from MsgList m where m.receiverId=?");
			((org.hibernate.Query) query).setInteger(0, receiverId);
			msglist = ((org.hibernate.Query) query).list();
		}catch(RuntimeException e){
			e.printStackTrace();
		}finally{
		session.close();
		}
		return msglist;
	}
	
	public static MsgList select (int receiverId, int senderId){
		Session session = HibernateUtil.getSession();
		try{
			org.hibernate.Query query = session.createQuery(
					"from MsgList m where m.receiverId=? and " +
					"m.senderId=?");
			((org.hibernate.Query) query).setInteger(0, receiverId);
			((org.hibernate.Query) query).setInteger(1, senderId);
			msglist = ((org.hibernate.Query) query).list();
			Iterator<MsgList> it = msglist.iterator();
			MsgList msg = it.next();
			return msg;
		}catch(RuntimeException e){
			e.printStackTrace();
			return null;
		}finally{
		session.close();
		}
	}
}

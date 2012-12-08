package org.hns.user.dao;

import java.util.Iterator;
import java.util.List;

import javax.management.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hns.bean.Community;
import org.hns.bean.Item;
import org.hns.plugin.HibernateUtil;

public class ItemHibDao {
	
	private static List<Item>itemlist;
	

	
	public static void insert(Item item){
		//HibernateUtil.createSeesionFactory();
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.save(item);
			tx.commit();
		}catch(RuntimeException e){
			if(tx != null)tx.rollback();
			throw e;
		}finally{
			session.close();
		}
	}

	public static List<Item> select(int communityId){
		//HibernateUtil.createSeesionFactory();
		Session session = HibernateUtil.getSession();
		try{
			org.hibernate.Query query = session.createQuery("from Item i where i.communityId=?");
			((org.hibernate.Query) query).setInteger(0, communityId);
			itemlist = ((org.hibernate.Query) query).list();
			//return communitylist;
		}catch(RuntimeException e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return itemlist;
	}
}

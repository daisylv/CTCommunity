package org.hns.user.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hns.plugin.HibernateUtil;
import org.hns.user.User;

public class UserHibDao {

		private List<User>userlist;
		private User user;
		
		public void delete(Integer id){
			Session session = HibernateUtil.getSession();
			Transaction tx = null;
			
			try{
				tx = session.beginTransaction();
				user = (User)session.get(User.class, id);
				session.delete(user);
				tx.commit();
			}catch(RuntimeException e){
				if(tx != null)tx.rollback();
				throw e;
			}finally{
				session.close();
			}
		}
		
		public static void insert(User user){
			Session session = HibernateUtil.getSession();
			Transaction tx = null;
			try{
				tx = session.beginTransaction();
				session.save(user);
				tx.commit();
			}catch(RuntimeException e){
				if(tx != null)tx.rollback();
				throw e;
			}finally{
				session.close();
			}
		}
		
		public void update(User user){
			Session session = HibernateUtil.getSession();
			Transaction tx = null;
			try{
				tx = session.beginTransaction();
				session.update(user);
			}catch(RuntimeException e){
				if(tx != null)tx.rollback();
				throw e;
			}finally{
				session.close();
			}
		}
}

package org.hns.user.dao;

import java.util.Iterator;
import java.util.List;

import javax.management.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hns.bean.User;
import org.hns.plugin.HibernateUtil;

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
		
		public static void update(User user){
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
		
		public static int finduser(String username, String password){
			Session session = HibernateUtil.getSession();
			//Transaction tx = null;
			try{
				Query query = (Query) session.createQuery("from User u where " +
						"u.username = ?");
				((org.hibernate.Query) query).setString(0, username);
				List<User> userlist = ((org.hibernate.Query) query).list();
				if(null == userlist || 0 == userlist.size()){
					return -1;//用户名不存在
				}
				
				Query query2 = (Query) session.createQuery("from User u where " +
						"u.username = ? and u.password = ?");
				((org.hibernate.Query) query).setString(0, username);
				((org.hibernate.Query) query).setString(1, password);
				List<User> userlist2 = ((org.hibernate.Query) query).list();
				if(null == userlist2){
					return -2;//密码不正确
				}
				
				Iterator<User> it = userlist2.iterator();
				User user = it.next();
				return user.getUserId();
			}catch(RuntimeException e){
				e.printStackTrace();
				return 0;
			}finally{
				session.close();
			}
			
		}
}

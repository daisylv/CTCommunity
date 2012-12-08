package org.hns.user.dao;

import java.util.Iterator;
import java.util.List;

import javax.management.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hns.bean.User;
import org.hns.plugin.HibernateUtil;

import communityDB.Userinfo;

public class UserHibDao {

		private List<User>userlist;
		private User user;
		
		public void delete(Integer id){
			//HibernateUtil.createSeesionFactory();
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
			//HibernateUtil.createSeesionFactory();
			Session session = HibernateUtil.getSession();
			Transaction tx = null;
			System.out.println("1111");
			try{

				tx = session.beginTransaction();
				session.save(user);
				System.out.println("2222");
				//session.flush();
				//System.out.println(user.getUserId());
				tx.commit();
				System.out.println("3333");
			}
			catch(RuntimeException e){
				System.out.println(e.toString());
				if(tx != null)tx.rollback();
				throw e;
			}finally{
				session.close();
			}
		}
		
		public static void update(User user){
			HibernateUtil.createSeesionFactory();
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
				org.hibernate.Query query = session.createQuery("from User u where u.username=?");
				((org.hibernate.Query) query).setString(0, username);
				List<User> userlist = ((org.hibernate.Query) query).list();
				if(userlist == null || 0 == userlist.size()){
					return -1;//用户名不存在
				}
				
				org.hibernate.Query query2 = session.createQuery("from User u where u.username=? and " +
						"u.password=?");
				((org.hibernate.Query) query2).setString(0, username);
				((org.hibernate.Query) query2).setString(1, password);
				List<User> userlist2 = ((org.hibernate.Query) query2).list();
				if(userlist2.size()==0){
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
		
		public static String findUserbyWeibo(String weiboid){
			Session session = HibernateUtil.getSession();
			try{
				org.hibernate.Query query = session.createQuery("from Userinfo u where u.weiboId=?");
				((org.hibernate.Query) query).setString(0, weiboid);
				List<Userinfo>weiboinfoList = ((org.hibernate.Query) query).list();
				if(weiboinfoList == null || 0 == weiboinfoList.size()){
					return "nonuser";//用户名不存在
				}
				Iterator<Userinfo> it = weiboinfoList.iterator();
				Userinfo weiboinfo = it.next();
				int userid = weiboinfo.getUserId();
				try{
					org.hibernate.Query query2 = session.createQuery("from User u where u.userId=?");
					((org.hibernate.Query) query2).setLong(0, userid);
					List<User> userlist = ((org.hibernate.Query) query2).list();
					if(userlist.size()==0){
						return "registe";
					}
					Iterator<User> it2 = userlist.iterator();
					User user = it2.next();
					return "success";
				}catch(RuntimeException e){
					e.printStackTrace();
					return "error";
				}
				//return weiboinfo.getWeiboId();
			}catch(RuntimeException e){
				e.printStackTrace();
				return "error";
			}finally{
				session.close();
			}
		}
}

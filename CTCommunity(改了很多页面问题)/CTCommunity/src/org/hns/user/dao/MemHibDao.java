package org.hns.user.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hns.bean.CommunityMember;
import org.hns.plugin.HibernateUtil;

public class MemHibDao {
	
	public static List<CommunityMember> memberlist;
	
	public static void insert(CommunityMember communitymember){
		Session session = HibernateUtil.getSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			session.save(communitymember);
			tx.commit();
		}catch(RuntimeException e){
			if(tx!=null)tx.rollback();
			throw e;
		}finally{
			session.close();
		}
	}
	
	public static List<CommunityMember> selectbyU(int userId){
		Session session = HibernateUtil.getSession();
		try{
			org.hibernate.Query query = session.createQuery("from CommunityMember cm where cm.userId=?");
			((org.hibernate.Query) query).setInteger(0, userId);
			memberlist = ((org.hibernate.Query) query).list();
			//return memberlist;
		}catch(RuntimeException e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return memberlist;
	}
	public static List<CommunityMember> selectbyC(int communityId){
		Session session = HibernateUtil.getSession();
		try{
			org.hibernate.Query query = session.createQuery("from CommunityMember cm where cm.communityId=?");
			((org.hibernate.Query) query).setInteger(0, communityId);
			memberlist = ((org.hibernate.Query) query).list();
			//return memberlist;
		}catch(RuntimeException e){
			e.printStackTrace();
		}finally{
			session.close();
		}
		return memberlist;
	}
}

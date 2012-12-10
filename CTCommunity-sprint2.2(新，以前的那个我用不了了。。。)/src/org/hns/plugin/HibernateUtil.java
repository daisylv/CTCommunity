package org.hns.plugin;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//import freemarker.template.Configuration;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	
	public static void createSeesionFactory(){
		sessionFactory = new Configuration().configure().buildSessionFactory();
	}
	
	public static Session getSession(){
		return sessionFactory.openSession();
	}
}

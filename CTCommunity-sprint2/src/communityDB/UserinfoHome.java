package communityDB;

// Generated 2012-11-21 15:26:38 by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Userinfo.
 * 
 * @see Userinfo
 * @author Hibernate Tools 
 * @author bjrara
 */
public class UserinfoHome {

	private static final Log log = LogFactory.getLog(UserinfoHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new Configuration().configure().buildSessionFactory();
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Userinfo transientInstance) {
		log.debug("persisting Userinfo instance");
		try {
			Transaction transaction = this.sessionFactory.getCurrentSession().beginTransaction();
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
			transaction.commit();
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Userinfo instance) {
		log.debug("attaching dirty Userinfo instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Userinfo instance) {
		log.debug("attaching clean Userinfo instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Userinfo persistentInstance) {
		log.debug("deleting Userinfo instance");
		try {
			Transaction transaction = this.sessionFactory.getCurrentSession().beginTransaction();
			log.debug("delete successful");
			transaction.commit();
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Userinfo merge(Userinfo detachedInstance) {
		log.debug("merging Userinfo instance");
		try {
			Transaction transaction = this.sessionFactory.getCurrentSession().beginTransaction();
			Userinfo result = (Userinfo) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			transaction.commit();
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Userinfo findById(java.lang.Integer id) {
		log.debug("getting Userinfo instance with id: " + id);
		try {
			Userinfo instance = (Userinfo) sessionFactory.getCurrentSession()
					.get("Userinfo", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Userinfo> findByExample(Userinfo instance) {
		log.debug("finding Userinfo instance by example");
		try {
			List<Userinfo> results = (List<Userinfo>) sessionFactory
					.getCurrentSession().createCriteria("Userinfo")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		Transaction transaction = this.sessionFactory.getCurrentSession().beginTransaction();
		log.debug("finding Usertable instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Userinfo as model where model."
					+ propertyName + "= ?";
			Query queryObject = sessionFactory.getCurrentSession().createQuery(
					queryString);
			queryObject.setParameter(0, value);
			List li = queryObject.list();
			transaction.commit();
			return li;
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List<Userinfo> findByWeiboId(Object weiboId){
		return findByProperty("weiboId", weiboId);
	} 
	
	public void modifyAccessToken(java.lang.Integer id, String accessToken){
		Transaction transaction = this.sessionFactory.getCurrentSession().beginTransaction();
		Session sess = sessionFactory.getCurrentSession();
		Userinfo userinfo = (Userinfo) sess.load(Userinfo.class, id);
		userinfo.setAccessToken(accessToken);
		sess.flush();
		transaction.commit();
	}
}

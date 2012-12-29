package communityDB;

// Generated 2012-12-27 22:23:43 by Hibernate Tools 3.4.0.CR1

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;

/**
 * Home object for domain model class Notice.
 * 
 * @see communityDB.Notice
 * @author Hibernate Tools
 * @author bjrara
 */
public class NoticeHome {

	private static final Log log = LogFactory.getLog(NoticeHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new Configuration().configure()
					.buildSessionFactory();
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException(
					"Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Notice transientInstance) {
		log.debug("persisting Notice instance");
		try {
			Transaction transaction = this.sessionFactory.getCurrentSession()
					.beginTransaction();
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
			transaction.commit();
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Notice instance) {
		log.debug("attaching dirty Notice instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Notice instance) {
		log.debug("attaching clean Notice instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Notice persistentInstance) {
		log.debug("deleting Notice instance");
		try {
			Transaction transaction = this.sessionFactory.getCurrentSession()
					.beginTransaction();
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
			transaction.commit();
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Notice merge(Notice detachedInstance) {
		log.debug("merging Notice instance");
		try {
			Transaction transaction = this.sessionFactory.getCurrentSession()
					.beginTransaction();
			Notice result = (Notice) sessionFactory.getCurrentSession().merge(
					detachedInstance);
			transaction.commit();
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Notice findById(java.lang.Integer id) {
		log.debug("getting Notice instance with id: " + id);
		try {
			Transaction transaction = this.sessionFactory.getCurrentSession()
					.beginTransaction();
			Notice instance = (Notice) sessionFactory.getCurrentSession().get(
					"communityDB.Notice", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			transaction.commit();
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Notice instance) {
		log.debug("finding Notice instance by example");
		try {
			Transaction transaction = this.sessionFactory.getCurrentSession()
					.beginTransaction();
			List results = sessionFactory.getCurrentSession()
					.createCriteria("communityDB.Notice")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			transaction.commit();
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findUncheckedNotices(Integer userId) {
		Transaction transaction = this.sessionFactory.getCurrentSession().beginTransaction();
		log.debug("finding Usertable instance with property: toUserId: " + userId
				+ ", noticed: 1");
		try {
			String queryString = "from Notice as model where model.toUserId= ? and model.noticed= ?";
			Query queryObject = sessionFactory.getCurrentSession().createQuery(
					queryString);
			queryObject.setParameter(0, userId);
			queryObject.setParameter(1, 1);
			List li = queryObject.list();
			transaction.commit();
			return li;
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
}

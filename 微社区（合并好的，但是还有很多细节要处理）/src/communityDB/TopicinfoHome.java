package communityDB;

// Generated 2012-12-25 19:42:31 by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;

/**
 * Home object for domain model class Topicinfo.
 * @see Topicinfo
 * @author Hibernate Tools
 * @author bjrara 
 */
public class TopicinfoHome {

	private static final Log log = LogFactory.getLog(TopicinfoHome.class);

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

	public void persist(Topicinfo transientInstance) {
		log.debug("persisting Topicinfo instance");
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

	public void attachDirty(Topicinfo instance) {
		log.debug("attaching dirty Topicinfo instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Topicinfo instance) {
		log.debug("attaching clean Topicinfo instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Topicinfo persistentInstance) {
		log.debug("deleting Topicinfo instance");
		try {
			Transaction transaction = this.sessionFactory.getCurrentSession().beginTransaction();
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
			transaction.commit();
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Topicinfo merge(Topicinfo detachedInstance) {
		log.debug("merging Topicinfo instance");
		try {
			Transaction transaction = this.sessionFactory.getCurrentSession().beginTransaction();
			Topicinfo result = (Topicinfo) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			transaction.commit();
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Topicinfo findById(int id) {
		log.debug("getting Topicinfo instance with id: " + id);
		try {
			Transaction transaction = this.sessionFactory.getCurrentSession().beginTransaction();
			Topicinfo instance = (Topicinfo) sessionFactory.getCurrentSession()
					.get("Topicinfo", id);
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

	public List findByExample(Topicinfo instance) {
		log.debug("finding Topicinfo instance by example");
		try {
			Transaction transaction = this.sessionFactory.getCurrentSession().beginTransaction();
			List results = sessionFactory.getCurrentSession()
					.createCriteria("Topicinfo")
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
	
	public List findByProperty(String propertyName, Object value) {
		Transaction transaction = this.sessionFactory.getCurrentSession().beginTransaction();
		log.debug("finding Usertable instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Topicinfo as model where model."
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
	
	public List<Topicinfo> findByTopicId(Object topicId) {
		return findByProperty("topicId", topicId);
	}
}

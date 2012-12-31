package communityDB;

// Generated 2012-12-11 20:26:53 by Hibernate Tools 3.4.0.CR1

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;

/**
 * Home object for domain model class Itemreply.
 * 
 * @see db.Itemreply
 * @author Hibernate Tools
 * @author bjrara
 */
public class ItemreplyHome {

	private static final Log log = LogFactory.getLog(ItemreplyHome.class);

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

	public void persist(Itemreply transientInstance) {
		log.debug("persisting Itemreply instance");
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

	public void attachDirty(Itemreply instance) {
		log.debug("attaching dirty Itemreply instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Itemreply instance) {
		log.debug("attaching clean Itemreply instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Itemreply persistentInstance) {
		log.debug("deleting Itemreply instance");
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

	public Itemreply merge(Itemreply detachedInstance) {
		log.debug("merging Itemreply instance");
		try {
			Transaction transaction = this.sessionFactory.getCurrentSession()
					.beginTransaction();
			Itemreply result = (Itemreply) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			transaction.commit();
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Itemreply findById(java.lang.Integer id) {
		log.debug("getting Itemreply instance with id: " + id);
		try {
			Transaction transaction = this.sessionFactory.getCurrentSession()
					.beginTransaction();
			Itemreply instance = (Itemreply) sessionFactory.getCurrentSession()
					.get("communityDB.Itemreply", id);
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

	public List findByExample(Itemreply instance) {
		log.debug("finding Itemreply instance by example");
		try {
			List results = sessionFactory.getCurrentSession()
					.createCriteria("communityDB.Itemreply")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		Transaction transaction = this.sessionFactory.getCurrentSession()
				.beginTransaction();
		log.debug("finding Usertable instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Itemreply as model where model."
					+ propertyName + "= ?";
			Query queryObject = sessionFactory.getCurrentSession().createQuery(
					queryString);
			queryObject.setParameter(0, value);
			List li = queryObject.list();
			System.out.print(li);
			transaction.commit();
			return li;
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Itemreply> findByTopicId(Object topicId) {
		return findByProperty("topicId", topicId);
	}
}

package communityDB;
// Generated 2012-11-24 17:26:44 by Hibernate Tools 3.4.0.CR1

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class CommunityItem.
 * @see .CommunityItem
 * @author Hibernate Tools
 * @author bjrara
 */
public class CommunityItemHome {

	private static final Log log = LogFactory.getLog(CommunityItemHome.class);

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

	public void persist(CommunityItem transientInstance) {
		log.debug("persisting CommunityItem instance");
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
	
	public Integer save(CommunityItem transientInstance) {
		log.debug("saving CommunityItem instance");
		try {
			Transaction transaction = this.sessionFactory.getCurrentSession().beginTransaction();
			Integer generatedId = (Integer) sessionFactory.getCurrentSession().save(transientInstance);
			log.debug("save successful");
			transaction.commit();
			return generatedId;
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void attachDirty(CommunityItem instance) {
		log.debug("attaching dirty CommunityItem instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CommunityItem instance) {
		log.debug("attaching clean CommunityItem instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(CommunityItem persistentInstance) {
		log.debug("deleting CommunityItem instance");
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

	public CommunityItem merge(CommunityItem detachedInstance) {
		log.debug("merging CommunityItem instance");
		try {
			Transaction transaction = this.sessionFactory.getCurrentSession().beginTransaction();
			CommunityItem result = (CommunityItem) sessionFactory.getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			transaction.commit();
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public CommunityItem findById(java.lang.Integer id) {
		log.debug("getting CommunityItem instance with id: " + id);
		try {
			Transaction transaction = this.sessionFactory.getCurrentSession().beginTransaction();
			CommunityItem instance = (CommunityItem) sessionFactory.getCurrentSession().get(
					"communityDB.CommunityItem", id);
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

	public List<CommunityItem> findByExample(CommunityItem instance) {
		log.debug("finding CommunityItem instance by example");
		try {
			List<CommunityItem> results = (List<CommunityItem>) sessionFactory
					.getCurrentSession().createCriteria("communityDB.CommunityItem")
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
			String queryString = "from CommunityItem as model where model."
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
	
	public List<CommunityItem> findByCommunityId(Object communityId){
		return findByProperty("communityId", communityId);
	}
	
}

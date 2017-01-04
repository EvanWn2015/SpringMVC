package idv.evan.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public abstract class AbstractDao extends HibernateDaoSupport {

	@Autowired
	SessionFactory sessionFactory;

	protected Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	public Transaction getTransaction() {
		return getSession().beginTransaction();
	}

	public <T> Serializable create(final T entity) {
		return getSession().save(entity);
	}

	public <T> T update(final T entity) {
		getSession().update(entity);
		return entity;
	}

	public <T> void delete(final T entity) {
		getSession().delete(entity);
	}

	public <T> void delete(Serializable id, Class<T> entityClass) {
		T entity = fetchById(id, entityClass);
		delete(entity);
	}

	@SuppressWarnings("unchecked")
	public <T> List<T> fetchAll(Class<T> entityClass) {
		return getSession().createQuery(" FROM " + entityClass.getName()).list();
	}

	@SuppressWarnings("rawtypes")
	public <T> List fetchAll(String query) {
		return getSession().createSQLQuery(query).list();
	}

	@SuppressWarnings("unchecked")
	public <T> T fetchById(Serializable id, Class<T> entityClass) {
		return (T) getSession().get(entityClass, id);
	}

}

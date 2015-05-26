package org.stuff.ejb.hibernate;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public abstract class HibernateDAOImpl<T, ID extends Serializable> implements GenericDAO<T, ID> {

	protected SessionFactory sessionFactory;
	
	
	@SuppressWarnings("unchecked")
	@Override
	public T findById(ID id) {
		return (T) getCurrentSession().get(this.getClass(), id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		return (List<T>) getCurrentSession().createQuery("from " + this.getClass().getName()).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByExample(T exampleInstance) {
		return (List<T>) getCurrentSession().createQuery("from " + this.getClass().getName()).list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public ID insert(T entity) {
		return (ID) getCurrentSession().save(entity);
	}

	@Override
	public void update(T entity) {
		getCurrentSession().update(entity);
		
	}

	@Override
	public void delete(T entity) {
		getCurrentSession().delete(entity);
		
	}

	@Override
	public void deleteById(ID id) {
		getCurrentSession().delete(findById(id));
		
	}

	public void find() {
		
	}
	
	protected Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	
}

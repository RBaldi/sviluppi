package org.stuff.ejb.hibernate.dao;

import org.hibernate.SessionFactory;
import org.stuff.ejb.hibernate.HibernateDAOImpl;
import org.stuff.ejb.model.User;

public class UserDao extends HibernateDAOImpl<User, Integer> {
	
	/**
	 * Costruttore per utilizzare Spring per iniettare 
	 * la sessionfactory
	 * 
	 * 
	 * @param sessionFactory
	 */
	public UserDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}

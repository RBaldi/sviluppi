package org.stuff.ejb.hibernate;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T, ID extends Serializable> {

	/**
	 * Revover Object by id
	 * 
	 * 
	 * @param id object id
	 * @return Object to find, null if research fail
	 */
	T findById(ID id);
	
	List<T> findAll();
	
	List<T> findByExample(T exampleInstance);
	
	/**
	 * Insert a new object into db and return
	 * its instance within assigned ID
	 * 
	 * 
	 * @param entity to be persisted into db
	 * @return entity persisted within ID
	 */
	ID insert(T entity);
	
	
	/**
	 * Perform update for entity
	 * 
	 * 
	 * @param entity
	 */
	void update(T entity);
	
	/**
	 * Perform deletion for entity
	 * 
	 * 
	 * @param entity
	 */
	void delete(T entity);
	
	/**
	 * Perform a delete by passed id
	 * 
	 * 
	 * @param id
	 */
	void deleteById(ID id);
	
	
}

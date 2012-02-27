package br.com.andorm.persistence;

import java.util.List;

import br.com.andorm.persistence.tablemanager.TableManager;
import br.com.andorm.query.Criteria;

/**
 * 
 * @author jonatasdaniel
 * @since 04/03/2011
 * @version 0.1
 *
 */
public interface PersistenceManager {

	/**
	 * Open the database 
	 */
	void open();
	
	boolean isOpen();
	
	/**
	 * Close the database
	 */
	void close();
	
	long count(Class<?> of);
	
	long count(Criteria criteria);
	
	/**
	 * Save a entity in the database
	 * @param o Entity to save
	 * @throws AndOrmPersistenceException
	 */
	long save(Object o);
	
	/**
	 * Delete a entity in the database
	 * @param o Entity to delete
	 * @throws AndOrmPersistenceException
	 */
	void delete(Object o);
	
	/**
	 * update a entity in the database
	 * @param o Entity to update
	 * @throws AndOrmPersistenceException
	 */
	void update(Object o);
	
	/**
	 * Return a entity contained in the database, specified by the pk
	 * @param entityClass Class of the entity to search
	 * @param pk PK of entity to search
	 * @return If entity was founded, return the entity, else return <code>null</code>
	 */
	<T> T read(Class<T> entityClass, Object pk);
	
	<T> T first(Class<T> entityClass);
	
	<T> T last(Class<T> entityClass);
	
	public <T> List<T> find(Class<T> entityClass, Criteria query);
	
	public <T> List<T> find(Class<T> entityClass, String query);
	
	public <T> List<T> find(Class<T> entityClass, String query, Object... whereArgs);
	
	Transaction getTransaction();
	
	public TableManager getTableManager();
}
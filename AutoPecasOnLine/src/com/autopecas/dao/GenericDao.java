/**
 * 
 */
package com.autopecas.dao;

import java.io.Serializable;
import java.util.List;

/**
 * @author Everson Lisboa
 *
 */
public interface GenericDao<T, I extends Serializable>{
	
	public boolean save(T entity);
	public boolean update (T entity);
	public boolean remove (T entity);
	public T getById(Class<T> classe, I id);
}

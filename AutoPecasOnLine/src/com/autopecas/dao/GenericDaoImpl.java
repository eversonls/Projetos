/**
 * 
 */
package com.autopecas.dao;

import java.io.Serializable;
import java.util.List;

import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Everson Lisboa
 *
 */
public class GenericDaoImpl <T,I extends Serializable> implements GenericDao<T, I> {

	@Override
	public boolean save(T entity) {
		getManager().persist(entity);
		return true;
	}

	@Override
	public boolean update(T entity) {
		getManager().merge(entity);
		return true;
	}

	@Override
	public boolean remove(T entity) {
		getManager().remove(entity);
		return true;
	}

	@Override
	public T getById(Class<T> classe, I id) {
		
		try {
			return getManager().find(classe, id);
		} catch (NoResultException e) {
			return null;
		}
	}

	public EntityManager getManager(){
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		EntityManager manager = (EntityManager)request.getAttribute("manager");
		return manager;
	}

}

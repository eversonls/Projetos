/**
 * 
 */
package com.autopecas.dao;



/**
 * @author Everson Lisboa
 *
 */
public interface Dao {
	
	public boolean save(Object object);
	public boolean update(Object object);
	public boolean desativar (int codigo);
	public boolean ativar(int codigo);
	public boolean isValido(Object object);
	public Object find(int codigo);
}

/**
 * 
 */
package com.autopecas.repositorio;

import java.io.Serializable;
import java.util.List;

import com.autopecas.dao.GenericDaoImpl;
import com.autopecas.modelo.Estado;

/**
 * @author Everson Lisboa
 *
 */
public class RepositorioEstado extends GenericDaoImpl<Estado, Integer> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String msgConteudo;

	public RepositorioEstado() {
	}

	public Estado getEstado(int codigo){
		return getById(Estado.class, codigo);
	}
	
	@SuppressWarnings("unchecked")
	public List<Estado> getListaEstados(){
		List<Estado> estados = getManager().createNamedQuery("findAllEstado").getResultList();
		return estados;
	}
	
	public boolean isUnico( Estado estado){
		List<Estado> estados = this.getListaEstados();
		for (Estado e : estados) {
			if(e.equals(estado)){
				this.msgConteudo = "Esse Estado já Existe em Nossos Registros";
				return false;
			}
		}
		return true;
	}
	
	public boolean saveEstado(Estado estado){
		if(!this.isUnico(estado)){
			return false;
		}
		this.save(estado);
		return true;
	}
	
	public String getMsgConteudo() {
		return msgConteudo;
	}

	public void setMsgConteudo(String msgConteudo) {
		this.msgConteudo = msgConteudo;
	}

	
}

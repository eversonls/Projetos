/**
 * 
 */
package com.autopecas.repositorio;

import java.io.Serializable;
import java.util.List;

import com.autopecas.dao.GenericDaoImpl;
import com.autopecas.modelo.Cidade;
import com.autopecas.modelo.Estado;

/**
 * @author Everson Lisboa
 *
 */
public class RepositorioCidade extends GenericDaoImpl<Cidade, Integer> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String msgConteudo;

	public RepositorioCidade() {
	}

	public boolean isUnico(Cidade cidade){
		List<Cidade> cidades = this.getListaCidade();
		for (Cidade c : cidades) {
			if(c.equals(cidade)){
				this.msgConteudo = "Essa Cidade já Existe em Nossos Registros";
				return false;
			}
		}
		return true;
	}
	
	public boolean saveCidade(Cidade cidade){
		if(cidade.getNo_vchcidade().isEmpty()){
			this.msgConteudo = "Informe o Nome da Cidade";
			return false;
		}
		if(!this.isUnico(cidade)){
			return false;
		}
		save(cidade);
		this.msgConteudo = "Cidade Salva com Sucesso";
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public List<Cidade> getListaCidade(){
		List<Cidade> cidades = getManager().createNamedQuery("findAllCidade").getResultList();
		return cidades;
	}
	
	@SuppressWarnings("unchecked")
	public List<Cidade> getListaCidadeEstado(Estado estado){
		List<Cidade> cidades = getManager().createNamedQuery("findAllCidadeEstado")
				.setParameter("codigo", estado.getCd_intestado())
				.getResultList();
		return cidades;
	}
	
	public String getMsgConteudo() {
		return msgConteudo;
	}

	public void setMsgConteudo(String msgConteudo) {
		this.msgConteudo = msgConteudo;
	}
	
	

}

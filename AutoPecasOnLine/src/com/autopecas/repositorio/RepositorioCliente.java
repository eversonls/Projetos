/**
 * 
 */
package com.autopecas.repositorio;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import com.autopecas.dao.GenericDaoImpl;
import com.autopecas.modelo.Cliente;

/**
 * @author Everson Lisboa
 *
 */
public class RepositorioCliente extends GenericDaoImpl<Cliente, Integer>{
	
	private String msgConteudo = "Problema ao Cadastrar Cliente";
	private String msgDetalhe;
	
	public boolean regitrar(Cliente cliente) {
		if(!this.isValido(cliente)){
			return false;
		}
		
		if(!this.isUnico(cliente)){
			return false;
		}
		
		cliente.setIn_bitativo(1);
		cliente.setDt_dtmcliente(new Date());
		save(cliente);
		this.msgConteudo ="O Cliente "+ cliente.getPessoa().getJuridica().getNo_vchfantasia() + " Foi Registrado com sucesso";
		this.msgDetalhe = "";
		return true;
	}

	public boolean atualiza(Cliente cliente) {
		this.msgConteudo = "Problema ao Atualizar Cliente";

		if(!this.isValido(cliente)){
			return false;
		}
		
		if(!this.isUnico(cliente)){
			return false;
		}
		update(cliente);
		this.msgConteudo = "Cliente foi Atualizado com Sucesso";
		this.msgDetalhe = "";
		return true;
	}


	public boolean isUnico(Cliente cliente) {
		for (Cliente c : this.getListaCliente()) {
			if(c.equals(cliente)){
				this.msgDetalhe = "Esse Cliente já Existe em nosso Registro!!";
				return false;
			}
		}
			return true;
	}

	public boolean isValido(Cliente cliente) {

		if(cliente.getPessoa().getJuridica().getNo_vchfantasia().isEmpty()){
			this.msgDetalhe = "Infome o Nome Fantasia";
			return false;
		}
		
		if(cliente.getPessoa().getJuridica().getNo_vchrazao_social().isEmpty()){
			this.msgDetalhe = "Informe a Razão Social";
			return false;
		}
		
		if(cliente.getPessoa().getJuridica().getIn_vchcnpj().isEmpty()){
			this.msgDetalhe = "Informe um CNPJ Valido";
			return false;
		}
		
		if(cliente.getPessoa().getJuridica().getIn_vchestadual().isEmpty()){
			this.msgDetalhe = "Informe a Inscrição Estadual";
			return false;
		}
		
		return true;
	}

	@SuppressWarnings("unchecked")
	public List<Cliente> getListaCliente(){
		Query query = getManager().createNamedQuery("findAllClientes");
		List<Cliente> clientes = query.getResultList();
		return clientes;
	}

	public String geraMatricula(){
		int codigo =0;
		for (int i = 0; i < this.getListaCliente().size(); i++) {
			codigo=this.getListaCliente().get(i).getCd_intcliente();
		}
		String mat="";
		if(codigo == 0){
			mat = "CLI-0001";
			return mat;
		}
		if(codigo >= 1 || codigo <= 9){
			mat = "CLI-000"+(codigo+1);
			return mat;
		}
		if(codigo >= 10 || codigo <= 99){
			mat = "CLI-00"+(codigo+1);
			return mat;
		}
		if(codigo == 100){
			mat = "CLI-0"+(codigo+1);
			return mat;
		}
		return null;
	}
	
	public String getMsgConteudo() {
		return msgConteudo;
	}
	
	public void setMsgConteudo(String msgConteudo) {
		this.msgConteudo = msgConteudo;
	}

	public String getMsgDetalhe() {
		return msgDetalhe;
	}

	public void setMsgDetalhe(String msgDetalhe) {
		this.msgDetalhe = msgDetalhe;
	}
	
}

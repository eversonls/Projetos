/**
 * 
 */
package com.autopecas.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Everson Lisboa
 *
 */
@Entity
@Table(name="tbl_endereco")
public class Endereco implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cd_intendereco;
	@OneToOne
	@JoinColumn(name="cd_intcliente")
	private Cliente cliente;
	
	@OneToOne
	@JoinColumn(name="cd_intestado")
	private Estado estado;
	
	@OneToOne
	@JoinColumn(name="cd_intcidade")
	private Cidade cidade;
	
	@OneToOne
	@JoinColumn(name="cd_intbairro")
	private Bairro bairro;
	
	@OneToOne
	@JoinColumn(name="cd_intlogradouro")
	private Logradouro logradouro;
	
	@Column(length = 9, nullable = false)
	private String in_vchcep;
	
	@Column(length = 100)
	private String ds_vchcomplemento;
	
	@Column(length = 10)
	private String nu_vchcasa;
	
	
	
	public Integer getCd_intendereco() {
		return cd_intendereco;
	}
	public void setCd_intendereco(Integer cd_intendereco) {
		this.cd_intendereco = cd_intendereco;
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	public Bairro getBairro() {
		return bairro;
	}
	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}
	public Logradouro getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(Logradouro logradouro) {
		this.logradouro = logradouro;
	}
	public String getIn_vchcep() {
		return in_vchcep;
	}
	public void setIn_vchcep(String in_vchcep) {
		this.in_vchcep = in_vchcep;
	}
	public String getDs_vchcomplemento() {
		return ds_vchcomplemento;
	}
	public void setDs_vchcomplemento(String ds_vchcomplemento) {
		this.ds_vchcomplemento = ds_vchcomplemento;
	}
	public String getNu_vchcasa() {
		return nu_vchcasa;
	}
	public void setNu_vchcasa(String nu_vchcasa) {
		this.nu_vchcasa = nu_vchcasa;
	}
	
	

}

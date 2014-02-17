/**
 * 
 */
package com.autopecas.modelo;

import java.io.Serializable;

import javax.persistence.CascadeType;
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
@Table(name="tbl_juridica")
public class Juridica implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Integer cd_intjuridica;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="cd_intpessoa")
	private Pessoa pessoa;
	
	private String no_vchrazao_social;
	private String no_vchfantasia;
	private String in_vchcnpj;
	private String in_vchestadual;
	
	public Integer getCd_intjuridica() {
		return cd_intjuridica;
	}
	public void setCd_intjuridica(Integer cd_intjuridica) {
		this.cd_intjuridica = cd_intjuridica;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public String getNo_vchrazao_social() {
		return no_vchrazao_social;
	}
	public void setNo_vchrazao_social(String no_vchrazao_social) {
		this.no_vchrazao_social = no_vchrazao_social;
	}
	public String getNo_vchfantasia() {
		return no_vchfantasia;
	}
	public void setNo_vchfantasia(String no_vchfantasia) {
		this.no_vchfantasia = no_vchfantasia;
	}
	public String getIn_vchcnpj() {
		return in_vchcnpj;
	}
	public void setIn_vchcnpj(String in_vchcnpj) {
		this.in_vchcnpj = in_vchcnpj;
	}
	public String getIn_vchestadual() {
		return in_vchestadual;
	}
	public void setIn_vchestadual(String in_vchestadual) {
		this.in_vchestadual = in_vchestadual;
	}
	
	
}

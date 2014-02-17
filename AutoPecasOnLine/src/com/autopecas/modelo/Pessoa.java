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
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Everson Lisboa
 *
 */
@Entity
@Table(name="tbl_pessoa")
public class Pessoa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cd_intpessoa;
	
	@OneToOne(mappedBy = "pessoa", cascade = CascadeType.ALL)
	private Juridica juridica;
	
	public int getCd_intpessoa() {
		return cd_intpessoa;
	}
	public void setCd_intpessoa(int cd_intpessoa) {
		this.cd_intpessoa = cd_intpessoa;
	}
	public Juridica getJuridica() {
		return juridica;
	}
	public void setJuridica(Juridica juridica) {
		this.juridica = juridica;
	}

	
}

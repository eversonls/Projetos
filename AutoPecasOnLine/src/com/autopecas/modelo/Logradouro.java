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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Everson Lisboa
 *
 */
@Entity
@Table(name="tbl_logradouro")
public class Logradouro implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cd_intlogradouro;
	
	@Column(length = 100, nullable = false, unique = true)
	private String no_vchlogradouro;
	
	@ManyToOne
	@JoinColumn(name="cd_intbairro")
	private Bairro bairro;

	@ManyToOne
	@JoinColumn(name="cd_inttipo_logradouro")
	private TipoLogradouro tipoLogradouro;
	
	public Integer getCd_intlogradouro() {
		return cd_intlogradouro;
	}

	public void setCd_intlogradouro(Integer cd_intlogradouro) {
		this.cd_intlogradouro = cd_intlogradouro;
	}

	public String getNo_vchlogradouro() {
		return no_vchlogradouro;
	}

	public void setNo_vchlogradouro(String no_vchlogradouro) {
		this.no_vchlogradouro = no_vchlogradouro;
	}

	public Bairro getBairro() {
		return bairro;
	}

	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bairro == null) ? 0 : bairro.hashCode());
		result = prime
				* result
				+ ((cd_intlogradouro == null) ? 0 : cd_intlogradouro.hashCode());
		result = prime
				* result
				+ ((no_vchlogradouro == null) ? 0 : no_vchlogradouro.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Logradouro)) {
			return false;
		}
		Logradouro other = (Logradouro) obj;
		if (bairro == null) {
			if (other.bairro != null) {
				return false;
			}
		} else if (!bairro.equals(other.bairro)) {
			return false;
		}
		if (cd_intlogradouro == null) {
			if (other.cd_intlogradouro != null) {
				return false;
			}
		} else if (!cd_intlogradouro.equals(other.cd_intlogradouro)) {
			return false;
		}
		if (no_vchlogradouro == null) {
			if (other.no_vchlogradouro != null) {
				return false;
			}
		} else if (!no_vchlogradouro.equals(other.no_vchlogradouro)) {
			return false;
		}
		return true;
	}

	
}

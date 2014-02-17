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
import javax.persistence.Table;

/**
 * @author Everson Lisboa
 *
 */
@Entity
@Table(name="tbl_tipo_logradouro")
public class TipoLogradouro implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cd_inttipo_logradouro;
	
	@Column(length = 50, unique = true, nullable = false)
	private String ds_vchtipo_logradouro;

	public Integer getCd_inttipo_logradouro() {
		return cd_inttipo_logradouro;
	}

	public void setCd_inttipo_logradouro(Integer cd_inttipo_logradouro) {
		this.cd_inttipo_logradouro = cd_inttipo_logradouro;
	}

	public String getDs_vchtipo_logradouro() {
		return ds_vchtipo_logradouro;
	}

	public void setDs_vchtipo_logradouro(String ds_vchtipo_logradouro) {
		this.ds_vchtipo_logradouro = ds_vchtipo_logradouro;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((cd_inttipo_logradouro == null) ? 0 : cd_inttipo_logradouro
						.hashCode());
		result = prime
				* result
				+ ((ds_vchtipo_logradouro == null) ? 0 : ds_vchtipo_logradouro
						.hashCode());
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
		if (!(obj instanceof TipoLogradouro)) {
			return false;
		}
		TipoLogradouro other = (TipoLogradouro) obj;
		if (cd_inttipo_logradouro == null) {
			if (other.cd_inttipo_logradouro != null) {
				return false;
			}
		} else if (!cd_inttipo_logradouro.equals(other.cd_inttipo_logradouro)) {
			return false;
		}
		if (ds_vchtipo_logradouro == null) {
			if (other.ds_vchtipo_logradouro != null) {
				return false;
			}
		} else if (!ds_vchtipo_logradouro.equals(other.ds_vchtipo_logradouro)) {
			return false;
		}
		return true;
	}
	
}

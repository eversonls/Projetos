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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author Everson Lisboa
 *
 */
@Entity
@Table(name="tbl_telefone")
@NamedQueries({
	@NamedQuery(name="findAllTelefone", query = "SELECT t FROM Telefone t")
})
public class Telefone implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cd_inttelefone;
	
	@Column(length = 6, nullable = false)
	private String in_vchtelefone;
	
	@Column(length = 14, nullable = false)
	private String nu_vchtelefone;
	
	private String ds_vchtipo_telefone;
	
	private String ch_chrtelefone;
	
	private String ds_vchoperadora;
	
	private int in_bitativo;
	
	public Integer getCd_inttelefone() {
		return cd_inttelefone;
	}
	public void setCd_inttelefone(Integer cd_inttelefone) {
		this.cd_inttelefone = cd_inttelefone;
	}
	public String getIn_vchtelefone() {
		return in_vchtelefone;
	}
	public void setIn_vchtelefone(String in_vchtelefone) {
		this.in_vchtelefone = in_vchtelefone;
	}
	public String getNu_vchtelefone() {
		return nu_vchtelefone;
	}
	public void setNu_vchtelefone(String nu_vchtelefone) {
		this.nu_vchtelefone = nu_vchtelefone;
	}
	public String getDs_vchtipo_telefone() {
		return ds_vchtipo_telefone;
	}
	public void setDs_vchtipo_telefone(String ds_vchtipo_telefone) {
		this.ds_vchtipo_telefone = ds_vchtipo_telefone;
	}
	
	public String getDs_vchoperadora() {
		return ds_vchoperadora;
	}
	public void setDs_vchoperadora(String ds_vchoperadora) {
		this.ds_vchoperadora = ds_vchoperadora;
	}
	public String getCh_chrtelefone() {
		return ch_chrtelefone;
	}
	public void setCh_chrtelefone(String ch_chrtelefone) {
		this.ch_chrtelefone = ch_chrtelefone;
	}
	public int getIn_bitativo() {
		return in_bitativo;
	}
	public void setIn_bitativo(int in_bitativo) {
		this.in_bitativo = in_bitativo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((cd_inttelefone == null) ? 0 : cd_inttelefone.hashCode());
		result = prime * result
				+ ((ch_chrtelefone == null) ? 0 : ch_chrtelefone.hashCode());
		result = prime * result
				+ ((ds_vchoperadora == null) ? 0 : ds_vchoperadora.hashCode());
		result = prime
				* result
				+ ((ds_vchtipo_telefone == null) ? 0 : ds_vchtipo_telefone
						.hashCode());
		result = prime * result + in_bitativo;
		result = prime * result
				+ ((in_vchtelefone == null) ? 0 : in_vchtelefone.hashCode());
		result = prime * result
				+ ((nu_vchtelefone == null) ? 0 : nu_vchtelefone.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Telefone other = (Telefone) obj;
		if (cd_inttelefone == null) {
			if (other.cd_inttelefone != null)
				return false;
		} else if (!cd_inttelefone.equals(other.cd_inttelefone))
			return false;
		if (ch_chrtelefone == null) {
			if (other.ch_chrtelefone != null)
				return false;
		} else if (!ch_chrtelefone.equals(other.ch_chrtelefone))
			return false;
		if (ds_vchoperadora == null) {
			if (other.ds_vchoperadora != null)
				return false;
		} else if (!ds_vchoperadora.equals(other.ds_vchoperadora))
			return false;
		if (ds_vchtipo_telefone == null) {
			if (other.ds_vchtipo_telefone != null)
				return false;
		} else if (!ds_vchtipo_telefone.equals(other.ds_vchtipo_telefone))
			return false;
		if (in_bitativo != other.in_bitativo)
			return false;
		if (in_vchtelefone == null) {
			if (other.in_vchtelefone != null)
				return false;
		} else if (!in_vchtelefone.equals(other.in_vchtelefone))
			return false;
		if (nu_vchtelefone == null) {
			if (other.nu_vchtelefone != null)
				return false;
		} else if (!nu_vchtelefone.equals(other.nu_vchtelefone))
			return false;
		return true;
	}
	
}

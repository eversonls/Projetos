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
@Table(name="tbl_email")
@NamedQueries({
	@NamedQuery(name="findAllEmail", query = "SELECT e FROM Email e")
})
public class Email implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cd_intemail;
	
	@Column(length = 7, nullable = false)
	private String in_vchemail;	
	@Column(length = 100, nullable = false, unique = true)
	private String ds_vchemail;
	@Column(length = 20, nullable = false)
	private String no_vchdominio;
	private int in_bitativo;
	
	public Integer getCd_intemail() {
		return cd_intemail;
	}
	public void setCd_intemail(Integer cd_intemail) {
		this.cd_intemail = cd_intemail;
	}
	public String getIn_vchemail() {
		return in_vchemail;
	}
	public void setIn_vchemail(String in_vchemail) {
		this.in_vchemail = in_vchemail;
	}
	public String getDs_vchemail() {
		return ds_vchemail;
	}
	public void setDs_vchemail(String ds_vchemail) {
		this.ds_vchemail = ds_vchemail;
	}
	public String getNo_vchdominio() {
		return no_vchdominio;
	}
	public void setNo_vchdominio(String no_vchdominio) {
		this.no_vchdominio = no_vchdominio;
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
				+ ((cd_intemail == null) ? 0 : cd_intemail.hashCode());
		result = prime * result
				+ ((ds_vchemail == null) ? 0 : ds_vchemail.hashCode());
		result = prime * result + in_bitativo;
		result = prime * result
				+ ((in_vchemail == null) ? 0 : in_vchemail.hashCode());
		result = prime * result
				+ ((no_vchdominio == null) ? 0 : no_vchdominio.hashCode());
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
		if (!(obj instanceof Email)) {
			return false;
		}
		Email other = (Email) obj;
		if (cd_intemail == null) {
			if (other.cd_intemail != null) {
				return false;
			}
		} else if (!cd_intemail.equals(other.cd_intemail)) {
			return false;
		}
		if (ds_vchemail == null) {
			if (other.ds_vchemail != null) {
				return false;
			}
		} else if (!ds_vchemail.equals(other.ds_vchemail)) {
			return false;
		}
		if (in_bitativo != other.in_bitativo) {
			return false;
		}
		if (in_vchemail == null) {
			if (other.in_vchemail != null) {
				return false;
			}
		} else if (!in_vchemail.equals(other.in_vchemail)) {
			return false;
		}
		if (no_vchdominio == null) {
			if (other.no_vchdominio != null) {
				return false;
			}
		} else if (!no_vchdominio.equals(other.no_vchdominio)) {
			return false;
		}
		return true;
	}
	
	

}

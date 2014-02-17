/**
 * 
 */
package com.autopecas.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Everson Lisboa
 *
 */
@Entity
@Table(name="tbl_estado")
@NamedQueries({
	@NamedQuery(name="findAllEstado", query ="SELECT e FROM Estado e")
})
public class Estado implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cd_intestado;
	
	@Column(length = 50, nullable = false, unique = true)
	private String no_vchestado;
	
	@Column(length = 3, nullable = false, unique = true)
	private String ch_chruf;
	
	@OneToMany(mappedBy = "estado", fetch =FetchType.LAZY)
	private List<Cidade> cidades;
	
	

	public Integer getCd_intestado() {
		return cd_intestado;
	}
	public void setCd_intestado(Integer cd_intestado) {
		this.cd_intestado = cd_intestado;
	}
	public String getNo_vchestado() {
		return no_vchestado;
	}
	public void setNo_vchestado(String no_vchestado) {
		this.no_vchestado = no_vchestado;
	}
	public String getCh_chruf() {
		return ch_chruf;
	}
	public void setCh_chruf(String ch_chruf) {
		this.ch_chruf = ch_chruf;
	}
	public List<Cidade> getCidades() {
		return cidades;
	}
	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((cd_intestado == null) ? 0 : cd_intestado.hashCode());
		result = prime * result
				+ ((ch_chruf == null) ? 0 : ch_chruf.hashCode());
		result = prime * result
				+ ((no_vchestado == null) ? 0 : no_vchestado.hashCode());
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
		if (!(obj instanceof Estado)) {
			return false;
		}
		Estado other = (Estado) obj;
		if (cd_intestado == null) {
			if (other.cd_intestado != null) {
				return false;
			}
		} else if (!cd_intestado.equals(other.cd_intestado)) {
			return false;
		}
		if (ch_chruf == null) {
			if (other.ch_chruf != null) {
				return false;
			}
		} else if (!ch_chruf.equals(other.ch_chruf)) {
			return false;
		}
		if (no_vchestado == null) {
			if (other.no_vchestado != null) {
				return false;
			}
		} else if (!no_vchestado.equals(other.no_vchestado)) {
			return false;
		}
		return true;
	}

}

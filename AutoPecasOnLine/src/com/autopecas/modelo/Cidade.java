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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Everson Lisboa
 *
 */
@Entity
@Table(name = "tbl_cidade")
@NamedQueries({
	@NamedQuery(name = "findAllCidade", query = "SELECT c FROM Cidade c")
})
public class Cidade implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cd_intcidade;
	
	@Column(length = 100, nullable = false, unique = true)
	private String no_vchcidade;
	
	@ManyToOne
	@JoinColumn(name="cd_intestado")
	private Estado estado;
	
	@OneToMany(mappedBy = "cidade", fetch = FetchType.LAZY)
	private List<Bairro> bairros;
	
	public Integer getCd_intcidade() {
		return cd_intcidade;
	}
	public void setCd_intcidade(Integer cd_intcidade) {
		this.cd_intcidade = cd_intcidade;
	}
	public String getNo_vchcidade() {
		return no_vchcidade;
	}
	public void setNo_vchcidade(String no_vchcidade) {
		this.no_vchcidade = no_vchcidade;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	public List<Bairro> getBairros() {
		return bairros;
	}
	public void setBairros(List<Bairro> bairros) {
		this.bairros = bairros;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((cd_intcidade == null) ? 0 : cd_intcidade.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result
				+ ((no_vchcidade == null) ? 0 : no_vchcidade.hashCode());
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
		if (!(obj instanceof Cidade)) {
			return false;
		}
		
		Cidade other = (Cidade) obj;
		if (cd_intcidade == null) {
			if (other.cd_intcidade != null) {
				return false;
			}
		} else if (!cd_intcidade.equals(other.cd_intcidade)) {
			return false;
		}
		if (estado == null) {
			if (other.estado != null) {
				return false;
			}
		} else if (!estado.equals(other.estado)) {
			return false;
		}
		if (no_vchcidade == null) {
			if (other.no_vchcidade != null) {
				return false;
			}
		} else if (!no_vchcidade.equals(other.no_vchcidade)) {
			return false;
		}
		return true;
	}

	
	
}

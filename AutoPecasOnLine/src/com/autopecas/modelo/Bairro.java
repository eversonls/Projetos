/**
 * 
 */
package com.autopecas.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Everson Lisboa
 *
 */
@Entity
@Table(name="tbl_bairro")
public class Bairro implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cd_intbairro;
	
	@Column(length = 50, nullable = false, unique = true)
	private String no_vchbairro;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="cd_intcidade")
	private Cidade cidade;
	
	@OneToMany(mappedBy = "bairro", cascade = CascadeType.ALL)
	private List<Logradouro> logradouros;

	public Integer getCd_intbairro() {
		return cd_intbairro;
	}

	public void setCd_intbairro(Integer cd_intbairro) {
		this.cd_intbairro = cd_intbairro;
	}

	public String getNo_vchbairro() {
		return no_vchbairro;
	}

	public void setNo_vchbairro(String no_vchbairro) {
		this.no_vchbairro = no_vchbairro;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public List<Logradouro> getLogradouros() {
		return logradouros;
	}

	public void setLogradouros(List<Logradouro> logradouros) {
		this.logradouros = logradouros;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((cd_intbairro == null) ? 0 : cd_intbairro.hashCode());
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result
				+ ((logradouros == null) ? 0 : logradouros.hashCode());
		result = prime * result
				+ ((no_vchbairro == null) ? 0 : no_vchbairro.hashCode());
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
		if (!(obj instanceof Bairro)) {
			return false;
		}
		Bairro other = (Bairro) obj;
		if (cd_intbairro == null) {
			if (other.cd_intbairro != null) {
				return false;
			}
		} else if (!cd_intbairro.equals(other.cd_intbairro)) {
			return false;
		}
		if (cidade == null) {
			if (other.cidade != null) {
				return false;
			}
		} else if (!cidade.equals(other.cidade)) {
			return false;
		}
		if (logradouros == null) {
			if (other.logradouros != null) {
				return false;
			}
		} else if (!logradouros.equals(other.logradouros)) {
			return false;
		}
		if (no_vchbairro == null) {
			if (other.no_vchbairro != null) {
				return false;
			}
		} else if (!no_vchbairro.equals(other.no_vchbairro)) {
			return false;
		}
		return true;
	}

	
}

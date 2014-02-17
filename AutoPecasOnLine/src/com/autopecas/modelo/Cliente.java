/**
 * 
 */
package com.autopecas.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Everson Lisboa
 *
 */
@Entity
@Table(name="tbl_cliente")
@NamedQueries({
	@NamedQuery(name="findAllClientesAtivos", query="SELECT c FROM Cliente c WHERE c.in_bitativo <> 0"),
	@NamedQuery(name="findAllClientes", query="SELECT c FROM Cliente c")
})
public class Cliente implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cd_intcliente;
	
	@Column(length = 10, nullable = false, unique = true)
	private String in_vchcliente;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="cd_intpessoa")
	private Pessoa pessoa;
	
	@Temporal(TemporalType.DATE)
	private Date dt_dtmcliente;
	
	private int in_bitativo;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="cd_intcliente")
	private List<Telefone> telefones;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="cd_intcliente")
	private List<Email> emails;
	
	public Integer getCd_intcliente() {
		return cd_intcliente;
	}
	public void setCd_intcliente(Integer cd_intcliente) {
		this.cd_intcliente = cd_intcliente;
	}
	public String getIn_vchcliente() {
		return in_vchcliente;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public void setIn_vchcliente(String in_vchcliente) {
		this.in_vchcliente = in_vchcliente;
	}
	
	public Date getDt_dtmcliente() {
		return dt_dtmcliente;
	}
	public void setDt_dtmcliente(Date dt_dtmcliente) {
		this.dt_dtmcliente = dt_dtmcliente;
	}
	public List<Telefone> getTelefones() {
		return telefones;
	}
	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
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
				+ ((cd_intcliente == null) ? 0 : cd_intcliente.hashCode());
		result = prime * result
				+ ((dt_dtmcliente == null) ? 0 : dt_dtmcliente.hashCode());
		result = prime * result + in_bitativo;
		result = prime * result
				+ ((in_vchcliente == null) ? 0 : in_vchcliente.hashCode());
		result = prime * result + ((pessoa == null) ? 0 : pessoa.hashCode());
		result = prime * result
				+ ((telefones == null) ? 0 : telefones.hashCode());
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
		if (!(obj instanceof Cliente)) {
			return false;
		}
		Cliente other = (Cliente) obj;
		if (cd_intcliente == null) {
			if (other.cd_intcliente != null) {
				return false;
			}
		} else if (!cd_intcliente.equals(other.cd_intcliente)) {
			return false;
		}
		if (dt_dtmcliente == null) {
			if (other.dt_dtmcliente != null) {
				return false;
			}
		} else if (!dt_dtmcliente.equals(other.dt_dtmcliente)) {
			return false;
		}
		if (in_bitativo != other.in_bitativo) {
			return false;
		}
		if (in_vchcliente == null) {
			if (other.in_vchcliente != null) {
				return false;
			}
		} else if (!in_vchcliente.equals(other.in_vchcliente)) {
			return false;
		}
		if (pessoa == null) {
			if (other.pessoa != null) {
				return false;
			}
		} else if (!pessoa.equals(other.pessoa)) {
			return false;
		}
		if (telefones == null) {
			if (other.telefones != null) {
				return false;
			}
		} else if (!telefones.equals(other.telefones)) {
			return false;
		}
		return true;
	}
	
	
	
	
}

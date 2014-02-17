/**
 * 
 */
package com.autopecas.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.autopecas.modelo.Cidade;
import com.autopecas.modelo.Cliente;
import com.autopecas.modelo.Email;
import com.autopecas.modelo.Endereco;
import com.autopecas.modelo.Estado;
import com.autopecas.modelo.Juridica;
import com.autopecas.modelo.Pessoa;
import com.autopecas.modelo.Telefone;
import com.autopecas.repositorio.RepositorioCliente;
import com.autopecas.repositorio.RepositorioEmail;
import com.autopecas.repositorio.RepositorioEstado;
import com.autopecas.repositorio.RepositorioTelefone;
import com.autopecas.util.Utilidades;

/**
 * @author Everson Lisboa
 *
 */
@ManagedBean(name="cadastroBean")
@SessionScoped
public class Cadastro implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Cliente cliente = new Cliente();
	private Pessoa pessoa = new Pessoa();
	private Juridica juridica = new Juridica();
	private List<Cliente> clientes = new ArrayList<>();
	private Telefone telefone = new Telefone();
	private List<Telefone> telefones = new ArrayList<>();
	private Email email = new Email();
	private List<Email> emails = new ArrayList<>();
	private Endereco endereco = new Endereco();
	private Estado estado = new Estado();
	private List<Estado> estados = new ArrayList<>();
	private Cidade cidade = new Cidade();
	private List<Cidade> cidades = new ArrayList<>();
	Utilidades util = new Utilidades();
	private boolean noveDigitos = false;
	private boolean edicao = false;
	private boolean autoUpdate = false;
	public Cadastro() {
		RepositorioCliente repositorioCliente = new RepositorioCliente();
		RepositorioEstado repositorioEstado = new RepositorioEstado();
		this.estados = repositorioEstado.getListaEstados();
		this.cliente.setDt_dtmcliente(new Date());
		this.cliente.setIn_vchcliente(repositorioCliente.geraMatricula());
	}
	
	public String registraCliente(){
		RepositorioCliente repositorioCliente = new RepositorioCliente();
		RepositorioTelefone repositorioTelefone = new RepositorioTelefone();
		repositorioTelefone.telefoneAtivo(this.telefones);
		this.cliente.setTelefones(this.telefones);
		if(repositorioCliente.regitrar(this.cliente)){
			this.addMsg(repositorioCliente.getMsgConteudo(), repositorioCliente.getMsgDetalhe());
			this.cliente = new Cliente();
			this.endereco = new Endereco();
			this.telefone = new Telefone();
			this.telefones = new ArrayList<>();
			this.cliente.setDt_dtmcliente(new Date());
			this.cliente.setIn_vchcliente(repositorioCliente.geraMatricula());
			return null;
		}
		this.addMsg(repositorioCliente.getMsgConteudo(), repositorioCliente.getMsgDetalhe());
		return null;
	}
	
	
	public String atualizaCliente(){
		RepositorioCliente repositorioCliente = new RepositorioCliente();
		RepositorioTelefone repositorioTelefone = new RepositorioTelefone();
		repositorioTelefone.telefoneAtivo(this.telefones);
		this.cliente.setTelefones(this.telefones);
		if(!repositorioCliente.atualiza(this.cliente)){
			this.addMsg(repositorioCliente.getMsgConteudo(), repositorioCliente.getMsgDetalhe());
			return null;
		}
		this.addMsg(repositorioCliente.getMsgConteudo(), repositorioCliente.getMsgDetalhe());
		this.cliente = new Cliente();
		this.telefone = new Telefone();
		this.telefones = new ArrayList<>();
		this.cliente.setIn_vchcliente(repositorioCliente.geraMatricula());
		this.cliente.setDt_dtmcliente(new Date());
		edicao = false;
		return null;
	}
	
	public void preparaEdicao(){
		RepositorioCliente repositorioCliente = new RepositorioCliente();
		Map<String, String> par = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
		int codigo = Integer.parseInt(par.get("cliente"));
		this.cliente = repositorioCliente.getById(Cliente.class,codigo);
		this.telefones = this.cliente.getTelefones();
		this.edicao = true;
		
	}
	
	public void addMsg(String msgConteudo, String msgDetalhe){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msgConteudo, msgDetalhe));
	}
	
	public String cancela(){
		RepositorioCliente repositorioCliente = new RepositorioCliente();
		this.cliente = new Cliente();
		this.telefone = new Telefone();
		this.telefones = new ArrayList<>();
		this.cliente.setIn_vchcliente(repositorioCliente.geraMatricula());
		this.edicao = false;
		return null;
	}
	
	public String addTelefone(){
		
		RepositorioTelefone repositorioTelefone = new RepositorioTelefone();
		if(this.telefone.getNu_vchtelefone().isEmpty()){
			return null;
		}
		if(!repositorioTelefone.isValido(this.telefone)){
			this.addMsg(repositorioTelefone.getMsgConteudo(), " ");
			return null;
		}
		if(repositorioTelefone.isExisteNaLista(this.telefones, this.telefone)){
			this.addMsg(repositorioTelefone.getMsgConteudo()," ");
			this.telefone = new Telefone();
			return null;
		}
		if(repositorioTelefone.isExisteNoBanco(this.telefones, this.telefone)){
			this.addMsg(repositorioTelefone.getMsgConteudo()," ");
			this.telefone = new Telefone();
			return null;
		}
		this.telefone.setIn_vchtelefone(repositorioTelefone.geraMatricula(this.telefones));
		this.telefones.add(this.telefone);
		this.addMsg("O Telefone foi Adicionado com Sucesso", " ");
		this.telefone = new Telefone();
		return null;
	}
	
	public String removeTelefone(){
		RepositorioTelefone repositorioTelefone = new RepositorioTelefone();
		Map<String, Object> map = FacesContext.getCurrentInstance().getExternalContext().getRequestMap();
		this.telefone = (Telefone)map.get("telefones");
		if(this.telefone.getIn_bitativo() == 0){
			for (Telefone t : this.telefones) {
					if(t.equals(this.telefone)){
						repositorioTelefone.removeTelefoneLista(telefones, t);
						this.addMsg(repositorioTelefone.getMsgConteudo(), " ");
						this.telefone = new Telefone();
						return null;
					}
				
			}
		}
		if(repositorioTelefone.deleteTelefone(this.telefone.getCd_inttelefone(), this.telefones)){
			this.addMsg(repositorioTelefone.getMsgConteudo(), " ");
			return null;
		}
		
		return null;
	}

	public String addEmail(){
		
		RepositorioEmail repositorioEmail = new RepositorioEmail();
		if(this.email.getDs_vchemail().isEmpty()){
			return null;
		}
		if(repositorioEmail.isExisteNaLista(this.emails, this.email)){
			this.addMsg(repositorioEmail.getMsgConteudo()," ");
			this.email = new Email();
			return null;
		}
		if(repositorioEmail.isUnico(this.emails, this.email)){
			this.addMsg(repositorioEmail.getMsgConteudo()," ");
			this.email = new Email();
			return null;
		}
		this.email.setIn_vchemail(repositorioEmail.geraMatricula(this.emails));
		this.email = repositorioEmail.preencheEmail(this.email);
		this.emails.add(this.email);
		this.addMsg("O Email foi Adicionado com Sucesso", " ");
		this.email = new Email();
		return null;
	}
	
	public String removeEmail(){
		this.autoUpdate = true;
		RepositorioEmail repositorioEmail = new RepositorioEmail();
		Map<String, Object> map = FacesContext.getCurrentInstance().getExternalContext().getRequestMap();
		this.email = (Email)map.get("email");
		if(this.email.getIn_bitativo() == 0){
			for (Email m : this.emails) {
					if(m.equals(this.email)){
						repositorioEmail.removeEmailLista(this.emails, m);
						this.addMsg(repositorioEmail.getMsgConteudo(), " ");
						this.email = new Email();
						return null;
					}
				
			}
		}
		if(repositorioEmail.deleteEmail(this.email.getCd_intemail(), this.emails)){
			this.addMsg(repositorioEmail.getMsgConteudo(), " ");
			return null;
		}
		
		return null;
	}

	public void carregaCidades(){
		this.cidades.clear();
		this.cidades = this.estado.getCidades();
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<Cliente> getClientes() {
		return clientes;
	}
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
	public boolean isEdicao() {
		return edicao;
	}
	public void setEdicao(boolean edicao) {
		this.edicao = edicao;
	}
	public Telefone getTelefone() {
		return telefone;
	}
	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}
	public List<Telefone> getTelefones() {
		return telefones;
	}
	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public Juridica getJuridica() {
		return juridica;
	}
	public void setJuridica(Juridica juridica) {
		this.juridica = juridica;
	}
	public Email getEmail() {
		return email;
	}
	public void setEmail(Email email) {
		this.email = email;
	}
	public List<Email> getEmails() {
		return emails;
	}
	public void setEmails(List<Email> emails) {
		this.emails = emails;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	public boolean isNoveDigitos() {
		return noveDigitos;
	}

	public void setNoveDigitos(boolean noveDigitos) {
		this.noveDigitos = noveDigitos;
	}

	public boolean isAutoUpdate() {
		return autoUpdate;
	}

	public void setAutoUpdate(boolean autoUpdate) {
		this.autoUpdate = autoUpdate;
	}


}

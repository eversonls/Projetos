/**
 * 
 */
package com.autopecas.repositorio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.autopecas.dao.GenericDaoImpl;
import com.autopecas.modelo.Email;

/**
 * @author Everson
 *
 */
public class RepositorioEmail extends GenericDaoImpl<Email, Integer> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String msgConteudo = "Problema ao Adiconar o Email";
	
	
	public boolean deleteEmail(int codigo, List<Email> emails){
		Email email = this.findEmail(codigo);
		this.remove(email);
		this.removeEmailLista(emails, email);
		return true;
	}
	public Email findEmail(int codigo){
		return getById(Email.class, codigo);
	}
	public void emailAtivo(List<Email> emails){
		for (Email email : emails) {
			email.setIn_bitativo(1);
		}
	}
	public boolean removeEmailLista(List<Email> emails, Email email){
		List<Email> ms = new ArrayList<>();
		for (Email m : emails) {
			if(!m.equals(email)){
				ms.add(email);
			}
		}
		
		emails.clear();
		ms = this.ordenaLista(ms);
		emails.addAll(ms);
		msgConteudo = "Email removido com sucesso";
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public boolean isUnico(List<Email> emails, Email email){
		emails = getManager().createNamedQuery("findAllEmail").getResultList();
		for (Email e : emails) {
			if(e.getDs_vchemail().equalsIgnoreCase(email.getDs_vchemail())){
				msgConteudo = "Esse Email já Existe em Nossos Registros";
				return true;
			}
		}
		return false;
	}
	
	public boolean isExisteNaLista(List<Email> emails, Email email){
		for (Email e : emails) {
			if(e.getDs_vchemail().equalsIgnoreCase(email.getDs_vchemail())){
				msgConteudo = "Esse Email já Existe na Lista";
				return true;
			}
		}
		return false;
	}

	public Email preencheEmail(Email email){
		String dominio = "";
		int posic = email.getDs_vchemail().indexOf("@");
		dominio = email.getDs_vchemail().substring(posic+1);
		dominio = dominio.substring(0, dominio.indexOf("."));
		email.setNo_vchdominio(dominio);
		return email;
	}
	
	public List<Email> ordenaLista(List<Email> emails){
		for (int i = 0; i < emails.size(); i++) {
			emails.get(i).setIn_vchemail("EMA-0"+(i+1));
		}
		return emails;
	}
	
	public String geraMatricula(List<Email> emails){
		int codigo =0;
		codigo=emails.size();
		String mat ="";
		
		if(emails.size() == 0){
			mat = "EMA-01";
			return mat;
		}
		if(codigo >= 1 || codigo <= 9){
			mat = "EMA-0"+(codigo+1);
			return mat;
		}
		return null;
	}
	
	
	
	public String getMsgConteudo() {
		return msgConteudo;
	}
	public void setMsgConteudo(String msgConteudo) {
		this.msgConteudo = msgConteudo;
	}

	public static void main(String[] args) {
		Email email = new Email();
		email.setDs_vchemail("everson.lisboa.santos@gmail.com");
		RepositorioEmail repositorioEmail = new RepositorioEmail();
		repositorioEmail.preencheEmail(email);
	}
}

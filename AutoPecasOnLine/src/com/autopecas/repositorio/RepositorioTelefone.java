package com.autopecas.repositorio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.autopecas.dao.GenericDaoImpl;
import com.autopecas.modelo.Telefone;

public class RepositorioTelefone extends GenericDaoImpl<Telefone, Integer> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String msgConteudo = "";
	
	public RepositorioTelefone() {
	}

	public Telefone findTelefone(int codigo){
		return getById(Telefone.class, codigo);
	}
	public void telefoneAtivo(List<Telefone> telefones){
		for (Telefone telefone : telefones) {
			telefone.setIn_bitativo(1);
		}
	}
	public boolean deleteTelefone(int codigo, List<Telefone> telefones){
		Telefone telefone = this.findTelefone(codigo);
		this.remove(telefone);
		this.removeTelefoneLista(telefones, telefone);
		return true;
	}
	
	public boolean removeTelefoneLista(List<Telefone> telefones, Telefone telefone){
		List<Telefone> t = new ArrayList<>();
		for (Telefone tel : telefones) {
			if(!tel.equals(telefone)){
				t.add(tel);
			}
		}
		telefones.clear();
		t = this.ordenaLista(t);
		telefones.addAll(t);
		msgConteudo = "Telefone removido com sucesso";
		return true;
	}
	
	public boolean isValido(Object object) {
		Telefone telefone = (Telefone) object;
		String tipo = "";
		if(telefone.getNu_vchtelefone().equalsIgnoreCase("(00)0000-0000") 
				|| telefone.getNu_vchtelefone().equalsIgnoreCase("(11)1111-1111") 
				|| telefone.getNu_vchtelefone().equalsIgnoreCase("(22)2222-2222") 
				|| telefone.getNu_vchtelefone().equalsIgnoreCase("(33)3333-3333") 
				|| telefone.getNu_vchtelefone().equalsIgnoreCase("(44)4444-4444") 
				|| telefone.getNu_vchtelefone().equalsIgnoreCase("(55)5555-5555") 
				|| telefone.getNu_vchtelefone().equalsIgnoreCase("(66)6666-6666") 
				|| telefone.getNu_vchtelefone().equalsIgnoreCase("(77)7777-7777") 
				|| telefone.getNu_vchtelefone().equalsIgnoreCase("(88)8888-8888") 
				|| telefone.getNu_vchtelefone().equalsIgnoreCase("(99)9999-9999")){
			this.msgConteudo = "Digite um telefone valído";
			return false;
			
		}
		tipo = telefone.getNu_vchtelefone().substring(4, 6);
		if("88879699".contains(tipo)){
			telefone.setDs_vchtipo_telefone("CELULAR");
			telefone.setDs_vchoperadora("OI");
		}else
			if("808183".contains(tipo)){
				telefone.setDs_vchtipo_telefone("CELULAR");
				telefone.setDs_vchoperadora("TIM");
			}else
				if("91".contains(tipo)){
					telefone.setDs_vchtipo_telefone("CELULAR");
					telefone.setDs_vchoperadora("VIVO");
				}else
					if("94".contains(tipo)){
						telefone.setDs_vchtipo_telefone("CELULAR");
						telefone.setDs_vchoperadora("CLARO");
					}else{
						telefone.setDs_vchtipo_telefone("RESIDÊNCIAL");
						telefone.setDs_vchoperadora("DESCONHECIDA");
					}
		
		tipo = telefone.getNu_vchtelefone().substring(1, 3);
		if("111213141516171819".contains(tipo)){
			telefone.setCh_chrtelefone("SP");
		}else
			if("212224".contains(tipo)){
				telefone.setCh_chrtelefone("RJ");
			}else
				if("2728".contains(tipo)){
					telefone.setCh_chrtelefone("ES");
				}else
					if("31323334353738".contains(tipo)){
						telefone.setCh_chrtelefone("MG");
					}else
						if("414243444546".contains(tipo)){
							telefone.setCh_chrtelefone("PR");
						}else
							if("474849".contains(tipo)){
								telefone.setCh_chrtelefone("SC");
							}else
								if("51535455".contains(tipo)){
									telefone.setCh_chrtelefone("RS");
								}else
									if("61".contains(tipo)){
										telefone.setCh_chrtelefone("DF");
									}else
										if("6264".contains(tipo)){
											telefone.setCh_chrtelefone("GO");
										}else
											if("919394".contains(tipo)){
												telefone.setCh_chrtelefone("PA");
											}
		return true;
	}

	
	public boolean isExisteNaLista(List<Telefone> telefones, Telefone telefone){
		for (Telefone t : telefones) {
			if (t.getNu_vchtelefone().equalsIgnoreCase(telefone.getNu_vchtelefone())) {
				this.msgConteudo = "Esse Telefone já Existe na Lista";
				return true;
			}
		}
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public boolean isExisteNoBanco(List<Telefone> telefones, Telefone telefone){
		telefones = getManager().createNamedQuery("findAllTelefone").getResultList();
		for (Telefone t : telefones) {
			if (t.getNu_vchtelefone().equalsIgnoreCase(telefone.getNu_vchtelefone())) {
				this.msgConteudo = "Esse Telefone já Existe em Nosso Registros";
				return true;
			}
		}
		return false;
	}
	
	public String geraMatricula(List<Telefone> telefones){
		int codigo =0;
		codigo=telefones.size();
		String mat ="";
		
		if(telefones.size() == 0){
			mat = "TEL-01";
			return mat;
		}
		if(codigo >= 1 || codigo <= 9){
			mat = "TEL-0"+(codigo+1);
			return mat;
		}
		return null;
	}
	
	public List<Telefone> ordenaLista(List<Telefone> telefones){
		for (int i = 0; i < telefones.size(); i++) {
			telefones.get(i).setIn_vchtelefone("TEL-0"+(i+1));
		}
		return telefones;
	}

	public String getMsgConteudo() {
		return msgConteudo;
	}

	public void setMsgConteudo(String msgConteudo) {
		this.msgConteudo = msgConteudo;
	}

	public static void main(String[] args) throws Exception{

	}

}

/**
 * 
 */
package com.autopecas.teste;

import com.autopecas.modelo.Cliente;


/**
 * @author Everson Lisboa
 * Classe gerada para teste
 */
public class RunTeste {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Cliente cliente = new Cliente();
		Cliente c = new Cliente();
		c.setCd_intcliente(1);
		cliente.setCd_intcliente(1);
		if(c.equals(cliente)){
			System.out.println("Iguais");
		}else{
			System.out.println("São diferentes");
		}
	}

}

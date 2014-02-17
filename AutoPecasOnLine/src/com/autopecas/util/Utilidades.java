/**
 * 
 */
package com.autopecas.util;

import java.io.Serializable;
import java.util.Calendar;

/**
 * @author Everson Lisboa
 *
 */
public class Utilidades implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String Hoje(){
		
		Calendar hoje = Calendar.getInstance();
		int d = hoje.get(Calendar.DATE);
		int m = hoje.get(Calendar.MONTH)+1;
		int a = hoje.get(Calendar.YEAR);
		return  d+"/"+m+"/"+a;
	}
	
}

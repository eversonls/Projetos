package com.autopecas.gerenciadorEntity;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class FilterEntity
 */
@WebFilter(servletNames="Faces Servlet")
public class FilterEntity implements Filter {

	private EntityManagerFactory factory;

	public void destroy() {
		this.factory.close();
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		EntityManager manager = this.factory.createEntityManager();
		
		manager.getTransaction().begin();
		request.setAttribute("manager", manager);
		chain.doFilter(request, response);
		
		try {
			manager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			manager.close();
		}
	}


	public void init(FilterConfig fConfig) throws ServletException {
		this.factory = Persistence.createEntityManagerFactory("AutoPecasOnLine");
	}

}

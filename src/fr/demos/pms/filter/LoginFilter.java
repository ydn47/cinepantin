package fr.demos.pms.filter;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;

import fr.demos.pms.annotation.Dao;
import fr.demos.pms.dao.ClientDao;
import fr.demos.pms.dao.ClientDaoJPA;
import fr.demos.pms.model.Client;


/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter(filterName="LoginFilter", urlPatterns={"/*"}, dispatcherTypes={DispatcherType.REQUEST, DispatcherType.FORWARD})
public class LoginFilter implements Filter {
	@Inject  @Dao
	private ClientDao clientDao; 
    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest) request).getSession(); 
		Client client       = (Client) session.getAttribute("client");
		System.out.print("clientSession" + client);
		if (client != null) {
			String nom    = client.getNom();
			String prenom = client.getPrenom();
			
			if (nom != null && !nom.equals("") || prenom != null && !prenom.equals("")) {
				request.setAttribute("msg","Bonjour "+ prenom + " " +nom);					
			} else {
				request.setAttribute("msg","Bonjour");		
			}
			/*
			RequestDispatcher rd =
					request.getRequestDispatcher("/boutique");
			rd.forward(request, response);
			*/
		}//l'user est connecté, on affiche Bonjour
		try {
			chain.doFilter(request, response);
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

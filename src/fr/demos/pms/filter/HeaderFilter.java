package fr.demos.pms.filter;

import java.io.IOException;
import java.util.Collection;

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
import fr.demos.pms.model.Categorie;
import fr.demos.pms.model.Client;
import fr.demos.pms.model.Panier;
import fr.demos.pms.dao.CategorieDao;
import fr.demos.pms.dao.CategorieDaoJPA;


/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter(filterName="HeaderFilter", urlPatterns={"/*"}, dispatcherTypes={DispatcherType.REQUEST, DispatcherType.FORWARD})
public class HeaderFilter implements Filter {
	@Inject  @Dao
	private ClientDao clientDao; 
	
	@Inject @Dao
	private CategorieDao daoCategorie;
    /**
     * Default constructor. 
     */
    public HeaderFilter() {
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
		request.setCharacterEncoding("UTF-8");
		
		// chargement des catégories 
		Collection<Categorie> listeCategories = daoCategorie
				.findAllCategories();
		request.setAttribute("lstCategories", listeCategories);
		
		HttpSession session = ((HttpServletRequest) request).getSession(); 
		Client client       = (Client) session.getAttribute("client");
		
		if (client != null) {//l'user est connecté, on affiche Bonjour
			String nom    = client.getNom();
			String prenom = client.getPrenom();
			
			if (nom != null && !nom.equals("") || prenom != null && !prenom.equals("")) {
				request.setAttribute("msg","Bonjour "+ prenom + " " +nom);					
			} else {
				request.setAttribute("msg","Bonjour");		
			}
		}
		
		Panier panier = (Panier) session.getAttribute("panier");
		System.out.print("panierSession" + panier);
		if (panier!= null) {
			int nbArticles = panier.getLignesPanier().size();
			request.setAttribute("nbArticles",nbArticles);
			request.setAttribute("total", panier.getMontantTotalTTCFormat());
			
		}
		
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

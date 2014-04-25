package fr.demos.pms.listener;

import javax.inject.Inject;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import fr.demos.pms.annotation.Dao;
import fr.demos.pms.dao.ArticleDao;
import fr.demos.pms.dao.PanierDao;
import fr.demos.pms.model.Client;
import fr.demos.pms.model.Panier;



/**
 * Application Lifecycle Listener implementation class SessionListener
 *
 */
@WebListener
public class SessionListener implements HttpSessionListener {
	@Inject @Dao
	private ArticleDao daoArticle;
	private PanierDao  daoPanier;
	
    public SessionListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent evt) {
    	HttpSession session = evt.getSession();
    	Compteur nbvisiteurs =  (Compteur) session.getServletContext().getAttribute("nbvisiteurs");
    	
    	nbvisiteurs.incrementer();
    	System.out.print("Created =" +nbvisiteurs);
    	System.out.print("cr?ation panier de course associ? ? l'utilisateur");
    	//cr?ation panier de course associ? ? l'utilisateur
    	
    	Panier panier = null;
    	//si l'utilisateur est connect?, recuperer son panier de la bdd s'il existe
    	Client client = (Client) session.getAttribute("client");
    	if (client != null){
    		panier = daoPanier.findByClient(client);
    		session.setAttribute("panier",panier);		
    	}else{
    		panier = new Panier();
        	session.setAttribute("panier",panier);
    	}
    	System.out.print("Panier : "+panier);
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent evt) {
    	
    	
    }
	
}

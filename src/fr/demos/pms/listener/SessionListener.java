package fr.demos.pms.listener;

import javax.inject.Inject;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import fr.demos.pms.annotation.Dao;
import fr.demos.pms.dao.ArticleDao;
import fr.demos.pms.dao.DAOException;
import fr.demos.pms.dao.PanierDao;
import fr.demos.pms.model.Client;
import fr.demos.pms.model.LignePanier;
import fr.demos.pms.model.LignePanierFactory;
import fr.demos.pms.model.Panier;
import fr.demos.pms.model.PanierFactory;



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
    	//System.out.print("Created =" +nbvisiteurs);
    	System.out.print("cr�ation panier de course associ� � l'utilisateur");
    	//cr?ation panier de course associ? ? l'utilisateur
    	
    	Panier panier = null;
    	//si l'utilisateur est connect?, recuperer son panier de la bdd s'il existe
    	Client client = (Client) session.getAttribute("client");
    	if (client != null){ //il est connect�
    		panier = daoPanier.findByClient(client);
    		session.setAttribute("panier",panier);		
    		
    		
    	}else{ //pas connecte , on cree un panier vide dans la session
    		panier = PanierFactory.getNewPanier();
    		//panier = new Panier();
    		panier.setDatePanier(new java.util.Date());
        	session.setAttribute("panier",panier);
    	}
    	System.out.print("Panier Listener : "+panier);

    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent evt) {
    	HttpSession session = evt.getSession();
    	//sauvgarde dans la bdd si le client est connect�
    	
    	Panier panier = (Panier) session.getAttribute("panier");
    	
    	if ( (panier.getClient() != null) && (panier!=null) ){
    		System.out.print("Panier sessionDestroyed : "+panier);
    		try{
    			daoPanier.create(panier);
			}catch (DAOException e){
				e.printStackTrace();
				System.out.println("erreur Creation compte DAO"+ e.getMessage());
				
			}
    	}	
    		
    	
    	
    }
	
}

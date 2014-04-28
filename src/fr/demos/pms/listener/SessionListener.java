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

    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent evt) {
    	
    	
    }
	
}

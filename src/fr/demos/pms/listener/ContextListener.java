package fr.demos.pms.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ContextListener
 *
 */
@WebListener
public class ContextListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public ContextListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent evt) {
        // TODO Auto-generated method stub
    	//recherche nombre de visites conserv? en base de donn?es
    	Compteur nbvisiteurs = null ;
    	//stocke ce nombre dans l'objet ServletContext
    	ServletContext application = evt.getServletContext();
    	if(nbvisiteurs!= null){
    		application.setAttribute("nbvisiteurs",nbvisiteurs);
    	} else {
    		application.setAttribute ("nbvisiteurs",new Compteur(0));
    	}
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0) { //lorsque glassfish est arret?
        // TODO Auto-generated method stub
    }
	
}

package fr.demos.pms.filter;

import java.io.IOException;
import java.util.HashMap;

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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import fr.demos.pms.annotation.Dao;
import fr.demos.pms.dao.ClientDao;
import fr.demos.pms.model.Client;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter(filterName = "LoginFilter", urlPatterns = { "/commande" }, dispatcherTypes={DispatcherType.REQUEST, DispatcherType.FORWARD})
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
		// TODO Auto-generated method stub
		HttpSession session = ((HttpServletRequest) request).getSession(); 
		Client client       = (Client) session.getAttribute("client");
		
		if (client == null) { //pas connecté
			
			
			String loginparam = request.getParameter("email");
			String mdpparam   = request.getParameter("mdp");
			HashMap<String, String> errorMap = new HashMap<>();
				
				if (loginparam == null || loginparam.equals("")) {
					errorMap.put("email", "Email (Login) obligatoire");
				}
				if (mdpparam == null || mdpparam.equals("")) {	
					errorMap.put("mdp", "Mdp obligatoire");	
				}
				if(errorMap.size() == 0){
					//verifier que le compte existe
					Client clientParam = null;
					System.out.print("email  " +loginparam+"  mdp  " +mdpparam);
					clientParam = clientDao.findByParam(loginparam, mdpparam);
					
					if (clientParam != null){
						request.setAttribute("origine","commande");
						session.setAttribute("client", clientParam);	
						
					}else{
						request.setAttribute("erreurCompte", "Votre login ou mdp est incorrect");
						request.setAttribute("email", "");
						request.setAttribute("mdp", "");
						request.setAttribute("origine","commande");
						RequestDispatcher rd = request.getRequestDispatcher("/my_account.jsp");
						rd.forward(request, response);
						return;
					}
                      
				}else{
					request.setAttribute("erreur",errorMap);
					request.setAttribute("origine","commande");
					RequestDispatcher rd = request.getRequestDispatcher("/my_account.jsp");
					rd.forward(request, response);
					return;
					
				}
		}//l'user est connecté, on laisse passer
		System.out.print("*******************************************je suis connecteé");
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

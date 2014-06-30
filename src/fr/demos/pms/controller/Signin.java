package fr.demos.pms.controller;


import java.io.IOException;
import java.util.HashMap;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.demos.pms.annotation.Dao;
import fr.demos.pms.dao.ClientDao;
import fr.demos.pms.model.Client;

/**
 * Servlet implementation class Signin
 */
@WebServlet("/signin/*")
public class Signin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject  @Dao
	private ClientDao clientDao;    
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//se connecter
		System.out.print("doGet Singin ");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.print("doPost Signin");
		HttpSession session = request.getSession(); 
		String info = request.getPathInfo();
		response.setCharacterEncoding("UTF-8");
		//verifier d'ou je viens
		
		String origine  = request.getParameter("origine").trim();
		System.out.println("origine= " +origine);
		System.out.println("info= " +info);
			
		String action = request.getParameter("signin");
		if (action != null && action.endsWith("connecter")) {
			String email    = "";
			String mdp      = "";
			email  = request.getParameter("email").trim();
			mdp    = request.getParameter("mdp").trim();
			HashMap<String, String> errorMap = new HashMap<>();
			
			if (email == null || email.equals("")) {
				errorMap.put("email", "Email (Login) obligatoire");
			}
			if (mdp == null || mdp.equals("")) {	
				errorMap.put("mdp", "Mdp obligatoire");	
			}
			if(errorMap.size() == 0){
				//verifier que le compte existe
				Client client = null;
				System.out.print("email  " +email+"  mdp  " +mdp);
				client = clientDao.findByParam(email, mdp);
				
				if (client != null){
					session.setAttribute("client", client);	
					System.out.println("origineICI " +origine);
					RequestDispatcher rd = request
							.getRequestDispatcher("/"+origine);
							rd.forward(request, response);
							System.out.print("doPost Singn fin");	
					return;	
				}else{
					request.setAttribute("erreurCompte", "Votre login ou mdp est incorrect");
					request.setAttribute("email", "");
					request.setAttribute("mdp", "");
					request.setAttribute("origine",origine);
					RequestDispatcher rd = request.getRequestDispatcher("/my_account.jsp");
					rd.forward(request, response);
					return;
				}
                  
			}else{
				request.setAttribute("erreur",errorMap);
				request.setAttribute("origine",origine);
				RequestDispatcher rd = request.getRequestDispatcher("/my_account.jsp");
				rd.forward(request, response);
				return;
				
			}

			
		}else {
			doGet(request, response);
		}
	}


}

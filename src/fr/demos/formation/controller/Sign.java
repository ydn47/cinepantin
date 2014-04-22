package fr.demos.formation.controller;

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


import fr.demos.pms.dao.*;
import fr.demos.pms.model.Client;

/**
 * Servlet implementation class Signin
 */
@WebServlet("/sign/*")
public class Sign extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject  
	private ClientDaoJPA clientDao;    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sign() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String info = request.getPathInfo();
		
		if ((info != null) && (info.equals("/in")) ){  //se connecter
		
		RequestDispatcher rd = request
				.getRequestDispatcher("/Signin.jsp");
				rd.forward(request, response);
		return;	
		}else if ((info != null) && (info.equals("/up")) ){ //creer un compte
			
			RequestDispatcher rd = request
					.getRequestDispatcher("/Signup.jsp");
					rd.forward(request, response);
			return;	
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String info = request.getPathInfo();
		
		if ((info != null) && (info.equals("/in")) ){  //se connecter
		
		RequestDispatcher rd = request
				.getRequestDispatcher("/Main.jsp");
				rd.forward(request, response);
		return;	
		}else if ((info != null) && (info.equals("/up")) ){//creer un compte
			
			
			//recup parametre, verifier 
			//inserer compte s'il n'exixte pas
			//redirect home avec mise a jour header (Bonjour M XX)
			
			String action = request.getParameter("submit");
			//request.setCharacterEncoding("UTF-8");
			HashMap<String, String> errorMap = new HashMap<>();
			
			String nom      = "";
			String prenom   = "";
			String email    = "";
			String mdp      = "";
			
			if (action != null && action.equals("signup")) {
				
				nom = request.getParameter("nom").trim();
				prenom = request.getParameter("prenom").trim();
				email = request.getParameter("email").trim();
				mdp   = request.getParameter("mdp").trim();
				
				if (nom == null || nom.equals("")) {
					errorMap.put("nom", "Nom obligatoire");
				}
				if (prenom == null || prenom.equals("")) {
					errorMap.put("prenom", "Prénom obligatoire");
				}
				if (email == null || email.equals("")) {
					errorMap.put("email", "Email (Login) obligatoire");
				}
				if (mdp == null || mdp.equals("")) {
					
					errorMap.put("mdp", "Mdp obligatoire");	
				}
				//verifier que le login n'existe pas deja
				Client client = null;
				client = clientDao.findByLogin(email);
				if (client != null){
					errorMap.put("email", "Email (Login) existant");
				}
				if(errorMap.size() !=0){
					request.setAttribute("erreur",errorMap);
			
					RequestDispatcher rd = request.getRequestDispatcher("/Compte.jsp");
					rd.forward(request, response);
					return;
				}else{
					Client userParam = new Client(nom, prenom,email, mdp);
					try{
						clientDao.create(userParam);
					}catch (DAOException e){
						request.setAttribute("erreur Creation compte DAO", e.getMessage());
						
					}
					HttpSession session = request.getSession(); 
					session.setAttribute("utilisateur", userParam);
					RequestDispatcher rd = request.getRequestDispatcher("/Main.jsp");
					rd.forward(request, response);
					return;
					
				}
			}
		}
			
	}

}

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
import fr.demos.pms.dao.DAOException;
import fr.demos.pms.model.Adresse;
import fr.demos.pms.model.Client;

/**
 * Servlet implementation class Signup
 */
@WebServlet("/signup/*")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject  @Dao
	private ClientDao clientDao;      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Signup() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//creer un compte
		System.out.print("doGet Singup");
		HttpSession session = request.getSession(); 
		String sb = request.getPathInfo();
		System.out.println("sb " +sb);
		String[] myArray = sb.split("/");
		String info = myArray[0];
		System.out.println("length " +myArray.length);
		String origine ="";
		if (myArray.length == 2 )
			origine  = myArray[1];
		else if (myArray.length > 2 )
			origine  = myArray[1]+"/"+myArray[2];
		
		System.out.println("origine " +origine);
	
		request.setAttribute("origine",origine);
		RequestDispatcher rd = request
				.getRequestDispatcher("/register.jsp");
				rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.print("doPost Sign");
		HttpSession session = request.getSession(); 
		String info = request.getPathInfo();
		response.setCharacterEncoding("UTF-8");
		//verifier d'ou je viens
		String origine  = request.getParameter("origine").trim();
		System.out.println("origine " +origine);
		System.out.println("info " +info);
		/* TODO
		 * enregistrer les autres param d'adresse OK
		 * verifier si le chmp mdp2 est egale au premier 
		 * 
		 * envoyer un mail de confirmation creation de compte 
		 * possibilite de gerer le meme formulaire en mode edition, le client peut modifier ses informations personelles (a voir)
		*/
		//recup parametre, verifier 
		//inserer compte s'il n'exixte pas
		//redirect home avec mise a jour header (Bonjour M XX)
		request.setCharacterEncoding("UTF-8");
		String action = request.getParameter("signup");
		HashMap<String, String> errorMap = new HashMap<>();
		
		String nom      = "";
		String prenom   = "";
		String email    = "";
		String mdp      = "";
		String mdp2     = "";
		String newsletter = "";
		String adresse  = "";
		String ville    = "";
		String codepostal = "";
		String pays = "";
		String telephone = "";
		
		if (action != null && action.endsWith("compte")) {
			
			nom    = request.getParameter("nom").trim();
			//System.out.println("**********************" +nom);
			
			
			prenom = request.getParameter("prenom").trim();
			email  = request.getParameter("email").trim();
			mdp    = request.getParameter("mdp").trim();
			mdp2   = request.getParameter("mdp2").trim();
			adresse = request.getParameter("adresse").trim();
			ville  = request.getParameter("ville").trim();
			codepostal = request.getParameter("cp").trim();
			pays   = request.getParameter("pays").trim();
			telephone = request.getParameter("telephone").trim();

			newsletter = request.getParameter("subscribe");
			//System.out.print("hgfhtdf "+newsletter);
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
			if (adresse == null || adresse.equals("")) {
				errorMap.put("adresse", "Adresse obligatoire");	
			}
			if (ville == null || ville.equals("")) {
				errorMap.put("ville", "Ville obligatoire");	
			}
			if (codepostal == null || codepostal.equals("")) {
				errorMap.put("codepostal", "Code postal obligatoire");	
			}
			if (pays == null || pays.equals("")) {
				errorMap.put("pays", "Pays obligatoire");	
			}
			if (telephone == null || telephone.equals("")) {
				errorMap.put("telephone", "Téléphone obligatoire");	
			}
			
			
			//verifier que le login n'existe pas deja
			Client client = null;
			client = clientDao.findByLogin(email);
			System.out.print("client  " +client);
			if (client != null){
				errorMap.put("email", "Email (Login) existant");
			}
			// vérifier que le champ mdp2 est égal au champ mdp1
			// eventuellement voir si on peut hasher les mdp
			if (!mdp.equals(mdp2)) 
			{
				errorMap.put("mdp2", "Les mots de passe ne sont pas égaux");
			}
			
			if(errorMap.size() != 0){
				request.setAttribute("nom",nom);
				request.setAttribute("prenom",prenom);
				request.setAttribute("email",email);
				request.setAttribute("erreur",errorMap);
		
				RequestDispatcher rd = request.getRequestDispatcher("/register.jsp");
				rd.forward(request, response);
				return;
			}else{
				int newsl;
				if (newsletter == null) newsl = 0;
				else newsl = 1 ;
				
				//Client userParam = new Client(nom, prenom,email, mdp, newsl);
				Adresse adr      = new Adresse(pays, ville, adresse, codepostal, telephone, nom,prenom);
				Client userParam = new Client(nom, prenom,email, mdp, newsl, adr, adr);
				System.out.print(userParam);
				try{
					clientDao.create(userParam);
				}catch (DAOException e){
					request.setAttribute("erreur Creation compte DAO", e.getMessage());
					
				}
				
				session.setAttribute("client", userParam);
				RequestDispatcher rd = request
						.getRequestDispatcher("/"+origine);
						rd.forward(request, response);
				return;	
				
			}
		}else {
			doGet(request, response);
		}
	}

}

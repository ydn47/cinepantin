
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
import fr.demos.pms.dao.PanierDao;
import fr.demos.pms.model.Adresse;
import fr.demos.pms.model.Client;




/**
 * Servlet implementation class Signin
 */
@WebServlet("/sign/*")
public class Sign extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject  @Dao
	private ClientDao clientDao;  
	private PanierDao panierDao;    
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
		System.out.print("doGet Singn");
		HttpSession session = request.getSession(); 
		String info = request.getPathInfo();
		
		if ((info != null) && (info.equals("/in")) ){  //se connecter
		
		RequestDispatcher rd = request
				.getRequestDispatcher("/Signin.jsp");
				rd.forward(request, response);
		return;	
		}else if ((info != null) && (info.equals("/up")) ){ //creer un compte
			
			RequestDispatcher rd = request
					.getRequestDispatcher("/register.jsp");
					rd.forward(request, response);
			return;	
		}else if ((info != null) && (info.equals("/disconnect")) ){ //se deconnecter
			System.out.print ("do Get disconnect");
			session.setAttribute("client", null);
			RequestDispatcher rd = request
					.getRequestDispatcher("/boutique");
					rd.forward(request, response);
			return;	
		}else if ((info != null) && (info.equals("/editAccount")) ){ //modifier son compte
			
			/* TODO
			 * recuperer le client de la session
			 * repeupler le formulaire
			 * et faire un update
			 * 
			 */
			Client client = (Client) session.getAttribute("client");
			if (client != null){
				request.setAttribute("nom",client.getNom());
				request.setAttribute("prenom",client.getPrenom());
				request.setAttribute("email",client.getLogin());
				RequestDispatcher rd = request.getRequestDispatcher("/my_account.jsp");
				rd.forward(request, response);
				return;
			}
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("/my_account.jsp");
			rd.forward(request, response);
			return;
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.print("doPost Singn");
		HttpSession session = request.getSession(); 
		String info = request.getPathInfo();
		
		if ((info != null) && (info.equals("/in")) ){//se connecter
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
				if(errorMap.size() ==0){
					//verifier que le compte existe
					Client client = null;
					System.out.print("email  " +email+"  mdp  " +mdp);
					client = clientDao.findByParam(email, mdp);
					
					if (client != null){
						session.setAttribute("client", client);	
						RequestDispatcher rd = request
								.getRequestDispatcher("/boutique");
								rd.forward(request, response);
								System.out.print("doPost Singn fin");	
						return;	
					}else{
						request.setAttribute("erreurCompte", "Votre login ou mdp est incorrect");
						request.setAttribute("email", "");
						request.setAttribute("mdp", "");
						RequestDispatcher rd = request.getRequestDispatcher("/my_account.jsp");
						rd.forward(request, response);
						return;
					}
                      
				}else{
					request.setAttribute("erreur",errorMap);
					
					RequestDispatcher rd = request.getRequestDispatcher("/my_account.jsp");
					rd.forward(request, response);
					return;
					
				}
	
				
			}
		}else if ((info != null) && (info.equals("/up")) ){//creer un compte
			/* TODO
			 * enregistrer les autres param d'adresse OK
			 * verifier si le chmp mdp2 est egale au premier OK 
			 * eventuellement voir si on peut hasher les mdp
			 * envoyer un mail de confirmation creation de compte 
			 * possibilite de gerer le meme formulaire en mode edition, le client peut modifier ses informations personelles (a voir)
			*/
			//recup parametre, verifier 
			//inserer compte s'il n'exixte pas
			//redirect home avec mise a jour header (Bonjour M XX)
			
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
				System.out.print("hgfhtdf "+newsletter);
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
					Adresse adr = new Adresse(pays, ville, adresse, codepostal, telephone);
					Client userParam = new Client(nom, prenom,email, mdp, newsl, adr, adr);
					System.out.print(userParam);
					try{
						clientDao.create(userParam);
					}catch (DAOException e){
						request.setAttribute("erreur Creation compte DAO", e.getMessage());
						
					}
					
					session.setAttribute("client", userParam);
					RequestDispatcher rd = request
							.getRequestDispatcher("/boutique");
							rd.forward(request, response);
					return;	
					
				}
			}
		}else{
			doGet(request, response);
		}
			
	}

}


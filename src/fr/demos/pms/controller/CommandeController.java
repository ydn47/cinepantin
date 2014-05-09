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
import fr.demos.pms.dao.AdresseDao;
import fr.demos.pms.dao.ClientDao;
import fr.demos.pms.dao.ClientDaoJPA;
import fr.demos.pms.dao.CommandeDao;
import fr.demos.pms.dao.DAOException;
import fr.demos.pms.dao.PanierDao;
import fr.demos.pms.model.Adresse;
import fr.demos.pms.model.Client;
import fr.demos.pms.model.Commande;
import fr.demos.pms.model.Panier;

/**
 * Servlet implementation class CommandeController
 */
@WebServlet("/commande")
public class CommandeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject  @Dao
	private ClientDao clientDao;  
	@Inject  @Dao
	private CommandeDao cmdDao;
	
    public CommandeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(); 
		Client client = (Client) session.getAttribute("client");
		System.out.print("adr fact : "+client.getAdresseFacturation().getIdAdresse());
		System.out.print("adr liv : "+client.getAdresseLivraison().getIdAdresse());
		
		if (client != null){
			request.setAttribute("client", client);
		}
		RequestDispatcher rd = request
				.getRequestDispatcher("/cart-confirmation.jsp");
				rd.forward(request, response);
				return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(); 
		
		Client client = (Client) session.getAttribute("client");
		
		String action 		= request.getParameter("valideCmd");
		
		System.out.print("action  " +action );
		if ((action != null) && (action.equals("Valider")) ){//valider la commader
			//recuperer tous champs du formulaire
			//maj les adresses de livraison et facturation
			// insertion ds la bdd ;ligneCommande et commande
			HashMap<String, String> errorMap = new HashMap<>();
			String nomf        = request.getParameter("nomf").trim();
			String noml        = request.getParameter("noml").trim();
			String prenomf     = request.getParameter("prenomf").trim();
			String prenoml     = request.getParameter("prenoml").trim();
			String adressef    = request.getParameter("adressef").trim();
			String adressel    = request.getParameter("adressel").trim();
			String villef      = request.getParameter("villef").trim();
			String villel      = request.getParameter("villel").trim();
			String codepostalf = request.getParameter("cpf").trim();
			String codepostall = request.getParameter("cpl").trim();
			String paysf       = request.getParameter("paysf").trim();
			String paysl       = request.getParameter("paysl").trim();
			String telephonef  = request.getParameter("telephonef").trim();
			String telephonel  = request.getParameter("telephonel").trim();
			
			//control sur les champs
			if (nomf == null || nomf.equals("")) {
				errorMap.put("nomf", "Nom obligatoire");
			}
			if (noml == null || noml.equals("")) {
				errorMap.put("noml", "Nom obligatoire");
			}
			if (prenomf == null || prenomf.equals("")) {
				errorMap.put("prenomf", "Prénom obligatoire");
			}
			if (prenoml == null || prenoml.equals("")) {
				errorMap.put("prenoml", "Prénom obligatoire");
			}
			
			if (adressef == null || adressef.equals("")) {
				errorMap.put("adressef", "Adresse obligatoire");	
			}
			if (adressel == null || adressel.equals("")) {
				errorMap.put("adressel", "Adresse obligatoire");	
			}
			if (villef == null || villef.equals("")) {
				errorMap.put("villef", "Ville obligatoire");	
			}
			if (villel == null || villel.equals("")) {
				errorMap.put("villel", "Ville obligatoire");	
			}
			if (codepostalf == null || codepostalf.equals("")) {
				errorMap.put("codepostalf", "Code postal obligatoire");	
			}
			if (codepostall == null || codepostall.equals("")) {
				errorMap.put("codepostall", "Code postal obligatoire");	
			}
			if (paysf == null || paysf.equals("")) {
				errorMap.put("paysf", "Pays obligatoire");	
			}
			if (telephonel == null || telephonel.equals("")) {
				errorMap.put("telephonel", "Téléphone obligatoire");	
			}
			
			if(errorMap.size() != 0){
				request.setAttribute("nomf",nomf);
				request.setAttribute("noml",noml);
				request.setAttribute("prenomf",prenomf);
				request.setAttribute("prenomf",prenomf);
				request.setAttribute("adressef",adressef);
				request.setAttribute("adressel",adressel);
				request.setAttribute("codepostalf",codepostalf);
				request.setAttribute("codepostall",codepostall);
				request.setAttribute("telephonef",telephonef);
				request.setAttribute("telephonel",telephonel);
				request.setAttribute("villef",villef);
				request.setAttribute("villel",villel);
				request.setAttribute("paysf",paysf);
				request.setAttribute("paysl",paysl);
				
		
				RequestDispatcher rd = request.getRequestDispatcher("/cart-confirmation.jsp");
				rd.forward(request, response);
				return;
			}else{
				
				Adresse adrLivParam     = new Adresse(paysl, villel, adressel, codepostall, telephonel, noml,prenoml);
				Adresse adrFactParam    = new Adresse(paysf, villef, adressef, codepostalf, telephonef, nomf,prenomf);
				
				//System.out.print("Equal :" +adrLivParam.equals(adrFactParam));
				if (adrLivParam.equals(adrFactParam)){ //adr liv == adr facturation
					//tester si la version de la base est different de celle affiche
					//si egal rien a faire
					//sinon update
					if (!client.getAdresseLivraison().equals(adrLivParam)){ //adr a été changée
						
						System.out.print(" 2 memes adrs  changées");
						System.out.print(" avant :" +client.getAdresseLivraison());
						//passer un objet avec un id pour que le merge fait un update
						adrLivParam.setIdAdresse(client.getAdresseLivraison().getIdAdresse());
						client.setAdresseFacturation(adrLivParam);
						client.setAdresseLivraison(adrLivParam);
						Client clienAJour = clientDao.update(client);
						System.out.print(" apres :" +clienAJour.getAdresseLivraison());
						session.setAttribute("client", clienAJour);
						
					}
				}else{ //adr liv != adr facturation
					//create a new line adress
					//maj client
					adrLivParam.setIdAdresse(client.getAdresseLivraison().getIdAdresse());
					client.setAdresseFacturation(adrLivParam);
					client.setAdresseLivraison(adrFactParam);
					Client clienAJour = clientDao.update(client);
					session.setAttribute("client", clienAJour);
				}

				/*
				 * enfin insert ds commande et ligne commande
				 */
				Panier panier = (Panier) session.getAttribute("panier");
				Commande cmd = new Commande(new java.util.Date(), client);
				
				try{
					cmdDao.create(cmd);
				}catch (DAOException e){
					request.setAttribute("erreur Creation commande", e.getMessage());		
				}
				
				
				
			}
		}else {
			//doGet(request, response);
			RequestDispatcher rd = request.getRequestDispatcher("/commande-merci.jsp");
			rd.forward(request, response);
			return;	
		}
	}	
}

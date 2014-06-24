package fr.demos.pms.controller;

import java.io.IOException;
import java.util.ArrayList;
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
import fr.demos.pms.dao.ArticleDao;
import fr.demos.pms.dao.ClientDao;
import fr.demos.pms.dao.CommandeDao;
import fr.demos.pms.dao.DAOException;
import fr.demos.pms.model.Adresse;
import fr.demos.pms.model.Article;
import fr.demos.pms.model.Client;
import fr.demos.pms.model.Commande;
import fr.demos.pms.model.ExceptionStock;
import fr.demos.pms.model.LigneCommande;
import fr.demos.pms.model.LignePanier;
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
	@Inject  @Dao
	private ArticleDao articleDao;
	
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
		//System.out.print("adr fact : "+client.getAdresseFacturation().getIdAdresse());
		//System.out.print("adr liv : "+client.getAdresseLivraison().getIdAdresse());
		
		if (client != null){
			request.setAttribute("client", client);
			RequestDispatcher rd = request
					.getRequestDispatcher("/cart-confirmation.jsp");
					rd.forward(request, response);
					return;
		}else {
			System.out.print("ici");
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(); 
		
		Client client = (Client) session.getAttribute("client");
		
		String action 		= request.getParameter("valideCmd");
		
		//System.out.print("action  " +action );
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
			
			String typePay     = request.getParameter("payment1");
			String commentaire = request.getParameter("commentaire");
			//control sur les champs
			if (nomf == null || nomf.equals("")) {
				errorMap.put("nomf", "Nom obligatoire");
			}
			if (noml == null || noml.equals("")) {
				errorMap.put("noml", "Nom obligatoire");
			}
			if (prenomf == null || prenomf.equals("")) {
				errorMap.put("prenomf", "Pr�nom obligatoire");
			}
			if (prenoml == null || prenoml.equals("")) {
				errorMap.put("prenoml", "Pr�nom obligatoire");
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
				errorMap.put("telephonel", "T�l�phone obligatoire");	
			}
			if (typePay == null || typePay.equals("")) {
				errorMap.put("payment1", "Paiement obligatoire");	
			}
			
			if(errorMap.size() != 0){
				/* on ne peut pas faire comme ca
				 * penser a charger l'objet client et le passer
				 * peupler le formulaire
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
				*/
				Adresse adrLivParam     = new Adresse(paysl, villel, adressel, codepostall, telephonel, noml,prenoml);
				Adresse adrFactParam    = new Adresse(paysf, villef, adressef, codepostalf, telephonef, nomf,prenomf);
				client.setAdresseFacturation(adrFactParam);
				client.setAdresseLivraison(adrLivParam);
				request.setAttribute("commentaire",commentaire);
				request.setAttribute("client",client);
				RequestDispatcher rd = request.getRequestDispatcher("/cart-confirmation.jsp");
				rd.forward(request, response);
				return;
			}else{
				/*
				 *  gestion des adresses Liv et facturation
				 */
				Adresse adrLivParam     = new Adresse(paysl, villel, adressel, codepostall, telephonel, noml,prenoml);
				Adresse adrFactParam    = new Adresse(paysf, villef, adressef, codepostalf, telephonef, nomf,prenomf);
				
				if ( (!adrLivParam.equals(client.getAdresseLivraison())) || (!adrFactParam.equals(client.getAdresseFacturation())) ){
					//l'une de 2 adresses sont modifiees ou les deux
					if (adrLivParam.equals(adrFactParam)){ //adr livParam == adr factParam
						System.out.print(" 2 memes adrs  changees");
						//cas du premier passage 
						adrLivParam.setIdAdresse(client.getAdresseLivraison().getIdAdresse());
						client.setAdresseFacturation(adrLivParam);
						client.setAdresseLivraison(adrLivParam);
					
					}else{  //adr liv != adr facturation
						System.out.print(" 2  adrs  changees differentes");
						adrLivParam.setIdAdresse(client.getAdresseLivraison().getIdAdresse());
						client.setAdresseLivraison(adrLivParam);
						adrFactParam.setIdAdresse(client.getAdresseFacturation().getIdAdresse());	
						client.setAdresseFacturation(adrFactParam);
					}
					
					Client clienAJour = clientDao.update(client);	
					session.setAttribute("client", clienAJour);
				}
				

				/*	TODO Verifier le stock
				 *  insert ds commande et ligne commande
				 */
				Panier panier = (Panier) session.getAttribute("panier");
				ArrayList<LigneCommande> lignesCommande = new ArrayList<LigneCommande>();
				ArrayList<LignePanier> lignesPanier = panier.getLignesPanier();
				double totalTTC = panier.getMontantTotalTTC();
				Commande cmd = new Commande (new java.util.Date(), totalTTC, commentaire, typePay, client, lignesCommande);
				if (lignesPanier != null){
					for (LignePanier lp : lignesPanier) {
						if (lp.getArticle().isInStock(lp.getQteCommande())){
							LigneCommande lc = new LigneCommande(lp.getQteCommande(), lp.getArticle(), cmd);
							try {
								lp.getArticle().retirerDuStock(lp.getQteCommande());
							} catch (ExceptionStock e) {
								request.setAttribute("msgErreurStock", "Vous avez commandé "+e.nbDemande+ " exemplaire(s). "+lp.getArticle().getNomArticle() +" : Stock non disponible, seulement " +e.etatStock);
								
								e.printStackTrace();
								RequestDispatcher rd = request
										.getRequestDispatcher("/commande-alert.jsp");
										rd.forward(request, response);
								return;	
							}
							//MAJ le stock bdd
							Article a = articleDao.update(lp.getArticle());
							lignesCommande.add(lc);	
						}else{
							request.setAttribute("msgErreurStock", lp.getArticle().getNomArticle() +" : Stock non disponible");
							RequestDispatcher rd = request
									.getRequestDispatcher("/commande-alert.jsp");
									rd.forward(request, response);
							return;	
							
						}
					}
						
					//insert bdd
					try{
						cmdDao.create(cmd);
					}catch (DAOException e){
						request.setAttribute("erreur Creation commande", e.getMessage());
						
					}
					panier.viderPanier();
					session.setAttribute("panier", panier);
					RequestDispatcher rd = request
							.getRequestDispatcher("/commande-merci.jsp");
							rd.forward(request, response);
					return;	
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

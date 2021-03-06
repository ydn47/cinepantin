
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
import fr.demos.pms.dao.ArticleDao;
import fr.demos.pms.dao.PanierDao;
import fr.demos.pms.model.Article;
import fr.demos.pms.model.ExceptionStock;
import fr.demos.pms.model.LignePanier;
import fr.demos.pms.model.Panier;

/**
 * Servlet implementation class Cart
 */
@WebServlet("/panier")
public class PanierController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Inject @Dao
	private ArticleDao daoArticle;
	private PanierDao  daoPanier;
    public PanierController() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(); 
		Panier panier = (Panier) session.getAttribute("panier");
		System.out.print("nb articles " +panier.getLignesPanier().size());
		request.setAttribute("panierContent", panier);
		RequestDispatcher rd = request
				.getRequestDispatcher("/cart.jsp");
				rd.forward(request, response);
				return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(); 
		Panier panier = (Panier) session.getAttribute("panier");
		HashMap<String, String> errorMap = new HashMap<>();
		String action 		    = request.getParameter("addCart");
		String action1 		    = request.getParameter("updateCart");
		//System.out.print("action  " +action + " action1  " +action1);
		if ((action != null) && (action.equals("Ajouter au panier")) ){//Ajouter au panier
			
			String quantite  = request.getParameter("quantity");
			String productId = request.getParameter("productId");
			//System.out.print(quantite +"   "+ productId);
			long idArticle = 0;
			int qte = 0;
			try {
				idArticle = Long.parseLong(productId);
			} catch (NumberFormatException e) {
				System.err.println("Id article non valide" + e);
				
				errorMap.put("articleID", "Article non valide");
			}
			try {
				qte = Integer.parseInt(quantite);
			} catch (NumberFormatException e) {
				System.err.println("Qte commandeé non valide" + e);
				errorMap.put("quantite", "Quantité non valide!");
			}
			
			
			Article article = null;
			if (idArticle != 0)
				article = daoArticle.findById(idArticle);
			//System.out.print(article);
			if (article != null){
				try {
					panier.ajouter(article, qte);
					
				} catch (ExceptionStock e) {
					errorMap.put("inputError", "inputError");
					errorMap.put("error", "error");
					errorMap.put("quantite", "Quantité non disponible! " + "Seulement "+ e.etatStock);
					e.printStackTrace();
				}
				//System.out.print("Panier Controller : "+panier);
				if (errorMap.size() != 0){
					request.setAttribute("erreur",errorMap);
					
					RequestDispatcher rd = request.getRequestDispatcher("/produit.jsp");
					rd.forward(request, response);
					return;
				}else{	
					//MAJ panier en session 
					session.setAttribute("panier", panier);
					request.setAttribute("succes", true);
					RequestDispatcher rd = request
							.getRequestDispatcher("/article/"+idArticle);
							rd.forward(request, response);
							return;
				}
			}
			
		}else if ((action1 != null) && (action1.equals("Modifier le panier"))){ // mettre à jour
			//// récupération des articles selectionnés
			String[] selectionArticle = request.getParameterValues("optionsCheckbox");
			//System.out.print("length" +selectionArticle.length);
			if (selectionArticle != null) {// retirer les articles selectionnés
				for (int i = 0; i < selectionArticle.length; i++) {
					System.out.print(selectionArticle[i]);
					
					long idArticle = 0;
					try {
						idArticle = Long.parseLong(selectionArticle[i]);
					} catch (NumberFormatException e) {
						System.err.println("Id article non valide" + e);
					}
					Article article = null;
					if (idArticle != 0)
						article = daoArticle.findById(idArticle);
						System.out.print(article);
					if (article != null){
						panier.retirer(article);
					}	
				}			
			}
			//gerer les quantites
			//recupererles valeurs: idee: parcoulir toutes les lignes panier et recuperer la valeur de qte qui a pour name idArticle
			//String[] qtes = request.getParameterValues("qte");
			for (LignePanier ligne : panier.getLignesPanier()) {
				String qte = request.getParameter(String.valueOf(ligne.getArticle().getIdArticle()));
				if (qte != null){
					int qteModif = 0;
					try {
						qteModif = Integer.parseInt(qte);
						//ligne.setQteCommande(Integer.parseInt(qte));
					} catch (NumberFormatException e) {
						System.err.println("qte non valide pour l'article"+ligne.getArticle().getIdArticle() + e);
					}
					try {
						panier.ajouter(ligne.getArticle(), qteModif);
						
					} catch (ExceptionStock e) {
						
						errorMap.put("_"+ligne.getArticle().getIdArticle(), "Quantité non disponible! " + "Seulement "+ e.etatStock);
						e.printStackTrace();
					}
							
				}
				
			}
			if (errorMap.size() != 0){
				request.setAttribute("erreur",errorMap);
				
			}
			session.setAttribute("panier", panier);
			System.out.print("nb articles " +panier.getLignesPanier().size());
			request.setAttribute("panierContent", panier);
			RequestDispatcher rd = request.getRequestDispatcher("/cart.jsp");
			rd.forward(request, response);
			return;
				
		}else { //dans tous les cas, reprendre le code de doGet
			doGet(request, response);
		}
	}

}



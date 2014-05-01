package fr.demos.pms.controller;

import fr.demos.pms.*;
import fr.demos.pms.annotation.Dao;
import fr.demos.pms.dao.ArticleDao;
import fr.demos.pms.dao.CategorieDao;
import fr.demos.pms.model.Article;
import fr.demos.pms.model.Categorie;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




/**
 * Servlet implementation class SaisieDvd
 */
// @WebServlet("/CrudDvd")
@WebServlet("/boutique")
// getPathInfo() /dvd/liste ; /dvd/add
public class MainFrontArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	

	@Inject
	@Dao
	private ArticleDao daoArticle;

	@Inject
	@Dao
	private CategorieDao daoCategorie;

	// si on veut utiliser DvdDaoMySQL , on cree une nouvelle annotation
	// @DaoMysql, et le met sur la classe

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MainFrontArticle() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * TODO charger la page acceuil home.jsp -menu/footer/logo - partie
	 * user/client) - zone de recherche -afficher la liste de top ventes
	 * 
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		System.out.print("doGet MAinFrontController");
		Collection<Categorie> listeCategories = daoCategorie
				.findAllCategories();
		request.setAttribute("lstCategories", listeCategories);

		// On vérifie si le bouton de recherche a été cliqué
		String action = request.getParameter("search");
		if (action != null && action.equals("Rechercher")) {
			// récupération du champ de saisie de recherche
			String searchName = request.getParameter("q").trim();
			if (searchName != null && searchName.length() > 0) {
				// récupération des catégories
				String[] selectionCateg = request
						.getParameterValues("choixCategories");
				// gérer le cas oé aucune catégorie / toutes les catégories sont
				// sélectionnées
				if (selectionCateg == null
						|| selectionCateg[0].equals("multiselect-all")) {
					Collection<Article> listeArticles = daoArticle
							.findByNom(searchName);
					request.setAttribute("lstArticles", listeArticles);
					RequestDispatcher rd = request
							.getRequestDispatcher("/index.jsp");
					rd.forward(request, response);
					return;
				}

				// Il y a une ou plusieurs catégories sélectionnées

				List<Categorie> categories = new ArrayList<>();

				try {
					for (String selCateg : selectionCateg) {
						categories.add(new Categorie(Long.parseLong(selCateg)));
					}
				} catch (NumberFormatException nbf) {
					System.err.println("Erreur de conversion de format" + nbf);
				}

				Collection<Article> listeArticles = daoArticle.findByNom(
						searchName, categories);
				// System.out.println("Valeurs query" +
				// Arrays.toString(selectionCateg));
				request.setAttribute("lstArticles", listeArticles);
				RequestDispatcher rd = request
						.getRequestDispatcher("/index.jsp");
				rd.forward(request, response);
				return;
			} else // pas de mots saisis dans la barre de recherche, on affiche
					// les articles
			{
				// affichage des articles les plus vendus
				Collection<Article> listeArticles = daoArticle.showMainArticles();
				// request.setAttribute("lstCategories", listeCategories);
				request.setAttribute("lstArticles", listeArticles);
				RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
				rd.forward(request, response);
				return;
			}
		} else { // le bouton rechercher n'a pas été cliqué, on affiche les
					// articles
			// affichage des articles les plus vendus
			Collection<Article> listeArticles = daoArticle.showMainArticles();
			// request.setAttribute("lstCategories", listeCategories);
			request.setAttribute("lstArticles", listeArticles);
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			rd.forward(request, response);
			return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/*
		 * dupliquer le code de doGet 
  			after a dispatch doPost() is called because your original request used POST method. 
		 */
		doGet(request, response);
		
	}

}

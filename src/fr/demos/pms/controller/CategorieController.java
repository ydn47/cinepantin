package fr.demos.pms.controller;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.demos.pms.annotation.Dao;
import fr.demos.pms.dao.ArticleDao;
import fr.demos.pms.dao.CategorieDao;
import fr.demos.pms.model.Article;

/**
 * Affichage des produits et de leurs nombres selon la catégorie passée en URL
 * 
 * Servlet implementation class CategorieController
 */
@WebServlet("/articles/*")
public class CategorieController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject @Dao
	private ArticleDao daoArticle;

	@Inject @Dao
	private CategorieDao daoCategorie;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CategorieController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String info = request.getPathInfo();
		
		long idCategorie = 0;
		
		try {
			idCategorie = Long.parseLong(info.substring(1));
		} catch (NumberFormatException e) {
			System.err.println("Id categorie non valide" + e);
		} finally {
			// que se passe t-il si la catégorie passée dans l'URL n'est pas valide ?
		}
		
		// Affichage des articles par catégorie
		Collection<Article> lstArticles = null;
		lstArticles = daoArticle.showArticleByCategory(idCategorie);
		if (lstArticles != null)
			request.setAttribute("articlesObject", lstArticles);
		
		// Récupération de la catégorie
		String nomCategorie = "";
		nomCategorie = daoCategorie.findNomById(idCategorie);
		request.setAttribute("nomCateg", nomCategorie);
		
		RequestDispatcher rd = request
				.getRequestDispatcher("/listings.jsp");
				rd.forward(request, response);
				return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

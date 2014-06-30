package fr.demos.pms.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

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
import fr.demos.pms.model.Categorie;
import fr.demos.pms.model.Tva;

/**
 * Servlet implementation class SerialController
 */
@WebServlet("/SerialController/*")
public class SerialController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	@Dao
	private ArticleDao daoArticle;
	@Inject
	@Dao
	private CategorieDao daoCategorie;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SerialController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// chargement des catégories
		Collection<Categorie> listeCategories = daoCategorie
				.findAllCategories();
		request.setAttribute("lstCategories", listeCategories);

		RequestDispatcher rd = request
				.getRequestDispatcher("/SerialArticle.jsp");
		rd.forward(request, response);
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("valider");
		String action2 = request.getParameter("insert");
		
		// cas du choix des catégories
		if (action != null && action.equals("Valider")) {
			int idCategorie = 0;
			// récupération de l'id de la catégorie sélectionnée
			String categorie = request.getParameter("categories");
			idCategorie = Integer.parseInt(categorie);
			request.setAttribute("idCategorie", idCategorie);
			// récupération du nom de la catégorie sélectionnée
			String nomCategorie = daoCategorie.findNomById(idCategorie);
			request.setAttribute("nomCateg", nomCategorie);

			// récupération des propriétés de la catégorie avant envoi
			Collection<String> proprietes = new ArrayList<>();
			switch (idCategorie) {
			// Les id de catégorie correspondent à ceux en base, on gère les
			// propriétés en statique (dur)
			// car elles ne sont pas enregistrées en base
			case 1: // DVD
				proprietes.add("Titre");
				proprietes.add("Réalisateur");
				break;
			case 2: // Livres
				proprietes.add("Genre");
				proprietes.add("Auteur");
				break;
			case 3: // Autre
				proprietes.add("Description");
				break;
			default:
				break;
			}
			request.setAttribute("proprietes", proprietes);
		}

		// Cas de l'insertion d'un article
		if (action2 != null && action2.equals("Inserer")) {
			// récupérer les propriétés de l'article et l'id categ
			
			int idCategorie = 0;
			try {
				idCategorie = Integer.parseInt(request.getParameter("idCategorie"));
			} catch  (NumberFormatException nbf)
			{
				System.err.println("Erreur de conversion de idCategorie" + nbf);
			}

			// Préparation de l'article
			HashMap<String, String> hm = new HashMap<>();

			switch (idCategorie) {
			case 1: // DVD
				hm.put("Titre", request.getParameter("Titre"));
				hm.put("Réalisateur", request.getParameter("Réalisateur"));
				break;
			case 2: // Livres
				hm.put("Auteur", request.getParameter("Genre"));
				hm.put("Auteur", request.getParameter("Auteur"));
				break;
			case 3: // Autre
				hm.put("Description", request.getParameter("Description"));
				break;
			default:
				break;
			}

			daoArticle.create(new Article("Test Insertion", "", "", 10.00, Tva.NORMAL, 10,
					null, new Categorie(idCategorie), null, hm));
			
		}
		
		RequestDispatcher rd = request
				.getRequestDispatcher("/InsertionArticle.jsp");
		rd.forward(request, response);
		return;

	}

}

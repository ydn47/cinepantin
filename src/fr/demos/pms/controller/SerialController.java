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
		// chargement des cat�gories
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
		
		// cas du choix des cat�gories
		if (action != null && action.equals("Valider")) {
			int idCategorie = 0;
			// r�cup�ration de l'id de la cat�gorie s�lectionn�e
			String categorie = request.getParameter("categories");
			idCategorie = Integer.parseInt(categorie);
			request.setAttribute("idCategorie", idCategorie);
			// r�cup�ration du nom de la cat�gorie s�lectionn�e
			String nomCategorie = daoCategorie.findNomById(idCategorie);
			request.setAttribute("nomCateg", nomCategorie);

			// r�cup�ration des propri�t�s de la cat�gorie avant envoi
			Collection<String> proprietes = new ArrayList<>();
			switch (idCategorie) {
			// Les id de cat�gorie correspondent � ceux en base, on g�re les
			// propri�t�s en statique (dur)
			// car elles ne sont pas enregistr�es en base
			case 1: // DVD
				proprietes.add("Titre");
				proprietes.add("R�alisateur");
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
			// r�cup�rer les propri�t�s de l'article et l'id categ
			
			int idCategorie = 0;
			try {
				idCategorie = Integer.parseInt(request.getParameter("idCategorie"));
			} catch  (NumberFormatException nbf)
			{
				System.err.println("Erreur de conversion de idCategorie" + nbf);
			}

			// Pr�paration de l'article
			HashMap<String, String> hm = new HashMap<>();

			switch (idCategorie) {
			case 1: // DVD
				hm.put("Titre", request.getParameter("Titre"));
				hm.put("R�alisateur", request.getParameter("R�alisateur"));
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

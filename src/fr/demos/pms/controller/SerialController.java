package fr.demos.pms.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

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
		// on supprime la session si elle était amorcée avant
		// HttpSession session = request.getSession();

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
		String action3 = request.getParameter("ajoutCateg");

		// Création de la session
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(1800); // 30 minutes de session

		// cas du choix des catégories
		if (action != null && action.equals("Valider")) {

			int idCategorie = 0;
			// récupération de l'id de la catégorie sélectionnée
			String categorie = request.getParameter("categories");
			
			// nouvelle catégorie sélectionnée
			String nouvCateg = request.getParameter("nouvCat");
			
			if (categorie != null && !categorie.equals(""))
				idCategorie = Integer.parseInt(categorie);

			session.setAttribute("idCategorie", idCategorie);

			// récupération du nom de la catégorie sélectionnée
			String nomCategorie = daoCategorie.findNomById(idCategorie);
			request.setAttribute("nomCateg", nomCategorie);

			// récupération des propriétés de la catégorie avant envoi
			List<String> proprietes = new ArrayList<>();
			switch (idCategorie) {
			// Les id de catégorie correspondent à ceux en base, on gère les
			// propriétés en statique (dur)
			// car elles ne sont pas enregistrées en base
			case 1: // DVD
				proprietes.add("Réalisateur");
				proprietes.add("Acteurs");
				break;
			case 2: // Livres
				proprietes.add("Genre");
				proprietes.add("Auteur");
				break;
			case 3: // Autre
				proprietes.add("Description");
				break;
			default: // Nouvelles catégories insérées, après implémentation de
						// la sérialisation
				// récupérer les propriétés selon l'id
				proprietes = daoCategorie.getProprietes(idCategorie);
				break;
				
			}
			
			if (nouvCateg != null)
			{
				proprietes = daoCategorie.getProprietes(idCategorie);
				request.setAttribute("proprietes", proprietes);
				RequestDispatcher rd = request
						.getRequestDispatcher("/InsertionCategorie.jsp");
				rd.forward(request, response);
			}
			else
			{

				request.setAttribute("proprietes", proprietes);
	
				RequestDispatcher rd = request
						.getRequestDispatcher("/InsertionArticle.jsp");
				rd.forward(request, response);
			}
			
			return;
		}

		// Cas de l'insertion d'un article
		if (action2 != null && action2.equals("Inserer")) {
			// récupérer les propriétés de l'article et l'id categ

			int idCategorie = 0;
			idCategorie = (int) session.getAttribute("idCategorie");

			// Préparation de l'article
			HashMap<String, String> hm = new HashMap<>();

			String nomArticle = request.getParameter("nomArticle");
			String descCourte = request.getParameter("descCourte");
			String descLongue = request.getParameter("descLongue");
			double prix = Double.parseDouble(request.getParameter("prix"));
			int quantite = Integer.parseInt(request.getParameter("quantite"));

			List<String> proprietes = new ArrayList<>();
			switch (idCategorie) {
			// Les id de catégorie correspondent à ceux en base, on gère les
			// propriétés en statique (dur)
			// car elles ne sont pas enregistrées en base
			case 1: // DVD
				proprietes.add("Réalisateur");
				proprietes.add("Acteurs");
				break;
			case 2: // Livres
				proprietes.add("Genre");
				proprietes.add("Auteur");
				break;
			case 3: // Autre
				proprietes.add("Description");
				break;
			default:
				proprietes = daoCategorie.getProprietes(idCategorie);
				break;
			}

			request.setAttribute("proprietes", proprietes);

			// remplissage des propriétés à sérialiser
			
			  switch (idCategorie) { 
			  case 1: // DVD hm.put("Réalisateurs",
			 request.getParameter("Réalisateur");
			 hm.put("Acteurs",
			 request.getParameter("Acteurs")); 
			 break; 
			 case 2: // Livres
			 hm.put("Auteur", request.getParameter("Genre")); 
			 hm.put("Auteur",
			 request.getParameter("Auteur")); 
			 break; case 3: // Autre
			 hm.put("Description", request.getParameter("Description"));
			 break; default: 	proprietes = daoCategorie.getProprietes(idCategorie);
				for (int index = 0; index < proprietes.size(); index++) {
					hm.put(proprietes.get(index),
							request.getParameter("prop" + index));
				 break; 
			  }
			 
//			// récupérer les catégories
//			proprietes = daoCategorie.getProprietes(idCategorie);
//			for (int index = 0; index < proprietes.size(); index++) {
//				hm.put(proprietes.get(index),
//						request.getParameter("prop" + index));
//			}
				
			 } 
				 

				daoArticle.create(new Article(nomArticle, descCourte,
						descLongue, prix, Tva.NORMAL, quantite, null,
						new Categorie(idCategorie), null, hm));

				RequestDispatcher rd = request
						.getRequestDispatcher("/InsertionArticle.jsp");
				rd.forward(request, response);
				return;

			}

			// cas de l'insertion d'une nouvelle catégorie
			if (action3 != null && action3.equals("Ajouter")) {
				String nomCateg = request.getParameter("nomCateg").trim();
				
				List<String> proprietesCategorie = new ArrayList<>();
				
				int totalChamps = Integer.parseInt(request.getParameter("totalChamps"));
				for(int index = 1; index <= totalChamps; index++)
				{
					proprietesCategorie.add(request.getParameter("prop" + index));
				}
					

				// récupérer le dernier id de catégorie et ajouter 1
				long newId = daoCategorie.getLastId() + 1;
				daoCategorie.create(new Categorie(newId, nomCateg, Categorie
						.serialize(proprietesCategorie)));

				Collection<Categorie> listeCategories = daoCategorie
						.findAllCategories();
				request.setAttribute("lstCategories", listeCategories);

				RequestDispatcher rd = request
						.getRequestDispatcher("/SerialArticle.jsp");
				rd.forward(request, response);
			}
		}
	}

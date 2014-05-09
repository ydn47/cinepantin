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

	@Inject @Dao
	private ArticleDao daoArticle;
	@Inject @Dao
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

		// En fonction de l'article pr�cis�, afficher une liste des propri�t�s
		String categorie = request.getPathInfo().substring(1).toUpperCase();
		boolean urlCategorie = false;
		
		if (categorie.length() > 0) {
			Collection<String> serialProprietes = new ArrayList<>();

			switch (categorie) {
			case "DVD":
				serialProprietes.add("Titre");
				serialProprietes.add("R�alisateurs");
				break;
			case "LIVRES":
				serialProprietes.add("Auteur");
				serialProprietes.add("Genre");
				break;
			default:
				serialProprietes.add("Description");
				break;
			};
			urlCategorie = true;		
			request.setAttribute("proprietes", serialProprietes);
		}
		
		request.setAttribute("urlCategorie", urlCategorie);
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
		Collection<Categorie> listeCategories = daoCategorie
				.findAllCategories();
		request.setAttribute("lstCategories", listeCategories);

		String nomArticle = "";
		String shortDesc = "";
		String longDesc = "";
		String prixUnitaire = "";
		// String tva = "";
		String qteStock = "";
		String nomFichierImage = "";
		long idCategorie = 0;

		String action = request.getParameter("valider");

		if (action != null && action.equals("valider")) {
			nomArticle = request.getParameter("nomArticle").trim();
			shortDesc = request.getParameter("shortDesc").trim();
			longDesc = request.getParameter("longDesc").trim();
			//titre = request.getParameter("titre").trim();
			//realisateurs = request.getParameter("realisateurs").trim();
			prixUnitaire = request.getParameter("prixUnit").trim();
			double prixUnit = Double.parseDouble(prixUnitaire);
			// tva = request.getParameter("listeCateg");
			qteStock = request.getParameter("qteStock").trim();
			int qte_stock = Integer.parseInt(qteStock);

			// R�cup�ration du fichier image
			// nomFichierImage = request.getParameter("file");
			// System.out.println("Fichier " + nomFichierImage);
			// Part filePart = request.getPart("file"); // Retrieves <input
			// type="file" name="file">
			// String filename = filePart.getName();
			// System.out.println(filename);

			
			String categorie = request.getPathInfo();
			Categorie cat = null; 

			// la cat�gorie est pass�e dans l'URL
			if (categorie != null && categorie.length() > 0) {
				categorie = categorie.substring(1).toUpperCase();
				System.out.println("CHECK: " + categorie);
				idCategorie = daoCategorie.findIdByNom(categorie);
			}
			else // la cat�gorie n'est pas pass�e
			{
				categorie = request.getParameter("listeCateg");
				idCategorie = Long.parseLong(categorie);
			}
			cat = new Categorie(idCategorie);

			HashMap<String, String> hm = new HashMap<>();
			// r�cup�ration des propri�t�s d'un article
			//hm.put("titre", titre);
			//hm.put("realisateurs", realisateurs);

			daoArticle.create(new Article(nomArticle, shortDesc, longDesc,
					prixUnit, Tva.NORMAL, qte_stock, null, cat, null, hm));

			RequestDispatcher rd = request
					.getRequestDispatcher("/SerialArticle.jsp");
			rd.forward(request, response);
			return;
		}
	}
}

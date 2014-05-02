package fr.demos.pms.controller;

import java.io.IOException;
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
@WebServlet("/SerialController")
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// chargement des catégories
		Collection<Categorie> listeCategories = daoCategorie
				.findAllCategories();
		request.setAttribute("lstCategories", listeCategories);
		
		String action = request.getParameter("afficher");
		if (action != null && action.equals("afficher")) {
			Article a = daoArticle.findById(6);
			System.out.println(a.deserialize(a.getSerialProprietes()));
//			request.setAttribute("lstCategories", listeCategories);
			RequestDispatcher rd = request
					.getRequestDispatcher("/SerialArticle.jsp");
			rd.forward(request, response);
			return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Collection<Categorie> listeCategories = daoCategorie
				.findAllCategories();
		request.setAttribute("lstCategories", listeCategories);
		
		String nomArticle = "";
		String shortDesc = "";
		String longDesc = "";
		String prixUnitaire = "";
		//String tva = "";
		String titre = "";
		String realisateurs = "";
		String qteStock = "";
		String[] categories = null;
		// encode les données saisies en UTF-8 avant de les envoyer en base
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String action = request.getParameter("valider");
		
		if (action != null && action.equals("valider")) 
		{
			nomArticle = request.getParameter("nomArticle").trim();
			shortDesc  = request.getParameter("shortDesc").trim();
			longDesc   = request.getParameter("longDesc").trim();
			titre = request.getParameter("titre").trim();
			realisateurs = request.getParameter("realisateurs").trim();
			prixUnitaire = request.getParameter("prixUnit").trim();
			double prixUnit = Double.parseDouble(prixUnitaire);
			//tva = request.getParameter("listeCateg");
			qteStock = request.getParameter("qteStock").trim();
			int qte_stock = Integer.parseInt(qteStock);
			
			//categories = request.getParameterValues("listeCateg");
			System.out.println(categories);
			
			HashMap<String, String> hm = new HashMap<>();
			hm.put("titre", titre);
			hm.put("realisateurs", realisateurs);
			daoArticle.create(new Article(nomArticle, shortDesc, longDesc, prixUnit, Tva.NORMAL, qte_stock, null, null, null, hm));
			
			RequestDispatcher rd = request
					.getRequestDispatcher("/SerialArticle.jsp");
			rd.forward(request, response);
			return;
		}
	}

}

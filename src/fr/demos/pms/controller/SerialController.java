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

import fr.demos.pms.annotation.Dao;
import fr.demos.pms.dao.ArticleDao;
import fr.demos.pms.model.Article;
import fr.demos.pms.model.Tva;

/**
 * Servlet implementation class SerialController
 */
@WebServlet("/SerialController")
public class SerialController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Inject @Dao
	private ArticleDao daoArticle; 
	
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
		// TODO Auto-generated method stub
		String action = request.getParameter("afficher");
		if (action != null && action.equals("afficher")) {
			Article a = daoArticle.findById(6);
			System.out.println(a.deserialize(a.getSerialProprietes()));
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
		// TODO Auto-generated method stub
		String titre = "";
		String realisateurs = "";
		String action = request.getParameter("valider");
		if (action != null && action.equals("valider")) 
		{
			titre = request.getParameter("titre").trim();
			realisateurs = request.getParameter("realisateurs").trim();
			HashMap<String, String> hm = new HashMap<>();
			hm.put("titre", titre);
			hm.put("realisateurs", realisateurs);
			daoArticle.create(new Article(6,"NomTest","aa","bb", 0.0, Tva.NORMAL, 10, null, null, null, hm));
			
			RequestDispatcher rd = request
					.getRequestDispatcher("/SerialArticle.jsp");
			rd.forward(request, response);
			return;
		}
	}

}

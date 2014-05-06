package fr.demos.pms.controller;

import java.io.IOException;

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
import fr.demos.pms.model.Article;

/**
 * Servlet implementation class Article
 */
@WebServlet("/article/*")
public class FrontArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Inject @Dao
	private ArticleDao daoArticle;
    public FrontArticle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String info = request.getPathInfo();  
		
		long idArticle = 0;
		
		try {
			idArticle = Long.parseLong(info.substring(1));
		} catch (NumberFormatException e) {
			System.err.println("Id article non valide" + e);
		}

		Article article = null;
		article = daoArticle.findById(idArticle);
		System.out.print(article);
		if (article != null)
			request.setAttribute("articleObject", article);
		
		RequestDispatcher rd = request
				.getRequestDispatcher("/produit.jsp");
				rd.forward(request, response);
				return;
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}

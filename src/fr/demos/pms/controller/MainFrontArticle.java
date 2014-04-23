package fr.demos.pms.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;









import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;














import fr.demos.pms.annotation.Dao;
import fr.demos.pms.dao.ClientDao;
import fr.demos.pms.model.Client;

/**
 * Servlet implementation class SaisieDvd
 */
//@WebServlet("/CrudDvd")
@WebServlet("/boutique")   //getPathInfo()  /dvd/liste ; /dvd/add
public class MainFrontArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//@Inject  @Dao  //on cree nos propres annotations
	private ClientDao daoDvd;
	//private DvdDaoJPA daoDvd;
	
	//si on veut utiliser DvdDaoMySQL , on cree une nouvelle annotation @DaoMysql, et le met sur la classe
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainFrontArticle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * TODO 
	 * charger la page acceuil home.jsp 
	-menu/footer/logo
	- partie user/client)
	- zone de recherche
	 -afficher la liste de top ventes
	 * 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			
			
			
		
			RequestDispatcher rd = request
					.getRequestDispatcher("/Main.jsp");
					rd.forward(request, response);
			return;		
	}		
		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	

}

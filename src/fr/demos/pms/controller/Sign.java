
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
import javax.servlet.http.HttpSession;

import fr.demos.pms.annotation.Dao;
import fr.demos.pms.dao.ClientDao;
import fr.demos.pms.dao.DAOException;
import fr.demos.pms.dao.PanierDao;
import fr.demos.pms.model.Adresse;
import fr.demos.pms.model.Client;




/**
 * Servlet implementation class Signin
 */
@WebServlet("/sign/*")
public class Sign extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject  @Dao
	private ClientDao clientDao;  
	private PanierDao panierDao;    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sign() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.print("doGet Sign");
		String sb = request.getPathInfo();
		System.out.println("sb = " +sb);
		String[] myArray = sb.split("/");
		String info = myArray[0];
		System.out.println("info =  " +info);
		String origine = "";
		if (myArray.length == 2 )
			origine  = myArray[1];
		else if (myArray.length > 2 )
			origine  = myArray[1]+"/"+myArray[2];
		
		System.out.println("origine " +origine);
		request.setAttribute("origine",origine);
		RequestDispatcher rd = request.getRequestDispatcher("/my_account.jsp");
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


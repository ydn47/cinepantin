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
import fr.demos.pms.dao.ClientDao;

/**
 * Servlet implementation class Sigout
 */
@WebServlet("/sigout/*")
public class Sigout extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject  @Dao
	private ClientDao clientDao;    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sigout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.print("doGet Singout");
		HttpSession session = request.getSession(); 
		String sb = request.getPathInfo();
		System.out.println("sb " +sb);
		String[] myArray = sb.split("/");
		String info = myArray[0];
		System.out.println("length " +myArray.length);
		String origine ="";
		if (myArray.length == 2 )
			origine  = myArray[1];
		else if (myArray.length > 2 )
			origine  = myArray[1]+"/"+myArray[2];
		
		System.out.println("origine " +origine);
	 //if ((info != null) && (info.equals("/disconnect")) ){ //se deconnecter
		System.out.print ("do Get disconnect");
		session.setAttribute("client", null);
		RequestDispatcher rd = request
				.getRequestDispatcher("/"+origine);
				rd.forward(request, response);
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

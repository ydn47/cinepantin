package fr.demos.pms.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.demos.pms.model.Client;
import fr.demos.pms.model.Panier;

/**
 * Servlet implementation class CommandeController
 */
@WebServlet("/commande")
public class CommandeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommandeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(); 
		Client client = (Client) session.getAttribute("client");
		System.out.print("adr fact : "+client.getAdresseFacturation().getIdAdresse());
		System.out.print("adr liv : "+client.getAdresseLivraison().getIdAdresse());
		
		if (client != null){
			request.setAttribute("client", client);
		}
		RequestDispatcher rd = request
				.getRequestDispatcher("/cart-confirmation.jsp");
				rd.forward(request, response);
				return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(); 
		Panier panier = (Panier) session.getAttribute("panier");
		
		String action 		= request.getParameter("valideCmd");
		
		System.out.print("action  " +action );
		if ((action != null) && (action.equals("Valider")) ){//valider la commader
			//recuperer tous champs du form
			//update
		}
	}	
}

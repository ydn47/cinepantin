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
import fr.demos.pms.dao.ClientDao;
import fr.demos.pms.dao.ContactDao;
import fr.demos.pms.dao.DAOException;
import fr.demos.pms.model.Adresse;
import fr.demos.pms.model.Client;
import fr.demos.pms.model.Contact;
import fr.demos.pms.util.SendExternalEmail;

/**
 * Servlet implementation class contactController
 */
@WebServlet("/contact")
public class ContactController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject  @Dao
	private ContactDao contactDao;    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request
				.getRequestDispatcher("/contact.jsp");
				rd.forward(request, response);
				return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("envoyer");
		HashMap<String, String> errorMap = new HashMap<>();
		
		String nom      = "";
		String email    = "";
		String demande = "";
		
		if (action != null && action.equals("Envoyer")) {
			
			nom    = request.getParameter("nom").trim();
			email  = request.getParameter("email").trim();
			demande = request.getParameter("demande").trim();

			
			if (nom == null || nom.equals("")) {
				errorMap.put("nom", "Nom obligatoire");
			}
			
			if (email == null || email.equals("")) {
				errorMap.put("email", "Email (Login) obligatoire");
			}
			
			
			if (demande == null || demande.equals("")) {
				errorMap.put("demande", "Contenu obligatoire");	
			}
			

			if(errorMap.size() != 0){
				request.setAttribute("nom",nom);
				request.setAttribute("demande",demande);
				request.setAttribute("email",email);
				request.setAttribute("erreur",errorMap);
		
				RequestDispatcher rd = request.getRequestDispatcher("/contact.jsp");
				rd.forward(request, response);
				return;
			}else{
		
				Contact contact = new Contact(demande, nom, email);
				SendExternalEmail se = new SendExternalEmail();
				se.setSubject("contact");
				se.setMessage(demande);
				se.setSender(email);
				se.setReceiver("wiem.marzouk@gmail.com");
				se.sendEmail();
				/*
				try{
					contactDao.create(contact);
				}catch (DAOException e){
					request.setAttribute("erreur Creation contact DAO", e.getMessage());
					
				}
				*/
				RequestDispatcher rd = request
						.getRequestDispatcher("/boutique");
						rd.forward(request, response);
				return;	
				
		}
		
	 }
	}

}

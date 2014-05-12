package hei.projetiti.controllers;

import hei.projetiti.metier.Manager;
import hei.projetiti.model.Adherent;
import hei.projetiti.model.Paiement;

import java.io.IOException;
import java.nio.channels.SeekableByteChannel;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ConnexionServlet extends HttpServlet{
	
	private static final long serialVersionUID = -5637709157426990297L;
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if(request.getParameter("logout") != null){
       	 HttpSession session = request.getSession(true); 
       	 session.invalidate();
       }
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/pages/connexion.jsp");
		view.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String mail = request.getParameter("mail");
		String password = request.getParameter("password");
		try {
			if (Manager.getInstance().adherentExiste(mail, Manager.getInstance().crypterPassword(password))) {
				HttpSession session = request.getSession(true);
				String licence = Manager.getInstance().getLicenceAdherent(mail, Manager.getInstance().crypterPassword(password));
				Adherent adherent = Manager.getInstance().getAdherent(licence);
				session.setAttribute("nom", adherent.getNom());
				session.setAttribute("prenom", adherent.getPrenom());
				session.setAttribute("licence", licence);
				session.setAttribute("adherentConnecte", new Adherent(mail, Manager.getInstance().crypterPassword(password)));
				session.setAttribute("statut",Manager.getInstance().getAdherent(licence).getStatut());
				redirectIndex(response);
			}
			else
			{
				request.setAttribute("loginError", "Votre login n'est pas bon. Veuillez rentrer un utilisateur et un mot de passe valides.");
			    RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/pages/connexion.jsp");
				view.forward(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Calendar cal = GregorianCalendar.getInstance();
		if (cal.getTime().getDate()==1)
		{
			Manager.getInstance().afficherNotification();
		}
	
	
	}
	
	private void redirectIndex(HttpServletResponse resp) throws IOException {
	    resp.sendRedirect(getServletContext().getContextPath()+"/index");
	}
}

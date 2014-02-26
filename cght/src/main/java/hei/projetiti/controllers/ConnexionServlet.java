package hei.projetiti.controllers;

import hei.projetiti.metier.Manager;
import hei.projetiti.model.Adherent;

import java.io.IOException;
import java.nio.channels.SeekableByteChannel;
import java.util.ArrayList;
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
	
	public void init() throws ServletException {
		super.init();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if(request.getParameter("logout") != null){
       	 HttpSession session = request.getSession(true); 
       	 session.invalidate();
       }
		
		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/connexion.jsp");
		view.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String loginRecup = request.getParameter("login");
		String passwordRecup = request.getParameter("password");
		if (Manager.getInstance().adherentExiste(loginRecup, passwordRecup)) {
			HttpSession session = request.getSession(true);
			session.setAttribute("nom", loginRecup);
			session.setAttribute("prenom", passwordRecup);
			session.setAttribute("adherentConnecte", new Adherent(loginRecup, passwordRecup));
			redirectIndex(response);
		}
		else
		{
			request.setAttribute("loginError", "Votre login n'est pas bon. Veuillez rentrer un utilisateur et un mot de passe valide.");
		    RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/connexion.jsp");
			view.forward(request, response);
		}
	}
	
	private void redirectIndex(HttpServletResponse resp) throws IOException {
	    resp.sendRedirect(getServletContext().getContextPath()+"/index");
	}
}

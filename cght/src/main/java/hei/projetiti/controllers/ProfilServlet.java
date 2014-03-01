package hei.projetiti.controllers;

import hei.projetiti.metier.Manager;
import hei.projetiti.model.Adherent;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ProfilServlet extends HttpServlet{

	private static final long serialVersionUID = -3589939413818501308L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		String licence= (String) session.getAttribute("licence");
		Adherent adherent = Manager.getInstance().getAdherent(licence);
		request.setAttribute("adherent", adherent);


		RequestDispatcher view = request.getRequestDispatcher("WEB-INF/pages/profil.jsp");
		view.forward(request, response);
	}
}

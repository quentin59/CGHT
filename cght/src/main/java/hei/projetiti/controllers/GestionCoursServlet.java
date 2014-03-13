package hei.projetiti.controllers;

import hei.projetiti.metier.Manager;
import hei.projetiti.model.Adherent;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GestionCoursServlet extends HttpServlet{

	private static final long serialVersionUID = 6682297944195128797L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<Adherent> listeAdherents = Manager.getInstance().listerAdherents();
		request.setAttribute("adherents", listeAdherents);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/pages/gestionCours.jsp");
		view.forward(request, response);
	}
}

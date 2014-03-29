package hei.projetiti.controllers;

import hei.projetiti.metier.Manager;
import hei.projetiti.model.Adherent;
import hei.projetiti.model.Cours;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ModificationAdherentServlet extends HttpServlet {

	private static final long serialVersionUID = 5033062409008471038L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String numLicence = request.getParameter("licence");
		Adherent adherent = Manager.getInstance().getAdherent(numLicence);
		request.setAttribute("adherent", adherent);
		
		List<Cours> listeCours = Manager.getInstance().listerCoursparAdherent(numLicence);
		request.setAttribute("cours", listeCours);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/pages/modifAdherent.jsp");
		view.forward(request, response);
	}
}

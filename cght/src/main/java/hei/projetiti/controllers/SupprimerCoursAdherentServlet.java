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

public class SupprimerCoursAdherentServlet extends HttpServlet{
	
	private static final long serialVersionUID = 6682297944195128797L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String numLicence = request.getParameter("licence");
		List<Cours> listeCours = Manager.getInstance().listerCours();
		for (int i=0;i<listeCours.size();i++) {
			if (request.getParameter("supprimercours"+listeCours.get(i).getIdCours())!=null)
			{
				Manager.getInstance().supprimerCoursAdherent(listeCours.get(i).getIdCours(), numLicence);
			}
		}
		
		List<Cours> listCours = Manager.getInstance().listerCoursparAdherent(numLicence);
		request.setAttribute("cours", listCours);
		
		Adherent adherent = Manager.getInstance().getAdherent(numLicence);
		request.setAttribute("adherent", adherent);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/pages/modifAdherent.jsp");
		view.forward(request, response);
		
	}
	
}
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

public class GestionComptesServlet extends HttpServlet{

	private static final long serialVersionUID = 6682297944195128797L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<Adherent> listeAdherents = Manager.getInstance().listerAdherents();
		request.setAttribute("adherents", listeAdherents);
		
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/pages/gestionComptes.jsp");
		view.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<Adherent> listeAdherents = Manager.getInstance().listerAdherents();
		
		int i;
		for (i=0;i<listeAdherents.size();i++) {
			if (request.getParameter("supprimer"+listeAdherents.get(i).getLicence())!=null)
			{
				Manager.getInstance().supprimerAdherent(listeAdherents.get(i));
			}
		}
		
		doGet(request, response);
	}
}

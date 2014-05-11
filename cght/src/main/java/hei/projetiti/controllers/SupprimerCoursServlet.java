package hei.projetiti.controllers;

import hei.projetiti.metier.Manager;
import hei.projetiti.model.Cours;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SupprimerCoursServlet extends HttpServlet{
	
	private static final long serialVersionUID = 6682297944195128797L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		List<Cours> listeCours = Manager.getInstance().listerCours();
		for (int i=0;i<listeCours.size();i++) {
			if (request.getParameter("supprimercours"+listeCours.get(i).getIdCours())!=null)
			{
				Manager.getInstance().supprimerCours(listeCours.get(i).getIdCours());
			}
		}
		
		GestionCoursServlet servlet = new GestionCoursServlet();
		servlet.doGet(request, response);
		
	}
	
}
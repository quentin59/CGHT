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

public class GestionCoursServlet extends HttpServlet{

	private static final long serialVersionUID = 6682297944195128797L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<Cours> listeCours = Manager.getInstance().listerCours();
		request.setAttribute("cours", listeCours);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/pages/gestionCours.jsp");
		view.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String jourCours = request.getParameter("jour");
		Integer heureDebut = Integer.parseInt(request.getParameter("heuredebut"));
		Integer minuteDebut = Integer.parseInt(request.getParameter("minutedebut"));
		Integer heureFin = Integer.parseInt(request.getParameter("heurefin"));
		Integer minuteFin = Integer.parseInt(request.getParameter("minutefin"));
		
		System.out.println(jourCours+ heureDebut+ minuteDebut+ heureFin+ minuteFin);
		Cours nouveaucours = new Cours(null, jourCours, heureDebut, minuteDebut, heureFin, minuteFin);
		Manager.getInstance().ajouterCours(nouveaucours);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/pages/gestionCours.jsp");
		view.forward(request, response);
	}
}

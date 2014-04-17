package hei.projetiti.controllers;

import hei.projetiti.metier.Manager;
import hei.projetiti.model.Adherent;
import hei.projetiti.model.Cours;
import hei.projetiti.model.Paiement;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ProfilServlet extends HttpServlet{

	private static final long serialVersionUID = -3589939413818501308L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(true);
		String licence= (String) session.getAttribute("licence");
		String adresse = request.getParameter("adresse");
		String codePostal = request.getParameter("codepostal");
		String ville = request.getParameter("ville");
		String telephone = request.getParameter("telfixe");
		String portable = request.getParameter("telmobile");
		
		
		
		Adherent adherent = new Adherent(licence, adresse, codePostal, ville, telephone, portable);
		Manager.getInstance().mettreAJourCoordonneesAdherent(adherent);
		
		Adherent adherentComplet = Manager.getInstance().getAdherent(licence);
		request.setAttribute("adherent", adherentComplet);
		
		List<Paiement> listePaiements = Manager.getInstance().listerPaiements(adherent);
		request.setAttribute("paiements", listePaiements);
		
		List<Cours> listeCours = Manager.getInstance().listerCoursparAdherent(licence);
		request.setAttribute("cours", listeCours);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/pages/profil.jsp");
		view.forward(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		String licence= (String) session.getAttribute("licence");
		Adherent adherent = Manager.getInstance().getAdherent(licence);
		request.setAttribute("adherent", adherent);

		List<Paiement> listePaiements = Manager.getInstance().listerPaiements(adherent);
		request.setAttribute("paiements", listePaiements);
		
		List<Cours> listeCours = Manager.getInstance().listerCoursparAdherent(licence);
		request.setAttribute("cours", listeCours);

		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/pages/profil.jsp");
		view.forward(request, response);
	}
}

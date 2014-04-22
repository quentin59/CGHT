package hei.projetiti.controllers;

import hei.projetiti.metier.Manager;
import hei.projetiti.model.Annonce;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class PosterAnnonceServlet extends HttpServlet {

	private static final long serialVersionUID = -8830849795476708949L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		if(request.getParameter("id") != null){
			Annonce annonce = Manager.getInstance().getAnnonce(Integer.parseInt(request.getParameter("id")));
			request.setAttribute("titre", annonce.getTitre());
			request.setAttribute("contenu", annonce.getContenu());
			request.setAttribute("categorie", annonce.getCategorie());
			request.setAttribute("coordonnees", annonce.getCoordonnees());
			request.setAttribute("prix", annonce.getPrix());
			request.setAttribute("id", request.getParameter("id"));
		}
		else
		{
			request.setAttribute("id",0);
		}
		
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/pages/poster-annonce.jsp");
		view.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		String texte = request.getParameter("texte");
		String titre = request.getParameter("titre");
		Calendar cal = GregorianCalendar.getInstance();
		HttpSession session = request.getSession(true);
		String licence= (String) session.getAttribute("licence");
		String categorie = request.getParameter("categorie");
		String coordonnees = request.getParameter("coordonnees");
		Float prix=(float) 0;
		if (categorie.equals("Vente de matériel"))
		{
			prix = (float) Integer.parseInt(request.getParameter("prix"));
		}
		
		Annonce annonce = new Annonce(null, titre, texte,coordonnees, licence, cal.getTime(), categorie, prix);
		Manager.getInstance().ajouterAnnonce(annonce);
		
		if(request.getParameter("id") != null){
			Manager.getInstance().supprimerAnnonce(Integer.parseInt(request.getParameter("id")));
		}
		
		AnnoncesServlet page = new AnnoncesServlet();
		page.doGet(request, response);
		
		
		
	}

}

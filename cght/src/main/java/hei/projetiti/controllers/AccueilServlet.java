package hei.projetiti.controllers;

import hei.projetiti.metier.Manager;
import hei.projetiti.model.Actualite;
import hei.projetiti.model.Adherent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AccueilServlet extends HttpServlet {

	private static final long serialVersionUID = -8830849795476708949L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		if(request.getParameter("supprimer") != null){
			Manager.getInstance().supprimerActualite(Integer.parseInt(request.getParameter("supprimer")));
		}
		
		
		List<Actualite> listeActualites;
		List<Actualite> listeTotaleActualites = Manager.getInstance().listerActualites();
		if (request.getParameter("annee") == null && request.getParameter("mois") == null)
		{
			request.setAttribute("actualites", listeTotaleActualites);
		}
		else if (request.getParameter("mois") == null)
		{	
			listeActualites = Manager.getInstance().listerActualites(request.getParameter("annee"));
			request.setAttribute("actualites", listeActualites);
		}
		else
		{
			listeActualites = Manager.getInstance().listerActualites(request.getParameter("annee"), Integer.parseInt(request.getParameter("mois")));
			request.setAttribute("actualites", listeActualites);
		}
		
		List<Integer> anneeListe = new ArrayList<Integer>();
		List<List<String>> moisParAn= new ArrayList<List<String>>();
		List<Integer> moisParAnEnChiffre= new ArrayList<Integer>();
		int compteur=0;
		for (Actualite actualite : listeTotaleActualites) {
			
			int annee = actualite.getDateActualite().getYear()+1900;
			int mois = actualite.getDateActualite().getMonth()+1;
			if (!anneeListe.contains(annee))
			{
				anneeListe.add(annee);
				moisParAn.add(new ArrayList<String>());
				compteur++;
			}
			if (!moisParAn.get(compteur-1).contains(actualite.moisLettre(mois)))
			{
				moisParAn.get(compteur-1).add(actualite.moisLettre(mois));
				moisParAnEnChiffre.add(mois);
			}
		}
		
		
		request.setAttribute("mois", moisParAn);
		request.setAttribute("annees", anneeListe);
		request.setAttribute("moisChiffre", moisParAnEnChiffre);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/pages/index.jsp");
		view.forward(request, response);
	}

}

package hei.projetiti.controllers;

import hei.projetiti.metier.Manager;
import hei.projetiti.model.Actualite;
import hei.projetiti.model.Adherent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

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
		
		List<Actualite> listeActualites = Manager.getInstance().listerActualites();
		request.setAttribute("actualites", listeActualites);
		List<Integer> anneeListe = new ArrayList<Integer>();
		List<List<String>> moisParAn= new ArrayList<List<String>>();
		int compteur=0;
		for (Actualite actualite : listeActualites) {
			
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
			}
		}
		
		request.setAttribute("mois", moisParAn);
		request.setAttribute("annees", anneeListe);
		
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/pages/index.jsp");
		view.forward(request, response);
	}

}

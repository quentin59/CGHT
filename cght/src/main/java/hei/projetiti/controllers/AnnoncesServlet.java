package hei.projetiti.controllers;

import hei.projetiti.metier.Manager;
import hei.projetiti.model.Actualite;
import hei.projetiti.model.Annonce;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.Size2DSyntax;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AnnoncesServlet extends HttpServlet{

	private static final long serialVersionUID = 2253074087570953163L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<Annonce> listeAnnonces = Manager.getInstance().listerAnnonces();
		request.setAttribute("annonces", listeAnnonces);
		List<Integer> anneeListe = new ArrayList<Integer>();
		List<List<String>> moisParAn= new ArrayList<List<String>>();
		int compteur=0;
		for (Annonce annonce : listeAnnonces) {
			
			int annee = annonce.getDateAnnonce().getYear()+1900;
			int mois = annonce.getDateAnnonce().getMonth()+1;
			if (!anneeListe.contains(annee))
			{
				anneeListe.add(annee);
				moisParAn.add(new ArrayList<String>());
				compteur++;
			}
			if (!moisParAn.get(compteur-1).contains(annonce.moisLettre(mois)))
			{
				moisParAn.get(compteur-1).add(annonce.moisLettre(mois));
			}
		}
		
		request.setAttribute("mois", moisParAn);
		request.setAttribute("annees", anneeListe);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/pages/annonces.jsp");
		view.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		if(req.getParameter("pageSelectionnee").equals("index"))
		{
			
		}
		
		
		super.doPost(req, resp);
	}
	
	
	
}

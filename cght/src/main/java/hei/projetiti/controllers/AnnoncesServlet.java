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
		
		
		
		if(request.getParameter("supprimer") != null){
			Manager.getInstance().supprimerAnnonce(Integer.parseInt(request.getParameter("supprimer")));
		}
		
		
		
			
		
		
		
		List<Annonce> listeAnnonces;
		List<Annonce> listeTotaleAnnonces = Manager.getInstance().listerAnnonces();
		if (request.getParameter("annee") == null && request.getParameter("mois") == null)
		{
			request.setAttribute("annonces", listeTotaleAnnonces);
		}
		else if (request.getParameter("mois") == null)
		{	
			listeAnnonces = Manager.getInstance().listerAnnonces(request.getParameter("annee"));
			request.setAttribute("annonces", listeAnnonces);
		}
		else
		{
			listeAnnonces = Manager.getInstance().listerAnnonces(request.getParameter("annee"), Integer.parseInt(request.getParameter("mois")));
			request.setAttribute("annonces", listeAnnonces);
		}
		
		
		List<Integer> anneeListe = new ArrayList<Integer>();
		List<List<String>> moisParAn= new ArrayList<List<String>>();
		List<Integer> moisParAnEnChiffre= new ArrayList<Integer>();
		int compteur=0;
		for (Annonce annonce : listeTotaleAnnonces) {
			
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
				moisParAnEnChiffre.add(mois);
			}
		}
		
		request.setAttribute("mois", moisParAn);
		request.setAttribute("annees", anneeListe);
		request.setAttribute("moisChiffre", moisParAnEnChiffre);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/pages/annonces.jsp");
		view.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String categorie = request.getParameter("categorie");
		if (!categorie.equals("toute"))
		{
			System.out.println("non nul");
			List<Annonce> listeAnnonces = Manager.getInstance().listerAnnoncesParCategorie(categorie);
			request.setAttribute("annonces", listeAnnonces);
		}
		else
		{
			List<Annonce> listeAnnonces = Manager.getInstance().listerAnnonces();
			request.setAttribute("annonces", listeAnnonces);
		}
		request.setAttribute("categorie", request.getParameter("categorie"));
		
		List<Annonce> listeTotaleAnnonces = Manager.getInstance().listerAnnonces();
		List<Integer> anneeListe = new ArrayList<Integer>();
		List<List<String>> moisParAn= new ArrayList<List<String>>();
		List<Integer> moisParAnEnChiffre= new ArrayList<Integer>();
		int compteur=0;
		for (Annonce annonce : listeTotaleAnnonces) {
			
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
				moisParAnEnChiffre.add(mois);
			}
		}
		
		request.setAttribute("mois", moisParAn);
		request.setAttribute("annees", anneeListe);
		request.setAttribute("moisChiffre", moisParAnEnChiffre);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/pages/annonces.jsp");
		view.forward(request, response);
		
	}
}
	
	
	


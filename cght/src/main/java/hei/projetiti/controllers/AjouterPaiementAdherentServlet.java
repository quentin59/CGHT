package hei.projetiti.controllers;

import hei.projetiti.metier.Manager;
import hei.projetiti.model.Adherent;
import hei.projetiti.model.Cours;
import hei.projetiti.model.Paiement;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AjouterPaiementAdherentServlet extends HttpServlet{
	
	private static final long serialVersionUID = 6682297944195128797L;
	private static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String numLicence = request.getParameter("licence");
		Adherent adherent = Manager.getInstance().getAdherent(numLicence);
		List<Paiement> listePaiements = Manager.getInstance().listerPaiements(adherent);
		for (int i=0;i<listePaiements.size();i++) {
			if (request.getParameter("encaisserpaiement"+listePaiements.get(i).getIdPaiement())!=null)
			{
				Manager.getInstance().encaisserPaiement(listePaiements.get(i).getIdPaiement());
			}
			else
			{
				Manager.getInstance().nePasEncaisserPaiement(listePaiements.get(i).getIdPaiement());
			}
		}
		
		int compteurCheque = Integer.parseInt(request.getParameter("compteurCheque"));
		for (int i=1;i<=compteurCheque;i++)
		{
			
			boolean payer;
			if (request.getParameter("payer"+i)!=null)
			{
				payer=true;
			}
			else
			{
				payer=false;
			}
			String banque = request.getParameter("banque"+i);
			String numCheque = request.getParameter("numCheque"+i);
			float montant = Integer.parseInt(request.getParameter("montant"+i));
			
			
			Date echeance = null;
			try {
				echeance = dateFormat.parse(request.getParameter("echeance"+i));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			
			Paiement paiement = new Paiement(payer,banque,numCheque,echeance,montant);
			Manager.getInstance().ajouterPaiement(adherent, paiement);
		}
		
		List<Cours> listCours = Manager.getInstance().listerCoursparAdherent(numLicence);
		request.setAttribute("cours", listCours);
		
		request.setAttribute("adherent", adherent);
		
		List<Paiement> listPaiements = Manager.getInstance().listerPaiements(adherent);
		request.setAttribute("paiements", listPaiements);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/pages/modifAdherent.jsp");
		view.forward(request, response);
		
	}
	
}
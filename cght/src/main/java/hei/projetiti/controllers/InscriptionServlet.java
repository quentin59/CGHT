package hei.projetiti.controllers;

import hei.projetiti.metier.Manager;
import hei.projetiti.model.Adherent;
import hei.projetiti.model.Cours;
import hei.projetiti.model.Mail;
import hei.projetiti.model.Paiement;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InscriptionServlet extends HttpServlet {

	private static final long serialVersionUID = -8830849795476708949L;
	private static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<String> listeJoursCours = Manager.getInstance().listerJoursCours();
		request.setAttribute("jourscours", listeJoursCours);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/pages/inscription.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		
		Integer jour = Integer.parseInt(request.getParameter("jour"));
		Integer mois = Integer.parseInt(request.getParameter("mois"));
		Integer annee = Integer.parseInt(request.getParameter("annee"));
		Calendar cal = GregorianCalendar.getInstance();
		cal.set(Calendar.YEAR, annee);
		cal.set(Calendar.MONTH, mois-1);
		cal.set(Calendar.DATE, jour);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		
		String telephone = request.getParameter("telfixe");
		String portable = request.getParameter("telmobile");
		String adresse = request.getParameter("adresse");
		String codePostal = request.getParameter("codepostal");
		String mail = request.getParameter("mail");
		String ville = request.getParameter("ville");
		String licence = request.getParameter("licence");
		String classement = request.getParameter("classement");
		boolean certif;
		if (request.getParameter("certificat")!=null)
		{
			certif=true;
		}
		else
		{
			certif=false;
		}
		String numPass = request.getParameter("numpass");
		
		boolean prendrePhoto;
		if (request.getParameter("prendrePhoto")!=null)
		{
			prendrePhoto=true;
		}
		else
		{
			prendrePhoto=false;
		}
		
		boolean publierPhoto;
		if (request.getParameter("publierPhoto")!=null)
		{
			publierPhoto=true;
		}
		else
		{
			publierPhoto=false;
		}
		String password = Manager.getInstance().genererPassword();
		String statut = request.getParameter("statut");
		Adherent nouveladherent = new Adherent(nom, prenom, cal.getTime(), adresse, codePostal, ville, licence, classement, numPass, telephone, portable, mail, password, certif, prendrePhoto, publierPhoto, statut);
		
		Manager.getInstance().ajouterAdherent(nouveladherent);
		
		
		String jourCours1 = request.getParameter("Cours-1");
		String horairesCours1 = request.getParameter("horaires-1");
		
		if (jourCours1!=null && horairesCours1!=null)
		{
			int heureDebut = Integer.parseInt(horairesCours1.substring(0, 2));
			int minuteDebut = Integer.parseInt(horairesCours1.substring(3, 5));
			int heureFin = Integer.parseInt(horairesCours1.substring(8, 10));
			int minuteFin = Integer.parseInt(horairesCours1.substring(11, 13));
			Cours cours = Manager.getInstance().trouverCours(jourCours1, heureDebut, minuteDebut, heureFin, minuteFin);
			Manager.getInstance().ajouterAdherentauCours(nouveladherent, cours);
		}
		
		String jourCours2 = request.getParameter("Cours-2");
		String horairesCours2 = request.getParameter("horaires-2");
		
		if (jourCours2!=null && horairesCours2!=null)
		{
			int heureDebut = Integer.parseInt(horairesCours2.substring(0, 2));
			int minuteDebut = Integer.parseInt(horairesCours2.substring(3, 5));
			int heureFin = Integer.parseInt(horairesCours2.substring(8, 10));
			int minuteFin = Integer.parseInt(horairesCours2.substring(11, 13));
			Cours cours = Manager.getInstance().trouverCours(jourCours2, heureDebut, minuteDebut, heureFin, minuteFin);
			Manager.getInstance().ajouterAdherentauCours(nouveladherent, cours);
		}
		
		String jourCours3 = request.getParameter("Cours-3");
		String horairesCours3 = request.getParameter("horaires-3");
		
		if (jourCours3!=null && horairesCours3!=null)
		{
			int heureDebut = Integer.parseInt(horairesCours3.substring(0, 2));
			int minuteDebut = Integer.parseInt(horairesCours3.substring(3, 5));
			int heureFin = Integer.parseInt(horairesCours3.substring(8, 10));
			int minuteFin = Integer.parseInt(horairesCours3.substring(11, 13));
			Cours cours = Manager.getInstance().trouverCours(jourCours3, heureDebut, minuteDebut, heureFin, minuteFin);
			Manager.getInstance().ajouterAdherentauCours(nouveladherent, cours);
		}
		
		int compteurCheque = Integer.parseInt(request.getParameter("compteurCheque"));
		
		int i;
		for (i=1;i<=compteurCheque;i++)
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
			Manager.getInstance().ajouterPaiement(nouveladherent, paiement);
		}
		
		Mail email = new Mail(mail,password);
		Manager.getInstance().envoyerMailInscription(email);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/pages/inscription.jsp");
		view.forward(request, response);
	}

}

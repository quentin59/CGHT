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

public class AjouterCoursAdherentServlet extends HttpServlet {

	private static final long serialVersionUID = -8830849795476708949L;
	private static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String licence = request.getParameter("licence");
		
		Adherent adherent = Manager.getInstance().getAdherent(licence);
		
		String jourCours1 = request.getParameter("Cours-1");
		String horairesCours1 = request.getParameter("horaires-1");
		
		if (jourCours1!=null && horairesCours1!=null)
		{
			int heureDebut = Integer.parseInt(horairesCours1.substring(0, 2));
			int minuteDebut = Integer.parseInt(horairesCours1.substring(3, 5));
			int heureFin = Integer.parseInt(horairesCours1.substring(8, 10));
			int minuteFin = Integer.parseInt(horairesCours1.substring(11, 13));
			Cours cours = Manager.getInstance().trouverCours(jourCours1, heureDebut, minuteDebut, heureFin, minuteFin);
			Manager.getInstance().ajouterAdherentauCours(adherent, cours);
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
			Manager.getInstance().ajouterAdherentauCours(adherent, cours);
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
			Manager.getInstance().ajouterAdherentauCours(adherent, cours);
		}
		
		ModificationAdherentServlet servlet = new ModificationAdherentServlet();
		servlet.doGet(request, response);
		
	}
	
}
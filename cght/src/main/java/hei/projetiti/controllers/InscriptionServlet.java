package hei.projetiti.controllers;

import hei.projetiti.metier.Manager;
import hei.projetiti.model.Adherent;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InscriptionServlet extends HttpServlet {

	private static final long serialVersionUID = -8830849795476708949L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/pages/inscription.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
		String password = "123456";
		String statut = request.getParameter("statut");
		/*Adherent nouveladherent = new Adherent(nom, prenom, cal.getTime(), licence, classement, telfixe);*/
		Adherent nouveladherent = new Adherent(nom, prenom, cal.getTime(), adresse, codePostal, ville, licence, classement, numPass, telephone, portable, mail, password, certif, prendrePhoto, publierPhoto, statut);
		
		Manager.getInstance().AjouterAdherent(nouveladherent);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/pages/inscription.jsp");
		view.forward(request, response);
	}

}

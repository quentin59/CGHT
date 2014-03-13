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
		
		String telfixe = request.getParameter("telfixe");
		String telmobile = request.getParameter("telmobile");
		String adresse = request.getParameter("adresse");
		Integer codepostal = Integer.parseInt(request.getParameter("codepostal"));
		String mail = request.getParameter("mail");
		String ville = request.getParameter("ville");
		String licence = request.getParameter("licence");
		String classement = request.getParameter("classement");
		boolean certif;
		if (request.getParameter("certificat")!=null)
		{
			certif=false;
		}
		else
		{
			certif=true;
		}
		String numPassString = request.getParameter("numpass");
		
		boolean prendrePhoto;
		if (request.getParameter("prendrePhoto")!=null)
		{
			prendrePhoto=false;
		}
		else
		{
			prendrePhoto=true;
		}
		
		boolean publierPhoto;
		if (request.getParameter("publierPhoto")!=null)
		{
			publierPhoto=false;
		}
		else
		{
			publierPhoto=true;
		}
		
		String statut = request.getParameter("statut");
		
		Adherent nouveladherent = new Adherent(nom, prenom, cal.getTime(), licence, classement, telfixe);
		Manager.getInstance().AjouterAdherent(nouveladherent);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/pages/inscription.jsp");
		view.forward(request, response);
	}

}

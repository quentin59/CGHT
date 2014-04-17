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
import javax.servlet.http.HttpSession;

public class ModificationAdherentServlet extends HttpServlet {

	private static final long serialVersionUID = 5033062409008471038L;
	private static DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String numLicence = request.getParameter("licence");
		Adherent adherent = Manager.getInstance().getAdherent(numLicence);
		request.setAttribute("adherent", adherent);
		
		List<Cours> listeCours = Manager.getInstance().listerCoursparAdherent(numLicence);
		request.setAttribute("cours", listeCours);
		
		List<Paiement> listePaiements = Manager.getInstance().listerPaiements(adherent);
		request.setAttribute("paiements", listePaiements);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/pages/modifAdherent.jsp");
		view.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(true);
		String licence= (String) session.getAttribute("licence");
		String adresse = request.getParameter("adresse");
		String codePostal = request.getParameter("codepostal");
		String ville = request.getParameter("ville");
		String telephone = request.getParameter("telfixe");
		String portable = request.getParameter("telmobile");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String nouvelleLicence = request.getParameter("licence");
		String mail = request.getParameter("mail");
		String statut = request.getParameter("statut");
		
		Date dateNaissance = null;
		try {
			dateNaissance = dateFormat.parse(request.getParameter("datenaissance"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
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
		
		Adherent adherent = new Adherent(nom, prenom, dateNaissance, adresse, codePostal, ville, nouvelleLicence, classement, numPass, telephone, portable, mail, certif, prendrePhoto, publierPhoto, statut);
		Manager.getInstance().mettreAJourAdherentCoteAdmin(adherent);
		
		
		
		doGet(request, response);
	}
}

package hei.projetiti.controllers;

import hei.projetiti.metier.Manager;
import hei.projetiti.model.Adherent;
import hei.projetiti.model.Cours;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ImpressionAdherentsServlet extends HttpServlet{

	private static final long serialVersionUID = 6682297944195128797L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<Adherent> listeAdherents = Manager.getInstance().listerAdherents();
		for (int i=0;i<listeAdherents.size();i++) {
			if (request.getParameter("adherent"+listeAdherents.get(i).getLicence())!=null)
			{
				Adherent adherent = listeAdherents.get(i);
				File f = new File("C:\\\\Users\\"+System.getProperty("user.name")+"\\Documents\\adherent"+adherent.getLicence()+".csv");
		        //ECRITURE
		        try {
		            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(f)));
		            	pw.print("Licence : "+adherent.getLicence());
		            	pw.println();
		            	pw.print("Nom : "+adherent.getNom());
		            	pw.println();
		            	pw.print("Prénom : "+adherent.getPrenom());
		            	pw.println();
		            	pw.print("Date de naissance : "+adherent.getDateNaissance());
		            	pw.println();
		            	pw.print("Adresse : "+adherent.getAdresse());
		                pw.println();
		                pw.print("Code postal :"+adherent.getCodePostal());
		                pw.println();
		                pw.print("Ville : "+adherent.getVille());
		                pw.println();
		                pw.print("Téléphone : "+adherent.getTelephone());
		                pw.println();
		                pw.print("Portable : "+adherent.getPortable());
		                pw.println();
		                pw.print("Mail : "+adherent.getMail());
		                pw.println();
		                pw.print("Numéro de pass : "+adherent.getNumPass());
		                pw.println();
		                pw.print("Classement : "+adherent.getClassement());
		                pw.println();
		                pw.close();
		        } catch (IOException exception) {
		            System.out.println("Erreur lors de la lecture : " + exception.getMessage());
		        }
        
			}
		}
		
		List<Adherent> listesAdherents = Manager.getInstance().listerAdherents();
		request.setAttribute("adherents", listesAdherents);
		
		List<Cours> listeCours = Manager.getInstance().listerCours();
		request.setAttribute("cours", listeCours);
		request.setAttribute("acknowledge-adherent", "Le fichier a été sauvegardé dans \"Mes documents\"");
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/pages/impression.jsp");
		view.forward(request, response);
	}
}

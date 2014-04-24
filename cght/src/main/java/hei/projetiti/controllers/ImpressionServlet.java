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

public class ImpressionServlet extends HttpServlet{

	private static final long serialVersionUID = 6682297944195128797L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<Adherent> listeAdherents = Manager.getInstance().listerAdherents();
		request.setAttribute("adherents", listeAdherents);
		
		List<Cours> listeCours = Manager.getInstance().listerCours();
		request.setAttribute("cours", listeCours);
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/pages/impression.jsp");
		view.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<Cours> listeCours = Manager.getInstance().listerCours();
		for (int i=0;i<listeCours.size();i++) {
			if (request.getParameter("cours"+listeCours.get(i).getIdCours())!=null)
			{
				System.out.println(listeCours.get(i).getIdCours());
				File f = new File("cours"+listeCours.get(i).getJourCours()+listeCours.get(i).getHeureDebut()+".csv");
				List<Adherent> listeAdherent = Manager.getInstance().listerAdherentInscrit(listeCours.get(i));
		        //ECRITURE
		        try {
		            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(f)));
		            	pw.print("Cours du "+listeCours.get(i).getJourCours()+"h");
		            	pw.println();
		            	pw.print("Heure de début : "+listeCours.get(i).getHeureDebut()+"h"+listeCours.get(i).getMinuteDebut());
		            	pw.println();
		            	pw.print("Heure de fin : "+listeCours.get(i).getHeureFin()+"h"+listeCours.get(i).getMinuteFin());
		            	pw.println();
		            	pw.println();
		            	pw.print("Nom;");
		            	pw.print("Prénom;");
		            	pw.print("Licence");
		                pw.println();
		            for (Adherent adherent : listeAdherent) {
		            	pw.print(adherent.getNom() + ";");
		            	pw.print(adherent.getPrenom() + ";");
		            	pw.print(adherent.getLicence());
		                pw.println();
		            }
		            pw.close();
		        } catch (IOException exception) {
		            System.out.println("Erreur lors de la lecture : " + exception.getMessage());
		        }
        
			}
		}
        
	}
}

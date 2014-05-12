package hei.projetiti.controllers;

import hei.projetiti.metier.Manager;
import hei.projetiti.model.Actualite;
import hei.projetiti.model.Adherent;
import hei.projetiti.model.Annonce;
import hei.projetiti.model.Cours;
import hei.projetiti.model.Paiement;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExporterServlet extends HttpServlet{

	private static final long serialVersionUID = 6682297944195128797L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/pages/exporter.jsp");
		view.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<Adherent> listeAdherents = Manager.getInstance().listerAdherents();
		List<Annonce> listeAnnonces = Manager.getInstance().listerAnnonces();
		List<Actualite> listeActualites = Manager.getInstance().listerActualites();
		//List<Paiement> listePaiements = Manager.getInstance().listerPaiements(adherent);
		List<Cours> listeCours = Manager.getInstance().listerCours();
		//List<Cours> listeDUnAdherent = Manager.getInstance().listerCoursparAdherent(numLicence);
		
		File f = new File("C:\\\\Users\\"+System.getProperty("user.name")+"\\Documents\\exportBDD.csv");
		
		try {
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(f)));
            	pw.print("Licence;Nom;Prenom;Date Naissance;Adresse;Code postal;Ville;Telephone;Portable;Mail;Num pass;Classement;Certifificat;Statut;prendrePhoto;publierPhoto;Mot de passe");
            	pw.println();
            	for (Adherent adherent : listeAdherents) {
					pw.print(adherent.getLicence()+";"+adherent.getNom()+";"+adherent.getPrenom()+";"+adherent.getDateNaissance()+";"+adherent.getAdresse()+";"+adherent.getCodePostal()+";"+adherent.getVille()+";"+adherent.getTelephone()+";"+adherent.getPortable()+";"+adherent.getMail()+";"+adherent.getNumPass()+";"+adherent.getClassement()+";"+adherent.isCertif()+";"+adherent.getStatut()+";"+adherent.isPrendrePhoto()+";"+adherent.isPublierPhoto()+";"+adherent.getPassword()+";");
					pw.println();
				}
            	
            	pw.println();
            	pw.print("idCours;Jour;Heure Début;Minute Début;Heure Fin;Minute Fin");
            	pw.println();
            	for (Cours cours : listeCours) {
            		pw.print(cours.getIdCours()+";"+cours.getJourCours()+";"+cours.getHeureDebut()+";"+cours.getMinuteDebut()+";"+cours.getHeureFin()+";"+cours.getMinuteFin()+";");
            		pw.println();
            	}
            	
            	pw.println();
            	pw.print("idCours;Licence;");
            	pw.println();
            	for (Adherent adherent : listeAdherents) {
            		List<Cours> listeAdherentsInscrits = Manager.getInstance().listerCoursparAdherent(adherent.getLicence());
            		for (Cours cours : listeAdherentsInscrits) {
            			pw.print(cours.getIdCours()+";"+adherent.getLicence()+";");
                		pw.println();
					}
            	}
            	
            	pw.println();
            	pw.print("idPaiement;Num Chèque;Banque;Echeance;Montant;Licence;Payer");
            	pw.println();
            	for (Adherent adherent : listeAdherents) {
            		List<Paiement> listePaiementsAdherent = Manager.getInstance().listerPaiements(adherent);
            		for (Paiement paiement : listePaiementsAdherent) {
            			pw.print(paiement.getIdPaiement()+";"+paiement.getNumCheque()+";"+paiement.getBanque()+";"+paiement.getEcheance()+";"+paiement.getMontant()+";"+adherent.getLicence()+";"+paiement.isPayer()+";");
                		pw.println();
					}
            	}
            	
                pw.close();
        } catch (IOException exception) {
            System.out.println("Erreur lors de la lecture : " + exception.getMessage());
        }
		
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/pages/exporter.jsp");
		view.forward(request, response);
	}
	
}
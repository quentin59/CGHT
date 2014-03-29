package hei.projetiti.metier;

import hei.projetiti.metier.Manager;
import hei.projetiti.dao.ActualiteDao;
import hei.projetiti.dao.AdherentDao;
import hei.projetiti.dao.AnnonceDao;
import hei.projetiti.dao.CoursDao;
import hei.projetiti.dao.impl.ActualiteDaoImpl;
import hei.projetiti.dao.impl.AdherentDaoImpl;
import hei.projetiti.dao.impl.AnnonceDaoImpl;
import hei.projetiti.dao.impl.CoursDaoImpl;
import hei.projetiti.model.Actualite;
import hei.projetiti.model.Adherent;
import hei.projetiti.model.Annonce;
import hei.projetiti.model.Cours;

import java.util.List;

public class Manager {

	private static Manager instance;
	private AdherentDao adherentdao = new AdherentDaoImpl();
	private ActualiteDao actualitedao = new ActualiteDaoImpl();
	private AnnonceDao annoncedao = new AnnonceDaoImpl();
	private CoursDao coursdao = new CoursDaoImpl();
	
	
	public static Manager getInstance() {
		if(instance == null) {
			instance = new Manager();
		}
		return instance;
	}
	
	public List<Adherent> listerAdherents(){
		return adherentdao.listerAdherents();
	}
	
	public List<Actualite> listerActualites(){
		return actualitedao.listerActualites();
	}
	
	public List<Annonce> listerAnnonces(){
		return annoncedao.listerAnnonces();
	}
	
	public void AjouterAdherent(Adherent adherent){
		adherentdao.AjouterAdherent(adherent);
	}
	
	public List<Adherent> listerIdentifiantsAdherents(){
		return adherentdao.listerIdentifiantsAdherents();
	}
	
	public boolean adherentExiste(String nom, String prenom){
		return adherentdao.adherentExiste(nom, prenom);
	}
	
	public Adherent getAdherent(String licence){
		return adherentdao.getAdherent(licence);
	}
	
	public String getLicenceAdherent(String nom, String prenom){
		return adherentdao.getLicenceAdherent(nom, prenom);
	}
	
	public List<Cours> listerCours(){
		return coursdao.listerCours();
	}
	
	public List<Cours> listerCours(String jour){
		return coursdao.listerCours(jour);
	}
	
	public List<String> listerJoursCours(){
		return coursdao.listerJoursCours();
	}
	
	public void ajouterCours (Cours cours){
		coursdao.ajouterCours(cours);
	}
	
	public void supprimerCours (Integer idCours){
		coursdao.supprimerCours(idCours);
	}
	
	public void ajouterAdherentauCours(Adherent adherent, Cours cours){
		coursdao.ajouterAdherentauCours(adherent, cours);
	}
	
	public Cours trouverCours (String jour, int heureDebut, int minuteDebut, int heureFin, int minuteFin){
		return coursdao.trouverCours(jour, heureDebut, minuteDebut, heureFin, minuteFin);
	}
	
	public List<Cours> listerCoursparAdherent(String numLicence){
		return coursdao.listerCoursparAdherent(numLicence);
	}
	
	public void supprimerCoursAdherent(Integer idCours, String numLicence){
		coursdao.supprimerCoursAdherent(idCours, numLicence);
	}
}

package hei.projetiti.metier;

import hei.projetiti.metier.Manager;
import hei.projetiti.dao.ActualiteDao;
import hei.projetiti.dao.AdherentDao;
import hei.projetiti.dao.AnnonceDao;
import hei.projetiti.dao.CoursDao;
import hei.projetiti.dao.MailDao;
import hei.projetiti.dao.PaiementDao;
import hei.projetiti.dao.impl.ActualiteDaoImpl;
import hei.projetiti.dao.impl.AdherentDaoImpl;
import hei.projetiti.dao.impl.AnnonceDaoImpl;
import hei.projetiti.dao.impl.CoursDaoImpl;
import hei.projetiti.dao.impl.MailDaoImpl;
import hei.projetiti.dao.impl.PaiementDaoImpl;
import hei.projetiti.model.Actualite;
import hei.projetiti.model.Adherent;
import hei.projetiti.model.Annonce;
import hei.projetiti.model.Cours;
import hei.projetiti.model.Mail;
import hei.projetiti.model.Paiement;

import java.sql.Date;
import java.util.List;

public class Manager {

	private static Manager instance;
	private AdherentDao adherentdao = new AdherentDaoImpl();
	private ActualiteDao actualitedao = new ActualiteDaoImpl();
	private AnnonceDao annoncedao = new AnnonceDaoImpl();
	private CoursDao coursdao = new CoursDaoImpl();
	private PaiementDao paiementdao = new PaiementDaoImpl();
	private MailDao maildao = new MailDaoImpl();
	
	
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
	
	public List<Actualite> listerActualites(String annee) {
		return actualitedao.listerActualites(annee);
	}
	
	public List<Actualite> listerActualites(String annee, int mois){
		return actualitedao.listerActualites(annee, mois);
	}
	
	public void supprimerActualite(Integer idActualite){
		actualitedao.supprimerActualite(idActualite);
	}
	
	public void ajouterActualite(Actualite actualite) {
		actualitedao.ajouterActualite(actualite);
	}
	
	public Actualite getActualite(Integer idActualite) {
		return actualitedao.getActualite(idActualite);
	}
	
	public List<Annonce> listerAnnonces(){
		return annoncedao.listerAnnonces();
	}
	
	public List<Annonce> listerAnnonces(String annee) {
		return annoncedao.listerAnnonces(annee);
	}
	
	public List<Annonce> listerAnnonces(String annee, int mois) {
		return annoncedao.listerAnnonces(annee, mois);
	}
	
	public List<Annonce> listerAnnoncesParCategorie (String categorie){
		return annoncedao.listerAnnoncesParCategorie(categorie);
	}
	
	public void supprimerAnnonce(Integer idAnnonce){
		annoncedao.supprimerAnnonce(idAnnonce);
	}
	
	public void ajouterAnnonce(Annonce annonce){
		annoncedao.ajouterAnnonce(annonce);
	}
	
	public Annonce getAnnonce(Integer idAnnonce) {
		return annoncedao.getAnnonce(idAnnonce);
	}
	
	public void ajouterAdherent(Adherent adherent){
		adherentdao.ajouterAdherent(adherent);
	}
	
	public List<Adherent> listerIdentifiantsAdherents(){
		return adherentdao.listerIdentifiantsAdherents();
	}
	
	public boolean adherentExiste(String mail, String password){
		return adherentdao.adherentExiste(mail, password);
	}
	
	public Adherent getAdherent(String licence){
		return adherentdao.getAdherent(licence);
	}
	
	public String getLicenceAdherent(String mail, String password){
		return adherentdao.getLicenceAdherent(mail, password);
	}
	
	public void mettreAJourCoordonneesAdherent(Adherent adherent){
		adherentdao.mettreAJourCoordonneesAdherent(adherent);
	}
	
	public String crypterPassword(String password) throws Exception{
		return adherentdao.crypterPassword(password);
	}
	
	public String genererPassword(){
		return adherentdao.genererPassword();
	}
	
	public void mettreAJourIdentifiantsAdherent(Adherent adherent){
		adherentdao.mettreAJourIdentifiantsAdherent(adherent);
	}
	
	public void mettreAJourAdherentCoteAdmin(Adherent adherent){
		adherentdao.mettreAJourAdherentCoteAdmin(adherent);
	}
	
	public void supprimerAdherent(Adherent adherent){
		adherentdao.supprimerAdherent(adherent);
	}
	
	public List<Adherent> listerAdherentInscrit(Cours cours){
		return adherentdao.listerAdherentInscrit(cours);
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
	
	public List<Paiement> listerPaiements(Adherent adherent){
		return paiementdao.listerPaiements(adherent);
	}
	
	public void ajouterPaiement(Adherent adherent, Paiement paiement){
		paiementdao.ajouterPaiement(adherent, paiement);
	}
	
	public void encaisserPaiement(Integer idPaiement){
		paiementdao.encaisserPaiement(idPaiement);
	}
	
	public void nePasEncaisserPaiement(Integer idPaiement){
		paiementdao.nePasEncaisserPaiement(idPaiement);
	}
	
	public void fermerNotification(){
		paiementdao.fermerNotification();
	}
	
	public boolean etatNotification(){
		return paiementdao.etatNotification();
	}
	
	public void afficherNotification() {
		paiementdao.afficherNotification();
	}
	
	public List<Paiement> listerPaiementsAEncaisser(java.util.Date date) {
		return paiementdao.listerPaiementsAEncaisser(date);
	}
	
	public void envoyerMailInscription(Mail mail){
		maildao.envoyerMailInscription(mail);
	}
	
	public void envoyerMailContact(Mail mail){
		maildao.envoyerMailContact(mail);
	}
	
	public void envoyerMailPaiementAEncaisser(Mail mail, List<Paiement> listePaiements) {
		maildao.envoyerMailPaiementAEncaisser(mail, listePaiements);
	}
}

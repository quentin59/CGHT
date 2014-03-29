package hei.projetiti.dao;

import hei.projetiti.model.Adherent;
import hei.projetiti.model.Cours;

import java.util.List;

public interface CoursDao {

	public List<Cours> listerCours();
	
	public List<Cours> listerCours(String jour);
	
	public List<String> listerJoursCours();
	
	public void ajouterCours (Cours cours);
	
	public void supprimerCours (Integer id);
	
	public void ajouterAdherentauCours(Adherent adherent, Cours cours);
	
	public Cours trouverCours (String jour, int heureDebut, int minuteDebut, int heureFin, int minuteFin);
}
package hei.projetiti.dao;

import hei.projetiti.model.Cours;

import java.util.List;

public interface CoursDao {

	public List<Cours> listerCours();
	
	public void ajouterCours (Cours cours);
	
	public void supprimerCours (Cours cours);
}
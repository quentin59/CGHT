package hei.projetiti.dao;

import hei.projetiti.model.Actualite;

import java.util.List;

public interface ActualiteDao {

	public List<Actualite> listerActualites();
	
	public List<Actualite> listerActualites(String annee);
	
	public List<Actualite> listerActualites(String annee, int mois);
	
	public void supprimerActualite(Integer idActualite);
}

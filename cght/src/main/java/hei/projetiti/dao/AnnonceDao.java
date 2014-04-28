package hei.projetiti.dao;

import hei.projetiti.model.Annonce;

import java.util.List;

public interface AnnonceDao {

	public List<Annonce> listerAnnonces();
	
	public List<Annonce> listerAnnonces(String annee);
	
	public List<Annonce> listerAnnonces(String annee, int mois);
	
	public List<Annonce> listerAnnoncesParCategorie (String categorie);
	
	public void supprimerAnnonce(Integer idAnnonce);
	
	public void ajouterAnnonce(Annonce annonce);
	
	public Annonce getAnnonce(Integer idAnnonce);
}

package hei.projetiti.dao;

import hei.projetiti.model.Adherent;

import java.util.List;

public interface AdherentDao {

	public List<Adherent> listerAdherents();
	
	public List<Adherent> listerIdentifiantsAdherents();
	
	public void AjouterAdherent(Adherent adherent);
	
	public boolean adherentExiste(String nom, String prenom);
	
	public Adherent getAdherent(String licence);
}

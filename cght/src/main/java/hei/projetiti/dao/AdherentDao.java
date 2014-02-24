package hei.projetiti.dao;

import hei.projetiti.model.Adherent;

import java.util.List;

public interface AdherentDao {

	public List<Adherent> listerAdherents();
	
	public void AjouterAdherent(Adherent adherent);
}

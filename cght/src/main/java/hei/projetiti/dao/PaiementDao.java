package hei.projetiti.dao;

import java.util.List;

import hei.projetiti.model.Adherent;
import hei.projetiti.model.Paiement;

public interface PaiementDao {

	public List<Paiement> listerPaiements(Adherent adherent);
	
	public void ajouterPaiement(Adherent adherent, Paiement paiement);
	
	public void encaisserPaiement(Integer idPaiement);
	
	public void nePasEncaisserPaiement(Integer idPaiement);
	
}

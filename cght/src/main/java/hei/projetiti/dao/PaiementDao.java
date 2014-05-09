package hei.projetiti.dao;

import java.util.Date;
import java.util.List;

import hei.projetiti.model.Adherent;
import hei.projetiti.model.Paiement;

public interface PaiementDao {

	public List<Paiement> listerPaiements(Adherent adherent);
	
	public void ajouterPaiement(Adherent adherent, Paiement paiement);
	
	public void encaisserPaiement(Integer idPaiement);
	
	public void nePasEncaisserPaiement(Integer idPaiement);
	
	public void fermerNotification();
	
	public boolean etatNotification();
	
	public void afficherNotification();
	
	public List<Paiement> listerPaiementsAEncaisser(Date date);
	
}

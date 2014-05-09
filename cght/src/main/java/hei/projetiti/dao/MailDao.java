package hei.projetiti.dao;

import java.util.List;

import hei.projetiti.model.Mail;
import hei.projetiti.model.Paiement;


public interface MailDao {

	public void envoyerMailInscription(Mail mail);
	
	public void envoyerMailContact(Mail mail);
	
	public void envoyerMailPaiementAEncaisser(Mail mail, List<Paiement> listePaiements);
	
}
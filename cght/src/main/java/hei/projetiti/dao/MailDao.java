package hei.projetiti.dao;

import hei.projetiti.model.Mail;


public interface MailDao {

	public void envoyerMailInscription(Mail mail);
	
	public void envoyerMailContact(Mail mail);
	
}
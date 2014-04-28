package hei.projetiti.model;

public class Mail {

	private String envoyeur;
	private String recepteur;
	private String sujet;
	private String message;
	private String nom;
	private String prenom;
	private String email;
	
	public Mail(String email, String message)
	{
		this.email=email;
		this.message=message;
	}
	
	public Mail(String nom, String prenom, String email, String sujet, String message)
	{
		this.nom=nom;
		this.prenom=prenom;
		this.email=email;
		this.sujet=sujet;
		this.message=message;
	}

	public String getEnvoyeur() {
		return envoyeur;
	}

	public void setEnvoyeur(String envoyeur) {
		this.envoyeur = envoyeur;
	}

	public String getRecepteur() {
		return recepteur;
	}

	public void setRecepteur(String recepteur) {
		this.recepteur = recepteur;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSujet() {
		return sujet;
	}

	public void setSujet(String sujet) {
		this.sujet = sujet;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}

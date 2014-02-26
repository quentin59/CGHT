package hei.projetiti.model;

import java.util.Date;

public class Adherent {

	private String nom;
	private String prenom;
	private Date dateNaissance;
	private String adresse;
	private Integer codePostal;
	private String ville;
	private String licence;
	private String classement;
	private String numPass;
	private String telephone;
	private String mail;
	private String password;
	private boolean certif;
	private boolean prendrePhoto;
	private boolean publierPhoto;
	private String statut;
	
	public Adherent (String nom, String prenom, Date dateNaissance, String licence, String classement, String telephone) 
	{
		this.nom=nom;
		this.prenom=prenom;
		this.dateNaissance=dateNaissance;
		this.licence=licence;
		this.classement=classement;
		this.telephone=telephone;
	}
	
	public Adherent(String nom, String prenom)
	{
		this.nom=nom;
		this.prenom=prenom;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
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
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public Integer getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(Integer codePostal) {
		this.codePostal = codePostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getLicence() {
		return licence;
	}
	public void setLicence(String licence) {
		this.licence = licence;
	}
	public String getClassement() {
		return classement;
	}
	public void setClassement(String classement) {
		this.classement = classement;
	}
	public String getNumPass() {
		return numPass;
	}
	public void setNumPass(String numPass) {
		this.numPass = numPass;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public boolean isCertif() {
		return certif;
	}
	public void setCertif(boolean certif) {
		this.certif = certif;
	}
	public boolean isPrendrePhoto() {
		return prendrePhoto;
	}
	public void setPrendrePhoto(boolean prendrePhoto) {
		this.prendrePhoto = prendrePhoto;
	}
	public boolean isPublierPhoto() {
		return publierPhoto;
	}
	public void setPublierPhoto(boolean publierPhoto) {
		this.publierPhoto = publierPhoto;
	}
	
}

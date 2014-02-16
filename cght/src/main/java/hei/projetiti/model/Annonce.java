package hei.projetiti.model;

import java.util.Date;

public class Annonce {

	private Integer idAnnonce;
	private String titre;
	private String contenu;
	private String coordonnees;
	private String licence;
	private Date dateAnnonce;
	
	public Annonce(Integer idAnnonce, String titre, String contenu, String coordonnees, String licence, Date dateAnnonce){
		this.idAnnonce=idAnnonce;
		this.titre=titre;
		this.contenu=contenu;
		this.coordonnees=coordonnees;
		this.licence=licence;
		this.dateAnnonce=dateAnnonce;
	}
	
	public Integer getIdAnnonce() {
		return idAnnonce;
	}
	public void setIdAnnonce(Integer idAnnonce) {
		this.idAnnonce = idAnnonce;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	public String getCoordonnees() {
		return coordonnees;
	}
	public void setCoordonnees(String coordonnees) {
		this.coordonnees = coordonnees;
	}
	public String getLicence() {
		return licence;
	}
	public void setLicence(String licence) {
		this.licence = licence;
	}
	public Date getDateAnnonce() {
		return dateAnnonce;
	}
	public void setDateAnnonce(Date dateAnnonce) {
		this.dateAnnonce = dateAnnonce;
	}
	
public String moisLettre(int chiffre){
		
		String mois="";
		switch (chiffre) {
        case 1:  mois = "Janvier";
                 break;
        case 2:  mois = "F�vrier";
                 break;
        case 3:  mois = "Mars";
                 break;
        case 4:  mois = "Avril";
                 break;
        case 5:  mois = "Mai";
                 break;
        case 6:  mois = "Juin";
                 break;
        case 7:  mois = "Juillet";
                 break;
        case 8:  mois = "Ao�t";
                 break;
        case 9:  mois = "Septembre";
                 break;
        case 10: mois = "Octobre";
                 break;
        case 11: mois = "Novembre";
                 break;
        case 12: mois = "D�cembre";
                 break;
		}
		return mois;
	}
}

package hei.projetiti.model;

import java.nio.charset.Charset;
import java.util.Date;

public class Actualite {

	private Integer idActualite;
	private String titre;
	private String contenu;
	private String licence;
	private Date dateActualite;
	
	public Actualite(Integer idActualite, String titre, String contenu, String licence, Date dateActualite) {
		this.idActualite=idActualite;
		this.titre=titre;
		this.contenu=contenu;
		this.licence=licence;
		this.dateActualite=dateActualite;
	}

	public Integer getIdActualite() {
		return idActualite;
	}

	public void setIdActualite(Integer idActualite) {
		this.idActualite = idActualite;
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

	public String getLicence() {
		return licence;
	}

	public void setLicence(String licence) {
		this.licence = licence;
	}

	public Date getDateActualite() {
		return dateActualite;
	}

	public void setDateActualite(Date dateActualite) {
		this.dateActualite = dateActualite;
	}
	
	public String moisLettre(int chiffre){
		
		String mois="";
		switch (chiffre) {
        case 1:  mois = "Janvier";
                 break;
        case 2:  String mois1 = "Février";
        mois = new String(mois1.getBytes(),Charset.forName("UTF-8"));
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

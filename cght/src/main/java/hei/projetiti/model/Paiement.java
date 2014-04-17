package hei.projetiti.model;

import java.util.Date;

public class Paiement 
{
	private Integer idPaiement;
	private boolean payer;
	private String banque;
	private String numCheque;
	private Date echeance;
	private float montant;

	public Paiement(Integer idPaiement, boolean payer, String banque, String numCheque, Date echeance, float montant)
	{
		this.setIdPaiement(idPaiement);
		this.payer=payer;
		this.banque=banque;
		this.numCheque=numCheque;
		this.echeance=echeance;
		this.montant=montant;
	}
	
	public Paiement(boolean payer, String banque, String numCheque, Date echeance, float montant)
	{
		this.payer=payer;
		this.banque=banque;
		this.numCheque=numCheque;
		this.echeance=echeance;
		this.montant=montant;
	}

	public String getNumCheque() {
		return numCheque;
	}
	public void setNumCheque(String numCheque) {
		this.numCheque = numCheque;
	}
	public boolean isPayer() {
		return payer;
	}
	public void setPayer(boolean payer) {
		this.payer = payer;
	}
	public String getBanque() {
		return banque;
	}
	public void setBanque(String banque) {
		this.banque = banque;
	}
	public Date getEcheance() {
		return echeance;
	}
	public void setEcheance(Date echeance) {
		this.echeance = echeance;
	}
	public float getMontant() {
		return montant;
	}
	public void setMontant(float montant) {
		this.montant = montant;
	}

	public Integer getIdPaiement() {
		return idPaiement;
	}

	public void setIdPaiement(Integer idPaiement) {
		this.idPaiement = idPaiement;
	}

}
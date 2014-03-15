package hei.projetiti.model;

	public class Cours {

		private Integer idCours;
		private String jourCours;
		private int heureDebut;
		private int minuteDebut;
		private int heureFin;
		private int minuteFin;
	

	public Cours (Integer idCours, String jourCours, int heureDebut, int minuteDebut, int heureFin, int minuteFin)
	{	
		this.idCours=idCours;
		this.jourCours=jourCours;
		this.heureDebut=heureDebut;
		this.minuteDebut=minuteDebut;
		this.heureFin=heureFin;
		this.minuteFin=minuteFin;
	}

	public Integer getIdCours() {
		return idCours;
	}
	
	public void setIdCours(Integer idCours) {
		this.idCours = idCours;
	}
	
	public String getJourCours() {
		return jourCours;
	}
	
	public void setJourCours(String jourCours) {
		this.jourCours = jourCours;
	}

	public int getHeureDebut() {
		return heureDebut;
	}

	public void setHeureDebut(int heureDebut) {
		this.heureDebut = heureDebut;
	}

	public int getMinuteDebut() {
		return minuteDebut;
	}

	public void setMinuteDebut(int minuteDebut) {
		this.minuteDebut = minuteDebut;
	}

	public int getHeureFin() {
		return heureFin;
	}

	public void setHeureFin(int heureFin) {
		this.heureFin = heureFin;
	}

	public int getMinuteFin() {
		return minuteFin;
	}

	public void setMinuteFin(int minuteFin) {
		this.minuteFin = minuteFin;
	}
	
	}
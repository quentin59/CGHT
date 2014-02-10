package hei.projetiti.metier;

import hei.projetiti.metier.Manager;
import hei.projetiti.dao.ActualiteDao;
import hei.projetiti.dao.AdherentDao;
import hei.projetiti.dao.impl.ActualiteDaoImpl;
import hei.projetiti.dao.impl.AdherentDaoImpl;
import hei.projetiti.model.Actualite;
import hei.projetiti.model.Adherent;

import java.util.List;

public class Manager {

	private static Manager instance;
	private AdherentDao adherentdao = new AdherentDaoImpl();
	private ActualiteDao actualitedao = new ActualiteDaoImpl();
	
	public static Manager getInstance() {
		if(instance == null) {
			instance = new Manager();
		}
		return instance;
	}
	
	public List<Adherent> listerAdherents(){
		return adherentdao.listerAdherents();
	}
	
	public List<Actualite> listerActualites(){
		return actualitedao.listerActualites();
	}
	
}

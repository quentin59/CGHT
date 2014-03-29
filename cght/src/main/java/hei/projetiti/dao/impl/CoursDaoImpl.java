package hei.projetiti.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hei.projetiti.dao.CoursDao;
import hei.projetiti.model.Adherent;
import hei.projetiti.model.Cours;

public class CoursDaoImpl implements CoursDao{
	
	public List<Cours> listerCours() {
		
		List<Cours> listeCours= new ArrayList<Cours>();
		
		try {
			//Créer une nouvelle connexion à la BDD
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			
			//Utiliser la connexion
			Statement stmt = connection.createStatement();
            ResultSet results = stmt.executeQuery("SELECT * FROM `cours` ORDER BY CASE `jourCours` "
            		+ "WHEN 'lundi' THEN 1 WHEN 'mardi' THEN 2 WHEN 'mercredi' THEN 3 WHEN 'jeudi' THEN 4 WHEN 'vendredi' THEN 5 WHEN 'samedi' THEN 6 WHEN 'dimanche' THEN 7 END, `heureDebut` ASC, `minuteDebut`");
            while (results.next()) {
                Cours cours = new Cours(results.getInt("idCours"), 
                           results.getString("jourCours"), 
                           results.getInt("heureDebut"),
                           results.getInt("minuteDebut"),
                           results.getInt("heureFin"),
						   results.getInt("minuteFin"));
                listeCours.add(cours);
            }
            
            // Fermer la connexion
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listeCours;
		}

	@Override
	public void ajouterCours(Cours cours) {
		// Créer une nouvelle connexion Ã  la BDD
	    try {
	        Connection connection = DataSourceProvider.getDataSource().getConnection();

	        // Utiliser la connexion
	        PreparedStatement stmt = connection.prepareStatement(
	                  "INSERT INTO `cours`(`jourCours`, `heureDebut`, `minuteDebut`, `heureFin`, `minuteFin`) VALUES(?, ?, ?, ?, ?)");
	        stmt.setString(1, cours.getJourCours());
	        stmt.setInt(2, cours.getHeureDebut());
	        stmt.setInt(3,cours.getMinuteDebut());
	        stmt.setInt(4,cours.getHeureFin());
	        stmt.setInt(5,cours.getMinuteFin());
	        stmt.executeUpdate();

	        // Fermer la connexion
	        connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		
	}

	@Override
	public void supprimerCours(Integer id) {
		// Créer une nouvelle connexion Ã  la BDD
	    try {
	        Connection connection = DataSourceProvider.getDataSource().getConnection();

	        // Utiliser la connexion
	        PreparedStatement stmt = connection.prepareStatement(
	                  "DELETE FROM `cours` WHERE `idCours`=?");
	        stmt.setInt(1,id);
	        stmt.executeUpdate();

	        // Fermer la connexion
	        connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		
	}

	@Override
	public List<Cours> listerCours(String jour) {
		
		List<Cours> listeCours= new ArrayList<Cours>();
		
		try {
			//Créer une nouvelle connexion à la BDD
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			
			//Utiliser la connexion
			
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM `cours` WHERE jourCours=?");
			stmt.setString(1, jour);
			ResultSet results = stmt.executeQuery();
            while (results.next()) {
                Cours cours = new Cours(results.getInt("idCours"), 
                           results.getString("jourCours"), 
                           results.getInt("heureDebut"),
                           results.getInt("minuteDebut"),
                           results.getInt("heureFin"),
						   results.getInt("minuteFin"));
                listeCours.add(cours);
            }
            
            // Fermer la connexion
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listeCours;
	}

	@Override
	public List<String> listerJoursCours() {
		
		List<String> listeJoursCours= new ArrayList<String>();
		
		try {
			//Créer une nouvelle connexion à la BDD
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			
			//Utiliser la connexion
			
			Statement stmt = connection.createStatement();
            ResultSet results = stmt.executeQuery("SELECT DISTINCT `jourCours` FROM `cours` ORDER BY CASE `jourCours` "
            		+ "WHEN 'lundi' THEN 1 WHEN 'mardi' THEN 2 WHEN 'mercredi' THEN 3 WHEN 'jeudi' THEN 4 WHEN 'vendredi' THEN 5 WHEN 'samedi' THEN 6 WHEN 'dimanche' THEN 7 END ");
            while (results.next()) {
                String cours = results.getString("jourCours");
                listeJoursCours.add(cours);
            }
            
            // Fermer la connexion
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listeJoursCours;
	}

	@Override
	public void ajouterAdherentauCours(Adherent adherent, Cours cours) {
		
		try {
	        Connection connection = DataSourceProvider.getDataSource().getConnection();

	        // Utiliser la connexion
	        PreparedStatement stmt = connection.prepareStatement(
	                  "INSERT INTO `participer`(`numLicence`, `idCours`) VALUES(?, ?)");
	        stmt.setString(1, adherent.getLicence());
	        stmt.setInt(2, cours.getIdCours());
	        stmt.executeUpdate();

	        // Fermer la connexion
	        connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		
	}

	@Override
	public Cours trouverCours(String jour, int heureDebut, int minuteDebut,
			int heureFin, int minuteFin) {
		
		Cours cours=null;
		try {
			//Créer une nouvelle connexion à la BDD
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			
			//Utiliser la connexion
			
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM `cours` WHERE `jourCours`=? AND `heureDebut`=? AND `minuteDebut`=? AND `heureFin`=? AND `minuteFin`=? ");
			stmt.setString(1, jour);
			stmt.setInt(2, heureDebut);
			stmt.setInt(3, minuteDebut);
			stmt.setInt(4, heureFin);
			stmt.setInt(5, minuteFin);
			
			ResultSet results = stmt.executeQuery();
            results.next();
            cours = new Cours(results.getInt("idCours"), 
                           results.getString("jourCours"), 
                           results.getInt("heureDebut"),
                           results.getInt("minuteDebut"),
                           results.getInt("heureFin"),
						   results.getInt("minuteFin"));
            
            // Fermer la connexion
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cours;
	}

	@Override
	public List<Cours> listerCoursparAdherent(String numLicence) {
		
		List<Cours> listeCours= new ArrayList<Cours>();
		
		try {
			//Créer une nouvelle connexion à la BDD
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			
			//Utiliser la connexion
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM `cours` INNER JOIN `participer` ON cours.idCours = participer.idCours WHERE participer.numLicence = ? ORDER BY CASE `jourCours` "
            		+ "WHEN 'lundi' THEN 1 WHEN 'mardi' THEN 2 WHEN 'mercredi' THEN 3 WHEN 'jeudi' THEN 4 WHEN 'vendredi' THEN 5 WHEN 'samedi' THEN 6 WHEN 'dimanche' THEN 7 END, `heureDebut` ASC, `minuteDebut`");
			stmt.setString(1, numLicence);
			ResultSet results = stmt.executeQuery();
            while (results.next()) {
                Cours cours = new Cours(results.getInt("idCours"), 
                           results.getString("jourCours"), 
                           results.getInt("heureDebut"),
                           results.getInt("minuteDebut"),
                           results.getInt("heureFin"),
						   results.getInt("minuteFin"));
                listeCours.add(cours);
            }
            
            // Fermer la connexion
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listeCours;
	}

	@Override
	public void supprimerCoursAdherent(Integer idCours, String numLicence) {

		 try {
		        Connection connection = DataSourceProvider.getDataSource().getConnection();

		        // Utiliser la connexion
		        PreparedStatement stmt = connection.prepareStatement(
		                  "DELETE FROM `participer` WHERE `idCours`=? AND `numLicence`=?");
		        stmt.setInt(1,idCours);
		        stmt.setString(2, numLicence);
		        stmt.executeUpdate();

		        // Fermer la connexion
		        connection.close();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		
	}
	
}

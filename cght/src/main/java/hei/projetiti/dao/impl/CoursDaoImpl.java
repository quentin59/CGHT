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
import hei.projetiti.model.Cours;

public class CoursDaoImpl implements CoursDao{
	
	public List<Cours> listerCours() {
		
		List<Cours> listeCours= new ArrayList<Cours>();
		
		try {
			//Créer une nouvelle connexion à la BDD
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			
			//Utiliser la connexion
			Statement stmt = connection.createStatement();
            ResultSet results = stmt.executeQuery("SELECT * FROM `cours`");
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
	                  "DELETE `cours` WHERE 'idCours=?");
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
	
}

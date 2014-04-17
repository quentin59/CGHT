package hei.projetiti.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hei.projetiti.dao.ActualiteDao;
import hei.projetiti.model.Actualite;
import hei.projetiti.model.Adherent;

public class ActualiteDaoImpl implements ActualiteDao{

	public List<Actualite> listerActualites() {
		
		List<Actualite> listeActualites = new ArrayList<Actualite>();
		
		try {
			//Cr�er une nouvelle connexion � la BDD
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			
			//Utiliser la connexion
			Statement stmt = connection.createStatement();
            ResultSet results = stmt.executeQuery("SELECT * FROM `actualite` ORDER BY `dateActualite` DESC");
            while (results.next()) {
                Actualite actualite = new Actualite(results.getInt("idActualite"), 
                           results.getString("titre"), 
                           results.getString("contenu"),
                           results.getString("numLicence"),
                           results.getDate("dateActualite"));
                listeActualites.add(actualite);
            }
            
            // Fermer la connexion
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listeActualites;
		
	
	}
	
public List<Actualite> listerActualites(String annee) {
		
		List<Actualite> listeActualites = new ArrayList<Actualite>();
		
		try {
			//Cr�er une nouvelle connexion � la BDD
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			
			//Utiliser la connexion
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM `actualite` WHERE YEAR(`dateActualite`)=? ORDER BY `dateActualite` DESC ");
			stmt.setString(1, annee);
			ResultSet results = stmt.executeQuery();
			while (results.next()) {
                Actualite actualite = new Actualite(results.getInt("idActualite"), 
                           results.getString("titre"), 
                           results.getString("contenu"),
                           results.getString("numLicence"),
                           results.getDate("dateActualite"));
                listeActualites.add(actualite);
            }
            
            // Fermer la connexion
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listeActualites;
		
	
	}

}

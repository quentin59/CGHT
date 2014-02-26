package hei.projetiti.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hei.projetiti.dao.AdherentDao;
import hei.projetiti.model.Adherent;

public class AdherentDaoImpl implements AdherentDao{
	
	public List<Adherent> listerAdherents() {
		
		List<Adherent> listeAdherents = new ArrayList<Adherent>();
		
		try {
			//Crï¿½er une nouvelle connexion ï¿½ la BDD
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			
			//Utiliser la connexion
			Statement stmt = connection.createStatement();
            ResultSet results = stmt.executeQuery("SELECT * FROM `adherent`");
            while (results.next()) {
                Adherent adherent = new Adherent(results.getString("nom"), 
                           results.getString("prenom"), 
                           results.getDate("dateNaissance"),
                           results.getString("numLicence"),
                           results.getString("classement"),
                results.getString("telephone"));
                listeAdherents.add(adherent);
            }
            
            // Fermer la connexion
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listeAdherents;
		}

	@Override
	public void AjouterAdherent(Adherent adherent) {
		// CrÃ©er une nouvelle connexion Ã  la BDD
	    try {
	        Connection connection = DataSourceProvider.getDataSource().getConnection();

	        // Utiliser la connexion
	        PreparedStatement stmt = connection.prepareStatement(
	                  "INSERT INTO `adherent`(`nom`, `prenom`, `dateNaissance`, `numLicence`, `classement`, `telephone`) VALUES(?, ?, ?, ?, ?, ?)");
	        stmt.setString(1, adherent.getNom());
	        stmt.setString(2, adherent.getPrenom());
	        stmt.setDate(3, new Date(adherent.getDateNaissance().getTime()));
	        stmt.setString(4,adherent.getLicence());
	        stmt.setString(5,adherent.getClassement());
	        stmt.setString(6,adherent.getTelephone());
	        stmt.executeUpdate();

	        // Fermer la connexion
	        connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		
	}

	@Override
	public List<Adherent> listerIdentifiantsAdherents() {
		
		List<Adherent> listeIdentifiantsAdherents = new ArrayList<Adherent>();
		
		try {
			//Crï¿½er une nouvelle connexion ï¿½ la BDD
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			
			//Utiliser la connexion
			Statement stmt = connection.createStatement();
            ResultSet results = stmt.executeQuery("SELECT * FROM `adherent`");
            while (results.next()) {
                Adherent adherent = new Adherent(results.getString("nom"), 
                           results.getString("prenom")); 
                          
                listeIdentifiantsAdherents.add(adherent);
            }
            
            // Fermer la connexion
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listeIdentifiantsAdherents;
	}

	@Override
	public boolean adherentExiste(String nom, String prenom) {
		
		try {
	        Connection connection = DataSourceProvider.getDataSource().getConnection();

	        // Utiliser la connexion
	        PreparedStatement stmt = connection.prepareStatement(
	                  "SELECT * FROM `adherent` WHERE `nom`=? and `prenom`=?");
	        stmt.setString(1, nom);
	        stmt.setString(2, prenom);
	        ResultSet results = stmt.executeQuery();
            if (results.first())
            {
            	return true;
            }

	        // Fermer la connexion
	        connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		return false;
	}
	
}

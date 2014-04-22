package hei.projetiti.dao.impl;

import java.sql.Connection;
import java.sql.Date;
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

public List<Actualite> listerActualites(String annee, int mois) {
	
	List<Actualite> listeActualites = new ArrayList<Actualite>();
	
	try {
		//Cr�er une nouvelle connexion � la BDD
		Connection connection = DataSourceProvider.getDataSource().getConnection();
		
		//Utiliser la connexion
		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM `actualite` WHERE YEAR(`dateActualite`)=? AND MONTH(`dateActualite`)=? ORDER BY `dateActualite` DESC ");
		stmt.setString(1, annee);
		stmt.setInt(2, mois);
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

	public void supprimerActualite(Integer idActualite){
		 try {
		        Connection connection = DataSourceProvider.getDataSource().getConnection();

		        // Utiliser la connexion
		        PreparedStatement stmt = connection.prepareStatement(
		                  "DELETE FROM `actualite` WHERE `idActualite`=?");
		        stmt.setInt(1,idActualite);
		        stmt.executeUpdate();

		        // Fermer la connexion
		        connection.close();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
	}

	@Override
	public void ajouterActualite(Actualite actualite) {
		// TODO Auto-generated method stub
		 try {
		        Connection connection = DataSourceProvider.getDataSource().getConnection();

		        // Utiliser la connexion
		        PreparedStatement stmt = connection.prepareStatement(
		                  "INSERT INTO `actualite`(`titre`, `contenu`, `numLicence`, `dateActualite`) VALUES(?, ?, ?, ?)");
		        stmt.setString(1, actualite.getTitre());
		        stmt.setString(2, actualite.getContenu());
		        stmt.setString(3,actualite.getLicence());
		        stmt.setDate(4, new Date(actualite.getDateActualite().getTime()));
		        stmt.executeUpdate();

		        // Fermer la connexion
		        connection.close();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
	}

	@Override
	public Actualite getActualite(Integer idActualite) {
		// TODO Auto-generated method stub
		Actualite actualite=null;
		try {
			//Cr�er une nouvelle connexion � la BDD
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			
			//Utiliser la connexion
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM `actualite` WHERE `idActualite`=? ");
			stmt.setInt(1, idActualite);
			ResultSet results = stmt.executeQuery();
			results.next();
                Actualite newactualite = new Actualite(results.getInt("idActualite"), 
                           results.getString("titre"), 
                           results.getString("contenu"),
                           results.getString("numLicence"),
                           results.getDate("dateActualite"));
                actualite=newactualite;
          
            
            
            // Fermer la connexion
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return actualite;
	}

}

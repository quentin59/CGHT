package hei.projetiti.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hei.projetiti.dao.AnnonceDao;
import hei.projetiti.model.Actualite;
import hei.projetiti.model.Annonce;

public class AnnonceDaoImpl implements AnnonceDao{

	@Override
	public List<Annonce> listerAnnonces() {
		List<Annonce> listeAnnonces = new ArrayList<Annonce>();
		
		try {
			//Créer une nouvelle connexion à la BDD
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			
			//Utiliser la connexion
			Statement stmt = connection.createStatement();
            ResultSet results = stmt.executeQuery("SELECT * FROM `annonce` ORDER BY `dateAnnonce` DESC");
            while (results.next()) {
                Annonce annonce = new Annonce(results.getInt("idAnnonce"), 
                           results.getString("titre"), 
                           results.getString("contenu"),
                           results.getString("coordonnees"),
                           results.getString("numLicence"),
                           results.getDate("dateAnnonce"),
                           results.getString("categorie"),
                           results.getFloat("prix"));
                listeAnnonces.add(annonce);
            }
            
            // Fermer la connexion
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return listeAnnonces;
	}
	
	public void supprimerAnnonce(Integer idAnnonce){
		 try {
		        Connection connection = DataSourceProvider.getDataSource().getConnection();

		        // Utiliser la connexion
		        PreparedStatement stmt = connection.prepareStatement(
		                  "DELETE FROM `annonce` WHERE `idAnnonce`=?");
		        stmt.setInt(1,idAnnonce);
		        stmt.executeUpdate();

		        // Fermer la connexion
		        connection.close();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
	}

	@Override
	public List<Annonce> listerAnnonces(String annee) {
		// TODO Auto-generated method stub
		List<Annonce> listeAnnonces = new ArrayList<Annonce>();
		
		try {
			//Cr�er une nouvelle connexion � la BDD
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			
			//Utiliser la connexion
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM `annonce` WHERE YEAR(`dateAnnonce`)=? ORDER BY `dateAnnonce` DESC ");
			stmt.setString(1, annee);
			ResultSet results = stmt.executeQuery();
			while (results.next()) {
				 Annonce annonce = new Annonce(results.getInt("idAnnonce"), 
                         results.getString("titre"), 
                         results.getString("contenu"),
                         results.getString("coordonnees"),
                         results.getString("numLicence"),
                         results.getDate("dateAnnonce"),
                         results.getString("categorie"),
                         results.getFloat("prix"));
              listeAnnonces.add(annonce);
            }
            
            // Fermer la connexion
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listeAnnonces;
	}

	@Override
	public List<Annonce> listerAnnonces(String annee, int mois) {
		// TODO Auto-generated method stub
List<Annonce> listeAnnonces = new ArrayList<Annonce>();
		
		try {
			//Cr�er une nouvelle connexion � la BDD
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			
			//Utiliser la connexion
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM `annonce` WHERE YEAR(`dateAnnonce`)=? AND MONTH(`dateAnnonce`)=? ORDER BY `dateAnnonce` DESC ");
			stmt.setString(1, annee);
			stmt.setInt(2,mois);
			ResultSet results = stmt.executeQuery();
			while (results.next()) {
				 Annonce annonce = new Annonce(results.getInt("idAnnonce"), 
                         results.getString("titre"), 
                         results.getString("contenu"),
                         results.getString("coordonnees"),
                         results.getString("numLicence"),
                         results.getDate("dateAnnonce"),
                         results.getString("categorie"),
                         results.getFloat("prix"));
              listeAnnonces.add(annonce);
            }
            
            // Fermer la connexion
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listeAnnonces;
	}

	@Override
	public void ajouterAnnonce(Annonce annonce) {
		// TODO Auto-generated method stub
		 try {
		        Connection connection = DataSourceProvider.getDataSource().getConnection();

		        // Utiliser la connexion
		        PreparedStatement stmt = connection.prepareStatement(
		                  "INSERT INTO `annonce`(`titre`, `contenu`, `coordonnees`, `numLicence`, `dateAnnonce`, `categorie`, `prix`) VALUES(?, ?, ?, ?, ?, ?, ?)");
		        stmt.setString(1, annonce.getTitre());
		        stmt.setString(2, annonce.getContenu());
		        stmt.setString(3, annonce.getCoordonnees());
		        stmt.setString(4,annonce.getLicence());
		        stmt.setDate(5, new Date(annonce.getDateAnnonce().getTime()));
		        stmt.setString(6, annonce.getCategorie());
		        stmt.setFloat(7, annonce.getPrix());
		        stmt.executeUpdate();

		        // Fermer la connexion
		        connection.close();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
	}

	@Override
	public Annonce getAnnonce(Integer idAnnonce) {
		// TODO Auto-generated method stub
		Annonce annonce=null;
		try {
			//Cr�er une nouvelle connexion � la BDD
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			
			//Utiliser la connexion
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM `annonce` WHERE `idAnnonce`=? ");
			stmt.setInt(1, idAnnonce);
			ResultSet results = stmt.executeQuery();
			results.next();
                Annonce newannonce = new Annonce(results.getInt("idAnnonce"), 
                           results.getString("titre"), 
                           results.getString("contenu"),
                           results.getString("coordonnees"),
                           results.getString("numLicence"),
                           results.getDate("dateAnnonce"),
                           results.getString("categorie"),
                           results.getFloat("prix"));
                annonce=newannonce;
          
            
            
            // Fermer la connexion
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return annonce;
	}

	
}

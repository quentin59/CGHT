package hei.projetiti.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import hei.projetiti.dao.CoursDao;
import hei.projetiti.dao.PaiementDao;
import hei.projetiti.model.Adherent;
import hei.projetiti.model.Cours;
import hei.projetiti.model.Paiement;

public class PaiementDaoImpl implements PaiementDao{

	@Override
	public List<Paiement> listerPaiements(Adherent adherent) {
		List<Paiement> listePaiements= new ArrayList<Paiement>();
		
		try {
			//Créer une nouvelle connexion à la BDD
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			
			//Utiliser la connexion
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM `paiement` WHERE `numLicence`=?");
			stmt.setString(1, adherent.getLicence());
			ResultSet results = stmt.executeQuery();
            while (results.next()) {
                Paiement paiement = new Paiement(
                		results.getInt("idPaiement"),	
                		results.getBoolean("payer"), 
                		results.getString("banque"), 
                        results.getString("numCheque"),
                        results.getDate("echeance"),
                        results.getFloat("montant"));
                listePaiements.add(paiement);
            }
            
            // Fermer la connexion
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listePaiements;
	}

	@Override
	public void ajouterPaiement(Adherent adherent, Paiement paiement) {
		try {
	        Connection connection = DataSourceProvider.getDataSource().getConnection();

	        // Utiliser la connexion
	        PreparedStatement stmt = connection.prepareStatement(
	                  "INSERT INTO `paiement`(`payer`, `banque`, `numCheque`, `echeance`, `montant`,`numLicence`) VALUES(?,?,?,?,?,?)");
	        stmt.setBoolean(1, paiement.isPayer());
	        stmt.setString(2, paiement.getBanque());
	        stmt.setString(3, paiement.getNumCheque());
	        stmt.setDate(4, new Date(paiement.getEcheance().getTime()));
	        stmt.setFloat(5, paiement.getMontant());
	        stmt.setString(6, adherent.getLicence());
	        stmt.executeUpdate();

	        // Fermer la connexion
	        connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		
	}

	@Override
	public void encaisserPaiement(Integer idPaiement) {
		// TODO Auto-generated method stub
		try {
	        Connection connection = DataSourceProvider.getDataSource().getConnection();

	        // Utiliser la connexion
	        PreparedStatement stmt = connection.prepareStatement(
	                  "UPDATE `paiement` SET `payer`='1' WHERE `idPaiement`=?");
	        stmt.setInt(1, idPaiement);
	        stmt.executeUpdate();

	        // Fermer la connexion
	        connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		
	}

	@Override
	public void nePasEncaisserPaiement(Integer idPaiement) {
		// TODO Auto-generated method stub
		try {
	        Connection connection = DataSourceProvider.getDataSource().getConnection();

	        // Utiliser la connexion
	        PreparedStatement stmt = connection.prepareStatement(
	                  "UPDATE `paiement` SET `payer`='0' WHERE `idPaiement`=?");
	        stmt.setInt(1, idPaiement);
	        stmt.executeUpdate();

	        // Fermer la connexion
	        connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	@Override
	public void fermerNotification() {
		// TODO Auto-generated method stub
		try {
			//Créer une nouvelle connexion à la BDD
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			
			//Utiliser la connexion
			 PreparedStatement stmt = connection.prepareStatement(
	                  "UPDATE flag SET notification = ?");
	        stmt.setBoolean(1, false);
	        stmt.executeUpdate();
			
               
            // Fermer la connexion
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
      
	}
	
	public boolean etatNotification() {
		// TODO Auto-generated method stub
		boolean res=false;
		try {
			//Créer une nouvelle connexion à la BDD
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			
			//Utiliser la connexion
			Statement stmt = connection.createStatement();
			ResultSet results = stmt.executeQuery("SELECT * FROM `flag`");
			results.next();
			res = results.getBoolean("notification");
			
               
            // Fermer la connexion
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return res;
      
	}
	
	public void afficherNotification() {
		// TODO Auto-generated method stub
		try {
			//Créer une nouvelle connexion à la BDD
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			
			//Utiliser la connexion
			 PreparedStatement stmt = connection.prepareStatement(
	                  "UPDATE flag SET notification = ?");
	        stmt.setBoolean(1, true);
	        stmt.executeUpdate();
			
               
            // Fermer la connexion
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
      
	}
	
	public List<Paiement> listerPaiementsAEncaisser(java.util.Date date) {
		List<Paiement> listePaiements= new ArrayList<Paiement>();
		
		try {
			//Créer une nouvelle connexion à la BDD
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			
			//Utiliser la connexion
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM `paiement` WHERE YEAR(`echeance`)=? AND MONTH(`echeance`)=?");
			stmt.setInt(1, date.getYear()+1900);
			stmt.setInt(2,date.getMonth()+1);
			ResultSet results = stmt.executeQuery();
            while (results.next()) {
                Paiement paiement = new Paiement(
                		results.getInt("idPaiement"),	
                		results.getBoolean("payer"), 
                		results.getString("banque"), 
                        results.getString("numCheque"),
                        results.getDate("echeance"),
                        results.getFloat("montant"));
                listePaiements.add(paiement);
            }
            
            // Fermer la connexion
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listePaiements;
	}

	
	
	
	
}
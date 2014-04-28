package hei.projetiti.dao.impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import hei.projetiti.dao.AdherentDao;
import hei.projetiti.model.Adherent;
import hei.projetiti.model.Cours;

public class AdherentDaoImpl implements AdherentDao{
	
	public List<Adherent> listerAdherents() {
		
		List<Adherent> listeAdherents = new ArrayList<Adherent>();
		
		try {
			//Crï¿½er une nouvelle connexion ï¿½ la BDD
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			
			//Utiliser la connexion
			Statement stmt = connection.createStatement();
            ResultSet results = stmt.executeQuery("SELECT * FROM `adherent` ORDER BY `nom` ASC, `prenom` ASC");
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
	public void ajouterAdherent(Adherent adherent) {
		// CrÃ©er une nouvelle connexion Ã  la BDD
	    try {
	        Connection connection = DataSourceProvider.getDataSource().getConnection();

	        // Utiliser la connexion
	        PreparedStatement stmt = connection.prepareStatement(
	                  "INSERT INTO `adherent`(`nom`, `prenom`, `dateNaissance`, `numLicence`, `adresse`, "
	                  + "`codePostal`, `ville`, `telephone`, `portable`, `mail`, `numPass`, "
	                  + "`classement`, `certif`, `statut`, `prendrePhoto`, `publierPhoto`, `password`) "
	                  + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
	        stmt.setString(1, adherent.getNom());
	        stmt.setString(2, adherent.getPrenom());
	        stmt.setDate(3, new Date(adherent.getDateNaissance().getTime()));
	        stmt.setString(4,adherent.getLicence());
	        stmt.setString(5,adherent.getAdresse());
	        stmt.setString(6,adherent.getCodePostal());
	        stmt.setString(7,adherent.getVille());
	        stmt.setString(8,adherent.getTelephone());
	        stmt.setString(9,adherent.getPortable());
	        stmt.setString(10,adherent.getMail());
	        stmt.setString(11,adherent.getNumPass());
	        stmt.setString(12,adherent.getClassement());
	        stmt.setBoolean(13,adherent.isCertif());
	        stmt.setString(14,adherent.getStatut());
	        stmt.setBoolean(15,adherent.isPrendrePhoto());
	        stmt.setBoolean(16,adherent.isPublierPhoto());
	        stmt.setString(17,adherent.getPassword());
	        
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
	public boolean adherentExiste(String mail, String password) {
		
		try {
	        Connection connection = DataSourceProvider.getDataSource().getConnection();

	        // Utiliser la connexion
	        PreparedStatement stmt = connection.prepareStatement(
	                  "SELECT * FROM `adherent` WHERE `mail`=? and `password`=?");
	        stmt.setString(1, mail);
	        stmt.setString(2, password);
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

	@Override
	public Adherent getAdherent(String licence) {
		
		Adherent adherent=null;
		// Créer une nouvelle connexion à la BDD
	    try {
	        Connection connection = DataSourceProvider.getDataSource().getConnection();

	        // Utiliser la connexion
	        PreparedStatement stmt = connection.prepareStatement(
	                  "SELECT * FROM `adherent` WHERE `numLicence`=?");
	        stmt.setString(1,licence);
	        ResultSet results = stmt.executeQuery();
	        results.next();
	        adherent = new Adherent(results.getString("nom"),
	        		results.getString("prenom"), results.getDate("dateNaissance"),
	        		results.getString("adresse"), results.getString("codePostal"),
	        		results.getString("ville"), results.getString("numLicence"),
	        		results.getString("classement"), results.getString("numPass"),
	        		results.getString("telephone"), results.getString("portable"),
	        		results.getString("mail"), results.getString("password"),
	        		results.getBoolean("certif"), results.getBoolean("prendrePhoto"),
	        		results.getBoolean("publierPhoto"), results.getString("statut"));
	            
	        // Fermer la connexion
	        connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return adherent;
	}

	@Override
	public String getLicenceAdherent(String mail, String password) {
		
		String licence=null;
		try {
	        Connection connection = DataSourceProvider.getDataSource().getConnection();

	        // Utiliser la connexion
	        PreparedStatement stmt = connection.prepareStatement(
	                  "SELECT `numLicence` FROM `adherent` WHERE `mail`=? and `password`=?");
	        stmt.setString(1, mail);
	        stmt.setString(2, password);
	        ResultSet results = stmt.executeQuery();
	        results.next();
	        licence=results.getString("numLicence");

	        // Fermer la connexion
	        connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
		return licence;
	}

	@Override
	public void mettreAJourCoordonneesAdherent(Adherent adherent) {
		
		 try {
		        Connection connection = DataSourceProvider.getDataSource().getConnection();

		        // Utiliser la connexion
		        PreparedStatement stmt = connection.prepareStatement(
		                  "UPDATE `adherent` SET `adresse`=?, `ville`=?, `codePostal`=?, `telephone`=?, `portable`=? "
		                  + "WHERE `numLicence`=?");
		        stmt.setString(1, adherent.getAdresse());
		        stmt.setString(2, adherent.getVille());
		        stmt.setString(3, adherent.getCodePostal());
		        stmt.setString(4,adherent.getTelephone());
		        stmt.setString(5,adherent.getPortable());
		        stmt.setString(6,adherent.getLicence());
		    
		        
		        stmt.executeUpdate();

		        // Fermer la connexion
		        connection.close();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		
	}

	@Override
	public String crypterPassword(String password) throws Exception {
		
			for(int a = 0; a < 3; a++){
				MessageDigest md = MessageDigest.getInstance("MD5");
				md.update(password.getBytes());

				byte byteData[] = md.digest();

				StringBuffer sb = new StringBuffer();
				for (int i = 0; i < byteData.length; i++) {
					sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
				}

				password = sb.toString();
			}

			return password;
			//Renvoi un varchar(32)

	}
	
	public String genererPassword(){
		
		String alphabet = "abcdefghijklmnopqrstuvwxyz1234567890"; 
		String pass="";
		Random rand = new Random(); 
		for (int i=0; i<8; i++) 
		{ 
			pass=pass+alphabet.charAt(rand.nextInt(alphabet.length()));
		} 
		return pass;
	}

	@Override
	public void mettreAJourIdentifiantsAdherent(Adherent adherent) {

		try {
	        Connection connection = DataSourceProvider.getDataSource().getConnection();

	        // Utiliser la connexion
	        PreparedStatement stmt = connection.prepareStatement(
	                  "UPDATE `adherent` SET `mail`=?, `password`=? "
	                  + "WHERE `numLicence`=?");
	        stmt.setString(1, adherent.getMail());
	        stmt.setString(2, adherent.getPassword());
	        stmt.setString(3, adherent.getLicence());	        
	        stmt.executeUpdate();

	        // Fermer la connexion
	        connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	@Override
	public void mettreAJourAdherentCoteAdmin(Adherent adherent) {
		// TODO Auto-generated method stub
		try {
	        Connection connection = DataSourceProvider.getDataSource().getConnection();

	        // Utiliser la connexion
	        PreparedStatement stmt = connection.prepareStatement(
	                  "UPDATE `adherent` SET `nom`=?, `prenom`=?, `dateNaissance`=?, `adresse`=?, "
	                  + "`codePostal`=?, `ville`=?, `telephone`=?, `portable`=?, `mail`=?, `numPass`=?, "
	                  + "`classement`=?, `certif`=?, `statut`=?, `prendrePhoto`=?, `publierPhoto`=? WHERE `numLicence`=?");
	        stmt.setString(1, adherent.getNom());
	        stmt.setString(2, adherent.getPrenom());
	        stmt.setDate(3, new Date(adherent.getDateNaissance().getTime()));
	        stmt.setString(4,adherent.getAdresse());
	        stmt.setString(5,adherent.getCodePostal());
	        stmt.setString(6,adherent.getVille());
	        stmt.setString(7,adherent.getTelephone());
	        stmt.setString(8,adherent.getPortable());
	        stmt.setString(9,adherent.getMail());
	        stmt.setString(10,adherent.getNumPass());
	        stmt.setString(11,adherent.getClassement());
	        stmt.setBoolean(12,adherent.isCertif());
	        stmt.setString(13,adherent.getStatut());
	        stmt.setBoolean(14,adherent.isPrendrePhoto());
	        stmt.setBoolean(15,adherent.isPublierPhoto());
	        stmt.setString(16,adherent.getLicence());
	        
	        stmt.executeUpdate();

	        // Fermer la connexion
	        connection.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	@Override
	public void supprimerAdherent(Adherent adherent) {
		// TODO Auto-generated method stub
		 try {
		        Connection connection = DataSourceProvider.getDataSource().getConnection();

		        // Utiliser la connexion
		        PreparedStatement stmt = connection.prepareStatement(
		                  "DELETE FROM `participer` WHERE `numLicence`=?");
		        stmt.setString(1,adherent.getLicence());
		        stmt.executeUpdate();

		        // Fermer la connexion
		        connection.close();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		 
		 try {
		        Connection connection = DataSourceProvider.getDataSource().getConnection();

		        // Utiliser la connexion
		        PreparedStatement stmt = connection.prepareStatement(
		                  "DELETE FROM `annonce` WHERE `numLicence`=?");
		        stmt.setString(1,adherent.getLicence());
		        stmt.executeUpdate();

		        // Fermer la connexion
		        connection.close();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		 try {
		        Connection connection = DataSourceProvider.getDataSource().getConnection();

		        // Utiliser la connexion
		        PreparedStatement stmt = connection.prepareStatement(
		                  "DELETE FROM `article` WHERE `numLicence`=?");
		        stmt.setString(1,adherent.getLicence());
		        stmt.executeUpdate();

		        // Fermer la connexion
		        connection.close();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		 try {
		        Connection connection = DataSourceProvider.getDataSource().getConnection();

		        // Utiliser la connexion
		        PreparedStatement stmt = connection.prepareStatement(
		                  "DELETE FROM `paiement` WHERE `numLicence`=?");
		        stmt.setString(1,adherent.getLicence());
		        stmt.executeUpdate();

		        // Fermer la connexion
		        connection.close();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		 try {
		        Connection connection = DataSourceProvider.getDataSource().getConnection();

		        // Utiliser la connexion
		        PreparedStatement stmt = connection.prepareStatement(
		                  "DELETE FROM `adherent` WHERE `numLicence`=?");
		        stmt.setString(1,adherent.getLicence());
		        stmt.executeUpdate();

		        // Fermer la connexion
		        connection.close();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
	}

	@Override
	public List<Adherent> listerAdherentInscrit(Cours cours) {
		// TODO Auto-generated method stub
		List<Adherent> listeAdherents = new ArrayList<Adherent>();
		
		try {
			//Crï¿½er une nouvelle connexion ï¿½ la BDD
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			
			//Utiliser la connexion
			
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM `adherent` INNER JOIN `participer` ON adherent.numLicence = participer.numLicence WHERE participer.idCours=? ORDER BY `nom` ASC, `prenom` ASC");
            stmt.setInt(1,cours.getIdCours());
            ResultSet results = stmt.executeQuery();
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
	
}

package hei.projetiti.dao.impl;

import java.sql.Connection;
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
			//Créer une nouvelle connexion à la BDD
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
	
}

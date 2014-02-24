package hei.projetiti.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hei.projetiti.dao.AnnonceDao;
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
            ResultSet results = stmt.executeQuery("SELECT * FROM `annonce`");
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

	
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controlleur.Connexion;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Enseignant;

/**
 *
 * @author victo
 */
public class EnseignantDAO extends DAO<Enseignant> {

    /**
     * Constructeur 
     * @param connect
     */
    public EnseignantDAO(Connexion connect) {
        super(connect);
    }

    /**
     * @param id
     * @param idCours
     * @return ensaignant
     */
    public Enseignant find(int id, int idCours) {
        Enseignant enseignant = new Enseignant();

        try {
            ResultSet rset = con.getStmt().executeQuery("select * from enseignant where ID_Enseignant = " + id + " and ID_Cours = " + idCours);
            if (rset.first()) {
                enseignant = new Enseignant(id, rset.getInt("ID_Cours"));
            }
        } catch (SQLException ex) {
        }

        return enseignant;
    }
    
    /**
     * Fonction qui retourn une liste de tous les id des cours dispensés par l'id de l'enseignant passé en paramètre
     * @param id
     * @return 
     */
    
    public ArrayList<Integer> findCours(int id) {
        ArrayList<Integer> liste;
        liste = new ArrayList<>();

        try {
            ResultSet rset = con.getStmt().executeQuery("select ID_Cours from enseignant where ID_Enseignant = " + id);
            // récupération du résultat de l'ordre
            ResultSetMetaData rsetMeta = rset.getMetaData();

            // calcul du nombre de colonnes du resultat
            int nbColonne = rsetMeta.getColumnCount();
            while(rset.next()){
            for (int i = 0; i < nbColonne; i++) {
            //champs = rset.getObject(i+1).toString();
            liste.add(rset.getInt(i+1));
        }
        }
        } catch (SQLException ex) {
        }

        return liste;
    }
    
    /**
     * Fonction qui retourne une liste de tous les id des enseignants du cours dont l'id est passé en paramètre
     * @param idCours
     * @return 
     */
    public ArrayList<Integer> findEnseignants(int idCours) {
        ArrayList<Integer> liste;
        liste = new ArrayList<>();

        try {
            ResultSet rset = con.getStmt().executeQuery("select ID_Enseignant from enseignant where ID_Cours = " + idCours);
            // récupération du résultat de l'ordre
            ResultSetMetaData rsetMeta = rset.getMetaData();

            // calcul du nombre de colonnes du resultat
            int nbColonne = rsetMeta.getColumnCount();
            while(rset.next()){
            for (int i = 0; i < nbColonne; i++) {
            //champs = rset.getObject(i+1).toString();
            liste.add(rset.getInt(i+1));
        }
        }
        } catch (SQLException ex) {
        }

        return liste;
    }

    @Override
    public Enseignant find(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

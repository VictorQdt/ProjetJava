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
import model.Seance_enseignant;

/**
 *
 * @author victo
 */
public class Seance_enseignantsDAO extends DAO<Seance_enseignant> {

    /**
     * Constructeur 
     * @param connect
     */
    public Seance_enseignantsDAO (Connexion connect) {
        super(connect);
    }

    /**
     * @param id
     * @param idSeance
     */
    public Seance_enseignant find(int id, int idSeance) {
        Seance_enseignant seance_enseignant = new Seance_enseignant();

        try {
            ResultSet rset = con.getStmt().executeQuery("select * from seance_enseignants where ID_Enseignant = " + id + " and ID_Seance = " + idSeance);
            if (rset.first()) {
                seance_enseignant = new Seance_enseignant(id, rset.getInt("ID_Seance"));
            }
        } catch (SQLException ex) {
        }

        return seance_enseignant;
    }
    
    /**
     * Fonction qui retourn une liste de tous les id des seances dispensés par l'id de l'enseignant passé en paramètre
     * @param id
     * @return 
     */
    
    public ArrayList<Integer> findSeances(int id) {
        ArrayList<Integer> liste;
        liste = new ArrayList<>();

        try {
            ResultSet rset = con.getStmt().executeQuery("select ID_Seance from seance_enseignants where ID_Enseignant = " + id);
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
     * Fonction qui retourne une liste de tous les id des enseignants de la séance dont l'id est passé en paramètre
     * @param idSeance
     * @return 
     */
    public ArrayList<Integer> findEnseignants(int idSeance) {
        ArrayList<Integer> liste;
        liste = new ArrayList<>();

        try {
            ResultSet rset = con.getStmt().executeQuery("select ID_Enseignant from seance_enseignants where ID_Seance = " + idSeance);
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
    public Seance_enseignant find(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
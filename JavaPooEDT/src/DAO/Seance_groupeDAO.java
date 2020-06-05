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
import model.Seance_groupe;

/**
 *
 * @author victo
 */
public class Seance_groupeDAO extends DAO<Seance_groupe>{
    
    public Seance_groupeDAO(Connexion connect) {
        super(connect);
    }

    public Seance_groupe find(int id, int idSeance) {
        Seance_groupe Seance_groupe = new Seance_groupe();

        try {
            ResultSet rset = con.getStmt().executeQuery("select * from seance_groupe where ID_Groupe = " + id + " and ID_Seance = " + idSeance);
            if (rset.first()) {
                Seance_groupe = new Seance_groupe(id, rset.getInt("ID_Seance"));
            }
        } catch (SQLException ex) {
        }

        return Seance_groupe;
    }
    
    /**
     * Fonction qui retourn une liste de tous les id des seances du groupe dont l'id est passé en parmaètre
     * @param id
     * @return 
     */
    
    public ArrayList<Integer> findSeances(int id) {
        ArrayList<Integer> liste;
        liste = new ArrayList<>();

        try {
            ResultSet rset = con.getStmt().executeQuery("select ID_Seance from seance_groupe where ID_Groupe = " + id);
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
     * Fonction qui retourne une liste de tous les id des groupes de la séance dont l'id est passé en paramètre
     * @param idSeance
     * @return 
     */
    public ArrayList<Integer> findGroupes(int idSeance) {
        ArrayList<Integer> liste;
        liste = new ArrayList<>();

        try {
            ResultSet rset = con.getStmt().executeQuery("select ID_Groupe from seance_groupe where ID_Seance = " + idSeance);
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
    public Seance_groupe find(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
    


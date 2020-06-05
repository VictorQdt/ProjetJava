/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controlleur.Connexion;
import Controlleur.Connexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Seance;

/**
 *
 * @author victo
 */
public class SeanceDAO extends DAO<Seance>{
    
    public SeanceDAO(Connexion connect) {
        super(connect);
    }
    
    @Override
    public Seance find(int id){
        Seance seance = new Seance();
        
        try {
            ResultSet rset = con.getStmt().executeQuery("select * from seance where ID_Seance = " + id);
            if(rset.first()){
                seance = new Seance(id, rset.getInt("semaine"), rset.getLong("date"), rset.getFloat("duree"),
                        rset.getInt("etat"), rset.getInt("ID_Cours"), rset.getInt("ID_Type"));
            }
        } catch (SQLException ex) {
        }
        
        return seance;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author Paul
 */
import Controlleur.Connexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Salle;


public class SalleDAO extends DAO<Salle>{
    
    public SalleDAO(Connexion connect) {
        super(connect);
    }
    
    @Override
    public Salle find(int id){
        Salle salle = new Salle();
        
        try {
            ResultSet rset = con.getStmt().executeQuery("select * from salle where ID_Salle = " + id);
            if(rset.first()){
                salle = new Salle(id, rset.getInt("capcite"), rset.getString("nom"),rset.getInt("ID_Site"));
            }
        } catch (SQLException ex) {
        }
        
        return salle;
    }
    
}

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
import model.Promotion;


public class PromotionDAO extends DAO<Promotion>{
    
    public PromotionDAO(Connexion connect) {
        super(connect);
    }
    
    @Override
    public Promotion find(int id){
        Promotion promo = new Promotion();
        
        try {
            ResultSet rset = con.getStmt().executeQuery("select * from seance where ID_Promotion = " + id);
            if(rset.first()){
                promo = new Promotion(id, rset.getString("nom"));
            }
        } catch (SQLException ex) {
        }
        
        return promo;
    }
    
}

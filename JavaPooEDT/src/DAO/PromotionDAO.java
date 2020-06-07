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
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
            ResultSet rset = con.getStmt().executeQuery("select * from promotion where ID_Promotion = " + id);
            if(rset.first()){
                promo = new Promotion(id, rset.getString("nom"));
            }
        } catch (SQLException ex) {
        }
        
        return promo;
    }
    public Promotion findId(String nomPromo){
        
        Promotion promo = new Promotion();
        nomPromo = "'"+nomPromo+"'";

        try {
            ResultSet rset = con.getStmt().executeQuery("select * from promotion where nom = " + nomPromo);
            if(rset.first()){
                promo = new Promotion(rset.getInt("ID_Promotion"), nomPromo);
            }
        } catch (SQLException ex) { ex.printStackTrace();
        }
        
        return promo;
    }
    
    public ArrayList<Integer> rechercheTot(){
        ArrayList<Integer> liste;
        liste = new ArrayList<>();
        try {
            ResultSet rset = con.getStmt().executeQuery("select ID_Promotion from promotion");
             System.out.print("5");
            while(rset.next()){
                System.out.print("6");
                liste.add(rset.getInt("ID_Promotion"));
            }
        } catch (SQLException ex) {
        }
        return liste;
    }
    
}

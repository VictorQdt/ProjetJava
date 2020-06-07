/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controlleur.Connexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Cours;


/**
 *
 * @author victo
 */
public class CoursDAO extends DAO<Cours>{
    
    /**
     * Constructeur 
     * @param connect
     */
    public CoursDAO(Connexion connect) {
        super(connect);
    }
    
    @Override
    public Cours find(int id){
        Cours cours = new Cours();
        
        try {
            ResultSet rset = con.getStmt().executeQuery("select * from cours where ID_Cours = " + id);
            if(rset.first()){
                cours = new Cours(id, rset.getString("nom"));
            }
        } catch (SQLException ex) {
        }
        
        return cours;
    }
    
    /** 
     * @return liste
     */
    public ArrayList<String> rechercheTot(){
        ArrayList<String> liste;
        liste = new ArrayList<>();
        try {
            ResultSet rset = con.getStmt().executeQuery("select nom from cours");
            
            while(rset.next()){
                
                liste.add(rset.getString("nom"));
            }
        } catch (SQLException ex) {
        }
        return liste;
    }
    
}

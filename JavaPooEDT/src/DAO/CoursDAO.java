/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controlleur.Connexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Cours;


/**
 *
 * @author victo
 */
public class CoursDAO extends DAO<Cours>{
    
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
    
}

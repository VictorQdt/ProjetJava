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
import model.Type_Cours;

/**
 *
 * @author victo
 */
public class Type_CoursDAO extends DAO<Type_Cours>{
    
    public Type_CoursDAO(Connexion connect) {
        super(connect);
    }
    
    @Override
    public Type_Cours find(int id){
        Type_Cours typecours = new Type_Cours();
        
        try {
            ResultSet rset = con.getStmt().executeQuery("select * from type_cours where ID_Type = " + id);
            if(rset.first()){
                typecours = new Type_Cours(id, rset.getString("nom"));
            }
        } catch (SQLException ex) {
        }
        
        return typecours;
    }
    
    public ArrayList<Integer> rechercheTot(){
        ArrayList<Integer> liste;
        liste = new ArrayList<>();
        try {
            ResultSet rset = con.getStmt().executeQuery("select ID_Type from type_cours");
            while(rset.next()){
                liste.add(rset.getInt("ID_Type"));
            }
        } catch (SQLException ex) {
        }
        return liste;
    }
    
}

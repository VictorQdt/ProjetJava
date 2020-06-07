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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Groupe;


public class GroupeDAO extends DAO<Groupe>{
    
    public GroupeDAO(Connexion connect) {
        super(connect);
    }
    
    @Override
    public Groupe find(int id){
        Groupe groupe = new Groupe();
        
        try {
            ResultSet rset = con.getStmt().executeQuery("select * from groupe where ID_Groupe = " + id);
            if(rset.first()){
                groupe = new Groupe(id, rset.getString("nom"), rset.getInt("ID_Promotion"));
            }
        } catch (SQLException ex) {
        }
        
        return groupe;
    }
    
    public ArrayList<Integer> recherchesGroupesPromo(int id){
        ArrayList<Integer> liste;
        liste = new ArrayList<>();
        try {
            ResultSet rset = con.getStmt().executeQuery("select ID_Groupe from groupe where ID_Promotion = " + id);
            System.out.print("1");
            while(rset.next()){
                System.out.print("testestes2");
                liste.add(rset.getInt("ID_Groupe"));
            }
        } catch (SQLException ex) {
        }
        return liste;
    }
    public ArrayList<Integer> rechercheTot(){
        ArrayList<Integer> liste;
        liste = new ArrayList<>();
        try {
            ResultSet rset = con.getStmt().executeQuery("select ID_Groupe from groupe");
            System.out.print("3");
            while(rset.next()){
                System.out.print("4");
                liste.add(rset.getInt("ID_Groupe"));
            }
        } catch (SQLException ex) {
        }
        return liste;
    }
}

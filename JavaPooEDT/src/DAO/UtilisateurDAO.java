/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controlleur.Connexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Utilisateur;

/**
 *
 * @author victo
 */
public class UtilisateurDAO extends DAO<Utilisateur>{
    
    public UtilisateurDAO(Connexion connect) {
        super(connect);
    }

    
    @Override
    public Utilisateur find(int id) {
        Utilisateur utilisateur = new Utilisateur();
        
        try {
            ResultSet rset = con.getStmt().executeQuery("select * from utilisateur where ID_Utilisateur = " + id);
            if(rset.first()){
                utilisateur = new Utilisateur(id,rset.getString("email"), rset.getString("pwd"), rset.getString("nom"), rset.getString("prenom"), rset.getInt("droit"));
            }
        } catch (SQLException ex) {
        }
        
        return utilisateur;
    }
    
    public Utilisateur findLogin(String email, String pwd){
        Utilisateur utilisateur = new Utilisateur();
  
        try {
            ResultSet rset = con.getStmt().executeQuery("SELECT * FROM utilisateur WHERE email = '" + email +"' AND pwd = '" + pwd + "'"); 
            if(rset.first()){

                utilisateur = new Utilisateur(rset.getInt("ID_Utilisateur"), email, pwd, rset.getString("nom"), rset.getString("prenom"), rset.getInt("droit"));

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return utilisateur;
    }
    
}

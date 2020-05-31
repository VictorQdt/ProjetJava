/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controlleur.Connexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Etudiant;
import model.Etudiant;

/**
 *
 * @author victo
 */
public class EtudiantDAO extends DAO<Etudiant>{
    public EtudiantDAO(Connexion connect) {
        super(connect);
    }
    
    @Override
    public Etudiant find(int id){
        Etudiant etudiant = new Etudiant();
        
        try {
            ResultSet rset = con.getStmt().executeQuery("select * from etudiant where ID_Utilisateur = " + id);
            if(rset.first()){
                etudiant = new Etudiant(id, rset.getInt("numero"), rset.getInt("ID_Groupe"));
            }
        } catch (SQLException ex) {
        }
        
        return etudiant;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Paul
 */

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UtilisateurDAO extends DAO<Utilisateur> {
  public UtilisateurDAO(Connection conn) {
    super(conn);
  }

  @Override
  public boolean create(Utilisateur obj) {
    return false;
  }

  @Override
  public boolean delete(Utilisateur obj) {
    return false;
  }
   
  public boolean update(Utilisateur obj) {
    return false;
  }
   
  public Utilisateur find(int id) {
    Utilisateur utilisateur = new Utilisateur();      
      
<<<<<<< HEAD
    try {
      ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM eleve WHERE elv_id = " + id);
      if(result.first())
        utilisateur = new Utilisateur(
          id,
          result.getString("elv_nom"),
          result.getString("elv_prenom"
        ));         
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return utilisateur;
  }

    @Override
    public boolean update(Utilisateur obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
=======
    ResultSet result = null;
      try {
          result = this.connect.createStatement(
                  ResultSet.TYPE_SCROLL_INSENSITIVE,
                  ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM Utilisateur WHERE ID_Utilisateur = " + id);
      } catch (SQLException ex) {
          Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
      }
      try {
          if(result.first())
              utilisateur = new Utilisateur(
                      id,
                      result.getString("email"),
                      result.getString("pwd"),
                      result.getString("nom"),
                      result.getString("prenom"),
                      result.getInt("droit")
                      
              );
      } catch (SQLException ex) {
          Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
      }
    return utilisateur;
  }

    
>>>>>>> 5a81e7b7daf24d54d0b45909ddf8955273e082b0
}


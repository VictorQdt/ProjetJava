/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;

import DAO.UtilisateurDAO;
import Vue.ListeEDT;
import Vue.MainContainer;
import Vue.PageConnexion;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Utilisateur;

/**
 *
 * @author victo
 */
public class Main {
    
    Utilisateur user;
    Connexion connect;

    public Utilisateur getUser() {
        return user;
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }

    public Connexion getConnect() {
        return connect;
    }

    public void setConnect(Connexion connect) {
        this.connect = connect;
    }
    
    public static void main(String[] args) throws InterruptedException{
        
        Connexion connect = null;
        Utilisateur user;
        PageConnexion co = new PageConnexion();
        
        Thread.sleep(5000);
        
        if(co.getIdUser() != 0){
            
            try {
            connect = new Connexion();
            } catch (SQLException ex) {}
            
            UtilisateurDAO userDAO = new UtilisateurDAO(connect);
            user = userDAO.find(co.getIdUser());
            
            MainContainer fenetre = new MainContainer(user.getId());
            //fenetre.grilleEdt(user);
            fenetre.listeEDT(user);
                       
        }
    }
}

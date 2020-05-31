/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controlleur.Connexion;
import java.sql.Connection;

/**
 *
 * @author victo
 */
public class DAOFactory {
    
    
    protected static final Connexion conn = new Connexion();
    
    public static DAO getSeanceDAO(){
        return new SeanceDAO(conn);
    }


    
}

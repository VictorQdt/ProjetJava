/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;

import DAO.SeanceDAO;
import DAO.DAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Seance;

/**
 *
 * @author victo
 */
public class Test {
    
    public static void main(String[] args){
        
        
        SeanceDAO seanceDao = new SeanceDAO(new Connexion());
        Seance seance = seanceDao.find(1);
        System.out.println(seance.getDuree());
        
        
    }

        
    
    
}

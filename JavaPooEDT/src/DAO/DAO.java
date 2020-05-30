/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Controlleur.Connexion;
import java.sql.*;

/**
 *
 * @author victo
 * @param <T>
 */
public abstract class DAO<T>{
    
    protected Connexion con;
    
    public DAO(Connexion connect){
        this.con = connect;       
    }
    
    /**
     *
     * @param id
     * @return
     */
    public abstract T find(int id);
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controlleur.Connexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Site;

/**
 *
 * @author victo
 */
public class SiteDAO extends DAO<Site>{
    
    public SiteDAO(Connexion connect) {
        super(connect);
    }
    
    @Override
    public Site find(int id){
        Site site = new Site();
        
        try {
            ResultSet rset = con.getStmt().executeQuery("select * from site where ID_Site = " + id);
            if(rset.first()){
                site = new Site(id, rset.getString("nom"));
            }
        } catch (SQLException ex) {
        }
        
        return site;
    }
    
}

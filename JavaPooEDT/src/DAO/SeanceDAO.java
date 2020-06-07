/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controlleur.Connexion;
import Controlleur.Connexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Seance;

/**
 *
 * @author victo
 */
public class SeanceDAO extends DAO<Seance>{
    private final Calendar calendar = Calendar.getInstance();
    
    public SeanceDAO(Connexion connect) {
        super(connect);
    }
    
    @Override
    public Seance find(int id){
        Seance seance = new Seance();
        
        try {
            ResultSet rset = con.getStmt().executeQuery("select * from seance where ID_Seance = " + id);
            if(rset.first()){
                seance = new Seance(id, rset.getInt("semaine"), rset.getLong("date"), rset.getFloat("duree"),
                        rset.getInt("etat"), rset.getInt("ID_Cours"), rset.getInt("ID_Type"));
            }
        } catch (SQLException ex) {
        }
        
        return seance;
    }
    
    public boolean ajouter(long date, double duree, int etat, int ID_Cours, int ID_Type, ArrayList<Integer> ID_Prof, ArrayList<Integer> ID_Groupe
    , ArrayList<Integer> ID_Salle){
        Seance seance = new Seance();
        int ID_Seance = 0;
        int verif = 0;
        
        try {
            ///////////VERIFICATION DISPONIBILITE DES PROF SUR LE CRENEAU/////////
            for(int i = 0; i < ID_Prof.size();i++){
                 ResultSet rset_cours = con.getStmt().executeQuery("SELECT * "
                         + "from seance_enseignants where ID_Enseignant = " + ID_Prof.get(i));
               
                  ArrayList<Integer> ids_seance; 
                ids_seance = new ArrayList<>();
                while(rset_cours.next()){
                    ids_seance.add(rset_cours.getInt("ID_Seance"));
                }
                for (Integer id_s : ids_seance){
                     ResultSet rset = con.getStmt().executeQuery("SELECT * "
                         + "from seance where ID_Seance = " + id_s);
                     
                      if (rset.first()){
                     Timestamp time = new Timestamp(rset.getLong("date"));
                      
                    Date t = new Date(time.getTime());
                    calendar.setTime(t);
                    int heure_f = 0;
                    int duree_heure = (int) Math.floor(rset.getLong("duree"));
                    int duree_minute = (int) (rset.getFloat("duree") - duree_heure);
                    int jour = calendar.get(Calendar.DAY_OF_MONTH);
                    int mois = calendar.get(Calendar.MONTH);
                    int heure_d = calendar.get(Calendar.HOUR_OF_DAY);
                    int minute_d = calendar.get(Calendar.MINUTE);
                    int debut = heure_d*100 + minute_d;
                    int minute_f = minute_d + (duree_minute*60);
                    if(minute_f>59){
                        minute_f = minute_f - 60;
                        heure_f = heure_d + duree_heure + 1;
                    }else{
                        heure_f = (int) (calendar.get(Calendar.HOUR_OF_DAY) + duree_heure);
                    }
                    int fin = heure_f*100 + minute_f;
                    
                    Timestamp time2 = new Timestamp(date);
            
                    Date t2 = new Date(time.getTime());
                    calendar.setTime(t2);
                    int heure_f2 = 0;
                    int duree_heure2 = (int) Math.floor(duree);
                    double duree_minute2 = duree - duree_heure2;
                    int jour2 = calendar.get(Calendar.DAY_OF_MONTH);
                    int mois2 = calendar.get(Calendar.MONTH);
                    int heure_d2 = calendar.get(Calendar.HOUR_OF_DAY);
                    int minute_d2 = calendar.get(Calendar.MINUTE);
                    int debut2 = heure_d2*100 + minute_d2;
                    int minute_f2 = minute_d2 + ((int)duree_minute2*60);
                    if(minute_f2>59){
                        minute_f2 = minute_f2 - 60;
                        heure_f2 = heure_d2 + duree_heure2 + 1;
                    }else{
                        heure_f2 = (int) (calendar.get(Calendar.HOUR_OF_DAY) + duree_heure2);
                    }
                    int fin2 = heure_f2*100 + minute_f2;
                   
                    if(jour == jour2 && mois == mois2){
                        
                        if((debut2>=debut && debut2<=fin) || (fin2>=debut && fin2<=fin)){
                            
                            if (rset.getInt("etat") != 1){
                                verif ++;
                                
                            }
                        }
                    }
                    
                 }
                }
                
            }
            
            ///////////VERIFICATION DISPONIBILITE DES GROUPES SUR LE CRENEAU/////////
            for(int i = 0; i < ID_Groupe.size();i++){
                
                 ResultSet rset_groupe = con.getStmt().executeQuery("SELECT ID_Seance "
                         + "from seance_groupe where ID_Groupe = " + ID_Groupe.get(i));
                ArrayList<Integer> ids_seance; 
                ids_seance = new ArrayList<>();
                while(rset_groupe.next()){
                    ids_seance.add(rset_groupe.getInt("ID_Seance"));
                }
                for (Integer id_s : ids_seance) {
                  
                    
                    ResultSet rset = con.getStmt().executeQuery("SELECT * FROM seance WHERE ID_Seance = " + id_s );
                    if (rset.first()){
                        
                        
                        
                        
                        int ett = rset.getInt("etat");
                        
                        Timestamp time = new Timestamp(rset.getLong("date"));
                        
                        Date t = new Date(time.getTime());
                        calendar.setTime(t);
                        int heure_f = 0;
                        int duree_heure = (int) Math.floor(rset.getLong("duree"));
                        int duree_minute = (int) (rset.getFloat("duree") - duree_heure);
                        
                        int jour = calendar.get(Calendar.DAY_OF_MONTH);
                        int mois = calendar.get(Calendar.MONTH);
                        int heure_d = calendar.get(Calendar.HOUR_OF_DAY);
                        int minute_d = calendar.get(Calendar.MINUTE);
                        int debut = heure_d*100 + minute_d;
                        int minute_f = minute_d + (duree_minute*60);
                        if(minute_f>59){
                            minute_f = minute_f - 60;
                            heure_f = heure_d + duree_heure + 1;
                        }else{
                            heure_f = (int) (calendar.get(Calendar.HOUR_OF_DAY) + duree_heure);
                        }
                        int fin = heure_f*100 + minute_f;
                        
                        Timestamp time2 = new Timestamp(date);
                        
                        Date t2 = new Date(time.getTime());
                        calendar.setTime(t2);
                        int heure_f2 = 0;
                        int duree_heure2 = (int) Math.floor(duree);
                        double duree_minute2 = duree - duree_heure2;
                        int jour2 = calendar.get(Calendar.DAY_OF_MONTH);
                        int mois2 = calendar.get(Calendar.MONTH);
                        int heure_d2 = calendar.get(Calendar.HOUR_OF_DAY);
                        int minute_d2 = calendar.get(Calendar.MINUTE);
                        int debut2 = heure_d2*100 + minute_d2;
                        int minute_f2 = minute_d2 + ((int)duree_minute2*60);
                        if(minute_f2>59){
                            minute_f2 = minute_f2 - 60;
                            heure_f2 = heure_d2 + duree_heure2 + 1;
                        }else{
                            heure_f2 = (int) (calendar.get(Calendar.HOUR_OF_DAY) + duree_heure2);
                        }
                        int fin2 = heure_f2*100 + minute_f2;
                        
                        if(jour == jour2 && mois == mois2){
                            if((debut2>=debut && debut2<=fin) || (fin2>=debut && fin2<=fin)){
                                
                                if (ett != 1){
                                    
                                    verif ++;
                                }
                            }
                        }
                        
                    }
                    
                }  
                  
            }
             
             ///////////VERIFICATION DISPONIBILITE DES SALLES SUR LE CRENEAU/////////
             for(int i = 0; i < ID_Salle.size();i++){
                 ResultSet rset_salle = con.getStmt().executeQuery("SELECT * "
                         + "from seance_salles where ID_Salle = " + ID_Salle.get(i));
                  ArrayList<Integer> ids_seance; 
                ids_seance = new ArrayList<>();
                while(rset_salle.next()){
                    ids_seance.add(rset_salle.getInt("ID_Seance"));
                }
                
                for (Integer id_s : ids_seance){
                     ResultSet rset = con.getStmt().executeQuery("SELECT * "
                         + "from seance where ID_Seance = " + id_s);
                      
                    if(rset.first()){
                        
                     Timestamp time = new Timestamp(rset.getLong("date"));
                   
                    Date t = new Date(time.getTime());
                    calendar.setTime(t);
                    int heure_f = 0;
                    
                    int duree_heure = (int) Math.floor(rset.getLong("duree"));
                    int duree_minute = (int) (rset.getFloat("duree") - duree_heure);
                     
                    int jour = calendar.get(Calendar.DAY_OF_MONTH);
                    int mois = calendar.get(Calendar.MONTH);
                    int heure_d = calendar.get(Calendar.HOUR_OF_DAY);
                    int minute_d = calendar.get(Calendar.MINUTE);
                    int debut = heure_d*100 + minute_d;
                    int minute_f = minute_d + (duree_minute*60);
                    if(minute_f>59){
                        minute_f = minute_f - 60;
                        heure_f = heure_d + duree_heure + 1;
                    }else{
                        heure_f = (int) (calendar.get(Calendar.HOUR_OF_DAY) + duree_heure);
                    }
                    int fin = heure_f*100 + minute_f;
                    
                    Timestamp time2 = new Timestamp(date);
                   
                    Date t2 = new Date(time.getTime());
                    calendar.setTime(t2);
                    int heure_f2 = 0;
                    int duree_heure2 = (int) Math.floor(duree);
                    double duree_minute2 = duree - duree_heure2;
                    int jour2 = calendar.get(Calendar.DAY_OF_MONTH);
                    int mois2 = calendar.get(Calendar.MONTH);
                    int heure_d2 = calendar.get(Calendar.HOUR_OF_DAY);
                    int minute_d2 = calendar.get(Calendar.MINUTE);
                    int debut2 = heure_d2*100 + minute_d2;
                    int minute_f2 = minute_d2 + ((int)duree_minute2*60);
                    if(minute_f2>59){
                        minute_f2 = minute_f2 - 60;
                        heure_f2 = heure_d2 + duree_heure2 + 1;
                    }else{
                        heure_f2 = (int) (calendar.get(Calendar.HOUR_OF_DAY) + duree_heure2);
                    }
                    int fin2 = heure_f2*100 + minute_f2;
                    
                    if(jour == jour2 && mois == mois2){
                        if((debut2>=debut && debut2<=fin) || (fin2>=debut && fin2<=fin)){
                            if (rset.getInt("etat") != 1){
                                
                                verif ++;
                            }
                        }
                    }
                    
                 }
                }
            }
            
             ///////////VERIFICATION DE lA CAPACITE DES SALLES SUR LE CRENEAU/////////
             int capacite_salle = 0;
             for(int i = 0; i < ID_Salle.size();i++){
                 ResultSet rset_salle = con.getStmt().executeQuery("SELECT * "
                         + "from salle where ID_Salle = " + ID_Salle.get(i));
                 if(rset_salle.first()){
                     
                     capacite_salle = capacite_salle + rset_salle.getInt("capacite");
                      
                 }
            }
             int capacite_groupe = 0;
             for(int i = 0; i < ID_Groupe.size();i++){
                 ResultSet rset_groupe = con.getStmt().executeQuery("SELECT COUNT(*) as count "
                         + "FROM etudiant WHERE ID_Groupe = " + ID_Groupe.get(i)+";");
                     
                 if(rset_groupe.first()){
                     capacite_groupe = capacite_groupe + rset_groupe.getInt("count");
                 }
                     
                      

            }
            
            if(capacite_groupe > capacite_salle){
                verif ++;
            }
            
            if(etat == 1){
                verif ++;
            }
            
            
            
            if(verif == 0){
                long time1 = (long) date; // Date
            Timestamp time = new Timestamp(time1);
            
            Date t = new Date(time.getTime());
            calendar.setTime(t);
            int id_seance;
            int semaine = calendar.get(Calendar.WEEK_OF_YEAR);
                int execute = con.getStmt().executeUpdate("INSERT INTO seance (semaine,date, duree, etat, ID_Cours, ID_Type) VALUES ("+semaine+","+date+","+duree+","
                    +etat+","+ID_Cours+","+ID_Type+")");
                ResultSet rset_id = con.getStmt().executeQuery("SELECT MAX(ID_Seance) as id FROM seance;");
                if(rset_id.first()){
                    id_seance = rset_id.getInt("id");
                 
                for(int i = 0; i < ID_Prof.size();i++){
                    
                    con.getStmt().executeUpdate("INSERT INTO seance_enseignants (ID_Seance, ID_Enseignant) VALUES ("+id_seance+","
                    +ID_Prof.get(i)+");");
                }
                
                for(int i = 0; i < ID_Groupe.size();i++){
                    con.getStmt().executeUpdate("INSERT INTO seance_groupe (ID_Seance, ID_Groupe) VALUES ("+id_seance+","
                    +ID_Groupe.get(i)+");");
                }
                
                for(int i = 0; i < ID_Salle.size();i++){
                    con.getStmt().executeUpdate("INSERT INTO seance_salles (ID_Seance, ID_Salle) VALUES ("+id_seance+","
                    +ID_Salle.get(i)+");");
                }
                }
                
                
                
            }
                         
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        if(verif == 0){
            return true;
        }else{
            return false;
        }
    }
    
   
    public void modifier(int id){
        Seance seance = new Seance();
        
        try {
            ResultSet rset = con.getStmt().executeQuery("select * from seance where ID_Seance = " + id);
            if(rset.first()){
                seance = new Seance(id, rset.getInt("semaine"), rset.getLong("date"), rset.getFloat("duree"),
                        rset.getInt("etat"), rset.getInt("ID_Cours"), rset.getInt("ID_Type"));
            }
        } catch (SQLException ex) {
        }
        
      
    }
    
    public void annuler(int id){
        
        
        try {
            con.getStmt().executeUpdate("UPDATE seance SET etat = '1' WHERE ID_Seance = " + id);
            
        } catch (SQLException ex) {
        }
        
      
    }
    
    public void valider(int id){
        
        
        try {
            con.getStmt().executeUpdate("UPDATE seance SET etat = '0' WHERE ID_Seance = " + id);
            
        } catch (SQLException ex) {
        }
        
      
    }
    

    public void supprimer(int id){
        
        
        try {
            con.getStmt().executeUpdate("DELETE FROM seance WHERE ID_Seance = " + id);
            
        } catch (SQLException ex) {
        }      
       
    }
    
    
    
}

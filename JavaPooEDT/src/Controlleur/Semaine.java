/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;

import static java.lang.System.console;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 *
 * @author Paul
 */
public class Semaine {
    
    private final Calendar calendar = Calendar.getInstance();
    int id_semaine = 0;
    
    public Semaine(){
    }
    
    public int getWeek(int ajout){
        Date t = new Date();
        calendar.setTime(t);
        calendar.add(Calendar.DATE, ajout); 
        int jour = calendar.get(Calendar.DAY_OF_MONTH);
        int mois = calendar.get(Calendar.MONTH) + 1;
        int J = calendar.get(Calendar.DAY_OF_WEEK) - 1;
        float p = (float) (30.6*mois - 32.3);
        int n = (int) (jour + Math.floor(p) + 1);
        int id_semaine = ((J + n + 5)/7) - (J/5);
        return id_semaine;
    }
   

    public static void main(String[] args) {

            new Semaine();
            
    }

}

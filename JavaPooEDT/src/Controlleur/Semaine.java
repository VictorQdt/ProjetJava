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
        int id_semaine = calendar.get(Calendar.WEEK_OF_YEAR);
        return id_semaine;
    }
   
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import javax.swing.*;
import java.awt.*;
import java.sql.Timestamp;
import java.util.*;
import java.text.*;

/**
 *
 * @author victo
 */
public class Grille extends JPanel {

    @Override
    public void paintComponent(Graphics g) {
                MenuBar bar = new MenuBar();
        g.setColor(Color.black);
        
        /// Méthode provisoire de récuppération d'heure et date. A adapter avec la récuppération depuis la base de données.
        // On recevera une arraylist de cours qu'on affichera 

        Timestamp timestamp = new Timestamp(System.currentTimeMillis()); //Timestamp forme date
        long timestamp1 = timestamp.getTime(); //Timestamp forme long int

        Date date = new Date(timestamp.getTime()); //Création de la date en fonction 

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        int jour = calendar.get(Calendar.DAY_OF_WEEK) - 2;
        int heure = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        double start = (heure + (minute * 0.016667) - 12) ;

        int uniteX = getWidth() / 6;
        int uniteY = getHeight() / 12;
        
        double Ystart = (uniteY*start);
        
        g.fillRect(uniteX * jour, (int) Ystart, uniteX, uniteY);

        for (int i = 0; i < 6; i++) {
            g.drawLine(uniteX * i, 0, uniteX * i, getHeight());

        }
        for (int y = 0; y < 12; y++) {
            g.drawLine(0, uniteY * y, getWidth(), uniteY * y);
        }
    }

    public void displayCourses() {

        Timestamp timestamp = new Timestamp(System.currentTimeMillis()); //Timestamp forme date
        long timestamp1 = timestamp.getTime(); //Timestamp forme long int

        Date date = new Date(timestamp.getTime()); //Création de la date en fonction 

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        int jour = calendar.get(Calendar.DAY_OF_WEEK) - 2;
        int heure = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        double start =  (heure + (minute * 0.016667) - 12) ;

        int uniteX = getWidth() / 6;
        int uniteY = getHeight() / 12;
        
        System.out.print(jour + " " + " " + heure  + " " + minute+ " " + start);

    }

    public static void main(String[] args) {
        Grille test = new Grille();
        test.displayCourses();

    }
}

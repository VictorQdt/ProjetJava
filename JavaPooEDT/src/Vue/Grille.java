/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Controlleur.Connexion;
import Controlleur.InfosCours;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author victo
 */
public class Grille extends JPanel implements MouseListener{

    private static final long serialVersionUID = 1L;
    
    private static int larg = 150;
    private static int larg2 = larg / 2;
    private static int larg3 = larg2 / 2;
    
    
    public Grille(){
        this.setOpaque(false);
        //this.setLayout(null);
    }

    private final Calendar calendar = Calendar.getInstance();

    //@Override

    public void paintGrille(Graphics g, int x, int y) {
        
        //this.addMouseListener(this);

        Timestamp timestamp = new Timestamp(System.currentTimeMillis()); //Timestamp forme date
        long timestamp1 = timestamp.getTime(); //Timestamp forme long int

        Date date = new Date(timestamp.getTime()); //Création de la date en fonction 

        /*int larg = 150;
        int larg2 = larg / 2;
        int larg3 = larg2 / 2;*/

        int uniteX = (x - larg) / 6;
        int uniteY = (y - larg) / 13;

        g.setColor(Color.black);

        for (int i = 0; i < 7; i++) {

            switch (i) {
                case 0:
                    g.drawString("Lundi", (uniteX * i) + (uniteX * 3) / 8 + larg2, larg3 + larg3 / 2);
                    break;
                case 1:
                    g.drawString("Mardi", (uniteX * i) + (uniteX * 3) / 8 + larg2, larg3 + larg3 / 2);
                    break;
                case 2:
                    g.drawString("Mercredi", (uniteX * i) + (uniteX * 3) / 8 + larg2, larg3 + larg3 / 2);
                    break;
                case 3:
                    g.drawString("Jeudi", (uniteX * i) + (uniteX * 3) / 8 + larg2, larg3 + larg3 / 2);
                    break;
                case 4:
                    g.drawString("Vendredi", (uniteX * i) + (uniteX * 3) / 8 + larg2, larg3 + larg3 / 2);
                    break;
                case 5:
                    g.drawString("Samedi", (uniteX * i) + (uniteX * 3) / 8 + larg2, larg3 + larg3 / 2);
                    break;
            }

            g.drawLine((uniteX * i) + larg2, larg2, (uniteX * i) + larg2, (uniteY * 13) + larg2);

        }
        for (int y2 = 0; y2 < 14; y2++) {

            String marquageheure = (y2 + 8) + "h";
            g.drawString(marquageheure, larg3, uniteY * (y2) + larg2);
            g.drawLine(larg2, (uniteY * y2) + larg2, (uniteX * 6) + larg2, (uniteY * y2) + larg2);

        }

        /*ArrayList<Object> liste;
        liste = new ArrayList<>();

        InfosCours infos = new InfosCours(); /// Méthode provisoire de récuppération d'heure et date. A adapter avec la récuppération depuis la base de données.
        // On recevera une arraylist de cours qu'on affichera
        
        try{
            liste = infos.rechercheCoursEtudiant(1);
        }catch(SQLException e){
            
        }

        while (!liste.isEmpty()) {
            
            int i = 0;
            
            ArrayList<Object> test;
            test = new ArrayList<>();
            
            test = (ArrayList<Object>) liste.get(i);
            
            
            long time1 = (long) test.get(i); // Date
            Timestamp time = new Timestamp(time1);
            
            Date t = new Date(time.getTime());
            calendar.setTime(t);
            int jour = calendar.get(Calendar.DAY_OF_WEEK) - 2;
            int heure = calendar.get(Calendar.HOUR_OF_DAY);
            int minute = calendar.get(Calendar.MINUTE);
            double start = (heure + (minute * 0.016667) - 8);
            
            double Ystart = (uniteY * start);
            
            i = 1; // Durée
            float duree = (float) test.get(i);
            
            i = 2; // Etat
            int id = (int) test.get(i);
            if (id % 2 == 0) {
                g.setColor(Color.red);
            } else {
                g.setColor(Color.BLUE);
            }
            
            g.fillRect((uniteX * jour) + larg2, ((int) Ystart) + larg2, uniteX, (int) (uniteY * duree));
            g.setColor(Color.black);
            
            
            liste.remove(0);
            
        }*/
    }

    public void displayCourses(Graphics g, int id12) {
        
        
        
        int uniteX = (getWidth() - larg) / 6;
        int uniteY = (getHeight() - larg) / 13;
        
        ArrayList<Object> liste;
        liste = new ArrayList<>();

        InfosCours infos = new InfosCours(); /// Méthode provisoire de récuppération d'heure et date. A adapter avec la récuppération depuis la base de données.
        // On recevera une arraylist de cours qu'on affichera
        
        try{
            liste = infos.rechercheCoursEtudiant(1);
        }catch(SQLException e){
            
        }

        while (!liste.isEmpty()) {
            
            int i = 0;
            
            ArrayList<Object> test;
            test = new ArrayList<>();
            
            test = (ArrayList<Object>) liste.get(i);
            
            
            long time1 = (long) test.get(i); // Date
            Timestamp time = new Timestamp(time1);
            
            Date t = new Date(time.getTime());
            calendar.setTime(t);
            int jour = calendar.get(Calendar.DAY_OF_WEEK) - 2;
            int heure = calendar.get(Calendar.HOUR_OF_DAY);
            int minute = calendar.get(Calendar.MINUTE);
            double start = (heure + (minute * 0.016667) - 8);
            
            double Ystart = (uniteY * start);
            
            i = 1; // Durée
            float duree = (float) test.get(i);
            
            i = 2; // Etat
            int id = (int) test.get(i);
            if (id % 2 == 0) {
                g.setColor(Color.red);
            } else {
                g.setColor(Color.BLUE);
            }
            
            g.fillRect((uniteX * jour) + larg2, ((int) Ystart) + larg2, uniteX, (int) (uniteY * duree));
            g.setColor(Color.black);
            
            
            liste.remove(0);
            
        }

        }

    public static void main(String[] args) {
        Grille test = new Grille();
        //test.displayCourses();

    }

    @Override
    public void mouseClicked(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}

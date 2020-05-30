/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Controlleur.Connexion;
import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author victo
 */
public class Grille extends JPanel {

    private final Calendar calendar = Calendar.getInstance();

    @Override
    public void paintComponent(Graphics g) {

        Timestamp timestamp = new Timestamp(System.currentTimeMillis()); //Timestamp forme date
        long timestamp1 = timestamp.getTime(); //Timestamp forme long int

        Date date = new Date(timestamp.getTime()); //Création de la date en fonction 

        int larg = 150;
        int larg2 = larg / 2;
        int larg3 = larg2 / 2;

        int uniteX = (getWidth() - larg) / 6;
        int uniteY = (getHeight() - larg) / 13;

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
        for (int y = 0; y < 14; y++) {

            String marquageheure = (y + 8) + "h";
            g.drawString(marquageheure, larg3, uniteY * (y) + larg2);
            g.drawLine(larg2, (uniteY * y) + larg2, (uniteX * 6) + larg2, (uniteY * y) + larg2);

        }

        ArrayList<Object> liste;
        liste = new ArrayList<>();

        try {
            Connexion con = new Connexion("edt", "root", "");
            liste = con.rechercheCours();
            while (!liste.isEmpty()) {

                int i = 0;
                long time1 = (long) liste.get(i);
                Timestamp time = new Timestamp(time1);

                Date t = new Date(time.getTime());
                calendar.setTime(t);
                int jour = calendar.get(Calendar.DAY_OF_WEEK) - 2;
                int heure = calendar.get(Calendar.HOUR_OF_DAY);
                int minute = calendar.get(Calendar.MINUTE);
                double start = (heure + (minute * 0.016667) - 8);

                double Ystart = (uniteY * start);

                i = 1;
                float duree = (float) liste.get(i);

                i = 2;
                int id = (int) liste.get(i);
                if (id % 2 == 0) {
                    g.setColor(Color.red);
                } else {
                    g.setColor(Color.BLUE);
                }

                g.fillRect((uniteX * jour) + larg2, ((int) Ystart) + larg2, uniteX, (int) (uniteY * duree));
                g.setColor(Color.black);

                liste.remove(0);
                liste.remove(0);
                liste.remove(0);

            }

        } catch (SQLException ex) {
            System.out.println("Pb de co");
        } catch (ClassNotFoundException e) {
            System.out.println("Pb de co 2");
        }

        /// Méthode provisoire de récuppération d'heure et date. A adapter avec la récuppération depuis la base de données.
        // On recevera une arraylist de cours qu'on affichera 
    }

    public void displayCourses() {

    }

    public static void main(String[] args) {
        Grille test = new Grille();
        test.displayCourses();

    }
}

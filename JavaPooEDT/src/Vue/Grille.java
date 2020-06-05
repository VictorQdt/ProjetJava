/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;


import java.awt.*;
import java.sql.Timestamp;
import java.util.*;


/**
 *
 * @author victo
 */
public class Grille {

   
    
    private static int larg = 150;
    private static int larg2 = larg / 2;
    private static int larg3 = larg2 / 2;
    
    
    public Grille(){
        //this.setOpaque(false);
 
    }

    private final Calendar calendar = Calendar.getInstance();


    public void paintGrille(Graphics g, int x, int y) {
        
      

        Timestamp timestamp = new Timestamp(System.currentTimeMillis()); //Timestamp forme date
        long timestamp1 = timestamp.getTime(); //Timestamp forme long int

        Date date = new Date(timestamp.getTime()); //Création de la date en fonction 

      
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

        
    }


        




    
    
}

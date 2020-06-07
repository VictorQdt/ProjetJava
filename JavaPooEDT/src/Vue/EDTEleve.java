/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Controlleur.InfosCours;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.*;

/**
 *
 * @author victo
 */
public class EDTEleve extends JPanel{

    private static final long serialVersionUID = 1L;
    
    private int idUser;
    private int nbWeek;
    private final Calendar calendar = Calendar.getInstance();
    private String infos22;
   
    

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getNbWeek() {
        return nbWeek;
    }

    public void setNbWeek(int nbWeek) {
        this.nbWeek = nbWeek;
    }
    
    public EDTEleve(int idUser, int nbWeek){
        this.idUser = idUser;
        this.nbWeek = nbWeek;
        this.setLayout(null);
        
    }
    
    public EDTEleve(){
        
        repaint();
       
    }
    
    /**
     * Fonction de aioobe sur stackoverflow https://stackoverflow.com/questions/4413132/problems-with-newline-in-graphics2d-drawstring qui permet le retour à la ligne dans les drawstring
     * @param g
     */
    void drawString(Graphics g, String text, int x, int y) {
    for (String line : text.split("\n"))
        g.drawString(line, x, y += g.getFontMetrics().getHeight()); 
}
    
    
    @Override
    public void paintComponent(Graphics g) {
        
        super.paintComponent(g);
       this.removeAll();
        
        Grille grille = new Grille();
        grille.paintGrille(g, getWidth(), getHeight());
               
        
        Timestamp timestamp = new Timestamp(System.currentTimeMillis()); //Timestamp forme date
        long timestamp1 = timestamp.getTime(); //Timestamp forme long int

        Date date = new Date(timestamp.getTime()); //Création de la date en fonction 

        int larg = 150;
        int larg2 = larg / 2;
        int larg3 = larg2 / 2;

        int uniteX = (getWidth() - larg) / 6;
        int uniteY = (getHeight()- larg) / 13;

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
            ArrayList<String> listeInfos;
            listeInfos = new ArrayList<>();
            
            i = 3;
            
            String phrase;
            phrase = "<html><div style='text-align:center'>" + (String) test.get(i) + "<br>";
            
            i=4;
            
            listeInfos = (ArrayList<String>) test.get(i);
            for (int h=0; h<listeInfos.size(); h++){
                phrase = phrase + listeInfos.get(h);
                listeInfos = (ArrayList<String>) test.get(i+1);
                phrase = phrase + " (" + listeInfos.get(h) + ") ";
            }
            
            phrase = phrase + "<br>";
            
            i=6;
            
            
            ArrayList<Integer> listeCap;
            listeCap = new ArrayList<>();
            
             for (int h=0; h<listeInfos.size(); h++){
                listeInfos = (ArrayList<String>) test.get(i);
                phrase = phrase + listeInfos.get(h);
                listeCap = (ArrayList<Integer>) test.get(i+1);
                phrase = phrase + " (" + listeCap.get(h) + ") ";
                listeInfos = (ArrayList<String>) test.get(i+2);
                phrase = phrase + listeInfos.get(h) + " ";
            }
            
            phrase = phrase + "<br>"; 
            
            i = 9;
            
            listeInfos = (ArrayList<String>) test.get(i);
            
            for (int j = 0; j<listeInfos.size(); j++){
                phrase = phrase + listeInfos.get(j);
            }
             
            g.setColor(Color.black);
            g.setFont(new Font("TimesRoman", Font.BOLD, (getHeight()*getWidth())/100000));
                    phrase = phrase + "</div></html>";
            //drawString(g,phrase, (uniteX * jour) + larg2 + 5, ((int) Ystart) + larg2 + 3);
            
            
            JLabel lab = new JLabel(phrase,SwingConstants.CENTER);
            lab.setSize(new Dimension(uniteX, (int) (uniteY * duree)));
            lab.setOpaque(true);
            lab.setBackground(Color.CYAN);
            lab.setBounds((uniteX * jour) + larg2+1, ((int) Ystart) + larg2, uniteX-1, (int) (uniteY * duree));
            lab.setToolTipText("<html>je fais des test on va bien voir <br> et la ca marche ?</html>");
            add(lab);
            
            liste.remove(0);
            
        }
       
    }
    
    
  
    
}

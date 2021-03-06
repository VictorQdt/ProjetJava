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
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.*;
import model.Cours;
import model.Utilisateur;

/**
 *
 * @author victo
 */
public class EDTGrille extends JPanel{

    private static final long serialVersionUID = 1L;
    
    private int idUser;
    private int nbWeek;
    private int idSemaine;
    private final Calendar calendar = Calendar.getInstance();
    private String infos22;
    private int droitUser;
    

    /**
     *
     * @return idUser
     */
    public int getIdUser() {
        return idUser;
    }

    /**
     *
     * @param idUser
     */
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    /**
     *
     * @return nbWeek
     */
    public int getNbWeek() {
        return nbWeek;
    }

    /**
     *
     * @param nbWeek
     */
    public void setNbWeek(int nbWeek) {
        this.nbWeek = nbWeek;
    }
    
    /**
     *
     * @param idUser
     * @param droit
     * @param semaineAct
     */
    public EDTGrille(int idUser, int droit, int semaineAct){
        this.idUser = idUser;
        this.droitUser = droit;
        this.idSemaine = semaineAct;
        this.setLayout(null);
        
            
        
        
    }
    
    public EDTGrille(){
        
        repaint();
       
    }
    
    /**
     * Fonction de aioobe sur stackoverflow https://stackoverflow.com/questions/4413132/problems-with-newline-in-graphics2d-drawstring qui permet le retour à la ligne dans les drawstring
     * @param g
     * @param text
     * @param x
     * @param y
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
               
        paintEDTGrille(g, getWidth(), getHeight(), droitUser,idSemaine);
       
       
    }
    
    /**
     * Fonction d'ajout graphique des cours sur l'emploi du temps
     * @param g le Graphics utilisé par paintComponent
     * @param x x qui sera remplacé par getWidth()
     * @param y y qui sera ramplacé par getHeight()
     * @param droit
     * @param semaineAct
     */
    public void paintEDTGrille(Graphics g, int x, int y, int droit, int semaineAct){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis()); //Timestamp forme date
        long timestamp1 = timestamp.getTime(); //Timestamp forme long int

        Date date = new Date(timestamp.getTime()); //Création de la date en fonction 

        int larg = 150;
        int larg2 = larg / 2;
        int larg3 = larg2 / 2;
        
        int uniteX = (x - larg) / 6;
        int uniteY = (y- larg) / 13;

        ArrayList<Object> liste;
        liste = new ArrayList<>();
        int droit1 = 1;

        InfosCours infos = new InfosCours(); 
        // On recevera une arraylist de cours qu'on affichera
        
        try{
            switch(droit){
               
                case 3 :
                    liste = infos.rechercheCoursProf(idUser);
                    break;
                case 4 :
                    liste = infos.rechercheCoursEtudiant(idUser);
                    break;
                default :
                    break;
            }
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
            int semaine = calendar.get(Calendar.WEEK_OF_YEAR);
            if(semaine == semaineAct){
                
            double start = (heure + (minute * 0.016667) - 8);
            
            double Ystart = (uniteY * start);
            
            i = 1; // Durée
            float duree = (float) test.get(i); //Duree
            
           
           
            ArrayList<String> listeInfos;
            listeInfos = new ArrayList<>();
            
            i = 3;
            
            String phrase;
            String phrase2;
            phrase = "<html><div style='text-align:center'>" + (String) test.get(i) + "<br>";
            phrase2 = phrase;
            
            i=4;
            
            listeInfos = (ArrayList<String>) test.get(i);
            for (int h=0; h<listeInfos.size(); h++){
                if(h <= 2){
                phrase2 = phrase2 + listeInfos.get(h);
                listeInfos = (ArrayList<String>) test.get(i+1);
                phrase2 = phrase2 + " (" + listeInfos.get(h) + ") ";
                if (h==2){
                    phrase2 = phrase2 + "(...)";
                }
                }
                phrase = phrase + listeInfos.get(h);
                listeInfos = (ArrayList<String>) test.get(i+1);
                phrase = phrase + " (" + listeInfos.get(h) + ") ";
            }
            
            phrase = phrase + "<br>";
            phrase2 = phrase2 + "<br>";
            i=6;
            
            
            ArrayList<Integer> listeCap;
            listeCap = new ArrayList<>();
            
             for (int h=0; h<listeInfos.size(); h++){
                if(h<=2){
                    listeInfos = (ArrayList<String>) test.get(i);
                phrase2 = phrase2 + listeInfos.get(h);
                listeCap = (ArrayList<Integer>) test.get(i+1);
                phrase2 = phrase2 + " (" + listeCap.get(h) + ") ";
                listeInfos = (ArrayList<String>) test.get(i+2);
                phrase2 = phrase2 + listeInfos.get(h) + " ";
                if (h==2){
                    phrase2 = phrase2 + "(...)";
                }
                }
                listeInfos = (ArrayList<String>) test.get(i);
                phrase = phrase + listeInfos.get(h);
                listeCap = (ArrayList<Integer>) test.get(i+1);
                phrase = phrase + " (" + listeCap.get(h) + ") ";
                listeInfos = (ArrayList<String>) test.get(i+2);
                phrase = phrase + listeInfos.get(h) + " ";
            }
            
            phrase = phrase + "<br>"; 
           
            phrase2 = phrase2 + "<br>";
            i = 9;
            
            listeInfos = (ArrayList<String>) test.get(i);
            
            for (int j = 0; j<listeInfos.size(); j++){
                if(j<=2){
                    phrase2 = phrase2 + listeInfos.get(j);
                }
                phrase = phrase + listeInfos.get(j);
            }
             
            
            phrase = phrase + "</div></html>";
            phrase2 = phrase2 + "</div></html>";
            
            
            Cours cours = (Cours) test.get(10);
            int idCours = cours.getId();
            Colours genColor = new Colours();
            Color couleur = genColor.generateColor(idCours);
                    
                    
             i = 2; // Etat
            int etat = (int) test.get(i);
            if (etat == 0) {
                
            JLabel lab = new JLabel(phrase2,SwingConstants.CENTER);
            lab.setSize(new Dimension(uniteX, (int) (uniteY * duree)));
            lab.setOpaque(true);
            lab.setBackground(couleur);
            lab.setBounds((uniteX * jour) + larg2+1, ((int) Ystart) + larg2, uniteX-1, (int) (uniteY * duree));
            lab.setToolTipText(phrase);
            add(lab);
              
            } else if (etat == 1){
                JLabel lab2 = new JLabel ("<html><div style = 'text-align:center'>ANNULÉ</div></html>",SwingConstants.CENTER);
                lab2.setOpaque(true);
                lab2.setBackground(Color.WHITE);
                lab2.setForeground(Color.RED);
                lab2.setBounds((uniteX * jour) + larg2+uniteX/10, ((int) Ystart) + larg2 + uniteY/10, uniteX-2*uniteX/10, (int) uniteY - 6*uniteY/10);
                add(lab2);
                JLabel lab = new JLabel((String) test.get(3),SwingConstants.CENTER);
            lab.setSize(new Dimension(uniteX, (int) (uniteY * duree)));
            lab.setOpaque(true);
            lab.setBackground(couleur);
            lab.setBounds((uniteX * jour) + larg2+1, ((int) Ystart)+1 + larg2, uniteX-1, (int) (uniteY * duree)-1);
            lab.setToolTipText("Ce cours a été annulé");
            add(lab);
            } else if (etat == 2 && droitUser != 4){
                JLabel lab2 = new JLabel ("<html><div style = 'text-align:center'>A VALIDER</div></html>",SwingConstants.CENTER);
                lab2.setOpaque(true);
                lab2.setBackground(Color.WHITE);
                lab2.setForeground(Color.RED);
                lab2.setBounds((uniteX * jour) + larg2+uniteX/10, ((int) Ystart) + larg2 + uniteY/10, uniteX-2*uniteX/10, (int) uniteY - 6*uniteY/10);
                add(lab2);
                JLabel lab = new JLabel((String) test.get(3),SwingConstants.CENTER);
            lab.setSize(new Dimension(uniteX, (int) (uniteY * duree)));
            lab.setOpaque(true);
            lab.setBackground(couleur);
            lab.setBounds((uniteX * jour) + larg2+1, ((int) Ystart)+1 + larg2, uniteX-1, (int) (uniteY * duree)-1);
            lab.setToolTipText(phrase + " - A VALIDER");
            add(lab);
            }
            
            }
            
            liste.remove(0);
                
            
            
        }
        }
        
    }
  
    


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
import java.awt.GridLayout;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import model.Cours;

/**
 *
 * @author victo
 */
public class ListeEDT extends JPanel {

    int idUser;
    Calendar calendar = Calendar.getInstance();
    int semaineAct;

    public ListeEDT() {
        repaint();
    }

    /*public ListeEDT(int identifiant) {
        this.idUser = identifiant;
        
        this.setLayout(null);
    }*/

    @Override
    public void paintComponent(Graphics g) {
        //this.removeAll();
        super.paintComponent(g);

        //paintEDTListe(0, 0, 3);

    }

    /**
     *
     * @param identifiant
     * @param droit
     * @param semaine2
     */
    public ListeEDT(/*Graphics g,*/int identifiant, int droit, int semaine2) {

        this.idUser = identifiant;
        this.semaineAct = semaine2;
        
        int compteurLun = 0;
        int compteurMar = 0;
        int compteurMer = 0;
        int compteurJeu = 0;
        int compteurVen = 0;
        int compteurSam = 0;

        Timestamp timestamp = new Timestamp(System.currentTimeMillis()); //Timestamp forme date
        long timestamp1 = timestamp.getTime(); //Timestamp forme long int

        Date date = new Date(timestamp.getTime()); //Création de la date en fonction 

        int larg = 150;
        int larg2 = larg / 2;
        int larg3 = larg2 / 2;

        

        ArrayList<Object> liste;
        liste = new ArrayList<>();
        int droit1 = 3;

        InfosCours infos = new InfosCours();
        // On recevera une arraylist de cours qu'on affichera

        try {
            switch (droit) {

                case 3:
                    liste = infos.rechercheCoursProf(idUser);

                    break;
                case 4:
                    liste = infos.rechercheCoursEtudiant(idUser);
                    break;
                default:
                    break;
            }
        } catch (SQLException e) {

        }
        
        this.setLayout(new GridLayout(liste.size()+6,1));

        ArrayList<Object> lundi;
        lundi = new ArrayList<>();

        ArrayList<Object> mardi;
        mardi = new ArrayList<>();

        ArrayList<Object> mercredi;
        mercredi = new ArrayList<>();

        ArrayList<Object> jeudi;
        jeudi = new ArrayList<>();

        ArrayList<Object> vendredi;
        vendredi = new ArrayList<>();

        ArrayList<Object> samedi;
        samedi = new ArrayList<>();

        while (!liste.isEmpty()) {

            ArrayList<Object> test;
            test = new ArrayList<>();

            test = (ArrayList<Object>) liste.get(0);

            long time1 = (long) test.get(0); // Date
            Timestamp time = new Timestamp(time1);

            Date t = new Date(time.getTime());
            calendar.setTime(t);
            int jour = calendar.get(Calendar.DAY_OF_WEEK) - 1;
            int semaine = calendar.get(Calendar.WEEK_OF_YEAR);
            if (semaine == semaineAct){
                switch (jour) {
                case 1:
                    lundi.add(liste.get(0));
                    compteurLun++;
                    break;
                case 2:
                    mardi.add(liste.get(0));
                    compteurMar++;
                    break;
                case 3:
                    mercredi.add(liste.get(0));
                    compteurMer++;
                    break;
                case 4:
                    jeudi.add(liste.get(0));
                    compteurJeu++;
                    break;
                case 5:
                    vendredi.add(liste.get(0));
                    compteurVen++;
                    break;
                case 6:
                    samedi.add(liste.get(0));
                    compteurSam++;
                    break;
                default:
                    break;
                    
            }
            }
            
           
            

            liste.remove(0);

        }
        JLabel lun = new JLabel("Lundi");
        lun.setBackground(Color.YELLOW);
        lun.setOpaque(true);
        add(lun);
        ajoutCours(lundi);
        JLabel mar = new JLabel("Mardi");
        mar.setBackground(Color.YELLOW);
        mar.setOpaque(true);
        add(mar);
        ajoutCours(mardi);
        JLabel mer = new JLabel("Mercredi");
        mer.setBackground(Color.YELLOW);
        mer.setOpaque(true);
        add(mer);
        ajoutCours(mercredi);
        JLabel jeu = new JLabel("Jeudi");
        jeu.setBackground(Color.YELLOW);
        jeu.setOpaque(true);
        add(jeu);
        ajoutCours(jeudi);
        JLabel ven = new JLabel("Vendredi");
        ven.setBackground(Color.YELLOW);
        ven.setOpaque(true);
        add(ven);
        ajoutCours(vendredi);
        JLabel sam = new JLabel("Samedi");
        sam.setBackground(Color.YELLOW);
        sam.setOpaque(true);
        add(sam);
        ajoutCours(samedi);
    }
    
    
    /**
     *
     * @param liste
     */
    public void ajoutCours(ArrayList<Object> liste){
            
            while(!liste.isEmpty()){
        
            ArrayList<Object> test;
            test = new ArrayList<>();
            
            test = (ArrayList<Object>) liste.get(0);
            
            String horaire;
            
            long time1 = (long) test.get(0); // Date
            Timestamp time = new Timestamp(time1);

            Date t = new Date(time.getTime());
            calendar.setTime(t);
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            int min = calendar.get(Calendar.MINUTE);
            int week = calendar.get(Calendar.WEEK_OF_YEAR);
            horaire = String.valueOf(hour) + "h" + String.valueOf(min) + " - ";
            
            int i = 1; // Durée
            float duree = (float) test.get(i); //Duree
            horaire = horaire + String.valueOf(duree) + "h - ";
            
            ArrayList<String> listeInfos;
            listeInfos = new ArrayList<>();

            i = 3;

            String phrase;
            String phrase2;
            phrase = "<html>" + (String) test.get(i) + " - ";
            phrase += horaire;
            phrase2 = phrase;

            i = 4;

            listeInfos = (ArrayList<String>) test.get(i);
            for (int h = 0; h < listeInfos.size(); h++) {
                
                phrase = phrase + listeInfos.get(h);
                listeInfos = (ArrayList<String>) test.get(i + 1);
                phrase = phrase + " (" + listeInfos.get(h) + ") ";
            }

            phrase = phrase + " - ";
            phrase2 = phrase2 + " - ";
            i = 6;

            ArrayList<Integer> listeCap;
            listeCap = new ArrayList<>();

            for (int h = 0; h < listeInfos.size(); h++) {
                
                listeInfos = (ArrayList<String>) test.get(i);
                phrase = phrase + listeInfos.get(h);
                listeCap = (ArrayList<Integer>) test.get(i + 1);
                phrase = phrase + " (" + listeCap.get(h) + ") ";
                listeInfos = (ArrayList<String>) test.get(i + 2);
                phrase = phrase + listeInfos.get(h) + " ";
            }

            phrase = phrase + " - ";

            phrase2 = phrase2 + " - ";
            i = 9;

            listeInfos = (ArrayList<String>) test.get(i);

            for (int j = 0; j < listeInfos.size(); j++) {
                if (j <= 2) {
                    phrase2 = phrase2 + listeInfos.get(j);
                }
                phrase = phrase + listeInfos.get(j);
            }
            
            phrase2 = phrase2 + "</html>";

            Cours cours = (Cours) test.get(10);
            int idCours = cours.getId();
            Colours genColor = new Colours();
            Color couleur = genColor.generateColor(idCours);

            i = 2; // Etat
            int etat = (int) test.get(i);
            if (etat == 0) {
                
                phrase = phrase + "</html>";

                JLabel lab = new JLabel(phrase, SwingConstants.CENTER);
                lab.setOpaque(true);
                lab.setBackground(couleur);
                lab.setToolTipText(phrase);
               add(lab);

            } else if(etat == 1) {
                
                String phrase3 = phrase + " - ANNULE </html>";           
                JLabel lab = new JLabel(phrase3, SwingConstants.CENTER);
                lab.setOpaque(true);
                lab.setBackground(couleur);
                lab.setToolTipText("Ce cours a été annulé");
                add(lab);
                
            } else if (etat == 2) {
                String phrase3 = phrase + " - A VALIDER </html>";           
                JLabel lab = new JLabel(phrase3, SwingConstants.CENTER);
                lab.setOpaque(true);
                lab.setBackground(couleur);
                lab.setToolTipText("Ce cours a été annulé");
                add(lab);
            }
        liste.remove(0);
    }

}
}

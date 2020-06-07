/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;
import Controlleur.Semaine;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import model.Utilisateur;





/**
 *
 * @author victo
 */

public class MainContainer extends JFrame {

    private static final long serialVersionUID = 1L;
    int idUtilisateur;
    Semaine NmSemaine = new Semaine();
    int idSemaine = NmSemaine.getWeek(0);
    Utilisateur userEnCours;
    int affAct = 1;
    int droitEnCours;

    public Utilisateur getUserEnCours() {
        return userEnCours;
    }

    public void setUserEnCours(Utilisateur userEnCours2) {
        this.userEnCours = userEnCours2;
    }
    
    

    public MainContainer(int idUtilisateur, int droitUser) {

        /*MenuBar bar = new MenuBar();
        JMenuBar test = bar.creerMenuBar();*/
        
        this.setTitle("Mon emploi du temps");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setSize(1200,600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setAlwaysOnTop(false);
        this.idUtilisateur = idUtilisateur;
        this.droitEnCours = droitUser;
        this.setJMenuBar(creerMenuBar());
        
    }
    
    public MainContainer(){
        
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }
    
    public int getIdSemaine() {
        return idSemaine;
    }

    public void setIdSemaine(int idSemaine) {
        this.idSemaine = idSemaine;
    }
    public int getDroitUtilisateur(){
        return userEnCours.getDroit();
    }
    
    public void grilleEdt(Utilisateur user22) {
        
       
      EDTGrille edt = new EDTGrille(user22.getId(),user22.getDroit(), idSemaine);
      this.setContentPane(edt);
      this.revalidate();
   
    }
    
    public void listeEDT(Utilisateur userrr){
        
        ListeEDT liste = new ListeEDT(userrr.getId(),userrr.getDroit(),idSemaine);
        JScrollPane pane = new JScrollPane(liste);
        pane.setVerticalScrollBarPolicy(
        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        this.add(pane,BorderLayout.CENTER);
        this.revalidate();
    }
    
    
    public JMenuBar creerMenuBar() { // Constructeur de la barre de menu
        JMenuBar menuBar = new JMenuBar();
        
        // MENU ETUDIANT & PROF
        
        /// PREMIER MENU ET SES SOUS-MENUS
        JMenu menuA = new JMenu (" Cours "); //Creation du 1er menu
  
        /////////////////////////EMPLOI DU TEMPS/////////////////////////
        JMenuItem menuB = new JMenuItem(" Emploi du temps "); //Creation Sous-Menu 1
        menuA.add(menuB);
        menuB.setIcon(new ImageIcon("Icone/Edt.png")); // Image en 24x24
        menuB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) 
            {
                 //Action a mettre en fct de la où on va
            }
        });
  
        
         ///////////////////////// RECAP DES COURS/////////////////////////
        JMenuItem menuC = new JMenuItem(" Récapitulatif des cours "); 
        
        menuA.add(menuC);
        menuC.setIcon(new ImageIcon("Icone/Recap.png"));
        menuC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) 
            {
                 //Action a mettre en fct de la où on va
            }
        });
        
        
        
        
        JMenuItem affichage = new JMenuItem(" Affichage "); 
        
        menuA.add(affichage);
       
        affichage.setIcon(new ImageIcon("Icone/affochage.png"));
        affichage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) 
            {
                  String[] display = {"En grille", "En liste"};
                    JOptionPane jop = new JOptionPane(), jop2 = new JOptionPane();
                    String nom = (String)jop.showInputDialog(null, 
                     "Veuillez choisir le type d'affichage",
                    "Affichage de l'emploi du temps",
                       JOptionPane.QUESTION_MESSAGE,
                    null,
                     display,
                    display[0]);
                    if(nom == "En grille"){
                        affAct = 1;
                        EDTGrille edt = new EDTGrille(userEnCours.getId(),userEnCours.getDroit(), idSemaine);
                setContentPane(edt);
                revalidate();
                repaint();
                        
                    }
                    if(nom== "En liste"){
                        affAct = 2;
                         ListeEDT edt2 = new ListeEDT(userEnCours.getId(),userEnCours.getDroit(), idSemaine);
                setContentPane(edt2);
                revalidate();
                repaint();
                    }
            }
        });
      
        
          /////////////////////////QUITTER/////////////////////////
        menuA.addSeparator();
        JMenuItem menuQ = new JMenuItem(" Quitter "); // QUITTER
        menuA.add(menuQ);
        menuQ.setIcon(new ImageIcon("Icone/exit.png"));
        menuQ.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                JOptionPane jop = new JOptionPane();			
                    int option = jop.showConfirmDialog(null, "Voulez-vous quitter l'emploi du temps ?", "Arrêt de l'application", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

                if(option == JOptionPane.YES_OPTION)
                {
                     System.exit(0);
                }
            }
        });
        
        
        //MENU ADMIN
        JMenu menuAdmin = new JMenu (" Cours "); //Creation du 1er menu
  
        
        JMenuItem Ajouter = new JMenuItem(" Ajouter un cours"); //Creation Sous-Menu 1
        menuAdmin.add(Ajouter);
        Ajouter.setIcon(new ImageIcon("Icone/add.png")); // Image en 24x24
        Ajouter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) 
            {
                //Fenetre fen = new Fenetre();
            }
   
        });
    
    
      
        JMenuItem Modifier = new JMenuItem(" Modifier un cours "); 
        
        menuAdmin.add(Modifier);
        Modifier.setIcon(new ImageIcon("Icone/edit.png"));
        Modifier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) 
            {
                 //Action a mettre en fct de la où on va
            }
            });
            
         JMenuItem Annuler = new JMenuItem(" Annuler un cours "); 
        
        menuAdmin.add(Annuler);
        Annuler.setIcon(new ImageIcon("Icone/cancel.png"));
        Annuler.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) 
            {
                // Action a mettre en fct de la où on va
            }
            });
        
        
        menuAdmin.addSeparator();
        JMenuItem Quitter = new JMenuItem(" Quitter "); // QUITTER
        menuAdmin.add(Quitter);
        Quitter.setIcon(new ImageIcon("Icone/exit.png"));
        Quitter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                JOptionPane jop = new JOptionPane();			
                    int option = jop.showConfirmDialog(null, "Voulez-vous quitter l'emploi du temps ?", "Arrêt de l'application", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

                if(option == JOptionPane.YES_OPTION)
                {
                     System.exit(0);
                }
            }
        });
        
        
        JMenu menuSemaine = new JMenu (" Choix semaine "); //Creation du 2eme menu
  
        /////////////////////////CHOIX SEMAINE/////////////////////////
        JMenuItem choix1 = new JMenuItem(" Semaine actuelle "); //Creation Sous-Menu 1
        menuSemaine.add(choix1);
        
        JMenuItem choix2 = new JMenuItem(" Semaine précédente "); //Creation Sous-Menu 1
        menuSemaine.add(choix2);
        
        JMenuItem choix3 = new JMenuItem(" Semaine suivante "); //Creation Sous-Menu 1
        menuSemaine.add(choix3);
        
         MainContainer fen = new MainContainer();
        
        choix1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                
                
                Semaine semaine = new Semaine();
                int id_semaine = semaine.getWeek(0);
                setIdSemaine(id_semaine);
                switch(affAct){
                    case 1 :
                        EDTGrille edt = new EDTGrille(userEnCours.getId(),userEnCours.getDroit(), id_semaine);
                setContentPane(edt);
                revalidate();
                repaint();
                break;
                    case 2:
                        ListeEDT edt2 = new ListeEDT(userEnCours.getId(),userEnCours.getDroit(), id_semaine);
                setContentPane(edt2);
                revalidate();
                repaint();
                break;
                    
                }
                
            }
        });
        
        choix2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                
                
                int id_semaine = getIdSemaine() - 1;
                setIdSemaine(id_semaine);
                switch(affAct){
                    case 1 :
                        EDTGrille edt = new EDTGrille(userEnCours.getId(),userEnCours.getDroit(), id_semaine);
                setContentPane(edt);
                revalidate();
                repaint();
                break;
                    case 2:
                        ListeEDT edt2 = new ListeEDT(userEnCours.getId(),userEnCours.getDroit(), id_semaine);
                setContentPane(edt2);
                revalidate();
                repaint();
                break;
                    
                }
               
            }
        });
        
        choix3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                
                int id_semaine = getIdSemaine() + 1;
                setIdSemaine(id_semaine);
                switch(affAct){
                    case 1 :
                        EDTGrille edt = new EDTGrille(userEnCours.getId(),userEnCours.getDroit(), id_semaine);
                setContentPane(edt);
                revalidate();
                repaint();
                break;
                    case 2:
                        ListeEDT edt2 = new ListeEDT(userEnCours.getId(),userEnCours.getDroit(), id_semaine);
                setContentPane(edt2);
                revalidate();
                repaint();
                break;
                    
                }
                
                
            }
        });
        
       switch(droitEnCours){
       
       
       case 1 :
        menuBar.add(menuAdmin );
        break;
       case 3 :
            menuBar.add(menuA );
        break;
       case 4 :
        menuBar.add(menuA );
        break;
       default:
           break;
        
   }
   
        menuBar.add(menuSemaine );
        return menuBar;
   
   }
    
       
}
    
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Controlleur.InfosCours;
import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


/**
 *
 * @author victo
 */
public class MainContainer extends JFrame {

    private static final long serialVersionUID = 1L;

    public MainContainer() {
        MenuBar bar = new MenuBar();
        JMenuBar menuBar = bar.creerMenuBar();
        this.setJMenuBar(menuBar);
        this.setTitle("Mon emploi du temps");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setSize(1500,750);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setAlwaysOnTop(false);
        
        
        
    }

    public void grilleEdt() {
        
       
       EDTEleve edt = new EDTEleve(1,0);
       
       //edt.afficher();
       //this.setContentPane(edt);
      // edt.afficher(edt.getWidth(), edt.getHeight());
      //PaintEDT paint = new PaintEDT();
      //paint.add(paint.ajout());
      edt.removeAll();
      
      this.setContentPane(edt);
      this.revalidate();
      //this.add(paint.ajout());
      

      
      

      
    }
    

    public static void main(String[] args) {

        MainContainer fen = new MainContainer();
        
        fen.grilleEdt();
        
    }
    

}

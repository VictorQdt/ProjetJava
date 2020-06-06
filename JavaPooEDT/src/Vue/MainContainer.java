/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;
import javax.swing.*;
import java.awt.*;

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
    
    

    public MainContainer(int idUtilisateur) {

        MenuBar bar = new MenuBar();
        JMenuBar test = bar.creerMenuBar();
        this.setJMenuBar(test);
        this.setTitle("Mon emploi du temps");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setSize(1200,600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setAlwaysOnTop(false);
        this.idUtilisateur = idUtilisateur;
    }
    
    public MainContainer(){
        
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }
    
    
    public void grilleEdt(Utilisateur user22) {
        
       
      EDTGrille edt = new EDTGrille(user22.getId(),user22.getDroit());
      this.setContentPane(edt);
      this.revalidate();
   
    }
    
    public void listeEDT(Utilisateur userrr){
        
        ListeEDT liste = new ListeEDT(userrr.getId(),userrr.getDroit());
        JScrollPane pane = new JScrollPane(liste);
        pane.setVerticalScrollBarPolicy(
        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        this.add(pane,BorderLayout.CENTER);
        this.revalidate();
    }
    
       

}
    
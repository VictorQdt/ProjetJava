/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author victo
 */
public class MainContainer extends JFrame {


    public MainContainer() {
        MenuBar bar = new MenuBar();
        JMenuBar menuBar = bar.creerMenuBar();
        this.setJMenuBar(menuBar);
        this.setTitle("Mon emploi du temps");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setSize(1200, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setAlwaysOnTop(false);
    }

    public void grilleEdt() {

        Grille pan = new Grille();
        this.getContentPane().add(pan);

    }

    public static void main(String[] args) {

        MainContainer fen = new MainContainer();
        fen.grilleEdt();
    }

}

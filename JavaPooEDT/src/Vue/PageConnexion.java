/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

/**
 *
 * @author Paul
 */

import Controlleur.Connexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import DAO.UtilisateurDAO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Utilisateur;


public class PageConnexion extends JFrame {
    
    private JPanel container = new JPanel();
    
  JTextField txtUsername = new JTextField();
    JTextField txtPwd = new JTextField();
    
    
    private JLabel lblLogin = new JLabel("Login :");
    private JLabel lblPwd = new JLabel("Mot de passe :");
    private  JButton b = new JButton ("Se connecter");
    
    Connexion connect = new Connexion();
    UtilisateurDAO identifiant = new UtilisateurDAO(connect);
    Utilisateur utilisateur = new Utilisateur();
    

  public PageConnexion(){
    this.setTitle("PageConnexion");
    this.setSize(1200, 600);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    container.setLayout(new BorderLayout());
    JPanel top = new JPanel();
    txtUsername.setColumns(10);
    txtPwd.setColumns(10);
    top.add(lblLogin);
    top.add(txtUsername);
    top.add(lblPwd);
    top.add(txtPwd);
    b.addActionListener(new BoutonListener());
    top.add(b);
    this.setContentPane(top); 
    this.setVisible(true); 
  }       

  class BoutonListener implements ActionListener{
    public void actionPerformed(ActionEvent e) {
      
      utilisateur = identifiant.findLogin(txtUsername.getText(), txtPwd.getText());
      if( utilisateur.getId() != 0){
          //afficher la fenêtre de l'emploi du temps
          //return utilisateur;
      }
    }
  }
    
   public static void main(String[] args) {

            new PageConnexion();
            
    }
}


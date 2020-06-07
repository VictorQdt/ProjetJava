/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

/**
 *
 * @author coren
 */
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Fenetre extends JFrame {
  private JButton bouton = new JButton("Ajouter un cours");

  public Fenetre(){      
    this.setTitle("Nouveau Cours");
    this.setSize(400, 100);
    this.setDefaultCloseOperation(this.DISPOSE_ON_CLOSE);
    this.setLocationRelativeTo(null);      
    this.getContentPane().setLayout(new FlowLayout());
    this.getContentPane().add(bouton);
    bouton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent arg0) {
        CreerCours courstest = new CreerCours(null, "Description du cours", true);
        InfoCours Cours = courstest.showCreerCours(); 
        JOptionPane jop = new JOptionPane();

      }         
    });      
    this.setVisible(true);      
  }
  
}

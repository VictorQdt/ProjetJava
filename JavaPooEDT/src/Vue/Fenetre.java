/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author victo
 */
class Fenetre extends JFrame{
    private JPanel pan=new JPanel();
    private JPanel blackPan=new JPanel();
    private JPanel redPan=new JPanel();
    private JButton blackButton=new JButton("Black!");
    private JButton redButton=new JButton("Red!");
 
    public Fenetre(){
        this.setTitle("hello");
        this.setSize(300,300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(blackButton,BorderLayout.NORTH);
        this.add(redButton,BorderLayout.SOUTH);
        this.add(pan);
        //on cree le JPanel principal
        pan.setLayout(new OverlayLayout(pan));
        //on y ajoute les autres JPanel
        pan.add(blackPan);
        pan.add(redPan);
        blackPan.setBackground(Color.black);
        redPan.setBackground(Color.red);
        blackButton.addActionListener(new ActionListener(){
 
            @Override
            public void actionPerformed(ActionEvent e) {
                 blackPan.setVisible(true);
                 redPan.setVisible(false);
            }
 
        });
         
        redButton.addActionListener(new ActionListener(){
 
            public void actionPerformed(ActionEvent e) {
                redPan.setVisible(true);
                blackPan.setVisible(false);
            }
 
        });
        this.setVisible(true);
    }
    
    public static void main(String[] args){
       Fenetre f = new Fenetre();
    }
    
}
 

    

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
public class Grille extends JPanel {
    
    /*public Grille(){
        this.setLayout(new GridLayout (3,3,10,10));
        //this.setBackground(Color.BLACK);
        this.add(new JButton("test"));
        
    }*/
    
    @Override
    public void paintComponent(Graphics g){
g.setColor(Color.black);
int uniteX = getWidth()/7;
int uniteY = getHeight()/14;
for(int i=0; i<9; i++){
g.drawLine(uniteX*i, 70, uniteX*i, getHeight()-70);

}
for (int y =1; y<14; y++){
    g.drawLine(75, uniteY*y, getWidth()-75, uniteY*y);
}
}

}


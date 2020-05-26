
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.UIManager;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

/**
 *
 * @author corentin
 * 
 */
public class MenuBar extends JFrame {
    
    
    public MenuBar() { // Constructeur de la fenetre de barre de menu
        super ("JMenuBar") ;
        this.setSize(600,400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation( DISPOSE_ON_CLOSE );
        
        //Construction de la barre de menu 
        
        this.setJMenuBar( creerMenuBar ()  );
        
    
    
}
    public static void main(String[] args) throws Exception{
        UIManager.setLookAndFeel( new NimbusLookAndFeel() );
                MenuBar window = new MenuBar ();
                window.setVisible( true );
                
    }

    private JMenuBar creerMenuBar() { // Constructeur de la barre de menu
        JMenuBar menuBar = new JMenuBar();
        
        /// PREMIER MENU ET SES SOUS-MENUS
        JMenu menuA = new JMenu (" Cours "); //Creation du 1er menu
  
        JMenuItem menuB = new JMenuItem(" Emploi du temps "); //Creation Sous-Menu 1
        menuA.add(menuB);
        menuB.setIcon(new ImageIcon("Icone/Edt.png")); // Image en 24x24
        menuA.addSeparator(); //Séparateur entre deux sous-menus
        
        JMenuItem menuC = new JMenuItem(" Récapitulatif des cours "); //Creation Sous-Menu 2
        menuA.add(menuC);
        menuC.setIcon(new ImageIcon("Icone/Recap.png"));
        
        menuBar.add(menuA ); //Ajout du 1er menu
        
        /// DEUXIEME MENU ET SES SOUS-MENUS
        JMenu MenuD = new JMenu (" Menu 2 "); //Creation du 1er menu
  
        JMenuItem menuE = new JMenuItem(" Sous-menu 2.1 "); //Creation Sous-Menu 1
        MenuD.add(menuE);
        
        MenuD.addSeparator(); //Séparateur entre deux sous-menus
        
        JMenuItem menuF = new JMenuItem(" Sous-menu 2.2 "); //Creation Sous-Menu 2
        MenuD.add(menuF);
        
        menuBar.add(MenuD ); //Ajout du 1er menu
        
        return menuBar; //MenuD & MenuE... a renommer en fonction de leur nom defs
        
    }
     
}



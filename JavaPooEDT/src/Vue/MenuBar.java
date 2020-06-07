
package Vue;
import Controlleur.Semaine;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
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
        this.setSize(1200,600);
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

    JMenuBar creerMenuBar() { // Constructeur de la barre de menu
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
       
        //affichage.setIcon(new ImageIcon("Icone/Recap.png"));
        affichage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) 
            {
                  String[] display = {"Par semaine", "Par jour", "Par défaut"};
                    JOptionPane jop = new JOptionPane(), jop2 = new JOptionPane();
                    String nom = (String)jop.showInputDialog(null, 
                     "Veuillez choisir le type d'affichage",
                    "Affichage de l'emploi du temps",
                       JOptionPane.QUESTION_MESSAGE,
                    null,
                     display,
                    display[2]);
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
                System.exit(0);
            }
        });
        
        
        //MENU ADMIN
        JMenu menuAdmin = new JMenu (" Cours "); //Creation du 1er menu
  
        
        JMenuItem Ajouter = new JMenuItem(" Ajouter un cours"); //Creation Sous-Menu 1
        menuAdmin.add(Ajouter);
        //menuB.setIcon(new ImageIcon("Icone/ .png")); // Image en 24x24
        Ajouter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) 
            {
                 //Action a mettre en fct de la où on va
            }
        });
  
        
      
        JMenuItem Modifier = new JMenuItem(" Modifier un cours "); 
        
        menuAdmin.add(Modifier);
        //menuC.setIcon(new ImageIcon("Icone/ .png"));
        Modifier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) 
            {
                 //Action a mettre en fct de la où on va
            }
            });
            
         JMenuItem Annuler = new JMenuItem(" Annuler un cours "); 
        
        menuAdmin.add(Annuler);
        //menuC.setIcon(new ImageIcon("Icone/Recap.png"));
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
                System.exit(0);
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
                fen.setIdSemaine(id_semaine);
            }
        });
        
        choix2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                int id_semaine = fen.getIdSemaine() - 1;
                fen.setIdSemaine(id_semaine);
            }
        });
        
        choix3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                int id_semaine = fen.getIdSemaine() + 1;
                fen.setIdSemaine(id_semaine);
            }
        });
        
     String choix="Etudiant";  
   switch(choix){
       
       case "Administrateur" :
        menuBar.add(menuAdmin );
           //Ajout du menu Etudiant
        break;
       case "Etudiant" :
        menuBar.add(menuA );
        break;
   }
        menuBar.add(menuSemaine );
        return menuBar;
   
   }
        
             
    }
        
    







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
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;

public class CreerCours extends JDialog {
  private InfoCours Cours = new InfoCours();
  private boolean sendData;
  private JLabel nomLabel, dureeLabel, ID_TypeLabel, ID_CoursLabel, dateLabel, icon;
  private JRadioButton tranche1, tranche2, tranche3, tranche4;
  private JComboBox duree, ID_Type;
  private JTextField nom, date;

  public CreerCours(JFrame parent, String title, boolean modal){
    super(parent, title, modal);
    this.setSize(500, 270);
    this.setLocationRelativeTo(null);
    this.setResizable(false);
    this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
    this.initComponent();
  }

  public InfoCours showCreerCours(){
    this.sendData = false;
    this.setVisible(true);      
    return this.Cours;      
  }

  private void initComponent(){
    //Icône
    icon = new JLabel(new ImageIcon("Icone/exit.jpg"));
    JPanel panIcon = new JPanel();
    panIcon.setBackground(Color.white);
    panIcon.setLayout(new BorderLayout());
    panIcon.add(icon);

    //Le nom
    JPanel panNom = new JPanel();
    panNom.setBackground(Color.white);
    panNom.setPreferredSize(new Dimension(220, 60));
    nom = new JTextField();
    nom.setPreferredSize(new Dimension(100, 25));
    panNom.setBorder(BorderFactory.createTitledBorder("Nom du cours"));
    nomLabel = new JLabel("Saisir un nom :");
    panNom.add(nomLabel);
    panNom.add(nom);

    //Durée du cours
    JPanel panDuree = new JPanel();
    panDuree.setBackground(Color.white);
    panDuree.setPreferredSize(new Dimension(220, 60));
    panDuree.setBorder(BorderFactory.createTitledBorder("Durée du cours"));
    duree = new JComboBox();
    duree.addItem("1 heure");
    duree.addItem("1.5 heures");
    duree.addItem("2 heures");
    duree.addItem("2.5 heures");
    dureeLabel = new JLabel("Durée : ");
    panDuree.add(dureeLabel);
    panDuree.add(duree);

    //ID_Cours 
    JPanel panID_Cours = new JPanel();
    panID_Cours.setBackground(Color.white);
    panID_Cours.setBorder(BorderFactory.createTitledBorder("ID du Cours"));
    panID_Cours.setPreferredSize(new Dimension(440, 60));
    tranche1 = new JRadioButton(" 0 ");
    tranche1.setSelected(true);
    tranche2 = new JRadioButton(" 1 ");
    tranche3 = new JRadioButton(" 2 ");
    tranche4 = new JRadioButton(" 3 ");
    ButtonGroup bg = new ButtonGroup();
    bg.add(tranche1);
    bg.add(tranche2);
    bg.add(tranche3);
    bg.add(tranche4);
    panID_Cours.add(tranche1);
    panID_Cours.add(tranche2);
    panID_Cours.add(tranche3);
    panID_Cours.add(tranche4);

    //La date
    JPanel panDate = new JPanel();
    panDate.setBackground(Color.white);
    panDate.setPreferredSize(new Dimension(220, 60));
    panDate.setBorder(BorderFactory.createTitledBorder("Date du cours"));
    dateLabel = new JLabel("Date : ");
    date = new JTextField("07/06/2020");
    date.setPreferredSize(new Dimension(90, 25));
    panDate.add(dateLabel);
    panDate.add(date);

    //ID_Type
    JPanel panID_Type = new JPanel();
    panID_Type.setBackground(Color.white);
    panID_Type.setPreferredSize(new Dimension(220, 60));
    panID_Type.setBorder(BorderFactory.createTitledBorder("Couleur de cheveux du personnage"));
    ID_Type = new JComboBox();
    ID_Type.addItem("0");
    ID_Type.addItem("1");
    ID_TypeLabel = new JLabel("ID_Type");
    panID_Type.add(ID_TypeLabel);
    panID_Type.add(ID_Type);

    JPanel content = new JPanel();
    content.setBackground(Color.white);
    content.add(panNom);
    content.add(panDuree);
    content.add(panID_Cours);
    content.add(panDate);
    content.add(panID_Type);

    JPanel control = new JPanel();
    JButton okBouton = new JButton("OK");
    
    okBouton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent arg0) {        
        Cours = new InfoCours(nom.getText(), (String)duree.getSelectedItem(), getAge(), (String)ID_Type.getSelectedItem());
        setVisible(false);
      }

      public String getAge(){
        return (tranche1.isSelected()) ? tranche1.getText() : 
               (tranche2.isSelected()) ? tranche2.getText() : 
               (tranche3.isSelected()) ? tranche3.getText() : 
               (tranche4.isSelected()) ? tranche4.getText() : 
                tranche1.getText();  
      }

          
    });

    JButton cancelBouton = new JButton("Annuler");
    cancelBouton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent arg0) {
        setVisible(false);
      }      
    });

    control.add(okBouton);
    control.add(cancelBouton);

    this.getContentPane().add(panIcon, BorderLayout.WEST);
    this.getContentPane().add(content, BorderLayout.CENTER);
    this.getContentPane().add(control, BorderLayout.SOUTH);
  }  
}
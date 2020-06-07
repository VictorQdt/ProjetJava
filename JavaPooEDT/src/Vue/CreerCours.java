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
import Controlleur.Connexion;
import DAO.CoursDAO;
import DAO.GroupeDAO;
import DAO.PromotionDAO;
import DAO.Type_CoursDAO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFormattedTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import model.Groupe;
import model.Promotion;
import model.Type_Cours;

public class CreerCours extends JDialog {

    private InfoCours Cours = new InfoCours();
    private boolean sendData;
    private JLabel nomLabel, dureeLabel, ID_TypeLabel, ID_CoursLabel, dateLabel, icon, ID_PromoLabel, ID_GroupeLabel;
    private JRadioButton tranche1, tranche2, tranche3, tranche4;
    private JComboBox duree, ID_Type;
    private JTextField nom, date;
    private ArrayList<String> nomDesGroupes;

    /**
     *
     * @param parent
     * @param title
     * @param modal
     */
    public CreerCours(JFrame parent, String title, boolean modal) {
        super(parent, title, modal);
        this.setSize(800, 800);
        this.setPreferredSize(new Dimension(800, 270));

        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.initComponent();
    }

    public InfoCours showCreerCours() {
        this.sendData = false;
        this.setVisible(true);
        return this.Cours;
    }

    private void initComponent() {

        Connexion connect = null;
        try {
            connect = new Connexion();
        } catch (SQLException ex) {

        }
        GroupeDAO gDAO = new GroupeDAO(connect);
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
        JFormattedTextField duree = new JFormattedTextField(new DecimalFormat("#.#"));
        float tt = (float) 1.0;
        duree.setValue(tt);
        duree.setPreferredSize(new Dimension(100, 25));
        dureeLabel = new JLabel("Durée : ");
        panDuree.add(dureeLabel);
        panDuree.add(duree);

        //ID_Cours 
        JPanel panID_Cours = new JPanel();
        panID_Cours.setBackground(Color.white);
        panID_Cours.setBorder(BorderFactory.createTitledBorder("Nom du cours"));
        panID_Cours.setPreferredSize(new Dimension(440, 60));
        ButtonGroup bg = new ButtonGroup();
        CoursDAO cDAO = new CoursDAO(connect);
        ArrayList<String> listeCours;
        listeCours = cDAO.rechercheTot();
        while (!listeCours.isEmpty()) {
            JRadioButton radioB = new JRadioButton(listeCours.get(0));
            bg.add(radioB);
            panID_Cours.add(radioB);
            listeCours.remove(0);
        }

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
        panID_Type.setBorder(BorderFactory.createTitledBorder("Type de cours"));
        ID_Type = new JComboBox();
        Type_CoursDAO tcDAO = new Type_CoursDAO(connect);
        ArrayList<Integer> listeTC;
        listeTC = tcDAO.rechercheTot();
        while (!listeTC.isEmpty()) {
            Type_Cours tc = tcDAO.find(listeTC.get(0));
            String nomTC = tc.getNom();
            ID_Type.addItem(nomTC);
            listeTC.remove(0);
        }
        ID_TypeLabel = new JLabel("Type de cours");
        panID_Type.add(ID_TypeLabel);
        panID_Type.add(ID_Type);

        //Promotion
        JPanel grandPanel = new JPanel();

        JPanel content = new JPanel();
        JPanel contentProm = new JPanel(new FlowLayout());
        contentProm.setPreferredSize(new Dimension(800, 130));

        JPanel contentGroupes = new JPanel(new FlowLayout());
        contentGroupes.setPreferredSize(new Dimension(800, 130));
        contentGroupes.setBackground(Color.white);
        contentProm.setBackground(Color.white);
        //TD en fonction de la promo
        JFormattedTextField nbGroupe = new JFormattedTextField(new DecimalFormat("##"));
        nbGroupe.setBackground(Color.white);
        nbGroupe.setPreferredSize(new Dimension(220, 60));
        nbGroupe.setBorder(BorderFactory.createTitledBorder("Choix du nombre de groupe"));
        JLabel nbGroupeLabel = new JLabel("Durée : ");
        nbGroupe.add(nbGroupeLabel);

        nbGroupe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {

                for (int h = 0; h < (long) nbGroupe.getValue(); h++) {

                    ArrayList<JPanel> listeTest;
                    listeTest = new ArrayList<>();

                    listeTest = choixGroupes();

                    contentProm.add(listeTest.get(0));
                    contentGroupes.add(listeTest.get(1));
                    content.add(contentProm);
                    content.add(contentGroupes);
                    repaint();
                    revalidate();

                }

            }

        });

        content.setPreferredSize(new Dimension(270, 800));
        content.setBackground(Color.white);
        content.add(panNom);
        content.add(panDuree);
        content.add(panID_Cours);
        content.add(panDate);
        content.add(panID_Type);

        /*content.add(panID_Promo);
    content.add(panID_Groupe);*/
        content.add(nbGroupe);
        /*grandPanel.add(panID_Promo);
    grandPanel.add(panID_Groupe);*/

        JScrollPane pane = new JScrollPane(content);
        JPanel control = new JPanel();
        JButton okBouton = new JButton("OK");

        okBouton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
//        Cours = new InfoCours(nom.getText(), (String)duree.getSelectedItem(), getAge(), (String)ID_Type.getSelectedItem());
                setVisible(false);
            }

            /**
     *
     * @return
     */
            public String getAge() {
                return (tranche1.isSelected()) ? tranche1.getText()
                        : (tranche2.isSelected()) ? tranche2.getText()
                        : (tranche3.isSelected()) ? tranche3.getText()
                        : (tranche4.isSelected()) ? tranche4.getText()
                        : tranche1.getText();
            }

        });

        JButton cancelBouton = new JButton("Annuler");
        cancelBouton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                setVisible(false);
            }
        });

        control.add(okBouton);
        control.add(cancelBouton);

        this.getContentPane().add(panIcon, BorderLayout.WEST);
        this.getContentPane().add(pane, BorderLayout.CENTER);
        this.getContentPane().add(control, BorderLayout.SOUTH);
    }

    /**
     *
     * @return liste
     */
    public ArrayList<JPanel> choixGroupes() {

        JComboBox ID_Promo = new JComboBox();
        JComboBox ID_Groupe = new JComboBox();
        ArrayList<JPanel> liste;
        liste = new ArrayList<>();

        Connexion connect = null;
        try {
            connect = new Connexion();
        } catch (SQLException ex) {

        }
        GroupeDAO gDAO = new GroupeDAO(connect);

        JPanel panID_Promo = new JPanel();
        panID_Promo.setBackground(Color.white);
        panID_Promo.setPreferredSize(new Dimension(220, 60));
        panID_Promo.setBorder(BorderFactory.createTitledBorder("Choix de la promo"));

        PromotionDAO promDAO = new PromotionDAO(connect);
        ArrayList<Integer> listePromo;
        listePromo = promDAO.rechercheTot();
        while (!listePromo.isEmpty()) {
            Promotion promo = promDAO.find(listePromo.get(0));
            String nomPromo = promo.getNom();
            ID_Promo.addItem(nomPromo);
            listePromo.remove(0);
        }
        ID_PromoLabel = new JLabel("Promo");
        ID_Promo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ///Endroit ou je selectionne les id des groupes selon la promo
                System.out.print(ID_Promo.getSelectedItem().toString());
                Promotion promAct = promDAO.findId(ID_Promo.getSelectedItem().toString());
                int idPromoAct = promAct.getId();
                ArrayList<Integer> listeGroupesPromo;
                listeGroupesPromo = gDAO.recherchesGroupesPromo(idPromoAct);
                if (ID_Promo.getSelectedItem().toString().equals("")) {
                    String[] test_1 = {""};
                    DefaultComboBoxModel defaultComboBoxModel = new DefaultComboBoxModel(test_1);
                    ID_Groupe.setModel(defaultComboBoxModel);
                } else {
                    int nbDeR = listeGroupesPromo.size();
                    String[] tabNomGroupe = new String[nbDeR];
                    for (int compteur = 0; compteur < listeGroupesPromo.size(); compteur++) {
                        Groupe groupeAct = gDAO.find(listeGroupesPromo.get(compteur));
                        String nomGroupe = groupeAct.getNom();
                        tabNomGroupe[compteur] = nomGroupe;

                    }

                    DefaultComboBoxModel defaultComboBoxModel = new DefaultComboBoxModel(tabNomGroupe);
                    ID_Groupe.setModel(defaultComboBoxModel);
                }
            }
        });
        panID_Promo.add(ID_PromoLabel);
        panID_Promo.add(ID_Promo);

        JPanel panID_Groupe = new JPanel();
        panID_Groupe.setBackground(Color.white);
        panID_Groupe.setPreferredSize(new Dimension(220, 60));
        panID_Groupe.setBorder(BorderFactory.createTitledBorder("Choix du groupe"));

        ID_Groupe.addItem("");
        ID_GroupeLabel = new JLabel("Groupe");
        panID_Groupe.add(ID_GroupeLabel);
        panID_Groupe.add(ID_Groupe);

        liste.add(panID_Promo);
        liste.add(panID_Groupe);
        return liste;
    }

}

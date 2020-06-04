/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlleur;

import java.util.ArrayList;
import DAO.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.*;

/**
 *
 * @author victo
 */
public class InfosCours {
    
    //private final Connexion connect = new Connexion();
    
    /**
     * Fonction qui retourne une ArrayList contenant toutes les séances de l'étudiant. Chaque séance est elle même une ArrayList qui contient :
     * 1 : Date et heure de la séance
     * 2 : Duréee
     * 3 : Etat
     * 4 : Nom du cours
     * 5 : Une ArrayList des noms des groupes
     * 6 : Une ArrayList des noms des promos (même ordre que les noms de groupes)
     * 7 : Une ArrayList des noms des salles
     * 8 : Une ArrayList des capacités des salles (pareil, même ordre)
     * 9 : Une ArrayList des sites des salles (toujours le même ordre)
     * 10 : Une ArrayList des noms des profs
     * @param idEtudiant
     * @return 
     */
    
    public ArrayList<Object> rechercheCoursEtudiant(int idEtudiant) throws SQLException{
        
        

            Connexion connect;
            connect = new Connexion();

        
        EtudiantDAO etudiantDAO;
        etudiantDAO = new EtudiantDAO(connect);
        Etudiant etudiant = etudiantDAO.find(idEtudiant);
        
        
        int idGroupe = etudiant.getId_td(); // Je recuppère l'id du groupe de l'étudiant
        
        GroupeDAO groupeDAO = new GroupeDAO(connect);
        Groupe groupe = groupeDAO.find(idGroupe);
        
        ArrayList<Integer> listeSeances;
        listeSeances = new ArrayList<>();
        
        Seance_groupeDAO  seanceGroupeDAO = new Seance_groupeDAO(connect);
        listeSeances = seanceGroupeDAO.findSeances(idGroupe);
        
        
        
        ArrayList<Object> listeFinal;
        listeFinal = new ArrayList();
        
        for(int i = 0; i<listeSeances.size(); i++)
        {
            ArrayList<Object> listeInfos;
            listeInfos = new ArrayList<>();
            
            SeanceDAO seanceDAO = new SeanceDAO(connect);
            Seance seance = seanceDAO.find(listeSeances.get(i));
            
            listeInfos.add(seance.getDate()); // J'ajoute les infos temporelles de cette séance à ma liste infos. 
            listeInfos.add(seance.getDuree());
            listeInfos.add(seance.getEtat()); // J'ajoute l'etat du cours aux infos
            
            CoursDAO coursDAO = new CoursDAO(connect);
            String nomCours = coursDAO.find(seance.getId_cours()).getNom(); // Je récuppère le nom du cours
            listeInfos.add(nomCours); // Puis je l'ajoute dans la lsite des infos
            
            ArrayList<Integer> listeIdGroupes;
            listeIdGroupes = new ArrayList<>();
            
            ArrayList<String> listeNomsGroupes; // Je crée ma liste qui va recevoir le nom de tous les groupes
            listeNomsGroupes = new ArrayList<>();
            
            listeIdGroupes = seanceGroupeDAO.findGroupes(listeSeances.get(i)); // Je récuppére les ID de tous les groupes qui sont sur cette séance
            
            ArrayList<String> listeNomsPromos;
            listeNomsPromos = new ArrayList<>();
            
            for(int j = 0; j<listeIdGroupes.size(); j++)
            {
                groupe = groupeDAO.find(listeIdGroupes.get(j));
                listeNomsGroupes.add(groupe.getNom());
                
                int idProm = groupe.getId_promo();
                
                PromotionDAO promDAO = new PromotionDAO(connect);
                Promotion prom = promDAO.find(idProm);
                
                listeNomsPromos.add(prom.getNom());
                
            }
            
            listeInfos.add(listeNomsGroupes); // J'ajoute dans ma liste d'infos la liste des noms des groupes
            listeInfos.add(listeNomsPromos);
            
            SalleDAO salleDAO = new SalleDAO(connect);
            SiteDAO siteDAO = new SiteDAO(connect);
            
            ArrayList<Integer> listeIdSalles;
            listeIdSalles = new ArrayList<>();
            
            ArrayList<String> listeNomsSalles; // Je crée ma liste qui va recevoir le nom de toutes les salles
            listeNomsSalles = new ArrayList<>();
            
            ArrayList<Integer> listeCapSalles; // Je crée ma liste qui va recevoir la capacité de toutes les salles
            listeCapSalles = new ArrayList<>();
            
            ArrayList<String> listeSites;
            listeSites = new ArrayList<>();
            
            Seance_sallesDAO seanceSallesDAO = new Seance_sallesDAO(connect);
            listeIdSalles = seanceSallesDAO.findSalles(listeSeances.get(i)); // Récuppère une liste des id des salles associées à la séance
            
            //listeIdSalles = seanceGroupeDAO.findGroupes(listeSeances.get(i)); // Je récuppére les ID de tous les groupes qui sont sur cette séance
            
            for(int j = 0; j<listeIdSalles.size(); j++)
            {
                Salle salle = new Salle();
                salle = salleDAO.find(listeIdSalles.get(j)); // Je récuppère l'id du site de la salle 
                              
                int idSite = salle.getId_site();
                Site site = siteDAO.find(idSite); // Je récuppère le site de la salle 
                listeNomsSalles.add(salle.getNom());
                listeCapSalles.add(salle.getCapacite());
                listeSites.add(site.getNom()); // J'ajoute le nom du site à ma liste
            }
            
            listeInfos.add(listeNomsSalles); // J'ajoute dans ma liste d'infos la liste des noms des groupes
            listeInfos.add(listeCapSalles); // J'ajoute dans ma liste d'infos la liste des capacités des salles. c'est dans le même ordre que pour les noms
            listeInfos.add(listeSites);
            
            Seance_enseignantsDAO seanceenseignantsDAO = new Seance_enseignantsDAO(connect);
            
            ArrayList<Integer> listeIdProfs;
            listeIdProfs = new ArrayList<>();
            
            ArrayList<String> listeNomsProfs;
            listeNomsProfs = new ArrayList();
            
            listeIdProfs = seanceenseignantsDAO.findEnseignants(listeSeances.get(i));
            
            for(int j=0; j<listeIdProfs.size(); j++)
            {
                /*EnseignantDAO profDAO = new EnseignantDAO(connect);
                int idProf = profDAO.find(listeIdProfs.get(j)).getId();*/
                
                UtilisateurDAO utDAO = new UtilisateurDAO(connect);
                String nomProf = utDAO.find(listeIdProfs.get(j)).getNom();
                
                listeNomsProfs.add(nomProf);
                              
            }
            listeInfos.add(listeNomsProfs);
            listeFinal.add(listeInfos);
        }
        
        return listeFinal;
        
    }
    

    
}

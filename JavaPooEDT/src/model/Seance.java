/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Paul
 */
public class Seance {
    
    Cours cours = new Cours();
    Type_Cours type = new Type_Cours();
    
    private int id = 0;
    private int semaine = 0;
    private String date = "";
    private String heure_d = "";
    private String heure_f = "";
    private int etat;
    private int id_cours;
    private int id_type;
    
    public Seance (int id, int semaine, String date, String heure_d, 
            String heure_f, int etat, int id_cours,int id_type){
        this.id = id;
        this.semaine = semaine;
        this.date = date;
        this.heure_d = heure_d;
        this.heure_f = heure_f;
        this.etat = etat;
        this.id_cours = cours.getId();
        this.id_type = type.getId();
    }
    
    public Seance () {}
    
    public int getId() {
        return id;
     }

    public void setId(int id) {
      this.id = id;
    }
    
    
}

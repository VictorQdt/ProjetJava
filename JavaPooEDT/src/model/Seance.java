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
    private long date = 0;
    private float duree = 0;
    private int etat;
    private int id_cours;
    private int id_type;
    
    /**
     * Constructeur de séance
     * @param id
     * @param semaine
     * @param date
     * @param duree
     * @param etat
     * @param id_cours
     * @param id_type
     */
    public Seance (int id, int semaine, long date, float duree, int etat, int id_cours,int id_type){
        this.id = id;
        this.semaine = semaine;
        this.date = date;
        this.duree = duree ;
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
    
    public float getDuree(){
        return duree;
    }
    
    
}

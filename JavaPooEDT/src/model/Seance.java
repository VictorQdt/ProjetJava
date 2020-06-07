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
        this.id_cours = id_cours;
        this.id_type = id_type;
    }
    
    public Seance () {}
    
    /**
     *
     * @return id
     */
    public int getId() {
        return id;
     }

    /**
     *
     * @param id
     */
    public void setId(int id) {
      this.id = id;
    }
    
    /**
     *
     * @return duree
     */
    public float getDuree(){
        return duree;
    }

    /**
     *
     * @return semaine
     */
    public int getSemaine() {
        return semaine;
    }

    /**
     *
     * @param semaine
     */
    public void setSemaine(int semaine) {
        this.semaine = semaine;
    }

    /**
     *
     * @return date
     */
    public long getDate() {
        return date;
    }

    /**
     *
     * @param date
     */
    public void setDate(long date) {
        this.date = date;
    }

    /**
     *
     * @return etat
     */
    public int getEtat() {
        return etat;
    }

    /**
     *
     * @param etat
     */
    public void setEtat(int etat) {
        this.etat = etat;
    }

    /**
     *
     * @return id_cours
     */
    public int getId_cours() {
        return id_cours;
    }
    
    /**
     *
     * @param id_cours
     */
    public void setId_cours(int id_cours) {
        this.id_cours = id_cours;
    }

    /**
     *
     * @return id_type
     */
    public int getId_type() {
        return id_type;
    }

    /**
     *
     * @param id_type
     */
    public void setId_type(int id_type) {
        this.id_type = id_type;
    }
    
    
    
    
}

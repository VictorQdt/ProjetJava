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
public class Salle {
    
    Site lieu = new Site();
    
    private int id = 0;
    private String nom = "";
    private int capacite = 0;
    private int id_site;
    
    /**
     * Constructeur de Salle
     * @param id
     * @param capacite
     * @param nom
     * @param id_site
     */
    public Salle (int id, int capacite, String nom, int id_site){
        this.id = id;
        this.nom = nom;
        this.capacite = capacite;
        this.id_site = id_site;
    }
    
    public Salle () {}
    
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
     * @return nom
     */
    public String getNom() {
        return nom;
      }

    /**
     *
     * @param nom
     */
    public void setNom(String nom) {
      this.nom = nom;
    }

    /**
     *
     * @return lieu
     */
    public Site getLieu() {
        return lieu;
    }
    
    /**
     *
     * @param lieu
     */
    public void setLieu(Site lieu) {
        this.lieu = lieu;
    }

    /**
     *
     * @return capacite
     */
    public int getCapacite() {
        return capacite;
    }
    
    /**
     *
     * @param capacite
     */
    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    /**
     *
     * @return id_site
     */
    public int getId_site() {
        return id_site;
    }
    
    /**
     *
     * @param id_site
     */
    public void setId_site(int id_site) {
        this.id_site = id_site;
    }
    
    
}

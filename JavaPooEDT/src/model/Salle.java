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
    
    public Salle (int id, int capacite, String nom, int id_site){
        this.id = id;
        this.nom = nom;
        this.capacite = capacite;
        this.id_site = lieu.getId();
    }
    
    public Salle () {}
    
    public int getId() {
        return id;
     }

    public void setId(int id) {
      this.id = id;
    }
    public String getNom() {
        return nom;
      }

    public void setNom(String nom) {
      this.nom = nom;
    }
}

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
public class Groupe {
    
    Promotion promo = new Promotion();
    
    private int id = 0;
    private String nom = "";
    private int id_promo;
    
    public Groupe (int id, String nom, int id_promo){
        this.id_promo = promo.getId();
        this.id = id;
        this.nom = nom;
    }
    
    public Groupe () {}
    
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

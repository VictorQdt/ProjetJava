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
    

    
    private int id = 0;
    private String nom = "";
    private int id_promo;
    
    /**
     * Constructeur de Groupe
     * @param id
     * @param nom
     * @param id_promo
     */
    public Groupe (int id, String nom, int id_promo){
        this.id_promo = id_promo;
        this.id = id;
        this.nom = nom;
    }
    
    public Groupe () {}

    /**
     *
     * @return id_promo
     */
    public int getId_promo() {
        return id_promo;
    }

    /**
     *
     * @param id_promo
     */
    public void setId_promo(int id_promo) {
        this.id_promo = id_promo;
    }
    
    
    
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
    
    
    
}

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
public class Site {
    private int id = 0;
    private String nom = "";
    
    /**
     *
     * @param id
     * @param nom
     */
    public Site (int id, String nom){
        this.id = id;
        this.nom = nom;
    }
    
    public Site () {}
    
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

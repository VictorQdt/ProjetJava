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
public class Type_Cours {
    
    private int id = 0;
    private String nom = "";
    
    public Type_Cours (int id, String nom){
        this.id = id;
        this.nom = nom;
    }
    
    public Type_Cours () {}
    
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

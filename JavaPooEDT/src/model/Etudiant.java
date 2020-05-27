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
public class Etudiant {
    
    Utilisateur eleve = new Utilisateur();
    Groupe td = new Groupe();
    
    private int nombre = 0;
    private int id;
    private int id_td;
    
    public Etudiant (int id,int id_td, int nombre){
        this.id_td = td.getId();
        this.id = eleve.getId();
        this.nombre = nombre;
    }
    
    public Etudiant () {}
    
    public int getID() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }
   
    
}

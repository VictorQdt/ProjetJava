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
    
    
    private int nombre = 0;
    private int id;
    private int id_td;
    
    public Etudiant (int id,int id_td, int nombre){
        this.id_td = id_td;
        this.id = id;
        this.nombre = nombre;
    }
    
    public Etudiant () {}

    public int getId_td() {
        return id_td;
    }

    public void setId_td(int id_td) {
        this.id_td = id_td;
    }
    
    
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

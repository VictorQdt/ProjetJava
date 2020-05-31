/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author victo
 */
public class Seance_salles {
    
    private int ID_Seance;
    private int ID_Salle;
    
    public Seance_salles(){
        ID_Seance = 0;
        ID_Salle = 0;       
    }
    
    public Seance_salles(int ID_Seance, int ID_Salle){
        this.ID_Seance = ID_Seance;
        this.ID_Salle = ID_Salle;
    }
    
}

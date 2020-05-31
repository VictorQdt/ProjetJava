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
public class Seance_enseignant {
    
    private int ID_Seance;
    private int ID_Enseignant;
    
    public Seance_enseignant(){
        ID_Seance = 0;
        ID_Enseignant = 0;       
    }
    
    public Seance_enseignant(int ID_Seance, int ID_Enseignant){
        this.ID_Seance = ID_Seance;
        this.ID_Enseignant = ID_Enseignant;
    }
    
}

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
public class Seance_groupe {
    
    private int ID_Seance;
    private int ID_Groupe;
    
    public Seance_groupe(){
        ID_Seance = 0;
        ID_Groupe = 0;       
    }
    
    public Seance_groupe(int ID_Seance, int ID_Groupe){
        this.ID_Seance = ID_Seance;
        this.ID_Groupe = ID_Groupe;
    }
    
    
}

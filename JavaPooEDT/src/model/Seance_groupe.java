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
    
    /**
     *
     * @param ID_Seance
     * @param ID_Groupe
     */
    public Seance_groupe(int ID_Seance, int ID_Groupe){
        this.ID_Seance = ID_Seance;
        this.ID_Groupe = ID_Groupe;
    }

    /**
     *
     * @return ID_Seance
     */
    public int getID_Seance() {
        return ID_Seance;
    }

    /**
     *
     * @param ID_Seance
     */
    public void setID_Seance(int ID_Seance) {
        this.ID_Seance = ID_Seance;
    }

    /**
     *
     * @return ID_Groupe
     */
    public int getID_Groupe() {
        return ID_Groupe;
    }

    /**
     *
     * @param ID_Groupe
     */
    public void setID_Groupe(int ID_Groupe) {
        this.ID_Groupe = ID_Groupe;
    }
    
    
    
    
}

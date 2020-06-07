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
    
    /**
     *
     * @param ID_Seance
     * @param ID_Salle
     */
    public Seance_salles(int ID_Seance, int ID_Salle){
        this.ID_Seance = ID_Seance;
        this.ID_Salle = ID_Salle;
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
     * @return ID_Salle
     */
    public int getID_Salle() {
        return ID_Salle;
    }

    /**
     *
     * @param ID_Salle
     */
    public void setID_Salle(int ID_Salle) {
        this.ID_Salle = ID_Salle;
    }
    
}

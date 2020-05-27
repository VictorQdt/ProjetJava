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
public class Enseignant {
    Utilisateur prof = new Utilisateur();
    Cours matiere = new Cours();
    
    private int id;
    private int id_cours;
    
    public Enseignant (int id, int id_cours){
        this.id = prof.getId();
        this.id_cours = matiere.getId();

    }
    
    public Enseignant () {}
}

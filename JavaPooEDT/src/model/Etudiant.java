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
    
    Utilisateur eleve;
    private int nombre = 0;
    private int id = eleve.getId();
    
    public Etudiant (){
        System.out.println(id);
    }
    
    public static void main(String[] args) {
        
        Utilisateur eleve = new Utilisateur();
        System.out.println(eleve.getId());
        
    }
    
}

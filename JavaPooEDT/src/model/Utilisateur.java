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
public class Utilisateur {
     //ID
  private int id = 0;
  //Email de l'utilisateur
  private String email = "";
  //Password de l'utilisateur
  private String pwd = "";
  //Nom de l'utilisateur
  private String nom = "";
  //Prénom de l'utilisateur
  private String prenom = "";
  //Droit de l'utilisateur
  private int droit = 0;
   
  public Utilisateur (int id, String email, String pwd, String nom, 
          String prenom, int droit) {
    this.id = id;
    this.email = email;
    this.pwd = pwd;
    this.nom = nom;
    this.prenom = prenom;
    this.droit = droit;
  }
  
  public Utilisateur () {}
     
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }
  
  public int setDroit() {
    return droit;
  }

  public void setDroit(int droit) {
    this.droit = droit;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getPrenom() {
    return prenom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  } 

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPwd() {
    return pwd;
  }

  public void setPwd(String pwd) {
    this.pwd = pwd;
  }  
  
}

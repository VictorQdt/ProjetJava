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
  private int droit =0;
   
  /**
     *
     * @param id
     * @param email
     * @param pwd
     * @param nom
     * @param prenom
     * @param droit
     */
  public Utilisateur (int id, String email, String pwd, String nom, 
          String prenom, int droit) {
    this.id = id;
    this.email = email;
    this.pwd = pwd;
    this.nom = nom;
    this.prenom = prenom;
    this.droit = droit;
  }

  /**
     *
     * @return droit
     */
    public int getDroit() {
        return droit;
    }
  
  public Utilisateur () {}
     
  /**
     *
     * @return id
     */
  public int getId() {
    return id;
  }

  /**
     *
     * @param id
     */
  public void setId(int id) {
    this.id = id;
  }
  

/**
     *
     * @param droit
     */
  public void setDroit(int droit) {
    this.droit = droit;
  }

  /**
     *
     * @return nom
     */
  public String getNom() {
    return nom;
  }

  /**
     *
     * @param nom
     */
  public void setNom(String nom) {
    this.nom = nom;
  }

  /**
     *
     * @return prenom
     */
  public String getPrenom() {
    return prenom;
  }

  /**
     *
     * @param prenom
     */
  public void setPrenom(String prenom) {
    this.prenom = prenom;
  } 

  /**
     *
     * @return email
     */
  public String getEmail() {
    return email;
  }

  /**
     *
     * @param email
     */
  public void setEmail(String email) {
    this.email = email;
  }

  /**
     *
     * @return pwd
     */
  public String getPwd() {
    return pwd;
  }

  /**
     *
     * @param pwd
     */
  public void setPwd(String pwd) {
    this.pwd = pwd;
  }  
  
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

/**
 *
 * @author coren
 */

public class InfoCours {
  private String nom, duree, ID_Cours, ID_Type, date;

  public InfoCours(){}
  
  /**
     *
     * @param nom
     * @param duree
     * @param ID_Cours
     * @param ID_Type
     * @param date
     */
  public InfoCours(String nom, String duree, String ID_Cours, String ID_Type, String date){
    this.nom = nom;
    this.duree = duree;
    this.ID_Cours = ID_Cours;
    this.ID_Type = ID_Type;
    this.date = date;
  }

    InfoCours(String text, String string, String age, String string0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

 
    


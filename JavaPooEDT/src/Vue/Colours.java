/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import java.awt.Color;
import java.util.Random;

/**
 *
 * @author victo
 */
public class Colours {
    /**
     * Retourne la couleur associée à l'id. L'id sert de graine à la génération d'une couleur aléatoire.
     * @param idCours
     * @return 
     */
    public Color generateColor(int idCours){
        Random rand = new Random(idCours);
        float r = (float) (rand.nextFloat() / 2f + 0.5);
        float g = (float) (rand.nextFloat() / 2f + 0.5);
        float b = (float) (rand.nextFloat() / 2f + 0.5);
        Color randomColor = new Color(r, g, b);
        return randomColor;
    }
    
}

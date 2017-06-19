/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aventuriers;

import Grille.Grille;
import Grille.Tuiles;
import java.util.ArrayList;

/**
 *
 * @author chaulaic
 */
public class Ingenieur extends Aventurier{
    
    public Ingenieur(String nom, Boolean vivant, int nbAction, Couleur couleur) {
        super(nom, vivant, nbAction, couleur);
    }
    // faire if dans controlleur c'est plus simple
    public ArrayList<Tuiles> AssechementPossible(Grille g){
                 ArrayList<Tuiles>tuilesAdj = new ArrayList();
         tuilesAdj = g.getTuilesAdjacentes(positionCourante);
         
         
         return tuilesAdj;
    }

}

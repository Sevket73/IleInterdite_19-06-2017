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
public class Explorateur extends Aventurier {
    
    public Explorateur(String nom, Boolean vivant, int nbAction, Couleur couleur) {
        super(nom, vivant, nbAction, couleur);
    }
    
    public ArrayList<Tuiles>deplacementPossible(Grille g) {
         ArrayList<Tuiles>tuilesAdj = new ArrayList();
         ArrayList<Tuiles>tuilesDiag = new ArrayList();
         ArrayList<Tuiles>tuilesAll = new ArrayList();
         tuilesAdj = g.getTuilesAdjacentes(positionCourante);
         tuilesDiag=getTuilesDiag(g,positionCourante);
         tuilesAll.addAll(tuilesAdj);
         tuilesAll.addAll(tuilesDiag);
         return tuilesAll;
    }
    
    public ArrayList<Tuiles>assechementPossible(Grille g){
         ArrayList<Tuiles>tuilesAdj = new ArrayList();
         ArrayList<Tuiles>tuilesDiag = new ArrayList();
         ArrayList<Tuiles>tuilesAll = new ArrayList();
         tuilesAdj = g.getTuilesAdjacentes(positionCourante);
         tuilesDiag=getTuilesDiag(g,positionCourante);
         tuilesAll.addAll(tuilesAdj);
         tuilesAll.addAll(tuilesDiag);
         return tuilesAdj;
    }
}

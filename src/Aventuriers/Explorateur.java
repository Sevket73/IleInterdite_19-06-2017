/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aventuriers;

import Grille.Grille;
import Grille.Tuiles;
import Modele.Couleur;
import java.util.ArrayList;

/**
 *
 * @author chaulaic
 */
public class Explorateur extends Aventurier {
    
    public Explorateur(String nom, Boolean vivant, int nbAction, Couleur couleur) {
        super(nom, vivant, nbAction, couleur);
    }
  /*
    @Override
    public ArrayList<Tuiles> deplacementPossible(Grille g) {
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
    private ArrayList<Tuiles> getTuilesDiag(Grille g,Tuiles positionCourante){
        ArrayList<Tuiles>tuilesDiag = new ArrayList();
        int l = positionCourante.getCoordonnée().getLigne();
        int c = positionCourante.getCoordonnée().getColonne();
        if((l-1)<0||c-1<0)
        tuilesDiag.add(g.getTuiles((l-1)*6+c-1));
        if((l-1)<0||c+1>5)
        tuilesDiag.add(g.getTuiles((l-1)*6+c+1));
        if((l+1)<5||c-1<0)
        tuilesDiag.add(g.getTuiles((l+1)*6+c-1));
        if((l+1)<5||c-1<5)
        tuilesDiag.add(g.getTuiles((l+1)*6+c+1));
        
        return tuilesDiag;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aventuriers;

import Grille.Grille;
import Grille.Tuile;
import Modele.CouleursEnum;
import java.util.ArrayList;

/**
 *
 * @author chaulaic
 */
public class Explorateur extends Aventurier {
    
    public Explorateur(String nom, Boolean vivant, int nbAction, CouleursEnum couleur) {
        super(nom, vivant, nbAction, couleur);
    }
    
    
  
    @Override
    public ArrayList<Tuile> deplacementPossible(Grille g) {
         ArrayList<Tuile>tuilesAdj = new ArrayList();
         ArrayList<Tuile>tuilesDiag = new ArrayList();
         ArrayList<Tuile>tuilesAll = new ArrayList();
         tuilesAdj = g.getTuilesAdjacentes(positionCourante);
         tuilesDiag=getTuilesDiag(g);
         tuilesAll.addAll(tuilesAdj);
         tuilesAll.addAll(tuilesDiag);
        
         return tuilesAll;
    }
    
    public ArrayList<Tuile> assechementPossible(Grille g){
         ArrayList<Tuile>tuilesAdj = new ArrayList();
         ArrayList<Tuile>tuilesDiag = new ArrayList();
         ArrayList<Tuile>tuilesAll = new ArrayList();
         tuilesAdj = g.getTuilesAdjacentes(positionCourante);
         tuilesDiag=getTuilesDiag(g);
         tuilesAll.addAll(tuilesAdj);
         tuilesAll.addAll(tuilesDiag);
         return tuilesAdj;
    }
    private ArrayList<Tuile> getTuilesDiag(Grille g){
        ArrayList<Tuile>tuilesDiag = new ArrayList();
        
        int l = positionCourante.getCoordonnée().getLigne();
        int c = positionCourante.getCoordonnée().getColonne();
        
        if(l-1<0){
            //System.out.println("capueH");
        }else if(((l-1)*6+(c-1)==0)||((l-1)*6+(c-1)==1)||((l-1)*6+(c-1)==6)||(c<0)){
          //  System.out.println("CapueGraveHG");
        }else{
            tuilesDiag.add(g.getTuiles((l-1)*6+c-1));
        }
        if(l-1<0){
          //  System.out.println("capueH");
        }else if(((l-1)*6+(c+1)==4)||((l-1)*6+(c+1)==5)||((l-1)*6+(c+1)==11)||(c>5)){
          //  System.out.println("capueGraveHD");
        }else{
            tuilesDiag.add(g.getTuiles((l-1)*6+c+1));
        }
        if (l+1>5){
           // System.out.println("capueB");
        }else if(((l+1)*6+(c-1)==24)||((l+1)*6+(c-1)==30)||((l+1)*6+(c-1)==31)||(c<0)){
          //  System.out.println("capueGraveBG");
        }else{
            tuilesDiag.add(g.getTuiles((l+1)*6+c-1));
        }
        if (l+1>5){
           // System.out.println("capueB");
        }else if(((l+1)*6+(c+1)==29)||((l+1)*6+(c+1)==34)||((l+1)*6+(c+1)==35)||(c>5)){
            // System.out.println("capueGraveBD");   
        }else{
            tuilesDiag.add(g.getTuiles((l+1)*6+c+1));
        }
        
        return tuilesDiag;
    }
    
}

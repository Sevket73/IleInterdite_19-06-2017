/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aventuriers;

import static Grille.Etat.*;
import Grille.Grille;
import java.util.ArrayList;
import Grille.Tuiles;
import Modele.Couleur;

/**
 *
 * @author chaulaic
 */
public class Plongeur extends Aventurier {

    public Plongeur(String nom, Boolean vivant, int nbAction, Couleur couleur) {
        super(nom, vivant, nbAction, couleur);
    }
    
    public ArrayList<Tuiles> deplacementpossible(Grille g){
        ArrayList<Tuiles>tuilesAdj = new ArrayList();
        ArrayList<Tuiles>tuilesTest = new ArrayList();
        
        tuilesTest = g.getTuilesAdjacentes(positionCourante);
        for ( Tuiles t :tuilesTest){
            for (Tuiles t2 : g.getTuilesAdjacentes(t)){
                if(t2.getEtat()==Assechee){
                tuilesAdj.add(t2);
                
                
                }else if(t2.getEtat()==Inondee || t2.getEtat()==coulee){
                    if(!tuilesTest.contains(t2)){
                    tuilesTest.add(t2);}
                }
                
            }
        }
        return tuilesAdj;
    }

}

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
    @Override
    public ArrayList<Tuiles> deplacementPossible(Grille g) {
        ArrayList<Tuiles> tuilesAdj = new ArrayList();
        ArrayList<Tuiles> tuilesT = new ArrayList();
        tuilesT.add(positionCourante);
        for( int i = 0 ; i<tuilesT.size();i++){
            if(tuilesT.get(i).getEtat() !=coulee ){
                tuilesAdj.add(tuilesT.get(i));
            }
            for(Tuiles t : g.getTuilesAdjacentes(tuilesT.get(i))){
                
                if(t.getEtat() == Assechee && !tuilesAdj.contains(t)){
                    tuilesAdj.add(t);
                }
                else if ( t.getEtat() != Assechee && !tuilesT.contains(t)){
                    tuilesT.add(t);
                }
            }
        }
                
        tuilesAdj.remove(positionCourante);
            

        
        return tuilesAdj;
}        
}

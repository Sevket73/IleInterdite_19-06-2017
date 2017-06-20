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
        ArrayList<Tuiles> tuilesAdj = new ArrayList<>();
        ArrayList<Tuiles> tuilesATest = new ArrayList<>();
        tuilesATest.add(positionCourante);
        
        for ( int i = 0 ; i<tuilesATest.size();i++){
            for(Tuiles t : g.getTuilesAdjacentes(tuilesATest.get(i))){
                if(t.getEtat()!=Assechee){
                    
                    if(!tuilesATest.contains(t))
                        if(t.getEtat()==Inondee){
                            tuilesAdj.add(t);}
                            tuilesATest.add(t);

                }else{
                    if(!tuilesATest.contains(t))
                        tuilesATest.add(t);
                }
            }
        }

        
        return tuilesAdj;
}        
}

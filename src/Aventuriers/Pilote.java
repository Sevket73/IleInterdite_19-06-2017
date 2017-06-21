/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aventuriers;

import static Grille.Etat.coulee;
import Grille.Grille;
import Grille.Tuiles;
import Modele.Couleur;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author chaulaic
 */
public class Pilote extends Aventurier {
    public Pilote(String nom, Boolean vivant, int nbAction, Couleur couleur){
        super(nom, vivant, nbAction, couleur);
    }
    
    @Override
    public ArrayList<Tuiles> deplacementPossible(Grille g) {
        Collection<Tuiles> tteLesTuiles = new ArrayList<>();
        ArrayList<Tuiles> tuilesAdj = new ArrayList();
        
        tteLesTuiles = g.getHmGrille().values();
        for( Tuiles t : tteLesTuiles){
            if(t.getEtat()!=coulee)
                tuilesAdj.add(t);
        }
           
        return tuilesAdj;
    }
}

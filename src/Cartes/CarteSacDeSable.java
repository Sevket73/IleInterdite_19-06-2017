/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cartes;

import Grille.Etat;
import Grille.Grille;
import Grille.Tuiles;
import java.util.ArrayList;

/**
 *
 * @author chaulaic
 */
public class CarteSacDeSable extends CartesTirage  {

    public CarteSacDeSable() {
        super();
        setNom("SacDeSable");
    
    }
    public ArrayList<Tuiles> assechementPossible(Grille g){
        ArrayList<Tuiles> assPoss = new ArrayList();
        for (Tuiles t : g.getAze().values()) {
            if (t.getEtat() != Etat.Inondee) {
                assPoss.add(t);
            } 
        }  
        
    return assPoss;

    }
}


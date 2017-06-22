/*
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates

package comment;

import Cartes.CartesTirage;
import Grille.EtatEnum;
import Grille.Grille;
import Grille.Tuile;
import java.util.ArrayList;

/**
 *
 * @author chaulaic

public class CarteSacDeSable   {

    public CarteSacDeSable() {
        super();
        setNom("SacDeSable");
    
    }
    public ArrayList<Tuile> assechementPossible(Grille g){
        ArrayList<Tuile> assPoss = new ArrayList();
        for (Tuile t : g.getHmGrille().values()) {
            if (t.getEtat() != EtatEnum.Inondee) {
                assPoss.add(t);
            } 
        }  
        
    return assPoss;

    }
}
*/

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
import java.util.Collection;
import static Grille.EtatEnum.Coulee;

/**
 *
 * @author chaulaic
 */
public class Pilote extends Aventurier {  
    private boolean actionSpe = true ;
    public Pilote(String nom, Boolean vivant, int nbAction, CouleursEnum couleur){
        super(nom, vivant, nbAction, couleur);
    }

    
    
    @Override
    public ArrayList<Tuile> deplacementPossible(Grille g) {
        Collection<Tuile> tteLesTuiles = new ArrayList<>();
        ArrayList<Tuile> tuilesAdj = new ArrayList();
        
        tteLesTuiles = g.getHmGrille().values();
        for( Tuile t : tteLesTuiles){
            if(t.getEtat()!=Coulee)
                tuilesAdj.add(t);
        }
           
        return tuilesAdj;
    }

    /**
     * @return the actionSpe
     */
    public boolean isActionSpe() {
        return actionSpe;
    }

    /**
     * @param actionSpe the actionSpe to set
     */
    public void setActionSpe(boolean actionSpe) {
        this.actionSpe = actionSpe;
    }
}

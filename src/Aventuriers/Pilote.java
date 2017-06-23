/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aventuriers;

import Grille.EtatEnum;
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
    public void resetActions()
    {
        nombreActions = 3;
        this.setActionSpe(true);
    }
    
    @Override
    public ArrayList<Tuile> deplacementPossible(Grille g) {//Le pilote peut se déplacer n'importe où sur la carte 1 fois par tour
        Collection<Tuile> tteLesTuiles = new ArrayList<>();
        ArrayList<Tuile> tuilesAdj = new ArrayList();
        ArrayList<Tuile> tuilesAdjBis = new ArrayList();
        if(this.isActionSpe()){
        
        
        tteLesTuiles = g.getHmGrille().values();
        for( Tuile t : tteLesTuiles){
            if(t.getEtat()!=Coulee)
                tuilesAdj.add(t);
        }
        this.setActionSpe(false);
        }else{
             tuilesAdj = g.getTuilesAdjacentes(positionCourante);

        for (Tuile t : tuilesAdj) {
            if (t.getEtat() == EtatEnum.Coulee) {
                tuilesAdjBis.add(t);
            }
        }
        tuilesAdj.removeAll(tuilesAdjBis);
        }
        return tuilesAdj;
    }

    /**
     * @return the actionSpe
     */
    public boolean isActionSpe() {//retourne vrai si le joueur utilise son action special
        return actionSpe;
    }

    /**
     * @param actionSpe the actionSpe to set
     */
    public void setActionSpe(boolean actionSpe) {
        this.actionSpe = actionSpe;
    }
}

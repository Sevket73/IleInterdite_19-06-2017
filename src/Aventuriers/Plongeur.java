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
        ArrayList<Tuiles> aze = new ArrayList<>();
        tuilesATest.add(positionCourante);

        for (int i = 0; i < tuilesATest.size(); i++) {
            Tuiles t = tuilesATest.get(i);
            aze = g.getTuilesAdjacentes(t);
            for (int x = 0; x < aze.size(); x++) {
                Tuiles t2 = aze.get(x);

                if (t2.getEtat() == (Assechee) ){
                    if (!tuilesAdj.contains(t2)) {
                        tuilesAdj.add(t2);
                    }
                } else if (t2.getEtat() == Inondee) {
                    if(!tuilesATest.contains(t2))
                    tuilesATest.add(t2);
                    if(!tuilesAdj.contains(t2))
                    tuilesAdj.add(t2);
                } else if (t2.getEtat() == coulee) {
                    if(!tuilesATest.contains(t2))
                    tuilesATest.add(t2);
                }

            }
        }
        tuilesAdj.remove(positionCourante);
        return tuilesAdj;
    }
}

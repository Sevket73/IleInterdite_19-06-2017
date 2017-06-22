/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aventuriers;

import static Grille.EtatEnum.*;
import Grille.Grille;
import java.util.ArrayList;
import Grille.Tuile;
import Modele.CouleursEnum;

/**
 *
 * @author chaulaic
 */
public class Plongeur extends Aventurier {

    public Plongeur(String nom, Boolean vivant, int nbAction, CouleursEnum couleur) {
        super(nom, vivant, nbAction, couleur);
    }

    @Override
    public ArrayList<Tuile> deplacementPossible(Grille g) {
        ArrayList<Tuile> tuilesAdj = new ArrayList<>();
        ArrayList<Tuile> tuilesATest = new ArrayList<>();
        ArrayList<Tuile> aze = new ArrayList<>();
        tuilesATest.add(positionCourante);

        for (int i = 0; i < tuilesATest.size(); i++) {
            Tuile t = tuilesATest.get(i);
            aze = g.getTuilesAdjacentes(t);
            for (int x = 0; x < aze.size(); x++) {
                Tuile t2 = aze.get(x);
                System.out.println(t2.getEtat());
                if (t2.getEtat() == (Assechee)){
                    System.out.println("coucou");
                    if (!tuilesAdj.contains(t2)) {
                        tuilesAdj.add(t2);
                    }
                } else if (t2.getEtat() == Inondee) {
                    if(!tuilesATest.contains(t2))
                    tuilesATest.add(t2);
                    if(!tuilesAdj.contains(t2))
                    tuilesAdj.add(t2);
                } else if (t2.getEtat() == Coulee) {
                    if(!tuilesATest.contains(t2))
                    tuilesATest.add(t2);
                }

            }
        }
        tuilesAdj.remove(positionCourante);
        return tuilesAdj;
    }
}

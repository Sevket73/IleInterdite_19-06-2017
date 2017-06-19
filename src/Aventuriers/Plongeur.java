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

    public ArrayList<Tuiles> deplacementpossible(Grille g) {
        ArrayList<Tuiles> tuilesAdj = new ArrayList();
        ArrayList<Tuiles> tuilesTest = new ArrayList();

        tuilesTest=g.getTuilesAdjacentes(positionCourante); 

            for (int i =0; i<tuilesTest.size();i++) {
                if (tuilesTest.get(i).getEtat() == Assechee) {
                    if (!tuilesTest.contains(tuilesTest.get(i))) 
                    tuilesAdj.add(tuilesTest.get(i));
                    

                } else if (tuilesTest.get(i).getEtat() == Inondee || tuilesTest.get(i).getEtat() == coulee) {
                    if (!tuilesTest.contains(tuilesTest.get(i))) {
                        tuilesTest.add(tuilesTest.get(i));
                        tuilesTest.addAll(g.getTuilesAdjacentes(tuilesTest.get(i)));
                    }
                }
            }
            

        
        return tuilesAdj;
}        
}

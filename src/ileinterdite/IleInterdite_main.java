/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ileinterdite;

import Aventuriers.*;
import Modele.Controleur;
import Modele.CouleursEnum;
import Grille.Grille;
import View.VueMenu;
import View.VueRules;

/**
 *
 * @author chaulaic
 */
public class IleInterdite_main {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        // TODO code application logic here
        
        // test de code sans ihm

                
        Aventurier j1 = new Pilote("Michel", true, 3, CouleursEnum.Bleu);
        Aventurier j2 = new Ingenieur("Paul", true, 3, CouleursEnum.Jaune);
        Aventurier j3 = new Explorateur("Sandrine", true, 3, CouleursEnum.Rouge);
        Aventurier j4 = new Plongeur("Annie", true, 3, CouleursEnum.Noir);
        Grille g = new Grille();
        Controleur c = new Controleur(2,g);

        
        c.jouer(j1, j2, j3, j4,g);
        
    }
    
}

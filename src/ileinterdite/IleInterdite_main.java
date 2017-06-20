/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ileinterdite;

import Aventuriers.Aventurier;
import Aventuriers.Explorateur;
import Aventuriers.Plongeur;
import Modele.Controleur;
import Modele.Couleur;
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

                
        Aventurier j1 = new Aventurier("Michel", true, 3, Couleur.Bleu);
        Aventurier j2 = new Aventurier("Paul", true, 3, Couleur.Jaune);
        Aventurier j3 = new Explorateur("Sandrine", true, 3, Couleur.Rouge);
        Plongeur j4 = new Plongeur("Annie", true, 3, Couleur.Noir);
        Grille g = new Grille();
        Controleur c = new Controleur(2,g);
        c.creerGrille(g);
        
        
        //System.out.println(g.getTuiles(14).getEtat());
        //System.out.println(g.getTuiles(3).getEtat());
        
        j1.setPositionCourante(3, 2);
        j2.setPositionCourante(3, 1);
        j3.setPositionCourante(3, 0);
        j4.setPositionCourante(2, 1);
        
        c.jouer(j1, j2, j3, j4, g);
        
    }
    
}

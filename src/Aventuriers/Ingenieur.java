/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aventuriers;

import Grille.Grille;
import Grille.Tuiles;
import Modele.Couleur;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author chaulaic
 */
public class Ingenieur extends Aventurier{
    
    public Ingenieur(String nom, Boolean vivant, int nbAction, Couleur couleur) {
        super(nom, vivant, nbAction, couleur);
    }

    @Override
    public void assechement(Grille g) { // faire en sorte qu'il ne soit pas obliger d'assecher 2 tuiles en une fois ** souhaitez vous assecher 1 ou 2 tuiles?
        ArrayList<Tuiles> tuilesAssechables = new ArrayList<>();
        
        for (int i = 1; i < 3; i++) {
            tuilesAssechables = this.tuilesAssechables(g);
                if (tuilesAssechables.isEmpty()) {
                    System.out.println("Il n'y a aucune tuile à assecher !");
                    break;
                }
            System.out.println("Quelle tuile souhaitez vous assecher ? (" + i + ")");
            for (Tuiles t : tuilesAssechables) {
                System.out.println(t.getNom());
            }
            Scanner repAss = new Scanner(System.in);
            String ass;
            ass = repAss.nextLine();
            for (Tuiles t : tuilesAssechables) {
                if (ass.equals(t.getNom())) {
                    this.assecher(t);
                    //tuilesAssechables.remove(t);
                } else {
                    continue;
                }
            }
        }
        
    }

}

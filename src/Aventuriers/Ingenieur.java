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
        
        System.out.println("Vous pouvez assecher " + this.tuilesAssechables(g).size() + " tuile(s) en une fois");
        System.out.println("");
        
            
        if (this.tuilesAssechables(g).isEmpty()) {
            System.out.println("Il n'y a aucune tuile à assecher !");
        } else {
            System.out.println("Combien de tuile souhaitez vous assécher en une fois ? (1/2) ");
            Scanner repAss = new Scanner(System.in);
            String nbTuileAss;
            nbTuileAss = repAss.nextLine();

            if (nbTuileAss.equals("1")) {
                System.out.println("Quelle tuile souhaitez vous assecher ? ");
                for (Tuiles t : tuilesAssechables) {
                    System.out.println(t.getNom());
                }

                String ass;
                ass = repAss.nextLine();
                for (Tuiles t : tuilesAssechables) {
                    if (ass.equals(t.getNom())) {
                        this.assecher(t);
                    } else {
                        continue;
                    }
                }
            } else {
                for (int i = 1; i < 3; i++) {
                tuilesAssechables = this.tuilesAssechables(g);
                    if (tuilesAssechables.isEmpty()) {
                        System.out.println("Il n'y a aucune tuile à assecher !");
                        break;
                    } else {
                        System.out.println("Quelle tuile souhaitez vous assecher ? (" + i + ")");
                        for (Tuiles t : tuilesAssechables) {
                            System.out.println(t.getNom());
                        }
                        String ass;
                        ass = repAss.nextLine();
                        for (Tuiles t : tuilesAssechables) {
                            if (ass.equals(t.getNom())) {
                                this.assecher(t);
                            } else {
                                continue;
                            }
                        }   
                    }

                }
            }
        }
    }
}

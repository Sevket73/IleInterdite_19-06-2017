/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aventuriers;

import Cartes.CarteTresor;
import Cartes.CartesTirage;
import Modele.Couleur;
import java.util.Scanner;

/**
 *
 * @author chaulaic
 */
public class Messager extends Aventurier {
    
    public Messager(String nom, Boolean vivant, int nbAction, Couleur couleur) {
        super(nom, vivant, nbAction, couleur);
    }
    
    public void donnerCarteTresor(Aventurier j) {
        if (j instanceof Messager) {
            System.out.println("Quelle carte souhaitez vous donner ? ");
        for (CartesTirage c : this.getCartesEnMain()){
            if (c instanceof CarteTresor) {
                System.out.println(((CarteTresor) c).getNomTresor());
            }
        }
        String tresor;
        Scanner rep = new Scanner(System.in);
        tresor = rep.nextLine();
        System.out.println("A quel joueur souhaitez vous la donner ? ");
        }
        
        
    }
    
}

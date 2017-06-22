/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aventuriers;

import Cartes.CarteTresor;
import Cartes.CartesTirage;
import Modele.CouleursEnum;
import java.util.Scanner;

/**
 *
 * @author chaulaic
 */
public class Messager extends Aventurier {
    
    public Messager(String nom, Boolean vivant, int nbAction, CouleursEnum couleur) {
        super(nom, vivant, nbAction, couleur);
    }
    @Override
    public void donnerCarteTresor(CartesTirage c,Aventurier j) {
       j.addCarteEnMain(c);
       this.enleverCarte(c);
    }
    
}

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
    
    public void donnerCarteTresor(CartesTirage t,Aventurier j) {
       j.addCarteEnMain(t);
       this.enleverCarte(t);
    }
    
}

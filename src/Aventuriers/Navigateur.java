/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aventuriers;

import Grille.Grille;
import Modele.Couleur;
import java.util.Scanner;

/**
 *
 * @author chaulaic
 */
public class Navigateur extends Aventurier {
    
    public Navigateur(String nom, Boolean vivant, int nbAction, Couleur couleur) {
        super(nom, vivant, nbAction, couleur);
    }
    
}

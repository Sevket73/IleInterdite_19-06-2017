/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grille;

import Grille.Tuiles;

/**
 *
 * @author chaulaic
 */
public class Coordonnee {
    private int colonne;
    private int ligne;
    private Tuiles tuile;
    
    public Coordonnee(int colonne, int ligne) {
        this.colonne = colonne;
        this.ligne = ligne;
    }

    public int getColonne() {
        return colonne;
    }

    public int getLigne() {
        return ligne;
    }

    public Tuiles getTuile() {
        return tuile;
    }

    public void setColonne(int colonne) {
        this.colonne = colonne;
    }

    public void setLigne(int ligne) {
        
        this.ligne = ligne;
    }
}

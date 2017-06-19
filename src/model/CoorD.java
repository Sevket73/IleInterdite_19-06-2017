/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author chaulaic
 */
public class CoorD {
    public int colonne;
    public int ligne;
    public Tuiles tuile;
    
    CoorD(int colonne, int ligne) {
        this.colonne = colonne;
        this.ligne = ligne;
        this.tuile = null;
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

    private void setColonne(int colonne) {
        this.colonne = colonne;
    }

    private void setLigne(int ligne) {
        
        this.ligne = ligne;
    }
}

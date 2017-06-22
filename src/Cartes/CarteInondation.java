/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cartes;

import Grille.Tuile;

/**
 *
 * @author chaulaic
 */
public class CarteInondation extends Cartes {

    private Tuile cible;

    public CarteInondation(Tuile cible) {
        this.cible = cible;

    }

    /**
     * @return the cible
     */
    public Tuile getCible() {
        return cible;
    }

    /**
     * @param cible the cible to set
     */
    public void setCible(Tuile cible) {
        this.cible = cible;
    }
}

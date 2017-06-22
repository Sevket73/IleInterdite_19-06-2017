/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cartes;

import Grille.Tuiles;

/**
 *
 * @author chaulaic
 */
public class CarteInondation extends Cartes {

    private Tuiles cible;

    public CarteInondation(Tuiles cible) {
        this.cible = cible;

    }

    /**
     * @return the cible
     */
    public Tuiles getCible() {
        return cible;
    }

    /**
     * @param cible the cible to set
     */
    public void setCible(Tuiles cible) {
        this.cible = cible;
    }
}

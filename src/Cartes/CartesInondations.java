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
public class CartesInondations  extends Cartes{
    private Tuiles cible;
    private Tuiles tuileInondable;
    
    public CartesInondations(Tuiles cible, Tuiles tuileInondable) {
        this.cible = cible;
        this.tuileInondable = tuileInondable;
    }
}

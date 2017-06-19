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
public class CartesInondations {
    private Tuiles cible;
    private Tuiles tuileInondable;
    
    public void cartesInondations(Tuiles cible, Tuiles tuileInondable) {
        this.cible = cible;
        this.tuileInondable = tuileInondable;
    }
}

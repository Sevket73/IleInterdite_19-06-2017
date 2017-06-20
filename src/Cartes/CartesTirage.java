/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cartes;

import Aventuriers.Aventurier;

/**
 *
 * @author chaulaic
 */
public class CartesTirage extends Cartes {
    private Aventurier aventurierPocesseur;

    public CartesTirage() {
        this.aventurierPocesseur = null;
    }
    
    
    
    public void ajouterPocesseur(Aventurier j) {
        if (this.aventurierPocesseur == null) {
            this.aventurierPocesseur = j;
        } 
    }
    
    
    
}

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
public class CartesTirage extends Cartes{
    private Aventurier aventurierPocesseur;
    private Aventurier aventurierPossesseur;
    public CartesTirage() {
        this.aventurierPocesseur = null;
    }
        
    
    /**
     * @return the aventurier
     */
    public Aventurier getAventurier() {
        return aventurierPossesseur;
    }

    /**
     * @param aventurier the aventurier to set
     */
    public void setAventurier(Aventurier aventurier) {
        this.aventurierPossesseur = aventurier;
    }

    
}

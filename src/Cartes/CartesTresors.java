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
public class CartesTresors extends Cartes {
    private Tresor tresor;
    private Aventurier aventurierPocesseur;

    public CartesTresors(int num, Tresor tresor) {
        super(num);
        this.tresor = tresor;
        this.aventurierPocesseur = null;
    }
    
    
    
    public void ajouterPocesseur(Aventurier j) {
        if (this.aventurierPocesseur == null) {
            this.aventurierPocesseur = j;
        } 
    }
    
}

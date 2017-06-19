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
    
    public void cartesTresors(Tresor tresor, Aventurier aventurierPocesseur) {
        this.tresor = tresor;
        this.aventurierPocesseur = aventurierPocesseur;
    }
    
    
}

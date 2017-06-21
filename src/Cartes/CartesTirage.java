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
    private String nom;
    
    public CartesTirage() {
        this.aventurierPocesseur = null;
    }
    
    
    
    public void ajouterPocesseur(Aventurier j) {
        if (this.getAventurierPocesseur() == null) {
            this.setAventurierPocesseur(j);
        } 
    }

    /**
     * @return the aventurierPocesseur
     */
    public Aventurier getAventurierPocesseur() {
        return aventurierPocesseur;
    }

    /**
     * @param aventurierPocesseur the aventurierPocesseur to set
     */
    public void setAventurierPocesseur(Aventurier aventurierPocesseur) {
        this.aventurierPocesseur = aventurierPocesseur;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    
    
}

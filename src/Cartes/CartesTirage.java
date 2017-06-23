/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cartes;

import Aventuriers.Aventurier;
import Grille.Grille;
import Grille.Tuile;

/**
 *
 * @author chaulaic
 */
public class CartesTirage extends Cartes {
   private Aventurier aventurierPossesseur;
    String nom;

    public CartesTirage(String nom) {
        this.setNom(nom);
    }
    
    
    
    public void ajouterPocesseur(Aventurier j) {//Lorqu'un joueur tire une carte tirage, cette derniere est possedée par un aventurier
        if (this.getAventurierPocesseur() == null) {
            this.setAventurierPocesseur(j);
        } 
    }


     
    public Aventurier getAventurierPocesseur() {
        return aventurierPossesseur;
    }

     
    public void setAventurierPocesseur(Aventurier aventurierPocesseur) {
        this.aventurierPossesseur = aventurierPocesseur;
    }

   
       
    public String getNom() {
        return nom;
    }


     
    public void setNom(String nom) {
        this.nom = nom;
    }
}

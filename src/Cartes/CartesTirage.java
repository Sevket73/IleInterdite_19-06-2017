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
    
    
    
    public void ajouterPocesseur(Aventurier j) {
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
    /*
    
    public void deplacer1Joueur(Aventurier j1,String tuile,Grille g){

    }
    
    public void deplacer2Joueurs(Aventurier j1,Aventurier j2,String tuile,Grille g){

    }
    
    public void deplacer3Joueurs(Aventurier j1,Aventurier j2,Aventurier j3,String tuile,Grille g){

    }
    public void deplacer4Joueurs(Aventurier j1,Aventurier j2,Aventurier j3,Aventurier j4,String tuile,Grille g){

    }
   */
    
    
    
}

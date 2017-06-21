/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grille;

import Aventuriers.Aventurier;
import Modele.Couleur;
import Cartes.Tresor;
import static Grille.Etat.coulee;
import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author chaulaic
 */
public class Tuiles {
    String nom;
    Etat etat; 
    Couleur couleur;
    Tresor tresor;
    Aventurier departAventurier;
    ArrayList<Aventurier> possedeAventurier;
    CoorD coordonnées;
    
    public Tuiles(String nom, CoorD c, Tresor tresor) {
        this.setNom(nom);
        this.etat = null;
        this.couleur = null;
        this.tresor = tresor;
        this.departAventurier = null;
        this.possedeAventurier = new ArrayList<>();
        this.coordonnées = c;
    }
    public Tuiles(CoorD c){
        this.setNom(null);
        this.etat = null;
        this.couleur = null;
        this.tresor = null;
        this.departAventurier = null;
        this.possedeAventurier = new ArrayList<>();
        this.coordonnées = c;
    }

    /**
     * @return the etat
     */
    public Etat getEtat() {
        return etat;
    }

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }
    

    /**
     * @return the couleur
     */
    public Couleur getCouleur() {
        return couleur;
    }

    /**
     * @return the tresor
     */
    public Tresor getTresor() {
        return tresor;
    }

    /**
     * @return the departAventurier
     */
    public Aventurier getDepartAventurier() {
        return departAventurier;
    }

    /**
     * @return the possedeAventurier
     */
    public ArrayList<Aventurier> getPossedeAventurier() {
        return possedeAventurier;
    }

    /**
     * @return the coordonnée
     */
    public CoorD getCoordonnée() {
        return coordonnées;
    }

    /**
     * @param nom the nom to set
     */
    private void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @param etat the etat to set
     */
    private void setEtat(Etat etat) {
        this.etat = etat;
    }

    /**
     * @param couleur the couleur to set
     */
    private void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }

    /**
     * @param tresor the tresor to set
     */
    public void setTresor(Tresor tresor) {
        this.tresor = tresor;
    }

    /**
     * @param departAventurier the departAventurier to set
     */
    public void setDepartAventurier(Aventurier departAventurier) {
        departAventurier.setPositionCourante(this.getCoordonnée().getColonne(),this.getCoordonnée().getLigne());
    }

    /**
     * @param possedeAventurier the possedeAventurier to set
     */
    public void setPossedeAventurier(ArrayList<Aventurier> possedeAventurier) {
        this.possedeAventurier = possedeAventurier;
    }
    public void addPossedeAventurier(Aventurier possedeAventurier){
        this.possedeAventurier.add(departAventurier);
    
    }
    public void removePossedeAventurier(Aventurier possedeAventurier){
        this.possedeAventurier.remove(possedeAventurier);
    }
    

    /**
     * @param coordonnée the coordonnée to set
     */
    public void setCoordonnée(int c, int l) {
        this.coordonnées.setColonne(c);
        this.coordonnées.setLigne(l);
    }
    
    public void changerEtat(Etat etat){
        this.setEtat(etat);
      
    }
    public void changerCouleur(Couleur couleur){
        this.setCouleur(couleur);
    }
}
    


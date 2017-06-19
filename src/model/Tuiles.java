/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author chaulaic
 */
public class Tuiles {
    String nom;
    Etat etat; 
    Color couleur;
    Tresor tresor;
    Aventurier departAventurier;
    ArrayList<Aventurier> possedeAventurier;
    CoorD coordonnées;
    
    Tuiles(String nom, CoorD c) {
        this.setNom(nom);
        this.etat = null;
        this.couleur = null;
        this.tresor = null;
        this.departAventurier = null;
        this.possedeAventurier = new ArrayList();
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
    public Color getCouleur() {
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
    private void setCouleur(Color couleur) {
        this.couleur = couleur;
    }

    /**
     * @param tresor the tresor to set
     */
    private void setTresor(Tresor tresor) {
        this.tresor = tresor;
    }

    /**
     * @param departAventurier the departAventurier to set
     */
    private void setDepartAventurier(Aventurier departAventurier) {
        this.departAventurier = departAventurier;
    }

    /**
     * @param possedeAventurier the possedeAventurier to set
     */
    private void setPossedeAventurier(ArrayList<Aventurier> possedeAventurier) {
        this.possedeAventurier = possedeAventurier;
    }

    /**
     * @param coordonnée the coordonnée to set
     */
    private void setCoordonnée(CoorD coordonnée) {
        this.coordonnées = coordonnée;
    }
    
}

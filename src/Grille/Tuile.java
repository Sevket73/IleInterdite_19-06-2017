/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grille;

import Aventuriers.Aventurier;
import Modele.CouleursEnum;
import Cartes.TresorsEnum;
import java.awt.Color;
import java.util.ArrayList;
import static Grille.EtatEnum.Coulee;

/**
 *
 * @author chaulaic
 */
public class Tuile {
    private String nom;
    private EtatEnum etat; 
    private CouleursEnum couleur;
    private String tresor;
    private Aventurier departAventurier;
    private ArrayList<Aventurier> possedeAventurier;
    private Coordonnee coordonnées;
    
    public Tuile(String nom, Coordonnee c, String tresor) {
        this.setNom(nom);
        this.etat = null;
        this.couleur = null;
        this.tresor = tresor;
        this.departAventurier = null;
        this.possedeAventurier = new ArrayList<>();
        this.coordonnées = c;
    }
    public Tuile(Coordonnee c){
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
    public EtatEnum getEtat() {
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
    public CouleursEnum getCouleur() {
        return couleur;
    }

    /**
     * @return the tresor
     */
    public String getTresor() {
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
    public Coordonnee getCoordonnée() {
        return coordonnées;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @param etat the etat to set
     */
    private void setEtat(EtatEnum etat) {
        this.etat = etat;
    }

    /**
     * @param couleur the couleur to set
     */
    private void setCouleur(CouleursEnum couleur) {
        this.couleur = couleur;
    }

    /**
     * @param tresor the tresor to set
     */
    public void setTresor(String tresor) {
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
    public void addPossedeAventurier(Aventurier j){//lorqu'un joueur s'arrete sur une tuile, on ajoute à cette derniere un Aventurier
        this.possedeAventurier.add(departAventurier);
    
    }
    public void removePossedeAventurier(Aventurier j){//lorqu'un joueur part d'une tuile, on ajoute à cette derniere un Aventurier
        this.possedeAventurier.remove(j);
    }
    

    /**
     * @param coordonnée the coordonnée to set
     */
    public void setCoordonnée(int c, int l) {
        this.coordonnées.setColonne(c);
        this.coordonnées.setLigne(l);
    }
    
    public void changerEtat(EtatEnum etat){
        this.setEtat(etat);
      
    }
    public void changerCouleur(CouleursEnum couleur){
        this.setCouleur(couleur);
    }
}
    


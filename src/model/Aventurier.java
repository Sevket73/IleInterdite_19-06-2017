/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import static model.Etat.Inondee;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author chaulaic
 */
public class Aventurier {
    protected String nom;
    protected Boolean vivant;
    protected int nbAction;
    protected Color couleur;
    protected ArrayList<CartesTresors> cartesEnMain;
    private Tuiles positionCourante;
    
    
    public void Aventurier(String nom, Boolean vivant, int nbAction, Color couleur) {
        this.setNom(nom);
        this.setVivant(vivant);
        this.setNbAction(nbAction);
        this.setCouleur(couleur);
    }
    
    //getteurs et setteurs :
    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @return the vivant
     */
    public Boolean getVivant() {
        return vivant;
    }

    /**
     * @return the nbAction
     */
    public int getNbAction() {
        return nbAction;
    }

    /**
     * @return the couleur
     */
    public Color getCouleur() {
        return couleur;
    }

    /**
     * @return the cartesEnMain
     */
    public ArrayList<CartesTresors> getCartesEnMain() {
        return cartesEnMain;
    }

    /**
     * @param nom the nom to set
     */
    private void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @param vivant the vivant to set
     */
    private void setVivant(Boolean vivant) {
        this.vivant = vivant;
    }

    /**
     * @param nbAction the nbAction to set
     */
    private void setNbAction(int nbAction) {
        this.nbAction = nbAction;
    }

    /**
     * @param couleur the couleur to set
     */
    private void setCouleur(Color couleur) {
        this.couleur = couleur;
    }

    /**
     * @param cartesEnMain the cartesEnMain to set
     */
    private void setCartesEnMain(ArrayList<CartesTresors> cartesEnMain) {
        this.cartesEnMain = cartesEnMain;
    }
    
    /**
     * @return the positionCourante
     */
    public Tuiles getPositionCourante() {
        return positionCourante;
    }

    /**
     * @param positionCourante the positionCourante to set
     */
    public void setPositionCourante(Tuiles positionCourante) {
        this.positionCourante = positionCourante;
    }
    
    
    
    /*private Collection getTuileAdj(Grille g){
        Collection<Tuiles> collecTuiAdj = new ArrayList();
        collecTuiAdj.add(
      
            
    }

    public Collection getTuileInondée(Grille g) {
        Collection<Tuiles> collecTuilesIn = new ArrayList();
        for (Tuiles t : g.getTuiles()) {
            if (t.getEtat() == Inondee) {
                collecTuilesIn.add(t);
            }        
        }
        return collecTuilesIn;
    }*/
    
}

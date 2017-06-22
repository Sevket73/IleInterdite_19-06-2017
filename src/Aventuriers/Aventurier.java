/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aventuriers;

import Cartes.CartesTirage;
import Grille.Coordonnee;
import Grille.EtatEnum;
import Grille.Grille;
import Grille.Tuile;
import static Grille.EtatEnum.Assechee;
import static Grille.EtatEnum.Inondee;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import Modele.CouleursEnum;

/**
 *
 * @author chaulaic
 */
public class Aventurier {
    protected String nom;
    protected Boolean vivant;
    protected int nbAction;
    protected CouleursEnum couleur;
    protected ArrayList<CartesTirage> cartesEnMain;
    protected Tuile positionCourante;
    
    
    public Aventurier(String nom, Boolean vivant, int nbAction, CouleursEnum couleur) {
        this.nom = nom;
        this.vivant = vivant;
        this.nbAction = nbAction;
        this.couleur = couleur;
        this.cartesEnMain = new ArrayList<>();
        this.positionCourante = new Tuile(null, new Coordonnee(0,0),null);
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
    public CouleursEnum getCouleur() {
        return couleur;
    }

    /**
     * @return the cartesEnMain
     */
    public ArrayList<CartesTirage> getCartesEnMain() {
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
    private void setCouleur(CouleursEnum couleur) {
        this.couleur = couleur;
    }

    /**
     * @param cartesEnMain the cartesEnMain to set
     */
    private void setCartesEnMain(ArrayList<CartesTirage> cartesEnMain) {
        this.cartesEnMain = cartesEnMain;
    }

    public void addCarteEnMain(CartesTirage c){
        this.cartesEnMain.add(c);
    }
    
    public void enleverCarte(CartesTirage c) {
        this.cartesEnMain.remove(c);
    }
    
    /**
     * @return the positionCourante
     */
    public Tuile getPositionCourante() {
        return positionCourante;
    }

    /**
     * @param positionCourante the positionCourante to set
     */
    public void setPositionCourante(int c, int l) {
        this.getPositionCourante().getCoordonnée().setColonne(c);
        this.getPositionCourante().getCoordonnée().setLigne(l);
    }
    
    public ArrayList<Tuile> deplacementPossible(Grille g) {
        
        ArrayList<Tuile> tuilesAdj = new ArrayList<>();
        ArrayList<Tuile> tuilesAdjBis = new ArrayList<>();
        tuilesAdj = g.getTuilesAdjacentes(positionCourante);

        for (Tuile t : tuilesAdj) {
            if (t.getEtat() == EtatEnum.Coulee ) {
                tuilesAdjBis.add(t);
            }
        }
        tuilesAdj.removeAll(tuilesAdjBis);

        return tuilesAdj;
        }

    public void deplacement(Grille g) {
        ArrayList<Tuile> tuilesAdj = new ArrayList();
        tuilesAdj = this.deplacementPossible(g);
        System.out.println("Où souhaitez-vous aller ?");

        for (Tuile t : tuilesAdj){
            if (t != null)
                System.out.println(t.getNom());   
        }
        Scanner repDep = new Scanner(System.in);
        String dep;
        dep = repDep.nextLine();
        for (Tuile t : tuilesAdj) {
            if (dep.equals(t.getNom())) {
                this.seDeplacer(t);
            } else {
                continue;
            }
        }
    }
    
    public void seDeplacer(Tuile t) {
        this.getPositionCourante().removePossedeAventurier(this);
        this.setPositionCourante(t.getCoordonnée().getColonne(), t.getCoordonnée().getLigne());
        System.out.println("Vous êtes maintenant sur la tuile :" + t.getNom());
        t.addPossedeAventurier(this);
        
    }
                
    public ArrayList<Tuile> tuilesAssechables(Grille g){

        ArrayList<Tuile> tuilesAdj = new ArrayList<>();
        ArrayList<Tuile> tuilesPasAssechables = new ArrayList<>();
        tuilesAdj = g.getTuilesAdjacentes(positionCourante);
        tuilesAdj.add(g.getTuiles(positionCourante.getCoordonnée().getLigne()*6 + positionCourante.getCoordonnée().getColonne()));
        for (Tuile t : tuilesAdj) {
            if (t.getEtat() != EtatEnum.Inondee) {
                tuilesPasAssechables.add(t);
            } 
        }
        
        tuilesAdj.removeAll(tuilesPasAssechables);
        return tuilesAdj;
        
    }
    
    public void assechement(Grille g){ 
        ArrayList<Tuile> tuilesAssechables = new ArrayList<>();
        tuilesAssechables = this.tuilesAssechables(g);
        if (tuilesAssechables.isEmpty()) {
            System.out.println("Il n'y a aucune tuile à assecher !");
                    
        } else {
            System.out.println("Quelle tuile souhaitez vous assecher ?");
            for (Tuile t : tuilesAssechables) {
                System.out.println(t.getNom());
            }
            Scanner repAss = new Scanner(System.in);
            String ass;
            ass = repAss.nextLine();
            for (Tuile t : tuilesAssechables) {
                if (ass.equals(t.getNom())) {
                    this.assecher(t);
                } else {
                    continue;
                }
            }
        }
    }
    
    public void assecher(Tuile t) {
        t.changerEtat(EtatEnum.Assechee);
        System.out.println("La tuile " + t.getNom() + " est maintenant assechee!");
    }
            
    

    

}

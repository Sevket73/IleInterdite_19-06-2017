/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aventuriers;

import Cartes.CartesTresors;
import Grille.CoorD;
import Grille.Etat;
import Grille.Grille;
import Grille.Tuiles;
import static Grille.Etat.Assechee;
import static Grille.Etat.Inondee;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import Modele.Couleur;

/**
 *
 * @author chaulaic
 */
public class Aventurier {
    protected String nom;
    protected Boolean vivant;
    protected int nbAction;
    protected Couleur couleur;
    protected ArrayList<CartesTresors> cartesEnMain;
    protected Tuiles positionCourante;
    
    
    public Aventurier(String nom, Boolean vivant, int nbAction, Couleur couleur) {
        this.nom = nom;
        this.vivant = vivant;
        this.nbAction = nbAction;
        this.couleur = couleur;
        this.cartesEnMain = new ArrayList<>();
        this.positionCourante = new Tuiles(null, new CoorD(0,0));
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
    public Couleur getCouleur() {
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
    private void setCouleur(Couleur couleur) {
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
    public void setPositionCourante(int c, int l) {
        this.getPositionCourante().getCoordonnée().setColonne(c);
        this.getPositionCourante().getCoordonnée().setLigne(l);
    }
    
    public ArrayList<Tuiles> deplacementPossible(Grille g) {
        
        ArrayList<Tuiles> tuilesAdj = new ArrayList<>();
        tuilesAdj = g.getTuilesAdjacentes(positionCourante);

        return tuilesAdj;
    }
    
    public void deplacement(Grille g) {
        ArrayList<Tuiles> tuilesAdj = new ArrayList();
        tuilesAdj= this.deplacementPossible(g);
        System.out.println("Où souhaitez-vous aller ?");
        for (Tuiles t : tuilesAdj){
            System.out.println(t.getNom());   
        }
        Scanner repDep = new Scanner(System.in);
        String dep;
        dep = repDep.nextLine();
        for (Tuiles t : tuilesAdj ) {
            if (t.getNom() == dep) {
                this.seDeplacer(t);
            } else {
                continue;
            }
        }
    }    
        
        
        
        
        
        /*System.out.println("Où souhaitez-vous aller? (haut/bas/gauche/droite)");
        String direction;
        Scanner repDir = new Scanner(System.in);
        direction = repDir.nextLine();
        int c;
        int l;
        switch (direction){
            case "haut":
                
                c = this.getPositionCourante().getCoordonnée().getColonne();
                l = this.getPositionCourante().getCoordonnée().getLigne()-1;
                
                if (g.getTuiles(l*6+c).getEtat() == Etat.coulee) {
                    System.out.println("Vous ne pouvez pas allez sur la tuile " + g.getNomTuiles(l, c) + " elle est coulee !");
                } else {
                    this.setPositionCourante(c,l);
                    System.out.println("Vous êtes maintenant sur la tuile : " + g.getNomTuiles(l,c));
                }
                break ; 
            case "bas":
                c = this.getPositionCourante().getCoordonnée().getColonne();
                l = this.getPositionCourante().getCoordonnée().getLigne()+1;
                
                if (g.getTuiles(l*6+c).getEtat() == Etat.coulee) {
                    System.out.println("Vous ne pouvez pas allez sur la tuile " + g.getNomTuiles(l, c) + " elle est coulee !");
                } else {
                    this.setPositionCourante(c,l);
                    System.out.println("Vous êtes maintenant sur la tuile : " + g.getNomTuiles(l,c));
                }
                break ;
            case"gauche":
                c = this.getPositionCourante().getCoordonnée().getColonne()-1;
                l = this.getPositionCourante().getCoordonnée().getLigne();
                
                if (g.getTuiles(l*6+c).getEtat() == Etat.coulee) {
                    System.out.println("Vous ne pouvez pas allez sur la tuile " + g.getNomTuiles(l, c) + " elle est coulee !");
                } else {
                    this.setPositionCourante(c,l);
                    System.out.println("Vous êtes maintenant sur la tuile : " + g.getNomTuiles(l,c));
                }
                break ;
                
            case "droite":
                c = this.getPositionCourante().getCoordonnée().getColonne()+1;
                l = this.getPositionCourante().getCoordonnée().getLigne();
                
                if (g.getTuiles(l*6+c).getEtat() == Etat.coulee) {
                    System.out.println("Vous ne pouvez pas allez sur la tuile " + g.getNomTuiles(l, c) + " elle est coulee !");
                } else {
                    this.setPositionCourante(c,l);
                    System.out.println("Vous êtes maintenant sur la tuile : " + g.getNomTuiles(l,c));
                }
                break ;*/
    
    public void seDeplacer(Tuiles t) {
        this.setPositionCourante(t.getCoordonnée().getColonne(), t.getCoordonnée().getLigne());
    }
                
        
    
    public void assechement(Grille g){

                
        System.out.println("Quelle tuile voulez-vous assecher? (haut/bas/gauche/droite/centre)");
        String direction;
        Scanner repDir = new Scanner(System.in);
        direction= repDir.nextLine();
        int c;
        int l;
        
        switch (direction){
            case "haut":
                c =this.getPositionCourante().getCoordonnée().getColonne();
                l =this.getPositionCourante().getCoordonnée().getLigne()-1;
                if (g.getTuiles(l*6+c).getEtat() == Inondee) {
                    g.getTuiles(l*6+c).changerEtat(Assechee);
                    System.out.println("La tuile " + g.getNomTuiles(this.getPositionCourante().getCoordonnée().getLigne(),this.getPositionCourante().getCoordonnée().getColonne()) + " est maintenant assecher!");
                } else {
                    System.out.println("Cette tuile est " + g.getTuiles(l*6+c).getEtat().toString() + ", vous ne pouvez pas l'assecher !");
                }
                break ; 
            case "bas":
                c =this.getPositionCourante().getCoordonnée().getColonne();
                l =this.getPositionCourante().getCoordonnée().getLigne()+1;
                if (g.getTuiles(l*6+c).getEtat() == Inondee) {
                    g.getTuiles(l*6+c).changerEtat(Assechee); 
                    System.out.println("La tuile " + g.getNomTuiles(this.getPositionCourante().getCoordonnée().getLigne(),this.getPositionCourante().getCoordonnée().getColonne()) + " est maintenant assecher!");
                } else {
                    System.out.println("Cette tuile est " + g.getTuiles(l*6+c).getEtat() + ", vous ne pouvez pas l'assecher !");
                }
                
                
                break;
            case"gauche":
                c =this.getPositionCourante().getCoordonnée().getColonne()-1;
                l =this.getPositionCourante().getCoordonnée().getLigne();
                if (g.getTuiles(l*6+c).getEtat() == Inondee) {
                    g.getTuiles(l*6+c).changerEtat(Assechee);
                    System.out.println("La tuile " + g.getNomTuiles(this.getPositionCourante().getCoordonnée().getLigne(),this.getPositionCourante().getCoordonnée().getColonne()) + " est maintenant assecher!");
                } else {
                    System.out.println("Cette tuile est " + g.getTuiles(l*6+c).getEtat() + ", vous ne pouvez pas l'assecher !");
                }

                break;
            case "droite":
                c =this.getPositionCourante().getCoordonnée().getColonne()+1;
                l =this.getPositionCourante().getCoordonnée().getLigne();
                if (g.getTuiles(l*6+c).getEtat() == Inondee) {
                    g.getTuiles(l*6+c).changerEtat(Assechee); 
                    System.out.println("La tuile " + g.getNomTuiles(this.getPositionCourante().getCoordonnée().getLigne(),this.getPositionCourante().getCoordonnée().getColonne()) + " est maintenant assecher!");
                } else {
                    System.out.println("Cette tuile est " + g.getTuiles(l*6+c).getEtat() + ", vous ne pouvez pas l'assecher !");
                }

                break;
            case "centre":
               c =this.getPositionCourante().getCoordonnée().getColonne();
                l =this.getPositionCourante().getCoordonnée().getLigne();
                if (g.getTuiles(l*6+c).getEtat() == Inondee) {
                    g.getTuiles(l*6+c).changerEtat(Assechee); 
                    System.out.println("La tuile " + g.getNomTuiles(this.getPositionCourante().getCoordonnée().getLigne(),this.getPositionCourante().getCoordonnée().getColonne()) + " est maintenant assecher!");
                } else {
                    System.out.println("Cette tuile est " + g.getTuiles(l*6+c).getEtat() + ", vous ne pouvez pas l'assecher !");
                }
                break; 
        }
            
    }
    public ArrayList<Tuiles> getTuilesDiag(Grille g,Tuiles positionCourante){
        ArrayList<Tuiles>tuilesDiag = new ArrayList();
        int l = positionCourante.getCoordonnée().getLigne();
        int c = positionCourante.getCoordonnée().getColonne();
        tuilesDiag.add(g.getTuiles((l-1)*6+c-1));
        tuilesDiag.add(g.getTuiles((l-1)*6+c+1));
        tuilesDiag.add(g.getTuiles((l+1)*6+c-1));
        tuilesDiag.add(g.getTuiles((l+1)*6+c+1));
        return tuilesDiag;
    }
    

}

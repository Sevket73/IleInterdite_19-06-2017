/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aventuriers;

import Cartes.CartesTirage;
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
    protected ArrayList<CartesTirage> cartesEnMain;
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
    private void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }

    /**
     * @param cartesEnMain the cartesEnMain to set
     */
    private void setCartesEnMain(ArrayList<CartesTirage> cartesEnMain) {
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
        ArrayList<Tuiles> tuilesAdjBis = new ArrayList<>();
        tuilesAdj = g.getTuilesAdjacentes(positionCourante);

        for (Tuiles t : tuilesAdj) {
            if (t.getEtat() == Etat.coulee ) {
                tuilesAdjBis.add(t);
            }
        }
        tuilesAdj.removeAll(tuilesAdjBis);

        return tuilesAdj;
        }

    public void deplacement(Grille g) {
        ArrayList<Tuiles> tuilesAdj = new ArrayList();
        tuilesAdj= this.deplacementPossible(g);
        System.out.println("Où souhaitez-vous aller ?");
        for (Tuiles t : tuilesAdj){
            if (t != null)
                System.out.println(t.getNom());   
        }
        Scanner repDep = new Scanner(System.in);
        String dep;
        dep = repDep.nextLine();
        for (Tuiles t : tuilesAdj) {
            if (dep.equals(t.getNom())) {
                this.seDeplacer(t);
            } else {
                continue;
            }
        }
    }
    
    public void seDeplacer(Tuiles t) {
        this.setPositionCourante(t.getCoordonnée().getColonne(), t.getCoordonnée().getLigne());
        System.out.println("Vous êtes maintenant sur la tuile :" + t.getNom());
    }
                
    public ArrayList<Tuiles> tuilesAssechables(Grille g){

        ArrayList<Tuiles> tuilesAdj = new ArrayList<>();
        ArrayList<Tuiles> tuilesAssechables = new ArrayList<>();
        tuilesAdj = g.getTuilesAdjacentes(positionCourante);
        tuilesAdj.add(g.getTuiles(positionCourante.getCoordonnée().getLigne()*6 + positionCourante.getCoordonnée().getColonne()));
        for (Tuiles t : tuilesAdj) {
            if (t.getEtat() != Etat.Inondee) {
                tuilesAssechables.add(t);
            } 
        }
        
        tuilesAdj.removeAll(tuilesAssechables);
        return tuilesAdj;
        
    }
    
    public void assechement(Grille g){ 
        ArrayList<Tuiles> tuilesAssechables = new ArrayList<>();
        tuilesAssechables = this.tuilesAssechables(g);
        if (tuilesAssechables.isEmpty()) {
            System.out.println("Il n'y a aucune tuile à assecher !");
                    
        } else {
            System.out.println("Quelle tuile souhaitez vous assecher ?");
            for (Tuiles t : tuilesAssechables) {
                System.out.println(t.getNom());
            }
            Scanner repAss = new Scanner(System.in);
            String ass;
            ass = repAss.nextLine();
            for (Tuiles t : tuilesAssechables) {
                if (ass.equals(t.getNom())) {
                    this.assecher(t);
                } else {
                    continue;
                }
            }
        }
        
        
 
    }
    
    public void assecher(Tuiles t) {
        t.changerEtat(Etat.Assechee);
        System.out.println("La tuile " + t.getNom() + " est maintenant assechee!");
    }
            
    

    

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Aventuriers;

import Cartes.CarteSpecial;
//import comment.CarteHelicoptere;
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
    protected int nombreActions;

    public Aventurier(String nom, Boolean vivant, int nbAction, CouleursEnum couleur) {
        this.nom = nom;
        this.vivant = vivant;
        this.nbAction = nbAction;
        this.couleur = couleur;
        this.cartesEnMain = new ArrayList<>();
        this.positionCourante = new Tuile(null, new Coordonnee(0, 0), null);
    }
    
    public void resetActions() { //Le nombre d'actions restantes du joueur est remis à 0
        nombreActions = 3;
    }
    public int getNombreActions()
    {
        return nombreActions;
    }
    public void actionEffectuer(){ //On décrémente le nombre d'action que le joueur peut encore effectuer
        nombreActions--;
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

    public void addCarteEnMain(CartesTirage c) { // on ajoute une CartesTirage à la main du joueur
        this.cartesEnMain.add(c);
    }

    public void enleverCarte(CartesTirage c) {// on enleve une CartesTirage à la main du joueur quand il l'a utiliser
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
    public void setPositionCourante(int c, int l,Grille g) {//on définit la position courante du joueur et le retire de sa precedente position courante
        this.positionCourante.removePossedeAventurier(this);
        this.positionCourante.setNom(g.getTuiles(l*6+c).getNom());
        this.getPositionCourante().getCoordonnée().setColonne(c);
        this.getPositionCourante().getCoordonnée().setLigne(l);
        this.positionCourante.addPossedeAventurier(this);
        
    }
    
    public void setPositionCourante(int c, int l) {
        this.positionCourante.removePossedeAventurier(this);
        this.getPositionCourante().getCoordonnée().setColonne(c);
        this.getPositionCourante().getCoordonnée().setLigne(l);
        this.positionCourante.addPossedeAventurier(this);
        
    }


    public ArrayList<Tuile> deplacementPossible(Grille g) {//renvoie une collection de Tuiles où le joueur peut se déplacer

        ArrayList<Tuile> tuilesAdj = new ArrayList<>();
        ArrayList<Tuile> tuilesAdjBis = new ArrayList<>();
        tuilesAdj = g.getTuilesAdjacentes(positionCourante);

        for (Tuile t : tuilesAdj) {
            if (t.getEtat() == EtatEnum.Coulee) {
                tuilesAdjBis.add(t);
            }
        }
        tuilesAdj.removeAll(tuilesAdjBis);

        return tuilesAdj;
    }

    public void deplacement(Grille g) {//on demande au joueur où il veut aller et on l'y déplace si possible
        ArrayList<Tuile> tuilesAdj = new ArrayList();
        tuilesAdj = this.deplacementPossible(g);

        System.out.println("Où souhaitez-vous aller ?");

        for (Tuile t : tuilesAdj) {
            if (t.getNom() != null) {
                System.out.print(t.getNom() + ' ');
            }
        }
        System.out.println();
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

    public void seDeplacer(Tuile t) { //on déplace le joueur

        this.setPositionCourante(t.getCoordonnée().getColonne(), t.getCoordonnée().getLigne());
        System.out.println("Vous êtes maintenant sur la tuile :" + t.getNom());


    }

    public ArrayList<Tuile> tuilesAssechables(Grille g) {//renvoie une collection de Tuile qui peuvent être assechée par le joueur

        ArrayList<Tuile> tuilesAdj = new ArrayList<>();
        ArrayList<Tuile> tuilesPasAssechables = new ArrayList<>();

        tuilesAdj = g.getTuilesAdjacentes(positionCourante);
        tuilesAdj.add(g.getTuiles(positionCourante.getCoordonnée().getLigne() * 6 + positionCourante.getCoordonnée().getColonne()));
        for (Tuile t : tuilesAdj) {
            if (t.getEtat() != EtatEnum.Inondee) {
                tuilesPasAssechables.add(t);
            }
        }

        tuilesAdj.removeAll(tuilesPasAssechables);
        return tuilesAdj;

    }

    public void assechement(Grille g) { //On demande au Joueur quelle tuile il souhaite assécher, s'il y en a, et on l'asseche si possible
        ArrayList<Tuile> tuilesAssechables = new ArrayList<>();
        tuilesAssechables = this.tuilesAssechables(g);
        if (tuilesAssechables.isEmpty()) {
            System.out.println("Il n'y a aucune tuile à assecher !");

        } else {
            System.out.println("Quelle tuile souhaitez vous assecher ?");
            for (Tuile t : tuilesAssechables) {
                System.out.print(t.getNom() + ' ');
            }
            System.out.println();
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

    public void assecher(Tuile t) {//on asseche la tuile t
        t.changerEtat(EtatEnum.Assechee);
        System.out.println("La tuile " + t.getNom() + " est maintenant assechee!");
    }

    public void donnerCarteTresor(CartesTirage c, Aventurier j) {//methode permettant de donner une carte tresor à un coéquipier présent sur la même tuile 

        if (this.getPositionCourante() == j.getPositionCourante()) {
            j.addCarteEnMain(c);
            this.enleverCarte(c);
        } else {
            System.out.println(" vous n'etes pas sur la meme tuile");
        }
    }

    public CartesTirage getCarte(String nom) { //On renvoie une CartesTirage selon son nom
        CartesTirage c1 = null;
        for (CartesTirage c : this.getCartesEnMain()) {
            if (c.getNom().equals(nom)  /*&& c instanceof CarteSpecial*/) {
                //System.out.println("On a trouvé la carte");
                c1 = c;
                break;
                //c1 = new CarteHelicoptere();
            } else {
                c1 = null;
            }
        }
        return (CartesTirage)c1;
    }

}

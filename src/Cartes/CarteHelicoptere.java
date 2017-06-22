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
public class CarteHelicoptere extends CartesTirage {

    public CarteHelicoptere() {
        super();
        setNom("helicoptere");

    }

    @Override
    public void deplacer1Joueur(Aventurier j1, String tuile, Grille g) {
        System.out.println("On rentre ");
        Tuile t1 = g.getTuiles(tuile);
        j1.setPositionCourante(t1.getCoordonnée().getColonne(), t1.getCoordonnée().getLigne());
    }

    @Override
    public void deplacer2Joueurs(Aventurier j1, Aventurier j2, String tuile, Grille g) {
        System.out.println("On rentre ");
        Tuile t1 = g.getTuiles(tuile);
        if ((j1.getPositionCourante() == j2.getPositionCourante())) {
            j1.setPositionCourante(t1.getCoordonnée().getColonne(), t1.getCoordonnée().getLigne());
            j2.setPositionCourante(t1.getCoordonnée().getColonne(), t1.getCoordonnée().getLigne());
        }
    }

    @Override
    public void deplacer3Joueurs(Aventurier j1, Aventurier j2, Aventurier j3, String tuile, Grille g) {
        System.out.println("On rentre ");
        Tuile t1 = g.getTuiles(tuile);
        if ((j1.getPositionCourante() == j2.getPositionCourante()) && (j2.getPositionCourante() == j3.getPositionCourante())) {
            j1.setPositionCourante(t1.getCoordonnée().getColonne(), t1.getCoordonnée().getLigne());
            j2.setPositionCourante(t1.getCoordonnée().getColonne(), t1.getCoordonnée().getLigne());
            j3.setPositionCourante(t1.getCoordonnée().getColonne(), t1.getCoordonnée().getLigne());
        }
    }

    @Override
    public void deplacer4Joueurs(Aventurier j1, Aventurier j2, Aventurier j3, Aventurier j4, String tuile, Grille g) {
        System.out.println("On rentre ");
        Tuile t1 = g.getTuiles(tuile);
        if ((j1.getPositionCourante() == j2.getPositionCourante()) && (j2.getPositionCourante() == j3.getPositionCourante()) && (j3.getPositionCourante() == j4.getPositionCourante())) {
            j1.setPositionCourante(t1.getCoordonnée().getColonne(), t1.getCoordonnée().getLigne());
            j2.setPositionCourante(t1.getCoordonnée().getColonne(), t1.getCoordonnée().getLigne());
            j3.setPositionCourante(t1.getCoordonnée().getColonne(), t1.getCoordonnée().getLigne());
            j4.setPositionCourante(t1.getCoordonnée().getColonne(), t1.getCoordonnée().getLigne());
        }

    }

}

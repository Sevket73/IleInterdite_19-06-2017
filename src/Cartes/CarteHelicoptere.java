/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cartes;

import Aventuriers.Aventurier;
import Grille.Grille;
import Grille.Tuiles;

/**
 *
 * @author chaulaic
 */
public class CarteHelicoptere extends CartesTirage {

    public CarteHelicoptere() {
        super(); //supercoptère
        setNom("helicoptere");
        
    }

    
    public void deplacer1Joueur(Aventurier j1,String tuile,Grille g){
            Tuiles t1 = g.getTuiles(tuile);
        j1.setPositionCourante(t1.getCoordonnée().getColonne(),t1.getCoordonnée().getLigne());
    }
    public void deplacer2Joueurs(Aventurier j1,Aventurier j2,String tuile,Grille g){
        Tuiles t1 = g.getTuiles(tuile);
        j1.setPositionCourante(t1.getCoordonnée().getColonne(),t1.getCoordonnée().getLigne());
        j2.setPositionCourante(t1.getCoordonnée().getColonne(),t1.getCoordonnée().getLigne());
    }
    public void deplacer3Joueurs(Aventurier j1,Aventurier j2,Aventurier j3,String tuile,Grille g){
        Tuiles t1 = g.getTuiles(tuile);
        j1.setPositionCourante(t1.getCoordonnée().getColonne(),t1.getCoordonnée().getLigne());
        j2.setPositionCourante(t1.getCoordonnée().getColonne(),t1.getCoordonnée().getLigne());
        j3.setPositionCourante(t1.getCoordonnée().getColonne(),t1.getCoordonnée().getLigne());
    }
    
}

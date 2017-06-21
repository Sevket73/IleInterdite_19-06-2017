/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grille;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 *
 * @author chaulaic
 */
public class Grille {

    private HashMap<Integer, Tuiles> hmGrille = new HashMap();

    public Grille() {
        hmGrille = new HashMap<Integer, Tuiles>();

    }

    public void addTuiles(Integer i, Tuiles t) {
        getHmGrille().put(i, t);
    }

    public Tuiles getTuiles(int k) {
        return hmGrille.get(k);
    }

    public Tuiles getTuiles(int lig, int col) {
        return hmGrille.get(lig * 6 + col);
    }

    /**
     * @return the aze
     */
    public HashMap<Integer, Tuiles> getHmGrille() {
        return hmGrille;
    }

    /**
     * @param aze the aze to set
     */
    public void setAze(HashMap<Integer, Tuiles> aze) {
        aze = new HashMap<Integer, Tuiles>();
        this.hmGrille = aze;
    }

    /**
     * @return the tuiles
     */
    public String getNomTuiles(int lig, int col) {
        return this.hmGrille.get(lig * 6 + col).getNom();
    }

    public String getNomTuiles(int k) {
        return this.hmGrille.get(k).getNom();
    }

    public ArrayList<Tuiles> getTuilesAdjacentes(Tuiles positionCourante) {

        ArrayList<Tuiles> tuilesAdjacentes = new ArrayList<>();

        int c;
        int l;

        //Tuile en-dessus
        c = positionCourante.getCoordonnée().getColonne();
        l = positionCourante.getCoordonnée().getLigne() - 1;
        int x = l * 6 + c;
        if (x <= 1 || x == 6 || x == 4 || x == 11) {
            System.out.println("NEGATIF HAUT");
        } else {
            tuilesAdjacentes.add(this.getTuiles(x));
        }

        //tuile en-dessous
        l = positionCourante.getCoordonnée().getLigne() + 1;
        x = l * 6 + c;
        if (x >= 34 || x == 31 || x == 24 || x == 29) {
            System.out.println("NEGATIF BAS");
        } else {
            tuilesAdjacentes.add(this.getTuiles(x));
        }

        //tuile à gauche
        c = positionCourante.getCoordonnée().getColonne() - 1;
        l = positionCourante.getCoordonnée().getLigne();
        x = l * 6 + c;
        if (x <= 1 || x == 6 || x == 24 || x == 31 || positionCourante.getCoordonnée().getColonne() - 1 == -1) {
            System.out.println("NEGATIF GAUCHE");
        } else {
            tuilesAdjacentes.add(this.getTuiles(x));
        }

        //tuile à droite
        c = positionCourante.getCoordonnée().getColonne() + 1;
        x = l * 6 + c;
        if (x >= 34 || x == 29 || x == 4 || x == 11 || positionCourante.getCoordonnée().getColonne() + 1 == 6) {
            System.out.println("NEGATIF DROITE");
        } else {
            tuilesAdjacentes.add(this.getTuiles(x));
        }
        /*for (Tuiles t : tuilesAdjacentes) {
            System.out.println(t.getNom());
        }*/
        return tuilesAdjacentes;

    }

    public Tuiles getTuiles(String nomTuiles) {
        for (Tuiles t : hmGrille.values()) {
            if (t.getNom() == nomTuiles) {
                return t;
            }
        }
        return null;
    }


    /*
    private Tuiles getTuilesAdjacentes(ArrayList<Tuiles> tuilesAdj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     */
}

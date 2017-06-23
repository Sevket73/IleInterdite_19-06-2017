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
    private HashMap<Integer,Tuile> hmGrille = new HashMap();

    public Grille() {

        hmGrille = new HashMap<Integer, Tuile>();
    }


    public void addTuiles(Integer i, Tuile t) {//ajout d'une tuile à la HashMap hmGrille
        getHmGrille().put(i, t);
    }


    
    public Tuile getTuiles(int lig, int col) {//on renvoie une tuile selon sa ligne et sa colonne
        return hmGrille.get(lig * 6 + col);
    }
    
    public Tuile getTuiles(int k ){//on renvoie une tuile selon sa clé dans la hashMap
        return hmGrille.get(k);
    }
    
    public HashMap<Integer,Tuile> getHmGrille() {
        return hmGrille;
    }

    
    public void setHmGrille(HashMap<Integer,Tuile> HmGrille) {
       HmGrille = new HashMap<Integer,Tuile>();
       this.hmGrille = HmGrille;
    }

    /**
     * @return the tuiles
     */
    public String getNomTuiles(int lig, int col) {//on renvoie le nom d'une tuile selon sa ligne et sa colonne
        return this.hmGrille.get(lig * 6 + col).getNom();
    }

    public String getNomTuiles(int k) {//on renvoie le nom d'une tuile selon sa clé dans la hashmap
        return this.hmGrille.get(k).getNom();
    }

    
    public ArrayList<Tuile> getTuilesAdjacentes(Tuile positionCourante) {//on renvoie une collection de Tuile adjacente à la position courante d'un joueur
        
        ArrayList<Tuile> tuilesAdjacentes = new ArrayList<>();
        
        int c;
        int l;

        //Tuile en-dessus
        c = positionCourante.getCoordonnée().getColonne();
        l = positionCourante.getCoordonnée().getLigne() - 1;
        int x = l * 6 + c;
        if (x <= 1 || x == 6 || x == 4 || x == 11) {
         //   System.out.println("NEGATIF HAUT");
        } else {
            tuilesAdjacentes.add(this.getTuiles(x));
        }

        //tuile en-dessous
        l = positionCourante.getCoordonnée().getLigne() + 1;
        x = l * 6 + c;
        if (x >= 34 || x == 31 || x == 24 || x == 29) {
         //   System.out.println("NEGATIF BAS");
        } else {
            tuilesAdjacentes.add(this.getTuiles(x));
        }

        //tuile à gauche
        c = positionCourante.getCoordonnée().getColonne() - 1;
        l = positionCourante.getCoordonnée().getLigne();
        x = l * 6 + c;
        if (x <= 1 || x == 6 || x == 24 || x == 31 || positionCourante.getCoordonnée().getColonne() - 1 == -1) {
         //   System.out.println("NEGATIF GAUCHE");
        } else {
            tuilesAdjacentes.add(this.getTuiles(x));
        }

        //tuile à droite
        c = positionCourante.getCoordonnée().getColonne() + 1;
        x = l * 6 + c;
        if (x >= 34 || x == 29 || x == 4 || x == 11 || positionCourante.getCoordonnée().getColonne() + 1 == 6) {
         //   System.out.println("NEGATIF DROITE");
        } else {
            tuilesAdjacentes.add(this.getTuiles(x));
        }
        /*for (Tuiles t : tuilesAdjacentes) {
            System.out.println(t.getNom());
        }*/
        return tuilesAdjacentes;

    }


    public Tuile getTuiles(String nomTuiles) {//on renvoit une tuile selon son nom
        Tuile t1 = null;
        for (Tuile t : hmGrille.values()) {
            if ((nomTuiles.equals(t.getNom()))) {
                t1 = t;
                break;
            }
        }
        return t1;
    }
    
}

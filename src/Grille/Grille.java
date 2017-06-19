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
    private HashMap<Integer,Tuiles> aze = new HashMap();

    
    public void Grille() {
        aze = new HashMap<Integer,Tuiles>();

    }
    
    public void addTuiles(Integer i,Tuiles t) {
        getAze().put(i,t);
    }
    
    public Tuiles getTuiles(int k ){
        return aze.get(k);
    }
    public HashMap getTuiles(){
        return aze;
    }
    
    public Tuiles getTuiles(int l,int c) {
        return aze.get(l*6+c);
    }

    /**
     * @return the aze
     */
    public HashMap<Integer,Tuiles> getAze() {
        return aze;
    }

    /**
     * @param aze the aze to set
     */
    public void setAze(HashMap<Integer,Tuiles> aze) {
       aze = new HashMap<Integer,Tuiles>();
        this.aze = aze;
    }

    /**
     * @return the tuiles
     */
    public String getNomTuiles(int l,int c){
        return this.aze.get(l*6+c).getNom();
    }
    
    public String getNomTuiles(int k){
        return this.aze.get(k).getNom();
    }
    
    public ArrayList<Tuiles> getTuilesAdjacentes(Tuiles positionCourante) {
        
        ArrayList<Tuiles> tuilesAdjacentes = new ArrayList<>();
        
        int c;
        int l;
        
        //Tuile en-dessus
        c = positionCourante.getCoordonnée().getColonne();
        l = positionCourante.getCoordonnée().getLigne()-1;
        
        if (this.getTuiles(l*6+c).getEtat() == Etat.Assechee || this.getTuiles(l*6+c).getEtat() == Etat.Inondee) {
            tuilesAdjacentes.add(this.getTuiles(l*6+c));
        } 
        
        //tuile en-dessous
        c = positionCourante.getCoordonnée().getColonne();
        l = positionCourante.getCoordonnée().getLigne()+1;
        
        if (this.getTuiles(l*6+c).getEtat() == Etat.Assechee || this.getTuiles(l*6+c).getEtat() == Etat.Inondee) {
            tuilesAdjacentes.add(this.getTuiles(l*6+c));
        }
        
        //tuile à gauche
        c = positionCourante.getCoordonnée().getColonne()-1;
        l = positionCourante.getCoordonnée().getLigne();
        
        if (this.getTuiles(l*6+c).getEtat() == Etat.Assechee || this.getTuiles(l*6+c).getEtat() == Etat.Inondee) {
            tuilesAdjacentes.add(this.getTuiles(l*6+c));
        }
        
        //tuile à droite
        c = positionCourante.getCoordonnée().getColonne()+1;
        l = positionCourante.getCoordonnée().getLigne();
        
        if (this.getTuiles(l*6+c).getEtat() == Etat.Assechee || this.getTuiles(l*6+c).getEtat() == Etat.Inondee) {
            tuilesAdjacentes.add(this.getTuiles(l*6+c));
        }
        
        return tuilesAdjacentes;
    }

    }

    

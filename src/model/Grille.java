/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 *
 * @author chaulaic
 */
public class Grille {
    private HashMap<Integer,Tuiles>aze = new HashMap<Integer,Tuiles>();
    
    public void addTuiles(Integer i,Tuiles t) {
        aze.put(i, t);
    }
    
    public Tuiles getTuiles(int k ){
        return aze.get(k);
    }
}

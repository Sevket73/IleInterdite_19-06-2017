/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cartes;

/**
 *
 * @author chaulaic
 */
public class CarteTresor extends CartesTirage {

       private TresorsEnum typeTresor;
       
    public CarteTresor(String tresor) {
        super(tresor);
        this.setTypeTresor(typeTresor);
    }

    /**
     * @return the typeTresor
     */
    public TresorsEnum getTypeTresor() {
        return typeTresor;
    }

    /**
     * @param typeTresor the typeTresor to set
     */
    public void setTypeTresor(TresorsEnum typeTresor) {
        this.typeTresor = typeTresor;
    }

}

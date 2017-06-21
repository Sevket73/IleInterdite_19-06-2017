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
    private Tresor nomTresor;
    
    

    public CarteTresor(Tresor tresor) {
        super();
        this.nomTresor = tresor;
    }

    /**
     * @return the nomTresor
     */
    public Tresor getNomTresor() {
        return nomTresor;
    }

    /**
     * @param nomTresor the nomTresor to set
     */
    public void setNomTresor(Tresor nomTresor) {
        this.nomTresor = nomTresor;
    }

}

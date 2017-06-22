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


    public CarteTresor(TresorsEnum tresor) {
        super();
        setNom(tresor.toString());
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import Modele.Couleur;
import Grille.*;
import Grille.Tuile;
import Aventuriers.*;
import View.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import Cartes.*;
import Cartes.CarteInondations;
import static Cartes.Tresor.*;
import static Grille.Etat.*;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Stack;

/**
 *
 * @author chaulaic
 */
public class Controleur /*implements Observateur*/ {

    private int niveauEaux;
    private ArrayList<Aventurier> joueurs;
    private Grille grille = new Grille();
    private Stack<CartesTirage> cartesPioche;
    private HashSet<Tresor> tresorsAcquis;
    private Stack<Tuile> listeTuiles;
    private Stack<CartesTirage> defausse;
    private Stack<CarteInondations> cartesInon;
    private Stack<CarteInondations> defausseInon;

    private VueMenu vueMenu;
    private VueRules vueRules;
    private VueGrille vueGrille;
    private VueStatue vueStatue;

    private Observateur observateur;
    private Message messArrayListage = new Message();

    public Controleur(int niveauEaux, Grille g) {
        this.niveauEaux = niveauEaux;
        this.joueurs = new ArrayList<>();
        this.grille = g;
        this.cartesPioche = new Stack<>();
        this.listeTuiles = new Stack();
        this.cartesPioche = new Stack();
        this.tresorsAcquis = new HashSet();
        this.listeTuiles = new Stack();
        this.defausse = new Stack();
        this.cartesInon = new Stack();
        this.defausseInon = new Stack();

        /*
        vueMenu = new VueMenu();
        vueMenu.setObservateur(this);
        
        vueRules = new VueRules();
        vueRules.setObservateur(this);
        
        vueGrille = new VueGrille();
        vueGrille.setObservateur(this);
        
        vueStatue = new VueStatue();
        vueStatue.setObservateur(this);
        
        message.type = TypesMessages.MENU;
//        this.click(message);
        
         */
    }

    private void initJoueurs() {
        ArrayList<String> nomJoueurs = new ArrayList<>();
        nomJoueurs = vueMenu.getJoueur();

        this.joueurs.add(new Aventurier(nomJoueurs.get(1), true, 3, Couleur.Bleu));
        this.joueurs.add(new Aventurier(nomJoueurs.get(2), true, 3, Couleur.Rouge));
        this.joueurs.add(new Aventurier(nomJoueurs.get(3), true, 3, Couleur.Noir));
        this.joueurs.add(new Aventurier(nomJoueurs.get(0), true, 3, Couleur.Jaune));
    }

    /*private String listeTuile[]= {null,null,"LePontDesAbimes","LaPorteDeBronze",null,null,
                          null,"LaCaverneDesOmbres","LaPorteDeFer","LaPorteDOr","LesFalaisesDeLOubli",null,
                          "LePalaisDeCorail","LaPorteDArgent","LesDunesDeLIllusion","Heliport","LaPorteDeCuivre","LeJardinDesHurlements",
                          "LaForetPourpre","LeLagonPerdu","LeMaraisBrumeux","Observatoire","LeRocherFantome","LaCaverneDuBrasier",
                          null,"LeTempleDuSoleil","LeTempleDeLaLune","LePalaisDesMarees","LeValDuCrepuscule",null,
                          null,null,"LaTourDuGuet","LeJardinDesMurmures",null,null};*/
    public void creerGrille(Grille g, Aventurier j1, Aventurier j2, Aventurier j3, Aventurier j4) {
        for (Tuile t : EnumSet.allOf(Tuile.class)) {
            listeTuiles.push(t);
        }

        //Collections.shuffle(listeTuiles);

        for (int l = 0; l <= 5; l++) {
            for (int c = 0; c <= 5; c++) {
                if ((l == 0 && ((c == 0 || c == 1) || c == 4 || c == 5)) || (l == 1 && c == 0) || (l == 1 && c == 5) || ((l == 4 && c == 0) || (l == 4 && c == 5)) || (l == 5 && ((c == 0 || c == 1) || c == 4 || c == 5))) {
                    Tuiles t = new Tuiles(null, new CoorD(c, l), null);
                } else {
                    Tuiles t = new Tuiles(listeTuiles.pop().toString(), new CoorD(c, l), null);
                    t.changerEtat(Assechee);
                    g.addTuiles((l * 6 + c), t);

                }
            }
        }

        g.getTuiles("LaPorteDeBronze").changerCouleur(Couleur.Rouge);
        g.getTuiles("LaPorteDOr").changerCouleur(Couleur.Jaune);
        g.getTuiles("LaPorteDeFer").changerCouleur(Couleur.Noir);
        g.getTuiles("LaPorteDArgent").changerCouleur(Couleur.Orange);
        g.getTuiles("LaPorteDeCuivre").changerCouleur(Couleur.Vert);
        g.getTuiles("Heliport").changerCouleur(Couleur.Bleu);

        g.getTuiles("LePalaisDeCorail").setTresor(Calice_de_l_onde);
        g.getTuiles("LePalaisDesMarees").setTresor(Calice_de_l_onde);
        g.getTuiles("LeJardinDesHurlements").setTresor(Statue_du_Zephyr);
        g.getTuiles("LeJardinDesMurmures").setTresor(Statue_du_Zephyr);
        g.getTuiles("LeTempleDeLaLune").setTresor(Pierre_Sacree);
        g.getTuiles("LeTempleDuSoleil").setTresor(Pierre_Sacree);
        g.getTuiles("LaCaverneDuBrasier").setTresor(Cristal_Ardent);
        g.getTuiles("LaCaverneDesOmbres").setTresor(Cristal_Ardent);

        for (Tuiles t : g.getAze().values()) {
            if (t.getCouleur() == j1.getCouleur()) {
                t.setDepartAventurier(j1);
                t.addPossedeAventurier(j1);
            }
            if (t.getCouleur() == j2.getCouleur()) {
                t.setDepartAventurier(j2);
                t.addPossedeAventurier(j2);
            }
            if (t.getCouleur() == j3.getCouleur()) {
                t.setDepartAventurier(j3);
                t.addPossedeAventurier(j3);
            }
            if (t.getCouleur() == j4.getCouleur()) {
                t.setDepartAventurier(j4);
                t.addPossedeAventurier(j4);
            }
        }

    }

    public void jouer(Aventurier j1, Aventurier j2, Aventurier j3, Aventurier j4, Grille g) {
        String passez;

        this.creerGrille(grille, j1, j2, j3, j4);
        this.creerPiocheTirage();
        this.creerPiocheInon();

        for (CarteInondations c : this.cartesInon) {
            System.out.println(c.getCible().getNom());
        }
        System.out.println("");
        this.initJoueurs(j1, j2, j3, j4);
        this.niveauEaux = 1;
        /* for (Tuiles t : g.getAze().values()) {
            System.out.println(t.getNom());
        }*/
        if (this.verifNbJoueurs()) {
            while (!this.partiePerdue()) {
                while (!this.partieGagnée()) {
                    for (Aventurier j : joueurs) {
                        System.out.println(j.getNom() + " à vous de jouer!");
                        System.out.println("");
                        System.out.println("Vous êtes sur la tuile : " + g.getNomTuiles(j.getPositionCourante().getCoordonnée().getLigne(), j.getPositionCourante().getCoordonnée().getColonne()));
                        System.out.println("Souhaitez-vous passez ? (o/n)");
                        Scanner repPasse = new Scanner(System.in);
                        passez = repPasse.nextLine();

                        if (passez.equals("n")) {
                            for (int k = 1; k < 4; k++) {
                                System.out.println("Action " + k);
                                System.out.println("Que souhaitez-vous faire? (deplacer/assecher)");
                                String action;
                                Scanner repAction = new Scanner(System.in);
                                action = repAction.nextLine();

                                if (action.equals("deplacer")) {
                                    j.deplacement(grille);

                                } else if (action.equals("assecher")) {
                                    j.assechement(grille);
                                }

                                if (k == 3) {
                                    break;
                                } else {
                                    System.out.println("Souhaitez-vous passez ? (o/n)");
                                    repPasse = new Scanner(System.in);
                                    passez = repPasse.nextLine();

                                    if (passez.equals("o")) {
                                        break;
                                    }
                                }
                               
                            }
                            this.donnerCarteTresEtInon(j);

                        } else {
                            this.donnerCarteTresEtInon(j);
                        }
                    }

                }
            }

        } else {
            System.out.println("Il n'y a pas assez de joueurs !");
        }
    }

    private void donnerCarteTresEtInon(Aventurier j) {
        this.piocherCarte(j);
        this.piocherCarte(j);
        for (CartesTirage t : j.getCartesEnMain()) {
            System.out.println(t.getNom());
        }
        System.out.println(niveauEaux);
        for (int i = 0; i < niveauEaux; i++) {
            this.piocherCarteInon();

        }
    }

    /*
    @Override
    public void click(Message message) {

        Grille grille = new Grille();

        switch (message.type) {
            case RULES:
                vueRules.afficher();
                vueMenu.fermer();
                break;
            case MENU:
                vueMenu.afficher();
                vueRules.fermer();
                break;
            case GRID:
                Controleur.this.initJoueurs();
                this.creerGrille(grille,j1,j2,j3,j4);
                grille.getAze();

                vueGrille.afficher();
                vueStatue.afficher();
                vueMenu.fermer();

        }
    }
     */
    private void creerPiocheTirage() {
        for (int i = 0; i < 5; i++) {
            cartesPioche.push(new CarteTresor(Tresor.Statue_du_Zephyr));
            cartesPioche.push(new CarteTresor(Tresor.Calice_de_l_onde));
            cartesPioche.push(new CarteTresor(Tresor.Cristal_Ardent));
            cartesPioche.push(new CarteTresor(Tresor.Pierre_Sacree));
        }
        for (int i = 0; i < 3; i++) {
            cartesPioche.push(new CarteHelicoptere());
        }
        for (int i = 0; i < 2; i++) {
            cartesPioche.push(new CarteSacDeSable());
            cartesPioche.push(new CarteMonteeDesEaux());
        }

        Collections.shuffle(cartesPioche);
    }

    private void creerPiocheInon() {
        for (Tuiles t : grille.getAze().values()) {
            /* int l = grille.getTuiles(i).getCoordonnée().getLigne();
            int c = grille.getTuiles(i).getCoordonnée().getColonne();
            switch(l*6+c){
                case 0:case1:case4:case5:case6:case11:case24:case29:case30:case31:case34:case35 :
                
                break;
                
            }*/
            if (t.getNom() != null) {
                CarteInondations cI = new CarteInondations(t);
                cartesInon.push(cI);
            }

        }
    }

    private void piocherCarteInon() {
        if (cartesInon.empty()) {
            cartesInon.addAll(defausseInon);
            defausseInon.removeAllElements();
            Collections.shuffle(cartesInon);
        }
        //for (CarteInondations c : cartesInon) {
        //    System.out.println(c.getCible().getNom());
        //}
        
      //  System.out.println("Je tire une carte");
        
        
        CarteInondations cI = cartesInon.pop();
        Tuiles t = cI.getCible();
        
        for( CarteInondations c : cartesInon){
            System.out.println(c.getCible().getNom());
        }
             //   System.out.println(t.getNom());

        if (t.getEtat() == Assechee) {
            t.changerEtat(Inondee);
            defausseInon.push(cI);

        } else if (t.getEtat() == Inondee) {
            t.changerEtat(coulee);
            
        }
    }

    private void piocherCarte(Aventurier j) {
        if (cartesPioche.isEmpty()) {
            cartesPioche.addAll(this.defausse);
            defausse.removeAllElements();
        }
        CartesTirage carte = cartesPioche.pop();

        if (carte instanceof CarteMonteeDesEaux) {
            this.monterEau();
            defausse.push(carte);
            this.cartesInon.addAll(this.defausseInon);
            defausseInon.removeAllElements();
            Collections.shuffle(cartesInon);
        } else {
            j.addCarteEnMain(carte);
        }
    }

    private void monterEau() {
        niveauEaux += 1;
    }

    private void initCartes(Aventurier j) {
        for (int i = 0; i < 4; i++) {
            this.piocherCarte(j);
        }
    }

    private void initJoueurs(Aventurier j1, Aventurier j2, Aventurier j3, Aventurier j4) {
        if (j1 != null) {
            this.joueurs.add(j1);
            this.initCartes(j1);
        }
        if (j2 != null) {
            this.joueurs.add(j2);
            this.initCartes(j2);
        }
        if (j3 != null) {
            this.joueurs.add(j3);
            this.initCartes(j3);
        }
        if (j4 != null) {
            this.joueurs.add(j4);
            this.initCartes(j4);
        }
    }

    private boolean verifNbJoueurs() {
        if (this.joueurs.size() < 2) {
            return false;
        } else {
            return true;
        }
    }

    private boolean peutPrendreTresor(Aventurier j, Tresor tresor) {
        int i = 0;
        for (CartesTirage c : j.getCartesEnMain()) {
            if (c instanceof CarteTresor) {
                if (c.getNom() == tresor.toString()) {
                    i++;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        if (i <= 4) {
            if (j.getPositionCourante().getTresor() == tresor) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private void prendreTresor(Tresor tresor, Aventurier j) {
        if (this.peutPrendreTresor(j, tresor)) {
            this.tresorsAcquis.add(tresor);
        }
    }

    private boolean partieGagnée() {
        Boolean allAlive = true;
        Boolean allHelico = true;

        for (Aventurier j : this.joueurs) {
            if (j.getVivant()) {
                allAlive = true;
            } else {
                allAlive = false;
                break;
            }

            if (j.getPositionCourante().getNom() == "Heliport") {
                allHelico = true;
            } else {
                allHelico = false;
                break;
            }
        }
        if (niveauEaux < 6) {
            if (allAlive) {
                if (allHelico) {
                    if (this.tresorsAcquis.size() == 4) {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                return false;
            }

        } else {
            return false;
        }

    }

    private Boolean partiePerdue() {
        Boolean allAlive = true;
        for (Aventurier j : this.joueurs) {
            if (j.getVivant()) {
                allAlive = false;
            } else {
                allAlive = true;
                break;
            }
        }
        if(niveauEaux>=6){
            allAlive = false;
        }
        return allAlive;
    }
}

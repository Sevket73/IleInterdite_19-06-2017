/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import Modele.CouleursEnum;
import Grille.*;
import Grille.TuileEnum;
import Aventuriers.*;
import View.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import Cartes.*;
import Cartes.CarteInondation;
import static Cartes.TresorsEnum.*;
import static Grille.EtatEnum.*;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Stack;
import java.util.Map;
import java.io.*;

/**
 *
 * @author chaulaic
 */
public class Controleur /*implements Observateur*/ {

    private int niveauEaux;
    private ArrayList<Aventurier> joueurs;
    private Grille grille = new Grille();
    private Stack<CartesTirage> cartesPioche;
    private HashSet<String> tresorsAcquis;
    private Stack<TuileEnum> listeTuiles;
    private Stack<CartesTirage> defausse;
    private Stack<CarteInondation> cartesInon;
    private Stack<CarteInondation> defausseInon;

    //bout de code conçu pour l'ihm mais dans cette version nous jouons en textuel (car ihm incomplète et inutilisable)
/*
    private VueMenu vueMenu;
    private VueRules vueRules;
    private VueGrille vueGrille;
    private VueStatue vueStatue;

    private Observateur observateur;
    private Message messArrayListage = new Message();
     */
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

        //bout de code conçu pour l'ihm mais dans cette version nous jouons en textuel (car ihm incomplète et inutilisable)
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

    //bout de code conçu pour l'ihm mais dans cette version nous jouons en textuel (car ihm incomplète et inutilisable)
    /*
    private void initJoueurs() {
        ArrayList<String> nomJoueurs = new ArrayList<>();
        nomJoueurs = vueMenu.getJoueur();

        this.joueurs.add(new Aventurier(nomJoueurs.get(1), true, 3, CouleursEnum.Bleu));
        this.joueurs.add(new Aventurier(nomJoueurs.get(2), true, 3, CouleursEnum.Rouge));
        this.joueurs.add(new Aventurier(nomJoueurs.get(3), true, 3, CouleursEnum.Noir));
        this.joueurs.add(new Aventurier(nomJoueurs.get(0), true, 3, CouleursEnum.Jaune));
    }*/

    public void creerGrille(Grille g, Aventurier j1, Aventurier j2, Aventurier j3, Aventurier j4) { //Creation de la grille selon la grille donnée sur papier
        Stack<TuileEnum> reverseListeTuiles = new Stack(); //Collection permettant d'avoir les tuiles dans le bon ordre lorsque l'on va pop()
        for (TuileEnum t : EnumSet.allOf(TuileEnum.class)) { //on parcours l'enumération afin de recupérer ces valeurs dans la collection tuile
            listeTuiles.push(t);
        }
        //Collections.shuffle(listeTuiles); //Permet de mélanger les tuiles, on ne s'en sert pas pour la demo

        for (int i = listeTuiles.size(); i > 0; i--) {   //Afin d'avoir les tuiles dans le bonne ordre par rapport à la grille donnée, on parcours listeTuiles 
            //à l'envers et on met les valeurs dans une collection différente
            reverseListeTuiles.push(listeTuiles.pop());
        }

        for (int l = 0; l <= 5; l++) { //Disposition des tuiles selon les lignes
            for (int c = 0; c <= 5; c++) { //Disposition des tuiles selon les colonnes
                if ((l == 0 && ((c == 0 || c == 1) || c == 4 || c == 5)) || (l == 1 && c == 0) || (l == 1 && c == 5) || ((l == 4 && c == 0) || (l == 4 && c == 5)) || (l == 5 && ((c == 0 || c == 1) || c == 4 || c == 5))) {
                    //Création des Tuiles null dans les coins de la grille
                    Tuile t = new Tuile(null, new Coordonnee(c, l), null);
                    g.addTuiles((l * 6 + c), t);
                } else {
                    //Création des Tuiles existantes
                    Tuile t = new Tuile(reverseListeTuiles.pop().toString(), new Coordonnee(c, l), null);

                    t.changerEtat(Assechee); //On les asseches par défaut
                    g.addTuiles((l * 6 + c), t);
                    if ((l == 0 && c == 3) || (l == 3 && ((c == 1 || c == 3) || c == 5)) || l == 5 && c == 3) { //on inonde quelques tuiles selon la grille donnée pour la demo
                        g.getTuiles(l * 6 + c).changerEtat(Inondee);
                    } else if ((c == 2 && (((l == 2 || l == 3) || l == 4))) || c == 4 && l == 3) {
                        g.getTuiles(l * 6 + c).changerEtat(Coulee);   //on coule quelques tuiles selon la grille donnée pour la demo
                    }
                    if (l == 0 && c == 3) {
                        g.getTuiles(l * 6 + c).changerCouleur(CouleursEnum.Rouge);
                    } else if (l == 1 && c == 2) {
                        g.getTuiles(l * 6 + c).changerCouleur(CouleursEnum.Noir);
                    } else if (l == 1 && c == 3) {
                        g.getTuiles(l * 6 + c).changerCouleur(CouleursEnum.Jaune);
                    } else if (l == 2 && c == 1) {
                        g.getTuiles(l * 6 + c).changerCouleur(CouleursEnum.Orange);
                    } else if (l == 2 && c == 3) {
                        g.getTuiles(l * 6 + c).changerCouleur(CouleursEnum.Bleu);
                    } else if (l == 2 && c == 4) {
                        g.getTuiles(l * 6 + c).changerCouleur(CouleursEnum.Vert);
                    }
                }
            }
        }

        System.out.println("");

        //On définit les différents départs des aventuriers en fonctions de la couleurs des pions
        g.getTuiles("LaPorteDeBronze").changerCouleur(CouleursEnum.Rouge);
        g.getTuiles("LaPorteDOr").changerCouleur(CouleursEnum.Jaune);
        g.getTuiles("LaPorteDeFer").changerCouleur(CouleursEnum.Noir);
        g.getTuiles("LaPorteDArgent").changerCouleur(CouleursEnum.Orange);
        g.getTuiles("LaPorteDeCuivre").changerCouleur(CouleursEnum.Vert);
        g.getTuiles("Heliport").changerCouleur(CouleursEnum.Bleu);

        //On définit les tresors sur les tuiles qui en possedent
        g.getTuiles("LaPorteDeBronze").setTresor(Calice_de_l_onde.toString());
        g.getTuiles("LePalaisDesMarees").setTresor(Calice_de_l_onde.toString());
        g.getTuiles("LeJardinDesHurlements").setTresor(Statue_du_Zephyr.toString());
        g.getTuiles("LeJardinDesMurmures").setTresor(Statue_du_Zephyr.toString());
        g.getTuiles("LeTempleDeLaLune").setTresor(Pierre_Sacree.toString());
        g.getTuiles("LeTempleDuSoleil").setTresor(Pierre_Sacree.toString());
        g.getTuiles("LaCaverneDuBrasier").setTresor(Cristal_Ardent.toString());
        g.getTuiles("LaCaverneDesOmbres").setTresor(Cristal_Ardent.toString());
        j1.addCarteEnMain(cartesPioche.push(new CarteTresor(Calice_de_l_onde.toString())));
        j1.addCarteEnMain(cartesPioche.push(new CarteTresor(Calice_de_l_onde.toString())));
        j1.addCarteEnMain(cartesPioche.push(new CarteTresor(Calice_de_l_onde.toString())));
        j1.addCarteEnMain(cartesPioche.push(new CarteTresor(Calice_de_l_onde.toString())));
    }

    public void jouer(Aventurier j1, Aventurier j2, Aventurier j3, Aventurier j4, Grille g) {
        this.creerGrille(grille, j1, j2, j3, j4);//on creer la grille

        j1.setPositionCourante(3, 2, g);//on place les joueurs manuellement pour la demo
        j2.setPositionCourante(3, 4, g);
        j3.setPositionCourante(3, 0, g);
        j4.setPositionCourante(2, 1, g);

        this.creerPiocheTirage();//on creer la pioche tirage (carte tresor, montee des eaux, special )
        this.creerPiocheInon();//on creer la pioche de cartes inondation
        
        System.out.println("A quelle niveau d eau souhaitez vous commencer ? (1/2/3/4/5)"); // on demande au joueurs d'initialiser le niveau d'eau
        String eau;
        Scanner repEau = new Scanner(System.in);
        eau = repEau.nextLine();
        this.initPartie(j1, j2, j3, j4, Integer.parseInt(eau), g); // on initialise la partie
        while (!this.partiePerdue()) { // on verifie que la paartie n'est pas perdue
            while (!this.partieGagnée()) {// on verifie que la paartie n'est pas gagnée
                for (Aventurier j : this.joueurs) {
                    j.resetActions();//on réinitialise le nombre d'actions restantes à effectuer
                    System.out.println(j.getNom() + " c'est à votre tour");
                    while (j.getNombreActions() >= 0) {//on verifie qu'il n'a pas épuisé son nombre d'action
                        if (!this.partieGagnée()) {// on verifie que la paartie n'est pas gagnée
                            if (!this.partiePerdue()) {// on verifie que la paartie n'est pas perdue
                                if (j.getCartesEnMain().size() > 5) {// si le joueur a plus de 5 cartes dans son jeu, on lui demande de se defausser
                                    System.out.println("Vous ne devez avoir que 5 cartes maximum ! Defaussez-vous !");
                                    this.defausser(j);
                                } else {
                                    //on presente l'etat du jeu
                                    System.out.println("Position des joueurs :");
                                    for (Aventurier joueur : joueurs) {
                                        System.out.println(joueur.getNom() + " : " + joueur.getPositionCourante().getNom());
                                    }
                                    System.out.println(j.getPositionCourante().getCoordonnée().getColonne() + " " + j.getPositionCourante().getCoordonnée().getLigne());
                                    System.out.println(" ");
                                    System.out.println("Les tuiles inondées sont : ");
                                    for (Tuile t : g.getHmGrille().values()) {
                                        if (t.getEtat() == EtatEnum.Inondee) {
                                            System.out.println(t.getNom());
                                        }
                                    }
                                    System.out.println();
                                    System.out.println("Les tuiles coulées sont : ");
                                    for (Tuile t : g.getHmGrille().values()) {
                                        if (t.getEtat() == EtatEnum.Coulee) {
                                            System.out.println(t.getNom());
                                        }
                                    }
                                    System.out.println();
                                    System.out.println("Cartes en main : ");
                                    for (CartesTirage c : j.getCartesEnMain()) {

                                        System.out.print(c.getNom() + ' ');

                                    }
                                    System.out.println();
                                    System.out.println("Quelle action souhaitez vous faire ? (deplacer/assecher/donner une carte/coup special/passer/prendre tresor)");//on demande au joueur quele action il souhaite faire
                                    Scanner repAction = new Scanner(System.in);
                                    String action;
                                    action = repAction.nextLine();

                                    if (action.equals("deplacer")) {//s'il souhaite se déplacer, on le déplace
                                        j.deplacement(g);
                                    } else if (action.equals("assecher")) {//s'il souhaite assecher une tuile, on l'asseche
                                        j.assechement(g);
                                    } else if (action.equals("donner une carte")) {//s'il souhaite donner une carte, on lui demande à qui il veut la donner, et quelle carte
                                        System.out.println("A quel aventurier souhaitez vous donner une carte ?");
                                        Scanner aventurier = new Scanner(System.in);
                                        String repAv;
                                        repAv = aventurier.nextLine();
                                        System.out.println("Quelle carte souhaitez vous donner ?");
                                        Scanner carte = new Scanner(System.in);
                                        String repCarte;
                                        repCarte = carte.nextLine();
                                        j.donnerCarteTresor(j.getCarte(repCarte), this.getJoueur(repAv));
                                    } else if (action.equals("coup special")) {//s'il souhaite effectuer une coup special, on lui dmande lequel
                                        System.out.println("Quelle coup special voulez vous faire ?(SacDeSable/Helicoptere");
                                        Scanner coupS = new Scanner(System.in);
                                        String repCoupS;
                                        repCoupS = coupS.nextLine();

                                        if (j.getCarte(repCoupS) instanceof CarteSpecial) {
                                            if (((CarteSpecial) j.getCarte(repCoupS)).getType() == "Helicoptere") {
                                                this.coupSpecialHelico(j, g);
                                                j.enleverCarte(j.getCarte(repCoupS));
                                            } else if (((CarteSpecial) ((CarteSpecial) j.getCarte(repCoupS))).getType() == "SacDeSable") {
                                                this.coupSpecialSacDeSable(g);
                                                j.enleverCarte(j.getCarte(repCoupS));
                                            } else {
                                                System.out.println("Ce n'est pas une carte special tant pis pour vous !");
                                            }
                                        } else {
                                            System.out.println("Vous en avez ");
                                        }
                                    } else if (action.equals("passer")) {//S'il souhaite passer, on passe au joueur suivant
                                        break;
                                    } else if (action.equals("prendre tresor")) {//s'lsouhaite prendre un tresor, on lui demande lequel et on verifie qu'il a pu le prendre
                                        System.out.println("Quel tresor voulez vous prendre ?");
                                        Scanner nomTres = new Scanner(System.in);
                                        String repNomTres;
                                        repNomTres = nomTres.nextLine();
                                        if (peutPrendreTresor(j, repNomTres, g)) {
                                            prendreTresor(repNomTres, j, g);
                                            System.out.println("Tu l'as eu !");

                                        } else {
                                            System.out.println("Tu peux pas !");
                                            ;
                                        }

                                    }

                                }
                            }
                        }
                        j.actionEffectuer();//on décrémente le nombre d'actions restantes à jouer
                    }
                    this.donnerCarteTresEtInon(j);//à la fin de chaque tour on distribue des cartes
                }
            }
        }

    }

    private void defausser(Aventurier j) {// quand le joueur a trop de carte dans son jeu, cette mthode permet de le defausser d'une carte
        System.out.println(" Veuillez choisir une carte a défausser");
        for (CartesTirage c : j.getCartesEnMain()) {
            System.out.println(c.getNom());
        }
        Scanner repCarte = new Scanner(System.in);
        String carte = repCarte.nextLine().toString();
        //carte = "Helicoptere";
        System.out.println("Vous avez choisi " + j.getCarte(carte).getNom());
        //j.getCartesEnMain().remove(j.getCarte(carte));
        j.getCartesEnMain().remove(j.getCarte(carte));
        for (CartesTirage c : j.getCartesEnMain()) {
            System.out.println(c.getNom());
        }
    }

    private void donnerCarteTresEtInon(Aventurier j) {//donne 2 cartes tresor et des cartes inondations en fonction du niveau d'eau
        this.piocherCarte(j);
        System.out.println("Je lui donne une carte T");
        this.piocherCarte(j);
        System.out.println("Je lui donne une carte T");
        //for (CartesTirage t : j.getCartesEnMain()) {
        //     System.out.println(t.getNom());
        // }
        System.out.println("Le niveau de l'eau est de : " + niveauEaux);
        for (int i = 0; i < niveauEaux; i++) {
            this.piocherCarteInon();
            System.out.println("Je lui donne une carte I");

        }
        
    }

    //bout de code conçu pour l'ihm mais dans cette version nous jouons en textuel (car ihm incomplète et inutilisable)
    /*@Override
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
    private void creerPiocheTirage() {//cette methode creer la pioche de CarteTirage(carte tresor, montee des eaux, special )
        for (int i = 0; i < 5; i++) {
            cartesPioche.push(new CarteTresor(Statue_du_Zephyr.toString()));
            cartesPioche.push(new CarteTresor(Calice_de_l_onde.toString()));
            cartesPioche.push(new CarteTresor(Cristal_Ardent.toString()));
            cartesPioche.push(new CarteTresor(Pierre_Sacree.toString()));

        }
        for (int i = 0; i < 3; i++) {
            cartesPioche.push(new CarteSpecial("Helicoptere"));
        }
        for (int i = 0; i < 1; i++) {
            cartesPioche.push(new CarteSpecial("SacDeSable"));
            cartesPioche.push(new CarteMonteeDesEaux("MonteeDesEaux"));
        }

        //Collections.shuffle(cartesPioche);
    }

    private void creerPiocheInon() {//cette methode creer la pioche de CarteInondation
        for (Tuile t : grille.getHmGrille().values()) {
            /* int l = grille.getTuiles(i).getCoordonnée().getLigne();
            int c = grille.getTuiles(i).getCoordonnée().getColonne();
            switch(l*6+c){
                case 0:case1:case4:case5:case6:case11:case24:case29:case30:case31:case34:case35 :
                
                break;
                
            }*/
            if (t.getNom() != null) {
                CarteInondation cI = new CarteInondation(t);
                cartesInon.push(cI);
            }
        }
    }

    private void piocherCarteInon() {//on pioche une carte inondation, s'il n'y a plus de cartes dans la pioche, on met la defausse dans la pioche
        if (cartesInon.empty()) {
            for (CarteInondation c : this.defausseInon) {
                this.cartesInon.push(c);
            }
            //cartesInon.addAll(defausseInon);
            defausseInon.removeAllElements();
            Collections.shuffle(cartesInon);
        } else {
            
            CarteInondation cI = cartesInon.pop();
            Tuile t = cI.getCible();
            if (t.getEtat() == Assechee) {
                t.changerEtat(Inondee);
                defausseInon.push(cI);

            } else if (t.getEtat() == Inondee) {
                t.changerEtat(Coulee);

            }
        }
    }

    private void piocherCarte(Aventurier j) {//pioche une carte dans la piocheTirage, s'il n'y a plus de cartes dans la pioche, on met la defausse dans la pioche
        if (cartesPioche.empty()) {
            cartesPioche.addAll(this.defausse);
            defausse.removeAllElements();
        }
        CartesTirage carte;
        carte = cartesPioche.pop();
        if (carte instanceof CarteMonteeDesEaux) {
            monterEau();
            defausse.push(carte);
            
        } else {
            j.addCarteEnMain(carte);
        }
    }

    private void monterEau() { // augmente le niveau de l'eau 
        niveauEaux = niveauEaux + 1;
    }

    private void initCartes(Aventurier j) {//initialise les cartes d'un aventurier en debut de partie
        for (int i = 0; i < 4; i++) {
            this.piocherCarte(j);
        }
    }

    private void initPartie(Aventurier j1, Aventurier j2, Aventurier j3, Aventurier j4, int niveauEauxDep, Grille g) { 
        //on ajoute les différents joueurs dans la collection joueurs, on leur disribue des cartes, on définit le niveau de l'eau au départ et on place les aventurier sur la grille
        if (j1 != null) {
            this.joueurs.add(j1);

            // this.initCartes(j1);
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
        this.niveauEaux = niveauEauxDep;
        for (Tuile t : g.getHmGrille().values()) {
            if ((j1 != null) && (t.getCouleur() == j1.getCouleur())) {
                t.setDepartAventurier(j1);
                t.addPossedeAventurier(j1);
                j1.setPositionCourante(t.getCoordonnée().getColonne(), t.getCoordonnée().getLigne(), g);
            }
            if ((j2 != null) && (t.getCouleur() == j2.getCouleur())) {
                t.setDepartAventurier(j2);
                t.addPossedeAventurier(j2);
                j2.setPositionCourante(t.getCoordonnée().getColonne(), t.getCoordonnée().getLigne(), g);
            }
            if ((j3 != null) && (t.getCouleur() == j3.getCouleur())) {
                t.setDepartAventurier(j3);
                t.addPossedeAventurier(j3);
                j3.setPositionCourante(t.getCoordonnée().getColonne(), t.getCoordonnée().getLigne(), g);

            }
            if ((j4 != null) && (t.getCouleur() == j4.getCouleur())) {
                t.setDepartAventurier(j4);
                t.addPossedeAventurier(j4);
                j4.setPositionCourante(t.getCoordonnée().getColonne(), t.getCoordonnée().getLigne(), g);

            }
        }
    }

    private boolean verifNbJoueurs() { // verifie qu'il y a au moins 2 joueurs et pas plus de 4
        if (this.joueurs.size() < 2 || this.joueurs.size()>4) {
            return false;
        } else {
            return true;
        }
    }

    private boolean peutPrendreTresor(Aventurier j, String tresor, Grille g) {//Renvoie true si le joueurs a 4 cartes du trésor et est sur une tuile qui possede ce tresor
        int i = 0;
        for (CartesTirage c : j.getCartesEnMain()) {
            if (c instanceof CarteTresor) {
                if (c.getNom().equals(tresor)) {
                    i++;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        if (i >= 4) {
            if (tresor.equals(g.getTuiles(j.getPositionCourante().getCoordonnée().getLigne(), j.getPositionCourante().getCoordonnée().getColonne()).getTresor())) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private void prendreTresor(String tresor, Aventurier j, Grille g) {//on ajoute le tresor à la collection tresors acquis
        if (this.peutPrendreTresor(j, tresor, g)) {
            this.tresorsAcquis.add(tresor);
            for (String t : this.tresorsAcquis) {
                System.out.println(t);

            }
            for (int i = 0; i <= 4; i++) {
                j.enleverCarte(j.getCarte(tresor));
                j.enleverCarte(j.getCarte(tresor));
                j.enleverCarte(j.getCarte(tresor));
                j.enleverCarte(j.getCarte(tresor));
            }
        }
    }

    private boolean partieGagnée() { //renvoie vraie si le niveau d'eau est inférieur à 6, que tous les joueurs sont vivant, qu'il sont tous sur la tuile heliport et qu'ils ont récupéré les 4 tresors
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

    private Boolean partiePerdue() {//renvoie vraie si le niveau d'eau >= 6, qu'un des joueurs est mort
        Boolean perdue = true;
        for (Aventurier j : this.joueurs) {
            if (j.getVivant()) {
                perdue = false;
                if (this.niveauEaux < 6) {
                    perdue = false;
                } else {
                    perdue = true;
                }
            } else {
                perdue = true;
                break;
            }
        }

        return perdue;

    }

    private Aventurier getJoueur(String nom) {// recupère un aventurier selon son nom
        Aventurier a = null;
        for (Aventurier j : joueurs) {
            if (j.getNom().equals(nom)) {
                a = j;
                break;
            }
        }
        return a;
    }

    private void coupSpecialHelico(Aventurier j, Grille g) {//effectuer le coup special de la carte hélicoptère

        System.out.println("Combien d'aventurier souhaitez vous déplacer ? (1/2/3//4)");
        Scanner repNbAv = new Scanner(System.in);
        String nbAv = repNbAv.nextLine();

        if (Integer.parseInt(nbAv) == 1) {
            Aventurier av = null;
            System.out.println("Saisissez un aventurier : ");
            Scanner repAventurier = new Scanner(System.in);
            String a = repAventurier.nextLine();
            av = this.getJoueur(a);

            System.out.println("Saisissez une tuile : ");
            for (Tuile t : g.getHmGrille().values()) {
                if (t.getEtat() != Coulee) {
                    System.out.print(t.getNom() + ' ');
                }
            }
            Scanner repTuile = new Scanner(System.in);
            String t = repTuile.nextLine();
            Tuile tu = g.getTuiles(t);
            System.out.println(av.getNom());
            this.DeplacerJoueur(av, tu, g);

        } else if (Integer.parseInt(nbAv) == 2) {

            Aventurier variable[] = null;

            for (int k = 0; k < 2; k++) {
                System.out.println("Saisissez un aventurier : ");
                Scanner repAventurier = new Scanner(System.in);
                String prout = repAventurier.nextLine();
                System.out.println(this.getJoueur(prout).getNom());
                variable[k] = this.getJoueur(prout);
            }
            System.out.println("Saisissez une tuile : ");
            for (Tuile t : g.getHmGrille().values()) {
                System.out.print(t.getNom() + ' ');
            }
            Scanner repTuile = new Scanner(System.in);
            String t = repTuile.nextLine();
            Tuile tu = g.getTuiles(t);
            this.DeplacerJoueur(variable[0], tu, g);
            this.DeplacerJoueur(variable[1], tu, g);

        } else if (Integer.parseInt(nbAv) == 3) {

            Aventurier variable[] = null;

            for (int k = 0; k < 2; k++) {
                System.out.println("Saisissez un aventurier : ");
                Scanner repAventurier = new Scanner(System.in);
                variable[k] = this.getJoueur(repAventurier.nextLine());

            }
            System.out.println("Saisissez une tuile : ");
            for (Tuile t : g.getHmGrille().values()) {
                if (t.getNom() != null) {
                    System.out.print(t.getNom());
                }
            }
            Scanner repTuile = new Scanner(System.in);
            String t = repTuile.nextLine();
            Tuile tu = g.getTuiles(t);
            this.DeplacerJoueur(variable[0], tu, g);
            this.DeplacerJoueur(variable[1], tu, g);
            this.DeplacerJoueur(variable[2], tu, g);
        } else if (Integer.parseInt(nbAv) == 4) {
            Aventurier variable[] = null;

            for (int k = 0; k < 2; k++) {
                System.out.println("Saisissez un aventurier : ");
                Scanner repAventurier = new Scanner(System.in);
                variable[k] = this.getJoueur(repAventurier.nextLine());

            }
            System.out.println("Saisissez une tuile : ");
            for (Tuile t : g.getHmGrille().values()) {
                System.out.print(t.getNom() + ' ');
            }
            Scanner repTuile = new Scanner(System.in);
            String t = repTuile.nextLine();
            Tuile tu = g.getTuiles(t);
            this.DeplacerJoueur(variable[0], tu, g);
            this.DeplacerJoueur(variable[1], tu, g);
            this.DeplacerJoueur(variable[2], tu, g);
            this.DeplacerJoueur(variable[3], tu, g);
        } else {
            System.out.println("J'me TIRE !");
        }
    }

    private void coupSpecialSacDeSable(Grille g) {//effectuer le coup special de la carte Sac de sable
        System.out.println("Les tuiles inondées sont : ");
        for (Tuile t : g.getHmGrille().values()) {
            if (t.getEtat() == EtatEnum.Inondee) {
                System.out.print(t.getNom() + ' ');
            }
        }
        System.out.println();
        System.out.println("Saisissez une tuile : ");
        Scanner repTuile = new Scanner(System.in);
        String t = repTuile.nextLine();
        Tuile tu = g.getTuiles(t);
        System.out.println(tu.getNom());
        tu.changerEtat(Assechee);
    }

    private void DeplacerJoueur(Aventurier a, Tuile t, Grille g) {
        a.setPositionCourante(t.getCoordonnée().getColonne(), t.getCoordonnée().getLigne(), g);
        t.addPossedeAventurier(a);
        System.out.println("Le joueur" + a.getNom() + " a été déplacé");
        System.out.println(a.getPositionCourante());

    }

}

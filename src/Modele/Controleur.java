/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

//import comment.CarteSacDeSable;
//import comment.CarteHelicoptere;
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

    /*
    private void initJoueurs() {
        ArrayList<String> nomJoueurs = new ArrayList<>();
        nomJoueurs = vueMenu.getJoueur();

        this.joueurs.add(new Aventurier(nomJoueurs.get(1), true, 3, CouleursEnum.Bleu));
        this.joueurs.add(new Aventurier(nomJoueurs.get(2), true, 3, CouleursEnum.Rouge));
        this.joueurs.add(new Aventurier(nomJoueurs.get(3), true, 3, CouleursEnum.Noir));
        this.joueurs.add(new Aventurier(nomJoueurs.get(0), true, 3, CouleursEnum.Jaune));
    }*/

 /*private String listeTuile[]= {null,null,"LePontDesAbimes","LaPorteDeBronze",null,null,
                          null,"LaCaverneDesOmbres","LaPorteDeFer","LaPorteDOr","LesFalaisesDeLOubli",null,
                          "LePalaisDeCorail","LaPorteDArgent","LesDunesDeLIllusion","Heliport","LaPorteDeCuivre","LeJardinDesHurlements",
                          "LaForetPourpre","LeLagonPerdu","LeMaraisBrumeux","Observatoire","LeRocherFantome","LaCaverneDuBrasier",
                          null,"LeTempleDuSoleil","LeTempleDeLaLune","LePalaisDesMarees","LeValDuCrepuscule",null,
                          null,null,"LaTourDuGuet","LeJardinDesMurmures",null,null};*/
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
        /*for (Tuile t : reverseListeTuiles) {
            System.out.println("Tuiles : ");
            System.out.println(t.toString());
        }*/
 /*System.out.println("");
        System.out.println(listeTuiles.peek().toString());
        this.listeTuiles.remove(listeTuiles.peek());
        System.out.println(listeTuiles.peek().toString());
        System.out.println("");
        for (Tuile t : this.listeTuiles) {
            System.out.println(t.toString());
            
        }*/
        //Collections.shuffle(listeTuiles);

        for (int l = 0; l <= 5; l++) { //Disposition des tuiles selon les lignes
            for (int c = 0; c <= 5; c++) { //Disposition des tuiles selon les colonnes
                if ((l == 0 && ((c == 0 || c == 1) || c == 4 || c == 5)) || (l == 1 && c == 0) || (l == 1 && c == 5) || ((l == 4 && c == 0) || (l == 4 && c == 5)) || (l == 5 && ((c == 0 || c == 1) || c == 4 || c == 5))) {
                    //Création des Tuiles null dans les coins de la grille
                    Tuile t = new Tuile(null, new Coordonnee(c, l), null);
                    g.addTuiles((l * 6 + c), t);
                } else {
                    //Création des Tuiles existantes
                    Tuile t = new Tuile(reverseListeTuiles.pop().toString(), new Coordonnee(c, l), null);
                    /*this.listeTuiles.remove(listeTuiles.peek());
                    System.out.println("");
                    System.out.println(t.getNom());*/
                    t.changerEtat(Inondee); //On les asseches par défaut
                    g.addTuiles((l * 6 + c), t);

                }
            }
        }
        /*
        System.out.println("");
        for (Tuile t : g.getHmGrille().values()) {
            System.out.println(t.getNom());
        }*/
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
        this.creerGrille(grille, j1, j2, j3, j4);
        
        j1.setPositionCourante(3, 2,g);
        j2.setPositionCourante(3, 4,g);
        j3.setPositionCourante(3, 0,g);
        j4.setPositionCourante(2, 1,g);
        
        this.creerPiocheTirage();
        this.creerPiocheInon();
        //   for(CartesTirage c : cartesPioche){
        //     System.out.println(c.getNom());
        //  }
        System.out.println("A quelle niveau d eau souhaitez vous commencer ? (1/2/3/4/5)");
        String eau;
        Scanner repEau = new Scanner(System.in);
        eau = repEau.nextLine();
        this.initPartie(j1, j2, j3, j4, Integer.parseInt(eau),g);
        while (!this.partiePerdue()) {
            while (!this.partieGagnée()) {
                for (Aventurier j : this.joueurs) {
                    j.resetActions();
                    System.out.println(j.getNom() + " c'est à votre tour");
                    while (j.getNombreActions() >= 0) {
                        if (!this.partieGagnée()) {
                            if (!this.partiePerdue()) {
                                if (j.getCartesEnMain().size() > 5) {
                                    System.out.println("Vous ne devez avoir que 5 cartes maximum ! Defaussez-vous !");
                                    this.defausser(j);
                                } else {

                                    //for (CartesTirage c : j.getCartesEnMain()) {null
                                    //for (CartesTirage c : j.getCartesEnMain()) {
                                    //   if(c!=null) System.out.println(c.getNom());
                                    //}
                                    System.out.println("Position des joueurs :");
                                    for (Aventurier joueur : joueurs) {
                                        System.out.println(joueur.getNom() + " : " + joueur.getPositionCourante().getNom());
                                    }
                                    System.out.println(j.getPositionCourante().getCoordonnée().getColonne()+" "+j.getPositionCourante().getCoordonnée().getLigne());
                                    System.out.println(" ");
                                    System.out.println("Les tuiles inondées sont : ");
                                    for (Tuile t : g.getHmGrille().values()) {
                                        if (t.getEtat() == EtatEnum.Inondee) {
                                            System.out.println(t.getNom() );
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
                                    System.out.println("Quelle action souhaitez vous faire ? (deplacer/assecher/donner une carte/coup special/passer/prendre tresor)");
                                    Scanner repAction = new Scanner(System.in);
                                    String action;
                                    action = repAction.nextLine();

                                    if (action.equals("deplacer")) {
                                        j.deplacement(g);
                                    } else if (action.equals("assecher")) {
                                        j.assechement(g);
                                    } else if (action.equals("donner une carte")) {
                                        System.out.println("A quel aventurier souhaitez vous donner une carte ?");
                                        Scanner aventurier = new Scanner(System.in);
                                        String repAv;
                                        repAv = aventurier.nextLine();
                                        System.out.println("Quelle carte souhaitez vous donner ?");
                                        Scanner carte = new Scanner(System.in);
                                        String repCarte;
                                        repCarte = carte.nextLine();
                                        j.donnerCarteTresor(j.getCarte(repCarte), this.getJoueur(repAv));
                                    } else if (action.equals("coup special")) {
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
                                    } else if (action.equals("passer")) {
                                        break;
                                    }else if (action.equals("prendre tresor")){
                                        System.out.println("Quel tresor voulez vous prendre ?");
                                        Scanner nomTres = new Scanner(System.in);
                                        String repNomTres;
                                        repNomTres = nomTres.nextLine();
                                        if (peutPrendreTresor(j,repNomTres,g)){ 
                                            prendreTresor(repNomTres,j,g);
                                            
                                        }else{
                                            System.out.println("Tu peux pas !");
                                            ;
                                        }
                                        
                                    }

                                }
                            }
                        }
                        j.actionEffectuer();
                    }
                    this.donnerCarteTresEtInon(j);
                }
            }
        }

    }

    private void defausser(Aventurier j) {
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

    private void donnerCarteTresEtInon(Aventurier j) {
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
        //for (CarteInondation c : cartesInon) {
        //   System.out.println(c.getCible().getNom());
        //}
    }


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
    private void creerPiocheTirage() {
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

    private void creerPiocheInon() {
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

    private void piocherCarteInon() {
        if (cartesInon.empty()) {
            for (CarteInondation c : this.defausseInon) {
                this.cartesInon.push(c);
            }
            //cartesInon.addAll(defausseInon);
            defausseInon.removeAllElements();
            Collections.shuffle(cartesInon);
        } else {
            //for (CarteInondations c : cartesInon) {
            //    System.out.println(c.getCible().getNom());
            //

            //  System.out.println("Je tire une carte");
            CarteInondation cI = cartesInon.pop();
            Tuile t = cI.getCible();
            //   System.out.println(t.getNom());
            if (t.getEtat() == Assechee) {
                t.changerEtat(Inondee);
                defausseInon.push(cI);

            } else if (t.getEtat() == Inondee) {
                t.changerEtat(Coulee);

            }

        }
    }

    private void piocherCarte(Aventurier j) {
        if (cartesPioche.empty()) {
            cartesPioche.addAll(this.defausse);
            defausse.removeAllElements();
        }
        CartesTirage carte;
        carte = cartesPioche.pop();
        if (carte instanceof CarteMonteeDesEaux) {
            monterEau();
            defausse.push(carte);
            /* this.cartesInon.addAll(this.defausseInon);
            defausseInon.removeAllElements();
            Collections.shuffle(cartesInon);*/
        } else {
            j.addCarteEnMain(carte);
        }
    }

    private void monterEau() {
        niveauEaux = niveauEaux + 1;
    }

    private void initCartes(Aventurier j) {
        for (int i = 0; i < 4; i++) {
            this.piocherCarte(j);
        }
    }

    private void initPartie(Aventurier j1, Aventurier j2, Aventurier j3, Aventurier j4, int niveauEauxDep,Grille g) {
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
            }
            if ((j2 != null) && (t.getCouleur() == j2.getCouleur())) {
                t.setDepartAventurier(j2);
                t.addPossedeAventurier(j2);
            }
            if ((j3 != null) && (t.getCouleur() == j3.getCouleur())) {
                t.setDepartAventurier(j3);
                t.addPossedeAventurier(j3);
            }
            if ((j4 != null) && (t.getCouleur() == j4.getCouleur())) {
                t.setDepartAventurier(j4);
                t.addPossedeAventurier(j4);
            }
        }
    }

    private boolean verifNbJoueurs() {
        if (this.joueurs.size() < 2) {
            return false;
        } else {
            return true;
        }
    }

    private boolean peutPrendreTresor(Aventurier j, String tresor,Grille g) {
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
            if (g.getTuiles(j.getPositionCourante().getCoordonnée().getLigne(), j.getPositionCourante().getCoordonnée().getColonne()).getTresor().equals(tresor)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private void prendreTresor(String tresor, Aventurier j,Grille g) {
        if (this.peutPrendreTresor(j, tresor,g)) {
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

    private Aventurier getJoueur(String nom) {
        Aventurier a = null;
        for (Aventurier j : joueurs) {
            if (j.getNom().equals(nom)) {
                a = j;
                break;
            }
        }
        return a;
    }

    private void coupSpecialHelico(Aventurier j, Grille g) {
        
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
            this.DeplacerJoueur(av, tu,g);

        } else if (Integer.parseInt(nbAv) == 2) {
            
            Aventurier variable[] = null;
            
            for (int k = 0; k < 2; k++) {
                System.out.println("Saisissez un aventurier : ");
                Scanner repAventurier = new Scanner(System.in);
                variable[k]= this.getJoueur(repAventurier.nextLine());
     
            }
            System.out.println("Saisissez une tuile : ");
            for (Tuile t : g.getHmGrille().values()) {
                System.out.print(t.getNom() + ' ');
            }
            Scanner repTuile = new Scanner(System.in);
            String t = repTuile.nextLine();
            Tuile tu = g.getTuiles(t);
            this.DeplacerJoueur(variable[0], tu,g);
            this.DeplacerJoueur(variable[1], tu,g);

        } else if (Integer.parseInt(nbAv) == 3) {
            
            Aventurier variable[] = null;
            
            for (int k = 0; k < 2; k++) {
                System.out.println("Saisissez un aventurier : ");
                Scanner repAventurier = new Scanner(System.in);
                variable[k]= this.getJoueur(repAventurier.nextLine());
     
            }
            System.out.println("Saisissez une tuile : ");
            for (Tuile t : g.getHmGrille().values()) {
                if(t.getNom()!=null)
                System.out.print(t.getNom() );
            }
            Scanner repTuile = new Scanner(System.in);
            String t = repTuile.nextLine();
            Tuile tu = g.getTuiles(t);
            this.DeplacerJoueur(variable[0], tu,g);
            this.DeplacerJoueur(variable[1], tu,g);
            this.DeplacerJoueur(variable[2], tu,g);
        } else if (Integer.parseInt(nbAv) == 4) {
            Aventurier variable[] = null;
            
            for (int k = 0; k < 2; k++) {
                System.out.println("Saisissez un aventurier : ");
                Scanner repAventurier = new Scanner(System.in);
                variable[k]= this.getJoueur(repAventurier.nextLine());
     
            }
            System.out.println("Saisissez une tuile : ");
            for (Tuile t : g.getHmGrille().values()) {
                System.out.print(t.getNom() + ' ');
            }
            Scanner repTuile = new Scanner(System.in);
            String t = repTuile.nextLine();
            Tuile tu = g.getTuiles(t);
            this.DeplacerJoueur(variable[0], tu,g);
            this.DeplacerJoueur(variable[1], tu,g);
            this.DeplacerJoueur(variable[2], tu,g);
            this.DeplacerJoueur(variable[3], tu,g);
        }else{
            System.out.println("J'me TIRE !");
        }
    }

    private void coupSpecialSacDeSable(Grille g) {
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

    private void DeplacerJoueur(Aventurier a, Tuile t,Grille g) {
        a.setPositionCourante(t.getCoordonnée().getColonne(), t.getCoordonnée().getLigne(),g);
        t.addPossedeAventurier(a);
        System.out.println("Le joueur"+a.getNom()+" a été déplacé");

    }

}

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

/**
 *
 * @author chaulaic
 */
public class Controleur /*implements Observateur*/ {

    private int niveauEaux;
    private ArrayList<Aventurier> joueurs;
    private Grille grille = new Grille();
    private Stack<CartesTirage> cartesPioche;
    private HashSet<TresorsEnum> tresorsAcquis;
    private Stack<TuileEnum> listeTuiles;
    private Stack<CartesTirage> cartes;
    private Stack<CartesTirage> defausse;
    private Stack<CarteInondation> cartesInon;
    private Stack<CarteInondation> defausseInon;

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
        this.cartes = new Stack();
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

        this.joueurs.add(new Aventurier(nomJoueurs.get(1), true, 3, CouleursEnum.Bleu));
        this.joueurs.add(new Aventurier(nomJoueurs.get(2), true, 3, CouleursEnum.Rouge));
        this.joueurs.add(new Aventurier(nomJoueurs.get(3), true, 3, CouleursEnum.Noir));
        this.joueurs.add(new Aventurier(nomJoueurs.get(0), true, 3, CouleursEnum.Jaune));
    }

    /*private String listeTuile[]= {null,null,"LePontDesAbimes","LaPorteDeBronze",null,null,
                          null,"LaCaverneDesOmbres","LaPorteDeFer","LaPorteDOr","LesFalaisesDeLOubli",null,
                          "LePalaisDeCorail","LaPorteDArgent","LesDunesDeLIllusion","Heliport","LaPorteDeCuivre","LeJardinDesHurlements",
                          "LaForetPourpre","LeLagonPerdu","LeMaraisBrumeux","Observatoire","LeRocherFantome","LaCaverneDuBrasier",
                          null,"LeTempleDuSoleil","LeTempleDeLaLune","LePalaisDesMarees","LeValDuCrepuscule",null,
                          null,null,"LaTourDuGuet","LeJardinDesMurmures",null,null};*/
    public void creerGrille(Grille g, Aventurier j1, Aventurier j2, Aventurier j3, Aventurier j4) {
        Stack<TuileEnum> reverseListeTuiles = new Stack();
        for (TuileEnum t : EnumSet.allOf(TuileEnum.class)) {
            listeTuiles.push(t);
        }
        //Collections.shuffle(listeTuiles);

        for (int i = listeTuiles.size(); i > 0; i--) {
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

        for (int l = 0; l <= 5; l++) {
            for (int c = 0; c <= 5; c++) {
                if ((l == 0 && ((c == 0 || c == 1) || c == 4 || c == 5)) || (l == 1 && c == 0) || (l == 1 && c == 5) || ((l == 4 && c == 0) || (l == 4 && c == 5)) || (l == 5 && ((c == 0 || c == 1) || c == 4 || c == 5))) {
                    Tuile t = new Tuile(null, new Coordonnee(c, l), null);
                    g.addTuiles((l * 6 + c), t);
                } else {
                    Tuile t = new Tuile(reverseListeTuiles.pop().toString(), new Coordonnee(c, l), null);
                    /*this.listeTuiles.remove(listeTuiles.peek());
                    System.out.println("");
                    System.out.println(t.getNom());*/
                    t.changerEtat(Assechee);
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

        g.getTuiles("LaPorteDeBronze").changerCouleur(CouleursEnum.Rouge);
        g.getTuiles("LaPorteDOr").changerCouleur(CouleursEnum.Jaune);
        g.getTuiles("LaPorteDeFer").changerCouleur(CouleursEnum.Noir);
        g.getTuiles("LaPorteDArgent").changerCouleur(CouleursEnum.Orange);
        g.getTuiles("LaPorteDeCuivre").changerCouleur(CouleursEnum.Vert);
        g.getTuiles("Heliport").changerCouleur(CouleursEnum.Bleu);

        g.getTuiles("LePalaisDeCorail").setTresor(Calice_de_l_onde);
        g.getTuiles("LePalaisDesMarees").setTresor(Calice_de_l_onde);
        g.getTuiles("LeJardinDesHurlements").setTresor(Statue_du_Zephyr);
        g.getTuiles("LeJardinDesMurmures").setTresor(Statue_du_Zephyr);
        g.getTuiles("LeTempleDeLaLune").setTresor(Pierre_Sacree);
        g.getTuiles("LeTempleDuSoleil").setTresor(Pierre_Sacree);
        g.getTuiles("LaCaverneDuBrasier").setTresor(Cristal_Ardent);
        g.getTuiles("LaCaverneDesOmbres").setTresor(Cristal_Ardent);

        for (Tuile t : g.getHmGrille().values()) {
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
        this.creerGrille(grille, j1, j2, j3, j4);
        this.creerPiocheTirage();
        this.creerPiocheInon();
        System.out.println("A quelle niveau d eau souhaitez vous commencer ? (1/2/3/4/5)");
        String eau;
        Scanner repEau = new Scanner(System.in);
        eau = repEau.nextLine();
        this.initPartie(j1, j2, j3, j4, Integer.parseInt(eau));
        while (!this.partiePerdue()) {
            while (!this.partieGagnée()) {
                for (Aventurier j : this.joueurs) {
                    j.resetActions();
                    System.out.println(j.getNom());
                    while(j.getNombreActions()>=0){
                    if (!this.partieGagnée()) {
                        if (!this.partiePerdue()) {
                            if (j.getCartesEnMain().size() > 5) {
                                System.out.println("Vous ne devez avoir que 5 cartes maximum ! Defaussez-vous !");
                                //this.defausser();
                            } else {
                               //for (CartesTirage c : j.getCartesEnMain()) {
                                //   if(c!=null) System.out.println(c.getNom());
                                //}
                                System.out.println("Quelle action souhaitez vous faire ? (deplacer/assecher/donner une carte/coup special/passer)");
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
                                    repAv =  aventurier.nextLine();
                                    System.out.println("Quelle carte souhaitez vous donner ?");
                                    Scanner carte = new Scanner(System.in);
                                    String repCarte;
                                    repCarte =  carte.nextLine();
                                    j.donnerCarteTresor(j.getCarte(repCarte), this.getJoueur(repAv));
                                } else if (action.equals("coup special")){
                                    
                                } else if (action.equals("passer")){
                                    break;
                                }
                                
                            }
                        }
                    } j.actionEffectuer();
                    }this.donnerCarteTresEtInon(j);
                }
            }
        }
        
        
        
        
        
        
        /*String passez;

        this.creerGrille(grille, j1, j2, j3, j4);
        this.creerPiocheTirage();
        this.creerPiocheInon();

        /*for (Map.Entry<Integer, Tuiles> t : g.getAze().entrySet()) {
            System.out.println(t.getValue().getNom());
        }
        System.out.println("");
        for (CarteInondations c : this.cartesInon) {
            System.out.println(c.getCible().getNom());
        }
        System.out.println("");
        System.out.println("A quelle niveau d eau souhaitez vous commencer ? (1/2/3/4/5)");
        String eau;
        Scanner repEau = new Scanner(System.in);
        eau = repEau.nextLine();
        this.initPartie(j1, j2, j3, j4, Integer.parseInt(eau));

        /* for (Tuiles t : g.getAze().values()) {
            System.out.println(t.getNom());
        }
        if (this.verifNbJoueurs()) {
            while (!this.partiePerdue()) {
                while (!this.partieGagnée()) {
                    for (Aventurier j : joueurs) {
                        System.out.println(j.getNom() + " à vous de jouer!");
                        System.out.println("");
                        j.resetActions();

                        while (j.getNombreActions() > 0) {
                            System.out.println("Vous êtes sur la tuile : " + g.getNomTuiles(j.getPositionCourante().getCoordonnée().getLigne(), j.getPositionCourante().getCoordonnée().getColonne()));
                            System.out.println("Souhaitez-vous passez ? (o/n)");
                            Scanner repPasse = new Scanner(System.in);
                            passez = repPasse.nextLine();

                            if (passez.equals("n")) {

                                System.out.println("Que souhaitez-vous faire? (deplacer/assecher/donner une carte/special)");
                                String action;
                                Scanner repAction = new Scanner(System.in);
                                action = repAction.nextLine();

                                switch (action) {
                                    case "deplacer":

                                        j.deplacement(grille);

                                        break;
                                    case "assecher":
                                        j.assechement(grille);
                                        break;
                                    case "donner une carte":
                                        for (CartesTirage c : j.getCartesEnMain()) {
                                            System.out.println(c.getNom());
                                        }
                                        System.out.println("quelle carte voulez vous donnez ?");
                                        String x;
                                        Scanner repX = new Scanner(System.in);
                                        x = repX.nextLine();
                                        
                                        System.out.println("A qui voulez vous donner la carte  ?");
                                        String xj;
                                        Scanner repxj = new Scanner(System.in);
                                        xj = repxj.nextLine();
                                        for( Aventurier jx :j.getPositionCourante().getPossedeAventurier()){
                                            System.out.println(jx.getNom());
                                        }
                                        j.donnerCarteTresor(j.getCarte(x), getJoueur(xj));
                                        break;
                                    case "Coup Special":
                                        for (CartesTirage c : j.getCartesEnMain()) {
                                            if (c instanceof CarteHelicoptere || c.getNom() == "SacDeSable") {
                                                System.out.println(c.getNom());
                                            }

                                        }

                                        System.out.println("quelle carte voulez vous utiliser?");
                                        String x1;
                                        Scanner repX1 = new Scanner(System.in);
                                        x1 = repX1.nextLine();

                                        switch (x1) {
                                            case "helicoptere":
                                                System.out.println("Combien de joueur voulez vous deplacer ? 1 , 2 , 3 ou 4");
                                                String x2;
                                                Scanner repX2 = new Scanner(System.in);
                                                x2 = repX2.nextLine();
                                                System.out.println("Sur quel tuile ?");
                                                String x3;
                                                Scanner repX3 = new Scanner(System.in);
                                                x3 = repX3.nextLine();
                                                switch (Integer.parseInt(x2)) {
                                                    case 1:
                                                        System.out.println("Inscrivez un joueur");
                                                        String x13;
                                                        Scanner repX13 = new Scanner(System.in);
                                                        x13 = repX13.nextLine();
                                                        System.out.println("Sur quel tuile ?");
                                                        j.getCarte(x1).deplacer1Joueur(this.getJoueur(x13), x3, g);
                                                        break;
                                                    case 2:
                                                        System.out.println("Inscrivez un joueur");
                                                        String x4;
                                                        Scanner repX4 = new Scanner(System.in);
                                                        x4 = repX4.nextLine();
                                                        System.out.println("Inscrivez un joueur");
                                                        String x5;
                                                        Scanner repX5 = new Scanner(System.in);
                                                        x5 = repX5.nextLine();
                                                        System.out.println("Sur quel tuile ?");
                                                        x3 = repX3.nextLine();
                                                        j.getCarte(x1).deplacer2Joueurs(this.getJoueur(x4), this.getJoueur(x5), x3, g);

                                                        break;
                                                    case 3:
                                                        System.out.println("Inscrivez un joueur");
                                                        String x6;
                                                        Scanner repX6 = new Scanner(System.in);
                                                        x6 = repX6.nextLine();
                                                        System.out.println("Inscrivez un joueur");
                                                        String x7;
                                                        Scanner repX7 = new Scanner(System.in);
                                                        x7 = repX7.nextLine();
                                                        System.out.println("Inscrivez un joueur");
                                                        String x8;
                                                        Scanner repX8 = new Scanner(System.in);
                                                        x8 = repX8.nextLine();

                                                        j.getCarte(x1).deplacer3Joueurs(this.getJoueur(x6), this.getJoueur(x7), this.getJoueur(x8), x3, g);
                                                        break;
                                                    case 4:
                                                        System.out.println("Inscrivez un joueur");
                                                        String x9;
                                                        Scanner repX9 = new Scanner(System.in);
                                                        x9 = repX9.nextLine();
                                                        System.out.println("Inscrivez un joueur");
                                                        String x10;
                                                        Scanner repX10 = new Scanner(System.in);
                                                        x10 = repX10.nextLine();
                                                        System.out.println("Inscrivez un joueur");
                                                        String x11;
                                                        Scanner repX11 = new Scanner(System.in);
                                                        x11 = repX11.nextLine();
                                                        System.out.println("Inscrivez un joueur");
                                                        String x12;
                                                        Scanner repX12 = new Scanner(System.in);
                                                        x12 = repX12.nextLine();
                                                        j.getCarte(x1).deplacer4Joueurs(this.getJoueur(x9), this.getJoueur(x10), this.getJoueur(x11), this.getJoueur(x12), x3, g);
                                                        break;
                                                }

                                        }

                                        j.enleverCarte(j.getCarte(x1));

                                }
                                j.actionEffectuer();
                            }else{break;}
                        }
                               
                            
                            this.piocherCarte(j);
                            this.piocherCarte(j);
                            for (CartesTirage t : j.getCartesEnMain()) {
                                System.out.println(t.getClass().toString());
                            }
                            for (int i = 0; i <= niveauEaux; i++) {
                                this.piocherCarteInon();
                            }
                        }

                  

                }
            }
        }

    

    
        else {
            System.out.println("Il n'y a pas assez de joueurs !");
    }*/
}

private void donnerCarteTresEtInon(Aventurier j) {
        this.piocherCarte(j);System.out.println("Je lui donne une carte T");
        this.piocherCarte(j);System.out.println("Je lui donne une carte T");
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
            cartesPioche.push(new CarteTresor(TresorsEnum.Statue_du_Zephyr));
            cartesPioche.push(new CarteTresor(TresorsEnum.Calice_de_l_onde));
            cartesPioche.push(new CarteTresor(TresorsEnum.Cristal_Ardent));
            cartesPioche.push(new CarteTresor(TresorsEnum.Pierre_Sacree));
        }
        for (int i = 0; i < 3; i++) {
            cartesPioche.push(new CarteSpecial("Helicoptere"));
        }
        for (int i = 0; i < 2; i++) {
            cartesPioche.push(new CarteSpecial("SacDeSable"));
            cartesPioche.push(new CarteMonteeDesEaux());
        }

        Collections.shuffle(cartesPioche);
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
    
    private void initPartie(Aventurier j1, Aventurier j2, Aventurier j3, Aventurier j4, int niveauEauxDep) {
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
        this.niveauEaux = niveauEauxDep;
    }

    private boolean verifNbJoueurs() {
        if (this.joueurs.size() < 2) {
            return false;
        } else {
            return true;
        }
    }

    private boolean peutPrendreTresor(Aventurier j, TresorsEnum tresor) {
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

    private void prendreTresor(TresorsEnum tresor, Aventurier j) {
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
    private Aventurier getJoueur(String nom){
        Aventurier a = null;
        for(Aventurier j : joueurs){
            if(j.getNom()==nom){
                a = j;
            }
        }return a;
    }
    /*
    private void effectuerTour()
    {
        
        System.out.println("Action " + k);
        System.out.println("Que souhaitez-vous faire? (deplacer/assecher/donner une carte/special)");
        String action;
        Scanner repAction = new Scanner(System.in);
        action = repAction.nextLine();

        switch(action){
            case "deplacer":

            j.deplacement(grille);

            break;
            case "assecher" :
            j.assechement(grille);
            break;
            case "donner une carte":
                for (CartesTirage c : j.getCartesEnMain()){
                    System.out.println(c.getNom());
                }
                System.out.println("quelle carte voulez vous donnez ?");
                String x;
                Scanner repX = new Scanner(System.in);
                x = repX.nextLine();

                j.donnerCarteTresor(j.getCarte(x), j);
            break;
            case"Coup Special" : 
                for (CartesTirage c : j.getCartesEnMain()){
                    if(c instanceof CarteHelicoptere ||c.getNom()=="SacDeSable")
                        System.out.println(c.getNom());

                }

                System.out.println("quelle carte voulez vous utiliser?");
                String x1;
                Scanner repX1 = new Scanner(System.in);
                x1 = repX1.nextLine();


                switch(x1){
                    case"helicoptere" :
                        System.out.println("Combien de joueur voulez vous deplacer ? 1 , 2 , 3 ou 4");
                        String x2;
                        Scanner repX2 = new Scanner(System.in);
                        x2 = repX2.nextLine();
                        System.out.println("Sur quel tuile ?");
                        String x3;
                        Scanner repX3 = new Scanner(System.in);
                                x3 = repX3.nextLine();
                        switch(Integer.parseInt(x2)){
                            case 1 : 
                                System.out.println("Inscrivez un joueur");
                                String x13;
                                Scanner repX13 = new Scanner(System.in);
                                x13 = repX13.nextLine();
                                System.out.println("Sur quel tuile ?");
                                j.getCarte(x1).deplacer1Joueur(this.getJoueur(x13), x3,g);
                                break;
                            case 2 :
                                System.out.println("Inscrivez un joueur");
                                String x4;
                                Scanner repX4 = new Scanner(System.in);
                                x4 = repX4.nextLine();
                                System.out.println("Inscrivez un joueur");
                                String x5;
                                Scanner repX5 = new Scanner(System.in);
                                x5 = repX5.nextLine();
                                System.out.println("Sur quel tuile ?");
                                x3 = repX3.nextLine();
                                j.getCarte(x1).deplacer2Joueurs(this.getJoueur(x4), this.getJoueur(x5),x3, g);

                                break;  
                            case 3 : 
                                System.out.println("Inscrivez un joueur");
                                String x6;
                                Scanner repX6 = new Scanner(System.in);
                                x6 = repX6.nextLine();
                                System.out.println("Inscrivez un joueur");
                                String x7;
                                Scanner repX7 = new Scanner(System.in);
                                x7 = repX7.nextLine();
                                System.out.println("Inscrivez un joueur");
                                String x8;
                                Scanner repX8 = new Scanner(System.in);
                                x8 = repX8.nextLine();

                                 j.getCarte(x1).deplacer3Joueurs(this.getJoueur(x6),this.getJoueur(x7), this.getJoueur(x8),x3, g);
                                break;
                            case 4 : 
                                System.out.println("Inscrivez un joueur");
                                String x9;
                                Scanner repX9 = new Scanner(System.in);
                                x9 = repX9.nextLine();
                                System.out.println("Inscrivez un joueur");
                                String x10;
                                Scanner repX10 = new Scanner(System.in);
                                x10 = repX10.nextLine();
                                System.out.println("Inscrivez un joueur");
                                String x11;
                                Scanner repX11 = new Scanner(System.in);
                                x11 = repX11.nextLine();
                                System.out.println("Inscrivez un joueur");
                                String x12;
                                Scanner repX12 = new Scanner(System.in);
                                x12 = repX12.nextLine();
                                j.getCarte(x1).deplacer4Joueurs(this.getJoueur(x9),this.getJoueur(x10),this.getJoueur(x11),this.getJoueur(x12),x3,g);
                                break;  
                        }

                    }

                        j.enleverCarte(j.getCarte(x1));

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
    */
}

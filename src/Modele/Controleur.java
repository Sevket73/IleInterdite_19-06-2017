/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import Modele.Couleur;
import Grille.Etat;
import Cartes.Cartes;
import Grille.CoorD;
import Grille.Tuiles;
import Grille.Grille;
import Aventuriers.Aventurier;
import static Grille.Etat.Inondee;
import View.Message;
import View.Observateur;
import View.TypesMessages;
import View.VueGrille;
import View.VueMenu;
import View.VueRules;
import View.VueStatue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

/**
 *
 * @author chaulaic
 */
public class Controleur implements Observateur{
    private int niveauEaux;
    private ArrayList<Aventurier> joueurs;
    private Grille grille;
    private ArrayList<Cartes> cartes;
    
    
    private VueMenu vueMenu;
    private VueRules vueRules;
    private VueGrille vueGrille;
    private VueStatue vueStatue;
    
    private Observateur observateur;
    private Message message = new Message();
    
    
    public Controleur(int niveauEaux,Grille g) {
        this.niveauEaux = niveauEaux;
        this.joueurs = new ArrayList<>();
//        joueurs.add(j1);
//        joueurs.add(j2);
//        joueurs.add(j3);
//        joueurs.add(j4);
        this.grille = g;
        this.cartes = new ArrayList<>();
        
        vueMenu = new VueMenu();
        vueMenu.setObservateur(this);
        
        vueRules = new VueRules();
        vueRules.setObservateur(this);
        
        vueGrille = new VueGrille();
        vueGrille.setObservateur(this);
        
        vueStatue = new VueStatue();
        vueStatue.setObservateur(this);
        
        message.type = TypesMessages.MENU;
        this.click(message);
        
        
    }
    
    private void initJoueurs(){
        ArrayList<String> nomJoueurs = new ArrayList<>();
        nomJoueurs = vueMenu.getJoueur();
        
        this.joueurs.add(new Aventurier(nomJoueurs.get(1), true, 3, Couleur.Bleu));
        this.joueurs.add(new Aventurier(nomJoueurs.get(2), true, 3, Couleur.Rouge));
        this.joueurs.add(new Aventurier(nomJoueurs.get(3), true, 3, Couleur.Noir));
        this.joueurs.add(new Aventurier(nomJoueurs.get(0), true, 3, Couleur.Jaune));
    }
   
    private String listeTuile[]= {"","","LePontDesAbimes","LaPorteDeBronze","","",
                          "","LaCaverneDesOmbres","LaPorteDeFer","LaPorteDOr","LesFalaisesDeLOubli","",
                          "LePalaisDeCorail","LaPorteDArgent","LesDunesDeLIllusion","Heliport","LaPorteDeCuivre","LeJardinDesHurlements",
                          "LaForetPourpre","LeLagonPerdu","LeMaraisBrumeux","Observatoire","LeRocherFantome","LaCaverneDuBrasier",
                          "","LeTempleDuSoleil","LeTempleDeLaLune","LePalaisDesMarees","LeValDuCrepuscule","",
                          "","","LaTourDuGuet","LeJardinDesMurmures","",""};
    
    public void creerGrille(Grille g){

        for (int l = 0; l <= 5;l++) {
            for (int c = 0; c <= 5; c++) {
                if ((l==0 && (( c==0||c==1)||c==4||c==5))||(l==1&&c==0)||(l==1&&c==5)||((l==4&&c==0)||(l==4&&c==5))||(l==5 && (( c==0||c==1)||c==4||c==5))){
                    continue;
                    
                } else {

                    Tuiles t = new Tuiles(listeTuile[l*6 + c], new CoorD(c,l));

                    g.addTuiles((l*6 + c),t);
                    
                    if ((l==0 && c==3)||(l==3 && ((c==1||c==3)||c==5))||l==5 && c ==3){
                        g.getTuiles(l*6+c).changerEtat(Etat.Inondee);
                    }       
                    else if (c==2 && (((l==2 || l == 3 )|| l == 4) )){
                        g.getTuiles(l*6+c).changerEtat(Etat.coulee);  
                    }
                    
                    if (l==0 && c==3 ){
                         g.getTuiles(l*6+c).changerCouleur(Couleur.Rouge);
                    }
                    else if (l==1&&c == 2){
                          g.getTuiles(l*6+c).changerCouleur(Couleur.Noir);  
                    } 
                    else if (l==1&& c == 3){
                          g.getTuiles(l*6+c).changerCouleur(Couleur.Jaune);  
                    } 
                    else if (l==2&& c == 1){
                          g.getTuiles(l*6+c).changerCouleur(Couleur.Orange);  
                    }
                    else if (l==2&& c == 3){
                          g.getTuiles(l*6+c).changerCouleur(Couleur.Bleu);  
                    }
                    else if (l==2 && c == 4){
                          g.getTuiles(l*6+c).changerCouleur(Couleur.Vert);  
                    }
                 }           
            }
        }
        
    }  
    public void jouer(Aventurier j, Grille g) {
        System.out.println(j.getNom() + " à vous de jouer!");
        System.out.println("");
        String passez;
        System.out.println("Vous êtes sur la tuile : " + g.getNomTuiles(j.getPositionCourante().getCoordonnée().getLigne(),j.getPositionCourante().getCoordonnée().getColonne()));
        
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
                    j.deplacement(g);           
                    
                } else if (action.equals("assecher")) {
                    j.assechement(grille);
                }

                if (k==3) {
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
        }
    }

    @Override
    public void click(Message message) {
        
        Grille grille = new Grille();
        
        switch (message.type) {
            case RULES : 
                vueRules.afficher();
                vueMenu.fermer();
                break;
            case MENU :
                vueMenu.afficher();
                vueRules.fermer();
                break;
            case GRID :
                initJoueurs();
                this.creerGrille(grille);
                grille.getAze();
                
                vueGrille.afficher();
                vueStatue.afficher();
                vueMenu.fermer();
                
                
        }
    }
}
          


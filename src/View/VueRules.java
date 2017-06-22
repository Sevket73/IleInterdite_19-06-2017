/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author cault
 */




public class VueRules extends javax.swing.JFrame{

    
    private final JFrame window;
    private final JPanel mainPanel;
    private final JPanel middlePanel;
    //private final JPanel titlePanel;
    //private final JPanel southPanel;
    
    private final JTextArea display;
    private final JScrollPane scroll;
    
    private final JButton resume;
    
    private Observateur observateur;
    
    /**
     */
    public VueRules() {
        window = new JFrame();
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation(dim.width/2-window.getSize().width/2,dim.height/2-window.getSize().height/2);
        
        
        this.window.setTitle("Règle du jeu L'ile interdite");
        
        mainPanel = new JPanel(new BorderLayout());
        this.window.add(mainPanel);
        
            mainPanel.add(new JLabel("Regles du jeu"), BorderLayout.NORTH);
            resume = new JButton("retour");
            mainPanel.add(resume, BorderLayout.SOUTH);
            
            
            middlePanel = new JPanel();
            
            mainPanel.add(middlePanel, BorderLayout.CENTER);
            middlePanel.setBorder(new TitledBorder(new EtchedBorder(), "Regles"));

    // create the middle panel components

            display = new JTextArea("Île Interdite était le cœur mystique\n" +
"de l’ancien empire des Atlantes.\n" +
"La légende raconte qu’ils avaient\n" +
"le pouvoir de contrôler les quatre éléments – le feu,\n" +
"le vent, l’eau et la terre – au moyen de trésors à la\n" +
"valeur inestimable : le Cristal ardent, la Statue\n" +
"du zéphyr, le Calice de l’onde et la Pierre sacrée.\n" +
"Ainsi, les Atlantes gardaient les trésors cachés\n" +
"sur l’Île Interdite qui était conçue pour s’enfoncer\n" +
"dans les flots si des intrus y mettaient les pieds.\n" +
"Durant les longs siècles qui nous séparent\n" +
"de la mystérieuse disparition de leur empire,\n" +
"l’Île Interdite demeurait introuvable…\n" +
"jusqu’à aujourd’hui.\n" +
"Votre équipe sera-t-elle la première à y ouvrir une\n" +
"brèche, prendre les trésors et en sortir en vie ?\n\n"+
                    "Materiel\n" +
"58 cartes réparties comme suit :\n" +
"28 cartes Trésor (dos orange)\n" +
"5 pour chacun des 4 trésors\n" +
"3 cartes Montée des eaux\n" +
"3 cartes Hélicoptère\n" +
"2 cartes Sacs de sable\n" +
"24 cartes Inondation (dos bleu)\n" +
"6 cartes Aventurier\n" +
"24 tuiles Île réversibles\n" +
"6 pions en bois\n" +
"4 figurines Trésor :\n" +
"Le Cristal ardent\n" +
"La Statue du zéphyr\n" +
"Le Calice de l’onde\n" +
"La Pierre sacrée\n" +
"1 échelle graduée\n" +
"1 Marqueur de niveau \n\n"+
                    "But du jeu\n" +
"Votre équipe d’aventuriers doit travailler collectivement pour éviter que l’Île Interdite ne\n" +
"sombre trop rapidement, afin d’avoir suffisamment de temps pour prendre les quatre trésors.\n" +
"Une fois ceux-ci récupérés, vous devez vous rendre à l’héliport et vous échapper par hélicoptère\n" +
"pour gagner. Mais, si l’île sombre avant que vous n’ayez tout accompli, la mission se solde par\n" +
"un échec !\n" +
"Installation\n" +
"1. Creer l'ile Interdite : Mélangez les 24 tuiles Île et placez-les visibles\n" +
"(pas du côté bleu et blanc) dans la configuration suivante : faites d’abord un carré de 4x4 au\n" +
"centre de la table, placez ensuite 2 tuiles près des 2 tuiles du milieu de chaque côté du carré.\n" +
"NB : laissez un léger espace entre les tuiles.\n" +
"2. Placer les Tresors : Placez les 4 figurines Trésor – le Cristal ardent, la\n" +
"Statue du zéphyr, le Calice de l’onde et la Pierre sacrée – autour de l’Île. Votre équipe essayera\n" +
"de récupérer ces trésors pendant le jeu en défaussant 4 cartes Trésor identiques sur la tuile\n" +
"Île correspondante. Prenez un moment pour localiser les 8 tuiles sur lesquels vous pourrez\n" +
"gagner les trésors. Chaque trésor peut être récupéré sur l’une des deux tuiles qui ont le symbole\n" +
"correspondant dans leur coin inférieur gauche.\n" +
"Défausse\n" +
"des cartes\n" +
"Trésor\n" +
"Défausse\n" +
"des cartes\n" +
"Inondation\n" +
"La Pierre sacrée La Statue du zéphyr Le Cristal ardent Le Calice de l’onde\n" +
"- Mise en place -\n" +
"2\n" +
"2\n" +
"3\n" +
"4\n" +
"5\n" +
"Legendaire\n" +
"Elite\n" +
"Normal\n" +
"Novice\n" +
"3. Separer les cartes : Séparez les cartes en trois piles correspondant à\n" +
"chacun des dos : pile Inondation (dos bleu), pile Trésor (dos orange), et cartes Aventurier (6 cartes).\n" +
"4. L'Ile commence a sombrer : Mélangez la pile Inondation et placezla\n" +
"face cachée à côté de l’Île. Tirez les 6 premières cartes (une par une) et empilez-les faces\n" +
"visibles à côté du paquet de cartes Inondation pour constituer la défausse. Pour chaque carte\n" +
"tirée, retournez la tuile Île correspondante du côté « inondé » (dos bleu et blanc).\n" +
"5. Les aventuriers debarquent :\n" +
"Mélangez les 6 cartes Aventurier et distribuez-en 1 au hasard\n" +
"à chacun des joueurs. Chacun d’entre vous va incarner un\n" +
"aventurier doté d’un pouvoir spécial qui lui est propre. Prenez\n" +
"un moment pour lire à voix haute vos rôles et pouvoirs écrits au\n" +
"dos des cartes pour que vos partenaires connaissent vos atouts.\n" +
"Il sera plus facile de gagner si vous coopérez et tirez profit de\n" +
"ces pouvoirs spéciaux.\n" +
"Prenez le pion de la couleur de votre carte Aventurier et placez-le sur la tuile Île\n" +
"correspondante : cherchez l’icône correspondant au pion dans le coin des tuiles\n" +
"« Porte » et de la tuile « l’héliport ». Rangez dans la boîte les cartes Aventurier et\n" +
"les pions non utilisés. NB : il est possible de démarrer sur une tuile inondée.\n" +
"6. Distribuer les cartes Tresor :\n" +
"Mélangez la pile de cartes Trésor et distribuez 2 cartes à chacun\n" +
"des joueurs. Placez vos cartes faces visibles devant vous afin\n" +
"que vous et vos partenaires les voient. Si quelqu’un reçoit une\n" +
"carte Montée des eaux, donnez-lui une autre carte, remettez la\n" +
"carte Montée des eaux dans la pile et mélangez-la à nouveau.\n" +
"Placez la pile Trésor face cachée à côté de l’Île.\n" +
"NB : il y aura une défausse de cartes Trésor à côté de la pile Trésor.\n" +
"7. Determiner le niveau d'eau : Placez le\n" +
"Marqueur de niveau du côté gauche de l’Échelle graduée et placez-le suivant\n" +
"le niveau de difficulté désiré (par exemple, si c’est la première fois que vous\n" +
"jouez à un jeu coopératif, mettez-le sur Novice).\n" +
"Tuile côté normal Tuile côté inondé\n" +
"Pile Inondation Pile Trésor Pile Aventurier\n" +
"Observatoire\n" +
"Observatoire Observatoire\n" +
"2\n" +
"3\n" +
"4\n" +
"5\n" +
"Legendaire\n" +
"Elite\n" +
"Normal\n" +
"Novice\n" +
"3\n" +
"Carte Inondation\n" +
"NB : vous pouvez regarder à tout moment les cartes Trésor et Inondation défaussées.\n" +
"Tour de jeu\n" +
"Le joueur qui a visité une île le plus récemment commence. Jouez ensuite\n" +
"dans le sens des aiguilles d’une montre. À chaque tour, réalisez les trois\n" +
"choses suivantes dans l’ordre :\n" +
"1. Faites jusqu’à 3 actions.\n" +
"2. Tirez 2 cartes Trésor.\n" +
"3. Tirez un nombre de cartes Inondation égal au niveau d’eau.\n" +
"Le détail de chaque tour est décrit plus loin. Notez que chaque carte\n" +
"Aventurier contient aussi une aide de jeu.\n" +
"1. Faire jusqu'a 3 actions\n" +
"À chaque tour, vous pouvez faire jusqu’à 3 actions (cela peut être aussi 0, 1 ou 2). Vos\n" +
"partenaires sont autorisés (et encouragés !) à vous conseiller sur les meilleures actions possibles\n" +
"pendant votre tour. Choisissez une combinaison parmi les 4 actions suivantes :\n" +
"• Se déplacer\n" +
"• Assécher\n" +
"• Donner une carte Trésor\n" +
"• Gagner un Trésor\n" +
"Se deplacer\n" +
"Vous pouvez, pour 1 ou plusieurs actions, déplacer votre pion sur une tuile\n" +
"Île adjacente : en haut, en bas, à gauche, à droite mais pas diagonalement.\n" +
"Vous pouvez aller sur une tuile inondée, mais vous ne pouvez pas aller sur\n" +
"(ou à travers) l’emplacement d’une tuile manquante.\n" +
"Exceptions:\n" +
"L’Explorateur peut se déplacer diagonalement.\n" +
"Le Pilote peut aller une fois par tour sur n’importe quelle tuile pour 1 action.\n" +
"Le Navigateur peut déplacer d’autres joueurs d’1 ou 2 cases adjacentes par action.\n" +
"Le Plongeur peut se déplacer au travers d’une ou plusieurs tuiles adjacentes\n" +
"manquantes et/ou inondées pour 1 action (pas forcément en ligne droite).\n" +
"Assecher\n" +
"Vous pouvez, pour 1 ou plusieurs actions, assécher n’importe quelle tuile\n" +
"Île adjacente (en haut, en bas, à gauche, à droite), ou celle sur laquelle se\n" +
"trouve votre pion. Pour assécher une tuile, retournez-la simplement pour\n" +
"qu’apparaisse son côté non inondé.\n" +
"Exceptions:\n" +
" L’Ingénieur peut assécher 2 tuiles pour 1 action.\n" +
" L’Explorateur peut assécher des tuiles diagonalement.\n" +
"4\n" +
"Donner une carte Tresor\n" +
"Vous pouvez donner 1 ou plusieurs cartes Trésor à un\n" +
"autre joueur si vos deux pions sont sur la même tuile.\n" +
"Cela coûte 1 action pour chaque carte que vous donnez\n" +
"(voir le paragraphe « Nombre maximal de cartes » pour\n" +
"les restrictions). Vous ne pouvez pas donner de cartes\n" +
"Action Spéciale (Hélicoptère et Sacs de sable).\n" +
"Exception:\n" +
" Le Messager peut donner des cartes Trésor sans être sur la même tuile.\n" +
"Gagner un Tresor\n" +
"Vous pouvez, pour 1 action, gagner un trésor en défaussant de votre main 4 cartes Trésor\n" +
"identiques, à condition que votre pion soit sur la tuile Île correspondante :\n" +
"NB :\n" +
"• Quand vous récupérez un trésor, défaussez les cartes dans la pile de défausse des cartes\n" +
"Trésor et prenez la figurine correspondante devant vous.\n" +
"• Vous pouvez gagner un trésor sur une tuile inondée.\n" +
"Cartes défaussées Pion sur une tuile Île correspondante Trésor gagné\n" +
"-OU-\n" +
"-OU-\n" +
"-OU-\n" +
"-OU-\n" +
"5\n" +
"2. Tirer 2 cartes Tresor\n" +
"Après avoir fait vos actions, vous devez tirer 2 cartes dans la pile Trésor et les poser devant vous\n" +
"faces visibles. Tirez les cartes une par une. Si vous tirez une carte Montée des eaux, ne la mettez\n" +
"pas devant vous, mais suivez ses instructions et défaussez-la dans la défausse de cartes Trésor.\n" +
"Cartes Tresor\n" +
"Chacun des 4 trésors est représenté par 5 cartes correspondantes.\n" +
"L’objectif est de rassembler 4 cartes Trésor identiques pour récupérer le\n" +
"trésor correspondant de l’Île Interdite. Vous pouvez donner des cartes\n" +
"Trésor aux autres joueurs en utilisant l’action « Donner une carte Trésor ».\n" +
"Cartes Action Speciale\n" +
"Il y a 2 types de cartes Action Spéciale dans la pile Trésor - Hélicoptère\n" +
"(3 cartes) et Sacs de Sable (2 cartes) – qui aideront votre équipe pendant\n" +
"la partie. Gardez ces cartes devant vous, elles peuvent être jouées quand\n" +
"vous le souhaitez, même lors du tour d’un autre joueur. Jouer une carte\n" +
"Action Spéciale ne coûte pas d’action. Défaussez les cartes dans la pile\n" +
"de défausse des cartes Trésor immédiatement après les avoir jouées.\n" +
"NB : vous pouvez utiliser le pouvoir d’une carte Action Spéciale si\n" +
"vous êtes forcé de vous en débarrasser.\n" +
"Carte Montee des eaux\n" +
"Il y a 3 cartes Montée des eaux dans la pile de cartes Trésor. Quand vous tirez une\n" +
"carte Montée des eaux, vous devez immédiatement réaliser les 3 actions suivantes :\n" +
"1. Montez le Marqueur de niveau d’un cran sur l’Échelle graduée.\n" +
"Notez combien de cartes seront tirées à la fin de votre tour en\n" +
"regardant le chiffre à droite du marqueur.\n" +
"2. Prenez toutes les cartes Inondation défaussées, mélangez-les et\n" +
"placez-les faces cachées sur la pile de cartes Inondation. Cela signifie\n" +
"que les cartes précédemment tirées vont bientôt être tirées à nouveau !\n" +
"3. Défaussez la carte Montée des eaux dans la pile de défausse\n" +
"des cartes Trésor.\n" +
"NB :\n" +
"• Si vous tirez une carte Montée des eaux, vous ne recevez pas de carte de remplacement.\n" +
"• Si vous tirez 2 cartes Montée des eaux, mélangez une seule fois la défausse des cartes\n" +
"Inondation mais montez le Marqueur de niveau de 2 crans.\n" +
"• Si vous tirez une carte Montée des eaux mais qu’il n’y a pas de carte dans la pile de\n" +
"défausse des cartes Inondation, montez simplement le Marqueur de niveau d’1 cran.\n" +
"2\n" +
"3\n" +
"4\n" +
"5\n" +
"Legendaire\n" +
"Elite\n" +
"Normal\n" +
"Novice\n" +
"6\n" +
"Quand il n'y a plus de cartes dans la pile Tresor\n" +
"Quand la dernière carte de la pile Trésor est tirée, mélangez immédiatement la défausse puis\n" +
"retournez-la face cachée afin de former une nouvelle pile de cartes Trésor.\n" +
"Nombre maximal de cartes\n" +
"Vous ne pouvez avoir devant vous que 5 cartes. Si vous constatez que vous avez 6 cartes ou\n" +
"plus (par exemple parce que vous avez tiré plus de cartes ou reçu des cartes d’un autre joueur),\n" +
"vous devez immédiatement choisir et défausser le surplus. Si vous avez choisi de défausser une\n" +
"carte Action Spéciale, vous pouvez utiliser son action avant de la défausser.\n" +
"3. Tirer des cartes Inondation\n" +
"Après avoir tiré 2 cartes Trésor, vous devez maintenant jouer le rôle de l’Île\n" +
"Interdite ! Tirez un nombre de cartes Inondation correspondant au chiffre\n" +
"indiqué par le Marqueur de niveau de l’Échelle graduée. Par exemple, si l’Échelle\n" +
"graduée indique 2, tirez 2 cartes. Tirez les cartes une par une et placez-les faces\n" +
"visibles dans la défausse des cartes Inondation. Pour chaque carte tirée, trouvez\n" +
"la tuile Île correspondante et agissez comme suit :\n" +
" • Si la tuile Île correspondante n’est pas inondée, retournez-la du côté inondé.\n" +
"• Si la tuile Île correspondante est inondée, elle sombre dans l’abysse !\n" +
"Retirez-la du jeu avec la carte Inondation correspondante.\n" +
"NB : on ne peut pas assécher une tuile qui a été retirée du jeu.\n" +
"Pions sur des tuiles inondees\n" +
"Si un pion est sur une tuile qui va être inondée, retirez-le de la tuile, puis retournez la tuile\n" +
"avant de le reposer dessus.\n" +
"Si un pion est sur une tuile qui va être enlevée, il doit immédiatement « nager » vers une tuile,\n" +
"même inondée, adjacente (en haut, en bas, à gauche, à droite). Si un pion est sur une tuile qui est\n" +
"enlevée et ne trouve pas de tuile adjacente, il plonge dans l’abysse et tout le monde perd la partie.\n" +
"Exceptions :\n" +
"Le Plongeur peut nager vers la tuile la plus proche. L’Explorateur peut nager diagonalement.\n" +
"Le Pilote peut voler et aller sur n’importe quelle tuile.\n" +
"à retirer\n" +
"-Avant- -AprèsRetiré\n" +
"du jeu\n" +
"7\n" +
"Carte Inondation tuile normale tuile inondée\n" +
"2\n" +
"3\n" +
"4\n" +
"5\n" +
"Legendaire\n" +
"Elite\n" +
"Normal\n" +
"Novice\n" +
"Quand il n'y a plus de cartes dans la pile Inondation\n" +
"S’il n’y a plus de cartes dans la pile Inondation, mélangez immédiatement la défausse des\n" +
"cartes Inondation et placez-la face cachée pour former une nouvelle pile de cartes Inondation.\n" +
"Si cela se produit au milieu d’un tour, continuez à tirer autant de cartes Inondation que\n" +
"nécessaire dans la nouvelle pile.\n" +
"Fin du jeu\n" +
"Gagner la partie\n" +
"Allez à l’Héliport ! Une fois que vous avez récupéré les quatre\n" +
"trésors, chacun doit déplacer son pion jusqu’à la tuile « l’héliport ».\n" +
"Ensuite, l’un des joueurs doit défausser une carte Hélicoptère pour\n" +
"que votre équipe décolle de l’Île Interdite et gagne !\n" +
"NB : vous pouvez gagner même si la tuile « l’héliport » est inondée.\n" +
"Perdre la partie\n" +
"Il y a quatre manières de perdre :\n" +
"1. Si les 2 tuiles « Temple », « Caverne », « Palais» ou « Jardin » (sur lesquelles sont placés les\n" +
"symboles des trésors) sombrent avant que vous n’ayez pris leurs trésors respectifs ;\n" +
"2. Si « l’héliport » sombre ;\n" +
"3. Si un joueur est sur une tuile Île qui sombre et qu’i",40,40);
            display.setEditable(false); // set textArea non-editable
            scroll = new JScrollPane(display);
            scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

            //Add Textarea in to middle panel
            middlePanel.add(scroll);
            
            resume.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Message m = new Message();
                m.type=TypesMessages.MENU;
                
                observateur.click(m);
            }
        });
            

}
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        //VueRules rules = new VueRules();
    }
    
    public void afficher(){
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        window.setSize(500, 780);
        window.setVisible(true);
    }
    
    public void setObservateur(Observateur  observateur){
        this.observateur = observateur;
    }
    
    public void fermer(){
        window.setVisible(false);
        
    }
}

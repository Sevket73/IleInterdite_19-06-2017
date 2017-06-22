/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Utile.Pion;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
//import javafx.scene.paint.Color;
import javax.swing.Action;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

/**
 *
 * @author cault
 */
public class VueMenu extends javax.swing.JFrame {

    /**
     * @param args the command line arguments
     */
    
    private Observateur observateur;
    
    private final JFrame window;
    private final JPanel mainPanel;
    private final JPanel titlePanel;
    private final JPanel registerPanel;
    private final JPanel registerGrid;
    private final JPanel southBorderPanel;
    
    private final JTextField joueur1;
    private final JTextField joueur2;
    private final JTextField joueur3;
    private final JTextField joueur4;
//    private final JTextField joueur5;
//    private final JTextField joueur6;
    
    private final JButton go;
    private final JButton rules;
    
    private boolean clicked = false;
    
    public VueMenu() {
        this.window = new JFrame();
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation(dim.width/2-window.getSize().width/2,dim.height/2-window.getSize().height/2);
        
        
        this.window.setTitle("l'ile interdite");
        
        mainPanel = new JPanel(new BorderLayout());
        this.window.add(mainPanel);
        
        titlePanel = new JPanel( );
        titlePanel.setBorder(BorderFactory.createLineBorder(java.awt.Color.darkGray));
        
        
            mainPanel.add(titlePanel , BorderLayout.NORTH);
            JLabel title = new JLabel("l'ile interdite");
            title.setFont(new Font("Serif",Font.BOLD, 25));
            titlePanel.add(title);
         
        registerPanel = new JPanel();
        
            mainPanel.add(registerPanel, BorderLayout.CENTER);
            
            registerGrid = new JPanel(new GridLayout(4,2));
            
                registerPanel.add(registerGrid);
                
                registerGrid.add(new JLabel("Joueur 1 : "));
                joueur1 = new JTextField("");
                registerGrid.add(joueur1);
                registerGrid.add(new JLabel("Joueur 2 : "));
                joueur2 = new JTextField("");
                registerGrid.add(joueur2);
                registerGrid.add(new JLabel("Joueur 3 : "));
                joueur3 = new JTextField("");
                registerGrid.add(joueur3);
                registerGrid.add(new JLabel("Joueur 4 : "));
                joueur4 = new JTextField("");
                registerGrid.add(joueur4);
//                registerGrid.add(new JLabel("Joueur 5 : "));
//                joueur5 = new JTextField("");
//                registerGrid.add(joueur5);
//                registerGrid.add(new JLabel("Joueur 6 : "));
//                joueur6 = new JTextField("");
//                registerGrid.add(joueur6);
                
        southBorderPanel = new JPanel();  
        
            mainPanel.add(southBorderPanel, BorderLayout.SOUTH);
            go = new JButton("Lets go !");
            rules = new JButton("show rules");
            
            southBorderPanel.add(go);
            southBorderPanel.add(rules);
            
            
        
            
        
        rules.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent me) {
                Message m = new Message();
                m.type = TypesMessages.RULES;
                
                observateur.click(m);
            }

            @Override
            public void mousePressed(MouseEvent me) {
            }

            @Override
            public void mouseReleased(MouseEvent me) {
            }

            @Override
            public void mouseEntered(MouseEvent me) {
            }

            @Override
            public void mouseExited(MouseEvent me) {
            }
            
            
        });
        
        go.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Message m = new Message();
                m.type = TypesMessages.GRID;
                
                observateur.click(m);

            }
        });
        
    }
    
    
//    public static void main(String[] args) {
//        
//       // VueMenu debutJeu = new VueMenu();
//        
//        
//    }

    public ArrayList getJoueur() {
        ArrayList<String> joueurs = new ArrayList<>();
        joueurs.add(this.joueur1.getText());
        joueurs.add(this.joueur2.getText());
        joueurs.add(this.joueur3.getText());
        joueurs.add(this.joueur4.getText());
        return joueurs;
    }
    public void setObservateur(Observateur  observateur){
        this.observateur = observateur;
    }

    public void afficher(){
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        window.setSize(400, 300);
        window.setVisible(true);
    }
    
    public void fermer(){
        window.setVisible(false);
        
    }
}

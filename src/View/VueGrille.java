/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author cault
 */
public class VueGrille extends javax.swing.JFrame{

    /**
     * @param args the command line arguments
     */
    private final JFrame window;
    private final JPanel mainPanel;
    
    private Observateur observateur;

    
    public VueGrille(){
        this.window = new JFrame();
        
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        

        window.setLocation(dim.width/7*3-window.getSize().width/2,dim.height/7*3-window.getSize().height/2);
        
        
        this.window.setTitle("l'ile interdite");
        
        mainPanel = new JPanel(new GridLayout(6,6));
        window.add(mainPanel);
        for(int i = 0 ; i<36 ; i++){
            mainPanel.add(new JLabel("empty"));
        }
    }
    
    
    public void setObservateur(Observateur  observateur){
        this.observateur = observateur;
    }

    public void afficher(){
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        window.setSize(dim.width/7*6, dim.height/7*6);
        window.setVisible(true);
    }
    
    public void fermer(){
        window.setVisible(false);
        
    }
    
    public void creeGrille(){
        
    }
    
}

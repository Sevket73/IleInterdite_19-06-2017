/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

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
public class VueStatue extends javax.swing.JFrame {

    /**
     * @param args the command line arguments
     */
    private static JFrame window;
    private static JPanel mainPanel;
    
    
    
    public VueStatue(){
        this.window = new JFrame();
        window.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        window.setSize(dim.width/7*6, dim.height/7*1);
        window.setLocation(dim.width/7*3-window.getSize().width/2,dim.height/18*17-window.getSize().height/2);
        
        window.setVisible(true);
        
        mainPanel = new JPanel(new GridLayout(1,6));
        mainPanel.add(new JLabel("Niveau Eaux"));
        mainPanel.add(new JLabel("empty"));
        mainPanel.add(new JLabel("Etat tresor1"));
        mainPanel.add(new JLabel("Etat tresor2"));
        mainPanel.add(new JLabel("Etat tresor3"));
        mainPanel.add(new JLabel("Etat tresor4"));
        
        window.add(mainPanel);
    }
        
    public static void main(String[] args) {
        VueStatue statue = new VueStatue();
        
        
    }
    
}

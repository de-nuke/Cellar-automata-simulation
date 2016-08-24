/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.additionalPanelComponents;

import GUI.ControlledPanel;
import GUI.PanelsControl;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Dom
 */
public class Switching extends JPanel implements MouseListener, ControlledPanel {
    PanelsControl control;
    private JLabel switchText = new JLabel("Automaton:");
    private JLabel automatonText1 = new JLabel("GAME OF LIFE");
    private JLabel automatonText2 = new JLabel("WIREWORLD");
    private JLabel switchIcon = new JLabel();
    
    private ImageIcon state1;
    private ImageIcon state2;
    
    private Boolean wireworld;
    
    private Color background;
    
    private int pWidth;
    private int pHeight;
    
    public Switching(Color background, int w, int h) throws IOException {
        
        pHeight = h;
        pWidth = w;
        
        setLayout(new FlowLayout());
        Image img1 = ImageIO.read((this.getClass().getResource("state1.png")));
        Image img2 = ImageIO.read((this.getClass().getResource("state2.png")));
        
        wireworld = false;
        
        state1 = new ImageIcon(img1);
        state2 = new ImageIcon(img2);
        
        switchIcon.setIcon(state1);
        switchIcon.addMouseListener(this);
        this.background = background;
        
        automatonText1.setBackground(background);
        automatonText1.setForeground(Color.GRAY);
        automatonText2.setForeground(Color.BLACK);
        automatonText2.setBackground(Color.GREEN);
        automatonText1.setOpaque(true);
        automatonText2.setOpaque(true);
        
        add(switchText);
        add(automatonText2);
        add(switchIcon);
        add(automatonText1);
    }
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(pWidth, pHeight);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
        control.reset();
        control.switchGame();
        if(wireworld == true) {
            switchIcon.setIcon(state2);
            wireworld = false;
            automatonText1.setBackground(background);
            automatonText1.setForeground(Color.GRAY);
            automatonText2.setBackground(Color.green);
            automatonText2.setForeground(Color.BLACK);
            
        }
        else {
            switchIcon.setIcon(state1);
            wireworld = true;
            automatonText2.setBackground(background);
            automatonText2.setForeground(Color.GRAY);
            automatonText1.setBackground(Color.green);
            automatonText1.setForeground(Color.BLACK);
        }
            
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void setControl(PanelsControl control) {
        this.control = control;
    }
}

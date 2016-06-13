/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static GUI.MyDimensions.BIG_BTN;
import static GUI.MyDimensions.SMALL_BTN;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.*;

/**
 *
 * @author Dom
 */
public class RestartPanel extends JPanel {
    
    int pWidth;
    int pHeight;
    
    JButton reset = new JButton("Reset");
    JButton quit = new JButton("Quit");
    JButton apply = new JButton("Apply");
    JLabel n = new JLabel("n =  ");
    JTextField tf = new JTextField("n");
    
    
    public RestartPanel(int w, int h) {
        pWidth = w;
        pHeight = h;
        
        setLayout(new FlowLayout(FlowLayout.CENTER, 5, 10));
        
        reset.setPreferredSize(SMALL_BTN);
        quit.setPreferredSize(SMALL_BTN);
        apply.setPreferredSize(SMALL_BTN);
        tf.setPreferredSize(SMALL_BTN);
        tf.setToolTipText("Type expected number of generations here");
        n.setPreferredSize(new Dimension(BIG_BTN.width, SMALL_BTN.height *2  + 10));
        
        add(n);
        add(tf);
        add(apply);
        add(reset);
        add(quit);
    }
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(pWidth, pHeight);
    }
}

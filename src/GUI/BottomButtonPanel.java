/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

/**
 *
 * @author Dom
 */
public class BottomButtonPanel extends JPanel {
    
    int pWidth;
    int pHeight;
    
    public BottomButtonPanel(int w, int h, Color c) {
        this.pHeight = h;
        this.pWidth = w;
        setBackground(c);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(pWidth, pHeight);
    }
}

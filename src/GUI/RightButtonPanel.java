/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static GUI.MyDimensions.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Dom
 */
class RightButtonPanel extends JPanel {
    
    int pWidth;
    int pHeight;
    JButton play = new JButton("Play/Stop");
    JButton singleStep = new JButton("Single Step");
    JButton faster = new JButton("Faster");
    JButton slower = new JButton("Slower");
    JButton loadFile = new JButton("Load file");
    JButton settings = new JButton("Settings");
    JButton restart = new JButton("Restart");
    
    public RightButtonPanel(int w, int h, Color c) {
        this.pHeight = h;
        this.pWidth = w;
        setBackground(c);
        setLayout(new GridBagLayout());
        
        JPanel p1 = new JPanel(new FlowLayout());
        p1.setPreferredSize(new Dimension(270, 184));
        play.setPreferredSize(BIG_BTN);
        p1.add(play);
        singleStep.setPreferredSize(BIG_BTN);
        p1.add(singleStep);
        
        JPanel p2 = new JPanel(new FlowLayout());
        p2.setPreferredSize(new Dimension(270, 60));
        faster.setPreferredSize(SMALL_BTN);
        p2.add(faster);
        slower.setPreferredSize(SMALL_BTN);
        p2.add(slower);
        
        
        JPanel p3 = new JPanel(new FlowLayout());
        p3.setPreferredSize(new Dimension(270, 184));
        loadFile.setPreferredSize(BIG_BTN);
        p3.add(loadFile);
        settings.setPreferredSize(BIG_BTN);
        p3.add(settings);
        
        //add(restart);
        GridBagConstraints con = new GridBagConstraints();
        con.fill = GridBagConstraints.HORIZONTAL;
        con.gridy = 0;
        con.gridx = 0;
        add(p1,con);
        con.gridy = 1;
        con.gridx = 0;
        add(p2,con);
        con.gridy = 2;
        con.gridx = 0;
        add(p3,con);
//     
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(pWidth, pHeight);
    }
}

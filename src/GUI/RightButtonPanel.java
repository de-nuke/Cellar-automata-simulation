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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JPanel;
/**
 *
 * @author Dom
 */
public class RightButtonPanel extends JPanel implements ActionListener{
    PanelsControl control;
    
    int pWidth;
    int pHeight;
    JButton play = new JButton("Play/Stop");
    JButton singleStep = new JButton("Single Step");
    JButton faster = new JButton("Faster");
    JButton slower = new JButton("Slower");
    JButton loadFile = new JButton("Load file");
    JButton settings = new JButton("Settings");
    JButton restart = new JButton("Restart");
    SettingsWindow s;
    
    File f;
    
    public RightButtonPanel(int w, int h) {
        this.pHeight = h;
        this.pWidth = w;
        setLayout(new GridBagLayout());
        
        JPanel p1 = new JPanel(new FlowLayout());
        JPanel p2 = new JPanel(new FlowLayout());
        JPanel p3 = new JPanel(new FlowLayout());
        
        p1.setPreferredSize(new Dimension(270, 184));
        p2.setPreferredSize(new Dimension(270, 60));
        p3.setPreferredSize(new Dimension(270, 184));
        
        play.setPreferredSize(BIG_BTN);
        play.addActionListener(this);
        singleStep.setPreferredSize(BIG_BTN);
        singleStep.addActionListener(this);
        faster.setPreferredSize(SMALL_BTN);
        faster.addActionListener(this);
        slower.setPreferredSize(SMALL_BTN);
        slower.addActionListener(this);
        loadFile.setPreferredSize(BIG_BTN);
        loadFile.addActionListener(this);
        settings.setPreferredSize(BIG_BTN);
        settings.addActionListener(this);
        
        
        p1.add(play);
        p1.add(singleStep);
        p2.add(faster);
        p2.add(slower);
        p3.add(loadFile);
        p3.add(settings);
        
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
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        
        if(btn == loadFile)
            try {
                control.loadFile();
            } catch (IOException ex) {
                System.out.println("WRONG FILE");
            }
        if(btn == singleStep) 
            control.singleStep();
        if(btn == play)
            control.play();
        if(btn == faster) {
            control.faster();
        }
        if(btn == slower)
            control.slower();
        if(btn == settings)
            s.setVisible(true);
    }
    
    public void setControl(PanelsControl c) {
        this.control = c;
    }
    
    public void connectWithSettingsWindow(SettingsWindow s) {
        this.s = s;
    }
}

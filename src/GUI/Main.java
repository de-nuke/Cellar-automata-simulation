/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package GUI;

import static GUI.MyDimensions.*; //zawiera stałe rozmiaru np, RBP_WIDTH
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.IOException;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import ww.Settings;

/**
 *
 * @author Dom
 */
public class Main {
 
    public static void main(String[] args) throws IOException {
        EventQueue.invokeLater(new Runnable() {
            Settings settings = new Settings();
            WireWorldMainWindow m;
            RightButtonPanel  rbp = new RightButtonPanel(RBP_WIDTH,RBP_HEIGHT,Color.red);
            BoardPanel bp = new BoardPanel(BP_WIDTH,BP_HEIGHT,Color.gray, settings);
            BottomButtonPanel bbp = new BottomButtonPanel(BBP_WIDTH, BBP_HEIGHT,Color.green);
            PanelsControl control = new PanelsControl();
            @Override
            public void run() {
                rbp.setControl(control);
                bp.setControl(control);
                bbp.setControl(control);
                
                control.setBoardPanel(bp);
                control.setBottomButtonPanel(bbp);
                control.setRightButtonPanel(rbp);
                
                m = new WireWorldMainWindow();
                m.setLayout(new GridBagLayout());
                GridBagConstraints c = new GridBagConstraints();
                c.gridy = 0;
                c.gridx = 0;
                m.add(rbp,c);
                c.gridy = 0;
                c.gridx = 1;
                m.add(bp,c);
                c.gridy = 1;
                c.gridx = 1;
                m.add(bbp,c);
            }
        });
    }
}

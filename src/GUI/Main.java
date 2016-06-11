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
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

/**
 *
 * @author Dom
 */
public class Main {
 
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            WireWorldMainWindow m;
            JPanel rbp = new RightButtonPanel(RBP_WIDTH,RBP_HEIGHT,Color.red);
            JPanel bp = new BoardPanel(BP_WIDTH,BP_HEIGHT,Color.blue);
            JPanel bbp = new BottomButtonPanel(BBP_WIDTH, BBP_HEIGHT,Color.green);

            @Override
            public void run() {
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

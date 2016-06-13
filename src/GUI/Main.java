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
import ww.Settings;

/**
 *
 * @author Dom
 */
public class Main {

    public static void main(String[] args) {
        try {
            createAndShowGUI();
        } catch (IOException ex) {
            System.err.println("Error while creating main window: " + ex.getMessage());
        }
    }

    public static void createAndShowGUI() throws IOException {
        EventQueue.invokeLater(new Runnable() {
            Settings settings = new Settings();
            WireWorldMainWindow m;
            SettingsWindow s;
            RightButtonPanel rbp = new RightButtonPanel(RBP_WIDTH, RBP_HEIGHT);
            BoardPanel bp = new BoardPanel(BP_WIDTH, BP_HEIGHT, Color.gray, settings);
            BottomButtonPanel bbp = new BottomButtonPanel(BBP_WIDTH, BBP_HEIGHT, Color.GRAY);
            OptionsPanel op = new OptionsPanel(RP_WIDTH, RP_HEIGHT);
            PanelsControl control = new PanelsControl();
            
            ColorSettingsPanel csp = new ColorSettingsPanel(250, 300, settings);
            OtherSettingsPanel osp = new OtherSettingsPanel(250, 300, settings);

            @Override
            public void run() {
                m = new WireWorldMainWindow();
                s = new SettingsWindow();
                bp.setControl(control);
                bbp.setControl(control);
                rbp.setControl(control);
                rbp.connectWithSettingsWindow(s);
                op.setControl(control);
                osp.setControl(control);
                
                control.setBoardPanel(bp);
                control.setBottomButtonPanel(bbp);
                control.setRightButtonPanel(rbp);
                control.setOptionsPanel(op);
                control.setOtherSettingsPanel(osp);
                control.setWindows(s,m);
                
                m.setLayout(new GridBagLayout());
                s.setLayout(new GridBagLayout());
                GridBagConstraints c = new GridBagConstraints();
                c.gridy = 0; c.gridx = 0;  m.add(rbp, c);
                c.gridy = 0; c.gridx = 1; m.add(bp, c);
                c.gridy = 1;  c.gridx = 0; m.add(op, c);
                c.gridy = 1; c.gridx = 1; m.add(bbp, c);
                
                c.gridy = 0; c.gridx = 0; s.add(csp,c);
                c.gridy = 1; c.gridx = 0; s.add(osp,c);

                m.setVisible(true);
            }
        });
    }
}

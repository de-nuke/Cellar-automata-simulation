/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestingGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author Dom
 */
public class Test {
 
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            MainWindow m;
            JPanel p;
            JPanel p2;

            @Override
            public void run() {
                m = new MainWindow();
                try {
                    p = new Panel(400, 400, 50);
                } catch (IOException ex) {
                    Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
                }
                m.add(p, BorderLayout.NORTH);
                //m.pack();
            }

        });
    }
}

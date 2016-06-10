/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestingGUI;

import java.awt.BorderLayout;
import javax.swing.*;

/**
 *
 * @author Dom
 */
public class MainWindow extends JFrame{
    
    public MainWindow() {
        super("WireWorld");
        int b = 450;
        int a = (int) (b*1.618);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
        setSize(a,b);
        setLocationRelativeTo(null);
        setResizable(false); 
        setLayout(new BorderLayout());
        

    }
}

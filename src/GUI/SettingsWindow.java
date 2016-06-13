/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static GUI.MyDimensions.MAIN_WIN_HEIGH;
import static GUI.MyDimensions.MAIN_WIN_WIDTH;
import javax.swing.JFrame;

/**
 *
 * @author Dom
 */
public class SettingsWindow extends JFrame{
    
    
    public SettingsWindow() {
        super("Settings");
        
        
        int b = MAIN_WIN_HEIGH;
        int a = MAIN_WIN_WIDTH;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setVisible(true);
        setSize(a,b);
        setLocationRelativeTo(null);
        setResizable(false); 
    }
}

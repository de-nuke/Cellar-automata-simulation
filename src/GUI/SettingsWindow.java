/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Dom
 */
public class SettingsWindow extends JFrame{
    
    public SettingsWindow() {
        super("Settings");
        int b = 650;
        int a = 402;
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(a,b);
        setLocationRelativeTo(null);
        setResizable(false); 
       
    }
}

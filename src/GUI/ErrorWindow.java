/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Dom
 */
public class ErrorWindow extends JFrame implements ActionListener {
    
    JButton ok = new JButton("OK");
    JLabel textMessage;
    
    public ErrorWindow(String message) {
        super("Error");
        textMessage = new JLabel(message);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,150);
        setLocationRelativeTo(null);
        setResizable(false); 
        setLayout(new GridBagLayout());
        ok.addActionListener(this);
        add(textMessage);
        GridBagConstraints c = new GridBagConstraints();
        c.gridy = 1;
        add(ok,c);
        
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        dispose();
    }
   
}

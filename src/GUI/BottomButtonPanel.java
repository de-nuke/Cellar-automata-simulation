/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;

/**
 *
 * @author Dom
 */
public class BottomButtonPanel extends JPanel implements ActionListener{
    PanelsControl control;
    
    int pWidth;
    int pHeight;
    
    JButton empty = new JButton("Empty");
    JButton wire = new JButton("wire");
    JButton eh = new JButton("ElectronHead");
    JButton et = new JButton("ElectronTail");
    JButton diodeN = new JButton("Diode Normal");
    JButton diodeR = new JButton("Diode Reversed");
    JButton orgate = new JButton("OR gate");
    JButton xorgate = new JButton("XOR gate");
    JButton andgate = new JButton("AND gate");
    JButton notgate = new JButton("NOT gate");
    
    File f;
    
    public BottomButtonPanel(int w, int h, Color c) {
        this.pHeight = h;
        this.pWidth = w;
        setBackground(c);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(pWidth, pHeight);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setControl(PanelsControl control) {
        this.control = control;
    }
   

}

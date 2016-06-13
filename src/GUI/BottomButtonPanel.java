/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static GUI.MyDimensions.ELMNT_BTN;
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
    JButton wire = new JButton("Wire");
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
        //setBackground(c);
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        
        empty.setPreferredSize(ELMNT_BTN);
        wire.setPreferredSize(ELMNT_BTN);
        eh.setPreferredSize(ELMNT_BTN);
        et.setPreferredSize(ELMNT_BTN);
        diodeN.setPreferredSize(ELMNT_BTN);
        diodeR.setPreferredSize(ELMNT_BTN);
        orgate.setPreferredSize(ELMNT_BTN);
        xorgate.setPreferredSize(ELMNT_BTN);
        andgate.setPreferredSize(ELMNT_BTN);
        notgate.setPreferredSize(ELMNT_BTN);

        empty.addActionListener(this);
        wire.addActionListener(this);
        eh.addActionListener(this);
        et.addActionListener(this);
        diodeN.addActionListener(this);
        diodeR.addActionListener(this);
        orgate.addActionListener(this);
        xorgate.addActionListener(this);
        andgate.addActionListener(this);
        notgate.addActionListener(this);
        
        add(empty);
        add(wire);
        add(eh);
        add(et);
        add(diodeN);
        add(diodeR);
        add(orgate);
        add(xorgate);
        add(andgate);
        add(notgate);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(pWidth, pHeight);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        control.insertElement(e);
    }

    public void setControl(PanelsControl control) {
        this.control = control;
    }
   

}

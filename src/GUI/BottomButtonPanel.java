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
public class BottomButtonPanel extends JPanel implements ActionListener,ControlledPanel{
    private PanelsControl control;
    
    private final int pWidth;
    private final int pHeight;
   
    private final JButton empty = new JButton("Empty");
    private final JButton wire = new JButton("Wire");
    private final JButton eh = new JButton("ElectronHead");
    private final JButton et = new JButton("ElectronTail");
    private final JButton diodeN = new JButton("Diode Normal");
    private final JButton diodeR = new JButton("Diode Reversed");
    private final JButton orgate = new JButton("OR gate");
    private final JButton xorgate = new JButton("XOR gate");
    private final JButton andgate = new JButton("AND gate");
    private final JButton notgate = new JButton("NOT gate");
    
    private File f;
    
    public BottomButtonPanel(int w, int h, Color c) {
        this.pHeight = h;
        this.pWidth = w;
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

    @Override
    public void setControl(PanelsControl control) {
        this.control = control;
    }

}

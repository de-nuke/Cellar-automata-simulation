/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static GUI.MyDimensions.BIG_BTN;
import static GUI.MyDimensions.SMALL_BTN;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Dom
 */
public class OptionsPanel extends JPanel implements ActionListener {
    PanelsControl control;
    
    int pWidth;
    int pHeight;
    
    JButton reset = new JButton("Reset");
    JButton quit = new JButton("Quit");
    JButton apply = new JButton("Apply");
    JButton toTxt = new JButton("Save to txt");
    
    JLabel n = new JLabel("n = ");
    private JTextField tf = new JTextField("n");
    
    
    public OptionsPanel(int w, int h) {
        pWidth = w;
        pHeight = h;
        
        setLayout(new FlowLayout(FlowLayout.CENTER, 5, 10));
        
        reset.setPreferredSize(SMALL_BTN);
        reset.addActionListener(this);
        quit.setPreferredSize(SMALL_BTN);
        quit.addActionListener(this);
        apply.setPreferredSize(SMALL_BTN);
        apply.addActionListener(this);
        toTxt.setPreferredSize(new Dimension(BIG_BTN.width, SMALL_BTN.height));
        toTxt.addActionListener(this);
        n.setPreferredSize(new Dimension(BIG_BTN.width, SMALL_BTN.height));
        tf.setPreferredSize(SMALL_BTN);
        tf.setToolTipText("Type expected number of generations here");
        
        add(toTxt);
        add(n);
        add(tf);
        add(apply);
        add(reset);
        add(quit);
    }
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(pWidth, pHeight);
    }
    
    public void setControl(PanelsControl control) {
        this.control = control;
    }

    public void clearTextField() {
        tf.setText("n");
    }
    
    public void clearLabel() {
        n.setText("n = ");
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        if(btn == reset) {
            control.reset();
        }
        if(btn == toTxt) {
            control.saveToTxt();
        }
    }
}

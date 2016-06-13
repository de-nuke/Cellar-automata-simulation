/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static GUI.MyDimensions.BIG_BTN;
import static GUI.MyDimensions.SMALL_BTN;
import java.awt.Color;
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
    JLabel nleft = new JLabel("");
    JLabel msg = new JLabel("");
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
        n.setPreferredSize(new Dimension((BIG_BTN.width-10)/3 -10, SMALL_BTN.height)); //(BIG_BTN.width-10)/3 == 1/3 of BIG_BTN without horizonal gaps
        nleft.setPreferredSize(new Dimension((BIG_BTN.width-10)/3 -10, SMALL_BTN.height));
        msg.setPreferredSize(new Dimension((BIG_BTN.width-10)/3 + 20, SMALL_BTN.height));
        tf.setPreferredSize(SMALL_BTN);
        tf.setToolTipText("Type expected number of generations here");
        
        add(toTxt);
        add(n);
        add(nleft);
        add(msg);
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

    private void clearLabelsAndTextField() {
        tf.setText("n");
        n.setText("n = ");
        nleft.setText("");
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
        if(btn == apply) {
            int number = 0;
            try{
                number = Integer.parseInt(tf.getText());
            } catch(NumberFormatException ex) {
            }
            n.setText("n = " + number);
            if(number < 0) number = 0;
            control.setNumOfGen(number);
        }
        if(btn == quit) {
            control.closeApplication();
        }
    }
    
    public void reset() {
        clearLabelsAndTextField();
    }

    void numLeft(int numOfGen) {
        nleft.setText("n left: " + numOfGen);
    }

    void showMessage(String message,Color c) {
        msg.setForeground(c);
        msg.setText(message);
    }
}

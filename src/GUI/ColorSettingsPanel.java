/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import ww.Settings;

/**
 *
 * @author Dom
 */
public class ColorSettingsPanel extends JPanel implements ActionListener,ControledPanel {

    Color[] colors = {
        Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GRAY,
        Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK,
        Color.RED, Color.WHITE, Color.YELLOW
    };

    String[] colorsNames = {
        "Black", "Blue", "Cyan", "Dark grey", "Gray", "Green", "Light gray",
        "Magenta", "Pink", "Red", "White", "Yellow"
    };

    JLabel wireColor = new JLabel("Wire Color: ");
    JLabel emptyCellColor = new JLabel("Empty Cell Color: ");
    JLabel etColor = new JLabel("Electron Tail Color: ");
    JLabel ehColor = new JLabel("Electron Head Color: ");
    JLabel warning = new JLabel("Color settings not supported yet");

    JComboBox<String> wires = new JComboBox<String>(colorsNames);
    JComboBox<String> empty = new JComboBox<String>(colorsNames);
    JComboBox<String> heads = new JComboBox<String>(colorsNames);
    JComboBox<String> tails = new JComboBox<String>(colorsNames);

    int w;
    int h;

    Settings settings;

    public ColorSettingsPanel(int w, int h, Settings settings) {
        this.w = w;
        this.h = h;
        this.settings = settings;

        wires.setSelectedIndex(0);
        wires.addActionListener(this);
        empty.setSelectedIndex(11);
        empty.addActionListener(this);
        heads.setSelectedIndex(10);
        heads.addActionListener(this);
        tails.setSelectedIndex(1);
        tails.addActionListener(this);
        warning.setForeground(Color.red);
        
        add(wireColor);
        add(wires);
        add(emptyCellColor);
        add(empty);
        add(ehColor);
        add(heads);
        add(etColor);
        add(tails);
        add(warning);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(w, h);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        JComboBox cb = (JComboBox) e.getSource();
        String chosenColor = (String) cb.getSelectedItem();
        
        setColor(chosenColor);
    }
    
    private void setColor(String colorname) {

        switch (colorname) {
            case "Black":
            case "Blue":
            case "Cyan":
            case "Dark grey":
            case "Gray":
            case "Green":
            case "Light gray":
            case "Magenta":
            case "Pink":
            case "Red":
            case "White":
            case "Yellow":
                
        }
    }

    @Override
    public void setControl(PanelsControl control) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

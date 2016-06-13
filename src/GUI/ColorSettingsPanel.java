/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import javax.swing.*;

/**
 *
 * @author Dom
 */
public class ColorSettingsPanel extends JPanel{
    
    Color[] colors = {
        new Color(1, 2, 3)
    };
    
    JLabel wireColor = new JLabel("Wire Color: ");
    JLabel emptyCellColor = new JLabel("Empty Cell Color: ");
    JLabel etColor = new JLabel("Electron Tail Color: ");
    JLabel ehColor = new JLabel("Electron Head Color: ");
    
    JComboBox<Color> wires = new JComboBox<Color>(colors);
    public ColorSettingsPanel() {
        
    }
}

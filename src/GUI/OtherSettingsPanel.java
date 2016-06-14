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
public class OtherSettingsPanel extends JPanel implements ActionListener, ControledPanel{

    private Settings settings;
    private int w;
    private int h;
    private PanelsControl control;
    private JLabel cellSize = new JLabel("Size of cell [in pixels]: ");
    private JLabel defOutPath = new JLabel("Default output path: ");
    private JLabel warning = new JLabel("(\"Apply\" will reset the Board)");
    private JButton apply = new JButton("Apply");
    private Integer[] sizes = {5,6,7,8,9,10,11,12,13,14,15};
    private JComboBox<Integer> cellSizes = new JComboBox<>(sizes);
    private int actualSize;
    private int actualSizeIndex;
    private boolean changesWereMade;

    public OtherSettingsPanel(int w, int h, Settings settings) {
        changesWereMade = false;
        this.w = w;
        this.h = h;
        this.settings = settings;
        actualSize = settings.getCellSize();
        for(int i = 0; i < sizes.length; i++)
            if(sizes[i] == actualSize) {
                actualSizeIndex = i;
                break;
            }
        cellSizes.setSelectedIndex(actualSizeIndex);
        cellSizes.addActionListener(this);
        apply.setEnabled(false);
        apply.addActionListener(this);
        warning.setForeground(Color.red);
        
        add(cellSize);
        add(cellSizes);
        add(apply);
        add(warning);
    }
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(w, h);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() instanceof JComboBox) {
            JComboBox cb = (JComboBox) e.getSource();
            int size = (int) cb.getSelectedItem();
            if(size != actualSize) {
                settings.setCellSize(size);
                changesWereMade = true;
                apply.setEnabled(true);
                actualSize = size;
            }

        }
        if(e.getSource() instanceof JButton) {
            JButton btn = (JButton) e.getSource();
            if(btn == apply && changesWereMade) {
                control.reset();
                settings.saveSettngs();
                apply.setEnabled(false);
                changesWereMade = false;
            }
        }
    }
    
    @Override
    public void setControl(PanelsControl control) {
        this.control = control;
    }
}

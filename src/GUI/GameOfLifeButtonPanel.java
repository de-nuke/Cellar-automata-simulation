/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static GUI.MyDimensions.ELMNT_BTN;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Dom
 */
public class GameOfLifeButtonPanel extends JPanel implements ActionListener, ControlledPanel {
    private PanelsControl control;
    
    private final int pWidth;
    private final int pHeight;
    
    private JButton deadCell = new JButton("Dead cell");
    private JButton livingCell = new JButton("Living cell");
    
    public GameOfLifeButtonPanel(int w, int h) {
        pWidth = w;
        pHeight = h;
        
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        
        deadCell.setPreferredSize(ELMNT_BTN);
        livingCell.setPreferredSize(ELMNT_BTN);
        
        deadCell.addActionListener(this);
        livingCell.addActionListener(this);
        
        add(deadCell);
        add(livingCell);
        
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

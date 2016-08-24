/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GUI.additionalPanelComponents.*;
import elements.Element;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.IOException;
import javax.swing.JPanel;

/**
 *
 * @author Dom
 */
public class AdditionalPanel extends JPanel{
    private PanelsControl control;
    
    private int pWidth;
    private int pHeight;
    
    private Preview previewPanel;
    private Switching switching;

    public AdditionalPanel(int w, int h) throws IOException {
        setLayout(new FlowLayout());
        setOpaque(true);
        //setBackground(new Color(250, 250, 250));
        pWidth = w;
        pHeight = h;
        
        switching = new Switching(this.getBackground(), pWidth, pHeight/3);
        previewPanel = new Preview(this.getBackground(), pWidth, pHeight/3);
        add(switching);
        add(previewPanel);
    }
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(pWidth, pHeight);
    }
    
    public void setControl(PanelsControl control) {
        this.control = control;
        switching.setControl(control);
    }

    void showElementPreview(Element pickedElement) {
        previewPanel.updatePreview(pickedElement);
    }

}

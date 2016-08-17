/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import ww.Settings;

/**
 *
 * @author Dom
 */
public class ColorSettingsPanel extends JPanel implements ActionListener,ControlledPanel {
    private PanelsControl control;
    
    private Color[] colors = {
        Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GRAY,
        Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.PINK,
        Color.RED, Color.WHITE, Color.YELLOW
    };

    private String[] colorsNames = {
        "Black", "Blue", "Cyan", "Dark grey", "Gray", "Green", "Light gray",
        "Magenta","Orange" ,"Pink", "Red", "White", "Yellow"
    };

    private JLabel wireColor = new JLabel("Wire Color: ");
    private JLabel emptyCellColor = new JLabel("Empty Cell Color: ");
    private JLabel etColor = new JLabel("Electron Tail Color: ");
    private JLabel ehColor = new JLabel("Electron Head Color: ");

    private JComboBox<Color> wires = new JComboBox<Color>(colors);
    private JComboBox<Color> empty = new JComboBox<Color>(colors);
    private JComboBox<Color> heads = new JComboBox<Color>(colors);
    private JComboBox<Color> tails = new JComboBox<Color>(colors);
    
    private int w;
    private int h;
    private int actualWireIndex;
    private int actualEHIndex;
    private int actualETIndex;
    private int actualEmptyIndex;
    
    private Settings settings;
    
    private Color actualWire;
    private Color actualEH;
    private Color actualET;
    private Color actualEmpty;

    public ColorSettingsPanel(int w, int h, Settings settings) {
        setLayout(new GridLayout(4, 2));
        this.w = w;
        this.h = h;
        this.settings = settings;
        actualWire = settings.getWireColor();
        actualEH = settings.getElectronHeadColor();
        actualET = settings.getElectronTailColor();
        actualEmpty = settings.getEmptyCellColor();
        for(int i = 0; i < colors.length-1; i++) {
            if(colors[i].equals(actualWire)) {
                actualWireIndex = i;
            }
            if(colors[i].equals(actualEH)) {
                actualEHIndex = i;
            }
            if(colors[i].equals(actualET)) {
                actualETIndex = i;
            }
            if(colors[i].equals(actualEmpty)) {
                actualEmptyIndex = i;
            }
        }
            
        wires.setSelectedIndex(actualWireIndex);
        wires.addActionListener(this);
        wires.setRenderer(new MyCellRenderer());
        empty.setSelectedIndex(actualEmptyIndex);
        empty.addActionListener(this);
        empty.setRenderer(new MyCellRenderer());
        heads.setSelectedIndex(actualEHIndex);
        heads.addActionListener(this);
        heads.setRenderer(new MyCellRenderer());
        tails.setSelectedIndex(actualETIndex);
        tails.addActionListener(this);
        tails.setRenderer(new MyCellRenderer());
        
        add(wireColor);
        add(wires);
        add(emptyCellColor);
        add(empty);
        add(ehColor);
        add(heads);
        add(etColor);
        add(tails);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(w, h);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        JComboBox cb = (JComboBox) e.getSource();
        Color chosenColor = (Color) cb.getSelectedItem();
        
        if(cb == wires)
            settings.setWireColor(chosenColor);
        else if(cb == heads)
            settings.setEhColor(chosenColor);
        else if(cb == tails)
            settings.setEtColor(chosenColor);
        else if(cb == empty)
            settings.setEmptyColor(chosenColor);
        
        control.repaintBoard();
    }
    
    
    @Override
    public void setControl(PanelsControl control) {
        this.control = control;
    }
    
    class MyCellRenderer extends JButton implements ListCellRenderer {  
     public MyCellRenderer() {  
         setOpaque(true); 

     }
     boolean b=false;
    @Override
    public void setBackground(Color bg) {
        // TODO Auto-generated method stub
         if(!b)
         {
             return;
         }

        super.setBackground(bg);
    }
     public Component getListCellRendererComponent(  
         JList list,  
         Object value,  
         int index,  

         boolean isSelected,  
         boolean cellHasFocus)  
     {  

         b=true;
         setText(" ");           
         setBackground((Color)value);        
         b=false;
         return this;  
     }  
}
         
}






/*   public class MyColor extends Color {
       int rgb;
        public MyColor(int rgb) {
            super(rgb);
            this.rgb = rgb;
        }
        @Override
    public String toString() {
        String colorName = null;
        Color c = new Color(rgb);
        
        if(c.equals(Color.BLACK)) colorName = "Black";
        else if(c.equals(Color.BLUE)) colorName = "Blue";
        else if(c.equals(Color.CYAN)) colorName = "Cyan";
        else if(c.equals(Color.DARK_GRAY)) colorName = "Dark gray";
        else if(c.equals(Color.GRAY)) colorName = "Gray";
        else if(c.equals(Color.GREEN)) colorName = "Green";
        else if(c.equals(Color.LIGHT_GRAY)) colorName = "Light gray";
        else if(c.equals(Color.MAGENTA)) colorName = "Magenta";
        else if(c.equals(Color.ORANGE)) colorName = "Orange";
        else if(c.equals(Color.PINK)) colorName = "Pink";
        else if(c.equals(Color.RED)) colorName = "Red";
        else if(c.equals(Color.WHITE)) colorName = "White";
        else if(c.equals(Color.YELLOW)) colorName = "YEllow";
        return colorName;
    }
   }*/
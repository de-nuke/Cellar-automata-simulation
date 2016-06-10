/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestingGUI;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

/**
 *
 * @author Dom
 */
public class Panel extends JPanel {
    
    int panelWidth;
    int panelHeight;
    int [][]brd;
    int n;
    public Panel(int w, int h, int n) {

        ExampleBoard b = new ExampleBoard(n);
        brd = b.getArray();
        panelWidth = w;
        panelHeight = h;
        this.n = n;
        setBorder(new LineBorder(Color.RED));
        

        
    }
    
    @Override
        public Dimension getPreferredSize() {
            return new Dimension(panelWidth, panelHeight);
        }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Color firstColor = new Color(245, 230, 222);
        Color secondColor = new Color(43, 0, 255);
        Color thirdColor = new Color(169, 130, 182);
        
        int rectWidth = (int) panelWidth/n;
        int rectHeight = (int) panelHeight/n;
        
//        System.out.println("rectWidth = " + rectWidth);
//        System.out.println("rectHeight = " + rectHeight);
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(brd[i][j] == 1) 
                    g.setColor(firstColor);
                else if(brd[i][j] == 2)
                    g.setColor(secondColor);
                else 
                    g.setColor(thirdColor);
                
                g.fillRect(j*rectWidth, i*rectHeight, rectWidth, rectHeight);
            }
        }
    }
}

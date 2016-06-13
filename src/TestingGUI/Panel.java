/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestingGUI;

import java.awt.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import ww.*;


/**
 *
 * @author Dom
 */
public class Panel extends JPanel {
    
    int panelWidth;
    int panelHeight;
    Integer [][]brd;
    int n;
    public Panel(int w, int h, int n) throws IOException {

//      ExampleBoard b = new ExampleBoard(n);
//      brd = b.getArray();
        Board b = new Board(w,h);
        b.addData(new FileData(new File("data.txt"), 10));
        brd = b.getArray();
        panelWidth = w;
        panelHeight = h;
        this.n = n;
        setBorder(new LineBorder(Color.RED));
        setBackground(Color.gray);

        
    }
    
    @Override
        public Dimension getPreferredSize() {
            return new Dimension(panelWidth, panelHeight);
        }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Color firstColor = Color.WHITE;
        Color secondColor = Color.BLACK;
        Color thirdColor = Color.BLUE;
        Color fourthColor = Color.RED;
        
        int rectWidth = (int) panelWidth/n;
        int rectHeight = (int) panelHeight/n;
        
//        System.out.println("rectWidth = " + rectWidth);
//        System.out.println("rectHeight = " + rectHeight);
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(brd[i][j] == 0) 
                    g.setColor(firstColor);
                else if(brd[i][j] == 1)
                    g.setColor(secondColor);
                else if(brd[i][j] == 2)
                    g.setColor(thirdColor);
                else if(brd[i][j] == 3)
                    g.setColor(fourthColor);
                g.fillRect(j*rectWidth, i*rectHeight, rectWidth - 1, rectHeight - 1);
            }
        }
    }
}

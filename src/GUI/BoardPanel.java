/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.*;
import java.io.File;
import javax.swing.*;
import ww.Board;
import ww.FileData;

/**
 *
 * @author Dom
 */
public class BoardPanel extends JPanel {

    int pWidth;
    int pHeight;
    Integer [][]brd;
    int nH = 90; //number of cells horizontally
    int nV = 107; //number of cells vertically
    int rectWidth;
    int rectHeight;
    
    public BoardPanel(int w, int h, Color c) {
        this.pHeight = h;
        this.pWidth = w;
        setBackground(c);
        Board b = new Board(nH, nV);
        b.addData(new FileData(new File("data.txt")));
        brd = b.getArray();
        pWidth = w;
        pHeight = h;
        rectWidth = (int) pWidth/nV;
        rectHeight = (int) pHeight/nV;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(pWidth, pHeight);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Color firstColor = Color.WHITE;
        Color secondColor = Color.BLACK;
        Color thirdColor = Color.BLUE;
        Color fourthColor = Color.RED;
        

        
//        System.out.println("rectWidth = " + rectWidth);
//        System.out.println("rectHeight = " + rectHeight);
        
        for(int i = 0; i < nV; i++) {
            for(int j = 0; j < nH; j++) {
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

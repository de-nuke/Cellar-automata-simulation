/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import javax.swing.border.LineBorder;
import ww.Board;
import ww.FileData;
import ww.Settings;

/**
 *
 * @author Dom
 */
public class BoardPanel extends JPanel {

    int pWidth;
    int pHeight;
    Integer [][]brd;
    int nH; //number of cells horizontally
    int nV; //number of cells vertically
    int cellSize; //in pixels
    Settings settings;
    
    public BoardPanel(int w, int h, Color c, Settings s) throws IOException {
        setBackground(c);
        setBorder(new LineBorder(Color.BLACK));
        this.settings = s;
        this.pHeight = h;
        this.pWidth = w;
        
        nH = (int)(w/settings.getCellSize());
        nV = (int)(h/settings.getCellSize());
        Board b = new Board(nH, nV);
        FileData fd = null;
        fd = new FileData(new File("data.txt"));
        b.addData(fd); 
      
        brd = b.getArray();
        cellSize = settings.getCellSize();

        
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(pWidth, pHeight);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Color firstColor = settings.getEmptyCellColor();
        Color secondColor = settings.getWireColor();
        Color thirdColor = settings.getElectronTailColor();
        Color fourthColor = settings.getElectronHeadColor();
        

        
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
                g.fillRect(j*cellSize, i*cellSize, cellSize-1 , cellSize-1 );
            }
        }
    }
}

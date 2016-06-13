/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import elements.Element;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import javax.swing.*;
import javax.swing.border.LineBorder;
import ww.Board;
import ww.FileData;
import ww.IO;
import ww.Settings;

/**
 *
 * @author Dom
 */
public class BoardPanel extends JPanel implements MouseListener{
    PanelsControl control;
            
    int pWidth;
    int pHeight;
    File f;
    FileData fd;
    Board b;
    Integer [][]brd;
    int nH; //number of cells horizontally
    int nV; //number of cells vertically
    int cellSize; //in pixels
    Settings settings;
    
    Element pickedElement = null;
    
    public BoardPanel(int w, int h, Color c, Settings s) throws IOException {
        setBackground(c);
        setBorder(new LineBorder(Color.BLACK));
        this.settings = s;
        this.pHeight = h;
        this.pWidth = w;
        
        nH = (int)(w/settings.getCellSize());
        nV = (int)(h/settings.getCellSize());
        b = new Board(nH, nV);
        brd = b.getArray();
        cellSize = settings.getCellSize();
        
        addMouseListener(this);
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
                g.fillRect(j*cellSize, i*cellSize, cellSize -1  , cellSize - 1 );
            }
        }
    }

    public void setControl(PanelsControl control) {
        this.control = control;
    }
    
    public void takeFile(File file) throws IOException {
        this.f = file;
        fd = new FileData(f, settings.getCellSize());
        b.addData(fd);
        brd = b.getArray();
    }
    
    public Board getBoard() {
        return b;
    }
    
    public void updateBoard(Board transformedBoard) {
        this.b = transformedBoard;
        this.brd = b.getArray();
    }
    
    public void putElement(Element e) {
        System.out.println("Wykonałem putElement");
        pickedElement = e;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int cellX = (int) (getMousePosition().x / cellSize);
        int cellY = (int) (getMousePosition().y / cellSize);
        
        if(pickedElement != null) {
            System.out.println("cellX: " + cellX + " cellY: " + cellY);
            b.insertElement(pickedElement, cellX, cellY);
            brd = b.getArray();
            repaint();
        }
        else
            System.out.println("pickedElement == null");
    }

    @Override
    public void mouseClicked(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void writeToTxt() {
        try {
            IO.writeToFile(b, fd == null ? null : fd.getFileName());
        } catch (FileNotFoundException ex) {
            System.err.println("Couldn't create output file. Inappropriate file name or path.");
        } catch (UnsupportedEncodingException ex) {
            System.err.println("Couldn't create output file. Unsupproted encoding.");
        }
    }
}

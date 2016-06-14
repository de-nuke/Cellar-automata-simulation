/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import elements.Element;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class BoardPanel extends JPanel implements MouseListener, ControledPanel{
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
    Timer timerClearMsg = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                control.showMessage("", Color.BLACK);
            }
        });

    
    Element pickedElement = null;
    
    public BoardPanel(int w, int h, Color c, Settings s) throws IOException {
        setBackground(c);
        setBorder(new LineBorder(Color.BLACK));
        this.settings = s;
        this.pHeight = h;
        this.pWidth = w;
        timerClearMsg.setRepeats(false);
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

    @Override
    public void setControl(PanelsControl control) {
        this.control = control;
    }
    
    public void takeFile(File file){
        this.f = file;
        try {
            fd = new FileData(f, settings.getCellSize());
            System.out.println("File \"" + file.getName() + "\" has been opened.");
            control.showMessage("File opened", Color.GREEN);
            timerClearMsg.start();
            b.addData(fd);
            brd = b.getArray();
        } catch (IOException ex) {
            System.out.println("Couldn't open file: \"" + file.getName() + "\"");
            control.showMessage("Opening failed.", Color.RED);
            timerClearMsg.start();
        }

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
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    public void writeToTxt() {
        try {
            IO.writeToFile(b, fd == null ? null : fd.getFileName());
            control.showMessage("Saved", Color.GREEN);
            timerClearMsg.start();
        } catch (FileNotFoundException ex) {
            System.err.println("Couldn't create output file. Inappropriate file name or path.");
            control.showMessage("Can't save to file", Color.RED);
        } catch (UnsupportedEncodingException ex) {
            System.err.println("Couldn't create output file. Unsupproted encoding.");
            control.showMessage("Can't save to file", Color.RED);
        }
    }
        
    public void reset() {
        nH = (int)(pWidth/settings.getCellSize());
        nV = (int)(pHeight/settings.getCellSize());
        cellSize = settings.getCellSize();
        b = new Board(nH, nV);
        updateBoard(b);
        repaint();
    }
    
    public void loadFile() throws IOException {
        JFileChooser fc = new JFileChooser();
        int returnVal = fc.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            timerClearMsg.start();
            takeFile(file);
            repaint();
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ww;

import java.awt.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dom
 */
public class Settings {

    Color ehColor; //electronHead
    Color etColor; //electronTail
    Color emptyColor;
    Color wireColor;

    Color gapsBetweenCellsColor;

    int cellSize;
    boolean repeatGeneration;
    boolean writeEveryFileToPng;
    boolean writeEveryFileToTxt;
    
    String[] settings = new String[9];

    public Settings() {
        FileReader fr;
        BufferedReader br;
        String line;
        String linePart[];
        int i=0;
        try {
            fr = new FileReader(new File("settings.txt"));
            br = new BufferedReader(fr);

            try {
                while ((line = br.readLine()) != null) {
                    linePart = line.split("-");
                    settings[i++] = linePart[1];
                }
            } catch (IOException ex) {
                System.err.println("Something is wrong with settings file.");
            }
        } catch (FileNotFoundException ex) {
            System.err.println("File with settings not found! ");
        }
        
        makeSettings(settings);
        
    } //end of constructor
    
    private void makeSettings(String s[]) {
        emptyColor = setColor(s[0]);
        wireColor = setColor(s[1]);
        etColor = setColor(s[2]);
        ehColor = setColor(s[3]);
        gapsBetweenCellsColor = setColor(s[4]);
        cellSize = Integer.parseInt(s[5]);
        repeatGeneration = Boolean.parseBoolean(s[6]);
        writeEveryFileToPng = Boolean.parseBoolean(s[7]);
        writeEveryFileToTxt = Boolean.parseBoolean(s[8]);
        
    }
    
    private Color setColor(String stringColor) {
        String[]rgb;
        rgb = stringColor.split("\\s+");
        Integer r,g,b;
        r = Integer.parseInt(rgb[0]);
        g = Integer.parseInt(rgb[1]);
        b = Integer.parseInt(rgb[2]);
        
        return new Color(r, g, b);
    }
    /******************************************************/
    //GETTERS AND SETTERS BELOW: 
    
    public Color getElectronHeadColor() {
        return ehColor;
    }

    public Color getElectronTailColor() {
        return etColor;
    }

    public Color getEmptyCellColor() {
        return emptyColor;
    }

    public Color getWireColor() {
        return wireColor;
    }

    public Color getGapsBetweenCellsColor() {
        return gapsBetweenCellsColor;
    }

    public int getCellSize() {
        return cellSize;
    }

    public boolean isRepeatingGeneration() {
        return repeatGeneration;
    }

    public boolean isWritingEveryFileToPng() {
        return writeEveryFileToPng;
    }

    public boolean isWritingEveryFileToTxt() {
        return writeEveryFileToTxt;
    }

    public void setEhColor(Color ehColor) {
        this.ehColor = ehColor;
    }
    
    //Setters: 
    
    public void setEtColor(Color etColor) {
        this.etColor = etColor;
    }

    public void setEmptyColor(Color emptyColor) {
        this.emptyColor = emptyColor;
    }

    public void setWireColor(Color wireColor) {
        this.wireColor = wireColor;
    }

    public void setGapsBetweenCellsColor(Color gapsBetweenCellsColor) {
        this.gapsBetweenCellsColor = gapsBetweenCellsColor;
    }

    public void setCellSize(int cellSize) {
        this.cellSize = cellSize;
    }

    public void setRepeatGeneration(boolean repeatGeneration) {
        this.repeatGeneration = repeatGeneration;
    }

    public void setWriteEveryFileToPng(boolean writeEveryFileToPng) {
        this.writeEveryFileToPng = writeEveryFileToPng;
    }

    public void setWriteEveryFileToTxt(boolean writeEveryFileToTxt) {
        this.writeEveryFileToTxt = writeEveryFileToTxt;
    }
    
    
}

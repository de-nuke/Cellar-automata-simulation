/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ww;

import elements.Element;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Dom
 */
public class FileData {

    ArrayList<Element> elements = new ArrayList();
    int cellSize = 10;
    String fileName;

    public FileData(File file, int cellSize)
            throws IOException {
            this.cellSize = cellSize;
            fileName = file.getName();
            elements = IO.readFromFile(file);
    }

    public String getFileName() {
        return fileName;
    }
    
    public ArrayList<Element> getElementsArrayList() {
        return elements;
    }
    
    @Override
    public String toString() {
        String text = "FileData has succesfully read " + elements.size() + " elements: \n";
        for (Element e : elements) {
            text += e.toString() + "\n";
        }
        return text;
    }
}

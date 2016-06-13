/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ww;

import GUI.ErrorWindow;
import GUI.MyDimensions;
import elements.*;
import elements.Element;
import elements.Wire;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Dom
 */
public class FileData {

    ArrayList<Element> elements = new ArrayList();
    Integer n = 0;
    int cellSize = 10;
    public FileData() {

    }

    public FileData(File file, int cellSize)
            throws IOException {
            this.cellSize = cellSize;
            readFromFile(file);
    }

    public void readFromFile(File file)
            throws FileNotFoundException, IOException {
        String[] lineParts;
        String line;
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        while ((line = br.readLine()) != null) {
            lineParts = line.split("\\s+");

            if (isRecognized(lineParts[0]) && isCorrectPoint(lineParts[1], lineParts[2])) {
                Point p = new Point(Integer.parseInt(lineParts[1]), Integer.parseInt(lineParts[2]));
                switch (lineParts[0]) {
                    case "wire": {
                        elements.add(new Wire("wire", p, 1, 1));
                    }
                    break;
                    case "diodenormal": {
                        elements.add(new DiodeN("diodenormal", p));
                    }
                    case "diodereversed": {
                        elements.add(new DiodeR("diodereversed", p));
                    }
                    break;
                    case "empty": {
                        elements.add(new EmptyCell("empty", p, 1, 1));
                    }
                    break;
                    case "electronhead": {
                        elements.add(new ElectronHead("electronhead", p, 1, 1));
                    }
                    break;
                    case "electrontail": {
                        elements.add(new ElectronTail("electrontail", p, 1, 1));
                    }
                    break;
                    case "orgate": {
                        elements.add(new OrGate("orgate", p));
                    }
                    break;
                    case "xorgate": {
                        elements.add(new XorGate("xorgate", p));
                    }
                    break;
                    case "andgate": {
                        elements.add(new AndGate("andgate", p));
                    }
                    break;
                    case "notgate": {
                        elements.add(new NotGate("notgate", p));
                    }
                    break;
                    default:
                        throw new IOException("Unknown element" + lineParts[0]);
                }

                n++;
            } else {
                System.err.println("Wrong data format in line " + (n + 1) + "!");
                new ErrorWindow("Wrong data format in line " + (n + 1) + " !");
                throw new IOException("Wrong data format");
            }
        }

    }

    public ArrayList<Element> getElementsArrayList() {
        return elements;
    }

    public Integer getNumberOfElements() {
        return n;
    }

    private boolean isRecognized(String element) {
        return element.equals("diodenormal") || element.equals("diodereversed")
                || element.equals("electronhead") || element.equals("electrontail")
                || element.equals("wire") || element.equals("orgate")
                || element.equals("xorgate") || element.equals("andgate")
                || element.equals("notgate");
    }

    private boolean isCorrectPoint(String x, String y) {
        if (x == null || y == null) {
            return false;
        }
        int lengthX = x.length();
        int lengthY = y.length();

        if (lengthX == 0 || lengthY == 0) {
            return false;
        }
        int i = 0;

        if (x.charAt(0) == '-') {
            return false;
        }
        if (y.charAt(0) == '-') {
            return false;
        }

        for (; i < lengthX; i++) {
            char c = x.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        i = 0;
        for (; i < lengthY; i++) {
            char c = y.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        /* - JEŚLI CHCE ZEBY PODANIE WSPÓŁRZĘDNEJ POZA ZAKRESEM SKUTOWAŁO BŁEDEM - ODPKOMENTOWAC
           // gdy jest zakomentowane, to pola poza zakresem po prostu nie są rysowane
        int maxX = (int) (MyDimensions.getBPwidth()/cellSize) - 1;
        int maxY = (int) (MyDimensions.getBPheight()/cellSize - 1);
        if(Integer.parseInt(x) < 0 || Integer.parseInt(x) > maxX) return false;
        if(Integer.parseInt(y) < 0 || Integer.parseInt(y) > maxY) return false;
        */
        return true;
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

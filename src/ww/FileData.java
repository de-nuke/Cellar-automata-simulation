/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ww;

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

    ArrayList<String> elements = new ArrayList();
    ArrayList<Element> elementes = new ArrayList();
    ArrayList<Point> coordinates = new ArrayList();
    Integer n = 0;

    public FileData() {

    }

    public FileData(File file) {
        try {
            readFromFile(file);
        } catch (FileNotFoundException fx) {
            System.err.println("IOException");
        } catch (IOException ex) {
            System.err.println("File Not Found");
        }
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
//                elements.add(lineParts[0]);
//                coordinates.add(new Point(Integer.parseInt(lineParts[1]), Integer.parseInt(lineParts[2])));
                Point p = new Point(Integer.parseInt(lineParts[1]), Integer.parseInt(lineParts[2]));
                switch(lineParts[0]) {
                    case "wire": {
                        elementes.add(new Wire("wire", p, "right", 3));
                    } break;
                    case "diodenormal": {
                        elementes.add(new DiodeN("diodenormal", p, "right", 7));
                    }
                    case "diodereversed": {
                        elementes.add(new DiodeR("diodereversed", p, "right", 7));
                    } break;
                    case "empty": {
                        elementes.add(new EmptyCell("empty", p, "right", 1));
                    } break;
                    case "electronhead": {
                        elementes.add(new ElectronHead("electronhead", p, "right", 1));
                    } break;
                    case "electrontail": {
                        elementes.add(new ElectronTail("electrontail", p, "right", 1));
                    } break;
                    case "orgate": {
                        elementes.add(new OrGate("orgate", p, "right", 10));
                    } break;
                    case "xorgate": {
                        elementes.add(new XorGate("xorgate", p, "right", 10));
                    } break;
                    case "andgate": {
                        elementes.add(new AndGate("andgate", p, "right", 20));
                    } break;
                    case "notgate": {
                        elementes.add(new NotGate("notgate", p, "right", 10));
                    } break;
                    default:
                        throw new IOException("Unknown element" + lineParts[0]);
                }

                n++;
            } else {
                System.err.println("Wrong data format in line " + (n+1) + "!");
                return;
            }
        }

    }

    public ArrayList<Element> getElementsArrayList() {
        return elementes;
    }
    
    public Element getElementNr(int i) {
        return elementes.get(i);
    }
    public String getElementNameAt(int elementIndex) {
        if (elementIndex < 0 || elementIndex >= elements.size()) {
            throw new IndexOutOfBoundsException("Index " + elementIndex + "is out of bounds.");
        } else {
            return elements.get(elementIndex);
        }
    }

    public Point getPointAt(int pointIndex) {
        if (pointIndex < 0 || pointIndex >= coordinates.size()) {
            throw new IndexOutOfBoundsException("Index " + pointIndex + "is out of bounds.");
        } else {
            return coordinates.get(pointIndex);
        }
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

        //Warto sprawdzic czy x.charAt(0) lub y.charAt(0)
        //są na pewno mniejsze niż na przykład 3 - jeśli mamy wymiary 300x300,
        //to najdalsze pole będzie miało x = 299, y = 299
        //Nie pisze tego teraz, bo nie wiem jaka będzie szerokość
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
        return true;
    }

    @Override
    public String toString() {
        String text = "FileData has succesfully read " + n + " elements: \n";
        for(int i = 0; i < n; i++) {
            text += elements.get(i) + " (" + coordinates.get(i).x + "," + coordinates.get(i).y + ") \n";
        }
        return text;
    }
    
    
    
}

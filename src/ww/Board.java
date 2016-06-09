/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ww;

import elements.*;
import java.awt.*;
import java.util.*;

/**
 *
 * @author Dom
 */
public class Board {
    
    Map<Point, Color> board = new HashMap<>();
    Integer[][] boardInts;
    public Board(int width, int height) {
        boardInts = new Integer[width][height];
    }
//    public void putFileData(FileData fd) {
//        int n = fd.getNumberOfElements();
//        for(int i = 0; i < n; i++) {
//            
//        }
//        
//    }
    public void addData(FileData fd) {
        ArrayList<Element> elementList = fd.getElementsArrayList();
        int n = elementList.size(); //number of elements
        for(Element e : elementList) {
            insertElement(e);
        }
    }
    
    private void insertElement(Element e) {

        switch (e.getName()) {
            case "wire": {
                for(int i = 0 ; i < e.getNumberOfCells(); i++) {
                    
                }
            }
            break;
            case "diodenormal": {
                DiodeN diodeN = (DiodeN) e;
                int[][] diodeArray = diodeN.getArray();
                int posX = e.getPosition().x;
                int posY = e.getPosition().y;
                for(int i = 0; i < e.getHeight(); i++) {
                    for(int j = 0; j < e.getWidth(); j++) {
                        boardInts[i+posX][j+posX] = diodeArray[i][j];
                    }
                }
            }
            case "diodereversed": {
               
            }
            break;
            case "empty": {
                
            }
            break;
            case "electronhead": {
                
            }
            break;
            case "electrontail": {
                
            }
            break;
            case "orgate": {
                
            }
            break;
            case "xorgate": {
                
            }
            break;
            case "andgate": {
                
            }
            break;
            case "notgate": {
                
            }
            break;
            default:
                
        }

    }
}






       /*        if (e instanceof Wire) {
        Wire wire = (Wire) e;
        } else if (e instanceof EmptyCell) {
        EmptyCell emptyCell = (EmptyCell) e;
        } else if (e instanceof ElectronHead) {
        ElectronHead electronHead = (ElectronHead) e;
        } else if (e instanceof ElectronTail) {
        ElectronTail electronTail= (ElectronTail) e;
        } else if (e instanceof DiodeN) {
        DiodeN diodeN = (DiodeN) e;
        } else if (e instanceof DiodeR) {
        DiodeR diodeR = (DiodeR) e;
        } else if (e instanceof OrGate) {
        OrGate orGate = (OrGate) e;
        } else if (e instanceof XorGate) {
        XorGate xorGate = (XorGate) e;
        } else if (e instanceof AndGate) {
        AndGate andGate = (AndGate) e;
        } else if (e instanceof NotGate) {
        NotGate notGate = (NotGate) e;
        }*/
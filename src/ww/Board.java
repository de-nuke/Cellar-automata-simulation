/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ww;

import elements.*;
import java.util.*;

/**
 *
 * @author Dom
 */
public class Board {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    Integer[][] boardInts;
    int width, height;

    public Board(int width, int height) {
        boardInts = new Integer[height][width];
        this.width = width;
        this.height = height;
        System.out.println(this.width + ", " + this.height);
        initializeBoard();
    }

    public Board(Board copied) {
        this.boardInts = cloneArray(copied.getArray());
        this.width = copied.width;
        this.height = copied.height;
    }

    public void addData(FileData fd) {
        ArrayList<Element> elementList = fd.getElementsArrayList();

        for (Element e : elementList) {
            insertElement(e,null,null);
        }
    }

    public Integer[][] getArray() {
        return boardInts;
    }

    @Override
    public String toString() {

        String text = "";
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (null != boardInts[i][j]) {
                    switch (boardInts[i][j]) {
                        case 0:
                            text += ANSI_WHITE + boardInts[i][j].toString() + ANSI_RESET;
                            break;
                        case 1:
                            text += ANSI_PURPLE + boardInts[i][j].toString() + ANSI_RESET;
                            break;
                        case 2:
                            text += ANSI_BLUE + boardInts[i][j].toString() + ANSI_RESET;
                            break;
                        case 3:
                            text += ANSI_RED + boardInts[i][j].toString() + ANSI_RESET;
                            break;
                        default:
                            break;
                    }
                }
            }
            text += "\n";
        }
        return text;
    }

    public void insertElement(Element e, Integer specifiedPosX, Integer specifiedPosY) {

        int posX, posY;
        if(specifiedPosX == null) 
            posX = e.getPosition().x;
        else
            posX = specifiedPosX;
        if(specifiedPosY == null)
            posY = e.getPosition().y;
        else
            posY = specifiedPosY;
        switch (e.getName()) {
            case "wire": {
                Wire wire = (Wire) e;
                int[][] wireArray = wire.getCellsArray();
                for (int i = 0; i < e.getHeight(); i++) {
                    for (int j = 0; j < e.getWidth(); j++) {
                        if(i+posY < height && j + posX < width)
                            boardInts[i + posY][j + posX] = wireArray[i][j];
                    }
                }
            }
            break;
            case "diodenormal": {
                DiodeN diodeN = (DiodeN) e;
                int[][] diodeArray = diodeN.getCellsArray();
                for (int i = 0; i < e.getHeight(); i++) {
                    for (int j = 0; j < e.getWidth(); j++) {
                        if(i+posY < height && j + posX < width)
                            boardInts[i + posY][j + posX] = diodeArray[i][j];
                    }
                }
            }
            case "diodereversed": {
                DiodeR diodeR = (DiodeR) e;
                int[][] diodeArray = diodeR.getCellsArray();
                for (int i = 0; i < e.getHeight(); i++) {
                    for (int j = 0; j < e.getWidth(); j++) {
                        if(i+posY < height && j + posX < width)
                            boardInts[i + posY][j + posX] = diodeArray[i][j];
                    }
                }
            }
            break;
            case "empty": {
//                EmptyCell emptyCells = (EmptyCell) e;
//                int[][] emptyCellsArray = emptyCells.getCellsArray();
                int[][]cellsArray = e.getCellsArray();
                for (int i = 0; i < e.getHeight(); i++) {
                    for (int j = 0; j < e.getWidth(); j++) {
                        if(i+posY < height && j + posX < width)
//                            boardInts[i + posY][j + posX] = emptyCellsArray[i][j];
                            boardInts[i + posY][j + posX] = cellsArray[i][j];
                    }
                }

            }
            break;
            case "electronhead": {
                ElectronHead electronHead = (ElectronHead) e;
                int[][] electronHeadArray = electronHead.getCellsArray();
                for (int i = 0; i < e.getHeight(); i++) {
                    for (int j = 0; j < e.getWidth(); j++) {
                        if(i+posY < height && j + posX < width)
                            boardInts[i + posY][j + posX] = electronHeadArray[i][j];
                    }
                }
            }
            break;
            case "electrontail": {
                ElectronTail electronTail = (ElectronTail) e;
                int[][] electronTailArray = electronTail.getCellsArray();
                for (int i = 0; i < e.getHeight(); i++) {
                    for (int j = 0; j < e.getWidth(); j++) {
                        if(i+posY < height && j + posX < width)
                            boardInts[i + posY][j + posX] = electronTailArray[i][j];
                    }
                }
            }
            break;
            case "orgate": {
                OrGate orGate = (OrGate) e;
                int[][] gateArray = orGate.getCellsArray();
                for (int i = 0; i < e.getHeight(); i++) {
                    for (int j = 0; j < e.getWidth(); j++) {
                        if(i+posY < height && j + posX < width)
                            boardInts[i + posY][j + posX] = gateArray[i][j];
                    }
                }
            }
            break;
            case "xorgate": {
                XorGate xorGate = (XorGate) e;
                int[][] gateArray = xorGate.getCellsArray();
                for (int i = 0; i < e.getHeight(); i++) {
                    for (int j = 0; j < e.getWidth(); j++) {
                        if(i+posY < height && j + posX < width)
                            boardInts[i + posY][j + posX] = gateArray[i][j];
                    }
                }
            }
            break;
            case "andgate": {
                AndGate andGate = (AndGate) e;
                int[][] gateArray = andGate.getCellsArray();
                for (int i = 0; i < e.getHeight(); i++) {
                    for (int j = 0; j < e.getWidth(); j++) {
                        if(i+posY < height && j + posX < width)
                            boardInts[i + posY][j + posX] = gateArray[i][j];
                    }
                }
            }
            break;
            case "notgate": {
                NotGate notGate = (NotGate) e;
                int[][] gateArray = notGate.getCellsArray();
                for (int i = 0; i < e.getHeight(); i++) {
                    for (int j = 0; j < e.getWidth(); j++) {
                        if(i+posY < height && j + posX < width)
                            boardInts[i + posY][j + posX] = gateArray[i][j];
                    }
                }
            }
            break;
            default:

        }

    }

    private void initializeBoard() {
        System.out.println(width + ", " + height);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                boardInts[i][j] = 0;
            }
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    private Integer[][] cloneArray(Integer[][] src) {
        int length = src.length;
        Integer[][] target = new Integer[length][src[0].length];
        for (int i = 0; i < length; i++) {
            System.arraycopy(src[i], 0, target[i], 0, src[i].length);
        }
        return target;
    }
}

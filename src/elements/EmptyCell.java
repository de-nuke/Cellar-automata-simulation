/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elements;

import java.awt.Point;

/**
 *
 * @author Dom
 */
public class EmptyCell extends Element {
    
    private int[][]emptyCells;
    
    public EmptyCell(String n, Point p,int width, int height ) {
        super(n,p,width,height); //niech sie da okreslax ile na ile ma byc wstawionych pustych
        emptyCells = new int[height][width];
        super.cellsArray = emptyCells;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                emptyCells[i][j] = 0;
            }
        }
    }
    
    @Override
    public int getDelta() {
        return 0;
    }
//    public int[][] getCellsArray() {
//        return emptyCells;
//    }
    
}

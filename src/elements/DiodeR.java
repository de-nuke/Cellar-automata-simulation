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
public class DiodeR extends Element {

    int diodeCellsX[][];

    public DiodeR(String n, Point p) {
        super(n, p, 6 * 3, 6, 3); //6 -width, 3 - height
        diodeCellsX = new int[][]{
            {0, 0, 1, 1, 0, 0},
            {1, 1, 0, 1, 1, 1},
            {0, 0, 1, 1, 0, 0}
        };
    }

    public int[][] getCellsArray() {
        return diodeCellsX;
    }
    
    @Override
    public int getDelta() {
        return 1;
    }
}

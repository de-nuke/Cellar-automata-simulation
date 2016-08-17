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
public class NotGate extends Element {
    private int gateCells[][];

    public NotGate(String n, Point p) {
        super(n, p, 8, 5); //6 -width, 3 - height
        gateCells = new int[][]{
            {0, 0, 1, 1, 0, 0, 0, 0},
            {1, 1, 0, 0, 1, 0, 1, 1},
            {0, 0, 0, 3, 3, 3, 0, 0},
            {0, 0, 2, 0, 2, 2, 0, 0},
            {0, 0, 1, 3, 1, 0, 0, 0}
        };
    }

    public int[][] getCellsArray() {
        return gateCells;
    }
    
    @Override
    public int getDelta() {
        return 1;
    }
}

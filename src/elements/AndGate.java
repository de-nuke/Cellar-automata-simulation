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
public class AndGate extends Element {

    int gateCells[][];

    public AndGate(String n, Point p) {
        super(n, p, 15 * 8, 15, 8); //6 -width, 3 - height
        gateCells = new int[][]{
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0},
            {1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0},
            {0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
            {0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1},
            {0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };
    }

    public int[][] getCellsArray() {
        return gateCells;
    }
}

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
public class XorGate extends Element {

    private int gateCells[][];

//    public XorGate(String n, Point p) {
//        super(n, p, 10, 7); //6 -width, 3 - height
//        gateCells = new int[][]{
//            {0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
//            {0, 0, 1, 0, 0, 1, 0, 0, 0, 0},
//            {1, 1, 0, 0, 1, 1, 1, 1, 0, 0},
//            {0, 0, 0, 0, 1, 0, 1, 1, 1, 1},
//            {1, 1, 0, 0, 1, 1, 1, 1, 0, 0},
//            {0, 0, 1, 0, 0, 1, 0, 0, 0, 0},
//            {0, 0, 0, 1, 1, 0, 0, 0, 0, 0}
//        };
//    }
        public XorGate(String n, Point p) {
        super(n, p, 5, 5); //6 -width, 3 - height
        gateCells = new int[][]{
           
            { 0, 1, 0, 0, 0},
            { 1, 1, 1, 1, 0},
            { 1, 0, 1, 1, 1},
            { 1, 1, 1, 1, 0},
            { 0, 1, 0, 0, 0},
            
        };
    }

    @Override
    public int[][] getCellsArray() {
        return gateCells;
    }
    
    @Override
    public int getDelta() {
        return 2;
    }
}

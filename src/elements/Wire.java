/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elements;

import java.awt.Color;
import java.awt.Point;

/**
 *
 * @author Dom
 */
public class Wire extends Element {

    int[][] wireCells;

    Color color = Color.BLACK;

    public Wire(String n, Point p, int width, int height) {
        super(n, p, width * height, width, height); //wire can be rectangle made of... wire. That's it.\
        wireCells = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                wireCells[i][j] = 1;
            }
        }
    }

    public int[][] getCellsArray() {
        return wireCells;
    }

    @Override
    public int getDelta() {
        return 0;
    }
}

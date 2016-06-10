/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elements;

import com.sun.prism.paint.Color;
import java.awt.Point;

/**
 *
 * @author Dom
 */
public class ElectronTail extends Element{
    
    Color color = Color.RED;
    int[][] electronCells;
    
    public ElectronTail(String n, Point p, int width, int height) {
        super(n,p, width*height, width, height);
        electronCells = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                electronCells[i][j] = 2;
            }
        }
    }

    public int[][] getCellsArray() {
        return electronCells;
    }
}

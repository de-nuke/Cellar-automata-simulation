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
public class ElectronHead extends Element{
    
    private int[][] electronCells;
    
    public ElectronHead(String n, Point p, int width, int height) {
        super(n,p, width, height);
        electronCells = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                electronCells[i][j] = 3;
            }
        }
    }

    public int[][] getCellsArray() {
        return electronCells;
    }
    
    @Override
    public int getDelta() {
        return 0;
    }
}

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
public class Element {
    String name;
    Point position; //left, upper corner
    int width;
    int height;
    int cellsArray[][];
    int delta;
    
    protected Element(String n, Point p,int w, int h) {
        this.name = n;
        this.position = p;
        this.width = w;
        this.height = h;
    }
    
    public String getName() {
        return name;
    }
    
    public Point getPosition() {
        return position;
    }

    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
    
    public int[][] getCellsArray() {
        return cellsArray;
    }
    public int getDelta(){
        return 0;
    }
    @Override
    public String toString() {
        return name + "( "+ position.x + "," + position.y + " ) - Dimensions:  " + width + " x " + height;
    }
}

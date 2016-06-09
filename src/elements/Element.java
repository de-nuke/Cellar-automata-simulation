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
    int numberOfCells;
    int width;
    int height;

    
    public Element(String n, Point p, int numberOfCells, int w, int h) {
        this.name = n;
        this.position = p;
        this.numberOfCells = numberOfCells;
        this.width = w;
        this.height = h;
    }
    
    public String getName() {
        return name;
    }
    
    public Point getPosition() {
        return position;
    }
    
    public int getNumberOfCells() {
        return numberOfCells;
    }

    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
}

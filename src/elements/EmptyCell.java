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
    String direction;
    int length;
    
    public EmptyCell(String n, Point p, String direction, int length ) {
        super(n,p);
        this.direction = direction;
        this.length = length;
    }
    
}

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
public class Wire extends Element {
    
    String direction;
    int length;
    int[] wireCells;
    
    public Wire(String n, Point p, String direction, int length ) {
        super(n,p, length);
        this.direction = direction;
        this.length = length;
        wireCells = new int[length];
        for(int i = 0, k = 0; i < length; i++) {
            wireCells[i] = k;
            if(direction.equals("right"))k++;
        }
        
        
    }
    
    
}

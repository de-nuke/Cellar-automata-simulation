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
    String direction;
    int length;
    
    public XorGate(String n, Point p, String direction, int length ) {
        super(n,p, 10*7);
        this.direction = direction;
        this.length = length;
    }
    
}

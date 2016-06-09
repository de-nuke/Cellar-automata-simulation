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
    String direction;
    int length;
    
    public AndGate(String n, Point p, String direction, int length ) { //Te duże struktury nie będa mialy lenghta
        super(n,p, 15*8, 15, 8); //15 is a width of andgate, 8 is height
        this.direction = direction;
        this.length = length;
    }
    
}

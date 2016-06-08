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
    
    
    public String getName() {
        return name;
    }
    
    public Point getPosition() {
        return position;
    }
}

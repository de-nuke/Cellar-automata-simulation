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
    public ElectronTail(String n, Point p) {
        super(n,p, 1, 1, 1);
    }
     
}

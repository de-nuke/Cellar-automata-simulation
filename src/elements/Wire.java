/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elements;

import java.awt.Color;
import java.awt.Point;

/**
 *
 * @author Dom
 */
public class Wire extends Element {

    Color color = Color.BLACK;
    public Wire(String n, Point p) {
        super(n, p, 1,1,1); //wire is one, black cell. That's all.
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ww;

import GUI.BoardPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author Dom
 */
public class Generator {

    Board first;
    Board second;
    BoardPanel bp;

    public Generator(Board first, Board second, BoardPanel bp) {
        this.first = first;
        this.second = second;
        this.bp = bp;
    }

    public void start() {
        System.out.println("Started");
    }

    public void stop() {
        System.out.println("Stopped");
    }
    
}

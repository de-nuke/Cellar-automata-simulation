/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Dimension;

/**
 *
 * @author Dom
 */
public class MyDimensions {
    static int MAIN_WIN_WIDTH = (int) (650 * 1.618);
    static int MAIN_WIN_HEIGH = 650;
    static int RBP_WIDTH = 270; 
    static int RBP_HEIGHT = 430;
    static int BP_WIDTH = 700;
    static int BP_HEIGHT = 430;
    static int BBP_WIDTH = 700;
    static int BBP_HEIGHT = 144;
    static Dimension BIG_BTN = new Dimension(250, 86);
    static Dimension SMALL_BTN = new Dimension(123, 30);
    static Dimension ELMNT_BTN = new Dimension(130, 60);
    public static int getBPwidth() {
        return BP_WIDTH;
    }
    
    public static int getBPheight() {
        return BP_HEIGHT;
    }
}

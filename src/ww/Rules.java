/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ww;

import java.awt.Dimension;

/**
 *
 * @author Dom
 */
public class Rules {
    
    int w;
    int h;
    
    public Rules(Dimension boardDimension) {
        this.w = boardDimension.width;
        this.h = boardDimension.height;
    }
    
    public int nextStateOf(Integer[][] brd, int i, int j) {
            
                if (brd[i][j] == 3) return 2;                       //Head -> Tail
                if (brd[i][j] == 2) return 1;                       //Tail -> Wire
                if (brd[i][j] == 0) return 0;                       //Empty->Empty
                if (brd[i][j] == 1 &&
                   (numOfNeighb(brd, i, j, w, h) == 1 ||
                    numOfNeighb(brd, i, j, w, h) == 2)) return 3;  //Wire -> Head
                
                return -1;
    }
    
    private int numOfNeighb(Integer[][] brd, int i, int j, int maxJ, int maxI) {
        int neighbNumber = 0;
        if (i > 0 && j > 0 && i < maxI - 1 && j < maxJ - 1) {
            if (brd[i - 1][j - 1] == 3)     neighbNumber++;
            if (brd[i][j - 1] == 3)         neighbNumber++;
            if (brd[i + 1][j - 1] == 3)     neighbNumber++;
            if (brd[i - 1][j] == 3)         neighbNumber++;
            if (brd[i + 1][j] == 3)         neighbNumber++;
            if (brd[i - 1][j + 1] == 3)     neighbNumber++;
            if (brd[i][j + 1] == 3)         neighbNumber++;
            if (brd[i + 1][j + 1] == 3)     neighbNumber++;
        } else if (i == 0 && j > 0 && j < maxJ - 1) {
            if (brd[i][j - 1] == 3)         neighbNumber++;
            if (brd[i + 1][j - 1] == 3)     neighbNumber++;
            if (brd[i + 1][j] == 3)         neighbNumber++;
            if (brd[i][j + 1] == 3)         neighbNumber++;
            if (brd[i + 1][j + 1] == 3)     neighbNumber++;
        } else if (i == 0 && j == 0) {
            if (brd[i + 1][j] == 3)         neighbNumber++;
            if (brd[i][j + 1] == 3)         neighbNumber++;
            if (brd[i + 1][j + 1] == 3)     neighbNumber++;
        } else if (i == 0 && j == maxJ - 1) {
            if (brd[i][j - 1] == 3)         neighbNumber++;
            if (brd[i + 1][j - 1] == 3)     neighbNumber++;
            if (brd[i + 1][j] == 3)         neighbNumber++;
        } else if (j == 0 && i > 0 && i < maxI - 1) {
            if (brd[i - 1][j] == 3)         neighbNumber++;
            if (brd[i + 1][j] == 3)         neighbNumber++;
            if (brd[i - 1][j + 1] == 3)     neighbNumber++;
            if (brd[i][j + 1] == 3)         neighbNumber++;
            if (brd[i + 1][j + 1] == 3)     neighbNumber++;
        } else if (j == 0 && i == maxI - 1) {
            if (brd[i - 1][j] == 3)         neighbNumber++;
            if (brd[i - 1][j + 1] == 3)     neighbNumber++;
            if (brd[i][j + 1] == 3)         neighbNumber++;
        } else if (i == maxI-1 && j > 0 && j < maxJ-1) {
            if (brd[i - 1][j - 1] == 3)     neighbNumber++;
            if (brd[i - 1][j] == 3)         neighbNumber++;
            if (brd[i - 1][j + 1] == 3)     neighbNumber++;
            if (brd[i][j - 1] == 3)         neighbNumber++;
            if (brd[i][j + 1] == 3)         neighbNumber++;
        } else if (i == maxI-1 && j == maxJ-1) {
            if (brd[i - 1][j - 1] == 3)     neighbNumber++;
            if (brd[i - 1][j] == 3)         neighbNumber++;
            if (brd[i][j - 1] == 3)         neighbNumber++;
        } else if (j == maxJ - 1 && i > 0 && i < maxI-1) {
            if (brd[i - 1][j - 1] == 3)     neighbNumber++;
            if (brd[i - 1][j] == 3)         neighbNumber++;
            if (brd[i][j - 1] == 3)         neighbNumber++;
            if (brd[i + 1][j - 1] == 3)     neighbNumber++;
            if (brd[i + 1][j] == 3)         neighbNumber++;
        }
        return neighbNumber;
    }
}

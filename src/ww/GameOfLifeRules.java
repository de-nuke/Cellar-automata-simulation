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
public class GameOfLifeRules implements Rules {
    
    private int w;
    private int h;
    
    public GameOfLifeRules(Dimension boardDimension) {
        this.w = boardDimension.width;
        this.h = boardDimension.height;
    }
    
    @Override
    public int nextStateOf(Integer[][] brd, int i, int j) {
            
                if (brd[i][j] == 0 && 
                    numOfNeighb(brd, i, j, w, h) == 3) return 1;    //Dead -> Living
                if (brd[i][j] == 0 &&
                    numOfNeighb(brd, i, j, w, h) != 3) return 0;    //Dead -> Dead
                if (brd[i][j] == 1 &&
                   (numOfNeighb(brd, i, j, w, h) == 2 ||
                    numOfNeighb(brd, i, j, w, h) == 3)) return 1;   //Living -> Living
                if (brd[i][j] == 1 &&
                    numOfNeighb(brd, i, j, w, h) != 2 &&
                    numOfNeighb(brd, i, j, w, h) != 3) return 0;   //Living -> Dead
                
                return -1;
    }
    
    @Override
    public int numOfNeighb(Integer[][] brd, int i, int j, int maxJ, int maxI) {
        int neighbNumber = 0;
        if (i > 0 && j > 0 && i < maxI - 1 && j < maxJ - 1) {
            if (brd[i - 1][j - 1] == 1)     neighbNumber++;
            if (brd[i][j - 1] == 1)         neighbNumber++;
            if (brd[i + 1][j - 1] == 1)     neighbNumber++;
            if (brd[i - 1][j] == 1)         neighbNumber++;
            if (brd[i + 1][j] == 1)         neighbNumber++;
            if (brd[i - 1][j + 1] == 1)     neighbNumber++;
            if (brd[i][j + 1] == 1)         neighbNumber++;
            if (brd[i + 1][j + 1] == 1)     neighbNumber++;
        } else if (i == 0 && j > 0 && j < maxJ - 1) {
            if (brd[i][j - 1] == 1)         neighbNumber++;
            if (brd[i + 1][j - 1] == 1)     neighbNumber++;
            if (brd[i + 1][j] == 1)         neighbNumber++;
            if (brd[i][j + 1] == 1)         neighbNumber++;
            if (brd[i + 1][j + 1] == 1)     neighbNumber++;
        } else if (i == 0 && j == 0) {
            if (brd[i + 1][j] == 1)         neighbNumber++;
            if (brd[i][j + 1] == 1)         neighbNumber++;
            if (brd[i + 1][j + 1] == 1)     neighbNumber++;
        } else if (i == 0 && j == maxJ - 1) {
            if (brd[i][j - 1] == 1)         neighbNumber++;
            if (brd[i + 1][j - 1] == 1)     neighbNumber++;
            if (brd[i + 1][j] == 1)         neighbNumber++;
        } else if (j == 0 && i > 0 && i < maxI - 1) {
            if (brd[i - 1][j] == 1)         neighbNumber++;
            if (brd[i + 1][j] == 1)         neighbNumber++;
            if (brd[i - 1][j + 1] == 1)     neighbNumber++;
            if (brd[i][j + 1] == 1)         neighbNumber++;
            if (brd[i + 1][j + 1] == 1)     neighbNumber++;
        } else if (j == 0 && i == maxI - 1) {
            if (brd[i - 1][j] == 1)         neighbNumber++;
            if (brd[i - 1][j + 1] == 1)     neighbNumber++;
            if (brd[i][j + 1] == 1)         neighbNumber++;
        } else if (i == maxI-1 && j > 0 && j < maxJ-1) {
            if (brd[i - 1][j - 1] == 1)     neighbNumber++;
            if (brd[i - 1][j] == 1)         neighbNumber++;
            if (brd[i - 1][j + 1] == 1)     neighbNumber++;
            if (brd[i][j - 1] == 1)         neighbNumber++;
            if (brd[i][j + 1] == 1)         neighbNumber++;
        } else if (i == maxI-1 && j == maxJ-1) {
            if (brd[i - 1][j - 1] == 1)     neighbNumber++;
            if (brd[i - 1][j] == 1)         neighbNumber++;
            if (brd[i][j - 1] == 1)         neighbNumber++;
        } else if (j == maxJ - 1 && i > 0 && i < maxI-1) {
            if (brd[i - 1][j - 1] == 1)     neighbNumber++;
            if (brd[i - 1][j] == 1)         neighbNumber++;
            if (brd[i][j - 1] == 1)         neighbNumber++;
            if (brd[i + 1][j - 1] == 1)     neighbNumber++;
            if (brd[i + 1][j] == 1)         neighbNumber++;
        }
        return neighbNumber;
    }
}

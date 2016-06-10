/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestingGUI;

/**
 *
 * @author Dom
 */
public class ExampleBoard {
    
    int[][] b;
    
    public ExampleBoard(int n) {
        b = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                b[i][j] = (i+j)%3;
            }
        }
    }
    
    public int[][] getArray() {
        return b;
    }
}

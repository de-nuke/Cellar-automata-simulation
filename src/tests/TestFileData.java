/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import java.io.File;
import ww.Board;
import ww.FileData;

/**
 *
 * @author Dom
 */
public class TestFileData {
    
    public static void main(String[] args) {
        
        FileData fd1 = new FileData(new File("data.txt"));
        Board b = new Board(100,100);
        b.addData(fd1);
        
        System.out.println("WYPISUJE FILEDATA: \n");
        System.out.println(fd1.toString());
        
        System.out.println("WYPISUJE BOARD: \n");
        System.out.println(b.toString());
        
    }
}

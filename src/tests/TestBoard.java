/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import java.io.File;
import java.io.IOException;
import ww.Board;
import ww.FileData;

/**
 *
 * @author Dom
 */
public class TestBoard {

    public static void main(String[] args) {
        FileData fd;
        try {
            fd = new FileData(new File("test3.txt"), 10);
            Board b = new Board(10, 10);
            b.addData(fd);
            System.out.println(b.toString());
        } catch (IOException ex) {

        }
    }
}

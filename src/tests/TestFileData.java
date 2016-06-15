/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import java.io.File;
import java.io.IOException;
import ww.FileData;

/**
 *
 * @author Dom
 */
public class TestFileData {
    
    public static void main(String[]args) {
        FileData fd;
        try {
            fd = new FileData(new File("test2.txt"), 10);
            System.out.println(fd.toString());
        } catch (IOException ex) {
            
        }
    }
}

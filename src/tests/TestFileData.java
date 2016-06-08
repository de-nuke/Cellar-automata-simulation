/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import java.io.File;
import ww.FileData;

/**
 *
 * @author Dom
 */
public class TestFileData {
    
    public static void main(String[] args) {
        
        FileData fd1 = new FileData(new File("data.txt"));
        System.out.println(fd1.toString());
        
        FileData fd2 = new FileData(new File("wrongdata.txt"));
        System.out.println(fd2.toString());
        
        FileData fd3 = new FileData(new File("wrongelement.txt"));
        System.out.println(fd3.toString());
        
        FileData fd4 = new FileData(new File("wrongpoint.txt"));
        System.out.println(fd4.toString());
        
    }
}

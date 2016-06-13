/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import elements.*;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import ww.Board;
import ww.Generator;

/**
 *
 * @author Dom
 */
public class PanelsControl {

    private BoardPanel bp;
    private BottomButtonPanel bbp;
    private RightButtonPanel rbp;
    private OptionsPanel op;
    boolean isPlaying = false;
    
    Generator generator;
    

    public void setBoardPanel(BoardPanel bp) {
        this.bp = bp;
        generator = new Generator(bp);
    }

    public void setBottomButtonPanel(BottomButtonPanel bbp) {
        this.bbp = bbp;
    }

    public void setRightButtonPanel(RightButtonPanel rbp) {
        this.rbp = rbp;
    }
    
    public void setOptionsPanel(OptionsPanel op) {
        this.op = op;
    }

    /** RightButtonPanel **/
    public void play() {
        if(!isPlaying) {
            generator.start();
            isPlaying = true;
        } else {
            generator.stop();
            isPlaying = false;
        }
            
    }
    
    public void singleStep() {
          generator.transform();
    }
    
    public void faster() {
        System.out.println("przyspieszam generator");
        generator.changeSleepTime(-50);
    }
    
    public void slower() {
        generator.changeSleepTime(50);
    }
    
    public void loadFile()  throws IOException {
        JFileChooser fc = new JFileChooser();
        int returnVal = fc.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            System.out.println("HURRA OTWORZYLEM PLIK");
            bp.takeFile(file);
            bp.repaint();
        }

    }
    /** BottomButtonPanel **/
    public void insertElement(ActionEvent e) {
        JButton btn = (JButton) e.getSource();
        Point tempPoint = new Point(0,0);
        switch(btn.getText()) {
            case "Empty": {
                bp.putElement(new EmptyCell("empty", tempPoint, 1, 1));
            } break;
            case "Wire": {
                bp.putElement(new Wire("wire", tempPoint, 1,1));
            } break;
            case "ElectronHead": {
                bp.putElement(new ElectronHead("electronhead", tempPoint, 1, 1));
            } break;
            case "ElectronTail": {
                bp.putElement(new ElectronTail("electrontail", tempPoint, 1, 1));
            } break;
            case "Diode Normal": {
                bp.putElement(new DiodeN("diodenormal", tempPoint));
            } break;
            case "Diode Reversed": {
                bp.putElement(new DiodeR("diodereversed", tempPoint));
            } break;
            case "OR gate": {
               bp.putElement(new OrGate("orgate", tempPoint)); 
            } break;
            case "XOR gate": {
                bp.putElement(new XorGate("xorgate", tempPoint)); 
            } break;
            case "AND gate": {
                bp.putElement(new AndGate("andgate", tempPoint)); 
            } break;
            case "NOT gate": {
                bp.putElement(new NotGate("notgate", tempPoint)); 
            } break;
        }
    }
    
    /** OptionsPanel **/
    public void reset() {
        int width = bp.nH;
        int height = bp.nV;
        bp.updateBoard(new Board(width, height));
        bp.repaint();
        
        op.clearTextField();
        op.clearLabel();
        
        generator.setSleepTime(500);
    }

    public void saveToTxt() {
        bp.writeToTxt();
    }
    

}

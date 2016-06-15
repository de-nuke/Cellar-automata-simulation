/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import elements.*;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.swing.JButton;
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
    private OtherSettingsPanel osp;
    private ColorSettingsPanel csp;
    private SettingsWindow s;
    private WireWorldMainWindow m;
    private boolean isPlaying = false;
    
    private Generator generator;
    

    public void setBoardPanel(BoardPanel bp) {
        this.bp = bp;
        generator = new Generator(bp);
        generator.setControl(this);
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

    void setOtherSettingsPanel(OtherSettingsPanel osp) {
        this.osp = osp;
    }
    
    void setWindows(SettingsWindow s, WireWorldMainWindow m) {
        this.s = s;
        this.m = m;
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
        generator.changeSleepTime(-50);
        System.out.println("Changed generator's sleep time to " + generator.getSleepTime() + " miliseconds.");
    }
    
    public void slower() {
        generator.changeSleepTime(50);
        System.out.println("Changed generator's sleep time to " + generator.getSleepTime() + " miliseconds.");
    }
    
    public void loadFile()  throws IOException {
        bp.loadFile();

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
        bp.reset();
        op.reset();
        rbp.reset();
        generator.stop();
        generator.setSleepTime(500);
    }

    public void saveToTxt() {
        bp.writeToTxt();
    }
    
    public void setNumOfGen(int n){
        generator.setNumOfGen(n);
    }

    public void genStopped() {
        rbp.reset();
    }

    public void numLeft(int numOfGen) {
        op.numLeft(numOfGen);
    }

    void showMessage(String message, Color c) {
        op.showMessage(message, c);
    }
    
    public void closeApplication(){
        s.dispose();
        m.dispose();
    }

    void setColorSettingsPanel(ColorSettingsPanel csp) {
        this.csp = csp;
    }

    void repaintBoard() {
        bp.repaint();
    }

    

}

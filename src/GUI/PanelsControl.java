/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import elements.*;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JPanel;
import ww.GameOfLifeRules;
import ww.Generator;
import ww.Rules;
import ww.WireWorldRules;

/**
 *
 * @author Dom
 */
public class PanelsControl {

    private BoardPanel bp;
    private BottomButtonPanel bbp;
    private LeftButtonPanel lbp;
    private OptionsPanel op;
    private OtherSettingsPanel osp;
    private ColorSettingsPanel csp;
    private SettingsWindow s;
    private WireWorldMainWindow m;
    private boolean isPlaying = false;
    private JPanel currentPanel = null;
    private GridBagConstraints c;
    private Element pickedElement = null;
    private Generator generator;
    private AdditionalPanel ap;
    private GameOfLifeButtonPanel golp;

    public void setBoardPanel(BoardPanel bp) {
        this.bp = bp;
        generator = new Generator(bp);
        generator.setControl(this);
    }

    public void setAdditionalPanel(AdditionalPanel ap) {
        this.ap = ap;
    } 
    
    public void setBottomButtonPanel(BottomButtonPanel bbp) {
        this.bbp = bbp;
    }

    public void setRightButtonPanel(LeftButtonPanel rbp) {
        this.lbp = rbp;
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
            case "Empty": 
            case "Dead cell" :{
                bp.putElement(new EmptyCell("empty", tempPoint, 1, 1));
            } break;
            case "Wire":
            case "Living cell" :{
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
        lbp.reset();
        generator.stop();
        generator.setSleepTime(500);
    }

    public void saveToTxt() {
        bp.writeToTxt();
    }
    
    public void setNumOfGen(int n){
        generator.setNumOfGen(n);
    }

    public void setRules(Rules rules){
        generator.setRules(rules);
    }
    
    public void genStopped() {
        lbp.reset();
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

    void setPickedElement(Element pickedElement) {
        this.pickedElement = pickedElement;
    }

    void showElementPreview() {
        ap.showElementPreview(pickedElement);
    }
    
    public void switchGame() {
        if(currentPanel != null) {
            System.out.println("currentPanel nie jest null");
            if(currentPanel == bbp) {
                System.out.println("Current panel == bbp");
                m.remove(bbp);
                c.gridy = 1; c.gridx = 2; m.add(golp, c);
                currentPanel = golp;
                generator.setRules(new GameOfLifeRules(bp.getBoard().getDimension()));
            } else if(currentPanel == golp) {
                System.out.println("Current panel == golp");
                m.remove(golp);
                c.gridy = 1; c.gridx = 2; m.add(bbp, c);
                currentPanel = bbp;
                generator.setRules(new WireWorldRules(bp.getBoard().getDimension()));
            }
        }
        else System.err.println("Aaaaaaa");
        m.revalidate();
        m.repaint();
        System.err.println("Jestem w switch game");
    }

    void setGameOfLifePanel(GameOfLifeButtonPanel golp) {
        this.golp = golp;
    }
    
    void setCurrentPanel(JPanel currentPanel, GridBagConstraints c) {
        this.currentPanel = currentPanel;
        this.c = c;
    }

    

}

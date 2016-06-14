/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ww;

import GUI.*;
import java.awt.Dimension;

/**
 *
 * @author Dom
 */
public class Generator {
    PanelsControl control;
    
    private BoardPanel bp;
    private GenerationThread genThread;
    private int sleepTime = 500;
    private int numOfGen = 0;
    public Generator(BoardPanel bp) {
        this.bp = bp;
    }

    public void transform() {
        Board current = bp.getBoard();
        Board transformed = new Board(current);

        Integer[][] brd1 = current.getArray();
        Integer[][] brd2 = transformed.getArray();

        Dimension boardDimension = current.getDimension();
        Rules rules = new Rules(boardDimension);
        if (current == transformed) {
            System.out.println("Ten sam adres tablic");
        }
        for (int i = 0; i < boardDimension.height; i++) {
            for (int j = 0; j < boardDimension.width; j++) {
                int a = rules.nextStateOf(brd1, i, j);
                brd2[i][j] =  a == -1 ? brd2[i][j] : a;
            }
        }
        
        bp.updateBoard(transformed);
        bp.repaint();
    }

    public void start() {
        System.out.println("Started");
        if (genThread == null) {
            genThread = new GenerationThread();
            new Thread(genThread).start();
        }
    }

    public void stop() {
        if(genThread != null) {
            System.out.println("Stopped");
            genThread.isGenerating = false;
            genThread = null;
        }
        
    }
    
    public void changeSleepTime(int timeInMs) {
        if(timeInMs < 0) {
            if(sleepTime > 50)
                sleepTime += timeInMs;
        } else {
            if(sleepTime < 3000)
                sleepTime += timeInMs;
        }

    }
    
    public void setSleepTime(int timeInMs) {
        if(timeInMs > 0 && timeInMs < 60000) {  //max 1min.
            sleepTime = timeInMs;
        }
    }

    public int getSleepTime() {
        return sleepTime;
    }

    public void setNumOfGen(int n) {
        numOfGen = n;
    }
    
    public void setControl(PanelsControl control) {
        this.control = control;
    }
   
    /*****************************************/
    class GenerationThread implements Runnable {

        boolean isGenerating;

        public GenerationThread() {
            isGenerating = true;
        }

        @Override
        public void run() {
            boolean isLimited = false;
            if(numOfGen == 0) isLimited = false;
            else if (numOfGen > 0) isLimited = true;
            
            while (isGenerating) {
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {

                }
                transform();
                bp.repaint();
                if(isLimited) {
                    control.numLeft(numOfGen);
                    if(--numOfGen == 0) {
                        control.genStopped();
                        break;
                    }
                }
            }
        }
    }
}

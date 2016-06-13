/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ww;

import GUI.BoardPanel;

/**
 *
 * @author Dom
 */
public class Generator {

    BoardPanel bp;
    GenerationThread genThread;
    int sleepTime = 500;

    public Generator(BoardPanel bp) {
        this.bp = bp;
    }

    public void transform() {
        Board current = bp.getBoard();
        Board transformed = new Board(current);

        Integer[][] brd1 = current.getArray();
        Integer[][] brd2 = transformed.getArray();

        int w = current.getWidth();
        int h = current.getHeight();

        if (current == transformed) {
            System.out.println("Ten sam adres tablic");
        }
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (brd1[i][j] == 3) {
                    brd2[i][j] = 2;     //ElectronHead -> ElectronTail
                }
                if (brd1[i][j] == 2) {
                    brd2[i][j] = 1;     //ElectronTail -> Wire
                }
                if (brd1[i][j] == 0) {
                    brd2[i][j] = 0;     //Empty -> Empty
                }
                if (brd1[i][j] == 1 && (numOfNeighb(brd1, i, j, w, h) == 1 || numOfNeighb(brd1, i, j, w, h) == 2)) {
                    brd2[i][j] = 3;     // Wire -> ElectronHead
                }
            }
        }
        
        bp.updateBoard(transformed);
        bp.repaint();
    }

    private int numOfNeighb(Integer[][] brd, int i, int j, int maxJ, int maxI) {
        int neighbNumber = 0;
//        int maxI = bp.getBoard().getHeight();
//        int maxJ = bp.getBoard().getWidth();
        if (i > 0 && j > 0 && i < maxI - 1 && j < maxJ - 1) {
            if (brd[i - 1][j - 1] == 3) {
                neighbNumber++;
            }
            if (brd[i][j - 1] == 3) {
                neighbNumber++;
            }
            if (brd[i + 1][j - 1] == 3) {
                neighbNumber++;
            }
            if (brd[i - 1][j] == 3) {
                neighbNumber++;
            }
            if (brd[i + 1][j] == 3) {
                neighbNumber++;
            }
            if (brd[i - 1][j + 1] == 3) {
                neighbNumber++;
            }
            if (brd[i][j + 1] == 3) {
                neighbNumber++;
            }
            if (brd[i + 1][j + 1] == 3) {
                neighbNumber++;
            }
        } else if (i == 0 && j > 0 && j < maxJ - 1) {
            if (brd[i][j - 1] == 3) {
                neighbNumber++;
            }
            if (brd[i + 1][j - 1] == 3) {
                neighbNumber++;
            }
            if (brd[i + 1][j] == 3) {
                neighbNumber++;
            }
            if (brd[i][j + 1] == 3) {
                neighbNumber++;
            }
            if (brd[i + 1][j + 1] == 3) {
                neighbNumber++;
            }
        } else if (i == 0 && j == 0) {
            if (brd[i + 1][j] == 3) {
                neighbNumber++;
            }
            if (brd[i][j + 1] == 3) {
                neighbNumber++;
            }
            if (brd[i + 1][j + 1] == 3) {
                neighbNumber++;
            }
        } else if (i == 0 && j == maxJ - 1) {
            if (brd[i][j - 1] == 3) {
                neighbNumber++;
            }
            if (brd[i + 1][j - 1] == 3) {
                neighbNumber++;
            }
            if (brd[i + 1][j] == 3) {
                neighbNumber++;
            }
        } else if (j == 0 && i > 0 && i < maxI - 1) {
            if (brd[i - 1][j] == 3) {
                neighbNumber++;
            }
            if (brd[i + 1][j] == 3) {
                neighbNumber++;
            }
            if (brd[i - 1][j + 1] == 3) {
                neighbNumber++;
            }
            if (brd[i][j + 1] == 3) {
                neighbNumber++;
            }
            if (brd[i + 1][j + 1] == 3) {
                neighbNumber++;
            }
        } else if (j == 0 && i == 0) {
            if (brd[i + 1][j] == 3) {
                neighbNumber++;
            }
            if (brd[i][j + 1] == 3) {
                neighbNumber++;
            }
            if (brd[i + 1][j + 1] == 3) {
                neighbNumber++;
            }
        } else if (j == 0 && i == maxI - 1) {
            if (brd[i - 1][j] == 3) {
                neighbNumber++;
            }
            if (brd[i - 1][j + 1] == 3) {
                neighbNumber++;
            }
            if (brd[i][j + 1] == 3) {
                neighbNumber++;
            }
        }
        return neighbNumber;

    }

    public void start() {
        System.out.println("Started");
        if (genThread == null) {
            genThread = new GenerationThread();
            new Thread(genThread).start();
        }
    }

    public void stop() {
        System.out.println("Stopped");
        genThread.isGenerating = false;
        genThread = null;
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
    /*****************************************/
    class GenerationThread implements Runnable {

        boolean isGenerating;

        public GenerationThread() {
            isGenerating = true;
        }

        @Override
        public void run() {
            while (isGenerating) {
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {

                }
                transform();
                bp.repaint();
            }
        }

    }

}

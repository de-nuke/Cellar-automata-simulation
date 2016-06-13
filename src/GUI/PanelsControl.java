/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import elements.*;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.Timer;
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
    boolean isPlaying = false;

    public void setBoardPanel(BoardPanel bp) {
        this.bp = bp;
    }

    public void setBottomButtonPanel(BottomButtonPanel bbp) {
        this.bbp = bbp;
    }

    public void setRightButtonPanel(RightButtonPanel rbp) {
        this.rbp = rbp;
    }

    public void loadFile()
            throws IOException {
        JFileChooser fc = new JFileChooser();
        int returnVal = fc.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            System.out.println("HURRA OTWORZYLEM PLIK");
            bp.takeFile(file);
            bp.repaint();
        }

    }

    public void singleStep() {
        Board current = bp.getBoard();
        Board transformed = new Board(current);
        if (current == transformed) {
            System.out.println("To je to samo");
        }
        transform(current.getArray(), transformed.getArray(), transformed.getWidth(), transformed.getHeight());
        bp.updateBoard(transformed);
        bp.repaint();
    }

    private void transform(Integer[][] brd1, Integer[][] brd2, int w, int h) {
        if (brd1 == brd2) {
            System.out.println("TEn sam adres tablic");
        }
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (brd1[i][j] == 3) {
                    brd2[i][j] = 2;
                    System.out.println("ElectronHead -> ElectronTail");
                } //ElectronHead -> ElectronTail
                if (brd1[i][j] == 2) {
                    brd2[i][j] = 1; //ElectronTail -> Wire
                }
                if (brd1[i][j] == 0) {
                    brd2[i][j] = 0; //Empty -> Empty
                }
                if (brd1[i][j] == 1 && (numOfNeighb(brd1, i, j, w, h) == 1 || numOfNeighb(brd1, i, j, w, h) == 2)) {
                    brd2[i][j] = 3; // Wire -> ElectronHead
                }
            }
        }

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
                
            } break;
            case "Diode Reversed": {
                
            } break;
            case "OR gate": {
                
            } break;
            case "XOR gate": {
                
            } break;
            case "AND gate": {
                
            } break;
            case "NOT gate": {
                
            } break;
        }
    }
}

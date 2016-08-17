/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.additionalPanelComponents;

import elements.Element;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.JLabel;

/**
 *
 * @author Dom
 */
public class Preview extends JPanel {

    private JLabel text1 = new JLabel("Structure");
    private JLabel text2 = new JLabel("preview");
    private JPanel previewPanel;

    private int pWidth;
    private int pHeight;

    private Element pickedElement = null;

    public Preview(Color background, int w, int h) {
        setLayout(new FlowLayout());

        pWidth = w;
        pHeight = h;

        text1.setOpaque(false);
        text2.setOpaque(false);
        previewPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (pickedElement != null) {

                    int cellSize = 10;
                    Color emptyCellColor = Color.WHITE;
                    Color wireColor = Color.BLACK;
                    Color etColor = Color.BLUE;
                    Color ehColor = Color.RED;
                    int nH = (int) (pWidth / cellSize);
                    int nV = (int) (pHeight / cellSize);
                    int[][] brd = pickedElement.getCellsArray();

                    int minV = Math.min(nV, pickedElement.getHeight());
                    int minH = Math.min(nH, pickedElement.getWidth());

//                    int startposV = (nV - pickedElement.getHeight())/2;
                    int startposV = 0;
                    int startposH = (nH - pickedElement.getWidth())/2;
//                    int startposH = 0;
                    for (int i = 0; i < minV; i++) {
                        for (int j = 0; j < minH; j++) {
                            if (brd[i][j] == 0) {
                                g.setColor(emptyCellColor);
                            } else if (brd[i][j] == 1) {
                                g.setColor(wireColor);
                            } else if (brd[i][j] == 2) {
                                g.setColor(etColor);
                            } else if (brd[i][j] == 3) {
                                g.setColor(ehColor);
                            }
                            g.fillRect((j  + startposH )* cellSize, (i + startposV) * cellSize, cellSize - 1, cellSize - 1);
                        }
                    }
                }

            }
        };
        previewPanel.setPreferredSize(new Dimension(w - 10, w - 10));
        previewPanel.setOpaque(true);
        previewPanel.setBackground(Color.red);

        add(text1);
        add(text2);
        add(previewPanel);

    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(pWidth, pHeight);
    }
//    @Override
//    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        
//    }

    public void updatePreview(Element pickedElement) {
        this.pickedElement = pickedElement;
        if (pickedElement == null) {

        } else {
            previewPanel.repaint();
        }
    }

}

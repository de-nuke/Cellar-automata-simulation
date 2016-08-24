/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ww;

/**
 *
 * @author Dom
 */
public interface Rules {
    public int nextStateOf(Integer[][] brd, int i, int j);
    public int numOfNeighb(Integer[][] brd, int i, int j, int maxJ, int maxI);
}

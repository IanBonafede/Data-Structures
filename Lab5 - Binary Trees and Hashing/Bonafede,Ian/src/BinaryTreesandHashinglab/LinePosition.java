/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BinaryTreesandHashinglab;

/**
 *
 * @author csis
 */
public class LinePosition {
    private int lineNumber;
    private int position;
    
    /**Creates a LinePosition object with two integers as arguments.
     *
     * @param lN
     * @param p
     */
    public LinePosition(int lN, int p) {
        lineNumber = lN;
        position = p;
    }
    
    /**returns the value of lineNumber.
     *
     * @return integer
     */
    public int getlineNumber() {
        return lineNumber;
    }
    
    /**returns the value of position.
     *
     * @return integer
     */
    public int getPosition() {
        return position;
    }
    
}

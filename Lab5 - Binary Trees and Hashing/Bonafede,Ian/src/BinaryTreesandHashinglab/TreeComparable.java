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
public interface TreeComparable {
    
    /** Compares two objects defined by the user.
     *
     * @param o
     * @return integer
     */
    public int compareTo(Object o);
    
    /** Will visit nodes in a tree. What it does is defined by the user.
     *
     */
    public void visit();
    
    /** Performed when a duplicate object is placed in a tree and should 
     * increment a counter that signifies how many objects, defined by the user,
     * there are in the tree.
     *
     * @param o
     */
    public void operate(Object o);
    
}

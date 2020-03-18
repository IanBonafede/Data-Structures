/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BinaryTreesandHashinglab;

/**
 *
 * @author Ian_2
 */
public interface Comparable {
    
    /**Allows the object list class methods to correctly use the 
     * comparing methods, defined in various object classes, to sort a list
     *
     * @param o
     * @return
     */
    public int compareTo(Object o);
    
}

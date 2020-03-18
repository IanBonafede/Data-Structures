/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonafede.ian_stacklab;

/**
 *
 * @author Ian_2
 */
public interface ObjectStackInterface {
    
    /** returns true if the value of the top is equal to the array length
     *
     * @return boolean
     */
    public boolean isEmpty();

    /**Creates a new object array for a new stack and sets top back to the bottom
     *
     */
    public void clear();

    /**places an object at the top and increments the top
     *
     * @param x
     */
    public void push(Object x);

    /**returns the item at the top and decrements the top
     *
     * @return Object
     */
    public Object pop();

    /**returns the value of the item at the top
     *
     * @return Object
     */
    public Object top();
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3.queue.lab;

/**
 *
 * @author Ian_2
 */
public interface OjectQueueInterface {

    /**returns true if the count equals 0, the count decrements when an item is
     * removed but increments when an item is inserted
     *
     * @return boolean
     */
    public boolean isEmpty();
    
    /**returns true the count equals the length of the array that the 
     * object queue is implemented by.the count decrements when an item is
     * removed but increments when an item is inserted
     *
     * @return boolean
     */
    public boolean isFull();
    
    /**Clears the queue by making an entirely new queue with the same name
     *
     */
    public void clear();
     
    /**resizes the array to a size double the length of the original,
     * inserts the object in the argument into the array above the element that 
     * rear points to, and increments count and rear by 1
     *
     * @param o
     */
    public void insert(Object o);

    /**
     *removes the object in the array at the element that 
     * front points to, then increments front, and decrements count by 1
     * 
     * @return Object
     */
    public Object remove();
    
    /**returns the item at the front of the queue, or the item that will be
     * removed next, if the queue is not empty
     *
     * @return Object
     */
    public Object query();
    
}

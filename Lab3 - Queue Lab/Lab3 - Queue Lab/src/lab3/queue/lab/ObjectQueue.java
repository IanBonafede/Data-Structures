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
public class ObjectQueue {
        
    private Object[] item;
    private int front;
    private int rear;
    private int count;

    /**Creates an object queue, implemented by an object array
     *
     */
    public ObjectQueue() {
        item = new Object[1];
        front = 0;
        rear  = -1;
        count = 0;
    }

    /**returns true if the count equals 0, the count decrements when an item is
     * removed but increments when an item is inserted
     *
     * @return boolean
     */
    public boolean isEmpty() {
        return count == 0;
    }
    
    /**returns true the count equals the length of the array that the 
     * object queue is implemented by.the count decrements when an item is
     * removed but increments when an item is inserted
     *
     * @return boolean
     */
    public boolean isFull() {
        return count == item.length;
    }
    
    /**Clears the queue by making an entirely new queue with the same name
     *
     */
    public void clear() {
        item = new Object[1];
        front = 0;
        rear  = -1;
        count = 0;
    }
     
    /**resizes the array to a size double the length of the original,
     * inserts the object in the argument into the array above the element that 
     * rear points to, and increments count and rear by 1
     *
     * @param o
     */
    public void insert(Object o) {
        if (isFull())
            resize(2 * item.length);
        rear = (rear+1) % item.length;
        item[rear] = o;
        ++count;
    }

    /**
     * removes the object in the array at the element that 
     * front points to, then increments front, and decrements count by 1
     * 
     * @return Object
     */
    public Object remove() {
        if (isEmpty()) {
            new Exception("Remove Runtime Error: "
                    + "Queue Underflow").printStackTrace();
            System.exit(1);
        }
        Object temp = item[front];
        item[front] = null;
        front = (front+1) % item.length;
        --count;
        if (count == item.length/4 && item.length != 1)
            resize(item.length/2);
        return temp;
    }
    
    /**returns the item at the front of the queue, or the item that will be
     * removed next, if the queue is not empty
     *
     * @return Object
     */
    public Object query() {
        if (isEmpty()) {
            new Exception("Remove Runtime Error: "
                    + "Queue Underflow").printStackTrace();
            System.exit(1);
        }
        return item[front];
    }

    private void resize(int size) {
        Object[] temp = new Object[size];
        for (int i = 0; i < count; ++i) {
            temp[i] = item[front];
            front = (front+1) % item.length;
        }
        front = 0;
        rear = count-1;
        item = temp;
    }
}
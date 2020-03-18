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
public class ObjectStack implements ObjectStackInterface {
    
    private Object[] item;
    private int top;
    
    /**
     *
     */
    public ObjectStack() {
        item = new Object[1];
        top = -1;
    }

    /**returns true if the value of the top is -1
     *
     * @return boolean
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**returns true if the value of the top is equal to the array length
     *
     * @return boolean
     */
    public boolean isFull() {
        return top == item.length-1;
    }
    
    /**Creates a new object array for a new stack and sets top back to the bottom
     *
     */
    public void clear() {
        item = new Object[1];
        top = -1;
    }
    
    /** places an object at the top and increments the top
     *
     * @param o
     */
    public void push(Object o) {
        if (isFull())
            resize(2 * item.length);
        item[++top] = o;
    }
    
    private void resize(int size) {
        Object[] temp = new Object[size];
        for (int i = 0; i <= top; i++)
            temp[i] = item[i];
        item = temp;
    }

    /**returns the item at the top and decrements the top
     *
     * @return Object
     */
    public Object pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow1");
            System.exit(1);
        }
        Object temp = item[top];
        item[top--] = null;
        if (top == item.length/4)
            resize(item.length/2);
        return temp;
    }
    
    /** returns the value of the item at the top
     *
     * @return Object
     */
    public Object top() {
        if (isEmpty()) {
            System.out.println("Stack Underflow2");
            System.exit(1);
        }    
        return item[top];
    }
    
}

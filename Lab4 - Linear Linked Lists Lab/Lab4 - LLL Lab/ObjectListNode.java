/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonafede.ian_linearlinkedlistlab;

/**
 *
 * @author Ian_2
 */
public class ObjectListNode {
    private Object info;
    private ObjectListNode next;
    
    // Default ctor    

    /**Creates and list node that holds an object
     * with info and the next fields both set to null
     *
     */
        public ObjectListNode() {
        info = null;
        next = null;
    }

    // One-arg ctor

    /**Creates and list node that holds an object
     * with info set to the object passed and the next field both set to null
     *
     * @param o
     */
        public ObjectListNode (Object o) {
        info = o;
        next = null;
    }    
    
    // Two-arg ctor

    /**Creates and list node that holds an object
     * with info set to the object passed and the next field both set to the
     * node passed
     *
     * @param o
     * @param p
     */
        public ObjectListNode (Object o, ObjectListNode p) {
        info = o;
        next = p;
    }       

    // Sets info field

    /**Sets the info to an object passed
     *
     * @param o
     */
        public void setInfo(Object o) {
        info = o;
    }    

    // Returns object in info field

    /**returns the object in the info field
     *
     * @return Object
     */
        public Object getInfo() {
        return info;
    }

    // Sets next field

    /**sets the node in the next field to the node passed
     *
     * @param p
     */
        public void setNext(ObjectListNode p) {
        next = p;
    }

    // Returns object in info field

    /**returns the node in the next field
     *
     * @return ObjectListNode
     */
        public ObjectListNode getNext() {
        return next;
    }
    
}

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
public interface ObjectListNodeInterface {
    
 

    // Sets info field

    /**Sets the info to an object passed
     *
     * @param o
     */
        public void setInfo(Object o);

    // Returns object in info field

    /**returns the object in the info field
     *
     * @return Object
     */
        public Object getInfo();

    // Sets next field

    /**sets the node in the next field to the node passed
     *
     * @param p
     */
        public void setNext(ObjectListNode p);

    // Returns object in info field

    /**returns the node in the next field
     *
     * @return ObjectListNode
     */
        public ObjectListNode getNext();
    
    
}

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
public interface ObjectListInterface {
    

    /**Returns the the node that list points to
     *
     * @return ObjectListNode
     */
        public ObjectListNode getFirstNode();
    

    /**Returns the node that last points to
     *
     * @return ObjectListNode
     */
        public ObjectListNode getLastNode();

    // Returns the first object in the list

    /**Returns the object in the info field of the node that
     * list points to
     *
     * @return Object
     */
        public Object getFirst();

    // Returns the last object in the list

    /**Returns the object in the info field of the node that
     * last points to
     *
     * @return Object
     */
        public Object getLast();

    // Adds an object to the front of a list

    /**Creates a node using the object and places that node 
     * in the front of the list
     *
     * @param o
     */
        public void addFirst(Object o);

    // Adds a node to the front of the list

    /**Places the node passed at the front of the list
     *
     * @param p
     */
        public void addFirst(ObjectListNode p);
    
   // Adds an object to the end of the list

    /**Creates a node using the object and places that node 
     * at the end of the list
     *
     * @param o
     */
        public void addLast(Object o);

    // Adds a node to the end of the list

    /**Places the node passed at the end of the list
     *
     * @param p
     */
        public void addLast(ObjectListNode p);

    // Removes the first object from the list

    /**returns the object in the info field of the node that 
     * list points to, and deletes it from the list
     *
     * @return Object
     */
        public Object removeFirst();

    // Removes the last object from the list

    /**returns the object in the info field of the node that 
     * last points to, and deletes it from the list
     *
     * @return Object
     */
        public Object removeLast();

    // Inserts an object after the node referenced by p

    /**creates a node with the object passed and sets next 
     * to the node after the node passed, and sets the node passed's 
     * next field to the node created
     *
     * @param p
     * @param o
     */
        public void insertAfter (ObjectListNode p, Object o);

    // Inserts a node after the node referenced by p

    /** sets next to the node after the node passed,
     *  and sets the node passed's 
     * next field to the node inserted
     *
     * @param p
     * @param q
     */
        public void insertAfter(ObjectListNode p, ObjectListNode q) ;
 
     // Deletes the node after the node referenced by p

    /**returns the node after the node pointed to by p, and sets the next
     * field of p to the next field of the node after p, and sets the next of 
     * the node to null
     *
     * @param p
     * @return Object
     */
         public Object deleteAfter(ObjectListNode p);

    // Inserts an item into its correct location within an ordered list

    /**Compares the object passed to objects in the info fields of the list 
     * until it has found the right place, then creates a node with the object
     * passed, and inserts it there
     *
     * @param o
     */
        public void insert(Object o);

    // Inserts a node into its correct location within an ordered list

    /**Compares the object in the info field of the node passed to objects 
     * in the info fields of the list until it has found
     *  the right place, then inserts it there
     *
     * @param r
     */
        public void insert(ObjectListNode r);

    // Removes the first occurrence of an item in a list 

    /**Searches the info fields of the nodes in the list for the object passed,
     * returns it, and deletes it
     *
     * @param o
     * @return Object
     */
        public Object remove(Object o);

    // Returns true if the item is found in the list

    /**Returns true if the list contains the object passed in any of the info 
     * fields of the nodes
     *
     * @param o
     * @return boolean
     */
        public boolean contains(Object o);

    
    // Returns a reference to the node with the requested value
    // Returns null otherwise

    /**Returns the node that contains the object passed 
     *
     * @param o
     * @return ObjectListNode
     */
        public ObjectListNode select(Object o);

    // Determines whether or not a list is empty

    /**Returns true if the list points to null
     *
     * @return boolean
     */
        public boolean isEmpty();

    // Removes all elements from a list

    /**sets list and last to null
     *
     */
        public void clear();

    // Returns the number of elements in the list

    /**Returns the number of nodes in the list 
     *
     * @return integer
     */
        public int size();

    // Makes a copy of a list

    /**Makes a copy of a list
     *
     * @return ObjectList
     */
        public ObjectList copyList();
    
    // Reverses a list

    /**Reverses a list
     *
     */
        public void reverse();
}

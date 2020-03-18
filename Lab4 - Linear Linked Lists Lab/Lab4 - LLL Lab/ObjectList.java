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
public class ObjectList implements ObjectListInterface {
    private ObjectListNode list;
    private ObjectListNode last;
    
    // Constructs an empty list

    /**Constructs an object list with the list and last fields set to null
     *
     */
        public ObjectList() {
        list = null;
        last = null;
    }

    // Returns the first node in the list

    /**Returns the the node that list points to
     *
     * @return ObjectListNode
     */
        public ObjectListNode getFirstNode() {
        return list;
    }
    
    // Returns the last node in the list

    /**Returns the node that last points to
     *
     * @return ObjectListNode
     */
        public ObjectListNode getLastNode() {
        return last;
    }

    // Returns the first object in the list

    /**Returns the object in the info field of the node that
     * list points to
     *
     * @return Object
     */
        public Object getFirst() {
        if (list == null) {
            System.out.println("Runtime Error: getFirst()");
            System.exit(1);
        }
        return list.getInfo();
    }

    // Returns the last object in the list

    /**Returns the object in the info field of the node that
     * last points to
     *
     * @return Object
     */
        public Object getLast() {
        if (list == null) {
            System.out.println("Runtime Error: getLast()");
            System.exit(1);
        }
        return last.getInfo();
    }

    // Adds an object to the front of a list

    /**Creates a node using the object and places that node 
     * in the front of the list
     *
     * @param o
     */
        public void addFirst(Object o) {
        ObjectListNode p = new ObjectListNode(o, list);
        if (list == null)
            last = p;
        list = p;
    }

    // Adds a node to the front of the list

    /**Places the node passed at the front of the list
     *
     * @param p
     */
        public void addFirst(ObjectListNode p) {
        if (p == null) {
            System.out.println("Runtime Error: addFirst()");
            System.exit(1);
        }
        p.setNext(list);
        if (list == null)
            last = p;
        list = p;
    }
    
   // Adds an object to the end of the list

    /**Creates a node using the object and places that node 
     * at the end of the list
     *
     * @param o
     */
        public void addLast(Object o) {
        ObjectListNode p = new ObjectListNode(o);
        if (list == null) 
            list = p;
        else
            last.setNext(p);
        last = p;
    }

    // Adds a node to the end of the list

    /**Places the node passed at the end of the list
     *
     * @param p
     */
        public void addLast(ObjectListNode p) {
        if (p == null) {
            System.out.println("Runtime Error: addLast()");
            System.exit(1);
        }
        p.setNext(null);
        if (list == null)
            list = p;
        else
            last.setNext(p);
        last = p;
    }

    // Removes the first object from the list

    /**returns the object in the info field of the node that 
     * list points to, and deletes it from the list
     *
     * @return Object
     */
        public Object removeFirst() {
        if (list == null) {
            System.out.println("Runtime Error: removeFirst()");
            System.exit(1);
        }
        ObjectListNode p = list;
        list = p.getNext();
        if (list == null)
            last = null;
        return p.getInfo();
    }

    // Removes the last object from the list

    /**returns the object in the info field of the node that 
     * last points to, and deletes it from the list
     *
     * @return Object
     */
        public Object removeLast() {
        if (list == null) {
            System.out.println("Runtime Error: removeLast()");
            System.exit(1);
        }
        ObjectListNode p = list;
        ObjectListNode q = null;
        while (p.getNext() != null) {
            q = p;
            p = p.getNext();
        }
        if (q == null) {
            list = null;
            last = null;
        }    
        else {
            q.setNext(null);
            last = q;
        }    
        return p.getInfo();
    }

    // Inserts an object after the node referenced by p

    /**creates a node with the object passed and sets next 
     * to the node after the node passed, and sets the node passed's 
     * next field to the node created
     *
     * @param p
     * @param o
     */
        public void insertAfter (ObjectListNode p, Object o) {
        if (list == null || p == null) {
            System.out.println("Runtime Error: insertAfter()");
            System.exit(1);
        }
        ObjectListNode q = new ObjectListNode(o, p.getNext());
        p.setNext(q);
        if (q.getNext() == null)
            last = q;
    }

    // Inserts a node after the node referenced by p

    /** sets next to the node after the node passed,
     *  and sets the node passed's 
     * next field to the node inserted
     *
     * @param p
     * @param q
     */
        public void insertAfter(ObjectListNode p, ObjectListNode q) {
        if (list == null || p == null || q == null) {
            System.out.println("Runtime Error: insertAfter()");
            System.exit(1);
        }
        q.setNext(p.getNext());
        p.setNext(q);
        if (last.getNext() != null)
            last = q;
    }
 
     // Deletes the node after the node referenced by p

    /**returns the node after the node pointed to by p, and sets the next
     * field of p to the next field of the node after p, and sets the next of 
     * the node to null
     *
     * @param p
     * @return Object
     */
         public Object deleteAfter(ObjectListNode p) {
        if (list == null || p == null || p.getNext() == null) {
            System.out.println("Runtime Error: deleteAfter()");
            System.exit(1);
        }
        ObjectListNode q = p.getNext();
        p.setNext(q.getNext());
        if (p.getNext() == null)
            last = p;
        return q.getInfo();
    }

    // Inserts an item into its correct location within an ordered list

    /**Compares the object passed to objects in the info fields of the list 
     * until it has found the right place, then creates a node with the object
     * passed, and inserts it there
     *
     * @param o
     */
        public void insert(Object o) {
        ObjectListNode p = list;
        ObjectListNode q = null;
        while (p != null && ((Comparable)o).compareTo(p.getInfo()) > 0) {
            q = p;
            p = p.getNext();
        }
        if (q == null)
            addFirst(o);
        else
            insertAfter(q, o);
    }

    // Inserts a node into its correct location within an ordered list

    /**Compares the object in the info field of the node passed to objects 
     * in the info fields of the list until it has found
     *  the right place, then inserts it there
     *
     * @param r
     */
        public void insert(ObjectListNode r) {
        ObjectListNode p = list;
        ObjectListNode q = null;
        while (p != null &&
                ((Comparable)r.getInfo()).compareTo(p.getInfo()) > 0) {
            q = p;
            p = p.getNext();
        }
        if (q == null)
            addFirst(r);
        else
            insertAfter(q, r);
    }

    // Removes the first occurrence of an item in a list 

    /**Searches the info fields of the nodes in the list for the object passed,
     * returns it, and deletes it
     *
     * @param o
     * @return Object
     */
        public Object remove(Object o) {
        ObjectListNode p = list;
        ObjectListNode q = null;
        while (p != null && ((Comparable)o).compareTo(p.getInfo()) !=
                                                                   0) {
            q = p;
            p = p.getNext();
        }
        if (p == null)
            return null;
        else return q == null ? removeFirst() : deleteAfter(q);
    }

    // Returns true if the item is found in the list

    /**Returns true if the list contains the object passed in any of the info 
     * fields of the nodes
     *
     * @param o
     * @return boolean
     */
        public boolean contains(Object o) {
        ObjectListNode p = list;
        while (p != null && ((Comparable)o).compareTo(p.getInfo()) !=
                                                                     0)
            p = p.getNext();
        return p != null;
    }

    
    // Returns a reference to the node with the requested value
    // Returns null otherwise

    /**Returns the node that contains the object passed 
     *
     * @param o
     * @return ObjectListNode
     */
        public ObjectListNode select(Object o) {
        ObjectListNode p = list;
        while (p != null)
            if (((Comparable)o).compareTo(p.getInfo()) == 0)
                return p;
            else
                p = p.getNext();
        return null;
    }

    // Determines whether or not a list is empty

    /**Returns true if the list points to null
     *
     * @return boolean
     */
        public boolean isEmpty() {
        return list == null;
    }

    // Removes all elements from a list

    /**sets list and last to null
     *
     */
        public void clear() {
        list = null;
        last = null;
    }

    // Returns the number of elements in the list

    /**Returns the number of nodes in the list 
     *
     * @return integer
     */
        public int size() {
        int count = 0;
        ObjectListNode p = list;
        while (p != null) {
            ++count;
            p = p.getNext();
        }
        return count;
    }

    // Makes a copy of a list

    /**Makes a copy of a list
     *
     * @return ObjectList
     */
        public ObjectList copyList() {
        ObjectListNode p = null; 
        ObjectListNode q = null; // to satisfy compiler;
        ObjectListNode r = list;
        
        if (isEmpty())
            return null;
        ObjectList newList = new ObjectList();
        while (r != null) {
            p = new ObjectListNode(r.getInfo());
            if (newList.isEmpty())
                newList.addFirst(p);
            else
                q.setNext(p); 
            q = p;
            r = r.getNext();
        }
        newList.last = p;
        return newList;
    }
    
    // Reverses a list

    /**Reverses a list
     *
     */
        public void reverse() {
       ObjectListNode p = list;
       ObjectListNode q = null;
       ObjectListNode r;
        
        while (p != null) {
            r = q;
            q = p;
            p = p.getNext();
            q.setNext(r);
        }
        last = list;
        list = q;
    }   
}

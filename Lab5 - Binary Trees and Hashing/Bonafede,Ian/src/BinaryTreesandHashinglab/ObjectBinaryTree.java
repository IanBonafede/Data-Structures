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
public class ObjectBinaryTree implements ObjectBinaryTreeInterface{
    private ObjectTreeNode root;
    
    /**Creates an ObjectBinaryTree with its root set to null.
     *
     */
    public ObjectBinaryTree() {
        root = null;
    }
    
    /**returns the first node of the tree.
     *
     * @return ObjectTreeNode
     */
    public ObjectTreeNode getRoot() {
        return root;
    }
    
    /**Sets the left child of the tree node parent to the tree node r.
     *
     * @param parent
     * @param r
     */
    public void setLeftChild(ObjectTreeNode parent, ObjectTreeNode r) {
        if (parent == null || parent.getLeft() != null) {
            System.out.println("Runtime Error: setLeftChild");
        }
        parent.setLeft(r);
    }
    
    /**Sets the right child of the tree node parent to the tree node r.
     *
     * @param parent
     * @param r
     */
    public void setRightChild(ObjectTreeNode parent, ObjectTreeNode r) {
        if (parent == null || parent.getRight() != null) {
            System.out.println("Runtime Error: setLeftChild");
        }
        parent.setRight(r);
    }
    
    /**Inserts the object o into the tree in its correct position by comparing
     * each object in the tree.
     *
     * @param o
     */
    public void inserBST(Object o) {
        ObjectTreeNode p, q;
        
        ObjectTreeNode r = new ObjectTreeNode(o);
        if (root == null)
            root = r;
        else {
            p = root;
            q = root;
            while (q != null) {
                p = q;
                if (((TreeComparable)(r.getInfo())).compareTo((TreeComparable)(p.getInfo())) < 0 ) 
                    q = p.getLeft();
                else
                    q = p.getRight();
            }
            if (((TreeComparable)(r.getInfo())).compareTo(p.getInfo()) < 0) 
                setLeftChild(p, r);
            else
                setRightChild(p, r);
        }
    }
    
    /**Inserts the object o into the tree in its correct position by comparing
     * each object in the tree. If the object is already there, it will perform
     * an operate method to increase the objects number of duplicates. Operate 
     * is defined by the user.
     *
     * @param o
     */
    public void insertBSTDup(Object o){
        ObjectTreeNode p, q;
        
        ObjectTreeNode r = new ObjectTreeNode(o);
        if (root == null)
            root = r;
        else {
            p = root;
            q = root;
            while (q != null && ((TreeComparable)(r.getInfo())).compareTo((TreeComparable)(p.getInfo())) != 0) {
                p = q;
                if (((TreeComparable)(r.getInfo())).compareTo((TreeComparable)(p.getInfo())) < 0) {
                    q = p.getLeft();
                }
                else {
                    q = p.getRight();
                }
            }
            if (((TreeComparable)(r.getInfo())).compareTo((TreeComparable)(p.getInfo())) < 0)
                setLeftChild(p, r);
            else if (((TreeComparable)(r.getInfo())).compareTo((TreeComparable)(p.getInfo())) > 0)
                setRightChild(p, r);
            else ((TreeComparable)(p.getInfo())).operate((TreeComparable)(r.getInfo()));
                
            
        }
    }
    
    /**Finds the object o in the tree and returns the tree node that contains
     * it.
     *
     * @param o
     * @return ObjectTreeNode
     */
    public ObjectTreeNode searchBST(Object o) {
        ObjectTreeNode p;
        
        ObjectTreeNode r = new ObjectTreeNode(o);
        if (root != null) {
            p = root;
            while (p != null) {
                if (((TreeComparable)(r.getInfo())).compareTo((TreeComparable)(p.getInfo())) < 0)
                    p = p.getLeft();
                else if (((TreeComparable)(r.getInfo())).compareTo((TreeComparable)(p.getInfo())) > 0)
                    p = p.getRight();
                else
                    return p;
                
            }
        }
        return null;
    }
    
    /**Visits all of the tree nodes in the tree from top, to the
     * bottom (parent, left child, then right child). Useful for making a copy
     * of a tree.
     *
     * @param tree
     */
    public void preTrav(ObjectTreeNode tree) {
        if (tree != null) {
            ((TreeComparable)tree.getInfo()).visit();
            preTrav(tree.getLeft());
            preTrav(tree.getRight());
        }
    }
    
    /**Visits all of the tree nodes in the tree in order according to the
     * information (left child, parent, then right child). Since it is a
     * BinarySearchTree, the info is already in order, from parent to leaves.
     * Useful for outputting all info.
     *
     * @param tree
     */
    public void inTrav(ObjectTreeNode tree) {
        if (tree != null) {
            inTrav(tree.getLeft());
            ((TreeComparable)tree.getInfo()).visit();
            inTrav(tree.getRight());
        }
    }
    
    /**Visits all of the tree nodes in the tree from the leaves to the top 
     * (left child, right child, then parent). Useful for deleting a tree.
     *
     * @param tree
     */
    public void postTrav(ObjectTreeNode tree) {
        if (tree != null) {
            postTrav(tree.getLeft());
            postTrav(tree.getRight());
            ((TreeComparable)tree.getInfo()).visit();
        }
    }
    
    
}

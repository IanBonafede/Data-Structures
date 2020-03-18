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
public interface ObjectBinaryTreeInterface {
    
    /**returns the first node of the tree.
     *
     * @return ObjectTreeNode
     */
    public ObjectTreeNode getRoot();
    
    /**Sets the left child of the tree node parent to the tree node r.
     *
     * @param parent
     * @param r
     */
    public void setLeftChild(ObjectTreeNode parent, ObjectTreeNode r);
    
    /**Sets the right child of the tree node parent to the tree node r.
     *
     * @param parent
     * @param r
     */
    public void setRightChild(ObjectTreeNode parent, ObjectTreeNode r);
    
    /**Inserts the object o into the tree in its correct position by comparing
     * each object in the tree.
     *
     * @param o
     */
    public void inserBST(Object o);
    
    /**Inserts the object o into the tree in its correct position by comparing
     * each object in the tree. If the object is already there, it will perform
     * an operate method to increase the objects number of duplicates. Operate 
     * is defined by the user.
     *
     * @param o
     */
    public void insertBSTDup(Object o);
    
    /**Finds the object o in the tree and returns the tree node that contains
     * it.
     *
     * @param o
     * @return ObjectTreeNode
     */
    public ObjectTreeNode searchBST(Object o);
    
    /**Visits all of the tree nodes in the tree from top, to the
     * bottom (parent, left child, then right child). Useful for making a copy
     * of a tree.
     *
     * @param tree
     */
    public void preTrav(ObjectTreeNode tree);
    
    /**Visits all of the tree nodes in the tree in order according to the
     * information (left child, parent, then right child). Since it is a
     * BinarySearchTree, the info is already in order, from parent to leaves.
     * Useful for outputting all info.
     *
     * @param tree
     */
    public void inTrav(ObjectTreeNode tree);
    
    /**Visits all of the tree nodes in the tree from the leaves to the top 
     * (left child, right child, then parent). Useful for deleting a tree.
     *
     * @param tree
     */
    public void postTrav(ObjectTreeNode tree);
    
    
}

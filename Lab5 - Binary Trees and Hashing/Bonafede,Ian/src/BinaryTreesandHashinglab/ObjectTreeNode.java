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
public class ObjectTreeNode implements ObjectTreeNodeInterface {
    private Object info;
    private ObjectTreeNode left;
    private ObjectTreeNode right;
    
    /**Creates an ObjectTreeNode with it's info, left child, and right child, 
     * all set to null.
     *
     */
    public ObjectTreeNode() {
        info = null;
        left = null;
        right = null;
    }
    
    /**Creates an ObjectTreeNode with it's info set to the object, and it's 
     * left child, and right child, set to null.
     * 
     *
     * @param o
     */
    public ObjectTreeNode(Object o) {
        info = o;
        left = null;
        right = null;
    }
    
    /**Sets it's info field to the object o
     *
     * @param o
     */
    public void setInfo(Object o) {
        info = o;
    }
    
    /**Returns the object in the info field
     *
     * @return
     */
    public Object getInfo() {
        return info;
    }
    
    /**Sets it's left child the the node p
     *
     * @param p
     */
    public void setLeft(ObjectTreeNode p) {
        left = p;
    }
    
    /**Returns the node in the left field
     *
     * @return
     */
    public ObjectTreeNode getLeft() {
        return left;
    }
    
    /**Sets it's right child the the node p
     *
     * @param p
     */
    public void setRight(ObjectTreeNode p) {
        right = p;
    }
    
    /**Returns the node in the right field
     *
     * @return
     */
    public ObjectTreeNode getRight() {
        return right;
    }
    
    
}

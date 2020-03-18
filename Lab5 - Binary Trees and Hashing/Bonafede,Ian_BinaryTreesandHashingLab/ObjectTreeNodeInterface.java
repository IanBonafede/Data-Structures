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
public interface ObjectTreeNodeInterface {

    /**Sets it's info field to the object o
     *
     * @param o
     */
    public void setInfo(Object o);
    
    /**Returns the object in the info field
     *
     * @return
     */
    public Object getInfo();
    
    /**Sets it's left child the the node p
     *
     * @param p
     */
    public void setLeft(ObjectTreeNode p);
    
    /**Returns the node in the left field
     *
     * @return
     */
    public ObjectTreeNode getLeft();
    
    /**Sets it's right child the the node p
     *
     * @param p
     */
    public void setRight(ObjectTreeNode p);
    
    /**Returns the node in the right field
     *
     * @return
     */
    public ObjectTreeNode getRight();
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BinaryTreesandHashinglab;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author csis
 */
public class Xref {
    private PrintWriter pw;
    private Scanner s;
    private Hash hash;
    private int c = 0;
    private Query q;
    
    /**Creates an Xref object with all of its fields set to the objects passed.
     *
     * @param pw
     * @param s
     * @param query
     * @param h
     */
    public Xref(PrintWriter pw, Scanner s, Query query, Hash h) {
        this.pw = pw;
        this.s = s;
        q = query;
        hash = h;
    }
    
    /**Scans through a text of words, then uses a hash function to place the
     * words in the correct index of the array. This solves collisions using 
     * chaining.
     *
     * @return
     */
    public ObjectList[] makeUnimportantHashTable() {
        ObjectList[] unimportantHashTable = new ObjectList[37];
        
        for( int i = 0; i < unimportantHashTable.length; i++) {
            unimportantHashTable[i] = new ObjectList();
        }
        
        while (s.hasNext()) {
            String temp = s.next();
            int hF = hash.h(temp, 37);
            
            
            placeKey(unimportantHashTable, hF, temp);
        }
        
        pw.println("Hash table of unimportant words created.");
        pw.println("Number of collisions: " + c + "\r\n");
        System.out.println("Hash table of unimportant words created.");
        System.out.println("Number of collisions: " + c + "\n");
        return unimportantHashTable;
    }
    
    /**Loops through the hash table, and the elements' lists to print out the 
     * hash tables information
     *
     * @param hashTable
     */
    public void makeHashDisplay(ObjectList[] hashTable) {
        pw.println("HASHTABLE:");
        pw.println("Index   List");
        System.out.println("HASHTABLE:");
        System.out.println("Index   List");
        
        for( int i = 0; i < hashTable.length; i++) {
            ObjectListNode p = hashTable[i].getFirstNode();
            String allStrings = "\t";
            
            while (p != null) {
                String tempS = (String)p.getInfo();
                allStrings = allStrings + " -> " + tempS;
                p = p.getNext();
            }
            allStrings = allStrings + " -> " + p;
            
            pw.println(i + allStrings);
            System.out.println(i + allStrings);
        }
    }
    
    /**Adds the String key to the hash table at its hash function integer, also 
     * while counting the collisions.
     *
     * @param unimportantHashTable
     * @param hF
     * @param temp
     */
    public void placeKey(ObjectList[] unimportantHashTable, int hF, String temp) {
        if (unimportantHashTable[hF].getFirstNode() != null) {
            c++;
        }
        unimportantHashTable[hF].addLast(temp);
    }
    
    /**Prints a text scanned, with also the line numbers.
     *
     */
    public void print() {
        pw.println("Print of Getty.txt:" + "\r\n");
        System.out.println("Print of Getty.txt:" + "\n");
        
        int i = 0;
        
        while (s.hasNext()) {
            i++;
            
            String tempS = s.nextLine();
            
            pw.println(i + " " + tempS);
            System.out.println(i + " " + tempS);
        }
    }
    
    /**Looping while scanning a text, it creates word objects, checks to see if 
     * the word is unimportant, and if it is important, it is placed into it's
     * correct position in the tree.
     *
     * @param hashTable
     * @return
     */
    public ObjectBinaryTree makeWordTreeWithout(ObjectList[] hashTable) {
        ObjectBinaryTree gettyTree = new ObjectBinaryTree();
        
        int lN = 0;
        while (s.hasNext()) {
            lN++;
            String tempS = s.nextLine();
            String[] wordStringArray = tempS.split("[;,. ]+");
            
            for (int lP = 0; lP < wordStringArray.length; lP++) {
                Word word = new Word(wordStringArray[lP], lN, lP + 1, pw);
                
                if (!word.isUnimportant(hashTable, word.getWord())) {
                    gettyTree.insertBSTDup(word);
                }
            }
        }
        
        return gettyTree;
    }
    
    /**Runs the Query class.
     *
     * @param tree
     */
    public void doQuery(ObjectBinaryTree tree) {
        q.displayRuntimePrompt();
        
        q.searchForWord(tree);
    }
    
    
    
    
}

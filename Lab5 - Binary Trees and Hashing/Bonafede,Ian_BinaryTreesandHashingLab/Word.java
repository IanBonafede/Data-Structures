/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BinaryTreesandHashinglab;

import java.io.PrintWriter;

/**
 *
 * @author csis
 */
public class Word implements TreeComparable{
    private String word;
    private int timesItAppears;
    private ObjectList list;
    private Hash hash = new Hash();
    private PrintWriter pw;
    
    /**Creates a word object with default settings and the PrintWriter set to p.
     *
     * @param p
     */
    public Word(PrintWriter p) {
        word = "word";
        timesItAppears = 1;
        list = null;
        pw = p;
    }
    
    /**Creates a word object with the word field set to the string passed, and 
     * a list of line positions with the integers passed, and the PrintWriter 
     * set to p.
     *
     * @param w
     * @param lN
     * @param lP
     * @param p
     */
    public Word(String w, int lN, int lP, PrintWriter p) {
        word = w;
        timesItAppears = 1;
        pw = p;
        
        list = new ObjectList();
        LinePosition lineP = new LinePosition(lN, lP);
        list.addLast(lineP);
    }
    
    /**Sets the word field to w.
     *
     * @param w
     */
    public void setWord(String w) {
        word = w;
    }
    
    /**Returns the value of the word field.
     *
     * @return String
     */
    public String getWord() {
        return word;
    }
    
    /**Returns the integer value of the timesItAppears field.
     *
     * @return integer
     */
    public int getTimesItAppears() {
        return timesItAppears;
    }
    
    /**Returns the first node of the line position list.
     *
     * @return ObjectListNode
     */
    public ObjectListNode getList() {
        return list.getFirstNode();
    }
    
    /**Increments the timesItAppears field.
     *
     */
    public void incrementTimesItAppears() {
        timesItAppears++;
    }
    
    /**Creates a new LinePosition object with the integers passed, and adds that
     * to it's list.
     *
     * @param lN
     * @param lP
     */
    public void addLinePosition(int lN, int lP) {
        LinePosition lineP = new LinePosition(lN, lP);
        list.addLast(lineP);
    }
    
    /**Returns the LinePosition object in the first node of it's list.
     *
     * @return LinePosition
     */
    public LinePosition getLinePosition() {
        return (LinePosition)((list.getFirstNode()).getInfo());
    }
    
    /**Checks a hash table to tell whether or not this word is unimportant.
     *
     * @param unimportantHashTable
     * @param w
     * @return boolean
     */
    public boolean isUnimportant(ObjectList[] unimportantHashTable, String w) {
        int hF = hash.h(w, 37);
        
        ObjectListNode p = unimportantHashTable[hF].getFirstNode();
        while (p != null && w.compareTo((String)p.getInfo()) != 0) {
            p = p.getNext();
        }
        if (p == null) {
            return false;
        }
        else if (w.compareTo((String)p.getInfo()) == 0) {
            return true;
        }
        else 
            return false;
    }
    
    
    @Override
    public int compareTo(Object o) {
        Word w = (Word) o;
        return word.compareTo(w.getWord());
    }
    
    @Override
    public void operate(Object o) {
        incrementTimesItAppears();
        Word w = (Word) o;
        addLinePosition((w.getLinePosition()).getlineNumber(), (w.getLinePosition()).getPosition());
    }
    
    @Override
    public void visit() {
        ObjectListNode p = list.getFirstNode();
        String wordInfoPositions = "";
        
        while(p != null) {
            wordInfoPositions = wordInfoPositions + ((LinePosition)(p.getInfo())).getlineNumber() + "-" + 
                    ((LinePosition)(p.getInfo())).getPosition() + " ";
            p = p.getNext();
        }
        pw.printf("%s\t\t%s\t%s\n",word, timesItAppears, wordInfoPositions);
        System.out.printf("%s\t\t%s\t%s\n",word, timesItAppears, wordInfoPositions);
    }
    
}

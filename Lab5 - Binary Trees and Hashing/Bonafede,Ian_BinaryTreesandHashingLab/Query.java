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
public class Query {
    private Scanner s; 
    private PrintWriter pw;
    
    /**Creates a Query object with it's PrintWriter set to p, and it's scanner
     * to System.in.
     *
     * @param p
     */
    public Query(PrintWriter p) {
        s = new Scanner(System.in);
        pw = p;
    }
    
    /**Outputs some strings to prompt a user.
     *
     */
    public void displayRuntimePrompt() {
        pw.println("\r\n" + "Please type a word to search for.");
        pw.println("Type '0' to exit." + "\r\n");
        System.out.println("\n" + "Please type a word to search for.");
        System.out.println("Type '0' to exit." + "\n");
    }
    
    /**Prints out information for the word searched for. If its not there, it 
     * will print out that its not there. If the user presses '0' it will exit
     * the program.
     *
     * @param tree
     */
    public void searchForWord(ObjectBinaryTree tree) {
        String word = s.next();
        
        
        if (word.compareTo("0") == 0) {
            pw.println("Exitting.");
            System.out.println("Exitting.");
            pw.close();
            System.exit(0);
        }
        
        Word newW = new Word(word, 0, 0, pw);
        
        ObjectTreeNode p = tree.searchBST(newW);
        
        if (p != null) {
            
            Word w = (Word)p.getInfo();
            
            ObjectListNode r = w.getList();
            String positions = "";
            
            while (r != null) {
                positions = positions + ((LinePosition)r.getInfo()).getlineNumber() 
                        + "-" + ((LinePosition)r.getInfo()).getPosition() + " ";
                r = r.getNext();
            }
            
            pw.println(w.getWord() + "\t\t" + w.getTimesItAppears() + "\t" 
                    + positions + "\r\n" + "\r\n");
        
            System.out.print(w.getWord() + "\t\t" + w.getTimesItAppears() + "\t" 
                    + positions + "\n" + "\n");
            
        }
        else {
            pw.println("Word was not found." + "\r\n");
            System.out.println("Word was not found." + "\n");
        }
        searchForWord(tree);
    }
}

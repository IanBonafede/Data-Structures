/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BinaryTreesandHashinglab;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author csis
 */
public class Driver {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        
        PrintWriter pw = new PrintWriter(new File("csci.txt"));
        Scanner s1 = new Scanner(new File("getty.txt"));
        Scanner s2 = new Scanner(new File("getty.txt"));
        Scanner s3 = new Scanner(new File("unimportant.txt"));
        Hash h = new Hash();
        Query q = new Query(pw);
        
        
        Xref x1 = new Xref(pw, s1, q, h);
        Xref x2 = new Xref(pw, s2, q, h);
        Xref x3 = new Xref(pw, s3, q, h);
        
        ObjectList[] unimportantHashTable = x3.makeUnimportantHashTable();
        
        x3.makeHashDisplay(unimportantHashTable);
        
        System.out.println("\n" + "Description of my hash function:" + "\n");
        System.out.println("    It uses a string and creates its KEY integer");
        System.out.println("value based on the characters' individual ASCII ");
        System.out.println("codes. Each ASCII value is cubed in my case. The ");
        System.out.println("KEY is then modulussed by the tablesize. This is");
        System.out.println("value that is used to place and find a word in the ");
        System.out.println("hash table." + "\n");
        
        pw.println("\n" + "Description of my hash function:" + "\n");
        pw.println("    It uses a string and creates its KEY integer");
        pw.println("value based on the characters' individual ASCII ");
        pw.println("codes. Each ASCII value is cubed in my case. The ");
        pw.println("KEY is then modulussed by the tablesize. This is");
        pw.println("value that is used to place and find a word in the ");
        pw.println("hash table." + "\n");
        
        
        x1.print();
        
        ObjectBinaryTree gettyTree = x2.makeWordTreeWithout(unimportantHashTable);
        
        System.out.println("\n" + "Word\t\t#\tpositions" + "\n");
        pw.println("\r\n" + "Word\t\t#\tpositions" + "\r\n");
        gettyTree.inTrav(gettyTree.getRoot());
        
        x3.doQuery(gettyTree);
        
        pw.close();
        
        
        
        
    }
    
}

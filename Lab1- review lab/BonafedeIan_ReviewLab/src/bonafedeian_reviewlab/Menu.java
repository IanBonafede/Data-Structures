

package bonafedeian_reviewlab;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author Ian Bonafede
 * 
 */
public class Menu{
    
    private Scanner s = new Scanner(System.in);
    int choice;
    
    private PrintWriter pw;
    
    /**
     *
     * @param pw
     */
    public Menu(PrintWriter pw){
        this.pw = pw;
    }
    
    /**
     * lines of prompting for user to choose a conversion
     */
    public void display(){
        
        System.out.println("1: DECIMAL TO BINARY");
        System.out.println("2: DECIMAL TO HEXADECIMAL");
        System.out.println("3: BINARY TO DECIMAL");
        System.out.println("4: BINARY TO HEXADECIMAL");
        System.out.println("5: HEXADECIMAL TO DECIMAL");
        System.out.println("6: HEXIDECIMAL TO BINARY");
        System.out.println("7: EXIT" + "\n");
        System.out.println("PLEASE CHOOSE A CONVERSION BY TYPING THE INDICATED NUMBER");
        
        
        pw.println("1: DECIMAL TO BINARY");
        pw.println("2: DECIMAL TO HEXADECIMAL");
        pw.println("3: BINARY TO DECIMAL");
        pw.println("4: BINARY TO HEXADECIMAL");
        pw.println("5: HEXADECIMAL TO DECIMAL");
        pw.println("6: HEXIDECIMAL TO BINARY");
        pw.println("7: EXIT" + "\n");
        pw.println("PLEASE CHOOSE A CONVERSION BY TYPING THE INDICATED NUMBER");
        
    }
    
    /**
     * the selection from the user of the type of conversion
     * @return int
     */
    public int getSelection(){
        
        choice = s.nextInt();
        pw.println(choice);
        
        return choice;
        
    }
    
}

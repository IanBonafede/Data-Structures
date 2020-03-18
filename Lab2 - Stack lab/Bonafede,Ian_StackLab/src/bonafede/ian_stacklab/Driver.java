/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonafede.ian_stacklab;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author Ian_2
 */
public class Driver {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        
        int i = 1;
        
        String postfix;
        
        PrintWriter pw = new PrintWriter(new FileWriter("csis.txt"));
        Scanner scanner = new Scanner(new File("Infix.txt"));
        
        InfixToPostfix ITP = new InfixToPostfix(pw, scanner);
        EvalPostfix EP = new EvalPostfix(pw, scanner);
        

        while (scanner.hasNext()) {
            String buf = scanner.nextLine();
            
            
            System.out.println("Problem " + i + ": " + buf);
            pw.println("Problem " + i + ": " + buf);
            
            System.out.println("Postfix: ");
            pw.println("Postfix: ");
            
            postfix = ITP.toPostfix(buf);
            
            System.out.println("Evaluation: ");
            pw.println("Evaluation: ");
            
            EP.evalEachLn(postfix);
            
            System.out.println("\n");
            pw.println("\r\n");
            
            i++;
        }
    
        pw.close();
        
    }
    
}

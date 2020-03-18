

package bonafedeian_reviewlab;

import java.io.*;
import java.util.Scanner;

/**
 *
 * @author Ian Bonafede
 */
public class Decimal{
    
    private int operand;
    private String answer = "";
    
    private Scanner s = new Scanner(System.in);
    
    private PrintWriter pw;

    /**
     *
     * @param pw
     */
    public Decimal(PrintWriter pw){
        this.pw = pw;
    }
    
    /**
     * converts decimal to binary
     * 
     */
    public void decToBin(){
        
        /*
         *takes input from user for decimal input
         */
            System.out.println("YOU CHOSE 1: DECIMAL TO BINARY" + "\n");
            System.out.println("PLEASE TYPE A NUMBER TO CONVERT" + "\n");
            pw.println("YOU CHOSE 1: DECIMAL TO BINARY" + "\r\n");
            pw.println("PLEASE TYPE A NUMBER TO CONVERT" + "\r\n");
            
            operand = s.nextInt();
            pw.println(operand);
            
            
        /*
         *takes input and converts it into a string called answer
         */
        
            
            for(int i = 32; i > 0 ; i--){
                
                        if (operand < 1) {
                        
                            answer = answer;
                        }
                        
                    else if(operand % 2 == 1){
                       
                        answer = "1" + answer;
                        operand = operand / 2;
                    }
                    
                    else if(operand % 2 == 0) {
                        
                        answer = "0" + answer;
                        operand = operand / 2;
                        }

                    
                }
                
            
                
                    
            
            
            
        
        /*
         *prints out answer to system and pw
            also resets answer
         */
            
            System.out.println("YOUR ANSWER: " + answer + "\n");
            pw.println("YOUR ANSWER: " + answer + "\r\n");
            
            answer = "";
            
        
    }

    /**
     * converts decimal to hexadecimal
     *
     */
    
    public void decToHex(){
        
        /*
         *takes input from user for decimal input
         */
          
            System.out.println("YOU CHOSE 2: DECIMAL TO HEXADECIMAL" + "\n");
            System.out.println("PLEASE TYPE A NUMBER TO CONVERT" + "\n");
            pw.println("YOU CHOSE 2: DECIMAL TO HEXADECIMAL" + "\r\n");
            pw.println("PLEASE TYPE A NUMBER TO CONVERT" + "\r\n");
            
            operand = s.nextInt();
            pw.println(operand);
            
            
        
        /*
         *takes input from user and changes it to a string called answer
         */
            
            while(operand != 0){
                switch(operand%16){
                    case 0: answer = "0" + answer; break;
                    case 1: answer = "1" + answer; break;
                    case 2: answer = "2" + answer; break;
                    case 3: answer = "3" + answer; break;
                    case 4: answer = "4" + answer; break;
                    case 5: answer = "5" + answer; break;
                    case 6: answer = "6" + answer; break;
                    case 7: answer = "7" + answer; break;
                    case 8: answer = "8" + answer; break;
                    case 9: answer = "9" + answer; break;
                    case 10: answer = "A" + answer; break;
                    case 11: answer = "B" + answer; break;
                    case 12: answer = "C" + answer; break;
                    case 13: answer = "D" + answer; break;
                    case 14: answer = "E" + answer; break;
                    case 15: answer = "F" + answer; break;
                    
                }
                
                
                operand = operand / 16;
            }
        
        
            
            /*
             *prints out answer to system and pw
             */
            
            System.out.println("YOUR ANSWER: " + answer + "\n");
            pw.println("YOUR ANSWER: " + answer + "\r\n");
            
            answer = "";
            
        
    }
    
    
}

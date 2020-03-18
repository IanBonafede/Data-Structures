

package bonafedeian_reviewlab;

import java.io.*;
import java.util.Scanner;
import java.lang.Math;

/**
 *
 * @author Ian Bonafede
 */
public class Hexadecimal{
    
    private int answerI;
    private String answerS = "";
    private String operand = "";
    private char[] oArray;
    
    private Scanner s = new Scanner(System.in);
    
    private PrintWriter pw;

    /**
     *
     * @param pw
     */
    public Hexadecimal(PrintWriter pw){
        this.pw = pw;
    }
    

    /**
     * converts hexadecimal to decimal
     */
        public void hexToDec(){
        /*
         *takes input from user for hexadecimal input
         */
          
            System.out.println("YOU CHOSE 5: HEXADECIMAL TO DECIMAL" + "\n");
            System.out.println("PLEASE TYPE A NUMBER TO CONVERT" + "\n");
            pw.println("YOU CHOSE 5: HEXADECIMAL TO DECIMAL" + "\r\n");
            pw.println("PLEASE TYPE A NUMBER TO CONVERT" + "\r\n");
            
            operand = s.nextLine();
            pw.println(operand);
            
            
        
        /*
         *takes input from user and changes it to a int called answer
         */
            oArray = operand.toCharArray();
            
            for(int i = 0; i < oArray.length; i++){
                switch(oArray[oArray.length - 1 - i]){
                    case '0': answerI = answerI + 0 * (int) Math.pow(16, i); break;
                    case '1': answerI = answerI + 1 * (int) Math.pow(16, i); break;
                    case '2': answerI = answerI + 2 * (int) Math.pow(16, i); break;
                    case '3': answerI = answerI + 3 * (int) Math.pow(16, i); break;
                    case '4': answerI = answerI + 4 * (int) Math.pow(16, i); break;
                    case '5': answerI = answerI + 5 * (int) Math.pow(16, i); break;
                    case '6': answerI = answerI + 6 * (int) Math.pow(16, i); break;
                    case '7': answerI = answerI + 7 * (int) Math.pow(16, i); break;
                    case '8': answerI = answerI + 8 * (int) Math.pow(16, i); break;
                    case '9': answerI = answerI + 9 * (int) Math.pow(16, i); break;
                    case 'A': answerI = answerI + 10 * (int) Math.pow(16, i); break;
                    case 'B': answerI = answerI + 11 * (int) Math.pow(16, i); break;
                    case 'C': answerI = answerI + 12 * (int) Math.pow(16, i); break;
                    case 'D': answerI = answerI + 13 * (int) Math.pow(16, i); break;
                    case 'E': answerI = answerI + 14 * (int) Math.pow(16, i); break;
                    case 'F': answerI = answerI + 15 * (int) Math.pow(16, i); break;
                }
            }
            
            /*
             *prints out answer to system and pw
             */
            
            System.out.println("YOUR ANSWER: " + answerI + "\n");
            pw.println("YOUR ANSWER: " + answerI + "\r\n");
            
            answerI = 0;
           
    }
    

    /**
     * converts hexadecimal to binary
     *
     */
        public void hexToBin(){
        /*
         *takes input from user for hexadecimal input
         */
          
            System.out.println("YOU CHOSE 5: HEXADECIMAL TO DECIMAL" + "\n");
            System.out.println("PLEASE TYPE A NUMBER TO CONVERT" + "\n");
            pw.println("YOU CHOSE 5: HEXADECIMAL TO DECIMAL" + "\r\n");
            pw.println("PLEASE TYPE A NUMBER TO CONVERT" + "\r\n");
            
            operand = s.nextLine();
            pw.println(operand);
            
            
        /*
         *takes input from user and changes it to a int called answer
         */
            oArray = operand.toCharArray();
            
            for(int i = 0; i < oArray.length; i++){
                switch(oArray[oArray.length - 1 - i]){
                    case '0': answerS = "0000" + answerS; break;
                    case '1': answerS = "0001" + answerS; break;
                    case '2': answerS = "0010" + answerS; break;
                    case '3': answerS = "0011" + answerS; break;
                    case '4': answerS = "0100" + answerS; break;
                    case '5': answerS = "0101" + answerS; break;
                    case '6': answerS = "0110" + answerS; break;
                    case '7': answerS = "0111" + answerS; break;
                    case '8': answerS = "1000" + answerS; break;
                    case '9': answerS = "1001" + answerS; break;
                    case 'A': answerS = "1010" + answerS; break;
                    case 'B': answerS = "1011" + answerS; break;
                    case 'C': answerS = "1100" + answerS; break;
                    case 'D': answerS = "1101" + answerS; break;
                    case 'E': answerS = "1110" + answerS; break;
                    case 'F': answerS = "1111" + answerS; break;
                    
                }
            }
            
            /*
             *prints out answer to system and pw
             */
            
            System.out.println("YOUR ANSWER: " + answerS + "\n");
            pw.println("YOUR ANSWER: " + answerS + "\r\n");
            
            answerS = "";
        
    }
    
    
}

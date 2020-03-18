

package bonafedeian_reviewlab;


import java.io.*;
import java.util.Scanner;
import java.lang.Math;


/**
 *
 * @author Ian Bonafede
 */
public class Binary{
    
    private int answerI = 0;
    private String answerS = "";
    private String operand;
    private char[] oArray;
    
    
    private Scanner s = new Scanner(System.in);
    
    private PrintWriter pw;

    /**
     *
     * @param pw
     */
    public Binary(PrintWriter pw){
        this.pw = pw;
    }
    
    /**
     * converts binary to decimal
     * 
     */
    public void binToDec(){
        
        /*
         *takes input from user for binary input
         */
            System.out.println("YOU CHOSE 3: BINARY TO DECIMAL" + "\n");
            System.out.println("PLEASE TYPE A NUMBER TO CONVERT" + "\n");
            pw.println("YOU CHOSE 3: BINARY TO DECIMAL" + "\r\n");
            pw.println("PLEASE TYPE A NUMBER TO CONVERT" + "\r\n");
            
            operand = s.nextLine();
            pw.println(operand);
        
        /*
         * takes input from user and converts it to an an int by adding them 
         * together from an array
         */    
        
            oArray = operand.toCharArray();
            
            for(int i = 0; i < oArray.length; i++){
                
                //System.out.println(oArray[i]);
                
                if(oArray[oArray.length -1 - i]  == '1'){
                    answerI = answerI + (int) Math.pow(2,i);
                }
                //System.out.println(oArray[oArray.length -1 - i]);
                    
                
                
            }
            
        
        /*
         *prints out answer to system and pw
         */
            System.out.println("YOUR ANSWER: " + answerI + "\n");
            pw.println("YOUR ANSWER: " + answerI + "\r\n");
            
            answerI = 0;
    }
    
    
    /**
     * converts binary to hexadecimal
     */
    public void binToHex(){
        char operandNew;
        String operandNew2 = "";
        
        
        /*
         *takes input from user for binary input
         */
            System.out.println("YOU CHOSE 4: BINARY TO HEXADECIMAL" + "\n");
            System.out.println("PLEASE TYPE A NUMBER TO CONVERT" + "\n");
            pw.println("YOU CHOSE 4: BINARY TO HEXADECIMAL" + "\r\n");
            pw.println("PLEASE TYPE A NUMBER TO CONVERT" + "\r\n");
            
            operand = s.nextLine();
            pw.println(operand);
            
        /*
         * takes input from user and converts it to an an int by adding them 
         * together from an array
         */  
    
            oArray = operand.toCharArray();
            
            for(int i = 0; i < oArray.length; i++){
                
                operandNew = oArray[oArray.length - 1 - i];
                
                operandNew2 = operandNew + operandNew2;
                
                
              if((i + 1) % 4 == 0){
                  
                  int variable = Integer.parseInt(operandNew2);
                
                  switch(variable){
                    case 0: answerS = "0" + answerS; break;
                    case 1: answerS = "1" + answerS; break;
                    case 10: answerS = "2" + answerS; break;
                    case 11: answerS = "3" + answerS; break;
                    case 100: answerS = "4" + answerS; break;
                    case 101: answerS = "5" + answerS; break;
                    case 110: answerS = "6" + answerS; break;
                    case 111: answerS = "7" + answerS; break;
                    case 1000: answerS = "8" + answerS; break;
                    case 1001: answerS = "9" + answerS; break;
                    case 1010: answerS = "A" + answerS; break;
                    case 1011: answerS = "B" + answerS; break;
                    case 1100: answerS = "C" + answerS; break;
                    case 1101: answerS = "D" + answerS; break;
                    case 1110: answerS = "E" + answerS; break;
                    case 1111: answerS = "F" + answerS; break;
                    
                }
                
                
                operandNew2 = "";
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

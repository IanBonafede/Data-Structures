/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonafede.ian_stacklab;

import com.sun.org.apache.xerces.internal.util.IntStack;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Ian_2
 */
public class EvalPostfix {

    /**
     *
     */
    public IntStack objectStack = new IntStack();
    
    private PrintWriter pw;
    private Scanner scanner;
    
    /**
     *
     * @param pw
     * @param s
     */
    public EvalPostfix(PrintWriter pw, Scanner s) {
        this.pw = pw;
        scanner = s;
    }
    
    /** assigns the first pop of the stack to first
     * assigns the second pop of the stack to second
     * operates the second to the power of the first
     * returns the value
     *
     * @return Integer
     */
    public int pow() {
        int x;
        
        int first = objectStack.pop();
        int second = objectStack.pop();
        
        x = (int) Math.pow(second, first);
        return x;
    }
    
    /**assigns the first pop of the stack to first
     * assigns the second pop of the stack to second
     * operates the second multiplied by first
     * returns the value
     *
     * @return Integer
     */
    public int mult() {
        int x;

        int first = objectStack.pop();
        int second = objectStack.pop();
        
        x = second * first;
        return x;
    }
    
    /**assigns the first pop of the stack to first
     * assigns the second pop of the stack to second
     * operates the second divided by first
     * returns the value
     *
     * @return Integer
     */
    public int div() {
        int x;
        
        int first = objectStack.pop();
        int second = objectStack.pop();
        
        
        x = second / first;
        return x;
    }
    
    /**assigns the first pop of the stack to first
     * assigns the second pop of the stack to second
     * operates the second added to first
     * returns the value
     *
     * @return Integer
     */
    public int add() {
        int x;
        
        int first = objectStack.pop();
        int second = objectStack.pop();
        
        
        x = second + first;
        return x;
    }
    
    /**assigns the first pop of the stack to first
     * assigns the second pop of the stack to second
     * operates the second minus first
     * returns the value
     *
     * @return Integer
     */
    public int sub() {
        int x;
        
        int first;
        int second;
        
        first = objectStack.pop();
        second = objectStack.pop();
        
        x = second - first;
        return x;
    }
    
    /**evaluates the postfix notation string passed into it, buf
     * turns buf into a character array, and loops through the array to look at the characters
     * if the character is a number, it is pushed onto the stack
     * if the character is a operator, it operates it on the last two numbers in the stack, then 
     * pushes the new value onto the stack
     * once it is done evaluating, the last number on the stack is the answer, and is popped
     * prints the final answer
     *
     * @param buf
     */
    public void evalEachLn(String buf) {
        int answer;
        char[] charArray = buf.toCharArray();
        
        for(int i = 0; i < charArray.length; i++) {
            
            switch (charArray[i]) {
                    case '0' : objectStack.push(0); break;
                    case '1' : objectStack.push(1); break;
                    case '2' : objectStack.push(2); break;
                    case '3' : objectStack.push(3); break;
                    case '4' : objectStack.push(4); break;
                    case '5' : objectStack.push(5); break;
                    case '6' : objectStack.push(6); break;
                    case '7' : objectStack.push(7); break;
                    case '8' : objectStack.push(8); break;
                    case '9' : objectStack.push(9); break;
                    
                    case '^' : objectStack.push(pow()); break;
                    case '*' : objectStack.push(mult()); break;
                    case '/' : objectStack.push(div()); break;
                    case '+' : objectStack.push(add()); break;
                    case '-' : objectStack.push(sub()); break;
                    
                }
            }
        
        
        answer = (int) objectStack.pop();
        pw.println(answer);
        System.out.println(answer);
    }
    
}

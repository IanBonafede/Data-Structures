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
public class InfixToPostfix {
    
    /**
     *
     */
    public int i;

    /**
     *
     */
    public char[] charArray;

    /**
     *
     */
    public char lastParenthesis;

    /**
     *
     */
    public char chara;

    /**
     *
     */
    public char topStackChar;

    /**
     *
     */
    public String postFix;

    /**
     *
     */
    public ObjectStack tempStack = new ObjectStack();
    
    /**
     *
     */
    public Scanner scanner;
    
    private PrintWriter pw;
    
    /**
     *
     * @param pw
     * @param s
     */
    public InfixToPostfix(PrintWriter pw, Scanner s) {
        this.pw = pw;
        scanner = s;
    }
    
    /**
     *
     * @param op
     * @return Integer
     */
    public int priority(char op){
        switch(op){
            case '^': return 3;
            case '*': 
            case '/': return 2;
            case '+': 
            case '-': return 1;
            default : return 0;
        }
    }

    
    /** Rule 6: if a right parenthesis is encountered in the infix expression
     * pop the stack and place them in the postfix expression until a left parenthesis is encountered 
     * then discard it
     * 
     */
        
    public void popUntillLeftParen() {
        while (!tempStack.isEmpty() && (char) tempStack.top() != '(') {
            postFix = postFix + (char) tempStack.pop();
        }
            
        lastParenthesis = (char) tempStack.pop();
    }

    
    /** rule 3 : pop the rest of the stack and move the characters to the postfix expression
     *           if the entire infix expression has been scanned
     */
        
    public void popRestOfStack() {
        
        while (!tempStack.isEmpty()) {
                    if ( (char) tempStack.top() == '(') {
                        lastParenthesis = (char) tempStack.pop();
                    }
                    else
                        postFix = postFix + (char) tempStack.pop();
                }
        
    }
    
    /** rule 2, 5 : If an operator is encountered, it will be pushed on the stack if its empty, 
     * it will be pushed onto the stack if the top is a left parenthesis, or it will pop the 
     * stack and put those characters into the postfix expression until any of those, or until
     * an operator will lower priority is encountered in the stack.
     * 
     * 
     *
     */
    public void popOrPush(){
        chara = charArray[i];
        
        if (tempStack.isEmpty()){
            tempStack.push(chara);
        }
        else {
            if ( (char) tempStack.top() == '(' ||
                    ( priority( (char) tempStack.top()) < priority( (char) chara) && priority( (char) tempStack.top()) != 0) ) {
                tempStack.push(chara);
            }
            else {
                while( !tempStack.isEmpty() && !(priority( (char) tempStack.top()) < priority( (char) chara )) ){
                    postFix = postFix + tempStack.pop();
                }
                tempStack.push(chara);
            }
        }
    }
    
    /** Rule 1: if an operand or a is encountered in the infix expression
     * automatically add it to the postfix expression
     * 
     * Rule 4: if a left parenthesis is encountered in the infix expression,
     * push it onto the stack
     *
     * @param buf
     * @return String
     */
    public String toPostfix(String buf){
        postFix = "";
        charArray = buf.toCharArray();
        
        for (i = 0; i < charArray.length; i++) {
            switch( (char) charArray[i]) {
                case '0' : postFix = postFix + charArray[i]; break;
                case '1' : postFix = postFix + charArray[i]; break;
                case '2' : postFix = postFix + charArray[i]; break;
                case '3' : postFix = postFix + charArray[i]; break;
                case '4' : postFix = postFix + charArray[i]; break;
                case '5' : postFix = postFix + charArray[i]; break;
                case '6' : postFix = postFix + charArray[i]; break;
                case '7' : postFix = postFix + charArray[i]; break;
                case '8' : postFix = postFix + charArray[i]; break;
                case '9' : postFix = postFix + charArray[i]; break;
                    
                case '(' : tempStack.push(charArray[i]); break;
                
                case ')' : popUntillLeftParen(); break;
                
                case '^' : popOrPush(); break;
                case '*' : popOrPush(); break;
                case '/' : popOrPush(); break;
                case '+' : popOrPush(); break;
                case '-' : popOrPush(); break;
                
            }
        }
        popRestOfStack();
        System.out.println(postFix);
        pw.println(postFix);
        
        return postFix;
    }
}
    


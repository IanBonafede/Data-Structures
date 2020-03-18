/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BinaryTreesandHashinglab;

import static java.lang.Math.abs;

/**
 *
 * @author csis
 */
public class Hash {
    
    /**
     *
     */
    public Hash() {
        
    }
    
    /**takes a string and an integer as arguments. It separates the characters
     * of the string into it's ASCII codes. It cubes all of the codes, then 
     * multiplies them together. this value is then taken the modulus of by the
     * integer in the argument. It returns the absolute value of this number.
     *
     * @param s
     * @param tableSize
     * @return integer
     */
    public int h(String s, int tableSize) {
        int key = 1;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int ascii = (int) c;
            key = key * ascii * ascii * ascii;
        }
        int hashF = (key) % (tableSize);
        hashF = abs(hashF);
        return hashF;
    }
    
}

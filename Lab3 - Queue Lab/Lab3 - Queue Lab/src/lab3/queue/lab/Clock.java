/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lab3.queue.lab;

/**
 *
 * @author csis
 */
public class Clock {
    
    int time;
    
    /**Creates a clock with time starting at 0
     *
     */
    public Clock() {
        time = 0;
    }
    
    /**increments the clock (adds 1 to the time)
     *
     */
    public void tick() {
        time = time + 1;
    }
    
    /**returns the time
     *
     * @return integer
     */
    public int getTime() {
        return time;
    }
    
}

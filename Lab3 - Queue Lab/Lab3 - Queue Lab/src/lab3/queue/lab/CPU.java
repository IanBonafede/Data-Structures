/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3.queue.lab;

/**
 *
 * @author Ian_2
 */
public class CPU {
    
    int quantumClock;
    Job currentJob;
    boolean busyFlag;
    
    /**Creates a CPU with a quantum clock at 0,
     * a null current job, and the busy flag down
     *
     */
    public CPU() {
        quantumClock = 0;
        currentJob = null;
        busyFlag = false;
    }
    
    /**Sets busy flag to false
     *
     */
    public void lowerBusyFlag() {
        busyFlag = false;
    }
    
    /**Sets busy flag to true
     *
     */
    public void raiseBusyFlag() {
        busyFlag = true;
    }
    
    /**Sets the quantum clock to the arguement you provide
     *
     * @param t
     */
    public void setQuantumClock (int t) {
        quantumClock = t;
    }
    
    /**subtracts the quantum clock by 1
     *
     */
    public void decrementQuantumClock() {
        quantumClock = quantumClock  - 1;
    }
    
    /**returns true if the busy flag is true (raised)
     *
     * @return
     */
    public boolean isBusy(){
        return busyFlag;
    }
    
    /**sets the current job to the arguement provided
     *
     * @param j
     */
    public void setJob(Job j) {
        currentJob = j;
    }
    
    /**returns the current job (non-destructive)
     *
     * @return Job
     */
    public Job getJob() {
        if (currentJob == null) {
            System.out.println("no job in cpu");
            
        }

        return currentJob;
    }
    
    /**returns the integer of the Quantum Clock
     *
     * @return integer
     */
    public int getQuantumTime() {
        return quantumClock;
    }
    
    
}

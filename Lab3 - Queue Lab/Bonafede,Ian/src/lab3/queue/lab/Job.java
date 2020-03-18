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
public class Job {
    
    int ArrivalTime;
    String ProcessID;
    int CPUTime;
    int LLQ;
    int totalTime;
    int waitTime;
    
    int jobClock;
    
    /**Creates a basic job with Arrival time 0, process id 000,
     * cpu time of 1, the job clock equal to 1, lowest level queue of 1,
     * totaltime in system of 0, and waiting time in queues 0
     *
     */
    public Job() {
        ArrivalTime = 0;
        ProcessID = "000";
        CPUTime = 1;
        jobClock = ArrivalTime;
        LLQ = 1;
        totalTime = 0;
        waitTime = 0;
    }
    
    /**Creates a basic job with Arrival time , process id,
     * and cpu time as arguments. the job clock equal to the cpu time, lowest level queue of 1,
     * totaltime in system of 0, and waiting time in queues 0
     *
     * @param AT
     * @param PID
     * @param CPUT
     */
    public Job(int AT, String PID, int CPUT) {
        ArrivalTime = AT;
        ProcessID = PID;
        CPUTime = CPUT;
        jobClock = CPUTime;
        LLQ = 1;
        totalTime = 0;
        waitTime = 0;
    }
    
    /** returns its arrival time that it should enter the system at
     *
     * @return integer
     */
    public int getArrivalTime() {
        return ArrivalTime;
    }
    
    /**Adds 1 to the lowest level queue if its 1, 2, or 3
     *
     */
    public void nextLLQ(){
        if (LLQ == 1 || LLQ == 2 || LLQ == 3) {
            LLQ = LLQ +1;
        } 
        else {}
    }
    
    /**subtracts the job clock by 1
     *
     */
    public void decrementJobClock() {
        jobClock = jobClock - 1;
    }
    
    /**returns the job clock time
     *
     * @return integer
     */
    public int getJobClockTime(){
        return jobClock;
    }
    
    /**returns the process id for the job
     *
     * @return String
     */
    public String getProcessID() {
        return ProcessID;
    }
    
    /**returns the cpu time it takes for this job to finish
     *
     * @return
     */
    public int getCPUTime() {
        return CPUTime;
    }
    
    /**returns 1, 2, 3, or 4 of the corresponding level queue
     *
     * @return integer
     */
    public int getLLQ() {
        return LLQ;
    }
    
    /**returns the total time that this job has been in the system
     *
     * @return integer
     */
    public int getTotalTime() {
        return totalTime;
    }
    
    /**returns the waiting time that this job has been in the queues waiting 
     * to be processed
     *
     * @return integer
     */
    public int getWaitTime() {
        return waitTime;
    }
    
    /**Adds 1 to the wait time
     *
     */
    public void incrementWaitTime() {
        waitTime++;
    }
    
}

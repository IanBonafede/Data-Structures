/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3.queue.lab;

import java.io.PrintWriter;
import java.util.Scanner;
import java.io.*;

/**
 *
 * @author Ian_2
 */
public class MFQ {
    
    private Scanner scanner;
    private Scanner csisScanner;
    private PrintWriter pW;
    
    private ObjectQueue jobQueue = new ObjectQueue();
    
    private ObjectQueue level1 = new ObjectQueue();
    private ObjectQueue level2 = new ObjectQueue();
    private ObjectQueue level3 = new ObjectQueue();
    private ObjectQueue level4 = new ObjectQueue();
    
    private CPU cpu = new CPU();
    private Clock clock = new Clock();
    
    private int totalTimeAdded = 0;
    private int i = 0;
    private float averageResponseTime;
    private int addedResponseTime = 0;
    private int time1;
    private int time2;
    private float averageTurnaroundTime;
    private int addedTurnaroundTime = 0;
    private float averageWaitingTime;
    private int addedWaitingTime = 0;
    private float averageThroughput;
    private int totalCPUIdleTime = 0;
    
    /**
     *
     * @param pw
     * @param s
     */
    public MFQ(PrintWriter pw, Scanner s) {
        pW = pw;
        scanner = s;
    }
    
    /**
     *
     */
    public void getJobs() {
        
        while (scanner.hasNext()) {
            String tempS = scanner.nextLine();
            
            
            String[] tokens = tempS.split("[ ]+");

            int ArrivalTime = Integer.parseInt(tokens[0]);
            String ProcessID = tokens[1];
            int CPUTime = Integer.parseInt(tokens[2]);
            
            
            Job tempJ = new Job(ArrivalTime, ProcessID, CPUTime);

            jobQueue.insert(tempJ);
            

        }
        
    }
    
    /**
     *
     */
    public void outputHeader(){
        System.out.println("Event" + "     " + "System" + "     " + "PID" 
                            + "     " + "CPU Time" + "     " + "Total Time"
                            + "     " + "Lowest");
        System.out.println("           " + "Time" + "               " + "Needed" + "      " + "in Syestem"
                            + "     " + "Level");
        System.out.println("                                                         " + "Queue");
        
        pW.println("Event" + "     " + "System" + "     " + "PID" 
                            + "     " + "CPU Time" + "     " + "Total Time"
                            + "     " + "Lowest");
        pW.println("           " + "Time" + "               " + "Needed" + "      " + "in Syestem"
                            + "     " + "Level");
        pW.println("                                                         " + "Queue");
        
    }
    
    /**
     *
     */
    public void runSimulation() {
        
        Job currentJob;
        Job tempj = new Job(0,"0",0);
        
        while (!jobQueue.isEmpty() || !level1.isEmpty() || !level2.isEmpty()
                                   || !level3.isEmpty() || !level4.isEmpty()
                                   || cpu.isBusy()) {
            
            
            if(!jobQueue.isEmpty()) {
                tempj = (Job) jobQueue.query(); 
            }
            
            if(jobQueue.isEmpty()) {
                tempj = new Job(0,"0",0); 
            }
            
            clock.tick();
            
            
            if (clock.getTime() == tempj.getArrivalTime()) {
                System.out.println("Arrival" + "      " + clock.getTime() + "       " + tempj.getProcessID()
                            + "         " + tempj.getCPUTime() + "     " + " "
                            + "     " + " ");
                pW.println("Arrival" + "      " + clock.getTime() + "       " + tempj.getProcessID()
                            + "         " + tempj.getCPUTime() + "     " + " "
                            + "     " + " ");
                level1.insert(jobQueue.remove());
                time1 = clock.getTime();
            }
            
            if (!cpu.isBusy()) {
                incrementAllWaitTimes();
                totalCPUIdleTime++;
                submitAppropriateJobToCPU();
            }
                
            
            
            else if(cpu.isBusy()) {
                cpu.decrementQuantumClock();
                decrementCurrentJobClock();
                incrementAllWaitTimes();
                
                // Is job Finished?
                //yes
                if (cpu.getJob().getJobClockTime() == 0) {
                    currentJob = cpu.getJob();
                    
                    System.out.println(currentJob.getWaitTime());
                    addedWaitingTime = addedWaitingTime + currentJob.getWaitTime();
                    
                    totalTimeAdded = totalTimeAdded + (clock.getTime() - currentJob.getArrivalTime());
                    i++;
                    
                    addedTurnaroundTime = addedTurnaroundTime + (clock.getTime() - currentJob.getArrivalTime());
                    
                    System.out.println("Departure" + "    " + clock.getTime() + "       " + currentJob.getProcessID()
                            + "                      " + (clock.getTime() - currentJob.getArrivalTime())
                            + "           " + currentJob.getLLQ());
                    pW.println("Departure" + "    " + clock.getTime() + "       " + currentJob.getProcessID()
                            + "                      " + (clock.getTime() - currentJob.getArrivalTime())
                            + "           " + currentJob.getLLQ());
                    
                    cpu.lowerBusyFlag();
                    
                    submitAppropriateJobToCPU();
                }
                //no
                
                //preemption?
                //yes
                else if (cpu.getQuantumTime() == 0 || (cpu.getJob().getLLQ() == 1 && !level1.isEmpty())
                                                   || (cpu.getJob().getLLQ() == 2 && !level1.isEmpty())
                                                   || (cpu.getJob().getLLQ() == 3 && (!level1.isEmpty() || !level2.isEmpty()) ) 
                                                   || (cpu.getJob().getLLQ() == 4 && (!level1.isEmpty() || !level2.isEmpty() || !level3.isEmpty()) ) 
                                                    )  {
                    currentJob = cpu.getJob();
                    
                    
                    if(currentJob.getLLQ() == 1) {
                        currentJob.nextLLQ();
                        level2.insert(currentJob);
                    }
                    else if(currentJob.getLLQ() == 2) {
                        currentJob.nextLLQ();
                        level3.insert(currentJob);
                    }
                    else if(currentJob.getLLQ() == 3) {
                        currentJob.nextLLQ();
                        level4.insert(currentJob);
                    }
                    else if(currentJob.getLLQ() == 4) {
                        currentJob.nextLLQ();
                        level4.insert(currentJob);
                    }
                    cpu.lowerBusyFlag();
                    submitAppropriateJobToCPU();
                }
                
                //no
            }
            
            
        }
        
    }
    
    /**
     *
     */
    public void outStats() {
        averageWaitingTime = (float) addedWaitingTime/i;
        averageResponseTime = (float) addedResponseTime/i;
        averageTurnaroundTime = (float) addedTurnaroundTime/i;
        averageThroughput = (float) i/totalTimeAdded;
        
        System.out.println(" ");
        System.out.println("Total number of Jobs: " + i);
        System.out.println("Total Time of all Jobs in the System: " + totalTimeAdded);
        System.out.println("Average Response Time: " + averageResponseTime);
        System.out.println("Average Turnaround Time: " + averageTurnaroundTime);
        System.out.println("Average Waiting Time: " + averageWaitingTime);
        System.out.println("Average throughput for the System as a whole: " + averageThroughput);
        System.out.println("Total CPU idle Time: " + totalCPUIdleTime);
        
        pW.println(" ");
        pW.println("Total number of Jobs: " + i);
        pW.println("Total Time of all Jobs in the System: " + totalTimeAdded);
        pW.println("Average Response Time: " + averageResponseTime);
        pW.println("Average Turnaround Time: " + averageTurnaroundTime);
        pW.println("Average Waiting Time: " + averageWaitingTime);
        pW.println("Average throughput for the System as a whole: " + averageThroughput);
        pW.println("Total CPU idle Time: " + totalCPUIdleTime);

        
    }
    
    /**
     *
     */
    public void submitAppropriateJobToCPU(){
        
        
                if(!level1.isEmpty()) {
                    cpu.setJob( (Job) level1.remove());
                    cpu.raiseBusyFlag();
                    cpu.setQuantumClock(2);
                    
                    time2 = clock.getTime();
                    addedResponseTime = addedResponseTime + (time2 - time1);
                }
                else if (!level2.isEmpty()) {
                    cpu.setJob( (Job) level2.remove());
                    cpu.raiseBusyFlag();
                    cpu.setQuantumClock(4);
                }
                else if (!level3.isEmpty()) {
                    cpu.setJob( (Job) level3.remove());
                    cpu.raiseBusyFlag();
                    cpu.setQuantumClock(8);
                }
                else if (!level4.isEmpty()) {
                    cpu.setJob( (Job) level4.remove());
                    cpu.raiseBusyFlag();
                    cpu.setQuantumClock(16);
                }
                
                else {}
                
    }
    
    /**
     *
     */
    public void decrementCurrentJobClock() {
        Job currentJob = cpu.getJob();
        currentJob.decrementJobClock();
        cpu.setJob(currentJob);
    }
    
    /**
     *
     */
    public void incrementAllWaitTimes() {
        ObjectQueue tempQ = new ObjectQueue();
        Job tempJ;
        
        while (!level1.isEmpty()) {
            tempJ = (Job) level1.remove();
            tempJ.incrementWaitTime();
            tempQ.insert(tempJ);
        }
        
        while(!tempQ.isEmpty()) {
            level1.insert(tempQ.remove());
        }
        
        while (!level2.isEmpty()) {
            tempJ = (Job) level2.remove();
            tempJ.incrementWaitTime();
            tempQ.insert(tempJ);
        }
        
        while(!tempQ.isEmpty()) {
            level2.insert(tempQ.remove());
        }
        
        while (!level3.isEmpty()) {
            tempJ = (Job) level3.remove();
            tempJ.incrementWaitTime();
            tempQ.insert(tempJ);
        }
        
        while(!tempQ.isEmpty()) {
            level3.insert(tempQ.remove());
        }
        
        while (!level4.isEmpty()) {
            tempJ = (Job) level4.remove();
            tempJ.incrementWaitTime();
            tempQ.insert(tempJ);
        }
        
        while(!tempQ.isEmpty()) {
            level4.insert(tempQ.remove());
        }
    }
    
    
}
